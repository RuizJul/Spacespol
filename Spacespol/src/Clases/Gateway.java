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
public class Gateway {

    List<Modulo> modulos;
    List<Astronauta> tripulacion;
    Canadarm3 brazo;
    double energiaDisponible;

    public Gateway(Canadarm3 brazo) {
        this.brazo = brazo;
        this.energiaDisponible = 0;
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
}
