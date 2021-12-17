package sara.nit;


import java.io.IOException;

import com.dropbox.core.DbxException;
import sara.datoteke.DropBox;
import sara.javefx.ImenikController;

public class Nit2 implements Runnable {

	private Thread t;
    private String ime;
    private DropBox drop;
    private boolean radi;
    
    public Nit2(String ime,boolean radi)
    {
    	this.ime=ime;
    	this.radi=radi;
    }
	
	@Override
	public void run() 
	{
		drop = ImenikController.drop;
		
		try
		{
			while(radi)
			{
				drop.DohvatiVremena();
				Thread.sleep(1000);
			}
		}
		
		catch (InterruptedException | DbxException | ClassNotFoundException | IOException e)
		{
			radi = false;
			/*Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Pogreška");
			alert.setHeaderText("Došlo je do greške");
			alert.setContentText(".........");
			alert.showAndWait();*/
		}
	}
	
	
	public void start()
	{
		  
		if (t == null)
	      {
			radi = true;
	        t = new Thread (this, ime);
	        t.setDaemon(true);
	        t.start ();
	      }
	      
	}
	
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	public void Stop(boolean rad)
	{
		this.radi=rad;
	}

}
