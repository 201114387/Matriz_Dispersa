package com.example.robin.matriz_dispersa_final;

/**
 * Created by robin on 26/05/15.
 */
public class Lista_Cabecera {
    Nodo_Lista_Cabecera Nodo_Raiz;
    public Lista_Cabecera(){
        Nodo_Raiz = new Nodo_Lista_Cabecera();
    }

    public void Insertar_Lista(String nombre, int pos, int fc){
        Nodo_Raiz.Insertar_lista(nombre,pos,fc);
    }
}
