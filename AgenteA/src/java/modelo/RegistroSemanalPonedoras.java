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
@Table(name = "registro_semanal_ponedoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSemanalPonedoras.findAll", query = "SELECT r FROM RegistroSemanalPonedoras r"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByCodigoRegistroPonedoras", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.codigoRegistroPonedoras = :codigoRegistroPonedoras"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findBySemanaProduccionRegistro", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.semanaProduccionRegistro = :semanaProduccionRegistro"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByNumeroPonedorasInicial", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.numeroPonedorasInicial = :numeroPonedorasInicial"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByNumeroPonedorasTerminar", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.numeroPonedorasTerminar = :numeroPonedorasTerminar"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByTotalHuevosSemana", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.totalHuevosSemana = :totalHuevosSemana"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByTotalHuevosSegundaSemana", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.totalHuevosSegundaSemana = :totalHuevosSegundaSemana"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByTotalKgSemana", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.totalKgSemana = :totalKgSemana"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByTotalMortalidadSemana", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.totalMortalidadSemana = :totalMortalidadSemana"),
    @NamedQuery(name = "RegistroSemanalPonedoras.findByTotalDesechoSemana", query = "SELECT r FROM RegistroSemanalPonedoras r WHERE r.totalDesechoSemana = :totalDesechoSemana")})
public class RegistroSemanalPonedoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_registro_ponedoras")
    private Integer codigoRegistroPonedoras;
    @Column(name = "semana_produccion_registro")
    private Integer semanaProduccionRegistro;
    @Column(name = "numero_ponedoras_inicial")
    private Integer numeroPonedorasInicial;
    @Column(name = "numero_ponedoras_terminar")
    private Integer numeroPonedorasTerminar;
    @Column(name = "total_huevos_semana")
    private Integer totalHuevosSemana;
    @Column(name = "total_huevos_segunda_semana")
    private Integer totalHuevosSegundaSemana;
    @Column(name = "total_kg_semana")
    private Integer totalKgSemana;
    @Column(name = "total_mortalidad_semana")
    private Integer totalMortalidadSemana;
    @Column(name = "total_desecho_semana")
    private Integer totalDesechoSemana;
    @JoinColumn(name = "numero_lote_ponedoras_fk", referencedColumnName = "numero_lote_ponedoras")
    @ManyToOne
    private LotePonedoras numeroLotePonedorasFk;
    @OneToMany(mappedBy = "codigoRegistroPonedorasFk")
    private List<Produccion> produccionList;
    @OneToMany(mappedBy = "codigoRegistroPonedorasFk1")
    private List<Alimentacion> alimentacionList;
    @OneToMany(mappedBy = "codigoRegistroPonedorasFk")
    private List<Economia> economiaList;
    @OneToMany(mappedBy = "codigoRegistroPonedorasFk")
    private List<RegistroDiarioPonedoras> registroDiarioPonedorasList;

    public RegistroSemanalPonedoras() {
    }

    public RegistroSemanalPonedoras(Integer codigoRegistroPonedoras) {
        this.codigoRegistroPonedoras = codigoRegistroPonedoras;
    }

    public Integer getCodigoRegistroPonedoras() {
        return codigoRegistroPonedoras;
    }

    public void setCodigoRegistroPonedoras(Integer codigoRegistroPonedoras) {
        this.codigoRegistroPonedoras = codigoRegistroPonedoras;
    }

    public Integer getSemanaProduccionRegistro() {
        return semanaProduccionRegistro;
    }

    public void setSemanaProduccionRegistro(Integer semanaProduccionRegistro) {
        this.semanaProduccionRegistro = semanaProduccionRegistro;
    }

    public Integer getNumeroPonedorasInicial() {
        return numeroPonedorasInicial;
    }

    public void setNumeroPonedorasInicial(Integer numeroPonedorasInicial) {
        this.numeroPonedorasInicial = numeroPonedorasInicial;
    }

    public Integer getNumeroPonedorasTerminar() {
        return numeroPonedorasTerminar;
    }

    public void setNumeroPonedorasTerminar(Integer numeroPonedorasTerminar) {
        this.numeroPonedorasTerminar = numeroPonedorasTerminar;
    }

    public Integer getTotalHuevosSemana() {
        return totalHuevosSemana;
    }

    public void setTotalHuevosSemana(Integer totalHuevosSemana) {
        this.totalHuevosSemana = totalHuevosSemana;
    }

    public Integer getTotalHuevosSegundaSemana() {
        return totalHuevosSegundaSemana;
    }

    public void setTotalHuevosSegundaSemana(Integer totalHuevosSegundaSemana) {
        this.totalHuevosSegundaSemana = totalHuevosSegundaSemana;
    }

    public Integer getTotalKgSemana() {
        return totalKgSemana;
    }

    public void setTotalKgSemana(Integer totalKgSemana) {
        this.totalKgSemana = totalKgSemana;
    }

    public Integer getTotalMortalidadSemana() {
        return totalMortalidadSemana;
    }

    public void setTotalMortalidadSemana(Integer totalMortalidadSemana) {
        this.totalMortalidadSemana = totalMortalidadSemana;
    }

    public Integer getTotalDesechoSemana() {
        return totalDesechoSemana;
    }

    public void setTotalDesechoSemana(Integer totalDesechoSemana) {
        this.totalDesechoSemana = totalDesechoSemana;
    }

    public LotePonedoras getNumeroLotePonedorasFk() {
        return numeroLotePonedorasFk;
    }

    public void setNumeroLotePonedorasFk(LotePonedoras numeroLotePonedorasFk) {
        this.numeroLotePonedorasFk = numeroLotePonedorasFk;
    }

    @XmlTransient
    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @XmlTransient
    public List<Alimentacion> getAlimentacionList() {
        return alimentacionList;
    }

    public void setAlimentacionList(List<Alimentacion> alimentacionList) {
        this.alimentacionList = alimentacionList;
    }

    @XmlTransient
    public List<Economia> getEconomiaList() {
        return economiaList;
    }

    public void setEconomiaList(List<Economia> economiaList) {
        this.economiaList = economiaList;
    }

    @XmlTransient
    public List<RegistroDiarioPonedoras> getRegistroDiarioPonedorasList() {
        return registroDiarioPonedorasList;
    }

    public void setRegistroDiarioPonedorasList(List<RegistroDiarioPonedoras> registroDiarioPonedorasList) {
        this.registroDiarioPonedorasList = registroDiarioPonedorasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRegistroPonedoras != null ? codigoRegistroPonedoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSemanalPonedoras)) {
            return false;
        }
        RegistroSemanalPonedoras other = (RegistroSemanalPonedoras) object;
        if ((this.codigoRegistroPonedoras == null && other.codigoRegistroPonedoras != null) || (this.codigoRegistroPonedoras != null && !this.codigoRegistroPonedoras.equals(other.codigoRegistroPonedoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegistroSemanalPonedoras[ codigoRegistroPonedoras=" + codigoRegistroPonedoras + " ]";
    }
    
}
