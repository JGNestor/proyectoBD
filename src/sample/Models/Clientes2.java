package sample.Models;

public class Clientes2
{
    int cveClientes, cveCiudad;
    String nombre, genero, ciudad;

    public Clientes2(){}

    public Clientes2(int cveClientes, int cveCiudad, String nombre, String genero, String ciudad) {
        this.cveClientes = cveClientes;
        this.cveCiudad = cveCiudad;
        this.nombre = nombre;
        this.genero = genero;
        this.ciudad = ciudad;
    }

    public int getCveClientes() {
        return cveClientes;
    }

    public void setCveClientes(int cveClientes) {
        this.cveClientes = cveClientes;
    }

    public int getCveCiudad() {
        return cveCiudad;
    }

    public void setCveCiudad(int cveCiudad) {
        this.cveCiudad = cveCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Clientes2{" +
                "cveClientes=" + cveClientes +
                ", cveCiudad=" + cveCiudad +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}'+"\n";
    }
}
