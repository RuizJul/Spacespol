/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Julian
 */
public class Logistica extends Modulo {

    private boolean enViaje;        // indica si el módulo está viajando
    private int diasRestantesViaje; // días que faltan para que regrese
    private List<Objeto> pedidosPendientes = new ArrayList<>(); // objetos solicitados

    public Logistica(String nombre, double capacidad, double pesoMaximo) {
        super.nombre = nombre;
        super.capacidad = capacidad;
        super.pesoMaximo = pesoMaximo;
        super.usado = 0;
        super.pesoActual = 0;
        super.estado = 100;
        super.estadoCritico = false;
        super.inventario = new ArrayList<>();
        this.enViaje = false;
        this.diasRestantesViaje = 0;
    }

    // Sobrescribir mostrarEstado para información específica de Logística
    @Override
    public void mostrarEstado() {
        System.out.println("=== Módulo Logístico ===");
        System.out.println("Estado general: " + estado + "%");
        if (estadoCritico) {
            System.out.println("⚠ Estado crítico!");
        }
        System.out.println("Espacio usado: " + usado + " / " + capacidad);
        System.out.println("Peso actual: " + pesoActual + " / " + pesoMaximo);
        if (enViaje) {
            System.out.println("🚀 En viaje. Días restantes para regresar: " + diasRestantesViaje);
        } else {
            System.out.println("🛰 En el Gateway, listo para recibir o enviar carga.");
        }
        System.out.println("Pedidos pendientes: " + pedidosPendientes.size());
    }

    // Agregar pedido
    public void agregarPedido(Objeto obj) {
        if (!enViaje) {
            pedidosPendientes.add(obj);
            System.out.println("📦 Pedido agregado: " + obj.getNombre());
        } else {
            System.out.println("⚠ No se pueden agregar pedidos mientras el módulo logístico está en viaje.");
        }
    }

    // Iniciar el viaje
    public void iniciarViaje() {
        if (!enViaje && !pedidosPendientes.isEmpty()) {
            enViaje = true;

            Random rand = new Random();
            int ida = rand.nextInt(6) + 5;   // 5 a 10 días
            int vuelta = rand.nextInt(6) + 10; // 10 a 15 días
            diasRestantesViaje = ida + vuelta;

            System.out.println("🚀 Módulo logístico partió a la Tierra.");
        } else if (pedidosPendientes.isEmpty()) {
            System.out.println("⚠ No hay pedidos pendientes para enviar.");
        } else {
            System.out.println("⚠ El módulo logístico ya está en viaje.");
        }
    }

    // Simular el paso de un día
    public void pasarDia() {
        if (enViaje) {
            diasRestantesViaje--;
            if (diasRestantesViaje <= 0) {
                enViaje = false;
                recibirPedidos();
                System.out.println("🛰️ El módulo logístico ha regresado con la carga.");
            }
        }
    }

    // Recibir los pedidos una vez completado el viaje
    private void recibirPedidos() {
        inventario.clear();
        inventario.addAll(pedidosPendientes);
        pedidosPendientes.clear();
    }

    public boolean isEnViaje() {
        return enViaje;
    }

    // Consumir recurso específico (usado por el laboratorio)
    public boolean consumirRecurso(String nombreRecurso) {
        for (Objeto obj : inventario) {
            if (obj.getNombre().equalsIgnoreCase(nombreRecurso)) {
                inventario.remove(obj);
                usado -= obj.getEspacio();
                pesoActual -= obj.getPeso();
                System.out.println("🔬 Recurso consumido del módulo logístico: " + nombreRecurso);
                return true;
            }
        }
        System.out.println("⚠ Recurso no encontrado: " + nombreRecurso);
        return false;
    }
}
