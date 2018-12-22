package com.example.liamy_000.appware2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText name,password;
    private TextView info;
    private Button button;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.editText);
        password = findViewById(R.id.editText3);
        button = findViewById(R.id.button);
        info = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("Number of Attempts remainging: "+String.valueOf(counter));
            if(counter == 0){
                button.setEnabled(false);
            }
        }
    }
}
