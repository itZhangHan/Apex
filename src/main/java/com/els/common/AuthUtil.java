package com.els.common;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;;

public class AuthUtil {

    public static final String APPID = "wx90b984cfe6134b69";
    public static final String APPSECRET = "e5b80c04a9d82905091235ad1e3928b1";

    /**
     * send http request and convert resposne into json object
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity !=null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
            jsonObject = JSONObject.fromObject(result);
        }
        return jsonObject;
    }
}
