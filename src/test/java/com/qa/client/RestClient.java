package com.qa.client;

import netscape.javascript.JSObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;


import java.io.IOException;

public class RestClient {

    // 1 Get Method

    public  void get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new  HttpGet(url);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code: " + statusCode);

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UFT-8");
        //JSONObject jsonObject = new JSONObject(responseString);
    }
}
