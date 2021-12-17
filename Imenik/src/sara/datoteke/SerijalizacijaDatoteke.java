package sara.datoteke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sara.klase.Arhitektonske_tvrtka;
import sara.klase.Distributer;
import sara.klase.Hotel;
import sara.klase.Izlozbeni_prostor;
import sara.klase.Izvodac;
import sara.metode.Firma;

public class SerijalizacijaDatoteke {
	
	public static File file = new File("dat//Hoteli_dat.dat");
	public static File file2 = new File("dat//Arhitekti_dat.dat");
	public static File file3 = new File("dat//IzlozbeniProstori_dat.dat");
	public static File file4 = new File("dat//Izvodjaci_dat.dat");
	public static File file5 = new File("dat//Distributeri_dat.dat");
	
	ObjectOutputStream out = null;
	FileOutputStream OutFile = null;
	
	ObjectInputStream in = null;
	FileInputStream InFile = null;
	
	public void UpisiUdatotekuHotele(Firma firma) 
	{
		
		try 
		{
			OutFile = new FileOutputStream(file);
			
			out= new ObjectOutputStream(
					 OutFile);
			
			for(int i=0; i<firma.dohvatiHotele().size(); i++)
			{
				out.writeObject(firma.dohvatiHotele().get(i));
			}
			
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			try 
			{
				out.flush();
				out.close();
				OutFile.close();
				
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
		
	}
	
	public void UpisiUdatotekuArhitekti(Firma firma) 
	{
		
		try 
		{
			OutFile = new FileOutputStream(file2);
			
			out= new ObjectOutputStream(
					 OutFile);
			
			for(int i=0; i<firma.dohvatiArhTvrtke().size(); i++)
			{
				out.writeObject(firma.dohvatiArhTvrtke().get(i));
			}
			
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			try 
			{
				out.flush();
				out.close();
				OutFile.close();
				
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
	}
	
	
	public void UpisiUdatotekuIzlozbeniProstori(Firma firma) 
	{
		
		try 
		{
			OutFile = new FileOutputStream(file3);
			
			out= new ObjectOutputStream(
					 OutFile);
			
			for(int i=0; i<firma.dohvatiIzlProstori().size(); i++)
			{
				out.writeObject(firma.dohvatiIzlProstori().get(i));
			}
			
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			try 
			{
				out.flush();
				out.close();
				OutFile.close();
				
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
	}

	public void UpisiUdatotekuIzvodjaci(Firma firma) 
	{
		
		try 
		{
			OutFile = new FileOutputStream(file4);
			
			out= new ObjectOutputStream(
					 OutFile);
			
			for(int i=0; i<firma.dohvatiIzvodjaci().size(); i++)
			{
				out.writeObject(firma.dohvatiIzvodjaci().get(i));
			}
			
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			try 
			{
				out.flush();
				out.close();
				OutFile.close();
				
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
	}
	
	public void UpisiUdatotekuDistributeri(Firma firma) 
	{
		
		try 
		{
			OutFile = new FileOutputStream(file5);
			
			out= new ObjectOutputStream(
					 OutFile);
			
			for(int i=0; i<firma.dohvatiDistributere().size(); i++)
			{
				out.writeObject(firma.dohvatiDistributere().get(i));
			}
			
			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
			try 
			{
				out.flush();
				out.close();
				OutFile.close();
				
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
	}

	
	public void UcitajHotele(Firma firma) throws ClassNotFoundException, IOException 
	{
		
		InFile = new FileInputStream(file);
		in= new ObjectInputStream(InFile);
		
		while(InFile.available()>0)
		{
			try 
			{
				Hotel h = (Hotel) in.readObject();
				firma.dodajHotel(h);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				try 
				{
					out.flush();
					out.close();
					OutFile.close();
					
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void UcitajArhitekte(Firma firma) throws ClassNotFoundException, IOException 
	{
		InFile = new FileInputStream(file2);
		in= new ObjectInputStream(InFile);
		
		while(InFile.available()>0)
		{
			try 
			{
				
				Arhitektonske_tvrtka a = (Arhitektonske_tvrtka) in.readObject();
				firma.dodajArhTvrtku(a);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				try 
				{
					out.flush();
					out.close();
					OutFile.close();
					
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void UcitajIzlozbeniProstore(Firma firma) throws ClassNotFoundException, IOException 
	{
		InFile = new FileInputStream(file3);
		in= new ObjectInputStream(InFile);
		
		while(InFile.available()>0)
		{
			try 
			{
				Izlozbeni_prostor i = (Izlozbeni_prostor) in.readObject();
				firma.dodajIzlProstor(i);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				try 
				{
					out.flush();
					out.close();
					OutFile.close();
					
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void UcitajIzvodjace(Firma firma) throws ClassNotFoundException, IOException 
	{
		
		
		InFile = new FileInputStream(file4);
		in= new ObjectInputStream(InFile);
		
		while(InFile.available()>0)
		{
			try 
			{
				Izvodac i = (Izvodac) in.readObject();
				firma.dodajIzvodjaca(i);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				try 
				{
					out.flush();
					out.close();
					OutFile.close();
					
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void UcitajDistributere(Firma firma) throws ClassNotFoundException, IOException 
	{
		InFile = new FileInputStream(file5);
		in= new ObjectInputStream(InFile);
		
		while(InFile.available()>0)
		{
			try 
			{
				Distributer d = (Distributer) in.readObject();
				firma.dodajDistributera(d);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
				try 
				{
					out.flush();
					out.close();
					OutFile.close();
					
				} 
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		}
		
	}

}
