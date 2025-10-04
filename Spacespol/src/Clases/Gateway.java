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
public class Gateway {

    List<Modulo> modulos;
    List<Astronauta> tripulacion;
    Canadarm3 brazo;
    double energiaDisponible;
    private Mision mision;


    public Gateway(Canadarm3 brazo) {
        this.modulos = new ArrayList<>();
        this.tripulacion = new ArrayList<>();
        this.brazo = brazo;
        this.energiaDisponible = 0;
    }

    public void agregarModulo(Modulo m) {
        modulos.add(m);
    }

    public void agregarAstronauta(Astronauta a) {
        tripulacion.add(a);
    }

    public Modulo getModulo(String nombre) {
        for (Modulo m : modulos) {
            if (m.nombre.equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    public void actualizarEnergia() {
        for (Modulo m : modulos) {
            if (m instanceof PPE) {
                PPE ppe = (PPE) m;// Convierte m a PPE para usar sus métodos
                energiaDisponible += ppe.generarEnergia();
            }
        }
    }

    public void consumirEnergia(double cantidad) {
        if (energiaDisponible >= cantidad) {
            energiaDisponible -= cantidad;
        } else {
            System.out.println("⚠ Energía insuficiente en el Gateway.");
        }
    }

    // Distribuye energía a módulos que la consumen (HALO, Laboratorio, etc.)
    public void distribuirEnergia() {
        for (Modulo m : modulos) {
            if (!(m instanceof PPE)) {
                double energiaConsumida = energiaDisponible * 0.15;
                energiaDisponible -= energiaConsumida;
                System.out.println("🔋 Módulo " + m.nombre + " consumió " + energiaConsumida + " unidades de energía.");
            }
        }
    }

    // Mostrar estado general del Gateway
    public void mostrarEstadoGeneral() {
        System.out.println("=== Estado del Gateway ===");
        System.out.println("Energía disponible: " + energiaDisponible);
        System.out.println("Tripulación a bordo: " + tripulacion.size());
        System.out.println("Módulos instalados:");
        for (Modulo m : modulos) {
            m.mostrarEstado();
        }
        System.out.println("=========================");
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Mision getMision() {
        return mision;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public List<Astronauta> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<Astronauta> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public Canadarm3 getBrazo() {
        return brazo;
    }

    public void setBrazo(Canadarm3 brazo) {
        this.brazo = brazo;
    }

    public double getEnergiaDisponible() {
        return energiaDisponible;
    }

    public void setEnergiaDisponible(double energiaDisponible) {
        this.energiaDisponible = energiaDisponible;
    }
    
    
    
}
