package Clases;

import java.util.List;

public class Planeta {
    private String nombre;
    private double distancia; // Para calcular tiempo de viaje
    private List<Objeto> muestras;
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

    /**
     * Recolecta una muestra del planeta para un astronauta.
     * @return true si la muestra se pudo recolectar, false si no estaba disponible.
     */
    public boolean recolectarMuestraPlaneta(Astronauta astronauta, Objeto muestra) {
        if (muestras.contains(muestra)) {
            muestras.remove(muestra);
            astronauta.reducirVitalidad(15);
            astronauta.aumentarMoral(3);
            System.out.println("✅ " + astronauta.getNombre() + " ha recolectado: " + muestra.getNombre());
            return true;
        } else {
            System.out.println("⚠️ La muestra " + muestra.getNombre() + " no está disponible en " + nombre);
            return false;
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getDistancia() { return distancia; }
    public List<Objeto> getMuestras() { return muestras; }
    public boolean isExplorado() { return explorado; }

    // Setter opcional para cambiar estado de exploración
    public void setExplorado(boolean explorado) { this.explorado = explorado; }
}
