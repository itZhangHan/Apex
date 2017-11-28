package com.els.getSign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/weixin")
public class GetSign {

	@RequestMapping(value="/getSign")
	@ResponseBody
	public static Map<String, String> sign(String jsapi_ticket, String url) {
		jsapi_ticket = GetTicket.getTicket(GetAccess_token.getAccess_token());
		url = "http://thdd.apexgame.cn/tetris/skip/index0send";
        Map<String, String> ret = new HashMap<String, String>();
        //获取随机字符串
        String nonce_str = create_nonce_str();
        System.out.println("获取的随机字符串为："+nonce_str);
        //获取时间戳
        String timestamp = create_timestamp();
        System.out.println("获取的时间戳为："+timestamp);
        String string1;
        //最后签名
        String signature = "";

        //设置参数有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        System.out.println(string1);

        //将签名进行SHA-1算法加密
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
            System.out.println("获取到的最后签名："+signature);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        System.out.println("最后得到的签名为："+ret.toString());
        String string = ret.get("url");
        System.out.println("获取的路径"+string);
        return ret;
    }

	//获取微信签名模块中的辅助函数
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
