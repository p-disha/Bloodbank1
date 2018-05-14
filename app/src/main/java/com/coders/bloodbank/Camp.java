package com.coders.bloodbank;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Camp extends Activity {
	SQLiteDatabase db;
	EditText s,a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camp);
		/*Button b=(Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("bloodbank",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		db.execSQL("create table if not exists camp(name varchar,address varchar,date varchar)");
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				s=(EditText) findViewById(R.id.editText1);
				a=(EditText) findViewById(R.id.editText2);
				String name=s.getText().toString();
				String address=a.getText().toString();
				DatePicker d=(DatePicker)findViewById(R.id.datePicker1);
				int day=d.getDayOfMonth();
				int month=d.getMonth();
				int year=d.getYear();
				String sa=Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
                 db.execSQL("insert into camp values('"+name+"','"+address+"','"+sa+"')");
				Toast.makeText(Camp.this, "registered successfully.", Toast.LENGTH_LONG).show();
				Intent in=new Intent(getApplicationContext(),Camptwo.class);
				startActivity(in);
			}
		});*/
	}
}
