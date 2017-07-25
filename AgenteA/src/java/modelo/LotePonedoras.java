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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dilov
 */
@Entity
@Table(name = "lote_ponedoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LotePonedoras.findAll", query = "SELECT l FROM LotePonedoras l"),
    @NamedQuery(name = "LotePonedoras.findByNumeroLotePonedoras", query = "SELECT l FROM LotePonedoras l WHERE l.numeroLotePonedoras = :numeroLotePonedoras"),
    @NamedQuery(name = "LotePonedoras.findByCodigoLotePonedoras", query = "SELECT l FROM LotePonedoras l WHERE l.codigoLotePonedoras = :codigoLotePonedoras"),
    @NamedQuery(name = "LotePonedoras.findByEdadSemanasLotePonedoras", query = "SELECT l FROM LotePonedoras l WHERE l.edadSemanasLotePonedoras = :edadSemanasLotePonedoras"),
    @NamedQuery(name = "LotePonedoras.findByFechaInicioLotePonedoras", query = "SELECT l FROM LotePonedoras l WHERE l.fechaInicioLotePonedoras = :fechaInicioLotePonedoras"),
    @NamedQuery(name = "LotePonedoras.findByNumeroPonedorasEncasetadas", query = "SELECT l FROM LotePonedoras l WHERE l.numeroPonedorasEncasetadas = :numeroPonedorasEncasetadas"),
    @NamedQuery(name = "LotePonedoras.findByComienzoPosturaPonedoras", query = "SELECT l FROM LotePonedoras l WHERE l.comienzoPosturaPonedoras = :comienzoPosturaPonedoras"),
    @NamedQuery(name = "LotePonedoras.findBySemanaComienzo", query = "SELECT l FROM LotePonedoras l WHERE l.semanaComienzo = :semanaComienzo"),
    @NamedQuery(name = "LotePonedoras.findByTotalHuevosLote", query = "SELECT l FROM LotePonedoras l WHERE l.totalHuevosLote = :totalHuevosLote"),
    @NamedQuery(name = "LotePonedoras.findByTotalHuevosSegundoLote", query = "SELECT l FROM LotePonedoras l WHERE l.totalHuevosSegundoLote = :totalHuevosSegundoLote"),
    @NamedQuery(name = "LotePonedoras.findByTotalKgAlimento", query = "SELECT l FROM LotePonedoras l WHERE l.totalKgAlimento = :totalKgAlimento"),
    @NamedQuery(name = "LotePonedoras.findByTotalMortalidadLote", query = "SELECT l FROM LotePonedoras l WHERE l.totalMortalidadLote = :totalMortalidadLote"),
    @NamedQuery(name = "LotePonedoras.findByTotalDesechoLote", query = "SELECT l FROM LotePonedoras l WHERE l.totalDesechoLote = :totalDesechoLote")})
