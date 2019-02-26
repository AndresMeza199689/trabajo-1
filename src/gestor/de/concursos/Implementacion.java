/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.de.concursos;

import Logica.Concurso;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Implementacion {
    ArrayList<Concurso> concursos;

    public Implementacion() {
        this.concursos=new ArrayList<>();
    }
    private boolean menu(){
        System.out.println("****Principal Menu****");
        System.out.println("1) Agregar Concursos");
        System.out.println("2) listar Concursos");
        System.out.println("3) Eliminar Concursos");

        int op=Integer.parseInt(JOptionPane.showInputDialog("Dijite una Opcion"));
        System.out.println("------------------------------------------------------------------------------------------");
        if(op >0 && op<5){
            switch(op){
                case 1:{
                    this.AgregarConcurso();
                    break;
                }
                case 2:{
                    this.listarConcursos();
                    break;
                }
                case 3:{
                    this.eliminarC();
                    break;
                }
                case 4:{
                   
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Opcion no valida");
        }
        return false;
    }
    public void run(){
        while(!menu()){
            
        }
    }
//------------------------------------------------------Agregar concursos -----------------------------------------------------------------------------
    private void  AgregarConcurso(){
        System.out.println("1) agregar nombre y numero de problemas");
        System.out.println("2) agregar nombre");
        int op =Integer.parseInt(JOptionPane.showInputDialog("elija una opcion :"));
        
        while(op>3 && op<0){
            JOptionPane.showMessageDialog(null,"Opccion invalida ");
            System.out.println("1) agregar nombre y numero de problemas");
            System.out.println("2) agregar nombre");
            op =Integer.parseInt(JOptionPane.showInputDialog("elija una opcion :"));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
        String nom=JOptionPane.showInputDialog("Ingrese Nombre :");
        while(!addDataConcurso(nom)){
            nom=JOptionPane.showInputDialog("este nombre ya existe, Ingrese Nombre :");
        }
        if(op==1){
            this.concursos.add(new Concurso(nom, Integer.parseInt(JOptionPane.showInputDialog("ingrese un numero de problemas :"))));
        }else if(op==2){
            this.concursos.add(new Concurso(nom));
        }
    }
    private boolean addDataConcurso(String nombre){
        boolean sw=true;
        for (int i = 0; i < this.concursos.size(); i++) {
            if(this.concursos.get(i).getNombre().equals(nombre)){
                JOptionPane.showMessageDialog(null, "este nombre de concurso ya se encuentra registrado ");
                sw = false;
            }
        }
        return sw;
    }
 //----------------------------------------------------Listar concursos ----------------------------------------------------------------------------------
   
    private void listarConcursos(){
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i=0;i<this.concursos.size();i++) {
            System.out.println((i+1)+") Nombre :"+this.concursos.get(i).getNombre());
        }
        int op=Integer.parseInt(JOptionPane.showInputDialog("inserte una opccion :"))-1;
        while(op>this.concursos.size() || op<0){
            op=Integer.parseInt(JOptionPane.showInputDialog("error de index inserte una opccion valida:"));
        }
        System.out.println("-------------------------------------------------------------------------------------");
        while(submenu(op)){
            System.out.println("-------------------------------------------------------------------------");

        }
            
        
    }
    private boolean submenu(int o) {
 
        
        boolean sw=true;
        Concurso c=this.concursos.get(o);

        int op=0;
        System.out.println("****Submenu +"+c.getNombre()+"****");
        System.out.println("1) editar nombre del concurso");
        System.out.println("2) agregar equipos ");
        System.out.println("3) ver nombre de los equipos");
        System.out.println("4) envios ");
        System.out.println("5) atras");
        op=Integer.parseInt(JOptionPane.showInputDialog("elija una opccion"));
         while(op>5 || op<1){
             op=Integer.parseInt(JOptionPane.showInputDialog("error eleccion invalida  elija una opccion"));
         }
         switch(op){

            case 1:{
                this.cambiarNombreConcurso(c);
                break;
            }
            case 2:{
                c.setListEquipos(this.getNomEquipos());
                break;
            }
            case 3:{
                this.listarEquipos(c);
                break;
            }
            case 4:{
                System.out.println("-----------------------------------------------");
                this.envios(c);
                break;
            }
            case 5:{
                sw=false;
            }
        }
        this.concursos.set(o, c);
        
        return sw;
    }
  
    

    //------------------------------------------------------------Editar Concurso---------------------------------------------------------

    private void cambiarNombreConcurso(Concurso c) {
        c.setNombre(JOptionPane.showInputDialog("Nuevo nombre para :"+c.getNombre()));
    }    
    
    private ArrayList<String> getNomEquipos(){
        int x=Integer.parseInt(JOptionPane.showInputDialog("Dijite la cantidad de equipos que habra en este concurso :"));
        ArrayList<String> aux=new ArrayList<>();
        for (int j = 0; j < x; j++) {
            
            String a=(JOptionPane.showInputDialog("nombre del equipo :"+j));
            if(aux.contains(a)){
                JOptionPane.showMessageDialog(null,"Uno de lo equipos ya se encuentra registrado con este mismo nombre "+a);
                j=j-1;
            }else{
                aux.add(a);
                System.out.println("se ha Agregado "+aux.get(aux.size()-1));
            }
        }
        return aux;
    }
 
    private void listarEquipos(Concurso c) {
        System.out.println("-------------------------------------");
        if(c.getListEquipos().size()>0){
            for (int i = 0; i < c.getListEquipos().size(); i++) {
                System.out.println("Nombre :"+c.getListEquipos().get(i));
            }
        }
        System.out.println("-------------------------------------");
        
    }
    
    private void editarNumPronlemas(Concurso c) {  
        int x=Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de problemas para el concurso "+c.getNombre()));
        c.setNumeroProblemas(x);
    }
    
    //--------------------------------------------------------ELIMINAR-------------------------------------------------------------------

    private void eliminarC() {
        if(this.concursos.size()>0){
            int op=Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el indice del concurso que desea eliminar"));
            while(op<1 ||op>this.concursos.size()){
                op=Integer.parseInt(JOptionPane.showInputDialog(null,"error eleccion invalida ingrese l indice del concurso que desea eliminar"));
            }
            deleteC(op);
        }else{
            JOptionPane.showMessageDialog(null,"no existe ningun concurso en la lista");
        }
    }
    private boolean deleteC(int o){
        return null!=this.concursos.remove(o);
    }

    private void envios(Concurso c) {
        System.out.println("1) agregar envio");
        System.out.println("2) ver envios ");
        int op=Integer.parseInt(JOptionPane.showInputDialog("elija una opccion "));
        while(op>2 ||  op<1){
            op = Integer.parseInt(JOptionPane.showInputDialog("error de indice elija una opccion valida "));
        }
        switch(op){
            case 1:{
                c.registarEnvio(JOptionPane.showInputDialog("ingrese el nombre del equipo"), Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero del problema") ),JOptionPane.showInputDialog("ingrse su respuesta"));
                break;
            }
            case 2:{
                System.out.println("--------------------------------------------");
                for(int i=0;i<c.getListEnvios().size();i++){
                    System.out.println("nombre equipo :"+c.getListEnvios().get(i).getNombre()+" numero de problema "+c.getListEnvios().get(i).getNproblemas()+" respuesta :"+c.getListEnvios().get(i).getRespuesta());
                }
            }
            
        }
    }
    

}
