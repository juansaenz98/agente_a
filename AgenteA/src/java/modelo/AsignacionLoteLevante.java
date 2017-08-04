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
@Table(name = "asignacion_lote_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionLoteLevante.findAll", query = "SELECT a FROM AsignacionLoteLevante a"),
    @NamedQuery(name = "AsignacionLoteLevante.findByCodigoAsignacionLevante", query = "SELECT a FROM AsignacionLoteLevante a WHERE a.codigoAsignacionLevante = :codigoAsignacionLevante"),
    @NamedQuery(name = "AsignacionLoteLevante.findByFechaAsignacion", query = "SELECT a FROM AsignacionLoteLevante a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "AsignacionLoteLevante.findByEstadoAsignacion", query = "SELECT a FROM AsignacionLoteLevante a WHERE a.estadoAsignacion = :estadoAsignacion")})
public class AsignacionLoteLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_asignacion_levante")
    private Integer codigoAsignacionLevante;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "estado_asignacion")
    private Integer estadoAsignacion;
    @JoinColumn(name = "numero_lote", referencedColumnName = "numero_lote")
    @ManyToOne
    private LoteLevante numeroLote;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuario;

    public AsignacionLoteLevante() {
    }

    public AsignacionLoteLevante(Integer codigoAsignacionLevante) {
        this.codigoAsignacionLevante = codigoAsignacionLevante;
    }

    public Integer getCodigoAsignacionLevante() {
        return codigoAsignacionLevante;
    }

    public void setCodigoAsignacionLevante(Integer codigoAsignacionLevante) {
        this.codigoAsignacionLevante = codigoAsignacionLevante;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(Integer estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public LoteLevante getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(LoteLevante numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAsignacionLevante != null ? codigoAsignacionLevante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionLoteLevante)) {
            return false;
        }
        AsignacionLoteLevante other = (AsignacionLoteLevante) object;
        if ((this.codigoAsignacionLevante == null && other.codigoAsignacionLevante != null) || (this.codigoAsignacionLevante != null && !this.codigoAsignacionLevante.equals(other.codigoAsignacionLevante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsignacionLoteLevante[ codigoAsignacionLevante=" + codigoAsignacionLevante + " ]";
    }
    
}