public class LotePonedoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_lote_ponedoras")
    private Integer numeroLotePonedoras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo_lote_ponedoras")
    private String codigoLotePonedoras;
    @Column(name = "edad_semanas_lote_ponedoras")
    private Integer edadSemanasLotePonedoras;
    @Column(name = "fecha_inicio_lote_ponedoras")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioLotePonedoras;
    @Column(name = "numero_ponedoras_encasetadas")
    private Integer numeroPonedorasEncasetadas;
    @Column(name = "comienzo_postura_ponedoras")
    private Integer comienzoPosturaPonedoras;
    @Column(name = "semana_comienzo")
    private Integer semanaComienzo;
    @Column(name = "total_huevos_lote")
    private Integer totalHuevosLote;
    @Column(name = "total_huevos_segundo_lote")
    private Integer totalHuevosSegundoLote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_kg_alimento")
    private Double totalKgAlimento;
    @Column(name = "total_mortalidad_lote")
    private Integer totalMortalidadLote;
    @Column(name = "total_desecho_lote")
    private Integer totalDesechoLote;
    @OneToMany(mappedBy = "numeroLotePonedorasFk2")
    private List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList;
    @JoinColumn(name = "codigo_alimentacion_fk", referencedColumnName = "codigo_alimentacion")
    @ManyToOne
    private Alimentacion codigoAlimentacionFk;
    @JoinColumn(name = "codigo_economia_fk", referencedColumnName = "codigo_economia")
    @ManyToOne
    private Economia codigoEconomiaFk;
    @JoinColumn(name = "numero_galpon_fk", referencedColumnName = "numero_galpon")
    @ManyToOne
    private Galpon numeroGalponFk;
    @JoinColumn(name = "numero_lote_fk", referencedColumnName = "numero_lote")
    @ManyToOne
    private LoteLevante numeroLoteFk;
    @JoinColumn(name = "codigo_produccion_fk", referencedColumnName = "codigo_produccion")
    @ManyToOne
    private Produccion codigoProduccionFk;
    @JoinColumn(name = "codigo_raza_fk", referencedColumnName = "codigo_raza")
    @ManyToOne
    private Raza codigoRazaFk;
    @OneToMany(mappedBy = "numeroLotePonedorasFk")
    private List<RegistroSemanalPonedoras> registroSemanalPonedorasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroLotePonedorasFk")
    private List<AsignacionLotePonedoras> asignacionLotePonedorasList;

    public LotePonedoras() {
    }

    public LotePonedoras(Integer numeroLotePonedoras) {
        this.numeroLotePonedoras = numeroLotePonedoras;
    }

    public LotePonedoras(Integer numeroLotePonedoras, String codigoLotePonedoras) {
        this.numeroLotePonedoras = numeroLotePonedoras;
        this.codigoLotePonedoras = codigoLotePonedoras;
    }

    public Integer getNumeroLotePonedoras() {
        return numeroLotePonedoras;
    }

    public void setNumeroLotePonedoras(Integer numeroLotePonedoras) {
        this.numeroLotePonedoras = numeroLotePonedoras;
    }

    public String getCodigoLotePonedoras() {
        return codigoLotePonedoras;
    }

    public void setCodigoLotePonedoras(String codigoLotePonedoras) {
        this.codigoLotePonedoras = codigoLotePonedoras;
    }

    public Integer getEdadSemanasLotePonedoras() {
        return edadSemanasLotePonedoras;
    }

    public void setEdadSemanasLotePonedoras(Integer edadSemanasLotePonedoras) {
        this.edadSemanasLotePonedoras = edadSemanasLotePonedoras;
    }

    public Date getFechaInicioLotePonedoras() {
        return fechaInicioLotePonedoras;
    }

    public void setFechaInicioLotePonedoras(Date fechaInicioLotePonedoras) {
        this.fechaInicioLotePonedoras = fechaInicioLotePonedoras;
    }

    public Integer getNumeroPonedorasEncasetadas() {
        return numeroPonedorasEncasetadas;
    }

    public void setNumeroPonedorasEncasetadas(Integer numeroPonedorasEncasetadas) {
        this.numeroPonedorasEncasetadas = numeroPonedorasEncasetadas;
    }

    public Integer getComienzoPosturaPonedoras() {
        return comienzoPosturaPonedoras;
    }

    public void setComienzoPosturaPonedoras(Integer comienzoPosturaPonedoras) {
        this.comienzoPosturaPonedoras = comienzoPosturaPonedoras;
    }

    public Integer getSemanaComienzo() {
        return semanaComienzo;
    }

    public void setSemanaComienzo(Integer semanaComienzo) {
        this.semanaComienzo = semanaComienzo;
    }

    public Integer getTotalHuevosLote() {
        return totalHuevosLote;
    }

    public void setTotalHuevosLote(Integer totalHuevosLote) {
        this.totalHuevosLote = totalHuevosLote;
    }

    public Integer getTotalHuevosSegundoLote() {
        return totalHuevosSegundoLote;
    }

    public void setTotalHuevosSegundoLote(Integer totalHuevosSegundoLote) {
        this.totalHuevosSegundoLote = totalHuevosSegundoLote;
    }

    public Double getTotalKgAlimento() {
        return totalKgAlimento;
    }

    public void setTotalKgAlimento(Double totalKgAlimento) {
        this.totalKgAlimento = totalKgAlimento;
    }

    public Integer getTotalMortalidadLote() {
        return totalMortalidadLote;
    }

    public void setTotalMortalidadLote(Integer totalMortalidadLote) {
        this.totalMortalidadLote = totalMortalidadLote;
    }

    public Integer getTotalDesechoLote() {
        return totalDesechoLote;
    }

    public void setTotalDesechoLote(Integer totalDesechoLote) {
        this.totalDesechoLote = totalDesechoLote;
    }

    @XmlTransient
    public List<GuiaVacunacionLotePonedoras> getGuiaVacunacionLotePonedorasList() {
        return guiaVacunacionLotePonedorasList;
    }

    public void setGuiaVacunacionLotePonedorasList(List<GuiaVacunacionLotePonedoras> guiaVacunacionLotePonedorasList) {
        this.guiaVacunacionLotePonedorasList = guiaVacunacionLotePonedorasList;
    }

    public Alimentacion getCodigoAlimentacionFk() {
        return codigoAlimentacionFk;
    }

    public void setCodigoAlimentacionFk(Alimentacion codigoAlimentacionFk) {
        this.codigoAlimentacionFk = codigoAlimentacionFk;
    }

    public Economia getCodigoEconomiaFk() {
        return codigoEconomiaFk;
    }

    public void setCodigoEconomiaFk(Economia codigoEconomiaFk) {
        this.codigoEconomiaFk = codigoEconomiaFk;
    }

    public Galpon getNumeroGalponFk() {
        return numeroGalponFk;
    }

    public void setNumeroGalponFk(Galpon numeroGalponFk) {
        this.numeroGalponFk = numeroGalponFk;
    }

    public LoteLevante getNumeroLoteFk() {
        return numeroLoteFk;
    }

    public void setNumeroLoteFk(LoteLevante numeroLoteFk) {
        this.numeroLoteFk = numeroLoteFk;
    }

    public Produccion getCodigoProduccionFk() {
        return codigoProduccionFk;
    }

    public void setCodigoProduccionFk(Produccion codigoProduccionFk) {
        this.codigoProduccionFk = codigoProduccionFk;
    }

    public Raza getCodigoRazaFk() {
        return codigoRazaFk;
    }

    public void setCodigoRazaFk(Raza codigoRazaFk) {
        this.codigoRazaFk = codigoRazaFk;
    }

    @XmlTransient
    public List<RegistroSemanalPonedoras> getRegistroSemanalPonedorasList() {
        return registroSemanalPonedorasList;
    }

    public void setRegistroSemanalPonedorasList(List<RegistroSemanalPonedoras> registroSemanalPonedorasList) {
        this.registroSemanalPonedorasList = registroSemanalPonedorasList;
    }

    @XmlTransient
    public List<AsignacionLotePonedoras> getAsignacionLotePonedorasList() {
        return asignacionLotePonedorasList;
    }

    public void setAsignacionLotePonedorasList(List<AsignacionLotePonedoras> asignacionLotePonedorasList) {
        this.asignacionLotePonedorasList = asignacionLotePonedorasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLotePonedoras != null ? numeroLotePonedoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LotePonedoras)) {
            return false;
        }
        LotePonedoras other = (LotePonedoras) object;
        if ((this.numeroLotePonedoras == null && other.numeroLotePonedoras != null) || (this.numeroLotePonedoras != null && !this.numeroLotePonedoras.equals(other.numeroLotePonedoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LotePonedoras[ numeroLotePonedoras=" + numeroLotePonedoras + " ]";
    }
    
}
