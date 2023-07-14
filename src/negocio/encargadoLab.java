/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_EncargadoLab;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class encargadoLab {
    private int idLab;
    private int noCarnet;
    private String fechaEntrada;
    private String fechaSalida;

    public encargadoLab(int idLab, int noCarnet, String fechaEntrada, String fechaSalida) {
        this.idLab = idLab;
        this.noCarnet = noCarnet;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public encargadoLab() {
        this.idLab = 0;
        this.noCarnet = 0;
        this.fechaEntrada = "";
        this.fechaSalida = "";
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public int getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(int noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
        public int agregarRegistro()
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EncargadoLab pa_bd = new BD_EncargadoLab(this);
        return pa_bd.guardar();
    }

    public int actualizarRegistro(int idLab)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EncargadoLab bdP = new BD_EncargadoLab(this);
        return bdP.actualizar(idLab);
    }
    
    
    
}
