/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "guia_vacunacion_lote_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findAll", query = "SELECT g FROM GuiaVacunacionLoteEngorde g"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByCodigoGuiaVacuna", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.codigoGuiaVacuna = :codigoGuiaVacuna"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByEdadGuiaVacunacion", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.edadGuiaVacunacion = :edadGuiaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByFechaPrevistaVacunacion", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.fechaPrevistaVacunacion = :fechaPrevistaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByFechaRealVacunacion", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.fechaRealVacunacion = :fechaRealVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByCantidadVacunacion", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.cantidadVacunacion = :cantidadVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteEngorde.findByCostoVacunacion", query = "SELECT g FROM GuiaVacunacionLoteEngorde g WHERE g.costoVacunacion = :costoVacunacion")})
public class GuiaVacunacionLoteEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_guia_vacuna")
    private Integer codigoGuiaVacuna;
    @Column(name = "edad_guia_vacunacion")
    private Integer edadGuiaVacunacion;
    @Column(name = "fecha_prevista_vacunacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPrevistaVacunacion;
    @Column(name = "fecha_real_vacunacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealVacunacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_vacunacion")
    private Double cantidadVacunacion;
    @Column(name = "costo_vacunacion")
    private Integer costoVacunacion;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_enfermedad_fk", referencedColumnName = "codigo_enfermedad")
    @ManyToOne
    private Enfermedad codigoEnfermedadFk;
    @JoinColumn(name = "numero_lote_engorde_fk", referencedColumnName = "numero_lote_engorde")
    @ManyToOne
    private LoteEngorde numeroLoteEngordeFk;
    @JoinColumn(name = "codigo_vacuna_fk", referencedColumnName = "codigo_vacuna")
    @ManyToOne
    private Vacuna codigoVacunaFk;

    public GuiaVacunacionLoteEngorde() {
    }

    public GuiaVacunacionLoteEngorde(Integer codigoGuiaVacuna) {
        this.codigoGuiaVacuna = codigoGuiaVacuna;
    }

    public Integer getCodigoGuiaVacuna() {
        return codigoGuiaVacuna;
    }

    public void setCodigoGuiaVacuna(Integer codigoGuiaVacuna) {
        this.codigoGuiaVacuna = codigoGuiaVacuna;
    }

    public Integer getEdadGuiaVacunacion() {
        return edadGuiaVacunacion;
    }

    public void setEdadGuiaVacunacion(Integer edadGuiaVacunacion) {
        this.edadGuiaVacunacion = edadGuiaVacunacion;
    }

    public Date getFechaPrevistaVacunacion() {
        return fechaPrevistaVacunacion;
    }

    public void setFechaPrevistaVacunacion(Date fechaPrevistaVacunacion) {
        this.fechaPrevistaVacunacion = fechaPrevistaVacunacion;
    }

    public Date getFechaRealVacunacion() {
        return fechaRealVacunacion;
    }

    public void setFechaRealVacunacion(Date fechaRealVacunacion) {
        this.fechaRealVacunacion = fechaRealVacunacion;
    }

    public Double getCantidadVacunacion() {
        return cantidadVacunacion;
    }

    public void setCantidadVacunacion(Double cantidadVacunacion) {
        this.cantidadVacunacion = cantidadVacunacion;
    }

    public Integer getCostoVacunacion() {
        return costoVacunacion;
    }

    public void setCostoVacunacion(Integer costoVacunacion) {
        this.costoVacunacion = costoVacunacion;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public Enfermedad getCodigoEnfermedadFk() {
        return codigoEnfermedadFk;
    }

    public void setCodigoEnfermedadFk(Enfermedad codigoEnfermedadFk) {
        this.codigoEnfermedadFk = codigoEnfermedadFk;
    }

    public LoteEngorde getNumeroLoteEngordeFk() {
        return numeroLoteEngordeFk;
    }

    public void setNumeroLoteEngordeFk(LoteEngorde numeroLoteEngordeFk) {
        this.numeroLoteEngordeFk = numeroLoteEngordeFk;
    }

    public Vacuna getCodigoVacunaFk() {
        return codigoVacunaFk;
    }

    public void setCodigoVacunaFk(Vacuna codigoVacunaFk) {
        this.codigoVacunaFk = codigoVacunaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGuiaVacuna != null ? codigoGuiaVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaVacunacionLoteEngorde)) {
            return false;
        }
        GuiaVacunacionLoteEngorde other = (GuiaVacunacionLoteEngorde) object;
        if ((this.codigoGuiaVacuna == null && other.codigoGuiaVacuna != null) || (this.codigoGuiaVacuna != null && !this.codigoGuiaVacuna.equals(other.codigoGuiaVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GuiaVacunacionLoteEngorde[ codigoGuiaVacuna=" + codigoGuiaVacuna + " ]";
    }
    
}
