package ejerciciosficherosbinarios.banco;

import java.io.*;
import java.util.*;

public class Gestor {

    Scanner sc;
    ArrayList<Empleado> empleados;
    String archivo;

    public Gestor() {
        empleados = new ArrayList<Empleado>();
        sc = new Scanner(System.in);
        archivo = "empleados.dat";
    }

    private void titulo(String texto) {
        System.out.println("=".repeat(texto.length()));
        System.out.println(texto);
        System.out.println("=".repeat(texto.length()));
    }

    public void alta() {
        String dni, nombre;
        double sueldo;

        titulo("Alta de empleado");
        System.out.println("Escribe el DNI del empleado");
        dni = sc.nextLine();
        if (buscarDNI(dni) != -1) {
            System.out.println("Ese DNI ya existe");
            return;
        }
        System.out.println("Escribe el nombre del empleado");
        nombre = sc.nextLine();
        System.out.println("Escribe el sueldo del empleado");
        sueldo = Double.parseDouble(sc.nextLine());
        empleados.add(new Empleado(dni, nombre, sueldo));
    }

    private int buscarEmpleado() {
        String dni;
        System.out.println("Introduce DNI");
        dni = sc.nextLine();
        return buscarDNI(dni);
    }

    private int buscarDNI(String dni) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    public void baja() {
        int indice;
        titulo("Baja de empleado");
        indice = buscarEmpleado();
        if (indice != -1) {
            empleados.remove(indice);
        }
    }

    public void mostrarDatos() {
        int indice;
        titulo("Mostrar datos empleado");
        indice = buscarEmpleado();
        if (indice != -1) {
            System.out.println(empleados.get(indice));
        }
    }

    public void listarEmpleados() {
        titulo("Listar empleados");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error guardando el archivo");
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (ArrayList<Empleado>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Agenda Vacia");
            return;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
