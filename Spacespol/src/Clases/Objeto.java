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
    private String nombre;
    private double peso;
    private double volumen;
    private String tipo; // comida, mobiliario, equipo, experimento
    private boolean esFijo;

    public Objeto(String nombre, double peso, double volumen, String tipo, boolean esFijo) {
        this.nombre = nombre;
        this.peso = peso;
        this.volumen = volumen;
        this.tipo = tipo;
        this.esFijo = esFijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsFijo() {
        return esFijo;
    }

    public void setEsFijo(boolean esFijo) {
        this.esFijo = esFijo;
    }
    
    
    public void usar() {
        System.out.println(nombre + " está siendo utilizado.");
    }
    
    // Método para mostrar información del objeto
    public void mostrarInfo() {
        System.out.println("Objeto: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Volumen: " + volumen + " m³");
        System.out.println("Es fijo: " + (esFijo ? "Sí" : "No"));
    }
}  
    
