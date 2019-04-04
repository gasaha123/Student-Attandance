package com.gaurav.sankalp.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DirectiveActivity extends AppCompatActivity  {

    Button add_class;
    Button studentdetails;
    Button take_attendance;
    Button show_attendance;
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
    int c=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directive);
        add_class=findViewById(R.id.add_class);
        studentdetails=findViewById(R.id.student_details);
        take_attendance=findViewById(R.id.take_attendence);
        show_attendance=findViewById(R.id.show_attendence);
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



        add_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,AddClassActivity.class));
                finish();
            }
        });
        studentdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,AddStudentsActivity.class));
                finish();
            }
        });

        take_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,ShowAttendance.class));
                finish();
            }
        });
      add_class_image.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(DirectiveActivity.this,AddClassActivity.class));
              finish();
          }
      });

        student_details_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,ShowAttendance.class));
                finish();
            }
        });
        add_class_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,AddClassActivity.class));
                finish();
            }
        });

        student_details_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,ShowAttendance.class));
                finish();
            }
        });

        show_teacher_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,ProfileActivity.class));
                finish();
            }
        });

        show_teacher_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectiveActivity.this,ProfileActivity.class));
                finish();
            }
        });




    }

    @Override
    public void onBackPressed() {
        if(c==0)
        {Toast.makeText(this,"Double Tap for exit", Toast.LENGTH_SHORT).show();c=1;}
        else
        {
            finish();
        }


    }
}
