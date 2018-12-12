package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadosDAO
{
    Connection conn;

    private static ObservableList<Empleados> data = FXCollections.observableArrayList();

    public EmpleadosDAO(Connection conn) { this.conn = conn; }

    public static void addTransaction(Empleados empleado)
    {
        data.add(empleado);
    }

    public ObservableList<Empleados> findAll()
    {
        ObservableList<sample.Models.Empleados> emp = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM empleados";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            sample.Models.Empleados p = null;
            while(rs.next()) {
                RolEmpleado rolEmpleado = new RolEmpleado();
                rolEmpleado.setCveRol(rs.getInt("cveRol"));

                p = new sample.Models.Empleados(
                        rs.getInt("cveEmpleado"),
                        rs.getInt("cveRol"),
                        rs.getInt("cveSucursal"),
                        rs.getString("nombreEmpleado")
                );
                emp.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return emp;
    }

    public ArrayList<Empleados> fetchByRol(Integer r)
    {
        ArrayList<Empleados> empleados = new ArrayList<>();
        try
        {
            String query = "select * from empleados where cveEmpleado="+"'"+r+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Empleados empleado = null;
            while(rs.next())
            {
                empleado = new Empleados();
                empleado.setCveEmpleado(rs.getInt("cveEmpleado"));
                empleado.setCveRol(rs.getInt("cveRol"));
                empleado.setCveSucursal(rs.getInt("cveSucursal"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleados.add(empleado);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    public ArrayList<Empleados> fetchBySuc(Integer s)
    {
        ArrayList<Empleados> empleados = new ArrayList<>();
        try
        {
            String query = "select * from empleados where cveSucursal="+"'"+s+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Empleados empleado = null;
            while(rs.next())
            {
                empleado = new Empleados();
                empleado.setCveEmpleado(rs.getInt("cveEmpleado"));
                empleado.setCveRol(rs.getInt("cveRol"));
                empleado.setCveSucursal(rs.getInt("cveSucursal"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleados.add(empleado);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    public ArrayList<Empleados2> fetchBoth(Integer r, Integer s)
    {
        ArrayList<Empleados2> empleados2 = new ArrayList<>();
        try
        {
            String query = "select cveEmpleado,nombreEmpleado,e.cveRol,e.cveSucursal,direccion,nombreCiudad " +
                                    "from empleados as e inner join sucursal as su on e.cveSucursal = su.cveSucursal " +
                                                        "inner join ciudad as ci on su.cveCiudad = ci.cveCiudad " +
                                    "where e.cveRol="+"'"+r+"' and e.cveSucursal="+"'"+s+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Empleados2 empleado2 = null;
            while(rs.next())
            {
                empleado2 = new Empleados2();
                empleado2.setCveEmpleado(rs.getInt("cveEmpleado"));
                empleado2.setCveRol(rs.getInt("cveRol"));
                empleado2.setCveSucursal(rs.getInt("cveSucursal"));
                empleado2.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado2.setDireccion(rs.getString("direccion"));
                empleado2.setNombreCiudad(rs.getString("nombreCiudad"));
                empleados2.add(empleado2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return empleados2;
    }
}
