package com.thinking.demo.spiderDemo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ClientWithResponseHandlerTest {
	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com/s?ie=utf-8&wd=为什么学习");
		
		 System.out.println("Executing request " + httpGet.getRequestLine());
		 
		 ResponseHandler<String> handler = new ResponseHandler<String>() {
			
			public String handleResponse(final HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if(status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					if(entity != null) {
						return EntityUtils.toString(entity, "utf-8");
					}
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
				return null;
			}
		};
		
		try {
			String responseBody = httpClient.execute(httpGet, handler);
			System.out.println("--------------------------------------------------------");
			//System.out.println(responseBody);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(httpClient != null)
					httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
