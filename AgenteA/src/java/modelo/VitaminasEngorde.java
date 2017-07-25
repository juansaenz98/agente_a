/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "vitaminas_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VitaminasEngorde.findAll", query = "SELECT v FROM VitaminasEngorde v"),
    @NamedQuery(name = "VitaminasEngorde.findByCodigoVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.codigoVitamina = :codigoVitamina"),
    @NamedQuery(name = "VitaminasEngorde.findByNombreVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.nombreVitamina = :nombreVitamina"),
    @NamedQuery(name = "VitaminasEngorde.findByDosisVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.dosisVitamina = :dosisVitamina"),
    @NamedQuery(name = "VitaminasEngorde.findByEdadSemasVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.edadSemasVitamina = :edadSemasVitamina"),
    @NamedQuery(name = "VitaminasEngorde.findByFechaVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.fechaVitamina = :fechaVitamina"),
    @NamedQuery(name = "VitaminasEngorde.findByValorVitamina", query = "SELECT v FROM VitaminasEngorde v WHERE v.valorVitamina = :valorVitamina")})
public class VitaminasEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_vitamina")
    private Integer codigoVitamina;
    @Size(max = 100)
    @Column(name = "nombre_vitamina")
    private String nombreVitamina;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dosis_vitamina")
    private Double dosisVitamina;
    @Column(name = "edad_semas_vitamina")
    private Integer edadSemasVitamina;
    @Column(name = "fecha_vitamina")
    @Temporal(TemporalType.DATE)
    private Date fechaVitamina;
    @Column(name = "valor_vitamina")
    private Integer valorVitamina;
    @JoinColumn(name = "numero_lote_engorde", referencedColumnName = "numero_lote_engorde")
    @ManyToOne
    private LoteEngorde numeroLoteEngorde;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuario;

    public VitaminasEngorde() {
    }

    public VitaminasEngorde(Integer codigoVitamina) {
        this.codigoVitamina = codigoVitamina;
    }

    public Integer getCodigoVitamina() {
        return codigoVitamina;
    }

    public void setCodigoVitamina(Integer codigoVitamina) {
        this.codigoVitamina = codigoVitamina;
    }

    public String getNombreVitamina() {
        return nombreVitamina;
    }

    public void setNombreVitamina(String nombreVitamina) {
        this.nombreVitamina = nombreVitamina;
    }

    public Double getDosisVitamina() {
        return dosisVitamina;
    }

    public void setDosisVitamina(Double dosisVitamina) {
        this.dosisVitamina = dosisVitamina;
    }

    public Integer getEdadSemasVitamina() {
        return edadSemasVitamina;
    }

    public void setEdadSemasVitamina(Integer edadSemasVitamina) {
        this.edadSemasVitamina = edadSemasVitamina;
    }

    public Date getFechaVitamina() {
        return fechaVitamina;
    }

    public void setFechaVitamina(Date fechaVitamina) {
        this.fechaVitamina = fechaVitamina;
    }

    public Integer getValorVitamina() {
        return valorVitamina;
    }

    public void setValorVitamina(Integer valorVitamina) {
        this.valorVitamina = valorVitamina;
    }

    public LoteEngorde getNumeroLoteEngorde() {
        return numeroLoteEngorde;
    }

    public void setNumeroLoteEngorde(LoteEngorde numeroLoteEngorde) {
        this.numeroLoteEngorde = numeroLoteEngorde;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVitamina != null ? codigoVitamina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VitaminasEngorde)) {
            return false;
        }
        VitaminasEngorde other = (VitaminasEngorde) object;
        if ((this.codigoVitamina == null && other.codigoVitamina != null) || (this.codigoVitamina != null && !this.codigoVitamina.equals(other.codigoVitamina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VitaminasEngorde[ codigoVitamina=" + codigoVitamina + " ]";
    }
    
}
