package sample.Models;

public class Tickets
{
    int noTicket, cveCliente, cveEmpleado, cvePago;
    String fecha;
    double total;

    public Tickets() {};

    public Tickets(int noTicket, int cveCliente, int cveEmpleado, int cvePago, String fecha, double total) {
        this.noTicket = noTicket;
        this.cveCliente = cveCliente;
        this.cveEmpleado = cveEmpleado;
        this.cvePago = cvePago;
        this.fecha = fecha;
        this.total = total;
    }

    public int getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(int noTicket) {
        this.noTicket = noTicket;
    }

    public int getCveCliente() {
        return cveCliente;
    }

    public void setCveCliente(int cveCliente) {
        this.cveCliente = cveCliente;
    }

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public int getCvePago() {
        return cvePago;
    }

    public void setCvePago(int cvePago) {
        this.cvePago = cvePago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "noTicket=" + noTicket +
                ", cveCliente=" + cveCliente +
                ", cveEmpleado=" + cveEmpleado +
                ", cvePago=" + cvePago +
                ", fecha=" + fecha +
                ", total=" + total +
                '}'+"\n";
    }
}
