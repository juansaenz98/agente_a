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
import javax.persistence.ManyToMany;
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
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByCodigoVacuna", query = "SELECT v FROM Vacuna v WHERE v.codigoVacuna = :codigoVacuna"),
    @NamedQuery(name = "Vacuna.findByNombreVacuna", query = "SELECT v FROM Vacuna v WHERE v.nombreVacuna = :nombreVacuna"),
    @NamedQuery(name = "Vacuna.findByValorUnitarioVacuna", query = "SELECT v FROM Vacuna v WHERE v.valorUnitarioVacuna = :valorUnitarioVacuna")})
public class Vacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_vacuna")
    private Integer codigoVacuna;
    @Size(max = 100)
    @Column(name = "nombre_vacuna")
    private String nombreVacuna;
    @Column(name = "valor_unitario_vacuna")
    private Integer valorUnitarioVacuna;
    @ManyToMany(mappedBy = "vacunaList")
    private List<Enfermedad> enfermedadList;
    @OneToMany(mappedBy = "codigoVacunaFk")
    private List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList;
    @OneToMany(mappedBy = "codigoVacunaFk")
    private List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList;
    @OneToMany(mappedBy = "codigoVacunaFk")
    private List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList;

    public Vacuna() {
    }

    public Vacuna(Integer codigoVacuna) {
        this.codigoVacuna = codigoVacuna;
    }

    public Integer getCodigoVacuna() {
        return codigoVacuna;
    }

    public void setCodigoVacuna(Integer codigoVacuna) {
        this.codigoVacuna = codigoVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Integer getValorUnitarioVacuna() {
        return valorUnitarioVacuna;
    }

    public void setValorUnitarioVacuna(Integer valorUnitarioVacuna) {
        this.valorUnitarioVacuna = valorUnitarioVacuna;
    }

    @XmlTransient
    public List<Enfermedad> getEnfermedadList() {
        return enfermedadList;
    }

    public void setEnfermedadList(List<Enfermedad> enfermedadList) {
        this.enfermedadList = enfermedadList;
    }

    @XmlTransient
    public List<GuiaVacunacionLotePonedoras> getGuiaVacunacionLotePonedorasList() {
        return guiaVacunacionLotePonedorasList;
    }

    public void setGuiaVacunacionLotePonedorasList(List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList) {
        this.guiaVacunacionLotePonedorasList = guiaVacunacionLotePonedorasList;
    }

    @XmlTransient
    public List<GuiaVacunacionLoteEngorde> getGuiaVacunacionLoteEngordeList() {
        return guiaVacunacionLoteEngordeList;
    }

    public void setGuiaVacunacionLoteEngordeList(List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList) {
        this.guiaVacunacionLoteEngordeList = guiaVacunacionLoteEngordeList;
    }

    @XmlTransient
    public List<GuiaVacunacionLoteLevante> getGuiaVacunacionLoteLevanteList() {
        return guiaVacunacionLoteLevanteList;
    }

    public void setGuiaVacunacionLoteLevanteList(List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList) {
        this.guiaVacunacionLoteLevanteList = guiaVacunacionLoteLevanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVacuna != null ? codigoVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.codigoVacuna == null && other.codigoVacuna != null) || (this.codigoVacuna != null && !this.codigoVacuna.equals(other.codigoVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vacuna[ codigoVacuna=" + codigoVacuna + " ]";
    }
    
}
