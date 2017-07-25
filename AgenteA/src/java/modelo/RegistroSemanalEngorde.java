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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "registro_semanal_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSemanalEngorde.findAll", query = "SELECT r FROM RegistroSemanalEngorde r"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByCodigoRegistroEngorde", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.codigoRegistroEngorde = :codigoRegistroEngorde"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByNumeroSemanaRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.numeroSemanaRegistro = :numeroSemanaRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findBySemanaDeRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.semanaDeRegistro = :semanaDeRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findBySemanaARegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.semanaARegistro = :semanaARegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByCantidadTotalSemanaAlimentoRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.cantidadTotalSemanaAlimentoRegistro = :cantidadTotalSemanaAlimentoRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByCostoTotalAlimentoRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.costoTotalAlimentoRegistro = :costoTotalAlimentoRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByTotalAcumuladoRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.totalAcumuladoRegistro = :totalAcumuladoRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByConsumoPorPolloRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.consumoPorPolloRegistro = :consumoPorPolloRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByPesoPromedioRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.pesoPromedioRegistro = :pesoPromedioRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByNumeroAnimalesIniciarSemana", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.numeroAnimalesIniciarSemana = :numeroAnimalesIniciarSemana"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByNumeroAnimalesFinalSemana", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.numeroAnimalesFinalSemana = :numeroAnimalesFinalSemana"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByTotalMuertesRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.totalMuertesRegistro = :totalMuertesRegistro"),
    @NamedQuery(name = "RegistroSemanalEngorde.findByPorcentajeMuertesRegistro", query = "SELECT r FROM RegistroSemanalEngorde r WHERE r.porcentajeMuertesRegistro = :porcentajeMuertesRegistro")})
