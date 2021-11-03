/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.vistaS;

import com_cliente_servidor.controladorS.ControladorServidor;

/**
 *
 * @author raulr
 */
public interface VistaS {
    final String ENVIAR = "ENVIAR";
    
    public void textoencaja(String mensaje);
    public void setControlador(ControladorServidor controlador);
    public void hacerVisible();
    //public String AsignarPaquetes();
    public void inicializar();
    public String getMensajeAEnviar_paquete();
    public String getMensajeAEnviar_int();
    public String getMensajeAEnviar_bool();
    public String getMensajeAEnviar_byte();
    public String getMensajeAEnviar_char();
    public String getMensajeAEnviar_long();
    public String getMensajeAEnviar_float();
    public String getMensajeAEnviar_double();
    public String getMensajeAEnviar_array();
    public String getMensajeAEnviar_string();
    
}
