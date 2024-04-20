import productos.Laptop;
import productos.Producto;
import productos.Telefono;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Producto> listaProductos = new ArrayList<>();
    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        Scanner sn = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Ingrese una opcion del menu: ");
                System.out.println("\t1. Agregar producto");
                System.out.println("\t2. Modificar un procuto");
                System.out.println("\t3. Listar todos los productos");
                System.out.println("\t0. Salir");
                System.out.print(">>");
                opcion = sn.nextInt();
                sn.nextLine();
                if(opcion == 0){
                    System.out.println("\nHasta la proxima!!\n");
                    break;
                }
                switch (opcion){
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        modificarProducto();
                        break;
                    case 3:
                        listarProductos();
                        break;
                    default:
                        System.out.println("\nIngrese una opcion del menu\n");
                        break;
                }
            }catch (Exception e){
                System.out.println("\nFavor ingrese un caracter numerico...\n");
                sn.nextLine();
            }
        }

    }

    private static void modificarProducto() {
        int id;
        Scanner sn = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Ingrese el identificador del producto del que desea modificar su nombre: ");
                id = sn.nextInt();
                sn.nextLine();
                for (int i = 0; i < listaProductos.size(); i++) {
                    if(listaProductos.get(i).getIdentificador() == id){
                        String nombre;
                        System.out.println("Ingrese el nuevo nombre del producto: ");
                        nombre = sn.nextLine();
                        listaProductos.get(i).setNombre(nombre);
                        System.out.println("\nProducto modificado satisfactoriamente\n");
                        return;
                    }
                }
                System.out.println("\nNo se encontraron coincidencias\n");
                return;
            }catch (Exception e){
                System.out.println("\nFavor ingresar caracter valido...\n");
                sn.nextLine();
            }
        }


    }

    private static void listarProductos() {
        System.out.println("\t\tPRODUCTOS\t\t");
        System.out.println("ID\t|Nombre\t\t|Modelo\t|Precio\t|Descripcion");
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            System.out.println(producto.getIdentificador() + "\t|"+ producto.getNombre() + "\t|" + producto.getModelo() + "|" + producto.getPrecio() + "|" + producto.getDescripcion());
        }
    }

    private static void agregarProducto() {
        Scanner sn = new Scanner(System.in);
        String nombre, modelo, descripcion;
        float precio;
        Producto producto = null;
        System.out.println("Ingrese el nombre del producto: ");
        nombre = sn.nextLine();
        System.out.println("Ingrese el modelo del producto: ");
        modelo = sn.nextLine();
        System.out.println("Ingrese la descripcion del producto");
        descripcion = sn.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        precio = sn.nextFloat();
        sn.nextLine();
        switch (obtenerTipoDeProducto()){
            case 1:
                String compania;
                float camaraFrontal, camaraTrasera;
                System.out.println("Ingrese la compañia telefonica del dispositivo: ");
                compania = sn.nextLine();
                System.out.println("Ingrese la resolucion de la camara frontal (en px): ");
                camaraFrontal = sn.nextFloat();
                System.out.println("Ingrese la resolucion de la camara trasera (en px): ");
                camaraTrasera = sn.nextFloat();
                producto = new Telefono(nombre, modelo, descripcion, precio, compania, camaraFrontal, camaraTrasera);
                break;
            case 2:
                String procesador, SO;
                int ram;
                System.out.println("Ingrese la marca del procesador: ");
                procesador = sn.nextLine();
                System.out.println("Ingrese el sistema operativo de su dispositivo: ");
                SO = sn.nextLine();
                System.out.println("Ingrese la cantidad de ram del dispositivo (en GB enteros): ");
                ram = sn.nextInt();
                producto = new Laptop(nombre, modelo, descripcion, precio, procesador, ram, SO);

                break;
        }
        System.out.println("\nProducto agregado satisfactoriamente con el identificador: " + producto.getIdentificador() + "\n");
        listaProductos.add(producto);
    }
    private static int obtenerTipoDeProducto(){
        Scanner sn = new Scanner(System.in);
        int opcion;
        while (true){
            try{
                System.out.println("Ingrese el tipo de producto que desea agregar: ");
                System.out.println("\t1. Telefono movil");
                System.out.println("\t2. Laptop");
                opcion = sn.nextInt();
                if(opcion >=1 && opcion <=2){
                   return opcion;
                }
                System.out.println("\nIngrese una opcion valida\n");
            } catch (Exception e){
                System.out.println("\nFavor ingrese un caracter valido\n");;
            }
        }
    }
}