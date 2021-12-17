package sara.javefx;

import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sara.klase.Distributer;

public class DodajDistributeraController {
	
	@FXML
	private TextField ime= new TextField();
	@FXML
	private TextField kontaktOsoba= new TextField();
	@FXML
	private TextField adresa= new TextField();
	@FXML
	private TextField grad= new TextField();
	@FXML
	private TextField drzava= new TextField();
	@FXML
	private TextField mail= new TextField();
	@FXML
	private TextField tel= new TextField();
	@FXML
	private TextField fax= new TextField();
	@FXML
	private TextField web= new TextField();
	@FXML
	private TextField mob= new TextField();
	
	@FXML
	private Button save = new Button();
	
	
	Distributer distributer;
	
	@FXML
    void initialize() 
	 { 
		distributer = new Distributer("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		
	 }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void spremi()
	{
		distributer.setNaziv(ime.getText());
		distributer.setKontaktOsoba(kontaktOsoba.getText());
		distributer.setAdresa(adresa.getText());
		distributer.setGrad(grad.getText());
		distributer.setDrzava(drzava.getText());
		distributer.setEmail(mail.getText().replace(" ", ""));
		distributer.setTelefon(tel.getText());
		distributer.setFax(fax.getText());
		distributer.setWeb(web.getText());
		distributer.setMobitel(mob.getText());
		
        ImenikController.firma.dodajDistributera(distributer);
        ImenikController.dat2.UpisiUdatotekuDistributeri(ImenikController.firma);
        try 
        {
			ImenikController.drop.upload("distributer");
		} catch (DbxException | IOException e) 
        {
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
		}
        
        ImenikController.observableList.add(distributer.toString());
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}


}
