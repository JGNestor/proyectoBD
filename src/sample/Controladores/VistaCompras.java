package sample.Controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Main;
import sample.Models.Compras;
import sample.Models.DAO.ComprasDAO;
import sample.Models.DAO.MySQL;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaCompras implements Initializable
{
    @FXML JFXButton btnCveP,btnCan,btnSalir,btnB;
    @FXML JFXTextField prod,can;
    @FXML TableView tablaCom;
    @FXML TableColumn noticket,cveprod,cant;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnCveP.setOnAction(consultaProd);
        btnCan.setOnAction(consultaCan);
        btnB.setOnAction(consultaBoth);
        btnSalir.setOnAction(atras);

        noticket.setCellValueFactory(new PropertyValueFactory<Compras, Integer>("noTicket"));
        cveprod.setCellValueFactory(new PropertyValueFactory<Compras, Integer>("cveProducto"));
        cant.setCellValueFactory(new PropertyValueFactory<Compras, Integer>("cantidad"));

        tablaCom.setItems(comprasDAO.findAll());
    }

    Compras compras = new Compras();
    ComprasDAO comprasDAO = new ComprasDAO(MySQL.getConnection());

    EventHandler<ActionEvent> consultaProd = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int r = Integer.parseInt(prod.getText());

            if(comprasDAO.fetchByProd(r) == null)
            {
                error();
            }
            else
            {
                System.out.println(comprasDAO.fetchByProd(r));
            }
        }
    };

    EventHandler<ActionEvent> consultaCan = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int s = Integer.parseInt(can.getText());

            if(comprasDAO.fetchByCan(s) == null)
            {
                error();
            }
            else
            {
                System.out.println(comprasDAO.fetchByCan(s));
            }
        }
    };

    EventHandler<ActionEvent> consultaBoth= new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int r = Integer.parseInt(prod.getText());
            int s = Integer.parseInt(can.getText());

            if(comprasDAO.fetchBoth(r,s) == null)
            {
                error();
            }
            else
            {
                System.out.println(comprasDAO.fetchBoth(r,s));
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

}
