package sample.Models;

public class Productos
{
    int cveProducto,cveTipo,cvePromo,cveProveedor;
    double precio;
    String nombreProd;

    public Productos() { }

    public Productos(int cveProducto, int cveTipo, int cvePromo, int cveProveedor, double precio, String nombreProd)
    {
        this.cveProducto = cveProducto;
        this.cveTipo = cveTipo;
        this.cvePromo = cvePromo;
        this.cveProveedor = cveProveedor;
        this.precio = precio;
        this.nombreProd = nombreProd;
    }

    public int getCveProducto() {
        return cveProducto;
    }

    public void setCveProducto(int cveProducto) {
        this.cveProducto = cveProducto;
    }

    public int getCveTipo() {
        return cveTipo;
    }

    public void setCveTipo(int cveTipo) {
        this.cveTipo = cveTipo;
    }

    public int getCvePromo() {
        return cvePromo;
    }

    public void setCvePromo(int cvePromo) {
        this.cvePromo = cvePromo;
    }

    public int getCveProveedor() {
        return cveProveedor;
    }

    public void setCveProveedor(int cveProveedor) {
        this.cveProveedor = cveProveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "cveProducto=" + cveProducto +
                ", cveTipo=" + cveTipo +
                ", cvePromo=" + cvePromo +
                ", cveProveedor=" + cveProveedor +
                ", precio=" + precio +
                ", nombreProd='" + nombreProd + '\'' +
                '}'+"\n";
    }
}
