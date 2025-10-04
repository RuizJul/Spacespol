/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Pedido {
    Objeto objeto;
    int tiempoIda;   // Días a la Tierra
    int tiempoVuelta; // Días de regreso
    boolean completado;
     private int diaPedido;

    public Pedido(Objeto objeto, int tiempoIda, int tiempoVuelta, boolean completado, int diaPedido) {
        this.objeto = objeto;
        this.tiempoIda = tiempoIda;
        this.tiempoVuelta = tiempoVuelta;
        this.completado = completado;
        this.diaPedido = diaPedido;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public int getTiempoIda() {
        return tiempoIda;
    }

    public void setTiempoIda(int tiempoIda) {
        this.tiempoIda = tiempoIda;
    }

    public int getTiempoVuelta() {
        return tiempoVuelta;
    }

    public void setTiempoVuelta(int tiempoVuelta) {
        this.tiempoVuelta = tiempoVuelta;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public int getDiaPedido() {
        return diaPedido;
    }

    public void setDiaPedido(int diaPedido) {
        this.diaPedido = diaPedido;
    }
    
    
    public int getDuracionTotal() {
        return tiempoIda + tiempoVuelta;
    }

    // Verifica si el pedido ya debería haber llegado según el día actual
    public void actualizarEstado(int diaActual) {
        if (diaActual >= diaPedido + getDuracionTotal()) {
            completado = true;
        }
    }

    @Override
    public String toString() {
        return "Pedido de " + objeto.getNombre() +
               " (Tipo: " + objeto.getTipo() + ")" +
               " | Duración total: " + getDuracionTotal() + " días" +
               " | Estado: " + (completado ? "Completado ✅" : "En curso 🚀");
    }
}

