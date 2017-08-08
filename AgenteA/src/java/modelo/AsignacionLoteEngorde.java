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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "asignacion_lote_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionLoteEngorde.findAll", query = "SELECT a FROM AsignacionLoteEngorde a"),
    @NamedQuery(name = "AsignacionLoteEngorde.findByCodigoAsignacionEngorde", query = "SELECT a FROM AsignacionLoteEngorde a WHERE a.codigoAsignacionEngorde = :codigoAsignacionEngorde"),
    @NamedQuery(name = "AsignacionLoteEngorde.findByFechaAsignacion", query = "SELECT a FROM AsignacionLoteEngorde a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "AsignacionLoteEngorde.findByEstadoAsignacion", query = "SELECT a FROM AsignacionLoteEngorde a WHERE a.estadoAsignacion = :estadoAsignacion")})
public class AsignacionLoteEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_asignacion_engorde")
    private Integer codigoAsignacionEngorde;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Size(max = 50)
    @Column(name = "estado_asignacion")
    private String estadoAsignacion;
    @JoinColumn(name = "numero_lote_engorde", referencedColumnName = "numero_lote_engorde")
    @ManyToOne
    private LoteEngorde numeroLoteEngorde;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuario;

    public AsignacionLoteEngorde() {
    }

    public AsignacionLoteEngorde(Integer codigoAsignacionEngorde) {
        this.codigoAsignacionEngorde = codigoAsignacionEngorde;
    }

    public Integer getCodigoAsignacionEngorde() {
        return codigoAsignacionEngorde;
    }

    public void setCodigoAsignacionEngorde(Integer codigoAsignacionEngorde) {
        this.codigoAsignacionEngorde = codigoAsignacionEngorde;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getEstadoAsignacion() {
        return estadoAsignacion;
    }

    public void setEstadoAsignacion(String estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }

    public LoteEngorde getNumeroLoteEngorde() {
        return numeroLoteEngorde;
    }

    public void setNumeroLoteEngorde(LoteEngorde numeroLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
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
        hash += (codigoAsignacionEngorde != null ? codigoAsignacionEngorde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionLoteEngorde)) {
            return false;
        }
        AsignacionLoteEngorde other = (AsignacionLoteEngorde) object;
        if ((this.codigoAsignacionEngorde == null && other.codigoAsignacionEngorde != null) || (this.codigoAsignacionEngorde != null && !this.codigoAsignacionEngorde.equals(other.codigoAsignacionEngorde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsignacionLoteEngorde[ codigoAsignacionEngorde=" + codigoAsignacionEngorde + " ]";
    }
    
}
