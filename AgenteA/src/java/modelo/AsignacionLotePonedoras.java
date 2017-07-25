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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "asignacion_lote_ponedoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionLotePonedoras.findAll", query = "SELECT a FROM AsignacionLotePonedoras a"),
    @NamedQuery(name = "AsignacionLotePonedoras.findByCodigoAsignacionPonedoras", query = "SELECT a FROM AsignacionLotePonedoras a WHERE a.codigoAsignacionPonedoras = :codigoAsignacionPonedoras"),
    @NamedQuery(name = "AsignacionLotePonedoras.findByFechaAsignacion", query = "SELECT a FROM AsignacionLotePonedoras a WHERE a.fechaAsignacion = :fechaAsignacion")})
public class AsignacionLotePonedoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_asignacion_ponedoras")
    private Integer codigoAsignacionPonedoras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne(optional = false)
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "numero_lote_ponedoras_fk", referencedColumnName = "numero_lote_ponedoras")
    @ManyToOne(optional = false)
    private LotePonedoras numeroLotePonedorasFk;

    public AsignacionLotePonedoras() {
    }

    public AsignacionLotePonedoras(Integer codigoAsignacionPonedoras) {
        this.codigoAsignacionPonedoras = codigoAsignacionPonedoras;
    }

    public AsignacionLotePonedoras(Integer codigoAsignacionPonedoras, Date fechaAsignacion) {
        this.codigoAsignacionPonedoras = codigoAsignacionPonedoras;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getCodigoAsignacionPonedoras() {
        return codigoAsignacionPonedoras;
    }

    public void setCodigoAsignacionPonedoras(Integer codigoAsignacionPonedoras) {
        this.codigoAsignacionPonedoras = codigoAsignacionPonedoras;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public LotePonedoras getNumeroLotePonedorasFk() {
        return numeroLotePonedorasFk;
    }

    public void setNumeroLotePonedorasFk(LotePonedoras numeroLotePonedorasFk) {
        this.numeroLotePonedorasFk = numeroLotePonedorasFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAsignacionPonedoras != null ? codigoAsignacionPonedoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionLotePonedoras)) {
            return false;
        }
        AsignacionLotePonedoras other = (AsignacionLotePonedoras) object;
        if ((this.codigoAsignacionPonedoras == null && other.codigoAsignacionPonedoras != null) || (this.codigoAsignacionPonedoras != null && !this.codigoAsignacionPonedoras.equals(other.codigoAsignacionPonedoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsignacionLotePonedoras[ codigoAsignacionPonedoras=" + codigoAsignacionPonedoras + " ]";
    }
    
}
