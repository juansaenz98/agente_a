/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "costo_variable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CostoVariable.findAll", query = "SELECT c FROM CostoVariable c"),
    @NamedQuery(name = "CostoVariable.findByCodigoCosstoVariable", query = "SELECT c FROM CostoVariable c WHERE c.codigoCosstoVariable = :codigoCosstoVariable"),
    @NamedQuery(name = "CostoVariable.findByNombreCostoVariable", query = "SELECT c FROM CostoVariable c WHERE c.nombreCostoVariable = :nombreCostoVariable")})
public class CostoVariable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_cossto_variable")
    private Integer codigoCosstoVariable;
    @Size(max = 100)
    @Column(name = "nombre_costo_variable")
    private String nombreCostoVariable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costoVariable")
    private List<CostosVariablesLoteLevante> costosVariablesLoteLevanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costoVariable")
    private List<CostosVariablesLoteEngorde> costosVariablesLoteEngordeList;

    public CostoVariable() {
    }

    public CostoVariable(Integer codigoCosstoVariable) {
        this.codigoCosstoVariable = codigoCosstoVariable;
    }

    public Integer getCodigoCosstoVariable() {
        return codigoCosstoVariable;
    }

    public void setCodigoCosstoVariable(Integer codigoCosstoVariable) {
        this.codigoCosstoVariable = codigoCosstoVariable;
    }

    public String getNombreCostoVariable() {
        return nombreCostoVariable;
    }

    public void setNombreCostoVariable(String nombreCostoVariable) {
        this.nombreCostoVariable = nombreCostoVariable;
    }

    @XmlTransient
    public List<CostosVariablesLoteLevante> getCostosVariablesLoteLevanteList() {
        return costosVariablesLoteLevanteList;
    }

    public void setCostosVariablesLoteLevanteList(List<CostosVariablesLoteLevante> costosVariablesLoteLevanteList) {
        this.costosVariablesLoteLevanteList = costosVariablesLoteLevanteList;
    }

    @XmlTransient
    public List<CostosVariablesLoteEngorde> getCostosVariablesLoteEngordeList() {
        return costosVariablesLoteEngordeList;
    }

    public void setCostosVariablesLoteEngordeList(List<CostosVariablesLoteEngorde> costosVariablesLoteEngordeList) {
        this.costosVariablesLoteEngordeList = costosVariablesLoteEngordeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCosstoVariable != null ? codigoCosstoVariable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostoVariable)) {
            return false;
        }
        CostoVariable other = (CostoVariable) object;
        if ((this.codigoCosstoVariable == null && other.codigoCosstoVariable != null) || (this.codigoCosstoVariable != null && !this.codigoCosstoVariable.equals(other.codigoCosstoVariable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CostoVariable[ codigoCosstoVariable=" + codigoCosstoVariable + " ]";
    }
    
}
