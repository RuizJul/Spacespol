/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class Laboratorio extends Modulo {
    
    List<Objeto> inventario = new ArrayList<>();

    
    // Método para agregar objeto
    public boolean agregarObjeto(Objeto obj) {
        if (usado + obj.espacio <= capacidad && pesoActual + obj.peso <= pesoMaximo) {
            inventario.add(obj);
            usado += obj.espacio;
            pesoActual += obj.peso;
            return true;
        } else {
            return false;
        }
    }

    // Método para remover objeto del módulo
    public boolean removerObjeto(Objeto obj) {
        
    }
    
    void realizarExperimento();
    void recolectarMuestras(Planeta planeta);

   
}
