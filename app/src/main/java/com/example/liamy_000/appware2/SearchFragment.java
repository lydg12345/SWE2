package com.example.liamy_000.appware2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchFragment extends Fragment {
    private EditText editText;
    private ConstraintLayout c1,c2,c3,c4,c5,c6,c7,c8;
    private Button button;
    int num = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        editText = view.findViewById(R.id.edit);
        button = view.findViewById(R.id.button4);
        c1 = (ConstraintLayout)view.findViewById(R.id.con1);
        c2 = (ConstraintLayout)view.findViewById(R.id.con2);
        c3 = (ConstraintLayout)view.findViewById(R.id.con3);
        c4 = (ConstraintLayout)view.findViewById(R.id.con4);
        c5 = (ConstraintLayout)view.findViewById(R.id.c5);
        c6 = (ConstraintLayout)view.findViewById(R.id.con6);
        c7 = (ConstraintLayout)view.findViewById(R.id.con7);
        c8 = (ConstraintLayout)view.findViewById(R.id.con8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                num = Integer.parseInt(editText.getText().toString());



                if( num >= 5000){

                    c5.setVisibility(View.VISIBLE);

                }

                else if(num>=3000 && num<5000){

                    c1.setVisibility(View.VISIBLE);
                    c8.setVisibility(View.VISIBLE);
                }
                else{

                    c2.setVisibility(View.VISIBLE);
                    c3.setVisibility(View.VISIBLE);
                    c4.setVisibility(View.VISIBLE);
                    c6.setVisibility(View.VISIBLE);
                    c7.setVisibility(View.VISIBLE);
                }
            }
        });


        return view;
    }
}
