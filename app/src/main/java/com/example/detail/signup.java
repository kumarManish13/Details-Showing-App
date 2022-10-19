package com.example.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity {
    EditText Na_name;
    EditText Na_phone;
    EditText Na_email;
    EditText Na_newPas;
    EditText Na_conPas;
    EditText Na_comp;
    Button Na_button;
    FirebaseDatabase compName;
    DatabaseReference reference;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Na_button = findViewById(R.id.NA_button);
        Na_conPas = findViewById(R.id.NA_conpas);
        Na_name  = findViewById(R.id.NA_name);
        Na_email = findViewById(R.id.NA_email);
        Na_newPas = findViewById(R.id.NA_newpas);
        Na_phone = findViewById(R.id.NA_phone);
        Na_comp = findViewById(R.id.NA_company);
        fAuth = FirebaseAuth.getInstance();



//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),list.class));
//            finish();
//        }

        Na_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                String Nac_conPas = Na_conPas.getText().toString();
                String Nac_phone = Na_phone.getText().toString();
                String Nac_newPas =Na_newPas.getText().toString();
                String Nac_email =Na_email.getText().toString();
                String Nac_name =Na_name.getText().toString();
                String Nac_company = Na_comp.getText().toString();

//                compName = FirebaseDatabase.getInstance();
//                reference = compName.getReference();
//
//                ComPany comp = new ComPany(Nac_company);
//                reference.setValue(comp);


                if(TextUtils.isEmpty(Nac_name)){
                    Toast.makeText(signup.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(Nac_email)){
                    Toast.makeText(signup.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(Nac_phone)){
                    Toast.makeText(signup.this, "Please enter your e-mail address", Toast.LENGTH_SHORT).show();
                }
                if(Nac_newPas.length() < 6){
                    Toast.makeText(signup.this, "Password should be greater than 6 Characters", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(Nac_conPas)){
                    Toast.makeText(signup.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                }

                if(Nac_conPas.equals(Nac_newPas)) {

                    fAuth.createUserWithEmailAndPassword(Nac_email,Nac_newPas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(signup.this, list.class);
                                intent.putExtra("Keycomp",Nac_company);
                                startActivity(intent);

                                Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();


                            }   else {
                                Toast.makeText(signup.this, "Their is an existing account from this e-mail address" , Toast.LENGTH_SHORT).show();
                            }


                        }
                    });


                }
                else {
                    Toast.makeText(signup.this, "Your password isn't same , Please enter same password ", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}


