package com.example.incluyeme;

import java.io.Serializable;

public class Pago implements Serializable {
    public int id;
    String concepto; //carné universitario, mensualidad, etc.
    int valor; //2000 soles, etc.
    String fechaVencimiento;
    boolean realizado;

    public Pago(int id, String concepto, int valor, String fechaVencimiento, boolean realizado) {
        this.id=id;
        this.concepto = concepto;
        this.valor = valor;
        this.fechaVencimiento = fechaVencimiento;
        this.realizado=realizado;
    }
}
