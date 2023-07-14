/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.usuario_i;

/**
 *
 * @author David
 */
public class CTr_usuario_i {

    public static int agregar(String contrasenia, int noCarne)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_i pa = new usuario_i(contrasenia, noCarne);
        return pa.agregarRegistro();
    }

    public static usuario_i leerRegistro(int noCarne) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_i po = new usuario_i();
        return (usuario_i) po.LEER(noCarne);
    }

    public static int actualizar(String contrasenia, int noCarne)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_i pa = new usuario_i(contrasenia, noCarne);
        return pa.actualizarRegistro(noCarne);
    }

    public static usuario_i VerificarRegistro(String contrasenia, int noCarne) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_i po = new usuario_i();
        return (usuario_i) po.VerificarRegistro(contrasenia, noCarne);
    }

}
