package com.example.tp2_2017;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AfficherPanier extends Activity {
	TextView txtTot;
	Button bcmd,bretour;
	ArrayList<ProdPanier> l=new ArrayList<ProdPanier>();
	String strJson1="";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.afficherpanier);
		l=(ArrayList<ProdPanier>)getIntent().getSerializableExtra("l");
		String[] panier = new String[l.size()];
		double total=0;
		for(int i=0;i<l.size();i++){
			panier[i]=l.get(i).getItem()+"||"+String.valueOf(l.get(i).getPrix()*l.get(i).getQte())+"Dt||"+l.get(i).getQte()+" items";
		    total+=l.get(i).getPrix()*l.get(i).getQte();
		}
		txtTot=(TextView)findViewById(R.id.textView1);
		txtTot.setText("Total des achats = "+total+"Dt");
		 ArrayAdapter adapter = new ArrayAdapter<String>(AfficherPanier.this, 
		         R.layout.activity_listview,panier);
		 ListView mlistView = (ListView) findViewById(R.id.listView1);
	      mlistView.setAdapter(adapter);
	      //supprimer item
	      bretour=(Button)findViewById(R.id.button2);
	      bretour.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(AfficherPanier.this,Recherche.class);
				i.putExtra("l", l);
				startActivity(i);
				
			}
		});
	      bcmd=(Button)findViewById(R.id.button1);
	      bcmd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(LoginActivity.idclient==0){
					if(l.size()==0){
						Toast.makeText(AfficherPanier.this,"Votre panier est vide", Toast.LENGTH_LONG).show();	
					}
					else{
					Intent i=new Intent(getApplicationContext(),CheckOut.class);
					i.putExtra("l", l);
					startActivity(i);
					}
		            
				}
				else{
					
					
					if(l.size()==0){
						Toast.makeText(AfficherPanier.this,"Votre panier est vide", Toast.LENGTH_LONG).show();	
					}
					else{
					new ExecuteTaskCmd().execute(String.valueOf(new Date()),"",String.valueOf(LoginActivity.idclient));
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
						Toast.makeText(AfficherPanier.this,"Votre commande a été enregistrer avec succes", Toast.LENGTH_LONG).show();
						l.clear();
						Intent ii=new Intent(AfficherPanier.this,LoginActivity.class);
						
						startActivity(ii);
						
					}
					}
					
		            

                    
				}
			}
		});

	}
}
