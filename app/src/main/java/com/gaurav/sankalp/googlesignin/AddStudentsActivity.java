package com.gaurav.sankalp.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentsActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    Spinner spinner1;
    Spinner rollspinner;
    Spinner coursespinner;
    Button fetchcourses;
    DatabaseReference branchRef;
    FirebaseUser mUser;
    ImageView add_class_image;
    ImageView student_details_image;
    ImageView take_attendance_image;
    ImageView show_attendance_image;
    TextView add_class_text;
    TextView student_details_text;
    TextView take_attendance_text;
    TextView show_attendance_text;
    Button submitbutton;
    String branchname;
    String year;
    EditText stuname;
    String roll;

    TextView show_teacher_name;
    ImageView show_teacher_image;
    String courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);
        spinner=(Spinner) findViewById(R.id.spinner);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        branchRef = database.getReference("Students");
        add_class_image=findViewById(R.id.add_class_image);
        student_details_image=findViewById(R.id.student_details_image);
        take_attendance_image=findViewById(R.id.take_attendence_image);
        show_attendance_image=findViewById(R.id.show_attendence_image);
        show_teacher_name=findViewById(R.id.show_teacher_name);
        show_teacher_image=findViewById(R.id.show_teacher_image);
        add_class_text=findViewById(R.id.add_class_text);
        student_details_text=findViewById(R.id.student_details_text);
        take_attendance_text=findViewById(R.id.take_attendence_text);
        show_attendance_text=findViewById(R.id.show_attendence_text);
        fetchcourses=findViewById(R.id.fetchcourses2);


       mUser = FirebaseAuth.getInstance().getCurrentUser();
        branchRef = branchRef.child(mUser.getUid());
        submitbutton=findViewById(R.id.submitstudent);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.branch,android.R.layout.simple_list_item_activated_1);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        stuname=findViewById(R.id.stuname);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                branchname=adapterView.getContext().getResources().getStringArray(R.array.branch)[i].split(" ")[0];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner1=(Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_list_item_activated_1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year=adapterView.getContext().getResources().getStringArray(R.array.year)[i].split(" ")[0];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rollspinner=(Spinner) findViewById(R.id.rollspinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.roll_array, android.R.layout.simple_list_item_activated_1);
        rollspinner.setAdapter(adapter);
        rollspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                roll=adapterView.getContext().getResources().getStringArray(R.array.roll_array)[i].split(" ")[0];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        coursespinner=findViewById(R.id.coursespinnerstudents);
        fetchcourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coursespinner.setClickable(true);
                coursespinner.setEnabled(true);
                submitbutton.setFocusable(true);
                submitbutton.setClickable(true);
                submitbutton.setEnabled(true);

                String my = spinner.getSelectedItem().toString();
                String your = spinner1.getSelectedItem().toString();
                if (my.equals("CSE") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }

                    });
                } else if (my.equals("CSE") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CSE") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CSE") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("CSE") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CSE") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CSE") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CSE") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.cse8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.cse8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }


                else if (my.equals("EEE") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("EEE") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("EEE") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.eee8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.eee8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (my.equals("ECE") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("ECE") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ECE") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ece8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ece8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }


                else if (my.equals("ME") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("ME") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("ME") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.me8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.me8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (my.equals("PIE") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("PIE") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("PIE") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.pie8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.pie8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }


                else if (my.equals("CE") && your.equals("I")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce1, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce1)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("II")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce2, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce2)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("III")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce3, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce3)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("IV")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce4, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce4)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }
                else if (my.equals("CE") && your.equals("V")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce5, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce5)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("VI")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce6, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce6)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("VII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce7, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);

                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce7)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if (my.equals("CE") && year.equals("VIII")) {
                    ArrayAdapter adapter = ArrayAdapter.createFromResource(AddStudentsActivity.this, R.array.ce8, android.R.layout.simple_list_item_activated_1);
                    coursespinner.setAdapter(adapter);
                    coursespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            courseid = adapterView.getContext().getResources().getStringArray(R.array.ce8)[i].split(" ")[0];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

            }

        });


        submitbutton.setOnClickListener(this);
        add_class_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,AddClassActivity.class));
                finish();
            }
        });

        student_details_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,ShowAttendance.class));
                finish();
            }
        });
        add_class_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,AddClassActivity.class));
                finish();
            }
        });

        student_details_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,AddStudentsActivity.class));
                finish();
            }
        });
        take_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,TakeAttendanceActivity.class));
                finish();
            }
        });

        show_attendance_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,ShowAttendance.class));
                finish();
            }
        });

        show_teacher_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,ProfileActivity.class));
                finish();
            }
        });

        show_teacher_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStudentsActivity.this,ProfileActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(validate())
            registeruser();
        else
        {
            Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show();
        }
    }

    private void registeruser()
    {
        String name=stuname.getText().toString().trim();
        branchRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details").child(roll).child("name").setValue(name);
        branchRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details").child(roll).child("attendance").setValue("0");
        branchRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details").child(roll).child("total").setValue("0");
        branchRef.child("Semester").child(year).child("branch").child(branchname).child("Course").child(courseid).child("Student Details").child(roll).child("roll").setValue(roll);
        Toast.makeText(this, "Uploading Done!!", Toast.LENGTH_LONG).show();
    }

    public boolean validate()
    {
        boolean valid=true;
        if(stuname.getText().toString().trim().isEmpty() )
        {
            stuname.setError("Please Enter Your Name");
            valid=false;
        }

        return valid;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,DirectiveActivity.class));
        finish();
    }
}
