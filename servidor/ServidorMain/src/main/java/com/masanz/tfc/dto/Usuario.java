package com.masanz.tfc.dto;

import java.util.Objects;

public class Usuario {




    private int idU;
    private String nombre;
    private String contrasena;
    private String edad;

    public Usuario(int idU, String nombre, String contrasena, String edad) {
        this.idU = idU;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idU == usuario.idU && Objects.equals(nombre, usuario.nombre) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(edad, usuario.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idU, nombre, contrasena, edad);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idU=" + idU +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }






}
