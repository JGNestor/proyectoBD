package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML JFXButton btnEmpleados,btnClientes,btnTickets,btnProductos,btnCompras,btnSalir;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnEmpleados.setOnAction(eventoBtn);
        btnClientes.setOnAction(eventoBtn);
        btnTickets.setOnAction(eventoBtn);
        btnProductos.setOnAction(eventoBtn);
        btnCompras.setOnAction(eventoBtn);
        btnSalir.setOnAction(salir);
    }

    private javafx.event.EventHandler<ActionEvent> eventoBtn = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(event.getSource().equals(btnEmpleados))
            {
                try
                {
                    Stage stage = new Stage();
                    stage.setTitle("Empleados");
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/VistaEmpleados.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    (((Button) event.getSource()).getScene().getWindow()).hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource().equals(btnClientes))
            {
                try
                {
                    Stage stage = new Stage();
                    stage.setTitle("Clientes");
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/VistaClientes.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    (((Button) event.getSource()).getScene().getWindow()).hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource().equals(btnTickets))
            {
                try
                {
                    Stage stage = new Stage();
                    stage.setTitle("Tickets");
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/VistaTickets.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    (((Button) event.getSource()).getScene().getWindow()).hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource().equals(btnProductos))
            {
                try
                {
                    Stage stage = new Stage();
                    stage.setTitle("Productos");
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/VistaProductos.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    (((Button) event.getSource()).getScene().getWindow()).hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (event.getSource().equals(btnCompras))
            {
                try
                {
                    Stage stage = new Stage();
                    stage.setTitle("Compras");
                    Parent root = null;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/VistaCompras.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                    (((Button) event.getSource()).getScene().getWindow()).hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private javafx.event.EventHandler<ActionEvent> salir = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            System.exit(0);
        }
    };
}