/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;

/**
 *
 * @author Julian
 */
abstract class Modulo {
    String nombre;
    double capacidad; // Espacio disponible
    double peso;      // Peso de objetos
    double energia;   // Energía disponible
    List<Objeto> inventario;
    
    double estado; //100% todo funciona correcto
    boolean estadoCritico; //Es indispensable hacer reparaciones

    abstract void actualizarEstado(); // Efectos diarios
}
