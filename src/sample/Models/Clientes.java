package sample.Models;

public class Clientes
{
    int cveClientes, cveCiudad;
    String nombre, genero;

    public Clientes() {}

    public Clientes(int cveClientes, int cveCiudad, String nombre, String genero)
    {
        this.cveClientes = cveClientes;
        this.cveCiudad = cveCiudad;
        this.nombre = nombre;
        this.genero = genero;
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

    @Override
    public String toString() {
        return "Clientes{" +
                "cveClientes=" + cveClientes +
                ", cveCiudad=" + cveCiudad +
                ", nombre='" + nombre +
                ", genero='" + genero +
                '}'+"\n";
    }
}
