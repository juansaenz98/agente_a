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
@Table(name = "produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p"),
    @NamedQuery(name = "Produccion.findByCodigoProduccion", query = "SELECT p FROM Produccion p WHERE p.codigoProduccion = :codigoProduccion"),
    @NamedQuery(name = "Produccion.findByNumeroPonedorasPresentePromedio", query = "SELECT p FROM Produccion p WHERE p.numeroPonedorasPresentePromedio = :numeroPonedorasPresentePromedio"),
    @NamedQuery(name = "Produccion.findByPorcentajeMortalidad", query = "SELECT p FROM Produccion p WHERE p.porcentajeMortalidad = :porcentajeMortalidad"),
    @NamedQuery(name = "Produccion.findByNumeroHuevosPpe", query = "SELECT p FROM Produccion p WHERE p.numeroHuevosPpe = :numeroHuevosPpe"),
    @NamedQuery(name = "Produccion.findByKgHuevosPpe", query = "SELECT p FROM Produccion p WHERE p.kgHuevosPpe = :kgHuevosPpe"),
    @NamedQuery(name = "Produccion.findByPesoPromedioXHuevos", query = "SELECT p FROM Produccion p WHERE p.pesoPromedioXHuevos = :pesoPromedioXHuevos"),
    @NamedQuery(name = "Produccion.findByPorcentajePostura", query = "SELECT p FROM Produccion p WHERE p.porcentajePostura = :porcentajePostura"),
    @NamedQuery(name = "Produccion.findByDocenaHuevos", query = "SELECT p FROM Produccion p WHERE p.docenaHuevos = :docenaHuevos")})
public class Produccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_produccion")
    private Integer codigoProduccion;
    @Column(name = "numero_ponedoras_presente_promedio")
    private Integer numeroPonedorasPresentePromedio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_mortalidad")
    private Double porcentajeMortalidad;
    @Column(name = "numero_huevos_ppe")
    private Double numeroHuevosPpe;
    @Column(name = "kg_huevos_ppe")
    private Double kgHuevosPpe;
    @Column(name = "peso_promedio_x_huevos")
    private Double pesoPromedioXHuevos;
    @Column(name = "porcentaje_postura")
    private Double porcentajePostura;
    @Column(name = "docena_huevos")
    private Double docenaHuevos;
    @OneToMany(mappedBy = "codigoProduccionFk")
    private List<LotePonedoras> lotePonedorasList;
    @JoinColumn(name = "codigo_registro_ponedoras_fk", referencedColumnName = "codigo_registro_ponedoras")
    @ManyToOne
    private RegistroSemanalPonedoras codigoRegistroPonedorasFk;

    public Produccion() {
    }

    public Produccion(Integer codigoProduccion) {
        this.codigoProduccion = codigoProduccion;
    }

    public Integer getCodigoProduccion() {
        return codigoProduccion;
    }

    public void setCodigoProduccion(Integer codigoProduccion) {
        this.codigoProduccion = codigoProduccion;
    }

    public Integer getNumeroPonedorasPresentePromedio() {
        return numeroPonedorasPresentePromedio;
    }

    public void setNumeroPonedorasPresentePromedio(Integer numeroPonedorasPresentePromedio) {
        this.numeroPonedorasPresentePromedio = numeroPonedorasPresentePromedio;
    }

    public Double getPorcentajeMortalidad() {
        return porcentajeMortalidad;
    }

    public void setPorcentajeMortalidad(Double porcentajeMortalidad) {
        this.porcentajeMortalidad = porcentajeMortalidad;
    }

    public Double getNumeroHuevosPpe() {
        return numeroHuevosPpe;
    }

    public void setNumeroHuevosPpe(Double numeroHuevosPpe) {
        this.numeroHuevosPpe = numeroHuevosPpe;
    }

    public Double getKgHuevosPpe() {
        return kgHuevosPpe;
    }

    public void setKgHuevosPpe(Double kgHuevosPpe) {
        this.kgHuevosPpe = kgHuevosPpe;
    }

    public Double getPesoPromedioXHuevos() {
        return pesoPromedioXHuevos;
    }

    public void setPesoPromedioXHuevos(Double pesoPromedioXHuevos) {
        this.pesoPromedioXHuevos = pesoPromedioXHuevos;
    }

    public Double getPorcentajePostura() {
        return porcentajePostura;
    }

    public void setPorcentajePostura(Double porcentajePostura) {
        this.porcentajePostura = porcentajePostura;
    }

    public Double getDocenaHuevos() {
        return docenaHuevos;
    }

    public void setDocenaHuevos(Double docenaHuevos) {
        this.docenaHuevos = docenaHuevos;
    }

    @XmlTransient
    public List<LotePonedoras> getLotePonedorasList() {
        return lotePonedorasList;
    }

    public void setLotePonedorasList(List<LotePonedoras> lotePonedorasList) {
        this.lotePonedorasList = lotePonedorasList;
    }

    public RegistroSemanalPonedoras getCodigoRegistroPonedorasFk() {
        return codigoRegistroPonedorasFk;
    }

    public void setCodigoRegistroPonedorasFk(RegistroSemanalPonedoras codigoRegistroPonedorasFk) {
        this.codigoRegistroPonedorasFk = codigoRegistroPonedorasFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProduccion != null ? codigoProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.codigoProduccion == null && other.codigoProduccion != null) || (this.codigoProduccion != null && !this.codigoProduccion.equals(other.codigoProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Produccion[ codigoProduccion=" + codigoProduccion + " ]";
    }
    
}
