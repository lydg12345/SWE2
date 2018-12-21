package com.example.liamy_000.appware2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileOutputStream;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.liamy_000.appware2.Apartments;

public class ApartmentFragment extends Fragment {
    private ImageView imageView;
    private Button button, button2;
    private TextView contactNumber;
    public int num;
    private static final int REQUEST_CALL = 1;
    DatabaseReference databaseReference;
    FirebaseDatabase database;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_apartment, container, false);
        imageView = view.findViewById(R.id.imageView);
        //textView = view.findViewById(R.id.textView3);
        int [] pics = new int [] {R.mipmap.apartment1, R.mipmap.apartment2,R.mipmap.apartment3,R.mipmap.apartment4,R.mipmap.apartment5,R.mipmap.apartment6,R.mipmap.apartment7,R.mipmap.apartment8};
        int [] txt = new int[] {R.string.t1,R.string.t2,R.string.t3,R.string.t4,R.string.t5,R.string.t6,R.string.t7,R.string.t8};
        Bundle bundle = getArguments();
        num = bundle.getInt("Num");


        String[] apartmentInfo = {""};


        if(num == 1)
            apartmentInfo = getResources().getStringArray(R.array.apartment1);
        else if(num == 2)
            apartmentInfo = getResources().getStringArray(R.array.apartment2);
        else if(num == 3)
            apartmentInfo = getResources().getStringArray(R.array.apartment3);
        else if(num == 4)
            apartmentInfo = getResources().getStringArray(R.array.apartment4);
        else if(num == 5)
            apartmentInfo = getResources().getStringArray(R.array.apartment5);
        else if(num == 6)
            apartmentInfo = getResources().getStringArray(R.array.apartment6);
        else if(num == 7)
            apartmentInfo = getResources().getStringArray(R.array.apartment7);
        else if(num == 8)
            apartmentInfo = getResources().getStringArray(R.array.apartment8);



        TextView apartmentName = view.findViewById(R.id.textView6);
        TextView apartmentType = view.findViewById(R.id.textView8);
        contactNumber = view.findViewById(R.id.textView9);

        try {

            //the following textviews will display details about the apartment, data comes from the Strings.xml file
            apartmentName.setText(apartmentInfo[0]);
            contactNumber.setText(apartmentInfo[1]);
        }catch(Exception e){
            Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_LONG).show();
        }

        try{//makes the contact number clickable
            contactNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makePhoneCall();//this will invoke a request permission if the persmissions aren;t true yet, and/or makes the call
                }
            });

        }catch(Exception e){
            Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_LONG).show();
        }

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Apartment");
        final Apartments apartments = new Apartments("Apartment A", "Spenser", "2 Bedroom", 662800);

        imageView.setImageResource(pics[num-1]);
        //String message = getString(txt[num-1]);
        //textView.setText(message);


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
                //String id = databaseReference.push().getKey();
                try {//in case data isn't stored to the database correctly
                    databaseReference.push().setValue(apartments);//stores the apartment object to the database, at least i hope so
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_LONG).show();
                }
                SavedFragment sf = new SavedFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("Num",num);
                sf.setArguments(bundle);
                ft.replace(R.id.fragment_container, sf);
                ft.commit();

            }
        });


        return view;
    }

    public void makePhoneCall(){
        String number = contactNumber.getText().toString().trim();
        if(number.length() > 0){
            if(ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }else{
                String dial = "tel:1868"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }




}
