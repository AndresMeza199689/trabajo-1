/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Concurso {
    String nombre;
    int numeroProblemas;
    ArrayList<Envios> listEnvios;
    ArrayList<String>listEquipos;
    
    public Concurso(String nombre){
        this.nombre=nombre;
        this.numeroProblemas=5;
        
        this.listEnvios=new  ArrayList<>();
        this.listEquipos=new ArrayList<>();
    }

    public Concurso(String nombre, int numeroProblemas) {
        this.nombre = nombre;
        this.numeroProblemas = numeroProblemas;
        this.listEnvios=new  ArrayList<>();
        this.listEquipos=new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroProblemas() {
        return numeroProblemas;
    }

    public ArrayList<Envios> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(ArrayList<Envios> listEnvios) {
        this.listEnvios = listEnvios;
    }
    public void setListEquipos(ArrayList<String> e){
        this.listEquipos=e;
    }

    public void setNumeroProblemas(int numeroProblemas) {
        this.numeroProblemas = numeroProblemas;
    }

    public ArrayList<String> getListEquipos() {
        return listEquipos;
    }
    public boolean registarEnvio(String nombre,int numProb,String resp){
        if(this.listEquipos.contains(nombre)){
            if(numProb<this.numeroProblemas){
                if(!resp.equals("")){
                    this.listEnvios.add(new Envios(nombre, resp, numProb));
                    JOptionPane.showMessageDialog(null, "envio registrado");
                    return false;
                }else{
                    JOptionPane.showMessageDialog(null, "respuesta vacia ");
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "indice del problema exedido");
            }
        }else{
            return false;
        }
        return true;
    }
    
}
