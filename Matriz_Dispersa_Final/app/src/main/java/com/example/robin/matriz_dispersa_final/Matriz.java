package com.example.robin.matriz_dispersa_final;

/**
 * Created by robin on 26/05/15.
 */
public class Matriz {
    Lista_Cabecera Cabecera_Dominio;
    Lista_Cabecera Cabecera_ABC;
    Nodo_Lista_Cabecera Primero_listaABC;
    Nodo_Lista_Cabecera Primero_ListaDom;
    int index;
    int i;
    String[] Abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public Matriz(){
        Cabecera_Dominio = new Lista_Cabecera();
        Cabecera_ABC = new Lista_Cabecera();
        index = 1;
        for (i = 0; i < Abecedario.length;i++){
            Cabecera_ABC.Insertar_Lista(Abecedario[i], i + 1, 0);
        }
        Cabecera_Dominio.Insertar_Lista("@hotmail.com", index, 0);
        index++;
        Cabecera_Dominio.Insertar_Lista("@gmail.com",index,0);
        index++;

        Primero_listaABC = Cabecera_ABC.Nodo_Raiz.FirstNode;
        Primero_ListaDom = Cabecera_Dominio.Nodo_Raiz.FirstNode;
     }

    public void Insertar_Matriz(String Name, String Dom){
        System.out.println(Name+ " " + Dom);
        Nodo_Lista_Cabecera AuxABC = Cabecera_ABC.Nodo_Raiz.Buscar_nodo(Primero_listaABC,String.valueOf(Name.charAt(0)));
        Nodo_Lista_Cabecera AuxDom = Cabecera_Dominio.Nodo_Raiz.Buscar_nodo(Primero_ListaDom,Dom);
        if ((AuxABC != null) & (AuxDom != null)){
            Insertar_Matriz2(AuxABC, AuxDom, AuxABC.Posicion, AuxDom.Posicion, Name, Dom);
        }
    }

