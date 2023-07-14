/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.sql.SQLException;

/**
 *
 * @author David
 */
public abstract class Personal {

    /* ************************************************************************/
 /*                      Variables de Instancia                            */
 /* ************************************************************************/
    protected String nombres;
    protected String apellidos;
    protected int telefono;
    protected String cedula;
    protected int activo;
    protected String contrasenia;

    public abstract int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException;

    public abstract Personal LEER(int val) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException;

    public abstract int actualizarRegistro(int val) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException;

    public abstract int borrarRegistro(int val) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException;

}
