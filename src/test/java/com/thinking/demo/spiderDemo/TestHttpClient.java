package com.thinking.demo.spiderDemo;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestHttpClient {
	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			
			Header[] headers = response.getAllHeaders();
			
			for(Header header : headers) {
				System.out.println(header.getName() + ":" + header.getValue());
			}
			
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getProtocolVersion());
			
			HttpEntity httpEntity = response.getEntity();
			System.out.println(httpEntity.isStreaming());
			
			byte[] body = EntityUtils.toByteArray(httpEntity);
			
			String bodyStr = new String(body);
			System.out.println(bodyStr);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(response != null) response.close();
				if(httpclient != null) httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
