package sample.Models;

public class Empleados
{
    int cveEmpleado,cveSucursal,cveRol;
    String nombreEmpleado;

    public Empleados() {}

    public Empleados(int cveEmpleado, int cveRol, int cveSucursal, String nombreEmpleado) {
        this.cveEmpleado = cveEmpleado;
        this.cveRol = cveRol;
        this.cveSucursal = cveSucursal;
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public int getCveRol() {

        return cveRol;
    }

    public void setCveRol(int cveRol) {
        this.cveRol = cveRol;
    }

    public int getCveSucursal() {
        return cveSucursal;
    }

    public void setCveSucursal(int cveSucursal) {
        this.cveSucursal = cveSucursal;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmplelado) {
        this.nombreEmpleado = nombreEmplelado;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "cveEmpleado=" + cveEmpleado +
                ", cveRol=" + cveRol +
                ", cveSucursal=" + cveSucursal +
                ", nombreEmplelado='" + nombreEmpleado + '\'' +
                '}'+"\n";
    }
}
