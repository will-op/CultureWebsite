package com.xm.sbdemo1.service;

import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.pojo.Comment;

public interface CommentService {

    boolean addComment(Comment comment);

    PageInfo<Comment> commentShow(int currentPage, int pageSize, Long courseid);
}
