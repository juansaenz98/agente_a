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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "lote_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoteLevante.findAll", query = "SELECT l FROM LoteLevante l"),
    @NamedQuery(name = "LoteLevante.findByNumeroLote", query = "SELECT l FROM LoteLevante l WHERE l.numeroLote = :numeroLote"),
    @NamedQuery(name = "LoteLevante.findByCodigoLoteLevante", query = "SELECT l FROM LoteLevante l WHERE l.codigoLoteLevante = :codigoLoteLevante"),
    @NamedQuery(name = "LoteLevante.findByFechaNacimiento", query = "SELECT l FROM LoteLevante l WHERE l.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "LoteLevante.findByNumeroPollasFinalLote", query = "SELECT l FROM LoteLevante l WHERE l.numeroPollasFinalLote = :numeroPollasFinalLote"),
    @NamedQuery(name = "LoteLevante.findByPorcentajeMortalidadLoteLevante", query = "SELECT l FROM LoteLevante l WHERE l.porcentajeMortalidadLoteLevante = :porcentajeMortalidadLoteLevante"),
    @NamedQuery(name = "LoteLevante.findByCostoTotalSanidadLote", query = "SELECT l FROM LoteLevante l WHERE l.costoTotalSanidadLote = :costoTotalSanidadLote"),
    @NamedQuery(name = "LoteLevante.findByTotalCostoVariableLote", query = "SELECT l FROM LoteLevante l WHERE l.totalCostoVariableLote = :totalCostoVariableLote"),
    @NamedQuery(name = "LoteLevante.findByNumeroPollasIniciarLote", query = "SELECT l FROM LoteLevante l WHERE l.numeroPollasIniciarLote = :numeroPollasIniciarLote"),
    @NamedQuery(name = "LoteLevante.findByPesoPromedioLoteLevante", query = "SELECT l FROM LoteLevante l WHERE l.pesoPromedioLoteLevante = :pesoPromedioLoteLevante")})
