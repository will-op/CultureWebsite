package com.xm.sbdemo1.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.dao.CommentDao;
import com.xm.sbdemo1.pojo.Comment;
import com.xm.sbdemo1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean addComment(Comment comment) {
        comment.setAnswertime(new Date());
        return commentDao.addComment(comment) == 1;
    }

    @Override
    public PageInfo<Comment> commentShow(int currentPage, int pageSize, Long courseid) {

        PageHelper.startPage(currentPage, pageSize);
        List<Comment> comments = commentDao.commentShow(courseid);
        PageInfo<Comment> commentPageInfo = new PageInfo<>(comments);
        return commentPageInfo;
    }
}
