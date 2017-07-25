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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "galpon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galpon.findAll", query = "SELECT g FROM Galpon g"),
    @NamedQuery(name = "Galpon.findByNumeroGalpon", query = "SELECT g FROM Galpon g WHERE g.numeroGalpon = :numeroGalpon"),
    @NamedQuery(name = "Galpon.findByEstadoGalpon", query = "SELECT g FROM Galpon g WHERE g.estadoGalpon = :estadoGalpon")})
public class Galpon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_galpon")
    private Integer numeroGalpon;
    @Size(max = 50)
    @Column(name = "estado_galpon")
    private String estadoGalpon;
    @OneToMany(mappedBy = "numeroGalponFk")
    private List<LotePonedoras> lotePonedorasList;
    @OneToMany(mappedBy = "numeroGalponFk")
    private List<LoteLevante> loteLevanteList;
    @OneToMany(mappedBy = "numeroGalpoFk")
    private List<LoteEngorde> loteEngordeList;

    public Galpon() {
    }

    public Galpon(Integer numeroGalpon) {
        this.numeroGalpon = numeroGalpon;
    }

    public Integer getNumeroGalpon() {
        return numeroGalpon;
    }

    public void setNumeroGalpon(Integer numeroGalpon) {
        this.numeroGalpon = numeroGalpon;
    }

    public String getEstadoGalpon() {
        return estadoGalpon;
    }

    public void setEstadoGalpon(String estadoGalpon) {
        this.estadoGalpon = estadoGalpon;
    }

    @XmlTransient
    public List<LotePonedoras> getLotePonedorasList() {
        return lotePonedorasList;
    }

    public void setLotePonedorasList(List<LotePonedoras> lotePonedorasList) {
        this.lotePonedorasList = lotePonedorasList;
    }

    @XmlTransient
    public List<LoteLevante> getLoteLevanteList() {
        return loteLevanteList;
    }

    public void setLoteLevanteList(List<LoteLevante> loteLevanteList) {
        this.loteLevanteList = loteLevanteList;
    }

    @XmlTransient
    public List<LoteEngorde> getLoteEngordeList() {
        return loteEngordeList;
    }

    public void setLoteEngordeList(List<LoteEngorde> loteEngordeList) {
        this.loteEngordeList = loteEngordeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroGalpon != null ? numeroGalpon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galpon)) {
            return false;
        }
        Galpon other = (Galpon) object;
        if ((this.numeroGalpon == null && other.numeroGalpon != null) || (this.numeroGalpon != null && !this.numeroGalpon.equals(other.numeroGalpon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Galpon[ numeroGalpon=" + numeroGalpon + " ]";
    }
    
}
