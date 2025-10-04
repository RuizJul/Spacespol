/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Julian
 */
public class Canadarm3 {
    boolean disponible;
    int diasRestantes=0;

    public void reparar(Modulo modulo){
        if(disponible){
            modulo.estado += 25; // mejora el estado del módulo
            diasRestantes = 3;   // 3 días de ocupación
            disponible = false;
            System.out.println("Canadarm3 está reparando " + modulo.nombre + " por 3 días.");
        }
        System.out.println("Canadarm3 no está disponible. Tiempo restante: " + diasRestantes + " días.");
    }
    
    public void moverObjeto(Objeto obj, Modulo origen, Modulo destino){
        
    }
}
