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
@Table(name = "sacrifio_venta_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SacrifioVentaEngorde.findAll", query = "SELECT s FROM SacrifioVentaEngorde s"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByCodigoSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.codigoSacrificioVenta = :codigoSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByEdadSemanaSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.edadSemanaSacrificioVenta = :edadSemanaSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByFechaSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.fechaSacrificioVenta = :fechaSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByCantidadSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.cantidadSacrificioVenta = :cantidadSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByTipoSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.tipoSacrificioVenta = :tipoSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByPesoSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.pesoSacrificioVenta = :pesoSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByPrecioKgSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.precioKgSacrificioVenta = :precioKgSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByTotalSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.totalSacrificioVenta = :totalSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByHoraRegistroSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.horaRegistroSacrificioVenta = :horaRegistroSacrificioVenta"),
    @NamedQuery(name = "SacrifioVentaEngorde.findByFechaRegistroSacrificioVenta", query = "SELECT s FROM SacrifioVentaEngorde s WHERE s.fechaRegistroSacrificioVenta = :fechaRegistroSacrificioVenta")})
public class SacrifioVentaEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_sacrificio_venta")
    private Integer codigoSacrificioVenta;
    @Column(name = "edad_semana_sacrificio_venta")
    private Integer edadSemanaSacrificioVenta;
    @Column(name = "fecha_sacrificio_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaSacrificioVenta;
    @Column(name = "cantidad_sacrificio_venta")
    private Integer cantidadSacrificioVenta;
    @Size(max = 50)
    @Column(name = "tipo_sacrificio_venta")
    private String tipoSacrificioVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_sacrificio_venta")
    private Double pesoSacrificioVenta;
    @Column(name = "precio_kg_sacrificio_venta")
    private Double precioKgSacrificioVenta;
    @Column(name = "total_sacrificio_venta")
    private Integer totalSacrificioVenta;
    @Column(name = "hora_registro_sacrificio_venta")
    @Temporal(TemporalType.TIME)
    private Date horaRegistroSacrificioVenta;
    @Column(name = "fecha_registro_sacrificio_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroSacrificioVenta;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "numero_lote_engorde_fk", referencedColumnName = "numero_lote_engorde")
    @ManyToOne
    private LoteEngorde numeroLoteEngordeFk;

    public SacrifioVentaEngorde() {
    }

    public SacrifioVentaEngorde(Integer codigoSacrificioVenta) {
        this.codigoSacrificioVenta = codigoSacrificioVenta;
    }

    public Integer getCodigoSacrificioVenta() {
        return codigoSacrificioVenta;
    }

    public void setCodigoSacrificioVenta(Integer codigoSacrificioVenta) {
        this.codigoSacrificioVenta = codigoSacrificioVenta;
    }

    public Integer getEdadSemanaSacrificioVenta() {
        return edadSemanaSacrificioVenta;
    }

    public void setEdadSemanaSacrificioVenta(Integer edadSemanaSacrificioVenta) {
        this.edadSemanaSacrificioVenta = edadSemanaSacrificioVenta;
    }

    public Date getFechaSacrificioVenta() {
        return fechaSacrificioVenta;
    }

    public void setFechaSacrificioVenta(Date fechaSacrificioVenta) {
        this.fechaSacrificioVenta = fechaSacrificioVenta;
    }

    public Integer getCantidadSacrificioVenta() {
        return cantidadSacrificioVenta;
    }

    public void setCantidadSacrificioVenta(Integer cantidadSacrificioVenta) {
        this.cantidadSacrificioVenta = cantidadSacrificioVenta;
    }

    public String getTipoSacrificioVenta() {
        return tipoSacrificioVenta;
    }

    public void setTipoSacrificioVenta(String tipoSacrificioVenta) {
        this.tipoSacrificioVenta = tipoSacrificioVenta;
    }

    public Double getPesoSacrificioVenta() {
        return pesoSacrificioVenta;
    }

    public void setPesoSacrificioVenta(Double pesoSacrificioVenta) {
        this.pesoSacrificioVenta = pesoSacrificioVenta;
    }

    public Double getPrecioKgSacrificioVenta() {
        return precioKgSacrificioVenta;
    }

    public void setPrecioKgSacrificioVenta(Double precioKgSacrificioVenta) {
        this.precioKgSacrificioVenta = precioKgSacrificioVenta;
    }

    public Integer getTotalSacrificioVenta() {
        return totalSacrificioVenta;
    }

    public void setTotalSacrificioVenta(Integer totalSacrificioVenta) {
        this.totalSacrificioVenta = totalSacrificioVenta;
    }

    public Date getHoraRegistroSacrificioVenta() {
        return horaRegistroSacrificioVenta;
    }

    public void setHoraRegistroSacrificioVenta(Date horaRegistroSacrificioVenta) {
        this.horaRegistroSacrificioVenta = horaRegistroSacrificioVenta;
    }

    public Date getFechaRegistroSacrificioVenta() {
        return fechaRegistroSacrificioVenta;
    }

    public void setFechaRegistroSacrificioVenta(Date fechaRegistroSacrificioVenta) {
        this.fechaRegistroSacrificioVenta = fechaRegistroSacrificioVenta;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public LoteEngorde getNumeroLoteEngordeFk() {
        return numeroLoteEngordeFk;
    }

    public void setNumeroLoteEngordeFk(LoteEngorde numeroLoteEngordeFk) {
        this.numeroLoteEngordeFk = numeroLoteEngordeFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSacrificioVenta != null ? codigoSacrificioVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SacrifioVentaEngorde)) {
            return false;
        }
        SacrifioVentaEngorde other = (SacrifioVentaEngorde) object;
        if ((this.codigoSacrificioVenta == null && other.codigoSacrificioVenta != null) || (this.codigoSacrificioVenta != null && !this.codigoSacrificioVenta.equals(other.codigoSacrificioVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SacrifioVentaEngorde[ codigoSacrificioVenta=" + codigoSacrificioVenta + " ]";
    }
    
}
