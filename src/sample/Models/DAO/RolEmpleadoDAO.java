package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.RolEmpleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolEmpleadoDAO
{
    Connection conn;

    private static ObservableList<RolEmpleado> data = FXCollections.observableArrayList();

    public RolEmpleadoDAO(Connection conn) { this.conn = conn; }

    public static void addTransaction(RolEmpleado rol)
    {
        data.add(rol);
    }

    public RolEmpleado fetch(int r)
    {
        ResultSet rs = null;
        RolEmpleado e = null;
        try {
            String query = "SELECT * FROM rolempleado where cveRol = " + r;
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);

            if(rs.first()) {
                e = new RolEmpleado(
                        rs.getInt("cveRol"),
                        rs.getString("nombreRol"),
                        rs.getDouble("sueldo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return e;
    }
}
