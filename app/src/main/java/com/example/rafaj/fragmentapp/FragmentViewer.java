package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
    TextView text2, ano2, vel2;
    ImageView img3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        text2=view.findViewById(R.id.textId);
        ano2=view.findViewById(R.id.year);
        vel2=view.findViewById(R.id.vel);
        img3=view.findViewById(R.id.imagen_auto);

        Bundle bundle = this.getArguments();

        if(bundle !=null){
            auto nuevo = (auto)bundle.getSerializable("key");

            Resources res =getResources();
            TypedArray icons = res.obtainTypedArray(R.array.iconos);
            Drawable draw = icons.getDrawable(Integer.parseInt(nuevo.getImagen()));

            text2.setText(nuevo.getNombre());
            ano2.setText(nuevo.getAno());
            vel2.setText(nuevo.getVeloc());
            img3.setImageDrawable(draw);
        }



        return view;
    }



}
