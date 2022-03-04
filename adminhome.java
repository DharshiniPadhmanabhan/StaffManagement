package com.example.staffmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class adminhome extends Activity implements OnClickListener{

	Button b1,b2,b3,b4,b5,b6,b7,b8;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminhome);
		
		b1=(Button)findViewById(R.id.ahplace);
		b1.setOnClickListener(this);
		
		b2=(Button)findViewById(R.id.ahview);
		b2.setOnClickListener(this);
		
		b3=(Button)findViewById(R.id.ahnear);
		b3.setOnClickListener(this);
		
		b4=(Button)findViewById(R.id.ahbooked);
		b4.setOnClickListener(this);
		
		b5=(Button)findViewById(R.id.ahsignout);
		b5.setOnClickListener(this);
		
		b6=(Button)findViewById(R.id.Button01);
		b6.setOnClickListener(this);
		
		b7=(Button)findViewById(R.id.Button02);
		b7.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
				
		if(v==b1)
		{
			Intent i=new Intent(adminhome.this,empregistration.class);				 
			startActivity(i);
		}
	
		if(v==b2)
		{
			Intent i=new Intent(adminhome.this,updateempregistration.class);				 
			startActivity(i);
		}
		
		if(v==b3)
		{
			Intent i=new Intent(adminhome.this,salaryentry.class);				 
			startActivity(i);
		}
		
		if(v==b4)
		{
			Intent i=new Intent(adminhome.this,Viewresign.class);				 
			startActivity(i);
		}
		
		if(v==b6)
		{
			Intent i=new Intent(adminhome.this,deleteresignation.class);				 
			startActivity(i);
		}
		
		if(v==b7)
		{
			Intent i=new Intent(adminhome.this,Viewemp.class);				 
			startActivity(i);
		}
		
		
		if(v==b5)
		{
			Intent i=new Intent(adminhome.this,Login.class);				 
			startActivity(i);
		}
	}

}
