/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.modeloC;

import com_cliente_servidor.controladorC.ControladorCliente;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author raulr
 */
public class Cliente extends Thread{
    ControladorCliente controlador;
    //puerto de nuestro servidor
    final int Puerto = 7000;
    final String Host = "localhost"; //or "192.168.0.3 or 192.168.0.2"
    public static Socket socket;
    BufferedReader br;
    
    public void setControlador(ControladorCliente controlador){
        this.controlador = controlador;
    }
    
    public void conectarConElServidor() throws InterruptedException{
        try {
            socket = new Socket(Host, Puerto);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            controlador.textoencaja("Error" + ex);
            controlador.textoencaja("Cierre en 3,2,1 ...");
            Thread.sleep(5000);
            System.exit(0);
        }
    }

    public void crearFlujos(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public String recibirMensaje_paquete(){
        try {
            String mensaje_paquete = br.readLine();
            return mensaje_paquete;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_int(){
        try {
            String mensaje_int = br.readLine();
            return mensaje_int;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
  
    public String recibirMensaje_bool(){
        try {
            String mensaje_bool = br.readLine();
            return mensaje_bool;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_byte(){
        try {
            String mensaje_byte = br.readLine();
            return mensaje_byte;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_char(){
        try {
            String mensaje_char = br.readLine();
            return mensaje_char;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_long(){
        try {
            String mensaje_long = br.readLine();
            return mensaje_long;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_float(){
        try {
            String mensaje_float = br.readLine();
            return mensaje_float;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String recibirMensaje_double(){
        try {
            String mensaje_double= br.readLine();
            return mensaje_double;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String mensaje_array(){
        try {
            String mensaje_array = br.readLine();
            return mensaje_array;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirMensaje_string(){
        try {
            String mensaje_string = br.readLine();
            return mensaje_string;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public void run(){
        boolean bucle;
            /*String mensaje2 = "-> Cliente Conectado";
            String mensaje3 = "-> Consumir el Paquete Seleccionado por el Servidor";
            controlador.textoencaja("\nEl Servidor dice: " + mensaje2);
            controlador.textoencaja("\nEl Servidor dice: " + mensaje3);*/
        while(bucle = true){
           /* 
            if(bucle!=true){
                try {
                   controlador.textoencaja("Cliente cerrando socket .... termina la aplicacion..");
                    br.close();
                    socket.close();              
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            String mensaje_paquete = recibirMensaje_paquete();
            controlador.textoencaja2("\n_______________________________________");
            controlador.textoencaja2("El Servidor envia el paquete: " + mensaje_paquete);
            String mensaje_int = recibirMensaje_int();
            controlador.textoencaja2("Recibido el int: " + mensaje_int);
            String mensaje_bool = recibirMensaje_bool();
            controlador.textoencaja2("Recibido el bool: " + mensaje_bool);
            String mensaje_byte = recibirMensaje_byte();
            controlador.textoencaja2("Recibido el byte: " + mensaje_byte);
            String mensaje_char = recibirMensaje_char();
            controlador.textoencaja2("Recibido el char: " + mensaje_char);
            String mensaje_long = recibirMensaje_long();
            controlador.textoencaja2("Recibido el long: " + mensaje_long);
            String mensaje_float = recibirMensaje_float();
            controlador.textoencaja2("Recibido el float: " + mensaje_float);
            String mensaje_double = recibirMensaje_double();
            controlador.textoencaja2("Recibido el double: " + mensaje_double);
            String mensaje_array = mensaje_array();
            controlador.textoencaja2("Recibido el array: " + mensaje_array);
            String mensaje_string = recibirMensaje_string();
            controlador.textoencaja2("Recibido el string: " + mensaje_string);
            controlador.textoencaja2("_______________________________________\n");
        
        }
        
    }
    
    
    
}

