package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.ReservationDao;
import cn.psyche.javaee.dao.TeacherDao;
import cn.psyche.javaee.entity.Reservation;
import cn.psyche.javaee.entity.Teacher;
import cn.psyche.javaee.util.ConstantUtils;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultEnum;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("reserveService")
public class ReserveService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private ReservationDao reservationDao;
    private static long teacherPgCount=-1;

    //get teacherList by page
    @Cacheable(value="teachers")
    public Map<String,Object> getTeachers(int page){
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Page<Teacher> pg=teacherDao.findAll(PageRequest.of(page, ConstantUtils.TEACHER_PAGE_SIZE,sort));
        List<Teacher> teachers=pg.getContent();
        if(teacherPgCount==-1){
            refreshTeacherPg();
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("current",page);
        map.put("total",teacherPgCount);
        map.put("teacher",teachers);

        return map;
    }

    //get reservation table of certain teacher
    @Cacheable(value="schedule")
    public Result getReservationTable(int teacherId){
        Optional<Teacher> optional=teacherDao.findById(teacherId);
        if(optional.isPresent()==false){
            return ResultUtil.error(ResultEnum.NOT_FOUND);
        }
        List<Reservation> reservations=reservationDao.findByTeacherId(teacherId);
        return ResultUtil.success(reservations);
    }

    //reserve
    @CacheEvict(value={"schedule","myReservation"},allEntries = true)
    public Result reserveTeacher(int teacher,int student,int day,int period){
        Optional<Reservation> optional=reservationDao.findByTeacherIdAndAndTimePeriodAndDay(teacher,period,day);
        //have been occupied
        if(optional.isPresent()==true){
            return ResultUtil.error(ResultEnum.HAVE_OCCUPIED);
        }
        //invalid time
        if(day>6||day<1||period>4||period<1){
            return ResultUtil.error(ResultEnum.FAIL);
        }
        //save and flush
        Reservation reservation=new Reservation();
        Calendar calendar=Calendar.getInstance();
        reservation.setDate(calendar.getTime());
        reservation.setStudentId(student);
        reservation.setTeacherId(teacher);
        reservation.setTimePeriod(period);
        reservation.setDay(day);
        reservationDao.saveAndFlush(reservation);
        return ResultUtil.success();
    }

    //cancel
    @CacheEvict(value={"schedule","myReservation"},allEntries = true)
    public Result cancelReservation(int id){
        Reservation reservation=reservationDao.findById(id);
        if(reservation==null){
            return ResultUtil.error(ResultEnum.NOT_FOUND);
        }
        reservationDao.deleteById(id);
        return ResultUtil.success();
    }

    //check my reservation
    @Cacheable(value = "myReservation")
    public Result myReservation(int studentId){
        List<Reservation> reservations=reservationDao.findByStudentId(studentId);
        return ResultUtil.success(reservations);
    }

    //refresh page count of teacher list
    public void refreshTeacherPg() {
        teacherPgCount = teacherDao.count() / ConstantUtils.TREEHOLE_PAGE_SIZE;
        if (teacherDao.count() % ConstantUtils.TEACHER_PAGE_SIZE == 0) {
            teacherPgCount -= 1;
        }
    }
}
