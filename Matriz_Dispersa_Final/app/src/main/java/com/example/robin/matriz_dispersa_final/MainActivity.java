package com.example.robin.matriz_dispersa_final;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    Matriz matriz2 = new Matriz();
    int bandera = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Ingresar(View v){
        EditText texto = (EditText)findViewById(R.id.Mensaje);
        String nombre = texto.getText().toString();
        EditText texto1 = (EditText)findViewById(R.id.Mensaje2);
        String dominio = texto1.getText().toString();
        Toast toast = Toast.makeText(this, nombre.toString()+" "+dominio.toString(), Toast.LENGTH_SHORT);
        toast.show();
        matriz2.Insertar_Matriz(nombre,dominio);
    }

    public void Mostrar(View v){
        if (matriz2.Primero_listaABC != null){
            Nodo_Lista_Cabecera aux = matriz2.Primero_listaABC;
            while (aux != null){
                Nodo_Matriz auxiliar = aux.Nodo_Derecho;
                if (auxiliar != null){
                    Toast toast = Toast.makeText(this, auxiliar.nombre.toString() , Toast.LENGTH_SHORT);
                    toast.show();
                }
                aux = aux.Siguiente_Nodo;
            }
        }else{
            Toast toast = Toast.makeText(this, "Sin elementos" , Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
