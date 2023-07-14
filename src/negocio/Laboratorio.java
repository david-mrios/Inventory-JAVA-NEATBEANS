/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_Laboratorio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public class Laboratorio {

    private String numeroLab;
    private String Instructor;
    private String fechaSalida;
    private String fechaEntrada;
    private int Estado;

    public Laboratorio() {
        this.numeroLab = "";
        this.fechaSalida = "";
        this.Instructor = "";
        this.fechaEntrada = "";
        this.Estado = 0;
    }

    public Laboratorio(String numeroLab) {
        this.numeroLab = numeroLab;
    }

    public Laboratorio(int Estado) {
        this.Estado = Estado;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Laboratorio(String numeroLab, String Instructor, String fechaEntrada, String fechaSalida) {
        this.numeroLab = numeroLab;
        this.Instructor = Instructor;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;

    }

    public Laboratorio(String numeroLab, int Estado) {
        this.numeroLab = numeroLab;
        this.Estado = Estado;
    }

    public String getNumeroLab() {
        return numeroLab;
    }

    public void setNumeroLab(String numeroLab) {
        this.numeroLab = numeroLab;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int agregarRegistro()
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio pa_bd = new BD_Laboratorio(this);
        return pa_bd.guardar();
    }

    public int actualizar(String Lab)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.Actualizar(Lab);
    }

    public int borrarRegistro(String Lab)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.borrar(Lab);
    }

    public List<String> getLaboratorios() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.ObtenerLaboratorio();

    }

    public Laboratorio EncargadosView(String Lab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return (Laboratorio) bdP.EncargadosView(Lab);
    }

    public Object[] EncargadosListar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.EncargadosListar();

    }

    public Object[] LaboratorioEquipoTecView(int idLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.LaboratorioEquipoTecView(idLab);
    }

    public Object[] LaboratorioEquipoMobView( int idLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Laboratorio bdP = new BD_Laboratorio(this);
        return bdP.LaboratorioEquipoMobView(idLab);
    }

}
