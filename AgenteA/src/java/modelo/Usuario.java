/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigoUsuario", query = "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "Usuario.findByDocumentoUsuario", query = "SELECT u FROM Usuario u WHERE u.documentoUsuario = :documentoUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario"),
    @NamedQuery(name = "Usuario.findByFichaUsuario", query = "SELECT u FROM Usuario u WHERE u.fichaUsuario = :fichaUsuario"),
    @NamedQuery(name = "Usuario.findByClaveUsuario", query = "SELECT u FROM Usuario u WHERE u.claveUsuario = :claveUsuario"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;
    @Column(name = "documento_usuario")
    private BigInteger documentoUsuario;
    @Size(max = 50)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Size(max = 50)
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Column(name = "ficha_usuario")
    private Integer fichaUsuario;
    @Size(max = 40)
    @Column(name = "clave_usuario")
    private String claveUsuario;
    @Size(max = 15)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<ConsumoAlimentoDiarioLevante> consumoAlimentoDiarioLevanteList;
    @OneToMany(mappedBy = "codigoUsuario")
    private List<SanidadEngorde> sanidadEngordeList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<GuiaVacunacionLoteEngorde> guiaVacunacionLoteEngordeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuarioFk")
    private List<AsignacionLotePonedoras> asignacionLotePonedorasList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<ConsumoAlimentoDiarioEngorde> consumoAlimentoDiarioEngordeList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<BajasMuertesDiarioLevante> bajasMuertesDiarioLevanteList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<SacrifioVentaEngorde> sacrifioVentaEngordeList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<BajasMuertesDiarioEngorde> bajasMuertesDiarioEngordeList;
    @OneToMany(mappedBy = "codigoUsuario")
    private List<AsignacionLoteEngorde> asignacionLoteEngordeList;
    @OneToMany(mappedBy = "codigoUsuario")
    private List<VitaminasEngorde> vitaminasEngordeList;
    @OneToMany(mappedBy = "codigoUsuarioFk")
    private List<RegistroDiarioPonedoras> registroDiarioPonedorasList;
    @JoinColumn(name = "codigo_programa_fk", referencedColumnName = "codigo_programa")
    @ManyToOne
    private Programa codigoProgramaFk;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public BigInteger getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(BigInteger documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Integer getFichaUsuario() {
        return fichaUsuario;
    }

    public void setFichaUsuario(Integer fichaUsuario) {
        this.fichaUsuario = fichaUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public List<ConsumoAlimentoDiarioLevante> getConsumoAlimentoDiarioLevanteList() {
        return consumoAlimentoDiarioLevanteList;
    }

    public void setConsumoAlimentoDiarioLevanteList(List<ConsumoAlimentoDiarioLevante> consumoAlimentoDiarioLevanteList) {
        this.consumoAlimentoDiarioLevanteList = consumoAlimentoDiarioLevanteList;
    }

    @XmlTransient
    public List<SanidadEngorde> getSanidadEngordeList() {
        return sanidadEngordeList;
    }

    public void setSanidadEngordeList(List<SanidadEngorde> sanidadEngordeList) {
        this.sanidadEngordeList = sanidadEngordeList;
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
    public List<AsignacionLotePonedoras> getAsignacionLotePonedorasList() {
        return asignacionLotePonedorasList;
    }

    public void setAsignacionLotePonedorasList(List<AsignacionLotePonedoras> asignacionLotePonedorasList) {
        this.asignacionLotePonedorasList = asignacionLotePonedorasList;
    }

    @XmlTransient
    public List<GuiaVacunacionLoteLevante> getGuiaVacunacionLoteLevanteList() {
        return guiaVacunacionLoteLevanteList;
    }

    public void setGuiaVacunacionLoteLevanteList(List<GuiaVacunacionLoteLevante> guiaVacunacionLoteLevanteList) {
        this.guiaVacunacionLoteLevanteList = guiaVacunacionLoteLevanteList;
    }

    @XmlTransient
    public List<ConsumoAlimentoDiarioEngorde> getConsumoAlimentoDiarioEngordeList() {
        return consumoAlimentoDiarioEngordeList;
    }

    public void setConsumoAlimentoDiarioEngordeList(List<ConsumoAlimentoDiarioEngorde> consumoAlimentoDiarioEngordeList) {
        this.consumoAlimentoDiarioEngordeList = consumoAlimentoDiarioEngordeList;
    }

    @XmlTransient
    public List<BajasMuertesDiarioLevante> getBajasMuertesDiarioLevanteList() {
        return bajasMuertesDiarioLevanteList;
    }

    public void setBajasMuertesDiarioLevanteList(List<BajasMuertesDiarioLevante> bajasMuertesDiarioLevanteList) {
        this.bajasMuertesDiarioLevanteList = bajasMuertesDiarioLevanteList;
    }

    @XmlTransient
    public List<SacrifioVentaEngorde> getSacrifioVentaEngordeList() {
        return sacrifioVentaEngordeList;
    }

    public void setSacrifioVentaEngordeList(List<SacrifioVentaEngorde> sacrifioVentaEngordeList) {
        this.sacrifioVentaEngordeList = sacrifioVentaEngordeList;
    }

    @XmlTransient
    public List<BajasMuertesDiarioEngorde> getBajasMuertesDiarioEngordeList() {
        return bajasMuertesDiarioEngordeList;
    }

    public void setBajasMuertesDiarioEngordeList(List<BajasMuertesDiarioEngorde> bajasMuertesDiarioEngordeList) {
        this.bajasMuertesDiarioEngordeList = bajasMuertesDiarioEngordeList;
    }

    @XmlTransient
    public List<AsignacionLoteEngorde> getAsignacionLoteEngordeList() {
        return asignacionLoteEngordeList;
    }

    public void setAsignacionLoteEngordeList(List<AsignacionLoteEngorde> asignacionLoteEngordeList) {
        this.asignacionLoteEngordeList = asignacionLoteEngordeList;
    }

    @XmlTransient
    public List<VitaminasEngorde> getVitaminasEngordeList() {
        return vitaminasEngordeList;
    }

    public void setVitaminasEngordeList(List<VitaminasEngorde> vitaminasEngordeList) {
        this.vitaminasEngordeList = vitaminasEngordeList;
    }

    @XmlTransient
    public List<RegistroDiarioPonedoras> getRegistroDiarioPonedorasList() {
        return registroDiarioPonedorasList;
    }

    public void setRegistroDiarioPonedorasList(List<RegistroDiarioPonedoras> registroDiarioPonedorasList) {
        this.registroDiarioPonedorasList = registroDiarioPonedorasList;
    }

    public Programa getCodigoProgramaFk() {
        return codigoProgramaFk;
    }

    public void setCodigoProgramaFk(Programa codigoProgramaFk) {
        this.codigoProgramaFk = codigoProgramaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
