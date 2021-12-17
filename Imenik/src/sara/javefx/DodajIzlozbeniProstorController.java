package sara.javefx;

import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sara.klase.Izlozbeni_prostor;

public class DodajIzlozbeniProstorController {

	
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
	private TextField brand= new TextField();
	
	@FXML
	private Button save = new Button();
	
	
	Izlozbeni_prostor izProstor;
	
	@FXML
    void initialize() 
	 { 
		izProstor = new Izlozbeni_prostor("-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		
	 }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void spremi()
	{
		izProstor.setNaziv(ime.getText());
		izProstor.setKontaktOsoba(kontaktOsoba.getText());
		izProstor.setAdresa(adresa.getText());
		izProstor.setGrad(grad.getText());
		izProstor.setDrzava(drzava.getText());
		izProstor.setEmail(mail.getText().replace(" ", ""));
		izProstor.setTelefon(tel.getText());
		izProstor.setFax(fax.getText());
		izProstor.setWeb(web.getText());
		izProstor.setMobitel(mob.getText());
		izProstor.setBrandovi(brand.getText());
		
	    ImenikController.firma.dodajIzlProstor(izProstor);
	    ImenikController.dat2.UpisiUdatotekuIzlozbeniProstori(ImenikController.firma);
	    try 
	    {
			ImenikController.drop.upload("izlProstor");
		} 
	    catch (DbxException | IOException e) 
	    {
	    	Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
		}
	    
	    ImenikController.observableList.add(izProstor.toString());
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}


}
