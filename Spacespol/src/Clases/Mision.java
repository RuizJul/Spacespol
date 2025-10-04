/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Mision {
    private String destino;          
    private int duracionDiasTotal;   
    private int diasRestantes;       
    private double progresoMision;   
    private double factorDificultad; 
    private String objetivoCientifico;

    
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
        }
    }

    
    /** Aumenta el progreso de la misión principal.
     * @param cantidad */
    public void avanzarProgreso(double cantidad) {
        this.progresoMision = Math.min(100.0, this.progresoMision + cantidad);
    }
    
    /** Verifica si se cumple la condición de éxito al finalizar el tiempo. */
    public boolean verificarExito() {
        // La victoria se logra si el tiempo se agota (supervivencia) Y se logra un avance considerable (ej: 80% o más)
        return (diasRestantes == 0 && progresoMision >= 80.0);
    }
    
    
    public String getDestino() { return destino; }
    public int getDiasRestantes() { return diasRestantes; }
    public double getProgresoMision() { return progresoMision; }
    public double getFactorDificultad() { return factorDificultad; }
    public String getObjetivoCientifico() { return objetivoCientifico; }
}


