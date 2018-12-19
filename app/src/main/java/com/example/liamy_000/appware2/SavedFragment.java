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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SavedFragment extends Fragment {
    private ImageView imageView;
    private TextView textView;
    private int num;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        imageView = view.findViewById(R.id.iv);
        textView = view.findViewById(R.id.tv);
        Bundle bundle = getArguments();
        try {
            bundle.getBoolean("check");
            int[] pics = new int[]{R.mipmap.apartment1, R.mipmap.apartment2, R.mipmap.apartment3, R.mipmap.apartment4, R.mipmap.apartment5, R.mipmap.apartment6, R.mipmap.apartment7, R.mipmap.apartment8};
            int[] txt = new int[]{R.string.t1, R.string.t2, R.string.t3, R.string.t4, R.string.t5, R.string.t6, R.string.t7, R.string.t8};

            num = bundle.getInt("Num");

            imageView.setImageResource(pics[num - 1]);
            String message = getString(txt[num - 1]);
            textView.setText(message);
        }catch(Exception e) {

        }

        return view;
    }
}
