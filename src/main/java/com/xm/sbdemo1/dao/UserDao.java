package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.pojo.UserCollect;
import com.xm.sbdemo1.pojo.UserSignIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 用户相关操作的数据库接口
 */

@Repository
@Mapper
public interface UserDao {

    User existswxid(@Param("wxid") String wxid);

    int regist(@Param("userid") Long userid, @Param("wxid") String wxid, @Param("wxnickname") String wxnickname, @Param("sex") String sex);

    int coursecollect(@Param("courseid") Long courseid, @Param("userid") Long userid);

    List<UserCollect> queryCollects(@Param("userid") Long userid);

    int signin(@Param("userid") Long userid, @Param("signdate") Date signdate, @Param("continuedays") Integer continuedays, @Param("award") Integer award, @Param("awardtype") String awardtype, @Param("finalaward") Integer finalaward);

    User queryByUserid(@Param("userid") Long userid);

    UserSignIn querySignDate(@Param("userid") Long userid, @Param("awardtype") String awardtype);

    int addscore(@Param("score") Integer score, @Param("userid") Long userid);


}
