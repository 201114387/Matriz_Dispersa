package com.example.robin.matriz_dispersa_final;

/**
 * Created by robin on 26/05/15.
 */
public class Nodo_Lista_Cabecera {
    String nombre;
    Nodo_Lista_Cabecera Siguiente_Nodo;
    Nodo_Lista_Cabecera Anterior_Nodo;
    Nodo_Lista_Cabecera FirstNode;
    Nodo_Lista_Cabecera LastNode;
    Nodo_Matriz Nodo_Derecho;
    Nodo_Matriz Nodo_Abajo;
    int Posicion;
    int filacol;
    Nodo_Lista_Cabecera Profundidad;

    public Nodo_Lista_Cabecera(){
        nombre = null;
        Siguiente_Nodo = null;
        Anterior_Nodo = null;
        FirstNode = null;
        LastNode = null;
        Nodo_Derecho = null;
        Nodo_Abajo = null;
        Profundidad = null;
    }

    public Nodo_Lista_Cabecera(String name, int pos, int fc){
        nombre = name;
        Siguiente_Nodo = null;
        Anterior_Nodo = null;
        FirstNode = null;
        LastNode = null;
        Posicion = pos;
        filacol = fc;
        Nodo_Derecho = null;
        Nodo_Abajo = null;
        Profundidad = null;
    }

    void Insertar_lista(String name, int pos, int fc){
        if (FirstNode == null){
            FirstNode = LastNode = new Nodo_Lista_Cabecera(name, pos, fc);
        }else{
            LastNode.Siguiente_Nodo = new Nodo_Lista_Cabecera(name,pos,fc);
            LastNode.Siguiente_Nodo.Anterior_Nodo = LastNode;
            LastNode = LastNode.Siguiente_Nodo;
        }
    }

    Nodo_Lista_Cabecera Buscar_nodo(Nodo_Lista_Cabecera Raiz, String Nom){
        if (Raiz != null){
            if (Raiz.nombre == Nom){
                return Raiz;
            }else{
                return Buscar_nodo(Raiz.Siguiente_Nodo, Nom);
            }
        }else{
            return null;
        }

    }
}
