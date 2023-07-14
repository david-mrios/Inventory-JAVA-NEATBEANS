/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.List;
import negocio.Movimiento;

/**
 *
 * @author David
 */
public class CTr_Movimientos {

    public static int agregar(int noMovimiento, int responsableInss, int idLab,
            int idTipoMovimiento, String LocacionNueva, String observacion, String FechaIngreso)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento pa = new Movimiento(noMovimiento, responsableInss, idLab,
                idTipoMovimiento, LocacionNueva, observacion, FechaIngreso);
        return pa.agregarRegistro();
    }
    public static List<String> obtenerEstados() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.TpMovimiento();

    }

    public static int buscarIDtpMov(String Movimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.BuscarIdtpMov(Movimiento);
    }

    public static int buscarIDLab(String Lab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.BuscarIdLab(Lab);
    }

    public static int noMovimiento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.noMovimiento();
    }

    public static Movimiento leerEquipoTecnologico(int numCarnet) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento po = new Movimiento();
        return (Movimiento) po.leerEquipoTecnologico(numCarnet);
    }

    public static Movimiento leerEquipoMobiliario(int numCarnet) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento po = new Movimiento();
        return (Movimiento) po.leerEquipoMobiliario(numCarnet);
    }

    public static Movimiento leerRegistro(int noMovimiento) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento po = new Movimiento();
        return (Movimiento) po.LEER(noMovimiento);
    }

    public static Object[] ListarMovimientosTec() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.ListarMovimientosTec();
    }

    public static Object[] ListarMovimientosEquipoTec(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.ListarMovimientosEquipoTec(numInventario);
    }
     public static Object[] ListarMovimientosMob() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.ListarMovimientosMob();
    }

    public static Object[] ListarMovimientosEquipoMob(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento bdP = new Movimiento();
        return bdP.ListarMovimientosEquipoMob(numInventario);
    }
    
       public static Movimiento leerMovimientoMob(int noMovimiento) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Movimiento po = new Movimiento();
        return (Movimiento) po.leerMovimientoMob(noMovimiento);
    }
    
}


