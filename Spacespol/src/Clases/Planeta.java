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
public class Planeta {
    String nombre;
    double distancia; // Para calcular tiempo de viaje
    List<Objeto> muestras;
    private boolean explorado;

    public Planeta(String nombre, double distancia, List<Objeto> muestras, boolean explorado) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.muestras = muestras;
        this.explorado = explorado;
    }
    
    public void agregarMuestra(Objeto muestra) {
        muestras.add(muestra);
    }
    
    public boolean recolectarMuestraPlaneta(Astronauta astronauta, Objeto muestra) {
        if (muestras.contains(muestra)) {
            astronauta.recolectarMuestras(this, muestra);
            muestras.remove(muestra);
            System.out.println("✅ " + astronauta.getNombre() + " ha recolectado: " + muestra.getNombre());
            return true;
        } else {
            System.out.println("⚠️ La muestra " + muestra.getNombre() + " no está disponible en " + nombre);
            return false;
        }
    }
 
    public String getNombre() {
        return nombre;
    }

    public double getDistancia() {
        return distancia;
    }

    public List<Objeto> getMuestras() {
        return muestras;
    }

    public boolean isExplorado() {
        return explorado;
    }

    
   
}
