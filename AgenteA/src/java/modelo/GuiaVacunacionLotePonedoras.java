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
@Table(name = "guia_vacunacion_lote_ponedoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findAll", query = "SELECT g FROM GuiaVacunacionLotePonedoras g"),
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findByCodigoGuiaVacunacion", query = "SELECT g FROM GuiaVacunacionLotePonedoras g WHERE g.codigoGuiaVacunacion = :codigoGuiaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findByEdadGuiaVacunacion", query = "SELECT g FROM GuiaVacunacionLotePonedoras g WHERE g.edadGuiaVacunacion = :edadGuiaVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findByFechaRealVacunacion", query = "SELECT g FROM GuiaVacunacionLotePonedoras g WHERE g.fechaRealVacunacion = :fechaRealVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findByCantidadVacunacion", query = "SELECT g FROM GuiaVacunacionLotePonedoras g WHERE g.cantidadVacunacion = :cantidadVacunacion"),
    @NamedQuery(name = "GuiaVacunacionLotePonedoras.findByCostoVacunacion", query = "SELECT g FROM GuiaVacunacionLotePonedoras g WHERE g.costoVacunacion = :costoVacunacion")})
public class GuiaVacunacionLotePonedoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_guia_vacunacion")
    private Integer codigoGuiaVacunacion;
    @Column(name = "edad_guia_vacunacion")
    private Integer edadGuiaVacunacion;
    @Column(name = "fecha_real_vacunacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealVacunacion;
    @Column(name = "cantidad_vacunacion")
    private Integer cantidadVacunacion;
    @Column(name = "costo_vacunacion")
    private Integer costoVacunacion;
    @JoinColumn(name = "numero_lote_ponedoras_fk2", referencedColumnName = "numero_lote_ponedoras")
    @ManyToOne
    private LotePonedoras numeroLotePonedorasFk2;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_vacuna_fk", referencedColumnName = "codigo_vacuna")
    @ManyToOne
    private Vacuna codigoVacunaFk;

    public GuiaVacunacionLotePonedoras() {
    }

    public GuiaVacunacionLotePonedoras(Integer codigoGuiaVacunacion) {
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

    public Date getFechaRealVacunacion() {
        return fechaRealVacunacion;
    }

    public void setFechaRealVacunacion(Date fechaRealVacunacion) {
        this.fechaRealVacunacion = fechaRealVacunacion;
    }

    public Integer getCantidadVacunacion() {
        return cantidadVacunacion;
    }

    public void setCantidadVacunacion(Integer cantidadVacunacion) {
        this.cantidadVacunacion = cantidadVacunacion;
    }

    public Integer getCostoVacunacion() {
        return costoVacunacion;
    }

    public void setCostoVacunacion(Integer costoVacunacion) {
        this.costoVacunacion = costoVacunacion;
    }

    public LotePonedoras getNumeroLotePonedorasFk2() {
        return numeroLotePonedorasFk2;
    }

    public void setNumeroLotePonedorasFk2(LotePonedoras numeroLotePonedorasFk2) {
        this.numeroLotePonedorasFk2 = numeroLotePonedorasFk2;
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
        if (!(object instanceof GuiaVacunacionLotePonedoras)) {
            return false;
        }
        GuiaVacunacionLotePonedoras other = (GuiaVacunacionLotePonedoras) object;
        if ((this.codigoGuiaVacunacion == null && other.codigoGuiaVacunacion != null) || (this.codigoGuiaVacunacion != null && !this.codigoGuiaVacunacion.equals(other.codigoGuiaVacunacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GuiaVacunacionLotePonedoras[ codigoGuiaVacunacion=" + codigoGuiaVacunacion + " ]";
    }
    
}
