package com.example.tp2_2017;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

class ExecuteTaskLc extends AsyncTask<String, Integer, String>  
{  

    @Override  
    protected String doInBackground(String... params) {  
          
        PostData(params);  
        return null;  
    }  
      
  
public void PostData(String[] valuse) {  
    try  
    {  
    HttpClient httpClient=new DefaultHttpClient();  
    HttpPost httpPost=new HttpPost(  
    		"http://10.0.2.2:8083/RestWeb/Produits/addLc");  
    ArrayList<NameValuePair> list=new ArrayList<NameValuePair>();  
    list.add(new BasicNameValuePair("IdComm", valuse[0]));  
    list.add(new BasicNameValuePair("idProduit",valuse[1])); 
    list.add(new BasicNameValuePair("quantite",valuse[2]));
    list.add(new BasicNameValuePair("prix",valuse[3]));
    httpPost.setEntity(new UrlEncodedFormEntity(list));  
    httpClient.execute(httpPost);  
    }  
    catch(Exception e)  
    {  
        System.out.println(e);  
    }  
      
}  
 
}  