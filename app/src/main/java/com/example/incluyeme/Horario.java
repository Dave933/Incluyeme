package com.example.incluyeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Horario extends AppCompatActivity implements OnClickListener {

    LinearLayout parent;
    Button b1;

    ArrayList<Clase> lisClases;
    ArrayList<Clase> lisClasesxTurno;


    String txtClase="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        Bundle bundleobject=getIntent().getExtras();
        lisClases=(ArrayList<Clase>)bundleobject.getSerializable("lisClases");
        lisClasesxTurno=new ArrayList<>();

        //pasar parámetro de turno
        Intent intent=getIntent();
        String turno=intent.getStringExtra(Turnos.EXTRA_TEXT);

        parent=(LinearLayout)findViewById(R.id.ll_parentlayout);

        //hacer un "for" para que aparezcan las clases de cierto turno.

        for(Clase c:lisClases)
        {
            switch (turno)
            {
                case "maniana":
                {
                    if(c.hora_inicio<12)
                    {
                        lisClasesxTurno.add(c);
                    }
                }
                break;
                case "tarde":
                {
                    if(c.hora_inicio>=12 && c.hora_inicio<19)
                    {
                        lisClasesxTurno.add(c);
                    }
                }
                break;
                case "noche":
                {
                    if(c.hora_inicio>=19)
                    {
                        lisClasesxTurno.add(c);
                    }
                }
                break;
                case "todos":
                {
                    lisClasesxTurno.add(c);
                }
            }

        }

        for(int i=0;i<=lisClasesxTurno.size();i++)
        {
            //crear botón de Volver
            if(i==lisClasesxTurno.size())
            {
                b1=new Button(Horario.this);
                b1.setId(i+1);
                b1.setText("Volver");
                b1.setTag("volver");
                parent.addView(b1);
                b1.setOnClickListener(Horario.this);
            }
            else
            {
                txtClase=lisClasesxTurno.get(i).hora_inicio+ ". " + lisClasesxTurno.get(i).curso+ ". " +lisClasesxTurno.get(i).tipo;

                b1=new Button(Horario.this);
                b1.setId(i+1);
                b1.setText(txtClase);//nombre de curso
                b1.setTag(i);//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(Horario.this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String str=v.getTag().toString();
        if(str.equals("volver"))
        {
            finish();
        }

    }
}
