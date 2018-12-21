package com.example.liamy_000.appware2.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.liamy_000.appware2.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogOut extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;//stores data for the firebase
    private Button logout, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);


        firebaseAuth = FirebaseAuth.getInstance();//gets the firebase instance

        cancel = findViewById(R.id.exit);
        logout = findViewById(R.id.logOut);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//if the person cancels, closes this intent
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();//if the person wants to log out, closes this intent and....
                startActivity(new Intent(LogOut.this,Login.class));//runs the Login intent
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);//pulls dimensions of the device

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.22));//only displays a percentage of the LogOut page, like a small window
    }
}
