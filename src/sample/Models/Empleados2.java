package sample.Models;

public class Empleados2
{
    int cveEmpleado,cveRol,cveSucursal;
    String nombreEmpleado,direccion,nombreCiudad;

    public Empleados2() {}

    public Empleados2(int cveEmpleado, int cveRol, int cveSucursal, String nombreEmpleado, String direccion, String nombreCiudad) {
        this.cveEmpleado = cveEmpleado;
        this.cveRol = cveRol;
        this.cveSucursal = cveSucursal;
        this.nombreEmpleado = nombreEmpleado;
        this.direccion = direccion;
        this.nombreCiudad = nombreCiudad;
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

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public String toString() {
        return "Empleados2{" +
                "cveEmpleado=" + cveEmpleado +
                ", cveRol=" + cveRol +
                ", cveSucursal=" + cveSucursal +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombreCiudad='" + nombreCiudad + '\'' +
                '}'+"\n";
    }
}
