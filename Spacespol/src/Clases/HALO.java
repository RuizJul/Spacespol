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
public class HALO extends Modulo {

    public HALO(double capacidad, double pesoMaximo) {
        super.nombre = "HALO";
        super.capacidad = capacidad;
        super.pesoMaximo = pesoMaximo;
        super.usado = 0;
        super.pesoActual = 0;
        super.estado = 100;
        super.estadoCritico = false;
        super.inventario = new ArrayList<>();
    }

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
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).nombre.equals(obj.nombre)) {
                usado -= inventario.get(i).espacio;
                pesoActual -= inventario.get(i).peso;
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
        System.out.println("El objeto " + obj.nombre + " no se encuentra en el HALO.");
        return false;
    }

    public void asignarActividad(String actividad) {
        System.out.println("Astronautas realizan: " + actividad);
    }

    // Mostrar estado específico de HALO
    @Override
    public void mostrarEstado() {
        System.out.println("=== Módulo HALO ===");
        System.out.println("Estado general: " + estado + "%");
        if (estadoCritico) {
            System.out.println("⚠ Estado crítico!");
        }
        System.out.println("Espacio usado: " + usado + " / " + capacidad);
        System.out.println("Peso actual: " + pesoActual + " / " + pesoMaximo);
        System.out.println("Astronautas pueden realizar: comer, descansar, preparar misión");
    }
}
