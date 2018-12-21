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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SearchFragment extends Fragment {
    private RadioGroup radioGroup;
    private RadioButton radioButton, rb1, rb2, rb3, rb4;
    private ConstraintLayout c1,c2,c3,c4,c5,c6,c7,c8;
    private Button button;
    int num = 0;
    String text;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        button = view.findViewById(R.id.button4);
        radioGroup = view.findViewById(R.id.radioGroup);
        rb1 = view.findViewById(R.id.cb1);
        rb2 = view.findViewById(R.id.cb2);
        rb3 = view.findViewById(R.id.cb3);
        rb4 = view.findViewById(R.id.cb4);
        c1 = (ConstraintLayout)view.findViewById(R.id.con1);
        c2 = (ConstraintLayout)view.findViewById(R.id.con2);
        c3 = (ConstraintLayout)view.findViewById(R.id.con3);
        c4 = (ConstraintLayout)view.findViewById(R.id.con4);
        c5 = (ConstraintLayout)view.findViewById(R.id.con5);
        c6 = (ConstraintLayout)view.findViewById(R.id.con6);
        c7 = (ConstraintLayout)view.findViewById(R.id.con7);
        c8 = (ConstraintLayout)view.findViewById(R.id.con8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c1.setVisibility(View.GONE);
                c2.setVisibility(View.GONE);
                c3.setVisibility(View.GONE);
                c4.setVisibility(View.GONE);
                c5.setVisibility(View.GONE);
                c6.setVisibility(View.GONE);
                c7.setVisibility(View.GONE);
                c8.setVisibility(View.GONE);

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = view.findViewById(radioId);

                try {
                    //displays every apartment that is more than $5000
                    if (radioId == (R.id.cb4)) {//radioButton.getText().toString() wasnt working. Luckily this works lol.

                        c5.setVisibility(View.VISIBLE);

                    } else if (radioId == (R.id.cb3)) {//displays every apartment that is between $4000 and $5000



                    } else if (radioId == (R.id.cb2)) {//displays every apartment that is between $3000 and $4000

                        c2.setVisibility(View.VISIBLE);
                        c8.setVisibility(View.VISIBLE);

                    } else if (radioId == (R.id.cb1)) {//displays every apartment that is less than $3000
                        c1.setVisibility(View.VISIBLE);
                        c3.setVisibility(View.VISIBLE);
                        c4.setVisibility(View.VISIBLE);
                        c6.setVisibility(View.VISIBLE);
                        c7.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){//always have a try catch if you are unsure
                    Toast.makeText(getActivity(),"Fix before you hand in",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
