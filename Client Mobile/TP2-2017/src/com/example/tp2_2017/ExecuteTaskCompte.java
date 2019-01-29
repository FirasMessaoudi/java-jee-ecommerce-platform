package com.example.tp2_2017;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

class ExecuteTaskCompte extends AsyncTask<String, Integer, String>  
{  

    @Override  
    protected String doInBackground(String... params) {  
          
        PostData(params);  
        return null;  
    }  
      
   /* @Override  
    protected void onPostExecute(String result) {  
    progressBar.setVisibility(View.GONE);  
    } */ 
      

  
 
  
public void PostData(String[] valuse) {  
    try  
    {  
    HttpClient httpClient=new DefaultHttpClient();  
    HttpPost httpPost=new HttpPost(  
    		"http://10.0.2.2:8083/RestWeb/Produits/addCompte");  
    ArrayList<NameValuePair> list=new ArrayList<NameValuePair>();  
    list.add(new BasicNameValuePair("login", valuse[0]));  
    list.add(new BasicNameValuePair("password",valuse[1])); 
    list.add(new BasicNameValuePair("c",valuse[2])); 
    httpPost.setEntity(new UrlEncodedFormEntity(list));  
    httpClient.execute(httpPost);  
    }  
    catch(Exception e)  
    {  
        System.out.println(e);  
    }  
      
}  
 
}  