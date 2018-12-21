package com.example.liamy_000.appware2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

public class SavedFragment extends Fragment {
    private ImageView imageView;
    private TextView textView;
    private int num = 4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        imageView = view.findViewById(R.id.iv);
        textView = view.findViewById(R.id.tv);
        Bundle bundle = getArguments();//retrieves all arguments from the previous fragment
        //pull the list of paths to the apartment pictures
        int[] pics = new int[]{R.mipmap.apartment1, R.mipmap.apartment2, R.mipmap.apartment3, R.mipmap.apartment4, R.mipmap.apartment5, R.mipmap.apartment6, R.mipmap.apartment7, R.mipmap.apartment8};
        //pulls the list of paths to the apartment information
        int[] txt = new int[]{R.string.t1, R.string.t2, R.string.t3, R.string.t4, R.string.t5, R.string.t6, R.string.t7, R.string.t8};

        try {//just in case it crashes.....again

            num = bundle.getInt("Num");//gets the apartment which was chosen
            imageView.setImageResource(pics[num - 1]);//sets the apartment image to match the last screen
            String message = getString(txt[num - 1]);//same but with the data
            textView.setText(message);
        }catch(Exception e) {//if it fails
            imageView.setImageResource(pics[num - 1]);//sets the apartment image to match the last screen
            String message = getString(txt[num - 1]);//same but with the data
            textView.setText(message);
        }

        Button button = view.findViewById(R.id.bck);//a simple back button, nun much
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new HomeFragment());
                ft.commit();//closes this fragment
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",num);//creates a bundle to store the position of apartment
                ApartmentFragment af = new ApartmentFragment();
                af.setArguments(bundle);//attaches it to the new fragment
                ft.replace(R.id.fragment_container, af);//replaces the fragment
                ft.commit();//closes this fragment
            }
        });

        return view;
    }
}
