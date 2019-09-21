package com.example.incluyeme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Pagos extends AppCompatActivity implements OnClickListener {

    LinearLayout parent;
    Button b1;

    String txtPago="";

    ArrayList<Pago> lisPagos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        //recibir arreglo de pagos
        Bundle bundleobject=getIntent().getExtras();
        lisPagos=(ArrayList<Pago>)bundleobject.getSerializable("lisPagos");

        //crear un botón dinámico según cada pago, por concepto. (concepto/monto/FechaVencimiento)

        parent=(LinearLayout)findViewById(R.id.ll_parentlayout);


        for(int i=0;i<=lisPagos.size();i++)
        {
            //crear botón de Volver
            if(i==lisPagos.size())
            {
                b1=new Button(Pagos.this);
                b1.setId(i+1);
                b1.setText("Volver");
                b1.setTag("volver");//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(Pagos.this);
            }
            else
            {
                txtPago=lisPagos.get(i).concepto+" "+lisPagos.get(i).valor+" "+lisPagos.get(i).fechaVencimiento;
                b1=new Button(Pagos.this);
                b1.setId(i+1);
                b1.setText(txtPago);//nombre de curso
                b1.setTag(lisPagos.get(i).concepto);//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(Pagos.this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String str=v.getTag().toString();
        if(str.equals("volver"))
        {
            //vuelve...
            finish();
        }

    }
}
