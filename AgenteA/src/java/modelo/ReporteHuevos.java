/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "reporte_huevos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteHuevos.findAll", query = "SELECT r FROM ReporteHuevos r"),
    @NamedQuery(name = "ReporteHuevos.findByCodigoReporteHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.codigoReporteHuevos = :codigoReporteHuevos"),
    @NamedQuery(name = "ReporteHuevos.findByNumeroPesadosHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.numeroPesadosHuevos = :numeroPesadosHuevos"),
    @NamedQuery(name = "ReporteHuevos.findByPesoTotalHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.pesoTotalHuevos = :pesoTotalHuevos"),
    @NamedQuery(name = "ReporteHuevos.findByPesoPanalesHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.pesoPanalesHuevos = :pesoPanalesHuevos"),
    @NamedQuery(name = "ReporteHuevos.findByPesoHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.pesoHuevos = :pesoHuevos"),
    @NamedQuery(name = "ReporteHuevos.findByPesoPromedioHuevos", query = "SELECT r FROM ReporteHuevos r WHERE r.pesoPromedioHuevos = :pesoPromedioHuevos")})
public class ReporteHuevos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_reporte_huevos")
    private Integer codigoReporteHuevos;
    @Column(name = "numero_pesados_huevos")
    private Integer numeroPesadosHuevos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_total_huevos")
    private Double pesoTotalHuevos;
    @Column(name = "peso_panales_huevos")
    private Double pesoPanalesHuevos;
    @Column(name = "peso_huevos")
    private Double pesoHuevos;
    @Column(name = "peso_promedio_huevos")
    private Double pesoPromedioHuevos;
    @JoinColumn(name = "codigo_registro_diario_ponedoras_fk", referencedColumnName = "codigo_registro_diario_ponedoraas")
    @ManyToOne
    private RegistroDiarioPonedoras codigoRegistroDiarioPonedorasFk;
    @OneToMany(mappedBy = "codigoReportesHuevosFk")
    private List<ClasificacionHuevos> clasificacionHuevosList;

    public ReporteHuevos() {
    }

    public ReporteHuevos(Integer codigoReporteHuevos) {
        this.codigoReporteHuevos = codigoReporteHuevos;
    }

    public Integer getCodigoReporteHuevos() {
        return codigoReporteHuevos;
    }

    public void setCodigoReporteHuevos(Integer codigoReporteHuevos) {
        this.codigoReporteHuevos = codigoReporteHuevos;
    }

    public Integer getNumeroPesadosHuevos() {
        return numeroPesadosHuevos;
    }

    public void setNumeroPesadosHuevos(Integer numeroPesadosHuevos) {
        this.numeroPesadosHuevos = numeroPesadosHuevos;
    }

    public Double getPesoTotalHuevos() {
        return pesoTotalHuevos;
    }

    public void setPesoTotalHuevos(Double pesoTotalHuevos) {
        this.pesoTotalHuevos = pesoTotalHuevos;
    }

    public Double getPesoPanalesHuevos() {
        return pesoPanalesHuevos;
    }

    public void setPesoPanalesHuevos(Double pesoPanalesHuevos) {
        this.pesoPanalesHuevos = pesoPanalesHuevos;
    }

    public Double getPesoHuevos() {
        return pesoHuevos;
    }

    public void setPesoHuevos(Double pesoHuevos) {
        this.pesoHuevos = pesoHuevos;
    }

    public Double getPesoPromedioHuevos() {
        return pesoPromedioHuevos;
    }

    public void setPesoPromedioHuevos(Double pesoPromedioHuevos) {
        this.pesoPromedioHuevos = pesoPromedioHuevos;
    }

    public RegistroDiarioPonedoras getCodigoRegistroDiarioPonedorasFk() {
        return codigoRegistroDiarioPonedorasFk;
    }

    public void setCodigoRegistroDiarioPonedorasFk(RegistroDiarioPonedoras codigoRegistroDiarioPonedorasFk) {
        this.codigoRegistroDiarioPonedorasFk = codigoRegistroDiarioPonedorasFk;
    }

    @XmlTransient
    public List<ClasificacionHuevos> getClasificacionHuevosList() {
        return clasificacionHuevosList;
    }

    public void setClasificacionHuevosList(List<ClasificacionHuevos> clasificacionHuevosList) {
        this.clasificacionHuevosList = clasificacionHuevosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoReporteHuevos != null ? codigoReporteHuevos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteHuevos)) {
            return false;
        }
        ReporteHuevos other = (ReporteHuevos) object;
        if ((this.codigoReporteHuevos == null && other.codigoReporteHuevos != null) || (this.codigoReporteHuevos != null && !this.codigoReporteHuevos.equals(other.codigoReporteHuevos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ReporteHuevos[ codigoReporteHuevos=" + codigoReporteHuevos + " ]";
    }
    
}
