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
@Table(name = "economia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Economia.findAll", query = "SELECT e FROM Economia e"),
    @NamedQuery(name = "Economia.findByCodigoEconomia", query = "SELECT e FROM Economia e WHERE e.codigoEconomia = :codigoEconomia"),
    @NamedQuery(name = "Economia.findByPrecioAlimentoKg", query = "SELECT e FROM Economia e WHERE e.precioAlimentoKg = :precioAlimentoKg"),
    @NamedQuery(name = "Economia.findByCostoAlimentacionTotal", query = "SELECT e FROM Economia e WHERE e.costoAlimentacionTotal = :costoAlimentacionTotal"),
    @NamedQuery(name = "Economia.findByCostoAlimentacionHuevos", query = "SELECT e FROM Economia e WHERE e.costoAlimentacionHuevos = :costoAlimentacionHuevos"),
    @NamedQuery(name = "Economia.findByValorHuevos", query = "SELECT e FROM Economia e WHERE e.valorHuevos = :valorHuevos"),
    @NamedQuery(name = "Economia.findByValorHuevosCosto", query = "SELECT e FROM Economia e WHERE e.valorHuevosCosto = :valorHuevosCosto"),
    @NamedQuery(name = "Economia.findByOtrosIngresos", query = "SELECT e FROM Economia e WHERE e.otrosIngresos = :otrosIngresos"),
    @NamedQuery(name = "Economia.findByOtrosCostosDirectos", query = "SELECT e FROM Economia e WHERE e.otrosCostosDirectos = :otrosCostosDirectos")})
public class Economia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_economia")
    private Integer codigoEconomia;
    @Column(name = "precio_alimento_kg")
    private Integer precioAlimentoKg;
    @Column(name = "costo_alimentacion_total")
    private Integer costoAlimentacionTotal;
    @Column(name = "costo_alimentacion_huevos")
    private Integer costoAlimentacionHuevos;
    @Column(name = "valor_huevos")
    private Integer valorHuevos;
    @Column(name = "valor_huevos_costo")
    private Integer valorHuevosCosto;
    @Column(name = "otros_ingresos")
    private Integer otrosIngresos;
    @Column(name = "otros_costos_directos")
    private Integer otrosCostosDirectos;
    @OneToMany(mappedBy = "codigoEconomiaFk")
    private List<LotePonedoras> lotePonedorasList;
    @JoinColumn(name = "codigo_registro_ponedoras_fk", referencedColumnName = "codigo_registro_ponedoras")
    @ManyToOne
    private RegistroSemanalPonedoras codigoRegistroPonedorasFk;

    public Economia() {
    }

    public Economia(Integer codigoEconomia) {
        this.codigoEconomia = codigoEconomia;
    }

    public Integer getCodigoEconomia() {
        return codigoEconomia;
    }

    public void setCodigoEconomia(Integer codigoEconomia) {
        this.codigoEconomia = codigoEconomia;
    }

    public Integer getPrecioAlimentoKg() {
        return precioAlimentoKg;
    }

    public void setPrecioAlimentoKg(Integer precioAlimentoKg) {
        this.precioAlimentoKg = precioAlimentoKg;
    }

    public Integer getCostoAlimentacionTotal() {
        return costoAlimentacionTotal;
    }

    public void setCostoAlimentacionTotal(Integer costoAlimentacionTotal) {
        this.costoAlimentacionTotal = costoAlimentacionTotal;
    }

    public Integer getCostoAlimentacionHuevos() {
        return costoAlimentacionHuevos;
    }

    public void setCostoAlimentacionHuevos(Integer costoAlimentacionHuevos) {
        this.costoAlimentacionHuevos = costoAlimentacionHuevos;
    }

    public Integer getValorHuevos() {
        return valorHuevos;
    }

    public void setValorHuevos(Integer valorHuevos) {
        this.valorHuevos = valorHuevos;
    }

    public Integer getValorHuevosCosto() {
        return valorHuevosCosto;
    }

    public void setValorHuevosCosto(Integer valorHuevosCosto) {
        this.valorHuevosCosto = valorHuevosCosto;
    }

    public Integer getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(Integer otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public Integer getOtrosCostosDirectos() {
        return otrosCostosDirectos;
    }

    public void setOtrosCostosDirectos(Integer otrosCostosDirectos) {
        this.otrosCostosDirectos = otrosCostosDirectos;
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
        hash += (codigoEconomia != null ? codigoEconomia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Economia)) {
            return false;
        }
        Economia other = (Economia) object;
        if ((this.codigoEconomia == null && other.codigoEconomia != null) || (this.codigoEconomia != null && !this.codigoEconomia.equals(other.codigoEconomia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Economia[ codigoEconomia=" + codigoEconomia + " ]";
    }
    
}
