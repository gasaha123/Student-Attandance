package com.gaurav.sankalp.googlesignin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TakeAttendanceMain extends AppCompatActivity implements View.OnClickListener{

    Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
    DatabaseReference mRef=FirebaseDatabase.getInstance().getReference("Students");
    FirebaseUser mUser;
    String year;
    String branchname;
    String courseid;
    private String[] arr;
    String[] arr1;
    String[] arr2;
    String[] myarray;
    String xx;
    String yy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance_main);
        year = getIntent().getExtras().getString("year");
        branchname = getIntent().getExtras().getString("branchname");
        courseid = getIntent().getExtras().getString("courseid");
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mRef = mRef.child(mUser.getUid());
        mRef = mRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                myarray = new String[(int) dataSnapshot.getChildrenCount()];
                int c=0;
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                     String xxx=ds.child("roll").getValue().toString();
                     myarray[c]=xxx;
                     //Toast.makeText(TakeAttendanceMain.this,""+myarray[c],Toast.LENGTH_LONG).show();
                     c++;
                }
                if(myarray.length==0)
                    Toast.makeText(TakeAttendanceMain.this, "No data", Toast.LENGTH_SHORT).show();
                else {
                        adapter = new ArrayAdapter<String>(TakeAttendanceMain.this,
                                android.R.layout.simple_list_item_multiple_choice, myarray);
                        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                        listView.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        findViewsById();


        //String[] rollno = getResources().getStringArray(R.array.roll_array);



        button.setOnClickListener(this);
    }
    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.testbutton);
    }

    public void onClick(View v) {

        SparseBooleanArray checked = listView.getCheckedItemPositions();
        final ArrayList<String> selectedItems = new ArrayList<String>();
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);

            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }

          mRef.addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                   arr=new String[(int)dataSnapshot.getChildrenCount()];
                   int counter=0;
                   arr1=new String[(int)dataSnapshot.getChildrenCount()];
                   int counter1=0;
                   arr2=new String[(int)dataSnapshot.getChildrenCount()];
                   int counter2=0;
                  for(DataSnapshot ds:dataSnapshot.getChildren())
                  {
                      String tot=ds.child("total").getValue().toString();
                      int totaldays=Integer.valueOf(tot);
                      totaldays=totaldays+1;
                      arr[counter]=tot;
                      counter++;
                      arr1[counter1]=ds.child("roll").getValue().toString();
                      mRef.child(arr1[counter1].toString()).child("total").setValue(""+totaldays);
                      counter1++;
                      arr2[counter2]=ds.child("attendance").getValue().toString();
                      counter2++;
                  }
                  for(int i=0;i<selectedItems.size();i++)
                  {
                      xx=selectedItems.get(i).toString();
                      for(int j=0;j<arr1.length;j++)
                      {

                          yy=arr1[j];
                          if(xx.equals(yy))
                          {
                            String take=arr2[j].toString();
                            int convert=Integer.valueOf(take);
                            convert=convert+1;
                            mRef.child(""+xx).child("attendance").setValue(""+convert);
                          }
                      }
                  }

              }

              @Override
              public void onCancelled(DatabaseError databaseError) {

              }
          });
          startActivity(new Intent(TakeAttendanceMain.this,TakeAttendanceActivity.class));
          finish();



    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TakeAttendanceMain.this,TakeAttendanceActivity.class));
        finish();
    }
}
