
package Clases;
import java.util.*;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Inicializar Canadarm3 y Gateway
        Canadarm3 brazo = new Canadarm3();
        Gateway gateway = new Gateway(brazo);

        // 2. Crear módulos y agregarlos al Gateway
        HALO halo = new HALO(100, 500);
        Laboratorio laboratorio = new Laboratorio("Laboratorio", 50, 200);
        PPE ppe = new PPE(50, 100);
        Logistica logistica = new Logistica("Logística", 100, 300);

        gateway.agregarModulo(halo);
        gateway.agregarModulo(laboratorio);
        gateway.agregarModulo(ppe);
        gateway.agregarModulo(logistica);

        // 3. Crear tripulación
        Astronauta astro1 = new Astronauta("Alice");
        Astronauta astro2 = new Astronauta("Bob");
        gateway.agregarAstronauta(astro1);
        gateway.agregarAstronauta(astro2);

        // 4. Selección de misión
        System.out.println("Selecciona la misión:");
        System.out.println("1. Luna (365 días, dificultad 1.0)");
        System.out.println("2. Marte (730 días, dificultad 1.5)");
        int opcionMision = sc.nextInt();

        Mision mision;
        if (opcionMision == 1) {
            mision = new Mision("Luna", 365, 1.0, "Estudio de rocas lunares");
        } else {
            mision = new Mision("Marte", 730, 1.5, "Análisis de suelo marciano");
        }
        mision.asignarTripulacion(gateway.getTripulacion());
        gateway.setMision(mision);

        // 5. Crear planeta
        List<Objeto> muestrasPlaneta = new ArrayList<>();
        muestrasPlaneta.add(new Objeto("Roca1", 5, 2, "Muestra", false));
        muestrasPlaneta.add(new Objeto("Roca2", 3, 1, "Muestra", false));
        Planeta planeta = new Planeta(mision.getDestino(), 0, muestrasPlaneta, false);

        // 6. Ciclo de días
        int dia = 1;
        while (!mision.verificarExito() && !mision.verificarFracaso()) {
            System.out.println("\n=== Día " + dia + " ===");

            // Mostrar estado del Gateway
            gateway.mostrarEstadoGeneral();

            // Mostrar log diario
            System.out.println("Eventos del día anterior:");
            for (String log : mision.getLogDiario()) {
                System.out.println(log);
            }

            // Decisiones del jugador
            System.out.println("\nDecide qué hacer:");
            System.out.println("1. Descansar astronautas");
            System.out.println("2. Comer astronautas");
            System.out.println("3. Hacer experimentos en laboratorio");
            System.out.println("4. Recolectar muestras en el planeta");
            System.out.println("5. Reparar módulo con Canadarm3");
            System.out.println("6. Agregar pedido en logística");
            System.out.println("7. Avanzar día sin acciones");

            int accion = sc.nextInt();
            switch (accion) {
                case 1:
                    for (Astronauta a : gateway.getTripulacion()) a.descansar();
                    break;
                case 2:
                    for (Astronauta a : gateway.getTripulacion()) a.comer();
                    break;
                case 3:
                    laboratorio.realizarExperimento(gateway, logistica);
                    break;
                case 4:
                    for (Astronauta a : gateway.getTripulacion()) {
                        if (!planeta.getMuestras().isEmpty()) {
                            a.recolectarMuestra(planeta, planeta.getMuestras().get(0));
                        }
                    }
                    break;
                case 5:
                    brazo.reparar(laboratorio); // ejemplo: reparar laboratorio
                    break;
                case 6:
                    System.out.println("Ingrese nombre del objeto a pedir:");
                    sc.nextLine(); // limpiar buffer
                    String nombreObj = sc.nextLine();
                    Objeto obj = new Objeto(nombreObj, 5, 2, "Recurso", false);
                    logistica.agregarPedido(obj);
                    break;
                case 7:
                    System.out.println("Se avanza el día sin acciones.");
                    break;
                default:
                    System.out.println("Acción inválida.");
            }

            // Pasar el día
            for (Astronauta a : gateway.getTripulacion()) a.pasarDia();
            brazo.pasarDia();
            logistica.pasarDia();
            mision.avanzarDia();
            dia++;
        }

        // Resultado final
        if (mision.verificarExito()) {
            System.out.println("\n✅ ¡Misión completada con éxito!");
        } else {
            System.out.println("\n❌ La misión ha fracasado. Progreso: " + mision.getProgresoMision() + "%");
        }

        sc.close();
    }
}

    


