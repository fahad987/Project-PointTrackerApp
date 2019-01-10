package com.example.fadiabrehman.project;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    // Toolbar toolbar;
    // ProgressBar progressBar;
    EditText userEmail;
    EditText userPass;
    Button userLogin;
    String user, pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPass = (EditText)findViewById(R.id.etUserPass);
        userLogin = (Button)findViewById(R.id.btnUserlogin);

        /*toolbar.setTitle("Login");*/

        firebaseAuth = FirebaseAuth.getInstance();

        /*userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signInWithEmailAndPassword(userEmail.getText().toString(),userPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {*/
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = userEmail.getText().toString();
                pass = userPass.getText().toString();
                if (valid()) {

                    firebaseAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task <AuthResult> task) {

                            if (task.isSuccessful()) {
                                finish();
                                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), Welcome.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(SignInActivity.this, task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }

            private Boolean valid() {
                Boolean result = false;

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill All The Fields", Toast.LENGTH_SHORT).show();
                } else {
                    result = true;
                }


                return result;
            }


        });
    }
}