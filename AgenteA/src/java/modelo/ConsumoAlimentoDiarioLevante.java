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
@Table(name = "consumo_alimento_diario_levante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsumoAlimentoDiarioLevante.findAll", query = "SELECT c FROM ConsumoAlimentoDiarioLevante c"),
    @NamedQuery(name = "ConsumoAlimentoDiarioLevante.findByCodigoConsumoAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioLevante c WHERE c.codigoConsumoAlimento = :codigoConsumoAlimento"),
    @NamedQuery(name = "ConsumoAlimentoDiarioLevante.findByCantidadAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioLevante c WHERE c.cantidadAlimento = :cantidadAlimento"),
    @NamedQuery(name = "ConsumoAlimentoDiarioLevante.findByFechaRegistroAlimento", query = "SELECT c FROM ConsumoAlimentoDiarioLevante c WHERE c.fechaRegistroAlimento = :fechaRegistroAlimento"),
    @NamedQuery(name = "ConsumoAlimentoDiarioLevante.findByHoraRegistroConsumo", query = "SELECT c FROM ConsumoAlimentoDiarioLevante c WHERE c.horaRegistroConsumo = :horaRegistroConsumo")})
public class ConsumoAlimentoDiarioLevante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_consumo_alimento")
    private Integer codigoConsumoAlimento;
    @Column(name = "cantidad_alimento")
    private Integer cantidadAlimento;
    @Column(name = "fecha_registro_alimento")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroAlimento;
    @Column(name = "hora_registro_consumo")
    @Temporal(TemporalType.TIME)
    private Date horaRegistroConsumo;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;
    @JoinColumn(name = "codigo_registro_levante_fk", referencedColumnName = "codigo_registro_levante")
    @ManyToOne
    private RegistroSemanalLevante codigoRegistroLevanteFk;

    public ConsumoAlimentoDiarioLevante() {
    }

    public ConsumoAlimentoDiarioLevante(Integer codigoConsumoAlimento) {
        this.codigoConsumoAlimento = codigoConsumoAlimento;
    }

    public Integer getCodigoConsumoAlimento() {
        return codigoConsumoAlimento;
    }

    public void setCodigoConsumoAlimento(Integer codigoConsumoAlimento) {
        this.codigoConsumoAlimento = codigoConsumoAlimento;
    }

    public Integer getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(Integer cantidadAlimento) {
        this.cantidadAlimento = cantidadAlimento;
    }

    public Date getFechaRegistroAlimento() {
        return fechaRegistroAlimento;
    }

    public void setFechaRegistroAlimento(Date fechaRegistroAlimento) {
        this.fechaRegistroAlimento = fechaRegistroAlimento;
    }

    public Date getHoraRegistroConsumo() {
        return horaRegistroConsumo;
    }

    public void setHoraRegistroConsumo(Date horaRegistroConsumo) {
        this.horaRegistroConsumo = horaRegistroConsumo;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    public RegistroSemanalLevante getCodigoRegistroLevanteFk() {
        return codigoRegistroLevanteFk;
    }

    public void setCodigoRegistroLevanteFk(RegistroSemanalLevante codigoRegistroLevanteFk) {
        this.codigoRegistroLevanteFk = codigoRegistroLevanteFk;
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
        if (!(object instanceof ConsumoAlimentoDiarioLevante)) {
            return false;
        }
        ConsumoAlimentoDiarioLevante other = (ConsumoAlimentoDiarioLevante) object;
        if ((this.codigoConsumoAlimento == null && other.codigoConsumoAlimento != null) || (this.codigoConsumoAlimento != null && !this.codigoConsumoAlimento.equals(other.codigoConsumoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ConsumoAlimentoDiarioLevante[ codigoConsumoAlimento=" + codigoConsumoAlimento + " ]";
    }
    
}
