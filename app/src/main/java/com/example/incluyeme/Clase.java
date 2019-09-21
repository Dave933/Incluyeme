package com.example.incluyeme;

import java.io.Serializable;
import java.util.Date;

public class Clase implements Serializable{
    public int id;
    public String curso;
    public String tipo; //examen parcial, examen final, PC1, etc. Si es clase normal, el string "tipo" es vacío.
    public Date fecha;
    public int hora_inicio;
    public int hora_fin;

    public Clase(int id, String curso, String tipo, int hora_inicio, int hora_fin, Date fecha) {
        this.id=id;
        this.curso = curso;
        this.tipo = tipo;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha=fecha;
    }
}
