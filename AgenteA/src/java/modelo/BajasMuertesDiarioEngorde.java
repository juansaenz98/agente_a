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
import javax.persistence.Lob;
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
@Table(name = "bajas_muertes_diario_engorde_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BajasMuertesDiarioEngorde.findAll", query = "SELECT b FROM BajasMuertesDiarioEngorde b"),
    @NamedQuery(name = "BajasMuertesDiarioEngorde.findByCodigoBajasMuertes", query = "SELECT b FROM BajasMuertesDiarioEngorde b WHERE b.codigoBajasMuertes = :codigoBajasMuertes"),
    @NamedQuery(name = "BajasMuertesDiarioEngorde.findByCantidadBajasMuertes", query = "SELECT b FROM BajasMuertesDiarioEngorde b WHERE b.cantidadBajasMuertes = :cantidadBajasMuertes"),
    @NamedQuery(name = "BajasMuertesDiarioEngorde.findByFechaRegistroBajas", query = "SELECT b FROM BajasMuertesDiarioEngorde b WHERE b.fechaRegistroBajas = :fechaRegistroBajas"),
    @NamedQuery(name = "BajasMuertesDiarioEngorde.findByHoraRegistroBajas", query = "SELECT b FROM BajasMuertesDiarioEngorde b WHERE b.horaRegistroBajas = :horaRegistroBajas")})
public class BajasMuertesDiarioEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_bajas_muertes")
    private Integer codigoBajasMuertes;
    @Column(name = "cantidad_bajas_muertes")
    private Integer cantidadBajasMuertes;
    @Column(name = "fecha_registro_bajas")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroBajas;
    @Column(name = "hora_registro_bajas")
    @Temporal(TemporalType.TIME)
    private Date horaRegistroBajas;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_bajas")
    private String observacionesBajas;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_registro_engorde", referencedColumnName = "codigo_registro_engorde")
    @ManyToOne
    private RegistroSemanalEngorde codigoRegistroEngorde;

    public BajasMuertesDiarioEngorde() {
    }

    public BajasMuertesDiarioEngorde(Integer codigoBajasMuertes) {
        this.codigoBajasMuertes = codigoBajasMuertes;
    }

    public Integer getCodigoBajasMuertes() {
        return codigoBajasMuertes;
    }

    public void setCodigoBajasMuertes(Integer codigoBajasMuertes) {
        this.codigoBajasMuertes = codigoBajasMuertes;
    }

    public Integer getCantidadBajasMuertes() {
        return cantidadBajasMuertes;
    }

    public void setCantidadBajasMuertes(Integer cantidadBajasMuertes) {
        this.cantidadBajasMuertes = cantidadBajasMuertes;
    }

    public Date getFechaRegistroBajas() {
        return fechaRegistroBajas;
    }

    public void setFechaRegistroBajas(Date fechaRegistroBajas) {
        this.fechaRegistroBajas = fechaRegistroBajas;
    }

    public Date getHoraRegistroBajas() {
        return horaRegistroBajas;
    }

    public void setHoraRegistroBajas(Date horaRegistroBajas) {
        this.horaRegistroBajas = horaRegistroBajas;
    }

    public String getObservacionesBajas() {
        return observacionesBajas;
    }

    public void setObservacionesBajas(String observacionesBajas) {
        this.observacionesBajas = observacionesBajas;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public RegistroSemanalEngorde getCodigoRegistroEngorde() {
        return codigoRegistroEngorde;
    }

    public void setCodigoRegistroEngorde(RegistroSemanalEngorde codigoRegistroEngorde) {
        this.codigoRegistroEngorde = codigoRegistroEngorde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBajasMuertes != null ? codigoBajasMuertes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BajasMuertesDiarioEngorde)) {
            return false;
        }
        BajasMuertesDiarioEngorde other = (BajasMuertesDiarioEngorde) object;
        if ((this.codigoBajasMuertes == null && other.codigoBajasMuertes != null) || (this.codigoBajasMuertes != null && !this.codigoBajasMuertes.equals(other.codigoBajasMuertes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.BajasMuertesDiarioEngorde[ codigoBajasMuertes=" + codigoBajasMuertes + " ]";
    }
    
}
