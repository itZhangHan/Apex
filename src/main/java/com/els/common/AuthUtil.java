package com.els.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.els.bean.JhddUsers;

import net.sf.json.JSONObject;;

public class AuthUtil {

    public static final String APPID = "wx90b984cfe6134b69";
    public static final String APPSECRET = "e5b80c04a9d82905091235ad1e3928b1";
    public static final Map<String,String> topName=new HashMap();
    
    static {
    	topName.put("first", "firstsend");
    }
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
    public static String getMsg(JhddUsers jhddUser,String topName){
    	String nickname="";
    	String city="";
    	String headimgurl="";
    	Integer sex=0;
    		try {
    			nickname=new String(new String(jhddUser.getUsername()).getBytes("UTF-8"),"ISO8859-1");
    			city=new String(new String(jhddUser.getCity()).getBytes("UTF-8"),"ISO8859-1");
    			headimgurl=new String(new String(jhddUser.getUserportrait()).getBytes("UTF-8"),"ISO8859-1");
    			sex=jhddUser.getUsersex();
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}    	
    	String topStr=getTopName(topName);
    	String urlName= "nickname="+ nickname+"&sex="+sex+"&headimgurl="+headimgurl +"&city="+city;
    	if(topStr!=null && !"".equals(topStr)){
    		return "redirect:/skip/"+ topStr+urlName;
    		
    	}
    	return "first";
    	
    }
    
    public static String getTopName(String topName){
    	if(topName!=null && !"".equals(topName)){
    		if(topName.contains("/")){
    			String[] split = topName.split("/");
    			String topStr=split[split.length-1];
    			if(AuthUtil.topName.get(topStr)!=null){
    				return AuthUtil.topName.get(topStr);
    			}
    		}
    	}
       return null;
    }
}
