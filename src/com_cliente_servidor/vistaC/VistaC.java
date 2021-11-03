/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor.vistaC;

import com_cliente_servidor.controladorC.ControladorCliente;

/**
 *
 * @author raulr
 */
public interface VistaC {
    final String ENVIAR = "ENVIAR";

    public void textoencaja(String mensaje);
    public void setControlador(ControladorCliente controlador);
    public void hacerVisible();
    //public void inicializar();
    //public void Consumir();
    public void textoencaja2(String mensaje);
}

