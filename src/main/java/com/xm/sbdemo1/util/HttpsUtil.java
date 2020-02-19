package com.xm.sbdemo1.util;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 微信操作的工具类 网上来源
 */

public class HttpsUtil {

    /**
     * 以https方式发送请求并将请求响应内容以String方式返回
     *
     * @param path   请求路径
     * @param method 请求方法
     * @param body   请求数据体
     * @return 请求响应内容转换成字符串信息
     */
    public static String httpsRequestToString(String path, String method, String body) {
        if (path == null || method == null) {
            return null;
        }

        //初始化操作
        String response = null;
        InputStream inputStream = null;//这是一个IO流 字节输入流
        InputStreamReader inputStreamReader = null;//字节输入流的转换流
        BufferedReader bufferedReader = null;//缓冲读取字符流
        HttpsURLConnection conn = null;
        try {
            //创建SSLConrext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new JEEWeiXinX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());

            //从上述对象中的到SSLSocketFactory
            SSLSocketFactory ssf = sslContext.getSocketFactory();

//            System.out.println(path);

            URL url = new URL(path);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            //设置请求方式（get|post）
            conn.setRequestMethod(method);
//            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");

            //有数据提交时  当body不为null时向输出流写数据
            if (null != body) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(body.getBytes("UTF-8"));
                outputStream.close();
            }

            //将返回的输入流转换成字符串
            inputStream = conn.getInputStream();
            //注意编码格式
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
//
//            response = buffer.toString();
//        } catch (Exception e) {
//
//        } finally {
//            if (conn != null) {
//                conn.disconnect();
//            }
//            try {
//                //释放资源
//                bufferedReader.close();
//                inputStreamReader.close();
//                inputStream.close();
//            } catch (IOException execption) {
//
//            }
//        }
//        return response;
//    }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


class JEEWeiXinX509TrustManager implements X509TrustManager {

    //检查客户端证书
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    //检查服务器端证书
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }

    //返回受信任的X509证书数组
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
