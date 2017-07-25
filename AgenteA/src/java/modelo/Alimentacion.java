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
@Table(name = "alimentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimentacion.findAll", query = "SELECT a FROM Alimentacion a"),
    @NamedQuery(name = "Alimentacion.findByCodigoAlimentacion", query = "SELECT a FROM Alimentacion a WHERE a.codigoAlimentacion = :codigoAlimentacion"),
    @NamedQuery(name = "Alimentacion.findByConsumoDiarioPpp", query = "SELECT a FROM Alimentacion a WHERE a.consumoDiarioPpp = :consumoDiarioPpp"),
    @NamedQuery(name = "Alimentacion.findByConversionKgHuevo", query = "SELECT a FROM Alimentacion a WHERE a.conversionKgHuevo = :conversionKgHuevo"),
    @NamedQuery(name = "Alimentacion.findByConversionDocenaHuevos", query = "SELECT a FROM Alimentacion a WHERE a.conversionDocenaHuevos = :conversionDocenaHuevos")})
public class Alimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_alimentacion")
    private Integer codigoAlimentacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "consumo_diario_ppp")
    private Double consumoDiarioPpp;
    @Column(name = "conversion_kg_huevo")
    private Double conversionKgHuevo;
    @Column(name = "conversion_docena_huevos")
    private Double conversionDocenaHuevos;
    @OneToMany(mappedBy = "codigoAlimentacionFk")
    private List<LotePonedoras> lotePonedorasList;
    @JoinColumn(name = "codigo_registro_ponedoras_fk1", referencedColumnName = "codigo_registro_ponedoras")
    @ManyToOne
    private RegistroSemanalPonedoras codigoRegistroPonedorasFk1;

    public Alimentacion() {
    }

    public Alimentacion(Integer codigoAlimentacion) {
        this.codigoAlimentacion = codigoAlimentacion;
    }

    public Integer getCodigoAlimentacion() {
        return codigoAlimentacion;
    }

    public void setCodigoAlimentacion(Integer codigoAlimentacion) {
        this.codigoAlimentacion = codigoAlimentacion;
    }

    public Double getConsumoDiarioPpp() {
        return consumoDiarioPpp;
    }

    public void setConsumoDiarioPpp(Double consumoDiarioPpp) {
        this.consumoDiarioPpp = consumoDiarioPpp;
    }

    public Double getConversionKgHuevo() {
        return conversionKgHuevo;
    }

    public void setConversionKgHuevo(Double conversionKgHuevo) {
        this.conversionKgHuevo = conversionKgHuevo;
    }

    public Double getConversionDocenaHuevos() {
        return conversionDocenaHuevos;
    }

    public void setConversionDocenaHuevos(Double conversionDocenaHuevos) {
        this.conversionDocenaHuevos = conversionDocenaHuevos;
    }

    @XmlTransient
    public List<LotePonedoras> getLotePonedorasList() {
        return lotePonedorasList;
    }

    public void setLotePonedorasList(List<LotePonedoras> lotePonedorasList) {
        this.lotePonedorasList = lotePonedorasList;
    }

    public RegistroSemanalPonedoras getCodigoRegistroPonedorasFk1() {
        return codigoRegistroPonedorasFk1;
    }

    public void setCodigoRegistroPonedorasFk1(RegistroSemanalPonedoras codigoRegistroPonedorasFk1) {
        this.codigoRegistroPonedorasFk1 = codigoRegistroPonedorasFk1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAlimentacion != null ? codigoAlimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentacion)) {
            return false;
        }
        Alimentacion other = (Alimentacion) object;
        if ((this.codigoAlimentacion == null && other.codigoAlimentacion != null) || (this.codigoAlimentacion != null && !this.codigoAlimentacion.equals(other.codigoAlimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alimentacion[ codigoAlimentacion=" + codigoAlimentacion + " ]";
    }
    
}
