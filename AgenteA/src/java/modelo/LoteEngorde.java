/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "lote_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoteEngorde.findAll", query = "SELECT l FROM LoteEngorde l"),
    @NamedQuery(name = "LoteEngorde.findByNumeroLoteEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.numeroLoteEngorde = :numeroLoteEngorde"),
    @NamedQuery(name = "LoteEngorde.findByCodigoLoteEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.codigoLoteEngorde = :codigoLoteEngorde"),
    @NamedQuery(name = "LoteEngorde.findByFechaNacimientoLoteEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.fechaNacimientoLoteEngorde = :fechaNacimientoLoteEngorde"),
    @NamedQuery(name = "LoteEngorde.findByDensidadLoteEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.densidadLoteEngorde = :densidadLoteEngorde"),
    @NamedQuery(name = "LoteEngorde.findByNumeroInicialEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.numeroInicialEngorde = :numeroInicialEngorde"),
    @NamedQuery(name = "LoteEngorde.findByPesoInicialEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.pesoInicialEngorde = :pesoInicialEngorde"),
    @NamedQuery(name = "LoteEngorde.findByTotalPesoPromedioEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.totalPesoPromedioEngorde = :totalPesoPromedioEngorde"),
    @NamedQuery(name = "LoteEngorde.findByNumeroFinalEngorde", query = "SELECT l FROM LoteEngorde l WHERE l.numeroFinalEngorde = :numeroFinalEngorde"),
    @NamedQuery(name = "LoteEngorde.findByTotalVentaCanal", query = "SELECT l FROM LoteEngorde l WHERE l.totalVentaCanal = :totalVentaCanal"),
    @NamedQuery(name = "LoteEngorde.findByTotalVentaVivo", query = "SELECT l FROM LoteEngorde l WHERE l.totalVentaVivo = :totalVentaVivo"),
    @NamedQuery(name = "LoteEngorde.findByPesoVentaVivo", query = "SELECT l FROM LoteEngorde l WHERE l.pesoVentaVivo = :pesoVentaVivo"),
    @NamedQuery(name = "LoteEngorde.findByPesoVentaCanal", query = "SELECT l FROM LoteEngorde l WHERE l.pesoVentaCanal = :pesoVentaCanal")})
