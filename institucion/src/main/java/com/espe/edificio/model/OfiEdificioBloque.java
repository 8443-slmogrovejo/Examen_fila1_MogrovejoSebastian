package com.espe.edificio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OFI_EDIFICIO_BLOQUE")
public class OfiEdificioBloque implements Serializable {

    @Id
    @Column(name = "COD_EDIFICIO_BLOQUE", length = 8, nullable = false)
    private String codEdificioBloque;
    @NotNull
    @Column(name = "COD_EDIFICIO", length = 8, nullable = false)
    private String codEdificio;
    @NotNull
    @Column(name = "NOMBRE_BLOQUE", length = 128, nullable = false)
    private String nombreBloque;
    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "COD_EDIFICIO", referencedColumnName = "COD_EDIFICIO", insertable = false, updatable = false)
    private OfiEdificio ofiEdificio;

    public OfiEdificioBloque() {
    }

    public OfiEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codEdificioBloque == null) ? 0 : codEdificioBloque.hashCode());
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
        OfiEdificioBloque other = (OfiEdificioBloque) obj;
        if (codEdificioBloque == null) {
            if (other.codEdificioBloque != null)
                return false;
        } else if (!codEdificioBloque.equals(other.codEdificioBloque))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiEdificioBloque [codEdificioBloque=" + codEdificioBloque + ", codEdificio=" + codEdificio
                + ", nombreBloque=" + nombreBloque + ", descripcion=" + descripcion + "]";
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OfiEdificio getOfiEdificio() {
        return ofiEdificio;
    }

    public void setOfiEdificio(OfiEdificio ofiEdificio) {
        this.ofiEdificio = ofiEdificio;
    }
}