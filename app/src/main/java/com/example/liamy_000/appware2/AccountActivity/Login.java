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
                if(firebaseAuth.getCurrentUser() != null){//if someone is already logged in when the app is opened....
                    finish();//close this screen and then...
                    Intent intent = new Intent(Login.this, MainActivity.class);//go straight to the app itself
                    startActivity(intent);//I mean this one lol
                }
            }
        };

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//if u dont have an account, or you dont know the fella password
                Intent intent = new Intent(Login.this, SignUp.class);//then how about we make out own on this page
                startActivity(intent);//opens up the sign up page to create our own email and password authentication
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });//to check if the password and email inputted is legit

    }






    private void validate(){
        String email = name.getText().toString().trim();//pulls the email from screen
        String pass = password.getText().toString().trim();//pulls the password from the screen

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){//if either field is empty, scold the user
            Toast.makeText(Login.this, "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
            counter--;//we also reduce their chances
            info.setText("Number of Attempts remaining: "+String.valueOf(counter));
            if(counter == 0){//if the user continuously presses login without any data, probably a bot or an idiot
                button.setEnabled(false);//prevent that hacker from accessing the app
            }
            return;
        }

        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {//takes both the email and password
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {//checks with the database
                        if(!task.isSuccessful()){//if its not there, tell the user
                            Toast.makeText(Login.this, "Email or Password is incorrect", Toast.LENGTH_SHORT).show();
                            counter--;//we also will reduce their chances here, just in case
                            info.setText("Number of Attempts remaining: "+String.valueOf(counter));
                            if(counter == 0){//in case they are trying too much
                                button.setEnabled(false);//cut them off
                            }
                        }
                        else{
                            finish();//email and password were accepted
                            Intent intent = new Intent(Login.this, MainActivity.class);//open the app
                            startActivity(intent);//send user to the first page
                        }
                    }
                });

    }

    @Override
    protected void onStart(){//needed for the authentication to work
        super.onStart();

        auth.addAuthStateListener(authLister);

    }
}
