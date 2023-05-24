package ejerciciosficherosbinarios.empresa;

import java.io.*;
import java.util.*;

public class Empresa {

    ArrayList<Cliente> clientes;
    String fichero;
    Scanner sc;

    public Empresa() {
        fichero = "informacion.dat";
        clientes = new ArrayList<Cliente>();
        sc = new Scanner(System.in);
    }

    public void anadirCliente() {
        int id;
        String nombre;
        long telefono;
        System.out.println("Añadir cliente");
        System.out.println("Introduce ID de cliente: ");
        id = Integer.parseInt(sc.nextLine());
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                System.out.println("Ya existe un cliente con ese código");
                return;
            }
        }
        System.out.println("Introduce Nombre de cliente: ");
        nombre = sc.nextLine();
        System.out.println("Introduce Telefono de cliente: ");
        telefono = Integer.parseInt(sc.nextLine());

        clientes.add(new Cliente(id, nombre, telefono));
        System.out.println("Cliente añadido");
    }

    public void modificarDatos() {
        int id;
        String nombre;
        long telefono;

        System.out.println("Modificar datos");

        System.out.println("Elige el cliente que quieras modificar");
        id = Integer.parseInt(sc.nextLine());
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                System.out.println(cliente);
                System.out.println("Escribe nuevo nombre: ");
                nombre = sc.nextLine();
                System.out.println("Escribe nuevo telefono: ");
                telefono = Integer.parseInt(sc.nextLine());
                cliente.setNombre(nombre);
                cliente.setTelefono(telefono);
                System.out.println("Cliente modificado");
            }
        }

    }

    public void bajaCliente() {
        int id;
        boolean borrado = false;

        System.out.println("Baja cliente");

        System.out.println("Elige el cliente que quieras dar de baja");
        id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                System.out.println(clientes.get(i));
                clientes.remove(i);
                System.out.println("Cliente borrado");
                borrado = true;
            }
        }
        if (!borrado) {
            System.out.println("No se ha encontrado el cliente");
        }
    }

    public void listarClientes() {
        System.out.println("Listar clientes");
        Collections.sort(clientes);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fichero))) {
            Collections.sort(clientes);
            out.writeObject(clientes);
        } catch (IOException ex) {
            System.out.println("Error grabando en el archivo " + ex);
        }
    }

    public void cargaDatos() {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(new FileInputStream(fichero));
        } catch (Exception ex) {
            // Si no existe el fichero no carga nada
            return;
        }
        try {
            clientes = (ArrayList<Cliente>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error cargando en el archivo " + ex);
        }
    }
}
