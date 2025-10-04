/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Objeto {
    String nombre;
    double peso;
    double espacio;
    String tipo; // comida, mobiliario, equipo, experimento
    
    public Objeto(String nombre, double peso, double espacio, String tipo){
        this.nombre = nombre;
        this.peso = peso;
        this.espacio = espacio;
        this.tipo = tipo;
    }
}
