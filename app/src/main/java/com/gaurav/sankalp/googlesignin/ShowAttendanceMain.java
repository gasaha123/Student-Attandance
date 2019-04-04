package com.gaurav.sankalp.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowAttendanceMain extends AppCompatActivity {

    //String DB_URL= "https://signin-c2dba.firebaseio.com/";
    DatabaseReference mRef= FirebaseDatabase.getInstance().getReference("Students");
    ListView listView;
    FirebaseUser mUser;
    FirebaseClient firebaseClient;
    String year;
    String branchname;
    String courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_attendance_main);
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mRef = mRef.child(mUser.getUid());
        year = getIntent().getExtras().getString("year");
        branchname = getIntent().getExtras().getString("branchname");
        courseid = getIntent().getExtras().getString("courseid");
        listView=(ListView)findViewById(R.id.listview);
        mRef=mRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details");
        firebaseClient= new FirebaseClient(this,mRef,listView);
       firebaseClient.refreshdata();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ShowAttendanceMain.this,ShowAttendance.class));
        finish();
    }
}
