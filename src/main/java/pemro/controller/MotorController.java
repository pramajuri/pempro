package pemro.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class MotorController implements Initializable {

    DBConn dbConn = new DBConn();

    @FXML
    private TableColumn<MotorModel, Integer> hargaKolum;

    @FXML
    private TableColumn<MotorModel, Integer> idKolom;

    @FXML
    private TableColumn<MotorModel, String> jenisKolom;

    @FXML
    private TableColumn<MotorModel, String> merkKolum;

    @FXML
    private TableColumn<MotorModel, String> nopolKolum;

    @FXML
    private TableView<MotorModel> tblMotor;

    @FXML
    private TextField textHarga;

    @FXML
    private TextField textID;

    @FXML
    private TextField textJenis;

    @FXML
    private TextField textMerk;

    @FXML
    private TextField textNopol;

    @FXML
    private void hapusAction(ActionEvent event) {
        String query = "DELETE FROM motor WHERE ID="+textID.getText()+"";
        executeQuery(query);
        showMotor();
    }

    @FXML
    void keluarAction(ActionEvent event) {

    }

    @FXML
    private void simpanAction() {
        String query = "insert into motor values("+textMerk.getText()+"','"+textJenis.getText()+"',"+textNopol.getText()+","+textHarga.getText()+")";
    	executeQuery(query);
        showMotor();
    }


    @FXML
    private void ubahAction(ActionEvent event) {
        String query = "UPDATE motor SET Merk='"+textMerk.getText()+"',Jenis="+textJenis.getText()+",Nopol="+textNopol.getText()+",Harga="+textHarga.getText()+" WHERE ID="+textID.getText()+"";
        executeQuery(query);
        showMotor();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMotor();
    }

    public void executeQuery(String query) {
        Connection connection = dbConn.getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<MotorModel> getMotorList(){
    	ObservableList<MotorModel> motorList = FXCollections.observableArrayList();
    	Connection connection = dbConn.getConnection();
    	String query = "SELECT * FROM motor";
    	Statement st;
    	ResultSet rs;

    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			MotorModel motorModel;
			while(rs.next()) {
				motorModel = new MotorModel(rs.getInt("Id_motor"), rs.getString("Merk"), rs.getString("Jenis"), rs.getString("Nopol"), rs.getInt("Harga"));
				motorList.add(motorModel);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return motorList;
    }

    public void showMotor() {
    	ObservableList<MotorModel> list = getMotorList();

    	idKolom.setCellValueFactory(new PropertyValueFactory<MotorModel,Integer>("id_motor"));
    	merkKolum.setCellValueFactory(new PropertyValueFactory<MotorModel,String>("merk"));
    	jenisKolom.setCellValueFactory(new PropertyValueFactory<MotorModel,String>("jenis"));
    	nopolKolum.setCellValueFactory(new PropertyValueFactory<MotorModel,String>("nopol"));
    	hargaKolum.setCellValueFactory(new PropertyValueFactory<MotorModel,Integer>("harga"));

    	tblMotor.setItems(list);
    }

}
