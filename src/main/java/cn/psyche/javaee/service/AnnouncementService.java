package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.AnnouncementDao;
import cn.psyche.javaee.entity.Announcement;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("AnnouncementService")
public class AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    @Cacheable(value="findNotification")
    public Result findArticleByTitle(String title, int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        Page<Announcement>announcements = announcementDao.findByTitleLike("%"+title+"%",pageable);

        if(announcements!=null) {
            return ResultUtil.success(announcements);
        }else {
            return ResultUtil.noRecord();
        }
    }

    @Cacheable(value="findAllNotification")
    public Result findAll(int pageNum, int pageSize){


        Pageable pageable = PageRequest.of(pageNum-1, pageSize,Sort.Direction.DESC,"id");
        Page<Announcement>announcements =announcementDao.findAll(pageable);

        if(announcements!=null) {
            return ResultUtil.success(announcements);
        }else {
            return ResultUtil.noRecord();
        }

    }

    @Cacheable(value="notificationDetail")
    public Result announcementDetail(int id){
        Announcement announcement = announcementDao.findById(id);

        if(announcement!=null) {
            return ResultUtil.success(announcement);
        }else {
            return ResultUtil.noRecord();
        }
    }
}
