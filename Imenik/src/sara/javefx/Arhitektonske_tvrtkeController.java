package sara.javefx;

import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sara.klase.Arhitektonske_tvrtka;

public class Arhitektonske_tvrtkeController {

	
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
	
	
	Arhitektonske_tvrtka tvrtke;
	
	@FXML
    void initialize() 
	 { 
		tvrtke = new Arhitektonske_tvrtka("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		
	 }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void spremi()
	{
		tvrtke.setNaziv(ime.getText());
		tvrtke.setKontaktOsoba(kontaktOsoba.getText());
		tvrtke.setAdresa(adresa.getText());
		tvrtke.setGrad(grad.getText());
		tvrtke.setDrzava(drzava.getText());
		tvrtke.setEmail(mail.getText().replace(" ", ""));
		tvrtke.setTelefon(tel.getText());
		tvrtke.setFax(fax.getText());
		tvrtke.setWeb(web.getText());
		tvrtke.setMobitel(mob.getText());
		
	    ImenikController.firma.dodajArhTvrtku(tvrtke);
	    ImenikController.dat2.UpisiUdatotekuArhitekti(ImenikController.firma);
	    try 
	    {
			ImenikController.drop.upload("arhitekt");
		} 
	    catch (DbxException | IOException e)
	    {
	    	Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
		}
	    
	    ImenikController.observableList.add(tvrtke.toString());
	    
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

}
