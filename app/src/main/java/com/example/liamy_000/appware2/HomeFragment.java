package com.example.liamy_000.appware2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {
    private ImageButton imageButton,imageButton2, imageButton3,imageButton4,imageButton5,imageButton6,imageButton7,imageButton8;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageButton = view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",1);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",2);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",3);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",4);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton5 = view.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",5);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton6 = view.findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",6);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton7 = view.findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",7);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        imageButton8 = view.findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",8);
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);
                ft.replace(R.id.fragment_container, af);
                ft.commit();
            }
        });

        return view;
    }

}
