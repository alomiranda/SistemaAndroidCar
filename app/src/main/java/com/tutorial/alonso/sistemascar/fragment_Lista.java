package com.tutorial.alonso.sistemascar;

/**
 * Created by alonso on 29/05/2015.
 */
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import java.util.LinkedList;
import java.util.List;


public class fragment_Lista extends Fragment {

    List<tarea> books;
    View rootView;
    int contador = 0;

    EditText ed ;
    private Cursor cursor;
    adminSql db;

    String[] values;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_lista, container, false);

        db = new adminSql(getActivity().getApplicationContext());
        ed = (EditText) rootView.findViewById(R.id.editText6);

        // Defined Array values to show in ListView
        values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        books = new LinkedList<tarea>();
        books = db.getAllTareas();

        return rootView;
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        books = db.getAllTareas();





    }

}