package sara.nit;


import java.io.IOException;

import com.dropbox.core.DbxException;

import sara.datoteke.DropBox;
import sara.javefx.ImenikController;

public class Nit implements Runnable {
	
	private Thread t;
    private String ime;
    @SuppressWarnings("unused")
	private DropBox drop;
    
    public Nit(String ime)
    {
    	this.ime=ime;
    }
	
	public void run() 
	{
		drop = ImenikController.drop;
		try
		{
		
			if(ime.equals("hotel"))
			{
				ImenikController.drop.download("hotel");
				ImenikController.firma.dohvatiHotele().clear();
				ImenikController.dat2.UcitajHotele(ImenikController.firma);
				System.out.println("jesaaaam hotel");
				
			}
			
			if(ime.equals("arhitekt"))
			{
				ImenikController.drop.download("arhitekt");
				ImenikController.firma.dohvatiArhTvrtke().clear();
			    ImenikController.dat2.UcitajArhitekte(ImenikController.firma);
			    System.out.println("jesaaaam arhitekt");
			}
			
			if(ime.equals("distributer"))
			{
				ImenikController.drop.download("distributer");
				ImenikController.firma.dohvatiDistributere().clear();
		        ImenikController.dat2.UcitajDistributere(ImenikController.firma);
		        System.out.println("jesaaaam distributer");
			}
			
			if(ime.equals("izlProstor"))
			{
				ImenikController.drop.download("izlProstor");
				ImenikController.firma.dohvatiIzlProstori().clear();
			    ImenikController.dat2.UcitajIzlozbeniProstore(ImenikController.firma);
			    System.out.println("jesaaaam izlProstor");
			}
			
			if(ime.equals("izvodjac"))
			{
				ImenikController.drop.download("izvodjac");
				ImenikController.firma.dohvatiIzvodjaci().clear();
			    ImenikController.dat2.UcitajIzvodjace(ImenikController.firma);
			    System.out.println("jesaaaam izvodjac");
			}
			
			
		}
		
		catch (  DbxException | IOException | ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	
	public void start()
	{
		  
		if (t == null)
	      {
	        t = new Thread (this, ime);
	        t.start ();
	      }
	      
	}
	
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	

}
