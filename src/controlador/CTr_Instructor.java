package controlador;

import java.sql.SQLException;
import negocio.Instructor;

/**
 *
 * @author David
 */
public class CTr_Instructor {

    public static int agregar(int noCarne, String nomb, String apell,
            int telefono, String cedula)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor pa = new Instructor(noCarne, nomb, apell,
                telefono, cedula);
        return pa.agregarRegistro();
    }

    public static Instructor leerRegistro(int noCarne) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor po = new Instructor();
        return (Instructor) po.LEER(noCarne);
    }

    public static int actualizar(int noCarne, String nomb, String apell,
            int telefono, String cedula, int activo)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor pa = new Instructor(noCarne, nomb, apell,
                telefono, cedula, activo);
        return pa.actualizarRegistro(noCarne);
    }

    public static boolean verificarCarnetRegistrado(int noCarne)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor pa = new Instructor();
        return pa.verificarCarnetRegistrado(noCarne);
    }

    public static int borrarRegistro(int noCarne, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor bdP = new Instructor(activo);
        return bdP.borrarRegistro(noCarne);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Instructor bdP = new Instructor();
        return bdP.Listado();
    }

}
