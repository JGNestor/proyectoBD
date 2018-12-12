package sample.Models;

public class Compras2
{
    int noTicket,cveProducto,cantidad;
    String nombre,nombrePod;

    public Compras2() {}

    public Compras2(int noTicket, int cveProducto, int cantidad, String nombre, String nombrePod) {
        this.noTicket = noTicket;
        this.cveProducto = cveProducto;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.nombrePod = nombrePod;
    }

    public int getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(int noTicket) {
        this.noTicket = noTicket;
    }

    public int getCveProducto() {
        return cveProducto;
    }

    public void setCveProducto(int cveProducto) {
        this.cveProducto = cveProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePod() {
        return nombrePod;
    }

    public void setNombrePod(String nombrePod) {
        this.nombrePod = nombrePod;
    }

    @Override
    public String toString() {
        return "Compras2{" +
                "noTicket=" + noTicket +
                ", cveProducto=" + cveProducto +
                ", cantidad=" + cantidad +
                ", cliente='" + nombre + '\'' +
                ", nombrePod='" + nombrePod + '\'' +
                '}'+"\n";
    }
}
