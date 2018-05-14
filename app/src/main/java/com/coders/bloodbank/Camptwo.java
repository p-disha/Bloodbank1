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


public class Camptwo extends ListActivity {
    private static final String TAGA = "heya";
    SQLiteDatabase db;
    private ArrayList<String> results = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_list);
        Intent in=getIntent();
        String re=in.getStringExtra(TAGA);
        try{

            db=openOrCreateDatabase("bloodbank",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            Toast.makeText(Camptwo.this, "showing people with " + re + " blood group emergency", Toast.LENGTH_SHORT).show();
        }catch(SQLException e)
        {
            Log.d("Error", "Error while Opening Database");
            e.printStackTrace();
        }
        try {

            Cursor c = db.rawQuery("SELECT* FROM emergency", null);

            if (c != null ) {
                if  (c.moveToFirst()) {
                    do {
                        String Name = c.getString(c.getColumnIndex("name"));
                        String address = c.getString(c.getColumnIndex("hospital"));
                        String phone = c.getString(c.getColumnIndex("phone"));
                        String group = c.getString(c.getColumnIndex("bgroup"));
                        if(c.getString(c.getColumnIndex("bgroup")).equals(re)){
                        results.add("Name: " + Name + "" +
                                "Hospital : " + address+
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

    }



}
