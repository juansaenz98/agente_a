/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dilov
 */
@Embeddable
public class CostosVariablesLoteLevantePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_costo_varieble")
    private int codigoCostoVarieble;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_lote")
    private int numeroLote;

    public CostosVariablesLoteLevantePK() {
    }

    public CostosVariablesLoteLevantePK(int codigoCostoVarieble, int numeroLote) {
        this.codigoCostoVarieble = codigoCostoVarieble;
        this.numeroLote = numeroLote;
    }

    public int getCodigoCostoVarieble() {
        return codigoCostoVarieble;
    }

    public void setCodigoCostoVarieble(int codigoCostoVarieble) {
        this.codigoCostoVarieble = codigoCostoVarieble;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCostoVarieble;
        hash += (int) numeroLote;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosVariablesLoteLevantePK)) {
            return false;
        }
        CostosVariablesLoteLevantePK other = (CostosVariablesLoteLevantePK) object;
        if (this.codigoCostoVarieble != other.codigoCostoVarieble) {
            return false;
        }
        if (this.numeroLote != other.numeroLote) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CostosVariablesLoteLevantePK[ codigoCostoVarieble=" + codigoCostoVarieble + ", numeroLote=" + numeroLote + " ]";
    }
    
}
