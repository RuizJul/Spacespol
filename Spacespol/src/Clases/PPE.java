/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class PPE extends Modulo {

    public PPE(double capacidad, double pesoMaximo) {
        super.nombre = "PPE";
        super.capacidad = capacidad;
        super.pesoMaximo = pesoMaximo;
        super.usado = 0;
        super.pesoActual = 0;
        super.estado = 100;
        super.estadoCritico = false;
        super.inventario = null;
    }

    public double generarEnergia() {
        if (estado <= 0) {
            System.out.println(nombre + " está fuera de servicio.");
            return 0;
        }
        double energia = 10 * (estado / 100.0);
        System.out.println(nombre + " genera " + energia + " unidades de energía.");
        return energia;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("=== Módulo PPE ===");
        System.out.println("Estado general: " + estado + "%");
        if (estadoCritico) {
            System.out.println("⚠ Estado crítico!");
        }
        System.out.println("Espacio usado: " + usado + " / " + capacidad);
        System.out.println("Peso actual: " + pesoActual + " / " + pesoMaximo);
        System.out.println("Genera energía para los módulos conectados");
    }
}
