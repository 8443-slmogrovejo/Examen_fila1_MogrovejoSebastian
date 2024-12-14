package com.espe.edificio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class AulaPK implements Serializable {

    @NotNull
    @Column(name = "COD_AULA", length = 8, nullable = false)
    private Integer codAula;
    @NotNull
    @Column(name = "COD_EDIFICIO", length = 8, nullable = false)
    private String codEdificio;
    @NotNull
    @Column(name = "COD_EDIFICIO_BLOQUE", length = 8, nullable = false)
    private String codEdificioBloque;

    public AulaPK() {
    }

    public AulaPK(@NotNull Integer codAula, @NotNull String codEdificio, @NotNull String codEdificioBloque) {
        this.codAula = codAula;
        this.codEdificio = codEdificio;
        this.codEdificioBloque = codEdificioBloque;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codAula == null) ? 0 : codAula.hashCode());
        result = prime * result + ((codEdificio == null) ? 0 : codEdificio.hashCode());
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
        AulaPK other = (AulaPK) obj;
        if (codAula == null) {
            if (other.codAula != null)
                return false;
        } else if (!codAula.equals(other.codAula))
            return false;
        if (codEdificio == null) {
            if (other.codEdificio != null)
                return false;
        } else if (!codEdificio.equals(other.codEdificio))
            return false;
        if (codEdificioBloque == null) {
            if (other.codEdificioBloque != null)
                return false;
        } else if (!codEdificioBloque.equals(other.codEdificioBloque))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AulaPK [codAula=" + codAula + ", codEdificio=" + codEdificio + ", codEdificioBloque="
                + codEdificioBloque + "]";
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

}