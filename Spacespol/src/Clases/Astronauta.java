
package Clases;


public class Astronauta {
    private String nombre;
    private int salud = 100;         
    private int vitalidad = 100;     
    private int privacidad = 100;    
    private int  moral = 100; 
    private Modulo moduloActual;
    
    public Astronauta(String nombre) {
        this.nombre = nombre;
    }

    public double getProductividad() {
        double factorSalud = this.salud / 100.0;
        double factorVitalidad = this.vitalidad / 100.0;
        double factorPrivacidad = this.privacidad / 100.0;
        double factorMoral = this.moral / 100.0;
        return (factorSalud + factorVitalidad + factorPrivacidad + factorMoral) / 4.0;
    }
    
   //Metodos que puede realizar en la mision 
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
            gateway.getMision().avanzarProgreso(5); // cada experimento contribuye
        }
    }


    public void recolectarMuestras(Gateway gateway, Planeta planeta, Objeto muestra) {
        if(planeta.recolectarMuestraPlaneta(this, muestra)) {
            reducirVitalidad(15);
            aumentarMoral(3);
            System.out.println(nombre + " recolectó: " + muestra.getNombre());
            if (gateway.getMision() != null) {
                gateway.getMision().avanzarProgreso(5); // recolecta contribuye al progreso
            }
        }
    }

    
    public void aumentarVitalidad(int cantidad) {
        this.vitalidad = Math.min(100, this.vitalidad + cantidad);
    }

    public void reducirVitalidad(int cantidad) {
        this.vitalidad = Math.max(0, this.vitalidad - cantidad);
    }

    public void curarSalud(int cantidad) {
        this.salud = Math.min(100, this.salud + cantidad);
    }

    public void modificarPrivacidad(int cantidad) {
        this.privacidad = Math.min(100, Math.max(0, this.privacidad + cantidad));
    }

    public void aumentarMoral(int cantidad) {
        this.moral = Math.min(100, this.moral + cantidad);
    }

    public void reducirMoral(int cantidad) {
        this.moral = Math.max(0, this.moral - cantidad);
    }
      
    public void pasarDia() {
        // Disminuye ligeramente la vitalidad y moral por desgaste diario
        reducirVitalidad(5);
        reducirMoral(1);
        modificarPrivacidad(-1); // si no hay espacio personal, baja privacidad
    }
    
    private void avanzarMisionPrincipal(double cantidad) {
        if (moduloActual instanceof HALO) {
            HALO halo = (HALO) moduloActual;
            if (halo.mision != null) {
                halo.mision.avanzarProgreso(cantidad);
            }
        }
    }
    
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(int privacidad) {
        this.privacidad = privacidad;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public Modulo getModuloActual() {
        return moduloActual;
    }

    public void setModuloActual(Modulo moduloActual) {
        this.moduloActual = moduloActual;
    }
    
    
}
