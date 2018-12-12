package sample.Controladores;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Models.DAO.ProductosDAO;
import sample.Models.DAO.MySQL;
import sample.Models.Productos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VistaProductos implements Initializable
{
    @FXML JFXButton updateTable,edit,delete,exit,add;
    @FXML TableView tablaProds;
    @FXML TableColumn prod,nameProd,price,prov,tipo,promo;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        updateTable.setOnAction(updatedTable);
        edit.setOnAction(editar);
        delete.setOnAction(borrar);
        exit.setOnAction(stop);
        add.setOnAction(agregar);

        prod.setCellValueFactory(new PropertyValueFactory<Productos, Integer>("cveProducto"));
        tipo.setCellValueFactory(new PropertyValueFactory<Productos, Integer>("cveTipo"));
        promo.setCellValueFactory(new PropertyValueFactory<Productos, Integer>("cvePromo"));
        prov.setCellValueFactory(new PropertyValueFactory<Productos, Integer>("cveProveedor"));
        price.setCellValueFactory(new PropertyValueFactory<Productos, Double>("precio"));
        nameProd.setCellValueFactory(new PropertyValueFactory<Productos, String>("nombreProd"));

        tablaProds.setItems(productosDAO.findAll());
    }

    Productos selection;
    Productos productos = new Productos();
    ProductosDAO productosDAO = new ProductosDAO(MySQL.getConnection());


    //boton consulta
    private EventHandler<ActionEvent> editar = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int idProd;
            Alert alert;
            selection = (Productos) tablaProds.getSelectionModel().getSelectedItem();

            if(selection != null)
            {
                idProd = selection.getCveProducto();
                productos = productosDAO.fetch(idProd);
                showUpdate();
            }
            else
            {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("No hay producto seleccionado");
                alert.show();
            }
        }
    };

    //actualizar tabla
    public EventHandler<ActionEvent> updatedTable = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            tablaProds.setItems(productosDAO.findAll());
        }
    };

    //boton borrar
    private EventHandler<ActionEvent> borrar = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            int idProd;
            Alert alert;
            selection = (Productos) tablaProds.getSelectionModel().getSelectedItem();

            if(selection != null)
            {
                idProd = selection.getCveProducto();


                if(productosDAO.deleteProductos(idProd))
                {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete Successful");
                    alert.setContentText("Producto eliminado correctamente.\nClick en 'Update Table' para ver los cambios.");
                    alert.show();
                }
            }
            else
            {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("No hay producto seleccionado");
                alert.show();
            }
        }
    };

    //boton salir
    private EventHandler<ActionEvent> stop = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            System.exit(0);
        }
    };

    private EventHandler<ActionEvent> agregar = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            showAdd();
        }
    };



    public void showUpdate()
    {
        try
        {
            Stage updateStage = new Stage();
            updateStage.setTitle("Update Productos");
            Parent root= null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/updateProductFormat.fxml"));
            updateProductController uptCont = new updateProductController();
            uptCont.setUpdate(productos);
            loader.setController(uptCont);
            root = loader.load();
            Scene scene = new Scene(root);
            updateStage.setScene(scene);
            updateStage.setResizable(false);
            updateStage.show();
        }
        catch (IOException e )
        { e.printStackTrace(); }
    }

    public void showAdd()
    {
        try
        {
            Stage updateStage = new Stage();
            updateStage.setTitle("Agregar Productos");
            Parent root= null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Vistas/addProductFormat.fxml"));
            addProductController addCont = new addProductController();
            addCont.setUpdate(productos);
            loader.setController(addCont);
            root = loader.load();
            Scene scene = new Scene(root);
            updateStage.setScene(scene);
            updateStage.setResizable(false);
            updateStage.show();
        }
        catch (IOException e )
        { e.printStackTrace(); }
    }
}

// fx:controller="sample.Vistas.UpdateProductFormat"