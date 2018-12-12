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
import sample.Models.Clientes;
import sample.Models.DAO.ClientesDAO;
import sample.Models.DAO.MySQL;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaClientes implements Initializable
{
    @FXML JFXButton btnCliG,btnCliC,btnB,btnSalir;
    @FXML JFXTextField gen,ciu;
    @FXML TableView tablaCli;
    @FXML TableColumn cveCliente,nombre,genero,cveCiudad;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnCliG.setOnAction(consultaGenero);
        btnCliC.setOnAction(consultaCiudad);
        btnB.setOnAction(consultaBoth);
        btnSalir.setOnAction(atras);

        cveCliente.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("cveClientes"));
        nombre.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
        genero.setCellValueFactory(new PropertyValueFactory<Clientes, String>("genero"));
        cveCiudad.setCellValueFactory(new PropertyValueFactory<Clientes, String>("cveCiudad"));

        tablaCli.setItems(clientesDAO.findAll());
    }

    Clientes clientes = new Clientes();
    ClientesDAO clientesDAO = new ClientesDAO(MySQL.getConnection());

    EventHandler<ActionEvent> consultaGenero = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            String genero = gen.getText();

            if(clientesDAO.fetchGen(genero) == null)
            {
                error();
            }
            else
            {
                System.out.println(clientesDAO.fetchGen(genero));
            }
        }
    };

    EventHandler<ActionEvent> consultaCiudad= new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int ciudad = Integer.parseInt(ciu.getText());

            if(clientesDAO.fetchCity(ciudad) == null)
            {
                error();
            }
            else
            {
                System.out.println(clientesDAO.fetchCity(ciudad));
            }
        }
    };

    EventHandler<ActionEvent> consultaBoth= new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int ciudad = Integer.parseInt(ciu.getText());
            String genero = gen.getText();

            if(clientesDAO.fetchBoth(ciudad,genero) == null)
            {
                error();
            }
            else
            {
                System.out.println(clientesDAO.fetchBoth(ciudad,genero));
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
