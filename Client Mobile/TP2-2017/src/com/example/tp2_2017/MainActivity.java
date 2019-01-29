package com.example.tp2_2017;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class MainActivity extends ActionBarActivity {


	
	ArrayList<Produit> ListP = new ArrayList<Produit>();
	ArrayList<ProdPanier> l=new ArrayList<ProdPanier>();
	
	EditText input,mc;
	Button bmc,bcmd;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bcmd=(Button)findViewById(R.id.btnretour);
	    bcmd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	            Intent i=new Intent(getApplicationContext(),AfficherPanier.class);
				i.putExtra("l", l);
				startActivity(i);

				
			}
		});		
		l=(ArrayList<ProdPanier>)getIntent().getSerializableExtra("l");
		String choix=(String) (getIntent().getSerializableExtra("choix"));
		String url;
		if(choix.equals("tous"))
			url="http://10.0.2.2:8083/RestWeb/Produits/prod";
		else{
			String mc=(String)getIntent().getSerializableExtra("mc");
			url="http://10.0.2.2:8083/RestWeb/Produits/produitParMc/"+mc;
		}
		JSONParser1 j=new JSONParser1();
		
		j.execute(new String[] {url});
		
		
		String strJson="";
		try{
			 strJson =	j.get();	
			 
			 

	
		}catch (Exception e) {
			// TODO: handle exception
		}
	     	   
	      try {
	         //JSONObject  jsonRootObject = new JSONObject(strJson);
	         
	         //Get the instance of JSONArray that contains JSONObjects
	    	 JSONArray jsonArray = new JSONArray(strJson);
	         
	         //Iterate the jsonArray and print the info of JSONObjects
	         for(int i=0; i < jsonArray.length(); i++){
	    	  JSONObject  jsonObject = jsonArray.getJSONObject(i);
	            
	            long id = Long.parseLong(jsonObject.optString("idProduit").toString());
	            String designation = jsonObject.optString("designation").toString();
	            String description= jsonObject.optString("description").toString();
	            double prix= Double.parseDouble(jsonObject.optString("prix").toString());
	            int qtite = Integer.parseInt(jsonObject.optString("quantite").toString());
	            
	            Produit p= new Produit(id, designation, description, prix, qtite);
	            
	            ListP.add(p);	            
	           
	       } // end for
	      } catch (JSONException e) {e.printStackTrace();}
		
	
		
		
		String[] ProduitArray = new String [ListP.size()];
		
		
		for(int i=0;i<ListP.size();i++)
			
		{
			//if(ListP.get(i).ge)
			
			ProduitArray[i]=ListP.get(i).getId()+")"+ListP.get(i).getDesignation()+": "+ListP.get(i).getPrix()+"Dt :"+ListP.get(i).getQuantité()+" items available";
			
			
		}
		
		 ArrayAdapter adapter = new ArrayAdapter<String>(this, 
		         R.layout.activity_listview,ProduitArray );
		      
		      ListView mlistView = (ListView) findViewById(R.id.mobile_list);
		      mlistView.setAdapter(adapter);
		      
		      mlistView.setOnItemClickListener(new OnItemClickListener() {
		    	  

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					
					  String stringText;

			            //in normal case
			            stringText=((TextView)view) .getText().toString();  
			            String idpr=stringText.substring(0, stringText.indexOf(")"));
			            String url1="http://10.0.2.2:8083/RestWeb/Produits/getProduit/"+idpr;
			            //Toast.makeText(MainActivity.this, nom, Toast.LENGTH_LONG).show();
			            
			            JSONParser1 j1=new JSONParser1();
			    		
			    		j1.execute(new String[] {url1});
			    		
			    		
			    		String strJson="";
			    		try{
			    			 strJson =	j1.get();	
			    			 
			    			 

			    	
			    		}catch (Exception e) {
			    			// TODO: handle exception
			    		}
			    		try{
			    			//JSONArray jsonArray = new JSONArray(strJson);
			    			JSONObject  jsonObject = new JSONObject(strJson);
			    			
			    			 long idp = Long.parseLong(jsonObject.optString("idProduit").toString());
			 	            String designation = jsonObject.optString("designation").toString();
			 	            String description= jsonObject.optString("description").toString();
			 	            double prix= Double.parseDouble(jsonObject.optString("prix").toString());
			 	            int qtite = Integer.parseInt(jsonObject.optString("quantite").toString());
			 	           YesNoDialogue(idp,designation,prix,qtite);
				            //Toast.makeText(MainActivity.this, String.valueOf(idp), Toast.LENGTH_LONG).show();

			    		}catch(Exception e){
			    			e.printStackTrace();
			    		
			    		}
			            
			            
			            
			           // Log.v("ArrayList", Panier.toString());
					
				}
			});
		      
		      
		      bmc=(Button)findViewById(R.id.btntous);
		      bmc.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(getApplicationContext(),Recherche.class);
					i.putExtra("l", l);
					startActivity(i);
					
				}
			});
		      
		      
		      
		      
		      
	}

	
	public void YesNoDialogue(final Long id,final String titre,final double prix, final int qte)
	{
		//l=(ArrayList<ProdPanier>)getIntent().getSerializableExtra("l");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

		builder.setTitle("Voulez vous ajouter ce produit au panier ?");
		//builder.setMessage("Are you sure?");

		builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
        
		    public void onClick(DialogInterface dialog, int which) {
		        // Do nothing but close the dialog

		    	
		    	AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

				builder1.setTitle("Saisir la quantitée");
				builder1.setMessage("Quantité");
		    	
				input=new EditText(MainActivity.this);
				input.setInputType(InputType.TYPE_CLASS_NUMBER);
				builder1.setView(input);
				builder1.setPositiveButton("Ajouter au panier", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						String qt=input.getText().toString();
						if(qt.equals("")){
				            Toast.makeText(MainActivity.this, "vous devez indiquer la quantité ", Toast.LENGTH_LONG).show();

						}
						else{
						int q=Integer.parseInt(qt);
						if(q>qte || q<=0)
				            Toast.makeText(MainActivity.this, "Quantité indisponible", Toast.LENGTH_LONG).show();
						else{
							ProdPanier pr = new ProdPanier(id,titre, prix, q);
							if (!Recherche.exist(l, pr)){
							l.add(pr);
				            Toast.makeText(MainActivity.this, "ce produit a été ajouté dans le panier ", Toast.LENGTH_LONG).show();
							}
							else{
								l.get(Recherche.findByItem(pr.getItem(), l)).setQte(q);
							}
						}

						
					}
					}
				});
				
				
				
				builder1.setNegativeButton("Retour", new DialogInterface.OnClickListener() {

				    @Override
				    public void onClick(DialogInterface dialog, int which) {

				        // Do nothing
				        dialog.dismiss();
				    }
				});
				
				
				
				
				
				
				  AlertDialog ad=builder1.create();
				  ad.show();
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Panier.add(titre);
		    }
		});
     
		builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) {

		        // Do nothing
		        dialog.dismiss();
		    }
		});
		
		
		builder.setNeutralButton("Google it", new DialogInterface.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) {

		        // Do nothing
		    	Uri uri = Uri.parse("https://www.google.com/search?q="+titre);
		    	Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);
		    	startActivity(gSearchIntent);
		    }
		});
		

		AlertDialog alert = builder.create();
		alert.show();		
		
	}
	
	
}
