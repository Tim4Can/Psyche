package com.javaee.psyche.dao;

import com.javaee.psyche.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("AnnouncementDao")
public interface AnnouncementDao extends JpaRepository<Announcement,Integer>, JpaSpecificationExecutor {

    Announcement findById(int id);

    Page<Announcement> findByTitleLike(String title, Pageable pageable);

    Page<Announcement> findAll(Pageable pageable);

}