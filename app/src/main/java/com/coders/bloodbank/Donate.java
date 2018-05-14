package com.coders.bloodbank;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Donate extends Activity {
    private static final String TAG = "hi";
    //TextView a,b;
 EditText s,a,m;
 Button b;
 SQLiteDatabase db;
 Spinner dropdown;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);
		//a=(TextView) findViewById(R.id.textView1);
		//b=(TextView) findViewById(R.id.textView2);
		
		b=(Button) findViewById(R.id.button1);
		dropdown = (Spinner)findViewById(R.id.spinner1);
		try{
	           
            db=openOrCreateDatabase("bloodbank",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            
        }catch(SQLException e)
        {
            Log.d("Error","Error while Opening Database");
            e.printStackTrace();
        }
		
		db.execSQL("create table if not exists bank(name varchar,address varchar,phone varchar,bgroup varchar)");
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String group=dropdown.getSelectedItem().toString();
				s=(EditText) findViewById(R.id.editText1);
				a=(EditText) findViewById(R.id.editText2);
				m=(EditText) findViewById(R.id.editText3);
				String name=s.getText().toString();
				String address=a.getText().toString();
				String contact=m.getText().toString();
				db.execSQL("insert into bank values('"+name+"','"+address+"','"+contact+"','"+group+"')");
				
				Toast.makeText(Donate.this, "registered successfully.", Toast.LENGTH_LONG).show();

				Intent in=new Intent(getApplicationContext(),List.class);
                in.putExtra(TAG,group);
                startActivity(in);
			}
		});
	}
}
