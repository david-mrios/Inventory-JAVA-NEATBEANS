/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_detalleInvEqTec;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class detalle_invEqTec {

    private int idInventario;
    private int idEquipoTecnologico;

    public detalle_invEqTec() {
        this.idInventario = 0;
        this.idEquipoTecnologico = 0;
    }

    public detalle_invEqTec(int idEquipoTecnologico , int idInventario) {
        this.idEquipoTecnologico = idEquipoTecnologico;
           this.idInventario = idInventario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdEquipoTecnologico() {
        return idEquipoTecnologico;
    }

    public void setIdEquipoTecnologico(int idEquipoMobiliario) {
        this.idEquipoTecnologico = idEquipoMobiliario;
    }

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqTec obb = new BD_detalleInvEqTec(this);
        return obb.guardar();

    }

    public int BuscarIdEquipo(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqTec bdP = new BD_detalleInvEqTec(this);
        return bdP.BuscarIDEquipo(numArt);

    }
    public int BuscarIdInventario(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqTec bdP = new BD_detalleInvEqTec(this);
        return bdP.BuscarIDInventario(numInventario);

    }
    
}
