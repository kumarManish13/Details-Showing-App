package com.example.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import  android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    TextView textView2;
    EditText editText;
    EditText editText1;
    EditText editText2;
    Button button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.NA_button);
        textView = findViewById(R.id.textView);
        editText2 = findViewById(R.id.main_company);
        textView2 = findViewById(R.id.textView3);
        editText = findViewById(R.id.main_email);
        editText1 = findViewById(R.id.main_pass);
        auth = FirebaseAuth.getInstance();

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext() ,signup.class));
            }
        });

//        String comPName = getIntent().getStringExtra("keycomp");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String logEmail = editText.getText().toString();
                String logPass = editText1.getText().toString();
                String logComp  = editText2.getText().toString();
                if(TextUtils.isEmpty(logEmail)){
                    Toast.makeText(MainActivity.this, "Please enter your e-mail address", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(logPass)) {
                    Toast.makeText(MainActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }
                auth.signInWithEmailAndPassword(logEmail,logPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, list.class);
                            intent.putExtra("Keycomp", logComp);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "No user found on this e-mail account", Toast.LENGTH_SHORT).show();
                        }
                    }

                });



            }
        });


    }
}
