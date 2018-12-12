package sample.Models;

public class RolEmpleado
{
    int cveRol;
    String nombreRol;
    double sueldo;

    public RolEmpleado() {}

    public RolEmpleado(int cveRol, String nombreRol, double sueldo) {
        this.cveRol = cveRol;
        this.nombreRol = nombreRol;
        this.sueldo = sueldo;
    }

    public int getCveRol() {
        return cveRol;
    }

    public void setCveRol(int cveRol) {
        this.cveRol = cveRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "RolEmpleado{" +
                "cveRol=" + cveRol +
                ", nombreRol='" + nombreRol + '\'' +
                ", sueldo=" + sueldo +
                '}'+"\n";
    }
}
