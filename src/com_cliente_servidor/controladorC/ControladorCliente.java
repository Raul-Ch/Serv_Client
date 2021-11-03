/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.controladorC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com_cliente_servidor.modeloC.Cliente;
import com_cliente_servidor.vistaC.VistaC;

/**
 *
 * @author raulr
 */
public class ControladorCliente implements ActionListener{
    VistaC vista;
    Cliente modelo;

    public ControladorCliente(VistaC vista, Cliente modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar() throws InterruptedException{
        vista.hacerVisible();
        //vista.inicializar();
        vista.textoencaja("Conectando con el Servidor...");
        Thread.sleep(1500);
        modelo.conectarConElServidor();   
        vista.textoencaja("Conectado al servidor.");
        Thread.sleep(1000);
        modelo.crearFlujos();
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case VistaC.ENVIAR:
                vista.textoencaja("Enviando paquete al cliente...");
               // modelo.enviarMensaje(vista.getMensajeAEnviar());
                vista.textoencaja("Paquete enviado.");
                break;
        }
    }
    
    public void textoencaja(String mensaje){
        vista.textoencaja(mensaje); 
    }
    
    public void textoencaja2(String mensaje){
        vista.textoencaja2(mensaje); 
    }
    
}

