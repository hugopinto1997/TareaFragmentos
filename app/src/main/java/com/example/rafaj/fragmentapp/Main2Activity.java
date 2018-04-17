package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.ls.LSResourceResolver;

public class Main2Activity extends AppCompatActivity {
    TextView text, ano, vel;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//vinculamos con los id del xml
        text=findViewById(R.id.textIdv);
        ano=findViewById(R.id.yearv);
        vel=findViewById(R.id.velv);
        img = findViewById(R.id.imagen_autov);
//hacemos un intent y ub bundle
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
//creamos cosas necesarias
        auto carro = (auto)bundle.getSerializable("Llave");
        Resources src = getResources();
        TypedArray tipeado = src.obtainTypedArray(R.array.iconos);
        Drawable draw = tipeado.getDrawable(Integer.parseInt(carro.getImagen()));
// llenamos nuestro auto con las cosas
        text.setText(carro.getNombre());
        img.setImageDrawable(draw);
        ano.setText(carro.getAno());
        vel.setText(carro.getVeloc());



    }


}
