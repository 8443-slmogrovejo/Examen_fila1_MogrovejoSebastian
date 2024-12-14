package com.espe.tipoaula.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OFI_TIPO_AULA")
public class OfiTipoAula implements Serializable {

    @Id
    @Column(name = "COD_TIPO_AULA", length = 10, nullable = false)
    private String codTipoAula;
    @NotNull
    @Column(name = "DESCRIPCION", length = 128, nullable = false)
    private String descripcion;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDate fechaCreacion;

    public OfiTipoAula() {
    }

    public OfiTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codTipoAula == null) ? 0 : codTipoAula.hashCode());
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
        OfiTipoAula other = (OfiTipoAula) obj;
        if (codTipoAula == null) {
            if (other.codTipoAula != null)
                return false;
        } else if (!codTipoAula.equals(other.codTipoAula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiTipoAula [codTipoAula=" + codTipoAula + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + "]";
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}