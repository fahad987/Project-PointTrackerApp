package com.example.fadiabrehman.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_Up extends AppCompatActivity {

    private EditText name, username, password;
    private Button signup;
    private TextView signin;
    FirebaseAuth firebaseAuth;
    String name1, user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.sign_up);
        name = (EditText) findViewById(R.id.name);
        signin = (TextView) findViewById(R.id.signin);


        firebaseAuth = FirebaseAuth.getInstance();


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString();
                user = username.getText().toString();
                pass = password.getText().toString();
                if (valid()) {

                    firebaseAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task <AuthResult> task) {
                            if (task.isSuccessful()) {
                                finish();
                                firebaseAuth.signOut();
                                Toast.makeText(getApplicationContext(),"Signup Successfull",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                                //calling send email method
                       //         sendEmail();
                            } else {
                                firebaseAuth.signOut();
                                Toast.makeText(getApplicationContext(), "Error in Sing-Up", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }

    private Boolean valid() {
        Boolean result = false;

        if (name.equals("") || user.equals("") || pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Fill All The Fields", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }


        return result;
    }
}