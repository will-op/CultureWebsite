package com.xm.sbdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 接入微信公众平台
 * 接受参数
 * signature 签名
 * timestamp 时间戳
 * nonce     随机数
 * echostr   随机字符串
 * 验证原理：将token+timestamp+nonce三个参数进行字典序排序 而后进行sha-1加密
 * 再与signature比较确认是否微信请求 返回布尔值
 */
@Controller
@RequestMapping("/youare")
@CrossOrigin
public class WxPubController {

    private String TOKEN = "good";

    /**
     * @api {GET} /youare/beautiful 公众号对接
     * @apiVersion 0.0.1
     * @apiGroup WxPubController
     * @apiName wechatDocking
     * @apiDescription 公众号对接（需要上下文勿操作）
     * @apiParam (请求参数) {String} TOKEN
     * @apiParam (请求参数) {String} signature
     * @apiParam (请求参数) {String} timestamp
     * @apiParam (请求参数) {String} nonce
     * @apiParam (请求参数) {String} echostr
     * @apiParamExample 请求参数示例
     * TOKEN=good&signature=n6M3m&nonce=lITV2Lb7&echostr=ODf09N&timestamp=Rnzg
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * "fMv"
     */
//验证接口信息 签名/时间戳/随机数/随机字符串
    @ResponseBody
    @GetMapping("/beautiful")
    public String wechatDocking(@RequestParam("signature") String signature,
                                @RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("echostr") String echostr) {

        //排序
        String sortString = sort(TOKEN, timestamp, nonce);
        //加密
        String myString = sha1(sortString);
        //校验
        if (myString != null && myString != "" && myString.equals(signature)) {
            System.out.println("签名校验通过");
            //如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
            return echostr;
        } else {
            System.out.println("签名校验失败");
            return "";
        }
    }

    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));//上面是排序 输出看看
        StringBuilder sb = new StringBuilder();
        //遍历构成新数组
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    //MessageDigest提供信息摘要算法 调用sha-1算法
    private String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");//调用sha-1
            digest.update(str.getBytes());//将token+时间戳+随机数的字节数组去更新摘要
            byte messageDigest[] = digest.digest();//进行加密算法 并返回字节数组
            // Create Hex String
            StringBuffer hexString = new StringBuffer();//对字符串修改
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);//转化成十六进制
                if (shaHex.length() < 2) {
                    hexString.append(0);//补零
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
//            throw new BasicException(500,"youare/beautiful");
        }
        return "";
    }
}

