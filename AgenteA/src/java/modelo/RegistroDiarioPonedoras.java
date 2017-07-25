/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "registro_diario_ponedoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroDiarioPonedoras.findAll", query = "SELECT r FROM RegistroDiarioPonedoras r"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByCodigoRegistroDiarioPonedoraas", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.codigoRegistroDiarioPonedoraas = :codigoRegistroDiarioPonedoraas"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByFechaRegistroDiario", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.fechaRegistroDiario = :fechaRegistroDiario"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByTotalHuevosSegundaClaseRegistro", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.totalHuevosSegundaClaseRegistro = :totalHuevosSegundaClaseRegistro"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByTotalHuevosRegistro", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.totalHuevosRegistro = :totalHuevosRegistro"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByKgAlimentoRegistro", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.kgAlimentoRegistro = :kgAlimentoRegistro"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByCantidadMortalidadRegistro", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.cantidadMortalidadRegistro = :cantidadMortalidadRegistro"),
    @NamedQuery(name = "RegistroDiarioPonedoras.findByCantidadDesechoRegistro", query = "SELECT r FROM RegistroDiarioPonedoras r WHERE r.cantidadDesechoRegistro = :cantidadDesechoRegistro")})
public class RegistroDiarioPonedoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_registro_diario_ponedoraas")
    private Integer codigoRegistroDiarioPonedoraas;
    @Column(name = "fecha_registro_diario")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroDiario;
    @Column(name = "total_huevos_segunda_clase_registro")
    private Integer totalHuevosSegundaClaseRegistro;
    @Column(name = "total_huevos_registro")
    private Integer totalHuevosRegistro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kg_alimento_registro")
    private Double kgAlimentoRegistro;
    @Column(name = "cantidad_mortalidad_registro")
    private Integer cantidadMortalidadRegistro;
    @Column(name = "cantidad_desecho_registro")
    private Integer cantidadDesechoRegistro;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_registro")
    private String observacionesRegistro;
    @OneToMany(mappedBy = "codigoRegistroDiarioPonedorasFk")
    private List<ReporteHuevos> reporteHuevosList;
    @JoinColumn(name = "codigo_registro_ponedoras_fk", referencedColumnName = "codigo_registro_ponedoras")
    @ManyToOne
    private RegistroSemanalPonedoras codigoRegistroPonedorasFk;
    @JoinColumn(name = "codigo_tipo_alimento_fk", referencedColumnName = "codigo_tipo_alimento")
    @ManyToOne
    private TipoAlimento codigoTipoAlimentoFk;
    @JoinColumn(name = "codigo_usuario_fk", referencedColumnName = "codigo_usuario")
    @ManyToOne
    private Usuario codigoUsuarioFk;

    public RegistroDiarioPonedoras() {
    }

    public RegistroDiarioPonedoras(Integer codigoRegistroDiarioPonedoraas) {
        this.codigoRegistroDiarioPonedoraas = codigoRegistroDiarioPonedoraas;
    }

    public Integer getCodigoRegistroDiarioPonedoraas() {
        return codigoRegistroDiarioPonedoraas;
    }

    public void setCodigoRegistroDiarioPonedoraas(Integer codigoRegistroDiarioPonedoraas) {
        this.codigoRegistroDiarioPonedoraas = codigoRegistroDiarioPonedoraas;
    }

    public Date getFechaRegistroDiario() {
        return fechaRegistroDiario;
    }

    public void setFechaRegistroDiario(Date fechaRegistroDiario) {
        this.fechaRegistroDiario = fechaRegistroDiario;
    }

    public Integer getTotalHuevosSegundaClaseRegistro() {
        return totalHuevosSegundaClaseRegistro;
    }

    public void setTotalHuevosSegundaClaseRegistro(Integer totalHuevosSegundaClaseRegistro) {
        this.totalHuevosSegundaClaseRegistro = totalHuevosSegundaClaseRegistro;
    }

    public Integer getTotalHuevosRegistro() {
        return totalHuevosRegistro;
    }

    public void setTotalHuevosRegistro(Integer totalHuevosRegistro) {
        this.totalHuevosRegistro = totalHuevosRegistro;
    }

    public Double getKgAlimentoRegistro() {
        return kgAlimentoRegistro;
    }

    public void setKgAlimentoRegistro(Double kgAlimentoRegistro) {
        this.kgAlimentoRegistro = kgAlimentoRegistro;
    }

    public Integer getCantidadMortalidadRegistro() {
        return cantidadMortalidadRegistro;
    }

    public void setCantidadMortalidadRegistro(Integer cantidadMortalidadRegistro) {
        this.cantidadMortalidadRegistro = cantidadMortalidadRegistro;
    }

    public Integer getCantidadDesechoRegistro() {
        return cantidadDesechoRegistro;
    }

    public void setCantidadDesechoRegistro(Integer cantidadDesechoRegistro) {
        this.cantidadDesechoRegistro = cantidadDesechoRegistro;
    }

    public String getObservacionesRegistro() {
        return observacionesRegistro;
    }

    public void setObservacionesRegistro(String observacionesRegistro) {
        this.observacionesRegistro = observacionesRegistro;
    }

    @XmlTransient
    public List<ReporteHuevos> getReporteHuevosList() {
        return reporteHuevosList;
    }

    public void setReporteHuevosList(List<ReporteHuevos> reporteHuevosList) {
        this.reporteHuevosList = reporteHuevosList;
    }

    public RegistroSemanalPonedoras getCodigoRegistroPonedorasFk() {
        return codigoRegistroPonedorasFk;
    }

    public void setCodigoRegistroPonedorasFk(RegistroSemanalPonedoras codigoRegistroPonedorasFk) {
        this.codigoRegistroPonedorasFk = codigoRegistroPonedorasFk;
    }

    public TipoAlimento getCodigoTipoAlimentoFk() {
        return codigoTipoAlimentoFk;
    }

    public void setCodigoTipoAlimentoFk(TipoAlimento codigoTipoAlimentoFk) {
        this.codigoTipoAlimentoFk = codigoTipoAlimentoFk;
    }

    public Usuario getCodigoUsuarioFk() {
        return codigoUsuarioFk;
    }

    public void setCodigoUsuarioFk(Usuario codigoUsuarioFk) {
        this.codigoUsuarioFk = codigoUsuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRegistroDiarioPonedoraas != null ? codigoRegistroDiarioPonedoraas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDiarioPonedoras)) {
            return false;
        }
        RegistroDiarioPonedoras other = (RegistroDiarioPonedoras) object;
        if ((this.codigoRegistroDiarioPonedoraas == null && other.codigoRegistroDiarioPonedoraas != null) || (this.codigoRegistroDiarioPonedoraas != null && !this.codigoRegistroDiarioPonedoraas.equals(other.codigoRegistroDiarioPonedoraas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RegistroDiarioPonedoras[ codigoRegistroDiarioPonedoraas=" + codigoRegistroDiarioPonedoraas + " ]";
    }
    
}
