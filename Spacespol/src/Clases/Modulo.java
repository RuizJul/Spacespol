/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;



public abstract class Modulo {
    protected String nombre;
    protected double capacidad;   
    protected double pesoMaximo;  
    protected double usado;       
    protected double pesoActual;  
    protected double estado = 100; 
    protected boolean estadoCritico = false;
    protected List<Objeto> inventario = new ArrayList<>();

    public abstract void mostrarEstado();

    // Agregar y remover objetos comunes
    public boolean agregarObjeto(Objeto obj) {
        if (usado + obj.getEspacio() <= capacidad && pesoActual + obj.getPeso() <= pesoMaximo) {
            inventario.add(obj);
            usado += obj.getEspacio();
            pesoActual += obj.getPeso();
            return true;
        } else {
            return false;
        }
    }

    public boolean removerObjeto(Objeto obj) {
        if (inventario.remove(obj)) {
            usado -= obj.getEspacio();
            pesoActual -= obj.getPeso();
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}
