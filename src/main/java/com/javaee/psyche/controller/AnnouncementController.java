package com.javaee.psyche.controller;

import com.javaee.psyche.entity.Result;
import com.javaee.psyche.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(value = "/browseAnnouncements",method = RequestMethod.GET)
    public Result browseArticles(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

        return announcementService.findAll(pageNum, pageSize);
    }

    @RequestMapping(value = "/searchAnnouncements",method = RequestMethod.GET)
    public Result searchArticles(@RequestParam("title") String title, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

        return announcementService.findArticleByTitle(title,pageNum,pageSize);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result searchArticles(@PathVariable("id") int id){

        return announcementService.announcementDetail(id);

    }

}
