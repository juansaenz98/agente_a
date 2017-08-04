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
@Table(name = "registro_semanal_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSemanalLevante.findAll", query = "SELECT r FROM RegistroSemanalLevante r"),
    @NamedQuery(name = "RegistroSemanalLevante.findByCodigoRegistroLevante", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.codigoRegistroLevante = :codigoRegistroLevante"),
    @NamedQuery(name = "RegistroSemanalLevante.findByNumeroSemanaRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.numeroSemanaRegistro = :numeroSemanaRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findBySemanaDeRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.semanaDeRegistro = :semanaDeRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findBySemanaARegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.semanaARegistro = :semanaARegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByCantidadTotalSemanaAlimentoRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.cantidadTotalSemanaAlimentoRegistro = :cantidadTotalSemanaAlimentoRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByCostoTotalAlimentoRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.costoTotalAlimentoRegistro = :costoTotalAlimentoRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByPesoPromedioRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.pesoPromedioRegistro = :pesoPromedioRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByNumeroPollasInicialRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.numeroPollasInicialRegistro = :numeroPollasInicialRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByNumeroPollasFinaRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.numeroPollasFinaRegistro = :numeroPollasFinaRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByGramosPollasPorSemana", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.gramosPollasPorSemana = :gramosPollasPorSemana"),
    @NamedQuery(name = "RegistroSemanalLevante.findByPorcentajeMortalidadRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.porcentajeMortalidadRegistro = :porcentajeMortalidadRegistro"),
    @NamedQuery(name = "RegistroSemanalLevante.findByTotalMuertesRegistro", query = "SELECT r FROM RegistroSemanalLevante r WHERE r.totalMuertesRegistro = :totalMuertesRegistro")})
