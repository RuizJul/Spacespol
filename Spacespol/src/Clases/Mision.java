/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Mision {
    String destino; // Luna o Marte
    int duracion;   // En dias o meses
    double progreso; // % de misión principal completada

    void avanzarProgreso(double cantidad);
    boolean verificarExito();
}

