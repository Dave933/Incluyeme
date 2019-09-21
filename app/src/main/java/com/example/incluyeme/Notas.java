package com.example.incluyeme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Notas extends AppCompatActivity implements OnClickListener {

    public static final String EXTRA_TEXT="com.example.incluyeme.EXTRA_TEXT";

    LinearLayout parent;
    Button b1;

    ArrayList<Nota> lisNotas;
    ArrayList<String> lisCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        //recibir arreglo de notas...
        Bundle bundleobject=getIntent().getExtras();
        lisNotas=(ArrayList<Nota>)bundleobject.getSerializable("lisNotas");

        //iniciando arreglos:
        lisCursos=new ArrayList<>();

        //hacer un "for" para sacar un arreglo de nombres de cursos.
        for(Nota n:lisNotas)
        {
            //si es que la nota no está en el arreglo, ponerla
            if(!(lisCursos.contains(n.curso)))
            {
                lisCursos.add(n.curso);
            }
        }

        //crear botones dinámicos con los nombres de cada curso. su onClickListener debe originar un "openNotasPorCurso"

        parent=(LinearLayout)findViewById(R.id.ll_parentlayout);

        //hacer un "for" para que aparezcan las clases de cierto turno.

        for(int i=0;i<=lisCursos.size();i++)
        {
            //crear botón de Volver
            if(i==lisCursos.size())
            {
                b1=new Button(Notas.this);
                b1.setId(i+1);
                b1.setText("Volver");
                b1.setTag("volver");//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(Notas.this);
            }
            else
            {
                b1=new Button(Notas.this);
                b1.setId(i+1);
                b1.setText(lisCursos.get(i));//nombre de curso
                b1.setTag(lisCursos.get(i));//tag=nombre de curso
                parent.addView(b1);
                b1.setOnClickListener(Notas.this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String str=v.getTag().toString();
        if(str.equals("volver"))
        {
            finish();
        }else
        {
            for(String c:lisCursos)
            {
                if(str.equals(c))
                {
                    openNotasPorCurso(c);
                }
            }
        }
    }

    public void openNotasPorCurso(String pCurso) //pasar como parámetro el curso a NotasPorCurso
    {
        Intent intent=new Intent(this, NotasPorCurso.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("lisNotas", lisNotas);
        intent.putExtras(bundle);
        intent.putExtra(EXTRA_TEXT, pCurso);
        startActivity(intent);
    }

}