package com.javaee.psyche.service;

import com.javaee.psyche.dao.AnnouncementDao;
import com.javaee.psyche.entity.Announcement;
import com.javaee.psyche.Util.Result;
import com.javaee.psyche.Util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("AnnouncementService")
public class AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    public Result findArticleByTitle(String title, int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        Page<Announcement>announcements = announcementDao.findByTitleLike("%"+title+"%",pageable);

        if(announcements!=null) {
            return ResultUtil.success(announcements);
        }else {
            return ResultUtil.noRecord();
        }
    }

    public Result findAll(int pageNum, int pageSize){


        Pageable pageable = PageRequest.of(pageNum-1, pageSize,Sort.Direction.DESC,"id");
        Page<Announcement>announcements =announcementDao.findAll(pageable);

        if(announcements!=null) {
            return ResultUtil.success(announcements);
        }else {
            return ResultUtil.noRecord();
        }

    }

    public Result announcementDetail(int id){
        Announcement announcement = announcementDao.findById(id);

        if(announcement!=null) {
            return ResultUtil.success(announcement);
        }else {
            return ResultUtil.noRecord();
        }
    }
}
