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
public class CostosVariablesLoteEngordePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_costo_variable")
    private int codigoCostoVariable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_lote_engorde")
    private int numeroLoteEngorde;

    public CostosVariablesLoteEngordePK() {
    }

    public CostosVariablesLoteEngordePK(int codigoCostoVariable, int numeroLoteEngorde) {
        this.codigoCostoVariable = codigoCostoVariable;
        this.numeroLoteEngorde = numeroLoteEngorde;
    }

    public int getCodigoCostoVariable() {
        return codigoCostoVariable;
    }

    public void setCodigoCostoVariable(int codigoCostoVariable) {
        this.codigoCostoVariable = codigoCostoVariable;
    }

    public int getNumeroLoteEngorde() {
        return numeroLoteEngorde;
    }

    public void setNumeroLoteEngorde(int numeroLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCostoVariable;
        hash += (int) numeroLoteEngorde;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosVariablesLoteEngordePK)) {
            return false;
        }
        CostosVariablesLoteEngordePK other = (CostosVariablesLoteEngordePK) object;
        if (this.codigoCostoVariable != other.codigoCostoVariable) {
            return false;
        }
        if (this.numeroLoteEngorde != other.numeroLoteEngorde) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CostosVariablesLoteEngordePK[ codigoCostoVariable=" + codigoCostoVariable + ", numeroLoteEngorde=" + numeroLoteEngorde + " ]";
    }
    
}
