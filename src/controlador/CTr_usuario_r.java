/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.usuario_r;

/**
 *
 * @author David
 */
public class CTr_usuario_r {

    public static int agregar(String contrasenia, int inss)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_r pa = new usuario_r(contrasenia, inss);
        return pa.agregarRegistro();
    }

    public static usuario_r leerRegistro(int inss) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_r po = new usuario_r();
        return (usuario_r) po.LEER(inss);
    }

    public static int actualizar(String contrasenia, int inss)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_r pa = new usuario_r(contrasenia, inss);
        return pa.actualizarRegistro(inss);
    }

    public static usuario_r VerificarRegistro(String contrasenia, int inss) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_r po = new usuario_r();
        return (usuario_r) po.VerificarRegistro(contrasenia, inss);
    }

}
