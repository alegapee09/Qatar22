package com.dam.evaluaciont1_agp;

import android.app.Application;

public class QATARApp extends Application {

    private String nombre;

    @Override
    public void onCreate(){super.onCreate();}

    public String getNombre(){return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre;}

}