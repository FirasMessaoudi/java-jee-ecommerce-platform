package com.example.tp2_2017;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Recherche extends Activity{
	ArrayList<ProdPanier> l=new ArrayList<ProdPanier>();
	Button b1,b2;
	EditText mc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choix_recherche);
		b1=(Button)findViewById(R.id.btntous);
		b2=(Button)findViewById(R.id.btnmotcle);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Recherche.this,MainActivity.class);
				i.putExtra("l", l);
				i.putExtra("choix", "tous");
				startActivity(i);
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mc=(EditText)findViewById(R.id.editText1);
				String mot=mc.getText().toString();
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				i.putExtra("mc", mot);
				i.putExtra("choix", "motcle");
				i.putExtra("l", l);
				startActivity(i);
				
				
		
				
				
				
			}
		});
		
	}
	public static boolean exist(ArrayList<ProdPanier> l ,ProdPanier p){
		Boolean trouve=false;
		int i=0;
		while(i<l.size() && !trouve){
			if(l.get(i).getItem().equals(p.getItem()))
				trouve=true;
			else
				i++;
		}
		return trouve;
	}
	public static int findByItem(String item,ArrayList<ProdPanier> l){
		//ProdPanier p;
		
		boolean ok=false;
		int i=0;
		while(i<l.size() && !ok){
			if(l.get(i).getItem().equals(item))
				ok=true;
			else
				i++;
		}
		return i;
	}
	

}
