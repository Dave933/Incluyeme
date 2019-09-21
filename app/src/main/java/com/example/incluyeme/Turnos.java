package com.example.incluyeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Turnos extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.incluyeme.EXTRA_TEXT";

    private Button btn_maniana;
    private Button btn_tarde;
    private Button btn_noche;
    private Button btn_volver;

    private String turno; // turno


    ArrayList<Clase> lisClases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);

        Bundle bundleobject=getIntent().getExtras();
        lisClases=(ArrayList<Clase>)bundleobject.getSerializable("lisClases");

        btn_maniana=(Button) findViewById(R.id.btn_maniana);
        btn_tarde=(Button) findViewById(R.id.btn_tarde);
        btn_noche=(Button) findViewById(R.id.btn_noche);
        btn_volver=(Button) findViewById(R.id.btn_volver);

        btn_maniana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHorarioxTurno("maniana");

            }
        });

        btn_tarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHorarioxTurno("tarde");
            }
        });

        btn_noche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHorarioxTurno("noche");
            }
        });

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }
    public void openHorarioxTurno(String pTurno)//aquí pasar el parámetro que indique el turno
    {
        Intent intent=new Intent(this, Horario.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisClases", lisClases);
        intent.putExtras(bundle);
        intent.putExtra(EXTRA_TEXT, pTurno);
        startActivity(intent);
    }
}
