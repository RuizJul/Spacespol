
package Clases;

public class Astronauta {
    private String nombre;
    private int salud = 100;         
    private int vitalidad = 100;     
    private int privacidad = 100;    
    private int moral = 100; 
    private Modulo moduloActual;

    public Astronauta(String nombre) {
        this.nombre = nombre;
        this.moduloActual = null;
    }

    public double getProductividad() {
        double factorSalud = this.salud / 100.0;
        double factorVitalidad = this.vitalidad / 100.0;
        double factorPrivacidad = this.privacidad / 100.0;
        double factorMoral = this.moral / 100.0;
        return (factorSalud + factorVitalidad + factorPrivacidad + factorMoral) / 4.0;
    }

    // Métodos de acción
    public void descansar() {
        aumentarVitalidad(30);
        curarSalud(10);
        aumentarMoral(5);
        System.out.println(nombre + " ha descansado y recupera salud y energía.");
    }

    public void comer() {
        aumentarVitalidad(20);
        System.out.println(nombre + " ha comido y recupera energía.");
    }

    public void hacerExperimento(Gateway gateway) {
        reducirVitalidad(10);
        aumentarMoral(2);
        System.out.println(nombre + " realiza un experimento.");
        if (gateway.getMision() != null) {
            gateway.getMision().avanzarProgreso(5);
        }
    }

    public void recolectarMuestra(Planeta planeta, Objeto muestra) {
        if (planeta.getMuestras().contains(muestra)) {
            planeta.getMuestras().remove(muestra);
            reducirVitalidad(15);
            aumentarMoral(3);
            System.out.println(nombre + " recolectó: " + muestra.getNombre());
        } else {
            System.out.println("⚠ La muestra " + muestra.getNombre() + " no está disponible en " + planeta.getNombre());
        }
    }

    // Métodos para modificar atributos
    public void aumentarVitalidad(int cantidad) { vitalidad = Math.min(100, vitalidad + cantidad); }
    public void reducirVitalidad(int cantidad) { vitalidad = Math.max(0, vitalidad - cantidad); }
    public void curarSalud(int cantidad) { salud = Math.min(100, salud + cantidad); }
    public void modificarPrivacidad(int cantidad) { privacidad = Math.min(100, Math.max(0, privacidad + cantidad)); }
    public void aumentarMoral(int cantidad) { moral = Math.min(100, moral + cantidad); }
    public void reducirMoral(int cantidad) { moral = Math.max(0, moral - cantidad); }

    public void pasarDia() {
        reducirVitalidad(5);
        reducirMoral(1);
        modificarPrivacidad(-1);
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getSalud() { return salud; }
    public void setSalud(int salud) { this.salud = salud; }
    public int getVitalidad() { return vitalidad; }
    public void setVitalidad(int vitalidad) { this.vitalidad = vitalidad; }
    public int getPrivacidad() { return privacidad; }
    public void setPrivacidad(int privacidad) { this.privacidad = privacidad; }
    public int getMoral() { return moral; }
    public void setMoral(int moral) { this.moral = moral; }
    public Modulo getModuloActual() { return moduloActual; }
    public void setModuloActual(Modulo moduloActual) { this.moduloActual = moduloActual; }
}
