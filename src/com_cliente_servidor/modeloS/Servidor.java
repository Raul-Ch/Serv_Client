/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.modeloS;


import com_cliente_servidor.controladorS.ControladorServidor;
//import com_cliente_servidor.vistaS.VistaS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author raulr
 */
public class Servidor extends Thread{
    ControladorServidor controlador;
    //puerto de nuestro servidor
    final int Puerto = 7000;
    ServerSocket sk = null;
    Socket socket = null;
    //VistaS vista;
    BufferedReader br;
    BufferedWriter bw;
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }
    
    public void abrirPuerto(){
        try {
            sk = new ServerSocket(Puerto);
        } catch (IOException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
            //vista.textoencaja("Error" + e);
        }
    }
    
   public void esperarAlCliente(){
        try {
            socket = sk.accept();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            //vista.textoencaja("Error" + ex);
        }
   }
   
    public void crearFlujos(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }  

    
}
