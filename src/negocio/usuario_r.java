/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_usuarioR;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class usuario_r {

    private String contrasenia;
    private int inss;
    private String nombre;

    public usuario_r() {
        this.contrasenia = "";
        this.inss = 0;
        this.nombre = "";
    }

    public usuario_r(String nombre) {
        this.nombre = nombre;
    }

    public usuario_r(String contrasenia, int inss) {
        this.contrasenia = contrasenia;
        this.inss = inss;
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

    public int getInss() {
        return inss;
    }

    public void setInss(int inss) {
        this.inss = inss;
    }

    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioR pa_bd = new BD_usuarioR(this);
        return pa_bd.guardar();
    }

    public usuario_r LEER(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioR bdP = new BD_usuarioR(this);
        return (usuario_r) bdP.leer(inss);
    }

    public int actualizarRegistro(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioR bdP = new BD_usuarioR(this);
        return bdP.actualizar(inss);
    }

    public usuario_r VerificarRegistro(String contrasenia, int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioR bdP = new BD_usuarioR(this);
        return (usuario_r) bdP.verificarPerfil(contrasenia, inss);
    }

}
