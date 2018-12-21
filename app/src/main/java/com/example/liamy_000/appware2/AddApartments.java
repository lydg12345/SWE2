package com.example.liamy_000.appware2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.Activity.RESULT_OK;


public class AddApartments extends Fragment {
    private ImageView upload;
    private EditText t1,t2,t3,t4,t5,t6;
    private Button save;
    private static final int PICK_IMAGE=100;
    Uri imageUri;
    DatabaseReference databaseReference;
    FirebaseDatabase database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view =  inflater.inflate(R.layout.activity_add_apartment, container, false);

        upload = view.findViewById(R.id.imageView3);
        upload.setOnClickListener(new View.OnClickListener() {//makes the picture clickable
            @Override
            public void onClick(View view) {
                openGallery();//runs function to get picture from phone gallery
            }
        });

        t1 = view.findViewById(R.id.text1);
        t2 = view.findViewById(R.id.text2);
        t3 = view.findViewById(R.id.text3);
        t4 = view.findViewById(R.id.text4);
        t5 = view.findViewById(R.id.text5);
        t6 = view.findViewById(R.id.text6);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("NewApartment");



        save = view.findViewById(R.id.saveApp);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apartmentName = t1.getText().toString();
                String landlordName = t2.getText().toString();
                String apartmentType = t3.getText().toString();
                String contractDuration = t4.getText().toString();
                String depositAndFees = t5.getText().toString();
                String amenities = t6.getText().toString();
                if(apartmentName.length()==0 || landlordName.length()==0||apartmentName.length()==0){
                    Toast.makeText(getActivity(),"Please Fill All Fields",Toast.LENGTH_LONG).show();
                }
                else {
                    try {//in case data isn't stored to the database correctly
                        final NewAppartment newAppartment = new NewAppartment(apartmentName, landlordName, apartmentType, contractDuration, depositAndFees, amenities);
                        databaseReference.push().setValue(newAppartment);//stores the apartment object to the database, at least i hope so
                        Toast.makeText(getActivity(),"Stored Successfully",Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });




        return view;
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);//necessary to get access to phone gallery
        startActivityForResult(gallery,PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {//checks if we have permission to access gallery
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == RESULT_OK && requestCode == PICK_IMAGE) {
                imageUri = data.getData();
                upload.setImageURI(imageUri);
                Toast.makeText(getActivity(), "Picture added", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getActivity(),"Permission not granted. Change your app settings to give this app permission to read your gallery.",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getActivity(), "Picture not added, please turn a blind eye", Toast.LENGTH_LONG).show();
        }
    }
}