public class RegistroSemanalLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_registro_levante")
    private Integer codigoRegistroLevante;
    @Column(name = "numero_semana_registro")
    private Integer numeroSemanaRegistro;
    @Column(name = "semana_de_registro")
    @Temporal(TemporalType.DATE)
    private Date semanaDeRegistro;
    @Column(name = "semana_a_registro")
    @Temporal(TemporalType.DATE)
    private Date semanaARegistro;
    @Column(name = "cantidad_total_semana_alimento_registro")
    private Integer cantidadTotalSemanaAlimentoRegistro;
    @Column(name = "costo_total_alimento_registro")
    private Integer costoTotalAlimentoRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso_promedio_registro")
    private Double pesoPromedioRegistro;
    @Column(name = "numero_pollas_inicial_registro")
    private Integer numeroPollasInicialRegistro;
    @Column(name = "numero_pollas_fina_registro")
    private Integer numeroPollasFinaRegistro;
    @Column(name = "gramos_pollas_por_semana")
    private Integer gramosPollasPorSemana;
    @Column(name = "porcentaje_mortalidad_registro")
    private Double porcentajeMortalidadRegistro;
    @Column(name = "total_muertes_registro")
    private Integer totalMuertesRegistro;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_registro")
    private String observacionesRegistro;
    @OneToMany(mappedBy = "codigoRegistroLevanteFk")
    private List<ConsumoAlimentoDiarioLevante> consumoAlimentoDiarioLevanteList;
    @OneToMany(mappedBy = "codigoRegistroLevanteFk")
    private List<BajasMuertesDiarioLevante> bajasMuertesDiarioLevanteList;
    @JoinColumn(name = "codigo_tipo_alimento_fk", referencedColumnName = "codigo_tipo_alimento")
    @ManyToOne
    private TipoAlimento codigoTipoAlimentoFk;
    @JoinColumn(name = "numero_lote_fk", referencedColumnName = "numero_lote")
    @ManyToOne
    private LoteLevante numeroLoteFk;

    public RegistroSemanalLevante() {
    }

    public RegistroSemanalLevante(Integer codigoRegistroLevante) {
        this.codigoRegistroLevante = codigoRegistroLevante;
    }

    public Integer getCodigoRegistroLevante() {
        return codigoRegistroLevante;
    }

    public void setCodigoRegistroLevante(Integer codigoRegistroLevante) {
        this.codigoRegistroLevante = codigoRegistroLevante;
    }

    public Integer getNumeroSemanaRegistro() {
        return numeroSemanaRegistro;
    }

    public void setNumeroSemanaRegistro(Integer numeroSemanaRegistro) {
        this.numeroSemanaRegistro = numeroSemanaRegistro;
    }

    public Date getSemanaDeRegistro() {
        return semanaDeRegistro;
    }

    public void setSemanaDeRegistro(Date semanaDeRegistro) {
        this.semanaDeRegistro = semanaDeRegistro;
    }

    public Date getSemanaARegistro() {
        return semanaARegistro;
    }

    public void setSemanaARegistro(Date semanaARegistro) {
        this.semanaARegistro = semanaARegistro;
    }

    public Integer getCantidadTotalSemanaAlimentoRegistro() {
        return cantidadTotalSemanaAlimentoRegistro;
    }

    public void setCantidadTotalSemanaAlimentoRegistro(Integer cantidadTotalSemanaAlimentoRegistro) {
        this.cantidadTotalSemanaAlimentoRegistro = cantidadTotalSemanaAlimentoRegistro;
    }

    public Integer getCostoTotalAlimentoRegistro() {
        return costoTotalAlimentoRegistro;
    }

    public void setCostoTotalAlimentoRegistro(Integer costoTotalAlimentoRegistro) {
        this.costoTotalAlimentoRegistro = costoTotalAlimentoRegistro;
    }

    public Double getPesoPromedioRegistro() {
        return pesoPromedioRegistro;
    }

    public void setPesoPromedioRegistro(Double pesoPromedioRegistro) {
        this.pesoPromedioRegistro = pesoPromedioRegistro;
    }

    public Integer getNumeroPollasInicialRegistro() {
        return numeroPollasInicialRegistro;
    }

    public void setNumeroPollasInicialRegistro(Integer numeroPollasInicialRegistro) {
        this.numeroPollasInicialRegistro = numeroPollasInicialRegistro;
    }

    public Integer getNumeroPollasFinaRegistro() {
        return numeroPollasFinaRegistro;
    }

    public void setNumeroPollasFinaRegistro(Integer numeroPollasFinaRegistro) {
        this.numeroPollasFinaRegistro = numeroPollasFinaRegistro;
    }

    public Integer getGramosPollasPorSemana() {
        return gramosPollasPorSemana;
    }

    public void setGramosPollasPorSemana(Integer gramosPollasPorSemana) {
        this.gramosPollasPorSemana = gramosPollasPorSemana;
    }

    public Double getPorcentajeMortalidadRegistro() {
        return porcentajeMortalidadRegistro;
    }

    public void setPorcentajeMortalidadRegistro(Double porcentajeMortalidadRegistro) {
        this.porcentajeMortalidadRegistro = porcentajeMortalidadRegistro;
    }

    public Integer getTotalMuertesRegistro() {
        return totalMuertesRegistro;
    }

    public void setTotalMuertesRegistro(Integer totalMuertesRegistro) {
        this.totalMuertesRegistro = totalMuertesRegistro;
    }

    public String getObservacionesRegistro() {
        return observacionesRegistro;
    }

    public void setObservacionesRegistro(String observacionesRegistro) {
        this.observacionesRegistro = observacionesRegistro;
    }

    @XmlTransient
    public List<ConsumoAlimentoDiarioLevante> getConsumoAlimentoDiarioLevanteList() {
        return consumoAlimentoDiarioLevanteList;
    }

    public void setConsumoAlimentoDiarioLevanteList(List<ConsumoAlimentoDiarioLevante> consumoAlimentoDiarioLevanteList) {
        this.consumoAlimentoDiarioLevanteList = consumoAlimentoDiarioLevanteList;
    }

    @XmlTransient
    public List<BajasMuertesDiarioLevante> getBajasMuertesDiarioLevanteList() {
        return bajasMuertesDiarioLevanteList;
    }

    public void setBajasMuertesDiarioLevanteList(List<BajasMuertesDiarioLevante> bajasMuertesDiarioLevanteList) {
        this.bajasMuertesDiarioLevanteList = bajasMuertesDiarioLevanteList;
    }

    public TipoAlimento getCodigoTipoAlimentoFk() {
        return codigoTipoAlimentoFk;
    }

    public void setCodigoTipoAlimentoFk(TipoAlimento codigoTipoAlimentoFk) {
        this.codigoTipoAlimentoFk = codigoTipoAlimentoFk;
    }

    public LoteLevante getNumeroLoteFk() {
        return numeroLoteFk;
    }

    public void setNumeroLoteFk(LoteLevante numeroLoteFk) {
        this.numeroLoteFk = numeroLoteFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRegistroLevante != null ? codigoRegistroLevante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSemanalLevante)) {
            return false;
        }
        RegistroSemanalLevante other = (RegistroSemanalLevante) object;
        if ((this.codigoRegistroLevante == null && other.codigoRegistroLevante != null) || (this.codigoRegistroLevante != null && !this.codigoRegistroLevante.equals(other.codigoRegistroLevante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegistroSemanalLevante[ codigoRegistroLevante=" + codigoRegistroLevante + " ]";
    }
    
}
