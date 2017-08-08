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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "consumo_alimento_diario_engorde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoAlimentoDiarioEngorde.findAll", query = "SELECT c FROM ConsumoAlimentoDiarioEngorde c"),
    @NamedQuery(name = "ConsumoAlimentoDiarioEngorde.findByCodigoConsumoAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioEngorde c WHERE c.codigoConsumoAlimento = :codigoConsumoAlimento"),
    @NamedQuery(name = "ConsumoAlimentoDiarioEngorde.findByCantidadAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioEngorde c WHERE c.cantidadAlimento = :cantidadAlimento"),
    @NamedQuery(name = "ConsumoAlimentoDiarioEngorde.findByFechaRegistro", query = "SELECT c FROM ConsumoAlimentoDiarioEngorde c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ConsumoAlimentoDiarioEngorde.findByHoraRegistroAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioEngorde c WHERE c.horaRegistroAlimento = :horaRegistroAlimento")})
public class ConsumoAlimentoDiarioEngorde implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_consumo_alimento")
    private Integer codigoConsumoAlimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_alimento")
    private Double cantidadAlimento;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "hora_registro_alimento")
    @Temporal(TemporalType.TIME)
    private Date horaRegistroAlimento;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_registro_engorde_fk", referencedColumnName = "codigo_registro_engorde")
    @ManyToOne
    private RegistroSemanalEngorde codigoRegistroEngordeFk;

    public ConsumoAlimentoDiarioEngorde() {
    }

    public ConsumoAlimentoDiarioEngorde(Integer codigoConsumoAlimento) {
        this.codigoConsumoAlimento = codigoConsumoAlimento;
    }

    public Integer getCodigoConsumoAlimento() {
        return codigoConsumoAlimento;
    }

    public void setCodigoConsumoAlimento(Integer codigoConsumoAlimento) {
        this.codigoConsumoAlimento = codigoConsumoAlimento;
    }

    public Double getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(Double cantidadAlimento) {
        this.cantidadAlimento = cantidadAlimento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getHoraRegistroAlimento() {
        return horaRegistroAlimento;
    }

    public void setHoraRegistroAlimento(Date horaRegistroAlimento) {
        this.horaRegistroAlimento = horaRegistroAlimento;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public RegistroSemanalEngorde getCodigoRegistroEngordeFk() {
        return codigoRegistroEngordeFk;
    }

    public void setCodigoRegistroEngordeFk(RegistroSemanalEngorde codigoRegistroEngordeFk) {
        this.codigoRegistroEngordeFk = codigoRegistroEngordeFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoConsumoAlimento != null ? codigoConsumoAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoAlimentoDiarioEngorde)) {
            return false;
        }
        ConsumoAlimentoDiarioEngorde other = (ConsumoAlimentoDiarioEngorde) object;
        if ((this.codigoConsumoAlimento == null && other.codigoConsumoAlimento != null) || (this.codigoConsumoAlimento != null && !this.codigoConsumoAlimento.equals(other.codigoConsumoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ConsumoAlimentoDiarioEngorde[ codigoConsumoAlimento=" + codigoConsumoAlimento + " ]";
    }
    
}
