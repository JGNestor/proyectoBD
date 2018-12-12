package sample.Models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Clientes;
import sample.Models.Productos;
import sample.Models.Tickets;
import sample.Models.Tickets2;

import java.sql.*;
import java.util.ArrayList;

public class TicketsDAO
{
    Connection conn;
    public TicketsDAO(Connection conn) { this.conn = conn; }

    public ObservableList<Tickets> findAll()
    {
        ObservableList<sample.Models.Tickets> ticket = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM ticket";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            sample.Models.Tickets p = null;
            while(rs.next()) {
                p = new sample.Models.Tickets(
                        rs.getInt("noTicket"),
                        rs.getInt("cveCliente"),
                        rs.getInt("cveEmpleado"),
                        rs.getInt("cvePago"),
                        rs.getString("fecha"),
                        rs.getDouble("total")
                );
                ticket.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return ticket;
    }

    public ArrayList<Tickets> fetchCli(Integer cveC)
    {
        ArrayList<Tickets> tickets = new ArrayList<>();
        try
        {
            String query = "select * from ticket where cveCliente="+"'"+cveC+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Tickets ticket = null;
            while(rs.next())
            {
                ticket = new Tickets();
                ticket.setNoTicket(rs.getInt("noTicket"));
                ticket.setCveCliente(rs.getInt("cveCliente"));
                ticket.setCveEmpleado(rs.getInt("cveEmpleado"));
                ticket.setCvePago(rs.getInt("cvePago"));
                ticket.setFecha(rs.getString("fecha"));
                ticket.setTotal(rs.getDouble("total"));
                tickets.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public ArrayList<Tickets> fetchEmp(Integer cveE)
    {
        ArrayList<Tickets> tickets = new ArrayList<>();
        try
        {
            String query = "select * from ticket where cveEmpleado="+"'"+cveE+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Tickets ticket = null;
            while(rs.next())
            {
                ticket = new Tickets();
                ticket.setNoTicket(rs.getInt("noTicket"));
                ticket.setCveCliente(rs.getInt("cveCliente"));
                ticket.setCveEmpleado(rs.getInt("cveEmpleado"));
                ticket.setCvePago(rs.getInt("cvePago"));
                ticket.setFecha(rs.getString("fecha"));
                ticket.setTotal(rs.getDouble("total"));
                tickets.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public ObservableList<Tickets> fetchAll() {//
        ObservableList<Tickets> tickets = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM ticket";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);//ejecutamos la sentencia/ResultSet=Conjunto de resultados que arroja la sentencia
            Tickets p = null;
            while(rs.next()) {//metodo next: accedemos a cada uno de los resultados
                p = new Tickets(
                        rs.getInt("noTicket"),
                        rs.getInt("cveCliente"),
                        rs.getInt("cveEmpleado"),
                        rs.getInt("cvePago"),
                        rs.getString("fecha"),
                        rs.getDouble("total")
                );
                tickets.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return tickets;
    }

    public ArrayList<Tickets2> fetchTicket(Integer noticket)
    {
        ArrayList<Tickets2> tickets2 = new ArrayList<>();
        try
        {
            String query = "select ticket.noTicket,fecha,total,nombre,nombreEmpleado,tipoPago,nombreProd,cantidad " +
                                "from ticket inner join clientes on clientes.cveClientes = ticket.cveCliente " +
                                            "inner join empleados on empleados.cveEmpleado = ticket.cveEmpleado " +
                                            "inner join metodopago on metodopago.cvePago = ticket.cvePago " +
                                            "inner join compra on ticket.noTicket = compra.noTicket " +
                                            "inner join productos on compra.cveProducto = productos.cveProducto " +
                                "where ticket.noTicket="+"'"+noticket+"'";
            System.out.println(query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            Tickets2 ticket2 = null;
            while(rs.next())
            {
                ticket2 = new Tickets2();
                ticket2.setNoTicket(rs.getInt("noTicket"));
                ticket2.setCantidad(rs.getInt("cantidad"));
                ticket2.setFecha(rs.getString("fecha"));
                ticket2.setNombre(rs.getString("nombre"));
                ticket2.setNombreEmpleado(rs.getString("nombreEmpleado"));
                ticket2.setTipoPago(rs.getString("tipoPago"));
                ticket2.setNombreProd(rs.getString("nombreProd"));
                ticket2.setTotal(rs.getDouble("total"));
                tickets2.add(ticket2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return tickets2;
    }

    public Boolean insert(Tickets tickets) {
        try {
            String query = "insert into tickets "
                    + " (noTicket, cveCliente, cveEmpleado, cvePago, fecha, total)"
                    + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setInt(   1, tickets.getNoTicket());
            st.setInt(  2, tickets.getCveCliente());
            st.setInt(3, tickets.getCveEmpleado());
            st.setInt(4, tickets.getCvePago());
            st.setString(5, String.valueOf(tickets.getFecha()));
            st.setDouble(  6, tickets.getTotal());
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Boolean delete(int noTicket) {
        try {
            String query = "delete from ticket where noTicket = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, noTicket);
            st.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
