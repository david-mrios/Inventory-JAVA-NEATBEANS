/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_DetalleMovEqTec;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class DetalleMovEqTec {
    private int noMovimiento;
    private int idEquipoTecnologico;

    public DetalleMovEqTec() {
        this.noMovimiento = 0;
        this.idEquipoTecnologico = 0;
    }

    public DetalleMovEqTec(int noMovimiento, int idEquipoTecnologico) {
        this.noMovimiento = noMovimiento;
        this.idEquipoTecnologico = idEquipoTecnologico;
    }

    public int getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(int noMovimiento) {
        this.noMovimiento = noMovimiento;
    }

    public int getIdEquipoTecnologico() {
        return idEquipoTecnologico;
    }

    public void setIdEquipoTecnologico(int idEquipoTecnologico) {
        this.idEquipoTecnologico = idEquipoTecnologico;
    }
    
    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_DetalleMovEqTec pa_bd = new BD_DetalleMovEqTec(this);
        return pa_bd.guardar();
    }
    
}
