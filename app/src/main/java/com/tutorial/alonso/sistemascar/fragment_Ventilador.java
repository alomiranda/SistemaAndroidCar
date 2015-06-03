package com.tutorial.alonso.sistemascar;

/**
 * Created by alonso on 29/05/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_Ventilador extends Fragment {

    View rootView;
    int contador = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_ventilador, container, false);


        return rootView;
    }
}