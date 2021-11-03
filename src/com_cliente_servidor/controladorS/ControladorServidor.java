/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.controladorS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com_cliente_servidor.modeloS.Servidor;
import com_cliente_servidor.vistaS.VistaS;

/**
 *
 *
 */
public class ControladorServidor implements ActionListener {
    VistaS vista;
    Servidor modelo;

    public ControladorServidor(VistaS vista, Servidor modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar() throws InterruptedException{
        vista.hacerVisible();
        vista.inicializar();
        vista.textoencaja("Abriendo el puerto 7000...");
        modelo.abrirPuerto();
        vista.textoencaja("Creando Socket\n");
        Thread.sleep(1000);
        vista.textoencaja("-------------------");
        vista.textoencaja("|Servidor iniciado|");
        vista.textoencaja("-------------------\n");
        vista.textoencaja("Esperando al cliente...");
        modelo.esperarAlCliente();
        modelo.crearFlujos();
        vista.textoencaja("Estado Cliente -> Conectado Listo Para el Intercambio");
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case VistaS.ENVIAR:
                modelo.enviarMensaje(vista.getMensajeAEnviar_paquete());
                modelo.enviarMensaje(vista.getMensajeAEnviar_int());
                modelo.enviarMensaje(vista.getMensajeAEnviar_bool());
                modelo.enviarMensaje(vista.getMensajeAEnviar_byte());
                modelo.enviarMensaje(vista.getMensajeAEnviar_char());
                modelo.enviarMensaje(vista.getMensajeAEnviar_long());
                modelo.enviarMensaje(vista.getMensajeAEnviar_float());
                modelo.enviarMensaje(vista.getMensajeAEnviar_double());
                modelo.enviarMensaje(vista.getMensajeAEnviar_array());
                modelo.enviarMensaje(vista.getMensajeAEnviar_string());
                vista.textoencaja("Paquete enviado.");
                break;
        }
    }
    
    public void textoencaja(String mensaje){
        vista.textoencaja(mensaje);
    }
    
}
