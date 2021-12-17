package sara.javefx;

import java.io.IOException;

import com.dropbox.core.DbxException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class IzmjenaController {
	
	
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
	
	
	
	@FXML
    void initialize() 
	 { 
		if(ImenikController.hotel == true)
		 {
	
			ime.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getNaziv());
			kontaktOsoba.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getKontaktOsoba());
			adresa.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getAdresa());
			grad.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getGrad());
			drzava.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getDrzava());
			mail.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getEmail());
			tel.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getTelefon());
			fax.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getFax());
			web.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getWeb());
			mob.setText(ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).getMob());
			brand.setDisable(true);
			
		 }
		 
		 if(ImenikController.arhTvrtke == true)
		 {
			 ime.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getNaziv());
			 kontaktOsoba.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getKontaktOsoba());
			 adresa.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getAdresa());
			 grad.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getGrad());
			 drzava.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getDrzava());
			 mail.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getEmail());
			 tel.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getTelefon());
			 fax.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getFax());
			 web.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getWeb());
			 mob.setText(ImenikController.firma.dohvatiArhTvrtke().
					 get(ImenikController.adresa).getMobitel());
			 brand.setDisable(true);
		 }
	        
		 if(ImenikController.izlozProstori == true)
		 {
			 ime.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getNaziv());
			 kontaktOsoba.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getKontaktOsoba());
			 adresa.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getAdresa());
			 grad.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getGrad());
			 drzava.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getDrzava());
			 mail.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getEmail());
			 tel.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getTelefon());
			 fax.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getFax());
			 web.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getWeb());
			 mob.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getMobitel());
			 brand.setText(ImenikController.firma.dohvatiIzlProstori().
					 get(ImenikController.adresa).getBrandovi());
		 }  
	        
	        
		 if(ImenikController.distributeri == true)
		 {
			 ime.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getNaziv());
			 kontaktOsoba.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getKontaktOsoba());
			 adresa.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getAdresa());
			 grad.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getGrad());
			 drzava.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getDrzava());
			 mail.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getEmail());
			 tel.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getTelefon());
			 fax.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getFax());
			 web.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getWeb());
			 mob.setText(ImenikController.firma.dohvatiDistributere().
					 get(ImenikController.adresa).getMobitel());
			 brand.setDisable(true);
		 }
	        
	        
		 if(ImenikController.izvodjaci == true)
		 {
			 ime.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getNaziv());
			 kontaktOsoba.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getKontaktOsoba());
			 adresa.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getAdresa());
			 grad.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getGrad());
			 drzava.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getDrzava());
			 mail.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getEmail());
			 tel.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getTelefon());
			 fax.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getFax());
			 web.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getWeb());
			 mob.setText(ImenikController.firma.dohvatiIzvodjaci().
					 get(ImenikController.adresa).getMobitel());
			 brand.setDisable(true);
		 }

		
	 }
	
	public void izbjena()
	{
		
		
		 if(ImenikController.hotel == true)
		 {
			
			 if(ImenikController.osvHotele == false)
				{
				 
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setNaziv(ime.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setKontaktOsoba(kontaktOsoba.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setAdresa(adresa.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setGrad(grad.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setDrzava(drzava.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setEmail(mail.getText().replace(" ", ""));
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setTelefon(tel.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setFax(fax.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setWeb(web.getText());
				 ImenikController.firma.dohvatiHotele().
					get(ImenikController.adresa).setMob(mob.getText());
				 
				 ImenikController.dat2.UpisiUdatotekuHotele(ImenikController.firma);
				 try 
				 {
					ImenikController.drop.upload("hotel");
				 } 
				 catch (DbxException | IOException e) 
				 {
					 Alert alert= new Alert(AlertType.ERROR);
					 alert.setTitle("Error");
					 alert.setHeaderText("Could not connect to the database");
					 alert.setContentText("Make sure your network connection is active and try again");
					 alert.showAndWait();
				 }
				 
				}
			 else
			 {
				 Alert alert= new Alert(AlertType.ERROR);
				 alert.setTitle("Refresh");
				 alert.setHeaderText("There was a change");
				 alert.setContentText("Refresh the screen");
				 alert.showAndWait();
			 }
			 
		 }
		 
		 if(ImenikController.arhTvrtke == true)
		 {
			 
			 if(ImenikController.osvArhTvrtke == false)
			 {
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setNaziv(ime.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setKontaktOsoba(kontaktOsoba.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setAdresa(adresa.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setGrad(grad.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setDrzava(drzava.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setEmail(mail.getText().replace(" ", ""));
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setTelefon(tel.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setFax(fax.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setWeb(web.getText());
				 ImenikController.firma.dohvatiArhTvrtke().
					get(ImenikController.adresa).setMobitel(mob.getText());
				 
				 ImenikController.dat2.UpisiUdatotekuArhitekti(ImenikController.firma);
				 try 
				 {
					ImenikController.drop.upload("arhitekt");
			   	 } 
				 
				 catch (DbxException | IOException e)
				 {
					 Alert alert= new Alert(AlertType.ERROR);
					 alert.setTitle("Pogreška");
					 alert.setHeaderText("Došlo je do greške");
					 alert.setContentText(".........");
					 alert.showAndWait();
				 }    
			 }
			 
			 else
			 {
				 Alert alert= new Alert(AlertType.ERROR);
				 alert.setTitle("Osvježi");
				 alert.setHeaderText("Došlo je do promjene");
				 alert.setContentText("Osvježi ekran");
				 alert.showAndWait();
			 }
			
			 
			 
		 }
	        
		 if(ImenikController.izlozProstori == true)
		 {
			 
			 if(ImenikController.osvIzlozbene == false)
			 {
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setNaziv(ime.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setKontaktOsoba(kontaktOsoba.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setAdresa(adresa.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setGrad(grad.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setDrzava(drzava.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setEmail(mail.getText().replace(" ", ""));
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setTelefon(tel.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setFax(fax.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setWeb(web.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setMobitel(mob.getText());
				 ImenikController.firma.dohvatiIzlProstori().
					get(ImenikController.adresa).setBrandovi(brand.getText());
				 
				 ImenikController.dat2.UpisiUdatotekuIzlozbeniProstori(ImenikController.firma);
			    try 
			    {
					ImenikController.drop.upload("izlProstor");
				} 
			    catch (DbxException | IOException e) 
			    {
			    	Alert alert= new Alert(AlertType.ERROR);
					alert.setTitle("Pogreška");
					alert.setHeaderText("Došlo je do greške");
					alert.setContentText(".........");
					alert.showAndWait();
				}
			 }
			 
			 else
			 {
				 Alert alert= new Alert(AlertType.ERROR);
				 alert.setTitle("Osvježi");
				 alert.setHeaderText("Došlo je do promjene");
				 alert.setContentText("Osvježi ekran");
				 alert.showAndWait();
			 }
			 
			
			 
		 }  
	        
	        
		 if(ImenikController.distributeri == true)
		 {
			 if(ImenikController.osvDistributere == false)
			 {
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setNaziv(ime.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setKontaktOsoba(kontaktOsoba.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setAdresa(adresa.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setGrad(grad.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setDrzava(drzava.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setEmail(mail.getText().replace(" ", ""));
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setTelefon(tel.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setFax(fax.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setWeb(web.getText());
				 ImenikController.firma.dohvatiDistributere().
					get(ImenikController.adresa).setMobitel(mob.getText());
				 
				 ImenikController.dat2.UpisiUdatotekuDistributeri(ImenikController.firma);
		        try 
		        {
					ImenikController.drop.upload("distributer");
				} 
		        catch (DbxException | IOException e) 
		        {
					Alert alert= new Alert(AlertType.ERROR);
					alert.setTitle("Pogreška");
					alert.setHeaderText("Došlo je do greške");
					alert.setContentText(".........");
					alert.showAndWait();
				}
			 }
			 
			 else
			 {
				 Alert alert= new Alert(AlertType.ERROR);
				 alert.setTitle("Osvježi");
				 alert.setHeaderText("Došlo je do promjene");
				 alert.setContentText("Osvježi ekran");
				 alert.showAndWait();
			 }
			 
			 
		 }
	        
	        
		 if(ImenikController.izvodjaci == true)
		 {
			 if(ImenikController.osvIzvodjace == false)
			 {
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setNaziv(ime.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setKontaktOsoba(kontaktOsoba.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setAdresa(adresa.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setGrad(grad.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setDrzava(drzava.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setEmail(mail.getText().replace(" ", ""));
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setTelefon(tel.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setFax(fax.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setWeb(web.getText());
				 ImenikController.firma.dohvatiIzvodjaci().
					get(ImenikController.adresa).setMobitel(mob.getText());
				 
				 ImenikController.dat2.UpisiUdatotekuIzvodjaci(ImenikController.firma);
			    try 
			    {
					ImenikController.drop.upload("izvodjac");
				}
			    
			    catch (DbxException | IOException e)
			    {
			    	Alert alert= new Alert(AlertType.ERROR);
					alert.setTitle("Pogreška");
					alert.setHeaderText("Došlo je do greške");
					alert.setContentText(".........");
					alert.showAndWait();
				}
			 }
			 
			 else
			 {
				 Alert alert= new Alert(AlertType.ERROR);
				 alert.setTitle("Osvježi");
				 alert.setHeaderText("Došlo je do promjene");
				 alert.setContentText("Osvježi ekran");
				 alert.showAndWait();
			 }
		 }
		
		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

}
