package productos;

public class Telefono extends Producto implements Priceable{

    private String companiaTelefonica;
    private float camaraFrontal;
    private float camaraTrasera;

    public Telefono(String nombre, String modelo, String descripcion, float precio, String companiaTelefonica, float camaraFrontal, float camaraTrasera) {
        super(nombre, modelo, descripcion, precio);
        this.companiaTelefonica = companiaTelefonica;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
    }

    public float obtenerPrecio() {
        return this.getPrecio();
    }
    public String getDescripcion(){
        return obtenerDescripcion();
    }
    public String obtenerDescripcion() {
        return super.getDescripcion() + ", compañia " + companiaTelefonica + ", camara frontal de " + camaraFrontal + " mega pixeles" + ", camara trasera de "+ camaraTrasera + " mega pixeles";
    }
}
