package controlador;

import java.sql.SQLException;
import java.util.List;
import negocio.Laboratorio;

/**
 *
 * @author David
 */
public class CTr_Laboratorio {

    public static int agregar(String numLab)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio pa = new Laboratorio(numLab);
        return pa.agregarRegistro();
    }

    public static int ActualizarRegistro(String numLab, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio(activo);
        return bdP.actualizar(numLab);

    }

    public static int borrarRegistro(String numLab)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio(numLab);
        return bdP.borrarRegistro(numLab);

    }

    public static List<String> getLaboratorios() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio();
        return bdP.getLaboratorios();

    }

    public static Object[] EncargadosListar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio();
        return bdP.EncargadosListar();
    }

    public static Laboratorio EncargadosView(String Laboratorio) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio po = new Laboratorio();
        return (Laboratorio) po.EncargadosView(Laboratorio);
    }

    public static Object[] LaboratorioEquipoTecView(int idLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio();
        return bdP.LaboratorioEquipoTecView(idLab);
    }

    public static Object[] LaboratorioEquipoMobView(int idLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Laboratorio bdP = new Laboratorio();
        return bdP.LaboratorioEquipoMobView(idLab);
    }

}
