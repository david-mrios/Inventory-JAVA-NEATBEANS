/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.MarcaEquipo;

/**
 *
 * @author David
 */
public class CTr_MarcaEquipo {

    public static int agregar(String marca)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        MarcaEquipo M = new MarcaEquipo(marca);
        return M.agregarRegistro();
    }

    public static int borrarRegistro(String marca)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        MarcaEquipo bdP = new MarcaEquipo(marca);
        return bdP.borrarRegistro(marca);

    }

    public boolean verificarMarca(String marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        MarcaEquipo CU_bd = new MarcaEquipo();
        return CU_bd.verificarMarca(marca);
    }
}
