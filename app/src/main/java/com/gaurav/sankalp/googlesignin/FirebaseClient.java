package com.gaurav.sankalp.googlesignin;

import android.content.Context;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by gourav on 4/24/2018.
 */

class FirebaseClient  {

    Context c;
    ListView listView;
    Firebase firebase;
    String DB_URL;
    CustomAdapter customAdapter;
    DatabaseReference mRef=FirebaseDatabase.getInstance().getReference("Students");


    ArrayList<Students> roll= new ArrayList<Students>();
    public  FirebaseClient(Context c,DatabaseReference mRef, ListView listView)
    {
        this.c= c;
        this.listView= listView;
        this.mRef=mRef;


        Firebase.setAndroidContext(c);
       // firebase=new Firebase(DB_URL);
    }

    public  void refreshdata()
    {
        // mRef=mRef.child("Year").child("I").child("branch").child("CSE").child("Student Details");

        mRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                roll.clear();
                 for(com.google.firebase.database.DataSnapshot ds :dataSnapshot.getChildren()){
                     Students d= new Students();
                     try
                     {
                         d.setName((String) ds.child("name").getValue());
                         d.setEmailid((String) ds.child("emailid").getValue());
                         String att1=(String) ds.child("attendance").getValue();
                         d.setAttendance(att1);
                         String tot1=(String)ds.child("total").getValue();
                         d.setTotal(tot1);
                         d.setRoll((String)ds.child("roll").getValue());
                         int xx=Integer.valueOf(att1);
                         int yy=Integer.valueOf(tot1);
                         double xxx=Math.round((xx*1.0*100)/yy);
                         d.setPercent(""+xxx);

                         roll.add(d);
                     }
                     catch(Exception e)
                     {
                         Log.e("FireBase_Client_Service",e.getMessage());
                     }


                 }
                 if(roll.size()>0)
                 {
                     customAdapter=new CustomAdapter(c, roll);
                     listView.setAdapter((ListAdapter) customAdapter);
                 }
                 else
                 {
                     Toast.makeText(c, "No data", Toast.LENGTH_SHORT).show();
                 }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }





}
