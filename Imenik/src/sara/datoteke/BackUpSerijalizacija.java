package sara.datoteke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import sara.metode.Firma;

public class BackUpSerijalizacija {
	public static File file = new File("BackUp//Hoteli_dat.dat");
	public static File file2 = new File("BackUp//Arhitekti_dat.dat");
	public static File file3 = new File("BackUp//IzlozbeniProstori_dat.dat");
	public static File file4 = new File("BackUp//Izvodjaci_dat.dat");
	public static File file5 = new File("BackUp//Distributeri_dat.dat");
	public static  Date HoteliDatum,ArhitektiDatum,IzlProsoriDatum,IzvodjaciDatum,DistributeriDatum;
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

	
	public void dohvatiDatum()
	{	
		HoteliDatum = new Date(file.lastModified());
		//System.out.println("Hoteli backup:"+HoteliDatum);
		ArhitektiDatum = new Date(file2.lastModified());
		//System.out.println("Arhitekti backup:"+ArhitektiDatum);
		IzlProsoriDatum = new Date(file3.lastModified());
		//System.out.println("IZlprosotri backup:"+IzlProsoriDatum);
		IzvodjaciDatum = new Date(file4.lastModified());
		//System.out.println("Izvodjaci backup:"+IzvodjaciDatum);
		DistributeriDatum = new Date(file5.lastModified());
		//System.out.println("Distributeri backup:"+DistributeriDatum);
		
	}
	
	

}
