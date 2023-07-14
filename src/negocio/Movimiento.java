package negocio;

import datos.BD_Movimientos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public class Movimiento {

    private int noMovimiento;
    private int responsableInss;
    private String Responsable;
    private int idLab;
    private int idTipoMovimiento;
    private String LocacionNueva;
    private String Observacion;
    private String TipoMovimiento;
    private String descripcion;

    private int numArtEquipo;
    private String numeroLab;

    private String FechaIngreso;

    public Movimiento(int numArtEquipo, String numeroLab) {
        this.numArtEquipo = numArtEquipo;
        this.numeroLab = numeroLab;
    }

    public Movimiento() {
        this.noMovimiento = 0;
        this.responsableInss = 0;
        this.idLab = 0;
        this.idTipoMovimiento = 0;
        this.LocacionNueva = "";
        this.Observacion = "";
        this.Responsable = "";
        this.TipoMovimiento = "";
        this.descripcion = "";
        this.FechaIngreso = "";
    }

    //Buscar
    public Movimiento(int noMovimiento, String Responsable, String numeroLab,
            String LocacionNueva, String TipoMovimiento, int numArtEquipo,
            String descripcion, String observacion, String FechaIngreso) {
        this.noMovimiento = noMovimiento;
        this.Responsable = Responsable;
        this.numeroLab = numeroLab;
        this.LocacionNueva = LocacionNueva;
        this.TipoMovimiento = TipoMovimiento;
        this.numArtEquipo = numArtEquipo;
        this.descripcion = descripcion;
        this.Observacion = observacion;
        this.FechaIngreso = FechaIngreso;
    }

    public Movimiento(int noMovimiento, int responsableInss, int idLab,
            int idTipoMovimiento, String LocacionNueva, String Observacion, String FechaIngreso) {
        this.noMovimiento = noMovimiento;
        this.responsableInss = responsableInss;
        this.idLab = idLab;
        this.idTipoMovimiento = idTipoMovimiento;
        this.LocacionNueva = LocacionNueva;
        this.Observacion = Observacion;
        this.FechaIngreso = FechaIngreso;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public int getNumArtEquipo() {
        return numArtEquipo;
    }

    public void setNumArtEquipo(int numArtEquipo) {
        this.numArtEquipo = numArtEquipo;
    }

    public String getNumeroLab() {
        return numeroLab;
    }

    public void setNumeroLab(String numeroLab) {
        this.numeroLab = numeroLab;
    }

    public int getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(int noMovimiento) {
        this.noMovimiento = noMovimiento;
    }

    public int getResponsableInss() {
        return responsableInss;
    }

    public void setResponsableInss(int responsableInss) {
        this.responsableInss = responsableInss;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String TipoMovimiento) {
        this.TipoMovimiento = TipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getLocacionNueva() {
        return LocacionNueva;
    }

    public void setLocacionNueva(String LocacionNueva) {
        this.LocacionNueva = LocacionNueva;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos pa_bd = new BD_Movimientos(this);
        return pa_bd.guardar();
    }

    public List<String> TpMovimiento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.ObtenerTipoMovimiento();

    }

    public int BuscarIdtpMov(String Movimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.BuscarIDTipoMov(Movimiento);

    }

    public int BuscarIdLab(String lab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.BuscarIDLab(lab);

    }

    public int noMovimiento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.noMovimiento();

    }

    public Movimiento leerEquipoTecnologico(int numCarnet)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return (Movimiento) bdP.leerEquipoTecnologico(numCarnet);
    }

    public Movimiento leerEquipoMobiliario(int numCarnet)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return (Movimiento) bdP.leerEquipoMobiliario(numCarnet);
    }

    public Object[] ListarMovimientosTec() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.ListarMovimientosTec();
    }

    public Object[] ListarMovimientosEquipoTec(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.ListarMovimientosEquipoTec(noMovimiento);
    }

    public Movimiento LEER(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return (Movimiento) bdP.leerMovimiento(noMovimiento);
    }

    public Object[] ListarMovimientosMob() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.ListarMovimientosMob();
    }

    public Object[] ListarMovimientosEquipoMob(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return bdP.ListarMovimientosEquipoMob(noMovimiento);
    }

    public Movimiento leerMovimientoMob(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Movimientos bdP = new BD_Movimientos(this);
        return (Movimiento) bdP.leerMovimientoMob(noMovimiento);
    }

}
