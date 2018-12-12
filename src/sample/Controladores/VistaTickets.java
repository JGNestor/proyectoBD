package sample.Controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Main;
import sample.Models.DAO.TicketsDAO;
import sample.Models.DAO.MySQL;
import sample.Models.Tickets;
import sun.security.krb5.internal.Ticket;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class VistaTickets implements Initializable
{
    @FXML JFXButton btnTiC,btnTiE,btnTiF,btnSalir, btnBorrar, btnAgregar;
    @FXML JFXTextField cli,emp,VxT;
    @FXML TableView<Tickets> tablaCli;
    @FXML TableColumn noTicket,cveCliente,cveEmpleado,cvePago,fecha,total;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnTiC.setOnAction(consultaClientes);
        btnTiE.setOnAction(consultaEmpleados);
        btnTiF.setOnAction(consultaTicket);
        btnSalir.setOnAction(atras);
        btnAgregar.setOnAction(agregar);
        btnBorrar.setOnAction(borrar);

        noTicket.setCellValueFactory(new PropertyValueFactory<Tickets, Integer>("noTicket"));
        cveCliente.setCellValueFactory(new PropertyValueFactory<Tickets, Integer>("cveCliente"));
        cveEmpleado.setCellValueFactory(new PropertyValueFactory<Tickets, Integer>("cveEmpleado"));
        cvePago.setCellValueFactory(new PropertyValueFactory<Tickets, Integer>("cvePago"));
        fecha.setCellValueFactory(new PropertyValueFactory<Tickets, String>("fecha"));
        total.setCellValueFactory(new PropertyValueFactory<Tickets, Double>("total"));

        tablaCli.setItems(ticketsDAO.findAll());
    }

    Tickets tickets = new Tickets();
    TicketsDAO ticketsDAO = new TicketsDAO(MySQL.getConnection());

    EventHandler<ActionEvent> consultaClientes = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int cveC = Integer.parseInt(cli.getText());

            if(ticketsDAO.fetchCli(cveC) == null)
            {
                error();
            }
            else
            {
                System.out.println(ticketsDAO.fetchCli(cveC));
                ObservableList<Tickets> listaT= FXCollections.observableArrayList();
                tablaCli.getItems();
                for(int i=0; i<ticketsDAO.findAll().size(); i++)
                {
                    if(ticketsDAO.findAll().get(i).getCveCliente()==cveC)
                    {
                        ticketsDAO.findAll().add(ticketsDAO.findAll().get(i));
                    }
                }
                tablaCli.setItems(ticketsDAO.findAll());
            }
        }
    };

    EventHandler<ActionEvent> consultaEmpleados = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int cveE = Integer.parseInt(emp.getText());

            if(ticketsDAO.fetchEmp(cveE) == null)
            {
                error();
            }
            else
            {
                System.out.println(ticketsDAO.fetchEmp(cveE));
            }
        }
    };

    EventHandler<ActionEvent> consultaTicket = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int noticket = Integer.parseInt(VxT.getText());

            if(ticketsDAO.fetchTicket(noticket) == null)
            {
                error();
            }
            else
            {
                System.out.println(ticketsDAO.fetchTicket(noticket));
            }
        }
    };

    private void error()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        String message = "ENTRADA INCORRECTA";
        alert.setContentText(""+message);
        alert.show();
    }

    public javafx.event.EventHandler<ActionEvent> atras = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            Main.primaryStage.show();
        }
    };

    public javafx.event.EventHandler<ActionEvent> agregar = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            try
            {
                Stage window=new Stage();
                window.setTitle("New Ticket");
//            Parent newEmployeeContent=FXMLLoader.load(getClass().getResource("/employee/new_employee.fxml"));
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/sample/Vistas/VistaNew_Ticket.fxml"));////////////////
                New_vistaTickets newVistaTickets=new New_vistaTickets();

                fxmlLoader.setController(newVistaTickets);
                Parent newTicketContent=fxmlLoader.load();
                Scene scene=new Scene(newTicketContent);
                window.setScene(scene);
                window.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>()
                {
                    @Override
                    public void handle(WindowEvent event)
                    {
                        System.out.println("Evento Hidden");//se oculto la ventana y se disparo el evento que hace que se cierre solo
                        tablaCli.getItems().clear();
                        //tablaCli.setItems(TicketsDAO.fetchAll());
                    }
                });
                //window.initOwner(_primaryStage);//hacer que la ventana de nuevo empleado...
                //window.initModality(Modality.APPLICATION_MODAL);//... no permita acceder a la ventana principal hasta que se cierre
                window.show();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    };

    public javafx.event.EventHandler<ActionEvent> borrar = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            Tickets vt=tablaCli.getSelectionModel().getSelectedItem();
            Alert message=new Alert(Alert.AlertType.CONFIRMATION);
            message.setTitle("Confirm delete");
            message.setContentText("Are you sure to delete "+vt.getNoTicket()+" ?");
//        message.showAndWait();
            Optional<ButtonType> resp=message.showAndWait();
            if(resp.get()==ButtonType.OK)
                ticketsDAO.delete(vt.getNoTicket());
            reloadTickets();
        }
    };

    private void reloadTickets()
    {
        tablaCli.setItems(ticketsDAO.findAll());
    }
}
