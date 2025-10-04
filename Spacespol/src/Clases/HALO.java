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
        System.out.println("El objeto " + obj.getNombre() + " no se encuentra en el HALO.");
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
