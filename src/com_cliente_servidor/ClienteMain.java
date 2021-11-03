/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_cliente_servidor;

import com_cliente_servidor.controladorC.ControladorCliente;
import com_cliente_servidor.modeloC.Cliente;
import com_cliente_servidor.vistaC.ClienteFrame;
import com_cliente_servidor.vistaC.VistaC;

public class ClienteMain {
 
    public static void main(String[] args) throws InterruptedException {
        //Cliente
        VistaC vista = new ClienteFrame();
        Cliente modelo = new Cliente();
        
        ControladorCliente controlador = new ControladorCliente(vista,modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
 
    }
 
}



/*
        System.out.println("----------------");
        System.out.println("|ClienteMain Activo|");
        System.out.println("----------------");
        
        //Host del servidor
        final String Host = "192.168.0.3";
        //Puerto del servidor
        final int Puerto = 7000;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(Host, Puerto);
 
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
 
            //Envio un mensaje al cliente
            out.writeUTF("Conectando al Servidor....");
            System.out.println("-> Conectado");
 
            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();
 
            System.out.println(mensaje);
 
            sc.close();
 
        } catch (IOException ex) {
            Logger.getLogger(ClienteMain.class.getName()).log(Level.SEVERE, null, ex);
        }
*/