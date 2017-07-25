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
@Table(name = "tipo_alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAlimento.findAll", query = "SELECT t FROM TipoAlimento t"),
    @NamedQuery(name = "TipoAlimento.findByCodigoTipoAlimento", query = "SELECT t FROM TipoAlimento t WHERE t.codigoTipoAlimento = :codigoTipoAlimento"),
    @NamedQuery(name = "TipoAlimento.findByNombreTipoAlimento", query = "SELECT t FROM TipoAlimento t WHERE t.nombreTipoAlimento = :nombreTipoAlimento"),
    @NamedQuery(name = "TipoAlimento.findByValorKiloTipoAlimento", query = "SELECT t FROM TipoAlimento t WHERE t.valorKiloTipoAlimento = :valorKiloTipoAlimento")})
public class TipoAlimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tipo_alimento")
    private Integer codigoTipoAlimento;
    @Size(max = 100)
    @Column(name = "nombre_tipo_alimento")
    private String nombreTipoAlimento;
    @Column(name = "valor_kilo_tipo_alimento")
    private Integer valorKiloTipoAlimento;
    @OneToMany(mappedBy = "codigoTipoAlimentoFk")
    private List<RegistroSemanalLevante> registroSemanalLevanteList;
    @OneToMany(mappedBy = "codigoTipoAlimentoFk")
    private List<RegistroDiarioPonedoras> registroDiarioPonedorasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipoAlimentoFk")
    private List<RegistroSemanalEngorde> registroSemanalEngordeList;

    public TipoAlimento() {
    }

    public TipoAlimento(Integer codigoTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
    }

    public Integer getCodigoTipoAlimento() {
        return codigoTipoAlimento;
    }

    public void setCodigoTipoAlimento(Integer codigoTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
    }

    public String getNombreTipoAlimento() {
        return nombreTipoAlimento;
    }

    public void setNombreTipoAlimento(String nombreTipoAlimento) {
        this.nombreTipoAlimento = nombreTipoAlimento;
    }

    public Integer getValorKiloTipoAlimento() {
        return valorKiloTipoAlimento;
    }

    public void setValorKiloTipoAlimento(Integer valorKiloTipoAlimento) {
        this.valorKiloTipoAlimento = valorKiloTipoAlimento;
    }

    @XmlTransient
    public List<RegistroSemanalLevante> getRegistroSemanalLevanteList() {
        return registroSemanalLevanteList;
    }

    public void setRegistroSemanalLevanteList(List<RegistroSemanalLevante> registroSemanalLevanteList) {
        this.registroSemanalLevanteList = registroSemanalLevanteList;
    }

    @XmlTransient
    public List<RegistroDiarioPonedoras> getRegistroDiarioPonedorasList() {
        return registroDiarioPonedorasList;
    }

    public void setRegistroDiarioPonedorasList(List<RegistroDiarioPonedoras> registroDiarioPonedorasList) {
        this.registroDiarioPonedorasList = registroDiarioPonedorasList;
    }

    @XmlTransient
    public List<RegistroSemanalEngorde> getRegistroSemanalEngordeList() {
        return registroSemanalEngordeList;
    }

    public void setRegistroSemanalEngordeList(List<RegistroSemanalEngorde> registroSemanalEngordeList) {
        this.registroSemanalEngordeList = registroSemanalEngordeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipoAlimento != null ? codigoTipoAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlimento)) {
            return false;
        }
        TipoAlimento other = (TipoAlimento) object;
        if ((this.codigoTipoAlimento == null && other.codigoTipoAlimento != null) || (this.codigoTipoAlimento != null && !this.codigoTipoAlimento.equals(other.codigoTipoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAlimento[ codigoTipoAlimento=" + codigoTipoAlimento + " ]";
    }
    
}
