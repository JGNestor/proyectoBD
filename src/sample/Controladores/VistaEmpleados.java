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
import sample.Models.DAO.EmpleadosDAO;
import sample.Models.Empleados;
import sample.Models.DAO.MySQL;

import java.net.URL;
import java.util.ResourceBundle;

public class VistaEmpleados implements Initializable
{
    @FXML JFXButton btnEmpR,btnEmpS,btnSalir,btnB;
    @FXML JFXTextField rol,suc;
    @FXML TableView tablaEmp;
    @FXML TableColumn cveEmpleado,nombreEmpleado,cveRol,cveSucursal;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        btnEmpR.setOnAction(consultaRol);
        btnEmpS.setOnAction(consultaSucursal);
        btnB.setOnAction(consultaBoth);
        btnSalir.setOnAction(atras);

        cveEmpleado.setCellValueFactory(new PropertyValueFactory<Empleados, Integer>("cveEmpleado"));
        nombreEmpleado.setCellValueFactory(new PropertyValueFactory<Empleados, String>("nombreEmpleado"));
        cveRol.setCellValueFactory(new PropertyValueFactory<Empleados, Integer>("cveRol"));
        cveSucursal.setCellValueFactory(new PropertyValueFactory<Empleados, Integer>("cveSucursal"));

        tablaEmp.setItems(empleadosDAO.findAll());
    }

    Empleados empleados = new Empleados();
    EmpleadosDAO empleadosDAO = new EmpleadosDAO(MySQL.getConnection());

    EventHandler<ActionEvent> consultaRol = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int r = Integer.parseInt(rol.getText());


            if(empleadosDAO.fetchByRol(r) == null)
            {
                error();
            }
            else
            {
                System.out.println(empleadosDAO.fetchByRol(r));
            }
        }
    };

    EventHandler<ActionEvent> consultaSucursal = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int s = Integer.parseInt(suc.getText());

            if(empleadosDAO.fetchBySuc(s) == null)
            {
                error();
            }
            else
            {
                System.out.println(empleadosDAO.fetchBySuc(s));
            }
        }
    };

    EventHandler<ActionEvent> consultaBoth= new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int r = Integer.parseInt(rol.getText());
            int s = Integer.parseInt(suc.getText());

            if(empleadosDAO.fetchBoth(r,s) == null)
            {
                error();
            }
            else
            {
                System.out.println(empleadosDAO.fetchBoth(r,s));
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
