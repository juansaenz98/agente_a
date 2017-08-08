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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "enfermedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedad.findAll", query = "SELECT e FROM Enfermedad e"),
    @NamedQuery(name = "Enfermedad.findByCodigoEnfermedad", query = "SELECT e FROM Enfermedad e WHERE e.codigoEnfermedad = :codigoEnfermedad"),
    @NamedQuery(name = "Enfermedad.findByNombreEnfermedad", query = "SELECT e FROM Enfermedad e WHERE e.nombreEnfermedad = :nombreEnfermedad")})
public class Enfermedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_enfermedad")
    private Integer codigoEnfermedad;
    @Size(max = 50)
    @Column(name = "nombre_enfermedad")
    private String nombreEnfermedad;
    @JoinTable(name = "enfermedades_vacuna", joinColumns = {
        @JoinColumn(name = "codigo_enfermedad", referencedColumnName = "codigo_enfermedad")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_vacuna", referencedColumnName = "codigo_vacuna")})
    @ManyToMany
    private List<Vacuna> vacunaList;
    @OneToMany(mappedBy = "codigoEnfermedadFk")
    private List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList;
    @OneToMany(mappedBy = "codigoEnfermedadFk")
    private List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList;
    @OneToMany(mappedBy = "codigoEnfermedadFk")
    private List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList;

    public Enfermedad() {
    }

    public Enfermedad(Integer codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }

    public Integer getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoEnfermedad(Integer codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    @XmlTransient
    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
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
        hash += (codigoEnfermedad != null ? codigoEnfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedad)) {
            return false;
        }
        Enfermedad other = (Enfermedad) object;
        if ((this.codigoEnfermedad == null && other.codigoEnfermedad != null) || (this.codigoEnfermedad != null && !this.codigoEnfermedad.equals(other.codigoEnfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Enfermedad[ codigoEnfermedad=" + codigoEnfermedad + " ]";
    }
    
}
