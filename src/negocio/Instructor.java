/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_Instructor;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class Instructor extends Personal {

    private int NoCarnet;

    public Instructor() {
        this.NoCarnet = 0;
        this.nombres = "";
        this.apellidos = "";
        this.telefono = 0;
        this.cedula = "";
        this.activo = 0;
        this.contrasenia= "";
    }

      public Instructor(int NoCarnet,String contrasenia) {
        this.contrasenia=  contrasenia;
        this.NoCarnet=  NoCarnet;
    }
    
    public Instructor(int NoCarnet) {
        this.NoCarnet = NoCarnet;
    }
    
    
     public Instructor(int NoCarnet, String nomb, String apell,
            int telefono, String cedula) {
        this.NoCarnet = NoCarnet;
        this.nombres = nomb;
        this.apellidos = apell;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    // Constructoractualizar
    public Instructor(int NoCarnet, String nombres, String apellidos,
            int telefono, String Cedula, int activo) {
        this.NoCarnet = NoCarnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cedula = Cedula;
        this.activo = activo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

    public int getNoCarnet() {
        return NoCarnet;
    }

    public void setNoCarnet(int NoCarnet) {
        this.NoCarnet = NoCarnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
     @Override
    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor pa_bd = new BD_Instructor(this);
        return pa_bd.guardar();
    }

    @Override
    public Personal LEER(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor bdP = new BD_Instructor(this);
        return (Personal) bdP.leer(carnet);
    }

    @Override
    public int actualizarRegistro(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor bdP = new BD_Instructor(this);
        return bdP.actualizar(carnet);
    }

    public boolean verificarCarnetRegistrado(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor CU_bd = new BD_Instructor();
        return CU_bd.verificarCarnetRegistrado(carnet);
    }

    @Override
    public int borrarRegistro(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor bdP = new BD_Instructor(this);
        return bdP.borrar(carnet);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Instructor bdP = new BD_Instructor(this);
        return bdP.Listado();
    }


}
