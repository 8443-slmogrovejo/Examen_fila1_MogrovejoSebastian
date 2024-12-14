package com.espe.edificio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OFI_AULA")
public class OfiAula implements Serializable {

    @EmbeddedId
    private AulaPK pk;
    @NotNull
    @Column(name = "COD_TIPO_AULA", length = 10, nullable = false)
    private String codTipoAula;
    @Column(name = "COD_ALTERNO", length = 10)
    private String codAlterno;
    @NotNull
    @Column(name = "CAPACIDAD", length = 4, nullable = false)
    private Integer capacidad;
    @NotNull
    @Column(name = "PISO", length = 2, nullable = false)
    private Integer piso;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDate fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ULT_ACTUALIZACION", nullable = false)
    private LocalDateTime fechaUltActualizacion;

    @ManyToOne
    @JoinColumn(name = "COD_EDIFICIO", referencedColumnName = "COD_EDIFICIO", insertable = false, updatable = false)
    private OfiEdificio ofiEdificio;

    @ManyToOne
    @JoinColumn(name = "COD_EDIFICIO_BLOQUE", referencedColumnName = "COD_EDIFICIO_BLOQUE", insertable = false, updatable = false)
    private OfiEdificioBloque ofiEdificioBloque;

    public OfiAula() {
    }

    public OfiAula(AulaPK pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OfiAula other = (OfiAula) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiAula [pk=" + pk + ", codTipoAula=" + codTipoAula + ", codAlterno=" + codAlterno + ", capacidad="
                + capacidad + ", piso=" + piso + ", fechaCreacion=" + fechaCreacion + ", fechaUltActualizacion="
                + fechaUltActualizacion + ", ofiEdificio=" + ofiEdificio + ", ofiEdificioBloque=" + ofiEdificioBloque
                + "]";
    }

    public AulaPK getPk() {
        return pk;
    }

    public void setPk(AulaPK pk) {
        this.pk = pk;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltActualizacion() {
        return fechaUltActualizacion;
    }

    public void setFechaUltActualizacion(LocalDateTime fechaUltActualizacion) {
        this.fechaUltActualizacion = fechaUltActualizacion;
    }

    public OfiEdificio getOfiEdificio() {
        return ofiEdificio;
    }

    public void setOfiEdificio(OfiEdificio ofiEdificio) {
        this.ofiEdificio = ofiEdificio;
    }

    public OfiEdificioBloque getOfiEdificioBloque() {
        return ofiEdificioBloque;
    }

    public void setOfiEdificioBloque(OfiEdificioBloque ofiEdificioBloque) {
        this.ofiEdificioBloque = ofiEdificioBloque;
    }
}