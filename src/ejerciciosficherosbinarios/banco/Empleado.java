package ejerciciosficherosbinarios.banco;

import java.io.Serializable;

public class Empleado implements Comparable, Serializable {

    String dni, nombre;
    double sueldo;

    public Empleado(String dni, String nombre, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado(" + "dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + ')';
    }

    @Override
    public int compareTo(Object temp) {
        Empleado emp = (Empleado) (temp);
        return nombre.compareTo(emp.getNombre());
    }

}
