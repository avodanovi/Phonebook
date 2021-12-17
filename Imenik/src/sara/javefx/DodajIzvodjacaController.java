package sara.javefx;

import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sara.klase.Izvodac;

public class DodajIzvodjacaController {

	
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
	
	
	Izvodac izvodjac;
	
	@FXML
    void initialize() 
	 { 
		izvodjac = new Izvodac("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		
	 }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void spremi()
	{
		izvodjac.setNaziv(ime.getText());
		izvodjac.setKontaktOsoba(kontaktOsoba.getText());
		izvodjac.setAdresa(adresa.getText());
		izvodjac.setGrad(grad.getText());
		izvodjac.setDrzava(drzava.getText());
		izvodjac.setEmail(mail.getText().replace(" ", ""));
		izvodjac.setTelefon(tel.getText());
		izvodjac.setFax(fax.getText());
		izvodjac.setWeb(web.getText());
		izvodjac.setMobitel(mob.getText());
		
	    ImenikController.firma.dodajIzvodjaca(izvodjac);
	    ImenikController.dat2.UpisiUdatotekuIzvodjaci(ImenikController.firma);
	    try 
	    {
			ImenikController.drop.upload("izvodjac");
		} 
	    catch (DbxException | IOException e)
	    {
	    	Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
		}
	    
	    ImenikController.observableList.add(izvodjac.toString());
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

	
}
