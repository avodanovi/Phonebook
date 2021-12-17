package sara.javefx;


import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sara.klase.Hotel;

public class DodajHotelController {
	
	
	
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
	
	
	Hotel hotel;
	
	@FXML
    void initialize() 
	 { 
		hotel = new Hotel("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		
	 }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void spremi() 
	{
		hotel.setNaziv(ime.getText());
		hotel.setKontaktOsoba(kontaktOsoba.getText());
		hotel.setAdresa(adresa.getText());
		hotel.setGrad(grad.getText());
		hotel.setDrzava(drzava.getText());
		hotel.setEmail(mail.getText().replace(" ", ""));
		hotel.setTelefon(tel.getText());
		hotel.setFax(fax.getText());
		hotel.setWeb(web.getText());
		hotel.setMob(mob.getText());
		
		//ImenikController.drop.download("hotel");
		//ImenikController.firma.dohvatiHotele().clear();
	    //ImenikController.dat2.UcitajHotele(ImenikController.firma);
	    ImenikController.firma.dodajHotel(hotel);
	    ImenikController.dat2.UpisiUdatotekuHotele(ImenikController.firma);
	    try 
	    {
			ImenikController.drop.upload("hotel");
		} catch (DbxException | IOException e) 
	    {	
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
		}
	    
	    ImenikController.observableList.add(hotel.toString());
	    
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

}
