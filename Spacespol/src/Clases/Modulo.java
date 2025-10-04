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
abstract class Modulo {
    String nombre;
    double capacidad;   // volumen máximo
    double pesoMaximo;  // peso máximo soportado
    double usado;       // espacio ocupado
    double pesoActual;  // peso actual
    double estado = 100; // estado de funcionamiento 0-100
    boolean estadoCritico = false;
    List<Objeto> inventario = new ArrayList<>();


    abstract void mostrarEstado();
}
