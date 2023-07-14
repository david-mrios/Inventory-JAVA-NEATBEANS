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
public abstract class Equipo {
    protected int inss;
    protected String Custodio;
    protected int numeroArticulo;
    protected String etiqueta;
    protected String codigo;
    protected int cantidad;
    protected String descripcion;
    protected double costo;
    protected int idEstado;
    protected String observacion;
    protected int activo;
 
    public abstract int agregarRegistro () throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException;
    
    public abstract Equipo LEER(int val) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException;
    
    public abstract int actualizarRegistro(int val) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException;
    
    //public abstract Object buscar ();
    public abstract int borrarRegistro (int val) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException;
}
