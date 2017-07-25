/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "costos_variables_lote_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CostosVariablesLoteEngorde.findAll", query = "SELECT c FROM CostosVariablesLoteEngorde c"),
    @NamedQuery(name = "CostosVariablesLoteEngorde.findByCodigoCostoVariable", query = "SELECT c FROM CostosVariablesLoteEngorde c WHERE c.costosVariablesLoteEngordePK.codigoCostoVariable = :codigoCostoVariable"),
    @NamedQuery(name = "CostosVariablesLoteEngorde.findByNumeroLoteEngorde", query = "SELECT c FROM CostosVariablesLoteEngorde c WHERE c.costosVariablesLoteEngordePK.numeroLoteEngorde = :numeroLoteEngorde"),
    @NamedQuery(name = "CostosVariablesLoteEngorde.findByCantidadCostoVariable", query = "SELECT c FROM CostosVariablesLoteEngorde c WHERE c.cantidadCostoVariable = :cantidadCostoVariable"),
    @NamedQuery(name = "CostosVariablesLoteEngorde.findByValorUnitarioCosto", query = "SELECT c FROM CostosVariablesLoteEngorde c WHERE c.valorUnitarioCosto = :valorUnitarioCosto"),
    @NamedQuery(name = "CostosVariablesLoteEngorde.findByTotalCostoVariable", query = "SELECT c FROM CostosVariablesLoteEngorde c WHERE c.totalCostoVariable = :totalCostoVariable")})
public class CostosVariablesLoteEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CostosVariablesLoteEngordePK costosVariablesLoteEngordePK;
    @Column(name = "cantidad_costo_variable")
    private Integer cantidadCostoVariable;
    @Column(name = "valor_unitario_costo")
    private Integer valorUnitarioCosto;
    @Column(name = "total_costo_variable")
    private Integer totalCostoVariable;
    @JoinColumn(name = "codigo_costo_variable", referencedColumnName = "codigo_cossto_variable", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CostoVariable costoVariable;
    @JoinColumn(name = "numero_lote_engorde", referencedColumnName = "numero_lote_engorde", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LoteEngorde loteEngorde;

    public CostosVariablesLoteEngorde() {
    }

    public CostosVariablesLoteEngorde(CostosVariablesLoteEngordePK costosVariablesLoteEngordePK) {
        this.costosVariablesLoteEngordePK = costosVariablesLoteEngordePK;
    }

    public CostosVariablesLoteEngorde(int codigoCostoVariable, int numeroLoteEngorde) {
        this.costosVariablesLoteEngordePK = new CostosVariablesLoteEngordePK(codigoCostoVariable, numeroLoteEngorde);
    }

    public CostosVariablesLoteEngordePK getCostosVariablesLoteEngordePK() {
        return costosVariablesLoteEngordePK;
    }

    public void setCostosVariablesLoteEngordePK(CostosVariablesLoteEngordePK costosVariablesLoteEngordePK) {
        this.costosVariablesLoteEngordePK = costosVariablesLoteEngordePK;
    }

    public Integer getCantidadCostoVariable() {
        return cantidadCostoVariable;
    }

    public void setCantidadCostoVariable(Integer cantidadCostoVariable) {
        this.cantidadCostoVariable = cantidadCostoVariable;
    }

    public Integer getValorUnitarioCosto() {
        return valorUnitarioCosto;
    }

    public void setValorUnitarioCosto(Integer valorUnitarioCosto) {
        this.valorUnitarioCosto = valorUnitarioCosto;
    }

    public Integer getTotalCostoVariable() {
        return totalCostoVariable;
    }

    public void setTotalCostoVariable(Integer totalCostoVariable) {
        this.totalCostoVariable = totalCostoVariable;
    }

    public CostoVariable getCostoVariable() {
        return costoVariable;
    }

    public void setCostoVariable(CostoVariable costoVariable) {
        this.costoVariable = costoVariable;
    }

    public LoteEngorde getLoteEngorde() {
        return loteEngorde;
    }

    public void setLoteEngorde(LoteEngorde loteEngorde) {
        this.loteEngorde = loteEngorde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costosVariablesLoteEngordePK != null ? costosVariablesLoteEngordePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosVariablesLoteEngorde)) {
            return false;
        }
        CostosVariablesLoteEngorde other = (CostosVariablesLoteEngorde) object;
        if ((this.costosVariablesLoteEngordePK == null && other.costosVariablesLoteEngordePK != null) || (this.costosVariablesLoteEngordePK != null && !this.costosVariablesLoteEngordePK.equals(other.costosVariablesLoteEngordePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CostosVariablesLoteEngorde[ costosVariablesLoteEngordePK=" + costosVariablesLoteEngordePK + " ]";
    }
    
}
