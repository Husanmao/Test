package com.colin.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * java向指定的url发送get或者post请求，并接受 返回的数据
 * @author Colin
 * @date 2015年5月14日下午8:54:59
 */
public class HttpRequest {
	
	/**
	 * 向指定的url发送get方法的请求
	 * @param url
	 * @param param
	 * @return	
	 */
	public static String sendGet(String url,String param)
	{
		String result = "";
		BufferedReader in = null;
		try{
			String urlName = url + "?" + param;
			URL realUrl = new URL(urlName);	//使用指定的url初始化一个URL
			URLConnection connection = realUrl.openConnection();	//打开一个url连接并返回
			//设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection","Keep-Alive");
			connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//建立实际的连接
			connection.connect();
			//获取所有的响应头字段
			Map<String,List<String>> map = connection.getHeaderFields();
			for(String key:map.keySet())
			{
				System.out.println(key + "---->"+map.get(key));
			}
			//定义一个BufferedReader输入流来读取url中的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line = "";
			while((line=in.readLine()) != null)
			{
				result += line;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(in != null)
				{
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}	
	
	public static String sendPose(String url,String param)
	{
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try{
			URL realUrl = new URL(url);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept","/");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent","MOzilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			out = new PrintWriter(connection.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line=in.readLine()) != null)
			{
				result += line;
			}
		}catch(Exception e){
			System.out.println(("发送post请求出现异常!"+e));
			e.printStackTrace();
		}finally{
			try{
				if(null != out)
				{
					out.close();
				}
				if(null != in)
				{
					in.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
