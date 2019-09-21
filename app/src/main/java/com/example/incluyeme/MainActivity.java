package com.example.incluyeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.incluyeme.EXTRA_TEXT";

    private Button btn_horario;
    private Button btn_notas;
    private Button btn_pagos;
    //private Button btn_navegar;


    public ArrayList<Clase> lisClases;
    public ArrayList<Nota> lisNotas;
    public ArrayList<Pago> lisPagos;

    public static String strClases;
    public static String strNotas;
    public static String strPagos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_horario=(Button) findViewById(R.id.btn_horario);
        btn_notas=(Button) findViewById(R.id.btn_notas);
        btn_pagos=(Button) findViewById(R.id.btn_pagos);
        //btn_navegar=(Button) findViewById(R.id.btn_navegar);

        //iniciando arreglos:
        lisClases=new ArrayList<>();
        lisNotas=new ArrayList<>();
        lisPagos=new ArrayList<>();

        //Estableciendo elementos del arreglo

        //Clases
        lisClases.add(new Clase(1,"Cálculo 2", "Examen Parcial", 9, 11, new Date(2019,03,03)));
        lisClases.add(new Clase(2,"Matemáticas Básicas", "Examen Parcial", 10,12, new Date(2019,03,03)));
        lisClases.add(new Clase(3, "Diseño de Base de Datos", "Exposición Parcial", 11, 13, new Date(2019,03,03)));
        lisClases.add(new Clase(4, "Cálculo 2", "Examen Parcial", 12, 14, new Date(2019,03,03)));
        lisClases.add(new Clase(5, "Matemáticas Básicas", "Examen Parcial", 13, 15, new Date(2019,03,03)));
        lisClases.add(new Clase(6,"Diseño de Base de Datos", "Exposición Parcial", 15, 16, new Date(2019,03,03)));
        lisClases.add(new Clase(7,"Cálculo 2", "Examen Parcial", 19, 20, new Date(2019,03,03)));
        lisClases.add(new Clase(8,"Matemáticas Básicas", "Examen Parcial", 20, 22, new Date(2019,03,03)));

        /*FetchClases process = new FetchClases();
        process.execute();

        try {
            JSONArray JClase = new JSONArray(strClases);
            for(int i =0 ;i <JClase.length(); i++){
                JSONObject JO = (JSONObject) JClase.get(i);
                lisClases.add(new Clase(JO.get("curso").toString(), JO.get("tipo").toString(), JO.getInt("hora")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        //Notas
        lisNotas.add(new Nota(1,"Cálculo 2", "PC 1", 20, 16));
        lisNotas.add(new Nota(2,"Cálculo 2", "PC 2", 20, 18));
        lisNotas.add(new Nota(3, "Matemáticas Básicas", "PC 1", 20, 16));
        lisNotas.add(new Nota(4, "Matemáticas Básicas", "PC 2", 20, 15));
        lisNotas.add(new Nota(5, "Matemáticas Básicas", "PC 3", 20, 17));

        //Pagos
        lisPagos.add(new Pago(1, "Mensualidad", 1200, "30 de Diciembre del 2019", false));
        lisPagos.add(new Pago(2, "Mensualidad", 1200, "30 de Diciembre del 2019", false));
        lisPagos.add(new Pago(3, "Mensualidad", 1200, "30 de Junio del 2018", true));
        lisPagos.add(new Pago(4, "Mensualidad", 1200, "30 de Junio del 2018", true));



        //Listeners para botones:

        btn_horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //si es que hay 7 clases en el día o menos, abrir de frente "Horarios"

                if(lisClases.size()>7)
                {
                    openTurnos();
                }else if(lisClases.size()>0 && lisClases.size()<=7)
                {
                    openHorario("todos");
                }else
                {
                    //mostrar mensaje "no hay clases por hoy"
                }
            }
        });

        btn_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lisNotas.size()>0)
                {
                    openNotas();
                }else
                {
                    //mostrar mensaje "no hay notas registradas"
                }
            }
        });

        btn_pagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(lisPagos.size()>0)
                {
                    openPagos();
                }else
                {
                    //mostrar mensaje "no hay pagos pendientes"
                }
            }
        });

        /*btn_navegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openOrigen();
            }
        });*/

    }

    public void openHorario(String pTurno)
    {
        //abrir horario con todos los turnos.
        Intent intent=new Intent(this, Horario.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisClases", lisClases);
        intent.putExtra(EXTRA_TEXT, pTurno);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void openTurnos()
    {
        Intent intent=new Intent(this, Turnos.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisClases", lisClases);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openNotas()
    {
        Intent intent=new Intent(this, Notas.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisNotas", lisNotas);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void openPagos()
    {
        Intent intent=new Intent(this, Pagos.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisPagos", lisPagos);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /*public void openOrigen()
    {
        Intent intent=new Intent(this, Origen.class);
        startActivity(intent);

    }*/
}
