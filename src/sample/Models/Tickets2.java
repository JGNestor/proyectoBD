package sample.Models;

public class Tickets2
{
    int noTicket,cantidad;
    String fecha,nombre,nombreEmpleado,tipoPago,nombreProd;
    double total;

    public Tickets2() {}

    public Tickets2(int noTicket, int cantidad, String fecha, String nombre, String nombreEmpleado, String tipoPago,
                    String nombreProd, double total) {
        this.noTicket = noTicket;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.nombre = nombre;
        this.nombreEmpleado = nombreEmpleado;
        this.tipoPago = tipoPago;
        this.nombreProd = nombreProd;
        this.total = total;
    }

    public int getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(int noTicket) {
        this.noTicket = noTicket;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Tickets2{" +
                "noTicket=" + noTicket +
                ", cantidad=" + cantidad +
                ", fecha='" + fecha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                ", nombreProd='" + nombreProd + '\'' +
                ", total=" + total +
                '}'+"\n";
    }
}
