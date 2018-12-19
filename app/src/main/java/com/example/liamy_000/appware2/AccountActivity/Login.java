package com.example.liamy_000.appware2.AccountActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liamy_000.appware2.MainActivity;
import com.example.liamy_000.appware2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText name,password;
    private TextView info;
    private Button button, signup;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authLister;
    private int counter=15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        button = findViewById(R.id.button);
        signup = findViewById(R.id.signUp);
        info = findViewById(R.id.textView2);

        authLister = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }






    private void validate(){
        String email = name.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){
            Toast.makeText(Login.this, "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
            counter--;
            info.setText("Number of Attempts remaining: "+String.valueOf(counter));
            if(counter == 0){
                button.setEnabled(false);
            }
            return;
        }

        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this, "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
                            counter--;
                            info.setText("Number of Attempts remaining: "+String.valueOf(counter));
                            if(counter == 0){
                                button.setEnabled(false);
                            }
                        }
                        else{
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

    }

    @Override
    protected void onStart(){
        super.onStart();

        auth.addAuthStateListener(authLister);

    }
}
