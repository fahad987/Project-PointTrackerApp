package com.example.fadiabrehman.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.oob.SignUp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.FederatedSignInActivity;
/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/

public class MainActivity extends AppCompatActivity {

    Button sign_up;
    Button sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_in = findViewById(R.id.button_sign_in);
        sign_up = findViewById(R.id.button_sign_up);

    }
    public void Signin(View view)
    {
        Intent intent;
        intent = new Intent(getApplicationContext(),SignInActivity.class);
        startActivity(intent);

    }

    public void Signup(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Sign_Up.class);
        startActivity(intent);

    }
}


/*
package com.example.fadiabrehman.project;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button sigin;
    private TextView signup, forget;
    String user, pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        sigin = (Button) findViewById(R.id.sign_in);
        signup = (TextView) findViewById(R.id.signup);
       // forget = (TextView) findViewById(R.id.forget);

        firebaseAuth = FirebaseAuth.getInstance();

        //Now Going To see Email Verification using Firebase
        //Now Going to see whether email has verified or not

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Sign_Up.class);
                startActivity(i);
            }
        });

*/
/*
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Forgot_Password.class));
            }
        });
*//*

        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = username.getText().toString();
                pass = password.getText().toString();
                if (valid()) {

                    firebaseAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task <AuthResult> task) {
                            if (task.isSuccessful()) {
                               finish();
                                Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),Welcome.class);
                                startActivity(i);
//                                checkEmail();
                            } else {
                                firebaseAuth.signOut();
                                Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


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

}
*/
