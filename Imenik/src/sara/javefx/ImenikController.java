package sara.javefx;


import sara.klase.Arhitektonske_tvrtka;
import sara.klase.Distributer;
import sara.klase.Hotel;
import sara.klase.Izlozbeni_prostor;
import sara.klase.Izvodac;
import sara.metode.Firma;
import sara.metode.Sort;
import sara.nit.Nit2;
import sara.datoteke.BackUpSerijalizacija;
import sara.datoteke.DropBox;
import sara.datoteke.SerijalizacijaDatoteke;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dropbox.core.DbxException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ImenikController {
	
	
	@SuppressWarnings("rawtypes")
	public static  ObservableList observableList = FXCollections.observableArrayList();
	public static Firma firma;
	
	public static int adresa = 0;
	
	public static boolean hotel,arhTvrtke,izlozProstori,distributeri,izvodjaci;
	public static boolean osvHotele,osvArhTvrtke,osvIzlozbene,osvDistributere,osvIzvodjace;
	public static Date verzijaHotel, verzijaArhTvrtka, verzijaIzlProstor, verzijaDistributeri,verzijaIzvodjaci;
	public static DropBox drop;
	
	public static SerijalizacijaDatoteke dat2 = new SerijalizacijaDatoteke();
	public static BackUpSerijalizacija backUpdat= new BackUpSerijalizacija();
	
	
	private Nit2 n2;
	
	@FXML
    private ListView<String> Prikaz;
	
	@FXML
	private Menu Hotel;
	@FXML
	private Menu Tvrtke;
	@FXML
	private Menu IzlozbeniP;
	@FXML
	private Menu Distributori;
	@FXML
	private Menu Izvodjaci;
	
	
	@FXML
	private MenuItem prikaziHotel;
	@FXML
	private MenuItem prikaziTvrtke;
	@FXML
	private MenuItem prikaziIzlozbeniP;
	@FXML
	private MenuItem prikaziDistributore;
	@FXML
	private MenuItem prikaziIzvodjace;
	
	
	@FXML
	private MenuItem noviHotel;
	@FXML
	private MenuItem novaTvrtka;
	@FXML
	private MenuItem noziIzProstor;
	@FXML
	private MenuItem noviDistributor;
	@FXML
	private MenuItem noviIzvodjac;
	
	@FXML
	private MenuItem sendEmail;
	@FXML
	private MenuItem izmjeni;
	@FXML
	private Button offline = new Button(); 
	
	
	@FXML
	private TextField pretraga = new TextField();
	
	@FXML
    private ChoiceBox<String> cb= new ChoiceBox<String>();
	
	
	
	@FXML
    void initialize()
	 {  
		
		firma = new Firma(null, null, null, null);
		drop = new DropBox();
		
		try 
		{
			drop.Povezi();
			drop.download("test");
			drop.download("hotel");
	        drop.download("distributer");
	        drop.download("izvodjac");
	        drop.download("arhitekt");
	        drop.download("izlProstor");
	        
	        dat2.UcitajHotele(firma);
			//dat.procitajTablicuArhTvrtke(firma);
			dat2.UcitajArhitekte(firma);
			//dat.procitajTablicuIzloProstor(firma);
			dat2.UcitajIzlozbeniProstore(firma);
			//dat.procitajTablicuIzvodjaci(firma);
			dat2.UcitajIzvodjace(firma);
			//dat.procitajTablicuDistributeri(firma);
			dat2.UcitajDistributere(firma);
			
			offline.setText("online");
			offline.setDisable(true);
		} 
		catch (DbxException | IOException | ClassNotFoundException e) 
		{
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not connect to the database");
			alert.setContentText("Make sure your network connection is active and try again");
			alert.showAndWait();
			offline.setText("offline");
			offline.setDisable(false);
		}
		
		
		
		cb.setItems(FXCollections.observableArrayList("All", "Company name", "Contact person",
				"Address","City","Country",
                "E-mail","Phone","Fax","Web","Mobile phone"));
        cb.getSelectionModel().selectFirst();
		
		hotel = false;
		arhTvrtke = false;
		izlozProstori = false;
		distributeri = false;
		izvodjaci = false;
		
		osvArhTvrtke = false;
		osvDistributere = false;
		osvHotele = false;
		osvIzlozbene = false;
		osvIzvodjace = false;
		
		Prikaz.setStyle("-fx-font-size: 9pt");
		
		n2 = new Nit2("provjera", false);
		n2.start();
		
		if(offline.getText().equals("online"))
		{
			backUpdat.dohvatiDatum();
			napraviBackUp();
		}
		
	 }
	
	
	
	@SuppressWarnings("unchecked")
	@FXML
	public void UcitajHotele() throws ClassNotFoundException, IOException
	{
		osvHotele = false;
		hotel = true;
		arhTvrtke = false;
		izlozProstori = false;
		distributeri = false;
		izvodjaci = false;
		
		Hotel.setStyle("-fx-background-color: rgb(225, 228, 203)");
		Tvrtke.setStyle(null);
		IzlozbeniP.setStyle(null);
		Distributori.setStyle(null);
		Izvodjaci.setStyle(null);
			
		Sort.sortirajHotele(firma.dohvatiHotele());
			
		observableList.clear();
		Prikaz.getItems().clear();
		for(int i=0; i<firma.dohvatiHotele().size(); i++)
		{
			observableList.add(firma.dohvatiHotele().get(i).toString());
		}
		
		Prikaz.setItems(observableList);
		
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	public void UcitajArhitekte()
	{
		osvArhTvrtke = false;
		hotel = false;
		arhTvrtke = true;
		izlozProstori = false;
		distributeri = false;
		izvodjaci = false;
		
		Hotel.setStyle(null);
		Tvrtke.setStyle("-fx-background-color: rgb(225, 228, 203)");
		IzlozbeniP.setStyle(null);
		Distributori.setStyle(null);
		Izvodjaci.setStyle(null);
		
		Sort.sortirajArhTvrtke(firma.dohvatiArhTvrtke());
		
		observableList.clear();
		Prikaz.getItems().clear();
		for(int i=0; i<firma.dohvatiArhTvrtke().size(); i++)
		{
			observableList.add(firma.dohvatiArhTvrtke().get(i).toString());
		}
		
		Prikaz.setItems(observableList);
	}
	
	@SuppressWarnings("unchecked")
	@FXML
    public void UcitajDistributere()
    {
		osvDistributere = false;
        hotel=false;
        arhTvrtke=false;
        izlozProstori=false;
        distributeri=true;
        izvodjaci=false;
        
        Hotel.setStyle(null);
		Tvrtke.setStyle(null);
		IzlozbeniP.setStyle(null);
		Distributori.setStyle("-fx-background-color: rgb(225, 228, 203)");
		Izvodjaci.setStyle(null);
        
        Sort.sortirajDistributere(firma.dohvatiDistributere());
        
        observableList.clear();
        Prikaz.getItems().clear();
        for(int i=0; i<firma.dohvatiDistributere().size(); i++)
        {
            observableList.add(firma.dohvatiDistributere().get(i).toString());
        }
        
        Prikaz.setItems(observableList);
    }
	
    @SuppressWarnings("unchecked")
	@FXML
    public void UcitajIzlozbeneProstore()
    {
    	osvIzlozbene = false;
        hotel=false;
        arhTvrtke=false;
        izlozProstori=true;
        distributeri=false;
        izvodjaci=false;
        
        Hotel.setStyle(null);
		Tvrtke.setStyle(null);
		IzlozbeniP.setStyle("-fx-background-color: rgb(225, 228, 203)");
		Distributori.setStyle(null);
		Izvodjaci.setStyle(null);
        
        Sort.sortirajIzlozbeneProstore(firma.dohvatiIzlProstori());
        
        observableList.clear();
        Prikaz.getItems().clear();
        for(int i=0; i<firma.dohvatiIzlProstori().size(); i++)
        {
            observableList.add(firma.dohvatiIzlProstori().get(i).toString());
        }
       
        Prikaz.setItems(observableList);
    }
    
    @SuppressWarnings("unchecked")
	public void UcitajIzvodjace()
    {
    	osvIzvodjace = false;
        hotel = false;
        arhTvrtke = false;
        izlozProstori = false;
        distributeri = false;
        izvodjaci = true;
        
        Hotel.setStyle(null);
		Tvrtke.setStyle(null);
		IzlozbeniP.setStyle(null);
		Distributori.setStyle(null);
		Izvodjaci.setStyle("-fx-background-color: rgb(225, 228, 203)");
        
        Sort.sortirajIzvodace(firma.dohvatiIzvodjaci());
        
        observableList.clear();
        Prikaz.getItems().clear();
        for(int i=0; i<firma.dohvatiIzvodjaci().size(); i++)
        {
            observableList.add(firma.dohvatiIzvodjaci().get(i).toString());
        }
        
        Prikaz.setItems(observableList);
    }
	
	@SuppressWarnings("unchecked")
	@FXML
	public void Pretrazi()
	{
		List<Hotel> proHoteli = new ArrayList<>();
		List<Arhitektonske_tvrtka> arTvrtke = new ArrayList<>();
		List<Distributer> distri = new ArrayList<>();
		List<Izlozbeni_prostor> IzPros = new ArrayList<>();
		List<Izvodac> izvodjacii = new ArrayList<>();
		
		observableList.clear();
		Prikaz.getItems().clear();
		
		if(hotel == true)
		{
			osvHotele = false;
			proHoteli.addAll(firma.dohvatiHotel(pretraga.getText(),cb.getValue().toString()));
			
			for(int i=0; i<proHoteli.size(); i++)
			{
				observableList.add(proHoteli.get(i).toString());
			}
			
			Prikaz.setItems(observableList);
		}
		
		if(arhTvrtke == true)
		{
			osvArhTvrtke = false;
			arTvrtke.addAll(firma.dohvatiArhTvrtku(pretraga.getText(),cb.getValue().toString()));
			
			for(int i=0; i<arTvrtke.size(); i++)
			{
				observableList.add(arTvrtke.get(i).toString());
			}
			
			Prikaz.setItems(observableList);
		}
		
		if(izlozProstori == true)
		{
			osvIzlozbene = false;
			IzPros.addAll(firma.dohvatiIzlozbeni_Prostor(pretraga.getText(),cb.getValue().toString()));
			
			for(int i=0; i<IzPros.size(); i++)
			{
				observableList.add(IzPros.get(i).toString());
			}
			
			Prikaz.setItems(observableList);
		}
		
		if(distributeri == true)
		{
			osvDistributere = false;
			distri.addAll(firma.dohvatiDistributera(pretraga.getText(),cb.getValue().toString()));
			
			for(int i=0; i<distri.size(); i++)
			{
				observableList.add(distri.get(i).toString());
			}
			
			Prikaz.setItems(observableList);
		}
		
		if(izvodjaci == true)
		{
			osvIzvodjace = false;
			izvodjacii.addAll(firma.dohvatiIzvodjaca(pretraga.getText(),cb.getValue().toString()));
			
			for(int i=0; i<izvodjacii.size(); i++)
			{
				observableList.add(izvodjacii.get(i).toString());
			}
			
			Prikaz.setItems(observableList);
		}
		
	}
	
	@FXML
	public void Refrash()
	{
		Pretrazi();
	}
	
	@FXML
	public void posaljiEmail()
	{
		String focus;
		focus = Prikaz.getSelectionModel().getSelectedItem();
				
		String adresa=" ";
		
		if(hotel == true)
		{
			for(int i=0; i<firma.dohvatiHotele().size(); i++)
			{
				if(firma.dohvatiHotele().get(i).toString().equals(focus))
				{
					if(!firma.dohvatiHotele().get(i).getEmail().equals(null))
					{
						adresa = firma.dohvatiHotele().get(i).getEmail();
						break;
					}}}
		}
		
		
		if(arhTvrtke == true)
		{
			for(int i=0; i<firma.dohvatiArhTvrtke().size(); i++)
			{
				if(firma.dohvatiArhTvrtke().get(i).toString().equals(focus))
				{
					if(!firma.dohvatiArhTvrtke().get(i).getEmail().equals(null))
					{
						adresa = firma.dohvatiArhTvrtke().get(i).getEmail();
						break;
					}}}
		}
		
		if(izlozProstori == true)
		{
			for(int i=0; i<firma.dohvatiIzlProstori().size(); i++)
			{
				if(firma.dohvatiIzlProstori().get(i).toString().equals(focus))
				{
					if(!firma.dohvatiIzlProstori().get(i).getEmail().equals(null))
					{
						adresa = firma.dohvatiIzlProstori().get(i).getEmail();
						break;
					}}}
		}
		
		if(distributeri == true)
		{
			for(int i=0; i<firma.dohvatiDistributere().size(); i++)
			{
				if(firma.dohvatiDistributere().get(i).toString().equals(focus))
				{
					if(!firma.dohvatiDistributere().get(i).getEmail().equals(null))
					{
						adresa = firma.dohvatiDistributere().get(i).getEmail();
						break;
					}}}
		}
		
		if(izvodjaci == true)
		{
			for(int i=0; i<firma.dohvatiIzvodjaci().size(); i++)
			{
				if(firma.dohvatiIzvodjaci().get(i).toString().equals(focus))
				{
					if(!firma.dohvatiIzvodjaci().get(i).getEmail().equals(null))
					{
						adresa = firma.dohvatiIzvodjaci().get(i).getEmail();
						break;
					}}}
		}
		
		if(adresa.contains("@"))
		{
			try 
			{
				String uriStr = String.format("mailto:%s?subject=%s&body=%s",
			            adresa,URLEncoder.encode(" ", "UTF-8"),URLEncoder.encode(" ", "UTF-8"));
				
				Desktop.getDesktop().browse(new URI(uriStr));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (URISyntaxException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void posaljiMailSvima()
	{
		List<String> listaMail = new ArrayList<>();
		
		if(hotel == true)
		{
			for(int i=0; i<observableList.size(); i++)
			{
				for(int j=0; j<firma.dohvatiHotele().size(); j++)
				{
					if(observableList.get(i).toString().equals(firma.dohvatiHotele().get(j).toString()))
					{
						if(firma.dohvatiHotele().get(j).getEmail().contains("@"))
						{
							listaMail.add(firma.dohvatiHotele().get(j).getEmail());
							System.out.println("spremno poslat mail");
						}
						
					}
				}}}
		
		if(arhTvrtke == true)
		{
			for(int i=0; i<observableList.size(); i++)
			{
				for(int j=0; j<firma.dohvatiArhTvrtke().size(); j++)
				{
					if(observableList.get(i).toString().equals(firma.dohvatiArhTvrtke().get(j).toString()))
					{
						if(firma.dohvatiArhTvrtke().get(j).getEmail().contains("@"))
						{
							listaMail.add(firma.dohvatiArhTvrtke().get(j).getEmail());
						}
						
					}
				}}}
		
		if(izlozProstori == true)
		{
			for(int i=0; i<observableList.size(); i++)
			{
				for(int j=0; j<firma.dohvatiIzlProstori().size(); j++)
				{
					if(observableList.get(i).toString().equals(firma.dohvatiIzlProstori().get(j).toString()))
					{
						if(firma.dohvatiIzlProstori().get(j).getEmail().contains("@"))
						{	
							listaMail.add(firma.dohvatiIzlProstori().get(j).getEmail());
						}
						
					}
				}}}
		
		if(distributeri == true)
		{
			for(int i=0; i<observableList.size(); i++)
			{
				for(int j=0; j<firma.dohvatiDistributere().size(); j++)
				{
					if(observableList.get(i).toString().equals(firma.dohvatiDistributere().get(j).toString()))
					{
						if(firma.dohvatiDistributere().get(j).getEmail().contains("@"))
						{
							listaMail.add(firma.dohvatiDistributere().get(j).getEmail());
						}
						
					}
				}}}
		
		if(izvodjaci == true)
		{
			for(int i=0; i<observableList.size(); i++)
			{
				for(int j=0; j<firma.dohvatiIzvodjaci().size(); j++)
				{
					if(observableList.get(i).toString().equals(firma.dohvatiIzvodjaci().get(j).toString()))
					{
						if(firma.dohvatiIzvodjaci().get(j).getEmail().contains("@"))
						{	
							listaMail.add(firma.dohvatiIzvodjaci().get(j).getEmail());
						}
						
					}
				}}}
		
		try 
		{
			String uriStr = String.format("mailto:%s?subject=%s&body=%s",
		            spojiAdrese(";",listaMail),URLEncoder.encode(" ", "UTF-8"),URLEncoder.encode(" ", "UTF-8"));
			
			Desktop.getDesktop().browse(new URI(uriStr));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (URISyntaxException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public String spojiAdrese(String sep, Iterable<?> objs)
	{
	    StringBuilder sb = new StringBuilder();
	    for(Object obj : objs) 
	    {
	        if (sb.length() > 0) sb.append(sep);
	        sb.append(obj);
	    }
	    
	    return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	@FXML
    public void obrisi()
    {
        String obrisi;
        obrisi = Prikaz.getSelectionModel().getSelectedItem();
        
        try 
        {
        	if(hotel == true)
            {
                for(int i=0; i<firma.dohvatiHotele().size(); i++)
                { 
                	if(firma.dohvatiHotele().get(i).toString().equals(obrisi))
    				{
                		
                		firma.dohvatiHotele().remove(i);
                        observableList.remove(Prikaz.getSelectionModel().getSelectedIndex());
                        Prikaz.setItems(observableList); 
                        dat2.UpisiUdatotekuHotele(ImenikController.firma);
                	    drop.upload("hotel");
                        break;
    				}
                }
                
            }

            
            if(arhTvrtke == true)
            {
                for(int i=0; i<firma.dohvatiArhTvrtke().size(); i++)
                {
                    if(firma.dohvatiArhTvrtke().get(i).toString().equals(obrisi))
                    {    
                        firma.dohvatiArhTvrtke().remove(i);
                        observableList.remove(Prikaz.getSelectionModel().getSelectedIndex());
                        Prikaz.setItems(observableList);
                	    dat2.UpisiUdatotekuArhitekti(ImenikController.firma);
                	    drop.upload("arhitekt");
                        break;
                    }
                
                }
            }
            
            if(izlozProstori == true)
            {
                for(int i=0; i<firma.dohvatiIzlProstori().size(); i++)
                {
                    if(firma.dohvatiIzlProstori().get(i).toString().equals(obrisi))
                    {
                        firma.dohvatiIzlProstori().remove(i);
                        observableList.remove(Prikaz.getSelectionModel().getSelectedIndex());
                        Prikaz.setItems(observableList);
                        dat2.UpisiUdatotekuIzlozbeniProstori(ImenikController.firma);
                        drop.upload("izlProstor");
                        break;
                    }
                }
           }
            
            if(distributeri == true)
            {
                for(int i=0; i<firma.dohvatiDistributere().size(); i++)
                {
                    if(firma.dohvatiDistributere().get(i).toString().equals(obrisi))
                    {
                    	firma.dohvatiDistributere().remove(i);
                        observableList.remove(Prikaz.getSelectionModel().getSelectedIndex());
                        Prikaz.setItems(observableList); 
                        dat2.UpisiUdatotekuDistributeri(ImenikController.firma);
                        drop.upload("distributer");
                        break;
                    }
                }
            }
            
            if(izvodjaci == true)
            {
                for(int i=0; i<firma.dohvatiIzvodjaci().size(); i++)
                {
                    if(firma.dohvatiIzvodjaci().get(i).toString().equals(obrisi))
                    {
                    	firma.dohvatiIzvodjaci().remove(i);
                        observableList.remove(Prikaz.getSelectionModel().getSelectedIndex());
                        Prikaz.setItems(observableList);
                        dat2.UpisiUdatotekuIzlozbeniProstori(ImenikController.firma);
                        drop.upload("izlProstor");
                        break;
                    }
                }
             }
        }
        catch( DbxException | IOException e)
        {
        	
        }
    }
	
	
	@FXML
	public void napraviIzmjenu() throws IOException
	{
		
		 if(hotel == true)
		 {
			 if(osvHotele == false)
			 {
				 for(int i=0; i<firma.dohvatiHotele().size(); i++)
			        { 
						if(firma.dohvatiHotele().get(i).toString().
								equals(Prikaz.getSelectionModel().getSelectedItem()))
						{
							adresa = i;
							break;
						}
						
			        }
				 prikazIzmjene();
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
		 
		 if(arhTvrtke == true)
		 {
			 if(osvArhTvrtke == false)
			 {
				 for(int i=0; i<firma.dohvatiArhTvrtke().size(); i++)
			        { 
						if(firma.dohvatiArhTvrtke().get(i).toString().
								equals(Prikaz.getSelectionModel().getSelectedItem()))
						{
							adresa = i;
							break;
						}
			        }
				 prikazIzmjene();
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
		 
		 if(distributeri == true)
		 {
			 
			 if(osvDistributere == false)
			 {
				 for(int i=0; i<firma.dohvatiDistributere().size(); i++)
			        { 
						if(firma.dohvatiDistributere().get(i).toString().
								equals(Prikaz.getSelectionModel().getSelectedItem()))
						{
							adresa = i;
							break;
						}
			        }
				 prikazIzmjene();
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
		 
		 if(izlozProstori == true)
		 {
			 
			 if(osvIzlozbene == false)
			 {
				 for(int i=0; i<firma.dohvatiIzlProstori().size(); i++)
			        { 
						if(firma.dohvatiIzlProstori().get(i).toString().
								equals(Prikaz.getSelectionModel().getSelectedItem()))
						{
							adresa = i;
							break;
						}
			        }
				 prikazIzmjene();
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
		 
		 if(izvodjaci == true)
		 {
			 
			 if(osvIzvodjace == false)
			 {
				 for(int i=0; i<firma.dohvatiIzvodjaci().size(); i++)
			        { 
						if(firma.dohvatiIzvodjaci().get(i).toString().
								equals(Prikaz.getSelectionModel().getSelectedItem()))
						{
							adresa = i;
							break;
						}
			        }
				 prikazIzmjene();
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
		 
	}

	@FXML
	private void RadiOffline()
	{
		try 
		{
			dat2.UcitajHotele(firma);
			dat2.UcitajArhitekte(firma);
			dat2.UcitajIzlozbeniProstore(firma);
			dat2.UcitajIzvodjace(firma);
			dat2.UcitajDistributere(firma);
			
			offline.setDisable(true);
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("All your data has been deleted");
			alert.setContentText("Make sure your network connection is active to download new data");
			alert.showAndWait();
		}
		
	}
	
	@FXML
	public void noviHotel() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajHotel.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("New hotel");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		
	}
	
	@FXML
	public void novaArhTvrtke() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajArhitektonske_tvrtke.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("New architects-interiour designer");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		
	}
	
	@FXML
	public void noviDistributer() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajDistributera.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("New distributor");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		
	}
	
	@FXML
	public void noviIzlozbeniProstor() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajIzlozbeniProstor.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("New showroom");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		
	}
	
	@FXML
	public void noviIzvodjac() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajIzvodjaca.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("New contractor");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
		
	}
	
	
	private void prikazIzmjene() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Izmjena.fxml"));
		Scene scene = new Scene(loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("Edit");
		stage.setScene(scene);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.show();
	}
	
	@SuppressWarnings("deprecation")
	private void napraviBackUp()
	{
		int mjesec =verzijaHotel.getMonth();
		int mjesecBackUp=BackUpSerijalizacija.HoteliDatum.getMonth();
		
		if(mjesec>mjesecBackUp)
		{
			backUpdat.UpisiUdatotekuHotele(firma);
			//System.out.println("Uspjesno");
		}
		
		mjesec =verzijaArhTvrtka.getMonth();
		mjesecBackUp=BackUpSerijalizacija.ArhitektiDatum.getMonth();
		
		if(mjesec>mjesecBackUp)
		{
			backUpdat.UpisiUdatotekuArhitekti(firma);
			//System.out.println("Uspjesno");
		}
		
		mjesec =verzijaIzlProstor.getMonth();
		mjesecBackUp=BackUpSerijalizacija.IzlProsoriDatum.getMonth();
		
		if(mjesec>mjesecBackUp)
		{
			backUpdat.UpisiUdatotekuIzlozbeniProstori(firma);
			//System.out.println("Uspjesno");
		}
		
		mjesec =verzijaIzvodjaci.getMonth();
		mjesecBackUp=BackUpSerijalizacija.IzvodjaciDatum.getMonth();
		
		if(mjesec>mjesecBackUp)
		{
			backUpdat.UpisiUdatotekuIzvodjaci(firma);
			//System.out.println("Uspjesno");
		}
		
		mjesec =verzijaDistributeri.getMonth();
		mjesecBackUp=BackUpSerijalizacija.DistributeriDatum.getMonth();
		
		if(mjesec>mjesecBackUp)
		{
			backUpdat.UpisiUdatotekuDistributeri(firma);
			//System.out.println("Uspjesno");
		}
	}
	
	
}


