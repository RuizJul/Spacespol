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
            if(modulo.estado<=30){
                modulo.estadoCritico= true;
            }
        }else{
            System.out.println("Canadarm3 no está disponible. Tiempo restante: " + diasRestantes + " días.");
    
        }
    }
    
    
    
    public void pasarDia() {
        if(!disponible) {
            diasRestantes--;
            if(diasRestantes <= 0) {
                disponible = true;
                System.out.println("Canadarm3 ya está disponible.");
            }
        }
    }
    
    
    public void moverObjeto(Objeto obj, Modulo origen, Modulo destino){
        if(!disponible){
            System.out.println("Canadarm3 no está disponible.");
            return;
        }

        if(!origen.inventario.contains(obj)){
            System.out.println("El módulo " + origen.nombre + " no contiene " + obj.getNombre());
            return;
        }

        if(destino.usado + obj.getEspacio() > destino.capacidad || destino.pesoActual + obj.getPeso() > destino.pesoMaximo){
            System.out.println("No hay suficiente espacio o peso en " + destino.nombre + " para " + obj.getNombre());
            return;
        }

        origen.inventario.remove(obj);
        origen.usado -= obj.getEspacio();
        origen.pesoActual -= obj.getPeso();

        destino.inventario.add(obj);
        destino.usado += obj.getEspacio();
        destino.pesoActual += obj.getPeso();

        System.out.println(obj.getNombre() + " movido de " + origen.nombre + " a " + destino.nombre);

    }
}
