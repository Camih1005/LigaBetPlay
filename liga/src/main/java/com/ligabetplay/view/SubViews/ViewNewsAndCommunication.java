package com.ligabetplay.view.SubViews;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.model.Announcement;
import com.ligabetplay.view.ShowValues;
import com.ligabetplay.view.Validation;

public class ViewNewsAndCommunication {

    Controller controlador = Controller.getInstance();
    Scanner sc = controlador.sc;
    ShowValues mostrar = new ShowValues();

    public void start(){
        
        
        int choice = 0;
        System.out.println("Gestión de Noticias y Comunicados");

        while (true) {
            System.out.println("\n1. Agregar Comunicado");
            System.out.println("2. Editar Comunicado");
            System.out.println("3. Eliminar Comunicado");
            System.out.println("4. Volver");

            choice = Integer.parseInt(Validation.leerdato("Elija una opcion: ", controlador.sc));
            System.out.println("\n");
          

            switch (choice) {
                case 1:
                    addAnnouncement();
                    break;
                case 2:
                    editAnnouncement();
                    break;
                case 3:
                    deleteAnnouncement();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Campo no Valido");
                    break;
            }
        
        }

    }

    public void addAnnouncement(){
        Announcement comunicacion = new Announcement();
        Integer codigoComunicacion = Validation.leerNumero("Digite el id del comunicado: ", sc);

        if((controlador.comunicaciones.containsKey(codigoComunicacion))){
            System.out.println("Codigo ya Existe");    
            return;
        }

        comunicacion.setId(codigoComunicacion);
        comunicacion.setTitulo(Validation.leerdato("Digite el titulo del comunicado: ", sc));
        comunicacion.setContenido(Validation.leerdato("Digite el contenido del comunicado: ", sc));
        comunicacion.setFechaPublicacion(Validation.leerdato("Digite la fecha del comunicado: ", sc));
        controlador.comunicaciones.put(codigoComunicacion, comunicacion);

        boolean mostrarUsuarios = mostrar.showUser();
        Boolean bandera = true;
        if(mostrarUsuarios==false){ bandera = false; }
            if(bandera==true){
                int codigoUsuario = Validation.leerNumero("Digite el codigo del destinatario: ",sc);
                if(!controlador.usuarios.containsKey(codigoUsuario)){ System.out.println("Error codigo no valido"); bandera=false; return;}
                    if(bandera==true){
                    comunicacion.setDestinatarios(controlador.usuarios.get(codigoUsuario));
                    System.out.println("Destinatario añadido");}   
            }
        
            controlador.comunicaciones.put(codigoComunicacion, comunicacion);
            System.out.println("---------------------------------");
            System.out.println("Creacion del comunicado exitosa");  
            System.out.println("---------------------------------");
            
        return;
    }

    public void editAnnouncement(){
         
        boolean mostrarComunicados = mostrar.showAnnouncements();
        if(mostrarComunicados==false){
            return;
        }

        int codigoComunicado = Validation.leerNumero("Digite el comunicado a actualizar: ",sc);
        if(!controlador.jugadores.containsKey(codigoComunicado)){
            System.out.println("Error codigo no valido");
            return ;
        }

        Announcement comunicado = controlador.comunicaciones.get(codigoComunicado);

        System.out.println("Campos de Comunicados");
        System.out.println("1. Titulo");
        System.out.println("2. Contenido");
        System.out.println("3. Fecha Publicacion");
        System.out.println("4. Volver");

        int opcion = Validation.leerNumero("Digite la opcion que desea editar: ",sc);


        switch (opcion) {
            case 1:
                System.out.println("Campo Actual: " + comunicado.getTitulo());
                comunicado.setTitulo(Validation.leerdato("Digite el titulo del comunicado: ",sc ));
                break;
            case 2:
                System.out.println("Campo Actual: " + comunicado.getContenido());
                comunicado.setContenido(Validation.leerdato("Digite el contenido del comunicado: ",sc ));
                break;
            case 3:
                System.out.println("Campo Actual: " + comunicado.getFechaPublicacion());
                comunicado.setFechaPublicacion(Validation.leerdato("Digite la fecha de publicacion del comunicado: ",sc ));
                break;
            case 4:
                return;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        System.out.println("---------------------------------");
        System.out.println("Campo actualizado  exitosamente");
        System.out.println("---------------------------------");
        return;

    }

    public void deleteAnnouncement(){
           
        boolean mostrarcomunicados = mostrar.showAnnouncements();
        if(mostrarcomunicados==false){
            return;
        }

        int codigoComunicacion = Validation.leerNumero("\nDigite el id del comunicado: ",sc);
        if(!controlador.jugadores.containsKey(codigoComunicacion)){
            System.out.println("Error codigo no valido");
            return ;
        }

        controlador.comunicaciones.remove(codigoComunicacion);
        System.out.println("Comunicado eliminado con exito");
    }
}
