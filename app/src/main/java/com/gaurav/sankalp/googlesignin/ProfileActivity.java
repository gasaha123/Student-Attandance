package com.gaurav.sankalp.googlesignin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.renderscript.Script;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {

    FirebaseUser mUser;
    ImageView add_class_image;
    ImageView student_details_image;
    ImageView take_attendance_image;
    ImageView show_attendance_image;
    TextView add_class_text;
    TextView student_details_text;
    TextView take_attendance_text;
    TextView show_attendance_text;
    TextView show_teacher_name;
    ImageView show_teacher_image;
    TextView teacher_name;
    TextView teacher_email;
    TextView teacher_phoneno;
    CircleImageView teacher_image;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    DatabaseReference userRef;

    Button logout;


    @SuppressLint("RestrictedApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        add_class_image=findViewById(R.id.add_class_image);
        student_details_image=findViewById(R.id.student_details_image);
        take_attendance_image=findViewById(R.id.take_attendence_image);
        show_attendance_image=findViewById(R.id.show_attendence_image);
        add_class_text=findViewById(R.id.add_class_text);
        student_details_text=findViewById(R.id.student_details_text);
        take_attendance_text=findViewById(R.id.take_attendence_text);
        show_attendance_text=findViewById(R.id.show_attendence_text);
        show_teacher_name=findViewById(R.id.show_teacher_name);
        show_teacher_image=findViewById(R.id.show_teacher_image);
        logout=findViewById(R.id.logout);
        teacher_name=findViewById(R.id.profile_name);
        teacher_email=findViewById(R.id.profile_emailid);
        teacher_image=findViewById(R.id.profile_img);
        teacher_phoneno=findViewById(R.id.profile_phoneno);
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        userRef = FirebaseDatabase.getInstance().getReference("Teachers").child(mUser.getUid());
        userRef.keepSynced(true);
        //Utilities.setPicassoImage(view.getContext(), mUser.getPhotoUrl().toString(), teacher_image, Constants.SQUA_PLACEHOLDER);
        teacher_name.setText(mUser.getDisplayName());
        teacher_email.setText(mUser.getEmail());
        teacher_phoneno.setText(mUser.getPhoneNumber());
        Glide.with(this)
                .load(mUser.getPhotoUrl())
                .into(teacher_image);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               signOut();



             }
         });
        add_class_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,AddClassActivity.class));
                finish();
            }
        });

        student_details_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ShowAttendance.class));
                finish();
            }
        });
        add_class_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,AddClassActivity.class));
                finish();
            }
        });

        student_details_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ShowAttendance.class));
                finish();
            }
        });

        show_teacher_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ProfileActivity.class));
                finish();
            }
        });

        show_teacher_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ProfileActivity.class));
                finish();
            }
        });




    }

    @SuppressLint("RestrictedApi")
    void signOut()
    {
        mAuth.signOut();

        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                 startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                 finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(ProfileActivity.this,DirectiveActivity.class));
        finish();
    }
}
