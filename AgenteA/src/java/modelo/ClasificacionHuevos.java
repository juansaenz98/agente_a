/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "clasificacion_huevos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClasificacionHuevos.findAll", query = "SELECT c FROM ClasificacionHuevos c"),
    @NamedQuery(name = "ClasificacionHuevos.findByCodigoClasificacion", query = "SELECT c FROM ClasificacionHuevos c WHERE c.codigoClasificacion = :codigoClasificacion"),
    @NamedQuery(name = "ClasificacionHuevos.findByTipoHuevos", query = "SELECT c FROM ClasificacionHuevos c WHERE c.tipoHuevos = :tipoHuevos"),
    @NamedQuery(name = "ClasificacionHuevos.findByCantidadHuevos", query = "SELECT c FROM ClasificacionHuevos c WHERE c.cantidadHuevos = :cantidadHuevos"),
    @NamedQuery(name = "ClasificacionHuevos.findByPorcentajeHuevos", query = "SELECT c FROM ClasificacionHuevos c WHERE c.porcentajeHuevos = :porcentajeHuevos"),
    @NamedQuery(name = "ClasificacionHuevos.findByValorUnitarioHuevos", query = "SELECT c FROM ClasificacionHuevos c WHERE c.valorUnitarioHuevos = :valorUnitarioHuevos"),
    @NamedQuery(name = "ClasificacionHuevos.findByValorTotalHuevos", query = "SELECT c FROM ClasificacionHuevos c WHERE c.valorTotalHuevos = :valorTotalHuevos")})
public class ClasificacionHuevos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_clasificacion")
    private Integer codigoClasificacion;
    @Size(max = 50)
    @Column(name = "tipo_huevos")
    private String tipoHuevos;
    @Column(name = "cantidad_huevos")
    private Integer cantidadHuevos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_huevos")
    private Double porcentajeHuevos;
    @Column(name = "valor_unitario_huevos")
    private Integer valorUnitarioHuevos;
    @Column(name = "valor_total_huevos")
    private Integer valorTotalHuevos;
    @JoinColumn(name = "codigo_reportes_huevos_fk", referencedColumnName = "codigo_reporte_huevos")
    @ManyToOne
    private ReporteHuevos codigoReportesHuevosFk;

    public ClasificacionHuevos() {
    }

    public ClasificacionHuevos(Integer codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }

    public Integer getCodigoClasificacion() {
        return codigoClasificacion;
    }

    public void setCodigoClasificacion(Integer codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }

    public String getTipoHuevos() {
        return tipoHuevos;
    }

    public void setTipoHuevos(String tipoHuevos) {
        this.tipoHuevos = tipoHuevos;
    }

    public Integer getCantidadHuevos() {
        return cantidadHuevos;
    }

    public void setCantidadHuevos(Integer cantidadHuevos) {
        this.cantidadHuevos = cantidadHuevos;
    }

    public Double getPorcentajeHuevos() {
        return porcentajeHuevos;
    }

    public void setPorcentajeHuevos(Double porcentajeHuevos) {
        this.porcentajeHuevos = porcentajeHuevos;
    }

    public Integer getValorUnitarioHuevos() {
        return valorUnitarioHuevos;
    }

    public void setValorUnitarioHuevos(Integer valorUnitarioHuevos) {
        this.valorUnitarioHuevos = valorUnitarioHuevos;
    }

    public Integer getValorTotalHuevos() {
        return valorTotalHuevos;
    }

    public void setValorTotalHuevos(Integer valorTotalHuevos) {
        this.valorTotalHuevos = valorTotalHuevos;
    }

    public ReporteHuevos getCodigoReportesHuevosFk() {
        return codigoReportesHuevosFk;
    }

    public void setCodigoReportesHuevosFk(ReporteHuevos codigoReportesHuevosFk) {
        this.codigoReportesHuevosFk = codigoReportesHuevosFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoClasificacion != null ? codigoClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasificacionHuevos)) {
            return false;
        }
        ClasificacionHuevos other = (ClasificacionHuevos) object;
        if ((this.codigoClasificacion == null && other.codigoClasificacion != null) || (this.codigoClasificacion != null && !this.codigoClasificacion.equals(other.codigoClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClasificacionHuevos[ codigoClasificacion=" + codigoClasificacion + " ]";
    }
    
}
