package sample.Models;

public class Compras
{
    int noTicket,cveProducto,cantidad;

    public Compras() {}

    public Compras(int noTicket, int cveProducto, int cantidad) {
        this.noTicket = noTicket;
        this.cveProducto = cveProducto;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Compras{" +
                "noTicket=" + noTicket +
                ", cveProducto=" + cveProducto +
                ", cantidad=" + cantidad +
                '}'+"\n";
    }
}
