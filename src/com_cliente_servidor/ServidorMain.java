/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor;


import com_cliente_servidor.controladorS.ControladorServidor;
import com_cliente_servidor.modeloS.Servidor;
import com_cliente_servidor.vistaS.VistaS;
import com_cliente_servidor.vistaS.ServidorFrame;

 
public class ServidorMain {
    
    public static void main(String[] args) throws InterruptedException {
        VistaS vista = new ServidorFrame();
        Servidor modelo = new Servidor();
        
        ControladorServidor controlador = new ControladorServidor(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
   
}