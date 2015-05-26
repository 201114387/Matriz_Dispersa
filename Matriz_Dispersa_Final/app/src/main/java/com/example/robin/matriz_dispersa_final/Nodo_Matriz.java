package com.example.robin.matriz_dispersa_final;

/**
 * Created by robin on 26/05/15.
 */
public class Nodo_Matriz {
    String nombre;
    Nodo_Matriz Nodo_Izquierdo;
    Nodo_Matriz Nodo_Derecho;
    Nodo_Matriz Nodo_Arriba;
    Nodo_Lista_Cabecera Nodo_Arriba1;
    Nodo_Lista_Cabecera Nodo_Izquierdo1;
    Nodo_Matriz Nodo_Abajo;
    Nodo_Matriz Profundidad;
    int fila;
    int Columna;

    public Nodo_Matriz(){
        Nodo_Izquierdo = null;
        Nodo_Derecho = null;
        Nodo_Arriba = null;
        Nodo_Abajo = null;
        Profundidad = null;
        Nodo_Arriba1 = null;
        Nodo_Izquierdo1 = null;
        fila = 0;
        Columna = 0;
    }

    void Set_Nombre(String nombre, String dominio){
        this.nombre = nombre + dominio;
    }

    void Set_Izquierda(Nodo_Matriz izq){
        this.Nodo_Izquierdo = izq;
    }

    void Set_Derecho(Nodo_Matriz der){
        this.Nodo_Derecho = der;
    }

    void Set_Arriba(Nodo_Matriz Up){
        this.Nodo_Arriba = Up;
    }

    void Set_Abajo(Nodo_Matriz Down){
        this.Nodo_Abajo = Down;
    }

    void Set_Profundidad(Nodo_Matriz Prof){
        this.Profundidad = Prof;
    }

    void Set_Fila(int f){
        this.fila = f;
    }

    void Set_Columna(int C){
        this.Columna = C;
    }

    void Set_Izquierda1(Nodo_Lista_Cabecera iz1){
        this.Nodo_Izquierdo1 = iz1;
    }

    void Set_Arriba1(Nodo_Lista_Cabecera up1){
        this.Nodo_Arriba1 = up1;
    }

}
