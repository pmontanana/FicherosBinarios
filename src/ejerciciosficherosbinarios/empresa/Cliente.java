package ejerciciosficherosbinarios.empresa;

import java.io.*;
import java.util.*;


public class Cliente implements Comparable, Serializable{
    int id;
    String nombre;
    long telefono;
    
    public Cliente(int id, String nombre, long telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente(" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ')';
    }
    
    @Override
    public int compareTo(Object temp){
        Cliente cliente = (Cliente) temp;
        return nombre.compareTo(cliente.getNombre());
    }
}
