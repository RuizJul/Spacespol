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

    public Laboratorio(String nombre, double capacidad, double pesoMaximo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pesoMaximo = pesoMaximo;
        this.usado = 0;
        this.pesoActual = 0;
    }

    // Método para agregar objeto
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

    // Método para remover objeto del módulo
    public boolean removerObjeto(Objeto obj) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equals(obj.getNombre())) {
                usado -= inventario.get(i).getEspacio();
                pesoActual -= inventario.get(i).getPeso();
                inventario.remove(i);
                if (usado < 0) {
                    usado = 0;
                }
                if (pesoActual < 0) {
                    pesoActual = 0;
                }
                return true;
            }
        }
        System.out.println("El objeto " + obj.getNombre() + " no se encuentra en el Laboratorio.");
        return false;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("=== Módulo Laboratorio ===");
        System.out.println("Estado general: " + estado + "%");
        if (estadoCritico) {
            System.out.println("⚠ Estado crítico!");
        }
        System.out.println("Espacio usado: " + usado + " / " + capacidad);
        System.out.println("Peso actual: " + pesoActual + " / " + pesoMaximo);
    }
}
