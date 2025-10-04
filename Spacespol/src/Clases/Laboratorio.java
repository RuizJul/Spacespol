/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Julian
 */
public class Laboratorio extends Modulo {

    private boolean equipoOperativo = true;
    private double energiaRequeridaPorExperimento = 10;
    //MISION
    private int muestrasRecolectadas = 0; // materiales disponibles para analizar
    private Random random = new Random();

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

    // Realizar un experimento (requiere energía, materiales y buen estado)
    public void realizarExperimento(Gateway gateway, Logistica logistica) {
        if (!equipoOperativo) {
            System.out.println("⚠ El laboratorio está averiado. No se pueden realizar experimentos.");
            return;
        }

        if (muestrasRecolectadas <= 0) {
            System.out.println("⚠ No hay muestras para analizar. Los astronautas deben recolectar más.");
            return;
        }

        if (gateway.energiaDisponible < energiaRequeridaPorExperimento) {
            System.out.println("⚠ Energía insuficiente para realizar el experimento.");
            return;
        }

        if (!logistica.consumirRecurso("reactivo")) {
            System.out.println("⚠ No hay suficientes reactivos en el módulo de logística.");
            return;
        }

        // Si pasa todas las condiciones:
        gateway.consumirEnergia(energiaRequeridaPorExperimento);
        muestrasRecolectadas--;
        
        boolean exito = random.nextDouble() < 0.7; // 70% de probabilidad de éxito

        //CORRECION PARA MISION
         if (exito) {
            double avance = 10 + random.nextDouble() * 10; // 10-20%
            if (gateway.getMision() != null) {
                gateway.getMision().avanzarProgreso(avance);
            }
            System.out.println("✅ Experimento exitoso. Progreso de la misión actualizado.");
         } else {
             estado -= 5;
            System.out.println("❌ El experimento falló. El equipo se deteriora. Estado actual: " + estado + "%");
            if (estado <= 50) {
                equipoOperativo = false;
                estadoCritico = true;
                System.out.println("⚠ El laboratorio ha entrado en estado crítico. Requiere reparación con el Canadarm3.");
            }
        }
    }
}
