
package Clases;


public class Astronauta {
    private String nombre;
    private int salud = 100;         
    private int vitalidad = 100;     
    private int privacidad = 100;    
    private int fatiga = 0; 

    public Astronauta(String nombre) {
        this.nombre = nombre;
    }

    public double getProductividad() {
        double factorSalud = this.salud / 100.0;
        double factorFatiga = 1.0 - (this.fatiga / 100.0);
        return Math.min(factorSalud, factorFatiga); 
    }
    
    
    public void aumentarVitalidad(int cantidad) {
        this.vitalidad = Math.min(100, this.vitalidad + cantidad);
    }
    
    public void curarSalud(int cantidad) {
        this.salud = Math.min(100, this.salud + cantidad);
    }
    
    public void reducirFatiga(int cantidad) {
        this.fatiga = Math.max(0, this.fatiga - cantidad);
    }
    
    public void modificarPrivacidad(int cantidad) {
        this.privacidad = Math.min(100, Math.max(0, this.privacidad + cantidad));
    }

    
    //Cuando haya un modulo especifico que solicite cambiar estos atributos
    public void setSalud(int salud) { 
        this.salud = salud; 
    }
    public void setFatiga(int fatiga) { 
        this.fatiga = fatiga; 
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
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

    public int getFatiga() {
        return fatiga;
    }
    
    
    
    
    void comer(){
    }
    void descansar(){
        
    }
//    void hacerExperimento(Cientifico modulo){
//        
//    }
    void recolectarMuestras(Planeta planeta){
        
    }
}
