package productos;

public class Laptop extends Producto implements Priceable{

    private String procesador;
    private int ram;
    private String SO;

    public Laptop(String nombre, String modelo, String descripcion, float precio, String procesador, int ram, String SO) {
        super(nombre, modelo, descripcion, precio);
        this.procesador = procesador;
        this.ram = ram;
        this.SO = SO;
    }

    public float obtenerPrecio() {
        return this.getPrecio();
    }

    public String getDescripcion(){
        return obtenerDescripcion();
    }

    public String obtenerDescripcion() {
        return super.getDescripcion() + ", Procesador " + procesador + ", " + ram  + "GB de ram\t|" + ", Sistema operativo " + SO;

    }
}
