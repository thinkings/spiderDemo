package com.thinking.demo.spiderDemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURLClass {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.baidu.com/s?wd=qq");
			
			System.out.println("Authority: " + url.getAuthority());
			System.out.println("DefaultPort: " + url.getDefaultPort());
			System.out.println("File: " + url.getFile());
			System.out.println("Host: " + url.getHost());
			System.out.println("getPath: " + url.getPath());
			System.out.println("getPort: " + url.getPort());
			System.out.println("getProtocol: " + url.getProtocol());
			System.out.println("getQuery: " + url.getQuery());
			System.out.println("getRef: " + url.getRef());
			System.out.println("getUserInfo: " + url.getUserInfo());
			System.out.println("getContent: " + url.getContent());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
