package com.coders.bloodbank;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class List extends ListActivity {
    private static final String TAG = "hi";
    SQLiteDatabase db;
    private ArrayList<String> results = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_list);
        Intent in=getIntent();
        String gr=in.getStringExtra(TAG);
        Toast.makeText(List.this,"showing people with "+gr+" blood group",Toast.LENGTH_SHORT).show();
        try{

            db=openOrCreateDatabase("bloodbank",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        }catch(SQLException e)
        {
            Log.d("Error", "Error while Opening Database");
            e.printStackTrace();
        }
        try {

            Cursor c = db.rawQuery("SELECT* FROM bank", null);

            if (c != null ) {
                if  (c.moveToFirst()) {
                    do {
                        String Name = c.getString(c.getColumnIndex("name"));
                        String address = c.getString(c.getColumnIndex("address"));
                        String phone = c.getString(c.getColumnIndex("phone"));
                        String group = c.getString(c.getColumnIndex("bgroup"));
                        if(c.getString(c.getColumnIndex("bgroup")).equals(gr))
                        {
                        results.add("Name: " + Name + "" +
                                    "Address : " + address+
                                    "Phone: " +phone+
                                    "Group: ");}
                    }while (c.moveToNext());
                }
            }
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        }

        TextView tView = new TextView(this);
        getListView().addHeaderView(tView);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, results));
        getListView().setTextFilterEnabled(true);
       // ListAdapter adapter = new SimpleAdapter(List.this, results,R.layout.activity_list, new String[] { TAG_EMAIL, TAG_NAME}, new int[] {
            //    R.id.name,R.id.email});

       // setListAdapter(adapter);
    }



}
