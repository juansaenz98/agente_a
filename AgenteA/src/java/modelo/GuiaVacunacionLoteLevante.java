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
@Table(name = "guia_vacunacion_lote_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findAll", query = "SELECT g FROM GuiaVacunacionLoteLevante g"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByCodigoGuiaVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.codigoGuiaVacunacion = :codigoGuiaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByEdadGuiaVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.edadGuiaVacunacion = :edadGuiaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByFechaPrevistaVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.fechaPrevistaVacunacion = :fechaPrevistaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByFechaRealVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.fechaRealVacunacion = :fechaRealVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByCantidadVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.cantidadVacunacion = :cantidadVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLoteLevante.findByCostoVacunacion", query = "SELECT g FROM GuiaVacunacionLoteLevante g WHERE g.costoVacunacion = :costoVacunacion")})
public class GuiaVacunacionLoteLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_guia_vacunacion")
    private Integer codigoGuiaVacunacion;
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
    @JoinColumn(name = "codigo_enfermedad", referencedColumnName = "codigo_enfermedad")
    @ManyToOne
    private Enfermedad codigoEnfermedad;
    @JoinColumn(name = "numero_lote_fk", referencedColumnName = "numero_lote")
    @ManyToOne
    private LoteLevante numeroLoteFk;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_vacuna_fk", referencedColumnName = "codigo_vacuna")
    @ManyToOne
    private Vacuna codigoVacunaFk;

    public GuiaVacunacionLoteLevante() {
    }

    public GuiaVacunacionLoteLevante(Integer codigoGuiaVacunacion) {
        this.codigoGuiaVacunacion = codigoGuiaVacunacion;
    }

    public Integer getCodigoGuiaVacunacion() {
        return codigoGuiaVacunacion;
    }

    public void setCodigoGuiaVacunacion(Integer codigoGuiaVacunacion) {
        this.codigoGuiaVacunacion = codigoGuiaVacunacion;
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

    public Enfermedad getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoEnfermedad(Enfermedad codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }

    public LoteLevante getNumeroLoteFk() {
        return numeroLoteFk;
    }

    public void setNumeroLoteFk(LoteLevante numeroLoteFk) {
        this.numeroLoteFk = numeroLoteFk;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
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
        hash += (codigoGuiaVacunacion != null ? codigoGuiaVacunacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaVacunacionLoteLevante)) {
            return false;
        }
        GuiaVacunacionLoteLevante other = (GuiaVacunacionLoteLevante) object;
        if ((this.codigoGuiaVacunacion == null && other.codigoGuiaVacunacion != null) || (this.codigoGuiaVacunacion != null && !this.codigoGuiaVacunacion.equals(other.codigoGuiaVacunacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GuiaVacunacionLoteLevante[ codigoGuiaVacunacion=" + codigoGuiaVacunacion + " ]";
    }
    
}
