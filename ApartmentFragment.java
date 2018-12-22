package com.example.liamy_000.appware2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class ApartmentFragment extends Fragment {
    private ImageView imageView;
    private Button button, button2;
    private TextView textView;
    public int num;
    String db = "file.txt";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_apartment, container, false);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView3);
        int [] pics = new int [] {R.mipmap.apartment1, R.mipmap.apartment2,R.mipmap.apartment3,R.mipmap.apartment4,R.mipmap.apartment5,R.mipmap.apartment6,R.mipmap.apartment7,R.mipmap.apartment8};
        int [] txt = new int[] {R.string.t1,R.string.t2,R.string.t3,R.string.t4,R.string.t5,R.string.t6,R.string.t7,R.string.t8};
        Bundle bundle = getArguments();
        num = bundle.getInt("Num");

        imageView.setImageResource(pics[num-1]);
        String message = getString(txt[num-1]);
        textView.setText(message);

        button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new HomeFragment());
                ft.commit();
            }
        });

        button2 = view.findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",num);
                bundle.putBoolean("check", true);
                SavedFragment af = new SavedFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();

            }
        });


        return view;
    }

}
