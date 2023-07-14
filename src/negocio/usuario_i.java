/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_usuarioi;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class usuario_i {

    private String contrasenia;
    private int noCarnet;
    private String nombre;

    public usuario_i() {
        this.contrasenia = "";
        this.noCarnet = 0;
        this.nombre = "";

    }

    public usuario_i(String contrasenia, int noCarnet) {
        this.contrasenia = contrasenia;
        this.noCarnet = noCarnet;
    }

    public usuario_i(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(int noCarnet) {
        this.noCarnet = noCarnet;
    }

    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioi pa_bd = new BD_usuarioi(this);
        return pa_bd.guardar();
    }

    public usuario_i LEER(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioi bdP = new BD_usuarioi(this);
        return (usuario_i) bdP.leer(carnet);
    }

    public int actualizarRegistro(int carnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioi bdP = new BD_usuarioi(this);
        return bdP.actualizar(carnet);
    }

    public usuario_i VerificarRegistro(String contrasenia, int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioi bdP = new BD_usuarioi(this);
        return (usuario_i) bdP.verificarPerfil(contrasenia, inss);
    }

}
