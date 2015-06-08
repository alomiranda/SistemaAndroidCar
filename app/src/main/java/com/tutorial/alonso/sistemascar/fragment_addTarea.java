package com.tutorial.alonso.sistemascar;

/**
 * Created by alonso on 29/05/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.Date;

public class fragment_addTarea extends Fragment  implements OnClickListener  {
    View rootView;

    private EditText et1, et2, et3, et4;
    private Button bt;
    adminSql db;

    private Date fecha;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_addtarea, container, false);
        et1 = (EditText) rootView.findViewById(R.id.editText);
        et2 = (EditText) rootView.findViewById(R.id.editText2);
        et3 = (EditText) rootView.findViewById(R.id.editText5);
        et4 = (EditText) rootView.findViewById(R.id.editText4);



         bt = (Button) rootView.findViewById(R.id.button);

        bt.setOnClickListener(this);

        db = new adminSql(getActivity().getApplicationContext());

        return rootView;
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public void onClick(View view) {

        tarea task = new tarea();

        //task.id = Integer.parseInt(et1.getText().toString());
        task.nombre  = et1.getText().toString();
        task.materia = et2.getText().toString();
        task.fechaEntrega = Integer.parseInt(et3.getText().toString());
        task.prioridad = Integer.parseInt(et4.getText().toString());

        db.addTarea(task);


        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        Toast.makeText(getActivity(), "Se agrego Tarea",
                Toast.LENGTH_SHORT).show();


    }
}