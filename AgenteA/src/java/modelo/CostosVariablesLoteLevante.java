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
@Table(name = "costos_variables_lote_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CostosVariablesLoteLevante.findAll", query = "SELECT c FROM CostosVariablesLoteLevante c"),
    @NamedQuery(name = "CostosVariablesLoteLevante.findByCodigoCostoVarieble", query = "SELECT c FROM CostosVariablesLoteLevante c WHERE c.costosVariablesLoteLevantePK.codigoCostoVarieble = :codigoCostoVarieble"),
    @NamedQuery(name = "CostosVariablesLoteLevante.findByNumeroLote", query = "SELECT c FROM CostosVariablesLoteLevante c WHERE c.costosVariablesLoteLevantePK.numeroLote = :numeroLote"),
    @NamedQuery(name = "CostosVariablesLoteLevante.findByCantidadCostoVariable", query = "SELECT c FROM CostosVariablesLoteLevante c WHERE c.cantidadCostoVariable = :cantidadCostoVariable"),
    @NamedQuery(name = "CostosVariablesLoteLevante.findByValorUnitarioCosto", query = "SELECT c FROM CostosVariablesLoteLevante c WHERE c.valorUnitarioCosto = :valorUnitarioCosto"),
    @NamedQuery(name = "CostosVariablesLoteLevante.findByTotalCostoVariable", query = "SELECT c FROM CostosVariablesLoteLevante c WHERE c.totalCostoVariable = :totalCostoVariable")})
public class CostosVariablesLoteLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CostosVariablesLoteLevantePK costosVariablesLoteLevantePK;
    @Column(name = "cantidad_costo_variable")
    private Integer cantidadCostoVariable;
    @Column(name = "valor_unitario_costo")
    private Integer valorUnitarioCosto;
    @Column(name = "total_costo_variable")
    private Integer totalCostoVariable;
    @JoinColumn(name = "codigo_costo_varieble", referencedColumnName = "codigo_cossto_variable", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CostoVariable costoVariable;
    @JoinColumn(name = "numero_lote", referencedColumnName = "numero_lote", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LoteLevante loteLevante;

    public CostosVariablesLoteLevante() {
    }

    public CostosVariablesLoteLevante(CostosVariablesLoteLevantePK costosVariablesLoteLevantePK) {
        this.costosVariablesLoteLevantePK = costosVariablesLoteLevantePK;
    }

    public CostosVariablesLoteLevante(int codigoCostoVarieble, int numeroLote) {
        this.costosVariablesLoteLevantePK = new CostosVariablesLoteLevantePK(codigoCostoVarieble, numeroLote);
    }

    public CostosVariablesLoteLevantePK getCostosVariablesLoteLevantePK() {
        return costosVariablesLoteLevantePK;
    }

    public void setCostosVariablesLoteLevantePK(CostosVariablesLoteLevantePK costosVariablesLoteLevantePK) {
        this.costosVariablesLoteLevantePK = costosVariablesLoteLevantePK;
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

    public LoteLevante getLoteLevante() {
        return loteLevante;
    }

    public void setLoteLevante(LoteLevante loteLevante) {
        this.loteLevante = loteLevante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costosVariablesLoteLevantePK != null ? costosVariablesLoteLevantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosVariablesLoteLevante)) {
            return false;
        }
        CostosVariablesLoteLevante other = (CostosVariablesLoteLevante) object;
        if ((this.costosVariablesLoteLevantePK == null && other.costosVariablesLoteLevantePK != null) || (this.costosVariablesLoteLevantePK != null && !this.costosVariablesLoteLevantePK.equals(other.costosVariablesLoteLevantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CostosVariablesLoteLevante[ costosVariablesLoteLevantePK=" + costosVariablesLoteLevantePK + " ]";
    }
    
}