public class RegistroSemanalEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_registro_engorde")
    private Integer codigoRegistroEngorde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_semana_registro")
    private int numeroSemanaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semana_de_registro")
    @Temporal(TemporalType.DATE)
    private Date semanaDeRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semana_a_registro")
    @Temporal(TemporalType.DATE)
    private Date semanaARegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_total_semana_alimento_registro")
    private int cantidadTotalSemanaAlimentoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_total_alimento_registro")
    private int costoTotalAlimentoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_acumulado_registro")
    private int totalAcumuladoRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consumo_por_pollo_registro")
    private int consumoPorPolloRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_promedio_registro")
    private double pesoPromedioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_animales_iniciar_semana")
    private int numeroAnimalesIniciarSemana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_animales_final_semana")
    private int numeroAnimalesFinalSemana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_muertes_registro")
    private int totalMuertesRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_muertes_registro")
    private double porcentajeMuertesRegistro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones_registro")
    private String observacionesRegistro;
    @OneToMany(mappedBy = "codigoRegistroEngordeFk")
    private List<ConsumoAlimentoDiarioEngorde> consumoAlimentoDiarioEngordeList;
    @OneToMany(mappedBy = "codigoRegistroEngorde")
    private List<BajasMuertesDiarioEngorde> bajasMuertesDiarioEngordeList;
    @JoinColumn(name = "numero_lote_engorde_fk", referencedColumnName = "numero_lote_engorde")
    @ManyToOne(optional = false)
    private LoteEngorde numeroLoteEngordeFk;
    @JoinColumn(name = "codigo_tipo_alimento_fk", referencedColumnName = "codigo_tipo_alimento")
    @ManyToOne(optional = false)
    private TipoAlimento codigoTipoAlimentoFk;

    public RegistroSemanalEngorde() {
    }

    public RegistroSemanalEngorde(Integer codigoRegistroEngorde) {
        this.codigoRegistroEngorde = codigoRegistroEngorde;
    }

    public RegistroSemanalEngorde(Integer codigoRegistroEngorde, int numeroSemanaRegistro, Date semanaDeRegistro, Date semanaARegistro, int cantidadTotalSemanaAlimentoRegistro, int costoTotalAlimentoRegistro, int totalAcumuladoRegistro, int consumoPorPolloRegistro, double pesoPromedioRegistro, int numeroAnimalesIniciarSemana, int numeroAnimalesFinalSemana, int totalMuertesRegistro, double porcentajeMuertesRegistro, String observacionesRegistro) {
        this.codigoRegistroEngorde = codigoRegistroEngorde;
        this.numeroSemanaRegistro = numeroSemanaRegistro;
        this.semanaDeRegistro = semanaDeRegistro;
        this.semanaARegistro = semanaARegistro;
        this.cantidadTotalSemanaAlimentoRegistro = cantidadTotalSemanaAlimentoRegistro;
        this.costoTotalAlimentoRegistro = costoTotalAlimentoRegistro;
        this.totalAcumuladoRegistro = totalAcumuladoRegistro;
        this.consumoPorPolloRegistro = consumoPorPolloRegistro;
        this.pesoPromedioRegistro = pesoPromedioRegistro;
        this.numeroAnimalesIniciarSemana = numeroAnimalesIniciarSemana;
        this.numeroAnimalesFinalSemana = numeroAnimalesFinalSemana;
        this.totalMuertesRegistro = totalMuertesRegistro;
        this.porcentajeMuertesRegistro = porcentajeMuertesRegistro;
        this.observacionesRegistro = observacionesRegistro;
    }

    public Integer getCodigoRegistroEngorde() {
        return codigoRegistroEngorde;
    }

    public void setCodigoRegistroEngorde(Integer codigoRegistroEngorde) {
        this.codigoRegistroEngorde = codigoRegistroEngorde;
    }

    public int getNumeroSemanaRegistro() {
        return numeroSemanaRegistro;
    }

    public void setNumeroSemanaRegistro(int numeroSemanaRegistro) {
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

    public int getCantidadTotalSemanaAlimentoRegistro() {
        return cantidadTotalSemanaAlimentoRegistro;
    }

    public void setCantidadTotalSemanaAlimentoRegistro(int cantidadTotalSemanaAlimentoRegistro) {
        this.cantidadTotalSemanaAlimentoRegistro = cantidadTotalSemanaAlimentoRegistro;
    }

    public int getCostoTotalAlimentoRegistro() {
        return costoTotalAlimentoRegistro;
    }

    public void setCostoTotalAlimentoRegistro(int costoTotalAlimentoRegistro) {
        this.costoTotalAlimentoRegistro = costoTotalAlimentoRegistro;
    }

    public int getTotalAcumuladoRegistro() {
        return totalAcumuladoRegistro;
    }

    public void setTotalAcumuladoRegistro(int totalAcumuladoRegistro) {
        this.totalAcumuladoRegistro = totalAcumuladoRegistro;
    }

    public int getConsumoPorPolloRegistro() {
        return consumoPorPolloRegistro;
    }

    public void setConsumoPorPolloRegistro(int consumoPorPolloRegistro) {
        this.consumoPorPolloRegistro = consumoPorPolloRegistro;
    }

    public double getPesoPromedioRegistro() {
        return pesoPromedioRegistro;
    }

    public void setPesoPromedioRegistro(double pesoPromedioRegistro) {
        this.pesoPromedioRegistro = pesoPromedioRegistro;
    }

    public int getNumeroAnimalesIniciarSemana() {
        return numeroAnimalesIniciarSemana;
    }

    public void setNumeroAnimalesIniciarSemana(int numeroAnimalesIniciarSemana) {
        this.numeroAnimalesIniciarSemana = numeroAnimalesIniciarSemana;
    }

    public int getNumeroAnimalesFinalSemana() {
        return numeroAnimalesFinalSemana;
    }

    public void setNumeroAnimalesFinalSemana(int numeroAnimalesFinalSemana) {
        this.numeroAnimalesFinalSemana = numeroAnimalesFinalSemana;
    }

    public int getTotalMuertesRegistro() {
        return totalMuertesRegistro;
    }

    public void setTotalMuertesRegistro(int totalMuertesRegistro) {
        this.totalMuertesRegistro = totalMuertesRegistro;
    }

    public double getPorcentajeMuertesRegistro() {
        return porcentajeMuertesRegistro;
    }

    public void setPorcentajeMuertesRegistro(double porcentajeMuertesRegistro) {
        this.porcentajeMuertesRegistro = porcentajeMuertesRegistro;
    }

    public String getObservacionesRegistro() {
        return observacionesRegistro;
    }

    public void setObservacionesRegistro(String observacionesRegistro) {
        this.observacionesRegistro = observacionesRegistro;
    }

    @XmlTransient
    public List<ConsumoAlimentoDiarioEngorde> getConsumoAlimentoDiarioEngordeList() {
        return consumoAlimentoDiarioEngordeList;
    }

    public void setConsumoAlimentoDiarioEngordeList(List<ConsumoAlimentoDiarioEngorde> consumoAlimentoDiarioEngordeList) {
        this.consumoAlimentoDiarioEngordeList = consumoAlimentoDiarioEngordeList;
    }

    @XmlTransient
    public List<BajasMuertesDiarioEngorde> getBajasMuertesDiarioEngordeList() {
        return bajasMuertesDiarioEngordeList;
    }

    public void setBajasMuertesDiarioEngordeList(List<BajasMuertesDiarioEngorde> bajasMuertesDiarioEngordeList) {
        this.bajasMuertesDiarioEngordeList = bajasMuertesDiarioEngordeList;
    }

    public LoteEngorde getNumeroLoteEngordeFk() {
        return numeroLoteEngordeFk;
    }

    public void setNumeroLoteEngordeFk(LoteEngorde numeroLoteEngordeFk) {
        this.numeroLoteEngordeFk = numeroLoteEngordeFk;
    }

    public TipoAlimento getCodigoTipoAlimentoFk() {
        return codigoTipoAlimentoFk;
    }

    public void setCodigoTipoAlimentoFk(TipoAlimento codigoTipoAlimentoFk) {
        this.codigoTipoAlimentoFk = codigoTipoAlimentoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRegistroEngorde != null ? codigoRegistroEngorde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSemanalEngorde)) {
            return false;
        }
        RegistroSemanalEngorde other = (RegistroSemanalEngorde) object;
        if ((this.codigoRegistroEngorde == null && other.codigoRegistroEngorde != null) || (this.codigoRegistroEngorde != null && !this.codigoRegistroEngorde.equals(other.codigoRegistroEngorde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegistroSemanalEngorde[ codigoRegistroEngorde=" + codigoRegistroEngorde + " ]";
    }
    
}
