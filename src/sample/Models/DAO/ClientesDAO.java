package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Clientes;
import sample.Models.Clientes2;
import sample.Models.Productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientesDAO 
{
    Connection conn;

    public ClientesDAO(Connection conn) { this.conn = conn; }

    public ObservableList<Clientes> findAll()
    {
        ObservableList<sample.Models.Clientes> cli = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM clientes";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            sample.Models.Clientes p = null;
            while(rs.next()) {
                p = new sample.Models.Clientes(
                        rs.getInt("cveClientes"),
                        rs.getInt("cveCiudad"),
                        rs.getString("nombre"),
                        rs.getString("genero")
                );
                cli.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return cli;
    }

    public ArrayList<Clientes> fetchGen(String gen)
    {
        ArrayList<Clientes> clientes = new ArrayList<>();
        try
        {
            String query = "select * from clientes where genero="+"'"+gen+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Clientes cliente = null;
            while(rs.next())
            {
                cliente = new Clientes();
                cliente.setCveClientes(rs.getInt("cveClientes"));
                cliente.setCveCiudad(rs.getInt("cveCiudad"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setGenero(rs.getString("genero"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    public ArrayList<Clientes> fetchCity(Integer cve)
    {
        ArrayList<Clientes> clientes = new ArrayList<>();
        try
        {
            String query = "select * from clientes where cveCiudad="+"'"+cve+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Clientes cliente = null;
            while(rs.next())
            {
                cliente = new Clientes();
                cliente.setCveClientes(rs.getInt("cveClientes"));
                cliente.setCveCiudad(rs.getInt("cveCiudad"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setGenero(rs.getString("genero"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    public ArrayList<Clientes2> fetchBoth(Integer cve, String gen)
    {
        ArrayList<Clientes2> clientes2 = new ArrayList<>();
        try
        {
            String query = "select * from clientes as cl inner join ciudad as ci on cl.cveCiudad = ci.cveCiudad " +
                            "where cl.cveCiudad="+"'"+cve+"' and genero="+"'"+gen+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Clientes2 cliente2 = null;
            while(rs.next())
            {
                cliente2 = new Clientes2();
                cliente2.setCveClientes(rs.getInt("cveClientes"));
                cliente2.setCveCiudad(rs.getInt("cveCiudad"));
                cliente2.setNombre(rs.getString("nombre"));
                cliente2.setGenero(rs.getString("genero"));
                cliente2.setCiudad(rs.getString("nombreCiudad"));
                clientes2.add(cliente2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return clientes2;
    }
}
