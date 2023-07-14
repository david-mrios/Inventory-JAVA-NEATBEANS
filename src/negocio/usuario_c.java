/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_usuarioC;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class usuario_c {

    private String contrasenia;
    private int inss;
    private String nombre;

    public usuario_c() {
        this.contrasenia = "";
        this.inss = 0;
        this.nombre = "";

    }

    public usuario_c(String contrasenia, int inss) {
        this.contrasenia = contrasenia;
        this.inss = inss;
    }

    public usuario_c(String nombre) {
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
        BD_usuarioC pa_bd = new BD_usuarioC(this);
        return pa_bd.guardar();
    }

    public usuario_c LEER(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioC bdP = new BD_usuarioC(this);
        return (usuario_c) bdP.leer(inss);
    }

    public int actualizarRegistro(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioC bdP = new BD_usuarioC(this);
        return bdP.actualizar(inss);
    }

    public usuario_c VerificarRegistro(String contrasenia, int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_usuarioC bdP = new BD_usuarioC(this);
        return (usuario_c) bdP.verificarPerfil(contrasenia, inss);
    }

}
