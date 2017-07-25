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
@Table(name = "raza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raza.findAll", query = "SELECT r FROM Raza r"),
    @NamedQuery(name = "Raza.findByCodigoRaza", query = "SELECT r FROM Raza r WHERE r.codigoRaza = :codigoRaza"),
    @NamedQuery(name = "Raza.findByNombreRaza", query = "SELECT r FROM Raza r WHERE r.nombreRaza = :nombreRaza")})
public class Raza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_raza")
    private Integer codigoRaza;
    @Size(max = 100)
    @Column(name = "nombre_raza")
    private String nombreRaza;
    @OneToMany(mappedBy = "codigoRazaFk")
    private List<LotePonedoras> lotePonedorasList;
    @OneToMany(mappedBy = "codigoRazaFk")
    private List<LoteLevante> loteLevanteList;
    @OneToMany(mappedBy = "codigoRazaFk")
    private List<LoteEngorde> loteEngordeList;

    public Raza() {
    }

    public Raza(Integer codigoRaza) {
        this.codigoRaza = codigoRaza;
    }

    public Integer getCodigoRaza() {
        return codigoRaza;
    }

    public void setCodigoRaza(Integer codigoRaza) {
        this.codigoRaza = codigoRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
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
        hash += (codigoRaza != null ? codigoRaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raza)) {
            return false;
        }
        Raza other = (Raza) object;
        if ((this.codigoRaza == null && other.codigoRaza != null) || (this.codigoRaza != null && !this.codigoRaza.equals(other.codigoRaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Raza[ codigoRaza=" + codigoRaza + " ]";
    }
    
}
