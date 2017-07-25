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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "bajas_muertes_diario_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BajasMuertesDiarioLevante.findAll", query = "SELECT b FROM BajasMuertesDiarioLevante b"),
    @NamedQuery(name = "BajasMuertesDiarioLevante.findByCodigoBajasMuerte", query = "SELECT b FROM BajasMuertesDiarioLevante b WHERE b.codigoBajasMuerte = :codigoBajasMuerte"),
    @NamedQuery(name = "BajasMuertesDiarioLevante.findByCantidadBajasMuerte", query = "SELECT b FROM BajasMuertesDiarioLevante b WHERE b.cantidadBajasMuerte = :cantidadBajasMuerte"),
    @NamedQuery(name = "BajasMuertesDiarioLevante.findByFechaRegistroBajas", query = "SELECT b FROM BajasMuertesDiarioLevante b WHERE b.fechaRegistroBajas = :fechaRegistroBajas"),
    @NamedQuery(name = "BajasMuertesDiarioLevante.findByHorasRegistroBajas", query = "SELECT b FROM BajasMuertesDiarioLevante b WHERE b.horasRegistroBajas = :horasRegistroBajas")})
public class BajasMuertesDiarioLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_bajas_muerte")
    private Integer codigoBajasMuerte;
    @Column(name = "cantidad_bajas_muerte")
    private Integer cantidadBajasMuerte;
    @Column(name = "fecha_registro_bajas")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroBajas;
    @Column(name = "horas_registro_bajas")
    @Temporal(TemporalType.TIME)
    private Date horasRegistroBajas;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_registro_levante_fk", referencedColumnName = "codigo_registro_levante")
    @ManyToOne
    private RegistroSemanalLevante codigoRegistroLevanteFk;

    public BajasMuertesDiarioLevante() {
    }

    public BajasMuertesDiarioLevante(Integer codigoBajasMuerte) {
        this.codigoBajasMuerte = codigoBajasMuerte;
    }

    public Integer getCodigoBajasMuerte() {
        return codigoBajasMuerte;
    }

    public void setCodigoBajasMuerte(Integer codigoBajasMuerte) {
        this.codigoBajasMuerte = codigoBajasMuerte;
    }

    public Integer getCantidadBajasMuerte() {
        return cantidadBajasMuerte;
    }

    public void setCantidadBajasMuerte(Integer cantidadBajasMuerte) {
        this.cantidadBajasMuerte = cantidadBajasMuerte;
    }

    public Date getFechaRegistroBajas() {
        return fechaRegistroBajas;
    }

    public void setFechaRegistroBajas(Date fechaRegistroBajas) {
        this.fechaRegistroBajas = fechaRegistroBajas;
    }

    public Date getHorasRegistroBajas() {
        return horasRegistroBajas;
    }

    public void setHorasRegistroBajas(Date horasRegistroBajas) {
        this.horasRegistroBajas = horasRegistroBajas;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public RegistroSemanalLevante getCodigoRegistroLevanteFk() {
        return codigoRegistroLevanteFk;
    }

    public void setCodigoRegistroLevanteFk(RegistroSemanalLevante codigoRegistroLevanteFk) {
        this.codigoRegistroLevanteFk = codigoRegistroLevanteFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBajasMuerte != null ? codigoBajasMuerte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BajasMuertesDiarioLevante)) {
            return false;
        }
        BajasMuertesDiarioLevante other = (BajasMuertesDiarioLevante) object;
        if ((this.codigoBajasMuerte == null && other.codigoBajasMuerte != null) || (this.codigoBajasMuerte != null && !this.codigoBajasMuerte.equals(other.codigoBajasMuerte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.BajasMuertesDiarioLevante[ codigoBajasMuerte=" + codigoBajasMuerte + " ]";
    }
    
}
