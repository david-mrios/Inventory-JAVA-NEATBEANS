/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_detalleInvEqMob;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class detalle_invEqMob {

    private int idInventario;
    private int idEquipoMobiliario;

    public detalle_invEqMob() {
        this.idInventario = 0;
        this.idEquipoMobiliario = 0;
    }

    public detalle_invEqMob(int idEquipoMobiliario, int idInventario) {
        this.idInventario = idInventario;
        this.idEquipoMobiliario = idEquipoMobiliario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdEquipoMobiliario() {
        return idEquipoMobiliario;
    }

    public void setIdEquipoMobiliario(int idEquipoMobiliario) {
        this.idEquipoMobiliario = idEquipoMobiliario;
    }

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqMob obb = new BD_detalleInvEqMob(this);
        return obb.guardar();

    }

    public int BuscarIdEquipo(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqMob bdP = new BD_detalleInvEqMob(this);
        return bdP.BuscarIDEquipo(numArt);

    }

    public int BuscarIdInventario(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_detalleInvEqMob bdP = new BD_detalleInvEqMob(this);
        return bdP.BuscarIDInventario(numInventario);

    }

}
