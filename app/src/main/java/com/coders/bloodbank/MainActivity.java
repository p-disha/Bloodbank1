package com.coders.bloodbank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
ImageView imageView1;
ImageView imageView2;
ImageView imageView3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView1=(ImageView)findViewById(R.id.imageView1);
		imageView2=(ImageView)findViewById(R.id.imageView2);
		imageView3=(ImageView)findViewById(R.id.imageView3);
		imageView1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
	            vb.vibrate(100);
				Toast.makeText(getApplicationContext(), "Enter your details",2).show();
				Intent in=new Intent(getApplicationContext(),Donate.class);
				startActivity(in);
			}
		} );
imageView2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
	            vb.vibrate(100);
				Toast.makeText(getApplicationContext(), "Enter your details",2).show();
				Intent in=new Intent(getApplicationContext(),Emergency.class);
				startActivity(in);
			}
		} );
imageView3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(100);
		Toast.makeText(getApplicationContext(), "Enter your details",2).show();
		Intent in=new Intent(getApplicationContext(),Camp.class);
		startActivity(in);
	}
} );


	}
}
