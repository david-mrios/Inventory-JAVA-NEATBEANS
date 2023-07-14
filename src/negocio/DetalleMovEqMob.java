/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


import datos.BD_DetalleMovEqMob;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class DetalleMovEqMob {

    private int noMovimiento;
    private int idEquipoMobiliario;

    public DetalleMovEqMob() {
        this.noMovimiento = 0;
        this.idEquipoMobiliario = 0;

    }

    public DetalleMovEqMob(int noMovimiento, int idEquipoMobiliario) {
        this.noMovimiento = noMovimiento;
        this.idEquipoMobiliario = idEquipoMobiliario;
    }

    public int getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(int noMovimiento) {
        this.noMovimiento = noMovimiento;
    }

    public int getIdEquipoMobiliario() {
        return idEquipoMobiliario;
    }

    public void setIdEquipoMobiliario(int idEquipoMobiliario) {
        this.idEquipoMobiliario = idEquipoMobiliario;
    }

    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_DetalleMovEqMob pa_bd = new BD_DetalleMovEqMob(this);
        return pa_bd.guardar();
    }

}
