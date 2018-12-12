package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Productos;

import java.sql.*;

public class ProductosDAO 
{
    Connection conn;

    private static ObservableList<sample.Models.Productos> data = FXCollections.observableArrayList();

    public ProductosDAO(Connection conn) { this.conn = conn; }

    public static void addTransaction(sample.Models.Productos productos)
    {
        data.add(productos);
    }


    public ObservableList<Productos> findAll()
    {
        ObservableList<sample.Models.Productos> prod = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM productos";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            sample.Models.Productos p = null;
            while(rs.next()) {
                p = new sample.Models.Productos(
                        rs.getInt("cveProducto"),
                        rs.getInt("cveTipo"),
                        rs.getInt("cvePromo"),
                        rs.getInt("cveProveedor"),
                        rs.getDouble("precio"),
                        rs.getString("nombreProd")
                );
                prod.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return prod;
    }


    public sample.Models.Productos fetch(int id)
    {
        ResultSet rs = null;
        sample.Models.Productos e = null;
        try {
            String query = "SELECT * FROM productos where cveProducto = " + "'" + id + "'";
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);

            if(rs.first())
            {
                e = new sample.Models.Productos(
                        rs.getInt("cveProducto"),
                        rs.getInt("cveTipo"),
                        rs.getInt("cvePromo"),
                        rs.getInt("cveProveedor"),
                        rs.getDouble("precio"),
                        rs.getString("nombreProd")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return e;
    }

    public Boolean updateProductos(Integer cveProducto, Integer cveTipo, Integer cvePromo, Integer cveProveedor,
                                   Double precio, String nombreProd)
    {
        try {
            String query = "update productos "
                    + " set cveProducto = ?, cveTipo = ?, cvePromo = ?, cveProveedor = ?, precio = ?, nombreProd = ?"
                    + " where cveProducto = ?";
            System.out.println(query + "\nupdating....");

            PreparedStatement st =  conn.prepareStatement(query);

            st.setInt(1, cveProducto);
            st.setInt(2, cveTipo);
            st.setInt(3, cvePromo);
            st.setInt(4, cveProveedor);
            st.setDouble(5, precio);
            st.setString(6, nombreProd);
            st.setInt(7, cveProducto);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean deleteProductos(Integer cveProducto)
    {
        try {
            String query = "delete from productos where cveProducto = "+ "'" + cveProducto + "'";
            System.out.println(query + "\ndeleting....");

            PreparedStatement st =  conn.prepareStatement(query);

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean addProductos(Productos pro)
    {
        try
        {
            String query = "insert into productos values (?,?,?,?,?,?)";
            System.out.println(query + "\nadding....");

            PreparedStatement st =  conn.prepareStatement(query);

            st.setInt(1,pro.getCveProducto());
            st.setString(2,pro.getNombreProd());
            st.setDouble(3,pro.getPrecio());
            st.setInt(4,pro.getCveTipo());
            st.setInt(5,pro.getCvePromo());
            st.setInt(6,pro.getCveProveedor());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return true;
    }
}
