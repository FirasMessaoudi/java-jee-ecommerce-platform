package com.example.tp2_2017;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

public class PostTask extends AsyncTask<String, String, String> {
@Override
protected String doInBackground(String... data) {
// Create a new HttpClient and Post Header
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("localhost:8083/Produits/addClient");
try {
//add data
ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
nameValuePairs.add(new BasicNameValuePair("clé", "valeur"));
nameValuePairs.add(new BasicNameValuePair("clé", "valeur"));
nameValuePairs.add(new BasicNameValuePair("clé", "valeur"));
nameValuePairs.add(new BasicNameValuePair("clé", "valeur"));

httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//execute http post
HttpResponse response = httpclient.execute(httppost);
HttpEntity resEntity = response.getEntity();
final String response_str = EntityUtils.toString(resEntity);
return response.getEntity().getContent().toString();
} catch (ClientProtocolException e) {
} catch (IOException e) {
}
return null;
}
}