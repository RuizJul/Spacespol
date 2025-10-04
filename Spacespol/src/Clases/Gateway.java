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
    Canadarm3 brazo;

    void enviarPedido(Pedido pedido); // Maneja pedidos de logística
    void repararModulo(Modulo modulo); // Usa Canadarm3
}
