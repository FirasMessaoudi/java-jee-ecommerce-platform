package com.example.tp2_2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class LoginActivity extends Activity {
	String strJson;
	EditText user;
	EditText pass;
	Button b,bv;
	public static Long idclient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
idclient =new Long(0);
b=(Button)findViewById(R.id.btnretour);
bv=(Button)findViewById(R.id.btncmd);
	b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			user=(EditText)findViewById(R.id.editText1);
			pass=(EditText)findViewById(R.id.editText2);
			
			JSONParser1 j=new JSONParser1();	
			final String l=user.getText().toString();
			final String p=pass.getText().toString();
			j.execute(new String[] {"http://10.0.2.2:8083/RestWeb/Produits/checkIdCompte/"+l+"/"+p});
			 
			try{
				 strJson =	j.get();	


			}catch (Exception e) {
				// TODO: handle exception
			}
			String str=strJson.substring(0, strJson.length()-1);
			if(str.equals("0")){
				
				Toast.makeText(LoginActivity.this,"Verifier vos données", Toast.LENGTH_LONG).show();	

			}
			else{
				idclient=Long.parseLong(str);
				Toast.makeText(LoginActivity.this,"Welcome "+user.getText().toString(), Toast.LENGTH_LONG).show();	

				Intent i=new Intent(getApplicationContext(),Recherche.class);
				i.putExtra("client", idclient);
				startActivity(i);
				
			}
			
			
		}
	});	
	bv.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),Recherche.class);
			//i.putExtra("client", idclient);
			startActivity(i);
			
		}
	});
		
	}
}
