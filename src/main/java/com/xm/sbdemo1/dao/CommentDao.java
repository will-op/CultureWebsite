package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    int addComment(Comment comment);

    List<Comment> commentShow(@Param("courseid") Long courseid);
}
