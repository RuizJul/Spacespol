
package Clases;

import java.util.ArrayList;
import java.util.List;


public class Mision {
    private String destino;          
    private int duracionDiasTotal;   
    private int diasRestantes;       
    private double progresoMision;   
    private double factorDificultad; 
    private String objetivoCientifico;
    
    private List<Astronauta> tripulacion = new ArrayList<>();
    private List<String> objetivosSecundarios = new ArrayList<>();
    private List<String> logDiario = new ArrayList<>();

    
    public Mision(String destino, int duracionDias, double factorDificultad, String objetivoCientifico) {
        this.destino = destino;
        this.duracionDiasTotal = duracionDias;
        this.diasRestantes = duracionDias;
        this.progresoMision = 0.0;
        this.factorDificultad = factorDificultad;
        this.objetivoCientifico = objetivoCientifico;
    }
    
    
    /** Avanza un día en el contador de la misión. */
    public void avanzarDia() {
        if (diasRestantes > 0) {
            diasRestantes--;
            logDiario.add("Día avanzado. Días restantes: " + diasRestantes);
            eventoDiario();
        }
    }

    
    public void avanzarProgreso(double cantidad) {
        double progresoReal = cantidad * factorDificultad;
        progresoMision = Math.min(100.0, progresoMision + progresoReal);
        logDiario.add("Progreso avanzado: " + progresoReal + "%. Total: " + progresoMision + "%");
    }
    
    //Tripulacion
     public void asignarTripulacion(List<Astronauta> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public List<Astronauta> getTripulacion() {
        return tripulacion;
    }
    
    //Objeto 
    public void agregarObjetivoSecundario(String objetivo) {
        objetivosSecundarios.add(objetivo);
    }

    public List<String> getObjetivosSecundarios() {
        return objetivosSecundarios;
    }
    
    
    // Log diario
     public void agregarLog(String mensaje) {
        logDiario.add(mensaje);
    }

    public List<String> getLogDiario() {
        return logDiario;
    }
    
    //Eventos que pueden ocurrir aleatoriamente
     public void eventoDiario() {
        double probabilidad = Math.random();
        if (probabilidad < 0.1) { // 10% de probabilidad de evento
            String evento = "⚠️ Evento inesperado: fallo en módulo PPE.";
            logDiario.add(evento);
            System.out.println(evento);
            // Opcional: reducir progreso, vitalidad o moral
            for (Astronauta a : tripulacion) {
                a.reducirVitalidad(5);
                a.reducirMoral(2);
            }
        }
    }
     
    /** Verifica si se cumple la condición de éxito al finalizar el tiempo. */
     public boolean verificarExito() {
        return diasRestantes == 0 && progresoMision >= 80.0;
    }

    public boolean verificarFracaso() {
        return diasRestantes == 0 && progresoMision < 80.0;
    }

    public Mision(String destino, int duracionDiasTotal, int diasRestantes, double progresoMision, double factorDificultad, String objetivoCientifico) {
        this.destino = destino;
        this.duracionDiasTotal = duracionDiasTotal;
        this.diasRestantes = diasRestantes;
        this.progresoMision = progresoMision;
        this.factorDificultad = factorDificultad;
        this.objetivoCientifico = objetivoCientifico;
    }
    
    public String getDestino(){
        return this.destino;
    }
    
    public double getProgresoMision(){
        return this.progresoMision;
    }
    
}


