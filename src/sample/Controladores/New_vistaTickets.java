package sample.Controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sample.Models.DAO.MySQL;
import sample.Models.DAO.ProductosDAO;
import sample.Models.DAO.TicketsDAO;
import sample.Models.Productos;
import sample.Models.Tickets;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class New_vistaTickets {

    @FXML
    JFXButton save, cancel;
    @FXML
    JFXTextField txtFnoTicket, txtFcveCli, txtFcveEmp, txtFcvePago, txtFdate, txtFtotal;

    sample.Models.DAO.TicketsDAO ticketsDAO = new TicketsDAO(MySQL.getConnection());

    //@Override
    public void initialize(URL location, ResourceBundle resources)
    {
        txtFnoTicket.setText(String.valueOf(tickets.getNoTicket()));
        txtFcveCli.setText(String.valueOf(tickets.getCveCliente()));
        txtFcveEmp.setText(String.valueOf(tickets.getCveEmpleado()));
        txtFcvePago.setText(String.valueOf(tickets.getCvePago()));
        txtFdate.setText(tickets.getFecha());
        txtFtotal.setText(String.valueOf(tickets.getTotal()));

        save.setOnAction(add);
        cancel.setOnAction(stop);
    }

    private Tickets tickets = new Tickets();
    public void setUpdate(Tickets tickets)
    {
        this.tickets = tickets;
    }


    //agregar ticket
    EventHandler<ActionEvent> add = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            Tickets t = new Tickets(Integer.parseInt(txtFnoTicket.getText()),
                    Integer.parseInt(txtFcveCli.getText()),
                    Integer.parseInt(txtFcveEmp.getText()),
                    Integer.parseInt(txtFcvePago.getText()),
                    txtFdate.getText(),
                    Double.parseDouble(txtFtotal.getText()));

            TicketsDAO data=new TicketsDAO(MySQL.getConnection());
            Alert alert;

            if (data.insert(t))
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Add Successful");
                alert.setContentText("Ticket registrado");
                Optional<ButtonType> response = alert.showAndWait();
                if (response.get() == ButtonType.OK)
                {
                    ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                }
            }
        }
    };

    //cancelar
    private EventHandler<ActionEvent> stop = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            ((Stage)(((JFXButton) event.getSource()).getScene().getWindow())).close();
        }
    };
}
