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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "sanidad_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanidadEngorde.findAll", query = "SELECT s FROM SanidadEngorde s"),
    @NamedQuery(name = "SanidadEngorde.findByCodigoSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.codigoSanidad = :codigoSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByEdadSemanasSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.edadSemanasSanidad = :edadSemanasSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByFechaSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.fechaSanidad = :fechaSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByTratamientoSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.tratamientoSanidad = :tratamientoSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByCostoSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.costoSanidad = :costoSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByFechaRegistroSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.fechaRegistroSanidad = :fechaRegistroSanidad"),
    @NamedQuery(name = "SanidadEngorde.findByHoraRegistroSanidad", query = "SELECT s FROM SanidadEngorde s WHERE s.horaRegistroSanidad = :horaRegistroSanidad")})
public class SanidadEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_sanidad")
    private Integer codigoSanidad;
    @Column(name = "edad_semanas_sanidad")
    private Integer edadSemanasSanidad;
    @Column(name = "fecha_sanidad")
    @Temporal(TemporalType.DATE)
    private Date fechaSanidad;
    @Size(max = 100)
    @Column(name = "tratamiento_sanidad")
    private String tratamientoSanidad;
    @Column(name = "costo_sanidad")
    private Integer costoSanidad;
    @Column(name = "fecha_registro_sanidad")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroSanidad;
    @Column(name = "hora_registro_sanidad")
    @Temporal(TemporalType.TIME)
    private Date horaRegistroSanidad;
    @JoinColumn(name = "numero_lote_engorde", referencedColumnName = "numero_lote_engorde")
    @ManyToOne
    private LoteEngorde numeroLoteEngorde;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuario;

    public SanidadEngorde() {
    }

    public SanidadEngorde(Integer codigoSanidad) {
        this.codigoSanidad = codigoSanidad;
    }

    public Integer getCodigoSanidad() {
        return codigoSanidad;
    }

    public void setCodigoSanidad(Integer codigoSanidad) {
        this.codigoSanidad = codigoSanidad;
    }

    public Integer getEdadSemanasSanidad() {
        return edadSemanasSanidad;
    }

    public void setEdadSemanasSanidad(Integer edadSemanasSanidad) {
        this.edadSemanasSanidad = edadSemanasSanidad;
    }

    public Date getFechaSanidad() {
        return fechaSanidad;
    }

    public void setFechaSanidad(Date fechaSanidad) {
        this.fechaSanidad = fechaSanidad;
    }

    public String getTratamientoSanidad() {
        return tratamientoSanidad;
    }

    public void setTratamientoSanidad(String tratamientoSanidad) {
        this.tratamientoSanidad = tratamientoSanidad;
    }

    public Integer getCostoSanidad() {
        return costoSanidad;
    }

    public void setCostoSanidad(Integer costoSanidad) {
        this.costoSanidad = costoSanidad;
    }

    public Date getFechaRegistroSanidad() {
        return fechaRegistroSanidad;
    }

    public void setFechaRegistroSanidad(Date fechaRegistroSanidad) {
        this.fechaRegistroSanidad = fechaRegistroSanidad;
    }

    public Date getHoraRegistroSanidad() {
        return horaRegistroSanidad;
    }

    public void setHoraRegistroSanidad(Date horaRegistroSanidad) {
        this.horaRegistroSanidad = horaRegistroSanidad;
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
        hash += (codigoSanidad != null ? codigoSanidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanidadEngorde)) {
            return false;
        }
        SanidadEngorde other = (SanidadEngorde) object;
        if ((this.codigoSanidad == null && other.codigoSanidad != null) || (this.codigoSanidad != null && !this.codigoSanidad.equals(other.codigoSanidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SanidadEngorde[ codigoSanidad=" + codigoSanidad + " ]";
    }
    
}
