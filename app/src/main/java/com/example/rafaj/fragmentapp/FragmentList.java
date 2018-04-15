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

    ArrayList<auto> arreglo = new ArrayList<auto>();
    auto lamborghini;
    auto laferrari;
    auto mbgtr;
    auto porsche918s;
    auto bugatti;
    auto Tesla;
    auto lexuslfa;
    auto audi;
    auto kr;



    public void instanciarauto(){
        lamborghini = new auto("Lamborghini Huracán","Year: 2017", "Top Speed: 285km/h",R.drawable.lmbh);
        laferrari = new auto("Ferrari LaFerrari", "Year: 2015", "Top Speed: 400km/h", R.drawable.flf);
        mbgtr = new auto("Mercedes Benz GTR", "Year: 2016", "Top Speed: 357km/h", R.drawable.gtrpng);
        porsche918s = new auto("Porsche 918 Spyder", "Year: 2018", "Top Speed: 290km/h", R.drawable.p918s);
        bugatti = new auto("Bugatti Veyron", "Year: 2009", "Top Speed: 420km/h", R.drawable.vb);
        Tesla= new auto("Tesla Model S", "Year: 2014", "Top Speed: 435km/h", R.drawable.tms);
        lexuslfa = new auto("Lexus LFA", "Year: 2013", "Top Speed: 368km/h", R.drawable.lfs);
        audi = new auto("Audi R8 V10 Plus", "Year: 2018", "Top Speed: 407km/h", R.drawable.v10);
        kr = new auto("Koenigsegg Regera", "Year: 2015", "Top Speed: 422km/h", R.drawable.kgr);


        arreglo.add(lamborghini);
        arreglo.add(laferrari);
        arreglo.add(mbgtr);
        arreglo.add(porsche918s);
        arreglo.add(bugatti);
        arreglo.add(Tesla);
        arreglo.add(lexuslfa);
        arreglo.add(audi);
        arreglo.add(kr);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        instanciarauto();

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Planets, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            newIntent.setType("text/plain");
            newIntent.putExtra(Intent.EXTRA_TEXT, adapterView.getItemAtPosition(i).toString());
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("KEY", arreglo.get(i).getNombre());
            bundle.putString("KEY2", arreglo.get(i).getAño());
            bundle.putString("KEY3", arreglo.get(i).getVelocidad());
            bundle.putInt("KEY4",arreglo.get(i).getImagen());

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
