package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Compras;
import sample.Models.Compras2;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComprasDAO 
{
    Connection conn;

    private static ObservableList<Compras> data = FXCollections.observableArrayList();

    public ComprasDAO(Connection conn) { this.conn = conn; }

    public static void addTransaction(Compras compra)
    {
        data.add(compra);
    }

    public ObservableList<Compras> findAll()
    {
        ObservableList<sample.Models.Compras> com = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM compra";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            sample.Models.Compras p = null;
            while(rs.next()) {
                p = new sample.Models.Compras(
                        rs.getInt("noTicket"),
                        rs.getInt("cveProducto"),
                        rs.getInt("cantidad")
                );
                com.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return com;
    }

    public ArrayList<Compras> fetchByProd(Integer r)
    {
        ArrayList<Compras> compras = new ArrayList<>();
        try
        {
            String query = "select * from compra where cveProducto="+"'"+r+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Compras compra = null;
            while(rs.next())
            {
                compra = new Compras();
                compra.setNoTicket(rs.getInt("noTicket"));
                compra.setCveProducto(rs.getInt("cveProducto"));
                compra.setCantidad(rs.getInt("cantidad"));
                compras.add(compra);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return compras;
    }

    public ArrayList<Compras> fetchByCan(Integer s)
    {
        ArrayList<Compras> compras = new ArrayList<>();
        try
        {
            String query = "select * from compra where cantidad="+"'"+s+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Compras compra = null;
            while(rs.next())
            {
                compra = new Compras();
                compra.setNoTicket(rs.getInt("noTicket"));
                compra.setCveProducto(rs.getInt("cveProducto"));
                compra.setCantidad(rs.getInt("cantidad"));
                compras.add(compra);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return compras;
    }

    public ArrayList<Compras2> fetchBoth(Integer r, Integer s)
    {
        ArrayList<Compras2> compras2 = new ArrayList<>();
        try
        {
            String query = "select c.noTicket, c.cveProducto, cantidad, cl.nombre, p.nombreProd " +
                    "from compra as c inner join ticket as t on c.noTicket = t.noTicket " +
                    "inner join clientes as cl on t.cveCliente = cl.cveClientes " +
                    "inner join productos as p on c.cveProducto = p.cveProducto " +
                    "where c.cveProducto="+"'"+r+"' and c.cantidad="+"'"+s+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Compras2 compra2 = null;
            while(rs.next())
            {
                compra2 = new Compras2();
                compra2.setNoTicket(rs.getInt("noTicket"));
                compra2.setCveProducto(rs.getInt("cveProducto"));
                compra2.setCantidad(rs.getInt("cantidad"));
                compra2.setNombre(rs.getString("nombre"));
                compra2.setNombrePod(rs.getString("nombreProd"));
                compras2.add(compra2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return compras2;
    }
}
