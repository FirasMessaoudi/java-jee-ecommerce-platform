package com.example.tp2_2017;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class CheckOut extends Activity {
	ArrayList<ProdPanier> l=new ArrayList<ProdPanier>();
	EditText nom,login,pass,email,tel,adresse,modep;
	Button b;
	String  strJson="";
	String strJson1="";
	String strJson2="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finalisercommande);
		l=(ArrayList<ProdPanier>)getIntent().getSerializableExtra("l");
		b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				nom=(EditText)findViewById(R.id.editText1);
				login=(EditText)findViewById(R.id.editText2);
				pass=(EditText)findViewById(R.id.editText3);
				adresse=(EditText)findViewById(R.id.editText4);
				email=(EditText)findViewById(R.id.editText5);
				tel=(EditText)findViewById(R.id.editText6);
				modep=(EditText)findViewById(R.id.editText7);
				if(!verif(nom)||!verif(login)||!verif(pass)||!verif(email)||!verif(adresse)||!verif(tel)||!verif(modep)){
					Toast.makeText(CheckOut.this, "Vous devez remplir tous les champs", Toast.LENGTH_LONG).show();
				}
				else{
					String n,lg,p,ad,em,tl,mdp;
					n=nom.getText().toString();
					ad=adresse.getText().toString();
					em=email.getText().toString();
					tl=tel.getText().toString();
					lg=login.getText().toString();
					p=pass.getText().toString();
					mdp=modep.getText().toString();
					new ExecuteTask().execute(n,ad,em,tl);
					JSONParser1 j=new JSONParser1();
					
					j.execute(new String[] {"http://10.0.2.2:8083/RestWeb/Produits/maxidclient"});
					

					try{
						 strJson =	j.get();	


					}catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());	
					}
					
					//maxidclient
					 
					String str=strJson.substring(0, strJson.length()-1);
					new ExecuteTaskCompte().execute(lg,p,str);
					new ExecuteTaskCmd().execute(String.valueOf(new Date()),mdp,str);
					JSONParser1 j1=new JSONParser1();
					j1.execute(new String[] {"http://10.0.2.2:8083/RestWeb/Produits/maxidcmd"});
					try{
						 strJson1 =	j1.get();	


					}catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());	
					}
					//maxidcmd
					String str1=strJson1.substring(0, strJson1.length()-1);
										
					for(int i=0;i<l.size();i++){
						String np=l.get(i).getItem();
						Long id=l.get(i).getId();
			             
					
				
						
						new ExecuteTaskLc().execute(str1,String.valueOf(id),String.valueOf(l.get(i).getQte()),String.valueOf(l.get(i).getPrix()));
						Toast.makeText(CheckOut.this,"Votre commande a été enregistrer avec succes", Toast.LENGTH_LONG).show();
						l.clear();
						Intent ii=new Intent(CheckOut.this,LoginActivity.class);
						
						startActivity(ii);
						
					}
					
					
				}
				
				
			}
		});
		
		
		
	}
	public boolean verif(EditText txt){
		if(txt.getText().toString().equals(""))
			return false;
		else
			return true;
	}
}
