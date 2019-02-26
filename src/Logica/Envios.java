/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

public class Envios {
    String nombre;
    String respuesta;
    int Nproblemas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getNproblemas() {
        return Nproblemas;
    }

    public Envios() {
        this.nombre="";
        this.respuesta="";
        this.Nproblemas=0;
    }

    public Envios(String nombre, String respuesta, int Nproblemas) {
        this.nombre = nombre;
        this.respuesta = respuesta;
        this.Nproblemas = Nproblemas;
    }
    
    
    
}
