package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByTeacherId(int teacherId);
    Optional<Reservation> findByTeacherIdAndAndTimePeriodAndDay(int teacherId,int period,int day);
    List<Reservation> findByStudentId(int studentId);
    Reservation findById(int id);
}
