package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView text, vel, year;
    ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text = view.findViewById(R.id.textId);
        vel = view.findViewById(R.id.vel);
        year = view.findViewById(R.id.year);
        image = view.findViewById(R.id.imagen_auto);
        Bundle bundle = this.getArguments();


        if(bundle != null){
            Toast.makeText(getActivity(), "Item: " + bundle.getString("KEY"), Toast.LENGTH_SHORT).show();

            text.setText(bundle.getString("KEY"));
            year.setText(bundle.getString("KEY2"));
            vel.setText(bundle.getString("KEY3"));
            image.setImageResource(bundle.getInt("KEY4"));
        }

        return view;
    }



}
