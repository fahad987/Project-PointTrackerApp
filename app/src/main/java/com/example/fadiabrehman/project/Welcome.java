package com.example.fadiabrehman.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button sign_up;
    Button map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

           map = findViewById(R.id.ShwMap);
            sign_up = findViewById(R.id.button_sign_up);

        }
        public void Signin(View view)
        {
            Intent intent;
            intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);

        }

        public void Map(View view)
        {
            Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
            startActivity(intent);

        }
    }
