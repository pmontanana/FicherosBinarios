package ejerciciosficherosbinarios;

import ejerciciosficherosbinarios.banco.Gestor;
import ejerciciosficherosbinarios.empresa.Empresa;
import java.util.*;

public class EjerciciosFicherosBinarios {

    public static Scanner sc = new Scanner(System.in);

    public static void menuEmpresa() {
        int opc;
        Empresa empresa = new Empresa();
        empresa.cargaDatos();

        do {
            System.out.println("Elige una opcion");
            System.out.println("-----------------------");
            System.out.println("1. Añadir nuevo cliente");
            System.out.println("2. Modificar datos");
            System.out.println("3. Dar de baja cliente");
            System.out.println("4. Listar los clientes");
            System.out.println("5. Salir");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    empresa.anadirCliente();
                    break;
                case 2:
                    empresa.modificarDatos();
                    break;
                case 3:
                    empresa.bajaCliente();
                    break;
                case 4:
                    empresa.listarClientes();
                    break;
            }
        } while (opc != 5);
        empresa.guardarDatos();
    }

    public static void menuBanco() {
        int opc;
        Gestor gestor = new Gestor();
        gestor.cargarDatos();

        do {
            System.out.println("Elige una opcion");
            System.out.println("-------------------------");
            System.out.println("1. Añadir nuevo empleado");
            System.out.println("2. Dar de baja empleado");
            System.out.println("3. Mostrar datos empleados");
            System.out.println("4. Listar los empleados");
            System.out.println("5. Salir");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    gestor.alta();
                    break;
                case 2:
                    gestor.baja();
                    break;
                case 3:
                    gestor.mostrarDatos();
                    break;
                case 4:
                    gestor.listarEmpleados();
                    break;
                case 5:
                    gestor.guardarDatos();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opc != 5);

    }

    public static void main(String[] args) {
        // menuEmpresa();
        menuBanco();
    }

}
