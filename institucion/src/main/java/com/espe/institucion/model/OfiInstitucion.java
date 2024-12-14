package com.espe.institucion.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OFI_INSTITUCION")
public class OfiInstitucion implements Serializable {

    @Id
    @Column(name = "COD_INSTITUCION", length = 3, nullable = false)
    private Integer codInstitucion;
    
    @NotNull
    @Column(name = "RUC", length = 13, nullable = false)
    private String ruc;
    
    @NotNull
    @Column(name = "RAZON_SOCIAL", length = 250, nullable = false)
    private String razonSocial;
    
    @NotNull
    @Column(name = "NOMBRE_COMERCIAL", length = 250, nullable = false)
    private String nombreComercial;

    public OfiInstitucion() {
    }

    public OfiInstitucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codInstitucion == null) ? 0 : codInstitucion.hashCode());
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
        OfiInstitucion other = (OfiInstitucion) obj;
        if (codInstitucion == null) {
            if (other.codInstitucion != null)
                return false;
        } else if (!codInstitucion.equals(other.codInstitucion))
            return false;
        return true;
    }

    public Integer getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @Override
    public String toString() {
        return "OfiInstitucion [codInstitucion=" + codInstitucion + ", ruc=" + ruc + ", razonSocial=" + razonSocial
                + ", nombreComercial=" + nombreComercial + "]";
    }
}