    public void Insertar_Matriz2(Nodo_Lista_Cabecera Cabecera_AuxABC, Nodo_Lista_Cabecera Cabecera_AuxDom, int posABC, int posDom, String Nombre, String Dom){
        if((Cabecera_AuxABC.Nodo_Derecho == null) & (Cabecera_AuxDom.Nodo_Abajo == null)){
            System.out.println("entro aqui nuevo");
            Nodo_Matriz auxiliar = new Nodo_Matriz();
            auxiliar.Set_Nombre(Nombre, Dom);
            Cabecera_AuxABC.Nodo_Derecho = Cabecera_AuxDom.Nodo_Abajo = auxiliar;
            auxiliar.Set_Arriba1(Cabecera_AuxDom);
            auxiliar.Set_Izquierda1(Cabecera_AuxABC);
            auxiliar.Set_Fila(posABC);
            auxiliar.Set_Columna(posDom);
        }
        else if((Cabecera_AuxABC.Nodo_Derecho != null) & (Cabecera_AuxDom.Nodo_Abajo == null)){
            if(Cabecera_AuxABC.Nodo_Derecho.Columna < posDom){
                this.Insertar_Matriz3(Cabecera_AuxABC.Nodo_Derecho,Cabecera_AuxDom,posABC,posDom,Nombre,Dom);
            }else if(Cabecera_AuxABC.Nodo_Derecho.Columna > posDom){
                Nodo_Matriz auxiliar1 = Cabecera_AuxABC.Nodo_Derecho;
                Nodo_Matriz nuevo = new Nodo_Matriz();
                nuevo.Set_Nombre(Nombre,Dom);
                Cabecera_AuxABC.Nodo_Derecho = Cabecera_AuxDom.Nodo_Abajo = nuevo;
                nuevo.Set_Izquierda1(Cabecera_AuxABC);
                nuevo.Set_Arriba1(Cabecera_AuxDom);
                nuevo.Set_Derecho(auxiliar1);
                auxiliar1.Set_Izquierda(nuevo);
                nuevo.Set_Fila(posABC);
                nuevo.Set_Columna(posDom);
            }
        }
        else if((Cabecera_AuxABC.Nodo_Derecho == null)&(Cabecera_AuxDom.Nodo_Abajo != null)){
            if(Cabecera_AuxDom.Nodo_Abajo.fila < posABC){
                this.Insertar_Matriz4(Cabecera_AuxABC, Cabecera_AuxDom.Nodo_Abajo, posABC, posDom, Nombre, Dom);
            }else if(Cabecera_AuxDom.Nodo_Abajo.fila > posABC){
                Nodo_Matriz auxiliar1 = Cabecera_AuxDom.Nodo_Abajo;
                Nodo_Matriz nuevo = new Nodo_Matriz();
                nuevo.Set_Nombre(Nombre,Dom);
                Cabecera_AuxABC.Nodo_Derecho = Cabecera_AuxDom.Nodo_Abajo = nuevo;
                nuevo.Set_Izquierda1(Cabecera_AuxABC);
                nuevo.Set_Arriba1(Cabecera_AuxDom);
                nuevo.Set_Abajo(auxiliar1);
                auxiliar1.Set_Arriba(nuevo);
                nuevo.Set_Fila(posABC);
                nuevo.Set_Columna(posDom);
            }
        }
        else{
            if((Cabecera_AuxABC.Nodo_Derecho.Columna > posDom) & (Cabecera_AuxDom.Nodo_Abajo.fila > posABC)){
                Nodo_Matriz aux1 = Cabecera_AuxABC.Nodo_Derecho;
                Nodo_Matriz aux2 = Cabecera_AuxDom.Nodo_Abajo;
                Nodo_Matriz nuevo = new Nodo_Matriz();
                nuevo.Set_Nombre(Nombre,Dom);
                Cabecera_AuxABC.Nodo_Derecho = Cabecera_AuxDom.Nodo_Abajo = nuevo;
                nuevo.Set_Izquierda1(Cabecera_AuxABC);
                nuevo.Set_Arriba1(Cabecera_AuxDom);
                nuevo.Set_Derecho(aux1);
                aux1.Set_Izquierda(nuevo);
                nuevo.Set_Abajo(aux2);
                aux2.Set_Arriba(nuevo);
                nuevo.Set_Fila(posABC);
                nuevo.Set_Columna(posDom);
            }
            else if((Cabecera_AuxABC.Nodo_Derecho.Columna < posDom) & (Cabecera_AuxDom.Nodo_Abajo.fila < posABC)){
                Nodo_Matriz nuevo = new Nodo_Matriz();
                nuevo.Set_Nombre(Nombre,Dom);
                Cabecera_AuxABC.Nodo_Derecho.Nodo_Derecho = Cabecera_AuxDom.Nodo_Abajo.Nodo_Abajo = nuevo;
                nuevo.Set_Izquierda(Cabecera_AuxABC.Nodo_Derecho.Nodo_Derecho);
                nuevo.Set_Arriba(Cabecera_AuxDom.Nodo_Abajo.Nodo_Abajo);
                nuevo.Set_Fila(posABC);
                nuevo.Set_Columna(posDom);
            }
        }
    }

    public void Insertar_Matriz3(Nodo_Matriz AuxABC, Nodo_Lista_Cabecera AuxDom, int posAuxABC, int posAuxDom, String Nombre, String Dom){
        if (AuxABC == null){
            Nodo_Matriz auxiliar = new Nodo_Matriz();
            auxiliar.Set_Nombre(Nombre,Dom);
            AuxABC = AuxDom.Nodo_Abajo = auxiliar;
            auxiliar.Set_Izquierda(AuxABC);
            auxiliar.Set_Arriba1(AuxDom);
            auxiliar.Set_Fila(posAuxABC);
            auxiliar.Set_Columna(posAuxDom);
        }else{
            this.Insertar_Matriz3(AuxABC.Nodo_Derecho, AuxDom, posAuxABC, posAuxDom, Nombre, Dom);
        }
    }


    public void Insertar_Matriz4(Nodo_Lista_Cabecera AuxABC, Nodo_Matriz AuxDom, int posAuxABC, int posAuxDom, String Nombre, String Dom){
        if(AuxDom == null){
            Nodo_Matriz nuevo = new Nodo_Matriz();
            nuevo.Set_Nombre(Nombre, Dom);
            AuxABC.Nodo_Derecho = AuxDom = nuevo;
            nuevo.Set_Izquierda1(AuxABC);
            nuevo.Set_Arriba(AuxDom);
            nuevo.Set_Fila(posAuxABC);
            nuevo.Set_Columna(posAuxDom);
        }else{
            this.Insertar_Matriz4(AuxABC, AuxDom.Nodo_Abajo, posAuxABC,posAuxDom,Nombre, Dom);
        }
    }
}
