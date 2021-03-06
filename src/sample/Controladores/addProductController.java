package sample.Controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sample.Models.DAO.ProductosDAO;
import sample.Models.DAO.MySQL;
import sample.Models.Productos;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class addProductController implements Initializable
{
    @FXML JFXButton save, cancel;
    @FXML JFXTextField txtFcve, prod, txtFprecio, txtFtipo, txtFpromo, txtFprov;

    sample.Models.DAO.ProductosDAO ProductosDAO = new ProductosDAO(MySQL.getConnection());

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        txtFcve.setText(String.valueOf(productos.getCveProducto()));
        prod.setText(productos.getNombreProd());
        txtFprecio.setText(String.valueOf(productos.getPrecio()));
        txtFtipo.setText(String.valueOf(productos.getCveTipo()));
        txtFpromo.setText(String.valueOf(productos.getCvePromo()));
        txtFprov.setText(String.valueOf(productos.getCveProveedor()));

        save.setOnAction(add);
        cancel.setOnAction(stop);
    }

    private Productos productos = new Productos();
    public void setUpdate(Productos productos)
    {
        this.productos = productos;
    }


    //agregar producto
    EventHandler<ActionEvent> add = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            Productos pro = new Productos(Integer.parseInt(txtFcve.getText()),
                                        Integer.parseInt(txtFtipo.getText()),
                                        Integer.parseInt(txtFpromo.getText()),
                                        Integer.parseInt(txtFprov.getText()),
                                        Double.parseDouble(txtFprecio.getText()),
                                        prod.getText());
            Alert alert;

            if (ProductosDAO.addProductos(pro))
            {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Add Successful");
                alert.setContentText("Producto agregado correctamente.\nClick en 'Update Table' para ver los cambios.");
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
