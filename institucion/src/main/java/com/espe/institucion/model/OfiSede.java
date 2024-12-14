package com.espe.institucion.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OFI_SEDE")
public class OfiSede implements Serializable {

    @Id
    @Column(name = "COD_SEDE", length = 8, nullable = false)
    private String codSede;

    @NotNull
    @Column(name = "COD_INSTITUCION", length = 3, nullable = false)
    private Integer codInstitucion;

    @NotNull
    @Column(name = "NOMBRE", length = 128, nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "DIRECCION", length = 128, nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "ES_PRINCIPAL", nullable = false)
    private Boolean esPrincipal;

    @NotNull
    @Column(name = "PRESUPUESTO", precision = 18, scale = 2, nullable = false)
    private BigDecimal presupuesto;

    @ManyToOne
    @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
    private OfiInstitucion ofiInstitucion;

    public OfiSede() {
    }

    public OfiSede(String codSede) {
        this.codSede = codSede;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codSede == null) ? 0 : codSede.hashCode());
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
        OfiSede other = (OfiSede) obj;
        if (codSede == null) {
            if (other.codSede != null)
                return false;
        } else if (!codSede.equals(other.codSede))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiSede [codSede=" + codSede + ", codInstitucion=" + codInstitucion + ", nombre=" + nombre
                + ", direccion=" + direccion + ", esPrincipal=" + esPrincipal + ", presupuesto=" + presupuesto + "]";
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public Integer getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public OfiInstitucion getOfiInstitucion() {
        return ofiInstitucion;
    }

    public void setOfiInstitucion(OfiInstitucion ofiInstitucion) {
        this.ofiInstitucion = ofiInstitucion;
    }
}