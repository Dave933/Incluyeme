package com.example.incluyeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class NotasPorCurso extends AppCompatActivity implements OnClickListener {

    ArrayList<Nota> lisNotas; //lista total de notas de todos los cursos
    ArrayList<Nota> lisNotasCurso; //lista de notas de "este curso"

    LinearLayout parent;
    Button b1;

    String txtNota="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_por_curso);

        //recibir arreglo de notas...
        Bundle bundleobject=getIntent().getExtras();
        lisNotas=(ArrayList<Nota>)bundleobject.getSerializable("lisNotas");
        lisNotasCurso=new ArrayList<>();


        //recibir el parámetro de curso
        Intent intent=getIntent();
        String curso=intent.getStringExtra(Notas.EXTRA_TEXT);

        for (Nota n:lisNotas)
        {
            if(n.curso.equals(curso))
            {
                //si es que la nota es de este curso, pasarla al otro arreglo
                lisNotasCurso.add(n);
            }
        }


        parent=(LinearLayout)findViewById(R.id.ll_parentlayout);

        //hacer el "display" de horario del curso (con un "for") con botones dinámicos

        for(int i=0;i<=lisNotasCurso.size();i++)
        {
            //crear botón de Volver
            if(i==lisNotasCurso.size())
            {
                b1=new Button(NotasPorCurso.this);
                b1.setId(i+1);
                b1.setText("Volver");
                b1.setTag("volver");//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(NotasPorCurso.this);
            }
            else
            {
                txtNota=lisNotasCurso.get(i).tipoEvaluacion+ ": " +lisNotasCurso.get(i).puntaje;
                b1=new Button(NotasPorCurso.this);
                b1.setId(i+1);
                b1.setText(txtNota);//nombre de curso
                b1.setTag(lisNotasCurso.get(i).tipoEvaluacion);
                parent.addView(b1);
                b1.setOnClickListener(NotasPorCurso.this);
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
