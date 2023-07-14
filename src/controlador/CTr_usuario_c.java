/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.usuario_c;

/**
 *
 * @author David
 */
public class CTr_usuario_c {

    public static int agregar(String contrasenia, int inss)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_c pa = new usuario_c(contrasenia, inss);
        return pa.agregarRegistro(); 
    }

    public static usuario_c leerRegistro(int inss) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_c po = new usuario_c();
        return (usuario_c) po.LEER(inss);
    }

    public static int actualizar(String contrasenia, int inss )
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_c pa = new usuario_c(contrasenia, inss);
        return pa.actualizarRegistro(inss);
    }


    
     public static usuario_c VerificarRegistro (String contrasenia,int inss) throws 
                                                    ClassNotFoundException,
                                                    InstantiationException,
                                                    InstantiationException,
                                                    IllegalAccessException,
                                                    SQLException
    {
        usuario_c po = new usuario_c();
        return (usuario_c) po.VerificarRegistro(contrasenia,inss);
    }
}
