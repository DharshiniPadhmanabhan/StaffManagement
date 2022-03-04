package com.example.staffmanagement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Login extends Activity implements OnClickListener {

	EditText t1,t2;
	Button login,cancel;
	SQLiteDatabase db;
	TextView newuser;
	Spinner s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		t1=(EditText)findViewById(R.id.luname);
		t2=(EditText)findViewById(R.id.lpassword);
		s1=(Spinner)findViewById(R.id.spinner1);
		login=(Button)findViewById(R.id.lsubmit);
		cancel=(Button)findViewById(R.id.lcancel);
		login.setOnClickListener(this);
		cancel.setOnClickListener(this);
		db=openOrCreateDatabase("auditing.db", MODE_PRIVATE, null); 
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==login)
		{
			if(t1.getText().toString().trim().length()==0 || t2.getText().toString().trim().length()==0)
			{
				show("Error","Fill all the values");
				clear();
			}
			
			else if(t1.getText().toString().equals("Admin") && t2.getText().toString().equals("1234") && s1.getSelectedItem().toString().equals("Admin"))
				{
					Intent i=new Intent(Login.this,adminhome.class);
					startActivity(i);
					
				}
			
			else if(s1.getSelectedItem().toString().equals("Employee")) 
			{
				Cursor c=db.rawQuery("SELECT * FROM employee WHERE eid='"+t1.getText()+"' and pass='"+t2.getText()+"'",null);
				
		if(c.moveToFirst())
				{
					Intent i=new Intent(Login.this,userhome.class);
					i.putExtra("uname", t1.getText().toString());
					startActivity(i);
					c.close();
					//db.close();
	
				}
				else
				{
					c.close();
					show("Error","Invalid Username & Password");
					
					clear();
				}
			}
			else
			{
				show("Error","Invalid Username & Password");
				
				clear();
			}

		}
		else if(v==cancel)
		{
			clear();
		}
		
		
	}
	private void clear() 
	{
		// TODO Auto-generated method stub
		t1.setText("");
		t2.setText("");
	}
	private void show(String title, String message) {
		// TODO Auto-generated method stub
	AlertDialog.Builder b=new AlertDialog.Builder(this);
	b.setTitle(title);
	b.setMessage(message);
	b.show();
	}

}
