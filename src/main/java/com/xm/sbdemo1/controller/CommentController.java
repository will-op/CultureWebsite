package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.constant.StatusCodeContent;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Comment;
import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.service.CommentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;


    /**
     * @api {POST} /comment/addcomment 用户评论
     * @apiVersion 0.0.1
     * @apiGroup UserController
     * @apiName addcomment
     * @apiDescription 用户评论
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "courseid":1
     * "ccomment":"好帅"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "addFlag": "评论成功"
     * }
     */
    @RequestMapping("/addcomment")
    public JSONObject addcomment(@RequestBody JSONObject object) {

        HashMap map = new HashMap();
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        Comment comment = object.toJavaObject(Comment.class);
        comment.setUserid(user.getUserid());
        boolean addFlag = commentService.addComment(comment);

        if (addFlag) {
//            map.put("addFlag", StatusCodeContent.COMMENT_ADDSUCCESS);
//            return new JSONObject(map);
            return Result.success(StatusCodeContent.COMMENT_ADDSUCCESS);
        }

//        map.put("addFlag",StatusCodeContent.COMMENT_ADDFAILURE);
//        return new JSONObject(map);
        throw new BasicException("/comment/addcomment", StatusCodeContent.COMMENT_ADDFAILURE);
    }

    @RequestMapping("/commentShow/{courseid}")
    public JSONObject commentShow(@PathVariable("courseid") Long courseid,
                                  @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "1") int pageSize
    ) {

//        HashMap<String,Object> map = new HashMap<>();

        //评论分页
        PageInfo<Comment> comments = commentService.commentShow(currentPage, pageSize, courseid);

//        map.put("comments",comments);
        return Result.success(comments);
    }
}