public class LoteEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_lote_engorde")
    private Integer numeroLoteEngorde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo_lote_engorde")
    private String codigoLoteEngorde;
    @Column(name = "fecha_nacimiento_lote_engorde")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoLoteEngorde;
    @Column(name = "densidad_lote_engorde")
    private Integer densidadLoteEngorde;
    @Column(name = "numero_inicial_engorde")
    private Integer numeroInicialEngorde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_inicial_engorde")
    private Double pesoInicialEngorde;
    @Column(name = "total_peso_promedio_engorde")
    private Double totalPesoPromedioEngorde;
    @Column(name = "numero_final_engorde")
    private Integer numeroFinalEngorde;
    @Column(name = "total_venta_canal")
    private Integer totalVentaCanal;
    @Column(name = "total_venta_vivo")
    private Integer totalVentaVivo;
    @Column(name = "peso_venta_vivo")
    private Double pesoVentaVivo;
    @Column(name = "peso_venta_canal")
    private Double pesoVentaCanal;
    @OneToMany(mappedBy = "numeroLoteEngorde")
    private List<SanidadEngorde> sanidadEngordeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteEngorde")
    private List<CostosVariablesLoteEngorde> costosVariablesLoteEngordeList;
    @OneToMany(mappedBy = "numeroLoteEngordeFk")
    private List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList;
    @OneToMany(mappedBy = "numeroLoteEngordeFk")
    private List<SacrifioVentaEngorde> sacrifioVentaEngordeList;
    @OneToMany(mappedBy = "numeroLoteEngorde")
    private List<AsignacionLoteEngorde> asignacionLoteEngordeList;
    @JoinColumn(name = "numero_galpo_fk", referencedColumnName = "numero_galpon")
    @ManyToOne
    private Galpon numeroGalpoFk;
    @JoinColumn(name = "codigo_raza_fk", referencedColumnName = "codigo_raza")
    @ManyToOne
    private Raza codigoRazaFk;
    @OneToMany(mappedBy = "numeroLoteEngorde")
    private List<VitaminasEngorde> vitaminasEngordeList;
    @OneToMany(mappedBy = "numeroLoteFk")
    private List<RegistroSemanalLevante> registroSemanalLevanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroLoteEngordeFk")
    private List<RegistroSemanalEngorde> registroSemanalEngordeList;

    public LoteEngorde() {
    }

    public LoteEngorde(Integer numeroLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
    }

    public LoteEngorde(Integer numeroLoteEngorde, String codigoLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
        this.codigoLoteEngorde = codigoLoteEngorde;
    }

    public Integer getNumeroLoteEngorde() {
        return numeroLoteEngorde;
    }

    public void setNumeroLoteEngorde(Integer numeroLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
    }

    public String getCodigoLoteEngorde() {
        return codigoLoteEngorde;
    }

    public void setCodigoLoteEngorde(String codigoLoteEngorde) {
        this.codigoLoteEngorde = codigoLoteEngorde;
    }

    public Date getFechaNacimientoLoteEngorde() {
        return fechaNacimientoLoteEngorde;
    }

    public void setFechaNacimientoLoteEngorde(Date fechaNacimientoLoteEngorde) {
        this.fechaNacimientoLoteEngorde = fechaNacimientoLoteEngorde;
    }

    public Integer getDensidadLoteEngorde() {
        return densidadLoteEngorde;
    }

    public void setDensidadLoteEngorde(Integer densidadLoteEngorde) {
        this.densidadLoteEngorde = densidadLoteEngorde;
    }

    public Integer getNumeroInicialEngorde() {
        return numeroInicialEngorde;
    }

    public void setNumeroInicialEngorde(Integer numeroInicialEngorde) {
        this.numeroInicialEngorde = numeroInicialEngorde;
    }

    public Double getPesoInicialEngorde() {
        return pesoInicialEngorde;
    }

    public void setPesoInicialEngorde(Double pesoInicialEngorde) {
        this.pesoInicialEngorde = pesoInicialEngorde;
    }

    public Double getTotalPesoPromedioEngorde() {
        return totalPesoPromedioEngorde;
    }

    public void setTotalPesoPromedioEngorde(Double totalPesoPromedioEngorde) {
        this.totalPesoPromedioEngorde = totalPesoPromedioEngorde;
    }

    public Integer getNumeroFinalEngorde() {
        return numeroFinalEngorde;
    }

    public void setNumeroFinalEngorde(Integer numeroFinalEngorde) {
        this.numeroFinalEngorde = numeroFinalEngorde;
    }

    public Integer getTotalVentaCanal() {
        return totalVentaCanal;
    }

    public void setTotalVentaCanal(Integer totalVentaCanal) {
        this.totalVentaCanal = totalVentaCanal;
    }

    public Integer getTotalVentaVivo() {
        return totalVentaVivo;
    }

    public void setTotalVentaVivo(Integer totalVentaVivo) {
        this.totalVentaVivo = totalVentaVivo;
    }

    public Double getPesoVentaVivo() {
        return pesoVentaVivo;
    }

    public void setPesoVentaVivo(Double pesoVentaVivo) {
        this.pesoVentaVivo = pesoVentaVivo;
    }

    public Double getPesoVentaCanal() {
        return pesoVentaCanal;
    }

    public void setPesoVentaCanal(Double pesoVentaCanal) {
        this.pesoVentaCanal = pesoVentaCanal;
    }

    @XmlTransient
    public List<SanidadEngorde> getSanidadEngordeList() {
        return sanidadEngordeList;
    }

    public void setSanidadEngordeList(List<SanidadEngorde> sanidadEngordeList) {
        this.sanidadEngordeList = sanidadEngordeList;
    }

    @XmlTransient
    public List<CostosVariablesLoteEngorde> getCostosVariablesLoteEngordeList() {
        return costosVariablesLoteEngordeList;
    }

    public void setCostosVariablesLoteEngordeList(List<CostosVariablesLoteEngorde> costosVariablesLoteEngordeList) {
        this.costosVariablesLoteEngordeList = costosVariablesLoteEngordeList;
    }

    @XmlTransient
    public List<GuiaVacunacionLoteEngorde> getGuiaVacunacionLoteEngordeList() {
        return guiaVacunacionLoteEngordeList;
    }

    public void setGuiaVacunacionLoteEngordeList(List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList) {
        this.guiaVacunacionLoteEngordeList = guiaVacunacionLoteEngordeList;
    }

    @XmlTransient
    public List<SacrifioVentaEngorde> getSacrifioVentaEngordeList() {
        return sacrifioVentaEngordeList;
    }

    public void setSacrifioVentaEngordeList(List<SacrifioVentaEngorde> sacrifioVentaEngordeList) {
        this.sacrifioVentaEngordeList = sacrifioVentaEngordeList;
    }

    @XmlTransient
    public List<AsignacionLoteEngorde> getAsignacionLoteEngordeList() {
        return asignacionLoteEngordeList;
    }

    public void setAsignacionLoteEngordeList(List<AsignacionLoteEngorde> asignacionLoteEngordeList) {
        this.asignacionLoteEngordeList = asignacionLoteEngordeList;
    }

    public Galpon getNumeroGalpoFk() {
        return numeroGalpoFk;
    }

    public void setNumeroGalpoFk(Galpon numeroGalpoFk) {
        this.numeroGalpoFk = numeroGalpoFk;
    }

    public Raza getCodigoRazaFk() {
        return codigoRazaFk;
    }

    public void setCodigoRazaFk(Raza codigoRazaFk) {
        this.codigoRazaFk = codigoRazaFk;
    }

    @XmlTransient
    public List<VitaminasEngorde> getVitaminasEngordeList() {
        return vitaminasEngordeList;
    }

    public void setVitaminasEngordeList(List<VitaminasEngorde> vitaminasEngordeList) {
        this.vitaminasEngordeList = vitaminasEngordeList;
    }

    @XmlTransient
    public List<RegistroSemanalLevante> getRegistroSemanalLevanteList() {
        return registroSemanalLevanteList;
    }

    public void setRegistroSemanalLevanteList(List<RegistroSemanalLevante> registroSemanalLevanteList) {
        this.registroSemanalLevanteList = registroSemanalLevanteList;
    }

    @XmlTransient
    public List<RegistroSemanalEngorde> getRegistroSemanalEngordeList() {
        return registroSemanalEngordeList;
    }

    public void setRegistroSemanalEngordeList(List<RegistroSemanalEngorde> registroSemanalEngordeList) {
        this.registroSemanalEngordeList = registroSemanalEngordeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLoteEngorde != null ? numeroLoteEngorde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteEngorde)) {
            return false;
        }
        LoteEngorde other = (LoteEngorde) object;
        if ((this.numeroLoteEngorde == null && other.numeroLoteEngorde != null) || (this.numeroLoteEngorde != null && !this.numeroLoteEngorde.equals(other.numeroLoteEngorde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LoteEngorde[ numeroLoteEngorde=" + numeroLoteEngorde + " ]";
    }
    
}
