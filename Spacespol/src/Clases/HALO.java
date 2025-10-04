package Clases;

import java.util.ArrayList;
import java.util.List;

public class HALO extends Modulo {

    public HALO(double capacidad, double pesoMaximo) {
        this.nombre = "HALO";
        this.capacidad = capacidad;
        this.pesoMaximo = pesoMaximo;
        this.usado = 0;
        this.pesoActual = 0;
        this.estado = 100;
        this.estadoCritico = false;
        this.inventario = new ArrayList<>();
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

    // Método para remover objeto
    public boolean removerObjeto(Objeto obj) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNombre().equals(obj.getNombre())) {
                usado -= inventario.get(i).getEspacio();
                pesoActual -= inventario.get(i).getPeso();
                inventario.remove(i);
                if (usado < 0) usado = 0;
                if (pesoActual < 0) pesoActual = 0;
                return true;
            }
        }
        System.out.println("El objeto " + obj.getNombre() + " no se encuentra en el HALO.");
        return false;
    }

    // Asignar actividad a la tripulación desde el Gateway
    public void asignarActividad(String actividad, Gateway gateway) {
        System.out.println("Astronautas realizan: " + actividad);

        // Verificar que la tripulación y la misión existan
        if (gateway != null && gateway.getTripulacion() != null && !gateway.getTripulacion().isEmpty()) {
            for (Astronauta a : gateway.getTripulacion()) {
                a.hacerExperimento(gateway); // cada astronauta realiza la actividad
            }
        }
    }

    @Override
    public void mostrarEstado() {
        System.out.println("=== Módulo HALO ===");
        System.out.println("Estado general: " + estado + "%");
        if (estadoCritico) {
            System.out.println("⚠ Estado crítico!");
        }
        System.out.println("Espacio usado: " + usado + " / " + capacidad);
        System.out.println("Peso actual: " + pesoActual + " / " + pesoMaximo);
        System.out.println("Astronautas pueden realizar: comer, descansar, preparar misión");
    }
}