public class LoteLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_lote")
    private Integer numeroLote;
    @Size(max = 50)
    @Column(name = "codigo_lote_levante")
    private String codigoLoteLevante;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "numero_pollas_final_lote")
    private Integer numeroPollasFinalLote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_mortalidad_lote_levante")
    private Double porcentajeMortalidadLoteLevante;
    @Column(name = "costo_total_sanidad_lote")
    private Integer costoTotalSanidadLote;
    @Column(name = "total_costo_variable_lote")
    private Integer totalCostoVariableLote;
    @Column(name = "numero_pollas_iniciar_lote")
    private Integer numeroPollasIniciarLote;
    @Column(name = "peso_promedio_lote_levante")
    private Double pesoPromedioLoteLevante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loteLevante")
    private List<CostosVariablesLoteLevante> costosVariablesLoteLevanteList;
    @OneToMany(mappedBy = "numeroLoteFk")
    private List<LotePonedoras> lotePonedorasList;
    @OneToMany(mappedBy = "numeroLoteFk")
    private List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList;
    @OneToMany(mappedBy = "numeroLote")
    private List<AsignacionLoteLevante> asignacionLoteLevanteList;
    @JoinColumn(name = "numero_galpon_fk", referencedColumnName = "numero_galpon")
    @ManyToOne
    private Galpon numeroGalponFk;
    @JoinColumn(name = "codigo_raza_fk", referencedColumnName = "codigo_raza")
    @ManyToOne
    private Raza codigoRazaFk;
    @OneToMany(mappedBy = "numeroLoteFk")
    private List<RegistroSemanalLevante> registroSemanalLevanteList;

    public LoteLevante() {
    }

    public LoteLevante(Integer numeroLote) {
        this.numeroLote = numeroLote;
    }

    public Integer getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Integer numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getCodigoLoteLevante() {
        return codigoLoteLevante;
    }

    public void setCodigoLoteLevante(String codigoLoteLevante) {
        this.codigoLoteLevante = codigoLoteLevante;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroPollasFinalLote() {
        return numeroPollasFinalLote;
    }

    public void setNumeroPollasFinalLote(Integer numeroPollasFinalLote) {
        this.numeroPollasFinalLote = numeroPollasFinalLote;
    }

    public Double getPorcentajeMortalidadLoteLevante() {
        return porcentajeMortalidadLoteLevante;
    }

    public void setPorcentajeMortalidadLoteLevante(Double porcentajeMortalidadLoteLevante) {
        this.porcentajeMortalidadLoteLevante = porcentajeMortalidadLoteLevante;
    }

    public Integer getCostoTotalSanidadLote() {
        return costoTotalSanidadLote;
    }

    public void setCostoTotalSanidadLote(Integer costoTotalSanidadLote) {
        this.costoTotalSanidadLote = costoTotalSanidadLote;
    }

    public Integer getTotalCostoVariableLote() {
        return totalCostoVariableLote;
    }

    public void setTotalCostoVariableLote(Integer totalCostoVariableLote) {
        this.totalCostoVariableLote = totalCostoVariableLote;
    }

    public Integer getNumeroPollasIniciarLote() {
        return numeroPollasIniciarLote;
    }

    public void setNumeroPollasIniciarLote(Integer numeroPollasIniciarLote) {
        this.numeroPollasIniciarLote = numeroPollasIniciarLote;
    }

    public Double getPesoPromedioLoteLevante() {
        return pesoPromedioLoteLevante;
    }

    public void setPesoPromedioLoteLevante(Double pesoPromedioLoteLevante) {
        this.pesoPromedioLoteLevante = pesoPromedioLoteLevante;
    }

    @XmlTransient
    public List<CostosVariablesLoteLevante> getCostosVariablesLoteLevanteList() {
        return costosVariablesLoteLevanteList;
    }

    public void setCostosVariablesLoteLevanteList(List<CostosVariablesLoteLevante> costosVariablesLoteLevanteList) {
        this.costosVariablesLoteLevanteList = costosVariablesLoteLevanteList;
    }

    @XmlTransient
    public List<LotePonedoras> getLotePonedorasList() {
        return lotePonedorasList;
    }

    public void setLotePonedorasList(List<LotePonedoras> lotePonedorasList) {
        this.lotePonedorasList = lotePonedorasList;
    }

    @XmlTransient
    public List<GuiaVacunacionLoteLevante> getGuiaVacunacionLoteLevanteList() {
        return guiaVacunacionLoteLevanteList;
    }

    public void setGuiaVacunacionLoteLevanteList(List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList) {
        this.guiaVacunacionLoteLevanteList = guiaVacunacionLoteLevanteList;
    }

    @XmlTransient
    public List<AsignacionLoteLevante> getAsignacionLoteLevanteList() {
        return asignacionLoteLevanteList;
    }

    public void setAsignacionLoteLevanteList(List<AsignacionLoteLevante> asignacionLoteLevanteList) {
        this.asignacionLoteLevanteList = asignacionLoteLevanteList;
    }

    public Galpon getNumeroGalponFk() {
        return numeroGalponFk;
    }

    public void setNumeroGalponFk(Galpon numeroGalponFk) {
        this.numeroGalponFk = numeroGalponFk;
    }

    public Raza getCodigoRazaFk() {
        return codigoRazaFk;
    }

    public void setCodigoRazaFk(Raza codigoRazaFk) {
        this.codigoRazaFk = codigoRazaFk;
    }

    @XmlTransient
    public List<RegistroSemanalLevante> getRegistroSemanalLevanteList() {
        return registroSemanalLevanteList;
    }

    public void setRegistroSemanalLevanteList(List<RegistroSemanalLevante> registroSemanalLevanteList) {
        this.registroSemanalLevanteList = registroSemanalLevanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLote != null ? numeroLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteLevante)) {
            return false;
        }
        LoteLevante other = (LoteLevante) object;
        if ((this.numeroLote == null && other.numeroLote != null) || (this.numeroLote != null && !this.numeroLote.equals(other.numeroLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LoteLevante[ numeroLote=" + numeroLote + " ]";
    }
    
}
