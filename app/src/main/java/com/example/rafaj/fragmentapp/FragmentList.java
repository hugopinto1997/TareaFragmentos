package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

//strings para guardar los datos de los scripts
    private String[] nombre;
    private String[] anioo;
    private String[] velocidad;
    private String[] imagen;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
//obteniendo los datos de los arreglos de scripts
        nombre = getResources().getStringArray(R.array.automoviles);
        anioo = getResources().getStringArray(R.array.year);
        velocidad = getResources().getStringArray(R.array.velo);
        imagen = getResources().getStringArray(R.array.imagenes);



        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.automoviles, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
//creando objeti tipo auto
        auto nuevoa = new auto(nombre[i], anioo[i], velocidad[i], imagen[i]);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //si es portrair hacemos un intent y le mandamos ub buncle serializable
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            Bundle caja = new Bundle();
            caja.putSerializable("Llave", nuevoa);
            newIntent.putExtras(caja);
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
//si es landscape
            //generamos un fragment viewer
            //hacemos un bundle y le mandamos la llave
            //argumentamos el fragmentviewer
            //realiamos una transaccion
            //realizamos el cambio
            FragmentViewer fv = new FragmentViewer();
            Bundle b1 = new Bundle();
            b1.putSerializable("key", nuevoa);
            fv.setArguments(b1);
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.viewer, fv);
            ft.commit();

        }



    }
}
