package sara.datoteke;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import sara.klase.Arhitektonske_tvrtka;
import sara.klase.Distributer;
import sara.klase.Hotel;
import sara.klase.Izlozbeni_prostor;
import sara.klase.Izvodac;
import sara.metode.Firma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Datoteka {

	public static File file = new File("dat//Hoteli.xlt");
	public static File file2 = new File("dat//Arhitekti.xlt");
	public static File file3 = new File("dat//IzlozbeniProstori.xlt");
	public static File file4 = new File("dat//Izvodjaci.xlt");
	public static File file5 = new File("dat//Distributeri.xlt");
	
	public static FileInputStream fr = null;
	
	private Hotel hotel;
	private Arhitektonske_tvrtka arhTvrtke;
	private Izlozbeni_prostor izProstor;
	private Izvodac izvodjac;
	private Distributer distributer;
	
	@SuppressWarnings("deprecation")
	public void procitajTablicuHotel(Firma firma)
	{
		
		try 
		{
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) 
		            	cols = tmp;
		        }
		    }
		    
		    //System.out.println(cols);

		    for(int r = 1; r < rows; r++) 
		    {
		    	hotel = new Hotel("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell((short)c);
		                if(cell != null) 
		                {
		                    //System.out.println(cell);
		                	
		                    if(c == 0)
		                    {
		                    	hotel.setNaziv(cell.toString());
		                    }
		                    
		                    if(c == 1)
		                    {
		                    	hotel.setKontaktOsoba(cell.toString());
		                    }
		                    
		                    if(c == 2)
		                    {
		                    	hotel.setAdresa(cell.toString());
		                    }
		                    
		                    if(c == 3)
		                    {
		                    	hotel.setGrad(cell.toString());
		                    }
		                    
		                    if(c == 4)
		                    {
		                    	hotel.setDrzava(cell.toString());
		                    }
		                    
		                    if(c == 5)
		                    {
		                    	hotel.setEmail(cell.toString());
		                    }
		                    
		                    if(c == 6)
		                    {
		                    	hotel.setTelefon(cell.toString());
		                    }
		                    
		                    if(c == 7)
		                    {
		                    	hotel.setFax(cell.toString());
		                    }
		                    
		                    if(c == 8)
		                    {
		                    	hotel.setWeb(cell.toString());
		                    }
		                    
		                    if(c == 9)
		                    {
		                    	hotel.setMob(cell.toString());
		                    }
		                }
		            }
		        }
		        firma.setHotel(hotel);
		        firma.dodajHotel(firma.getHotel());
		    }
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void procitajTablicuArhTvrtke(Firma firma)
	{
		
		try 
		{
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file2));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) 
		            	cols = tmp;
		        }
		    }
		    
		    //System.out.println(cols);

		    for(int r = 2; r < rows; r++) 
		    {
		    	
		    	arhTvrtke = new Arhitektonske_tvrtka("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell((short)c);
		                if(cell != null) 
		                {
		                   // System.out.println(cell);
		                    
		                    if(c == 0)
		                    {
		                    	arhTvrtke.setNaziv(cell.toString());
		                    }
		                    
		                    if(c == 1)
		                    {
		                    	arhTvrtke.setKontaktOsoba(cell.toString());
		                    }
		                    
		                    if(c == 2)
		                    {
		                    	arhTvrtke.setAdresa(cell.toString());
		                    }
		                    
		                    if(c == 3)
		                    {
		                    	arhTvrtke.setGrad(cell.toString());
		                    }
		                    
		                    if(c == 4)
		                    {
		                    	arhTvrtke.setDrzava(cell.toString());
		                    }
		                    
		                    if(c == 5)
		                    {
		                    	arhTvrtke.setEmail(cell.toString());
		                    }
		                    
		                    if(c == 6)
		                    {
		                    	arhTvrtke.setTelefon(cell.toString());
		                    }
		                    
		                    if(c == 7)
		                    {
		                    	arhTvrtke.setFax(cell.toString());
		                    }
		                    
		                    if(c == 8)
		                    {
		                    	arhTvrtke.setWeb(cell.toString());
		                    }
		                    
		                    if(c == 9)
		                    {
		                    	arhTvrtke.setMobitel(cell.toString());
		                    }
		                }
		            }
		        }
		        firma.setArhTvrtka(arhTvrtke);
		        firma.dodajArhTvrtku(firma.getArhTvrtka());
		    }
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void procitajTablicuIzloProstor(Firma firma)
	{
		
		try 
		{
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file3));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) 
		            	cols = tmp;
		        }
		    }
		    
		    //System.out.println(cols);

		    for(int r = 2; r < rows; r++) 
		    {
		    	
		    	izProstor = new Izlozbeni_prostor("-", "-", "-","-", "-", "-", "-", "-",
		    			"-", "-", "-");
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell((short)c);
		                if(cell != null) 
		                {
		                    //System.out.println(cell);
		                    
		                    if(c == 0)
		                    {
		                    	izProstor.setNaziv(cell.toString());
		                    }
		                    
		                    if(c == 1)
		                    {
		                    	izProstor.setKontaktOsoba(cell.toString());
		                    }
		                    
		                    if(c == 2)
		                    {
		                    	izProstor.setAdresa(cell.toString());
		                    }
		                    
		                    if(c == 3)
		                    {
		                    	izProstor.setGrad(cell.toString());
		                    }
		                    
		                    if(c == 4)
		                    {
		                    	izProstor.setDrzava(cell.toString());
		                    }
		                    
		                    if(c == 5)
		                    {
		                    	izProstor.setEmail(cell.toString());
		                    }
		                    
		                    if(c == 6)
		                    {
		                    	izProstor.setTelefon(cell.toString());
		                    }
		                    
		                    if(c == 7)
		                    {
		                    	izProstor.setFax(cell.toString());
		                    }
		                    
		                    if(c == 8)
		                    {
		                    	izProstor.setWeb(cell.toString());
		                    }
		                    
		                    if(c == 9)
		                    {
		                    	izProstor.setMobitel(cell.toString());
		                    }
		                    
		                    if(c == 10)
		                    {
		                    	izProstor.setBrandovi(cell.toString());
		                    }
		                }
		            }
		        }
		        firma.setIzlozbeniProstor(izProstor);
		        firma.dodajIzlProstor(firma.getIzlozbeniProstor());
		    }
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void procitajTablicuIzvodjaci(Firma firma)
	{
		
		try 
		{
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file4));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) 
		            	cols = tmp;
		        }
		    }
		    
		    //System.out.println(cols);

		    for(int r = 1; r < rows; r++) 
		    {
		    	
		    	izvodjac = new Izvodac("-", "-", "-", "-", "-", "-", "-", "-", "-","-");
		 
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell((short)c);
		                if(cell != null) 
		                {
		                   // System.out.println(cell);
		                    
		                    if(c == 0)
		                    {
		                    	izvodjac.setNaziv(cell.toString());
		                    }
		                    
		                    if(c == 1)
		                    {
		                    	izvodjac.setKontaktOsoba(cell.toString());
		                    }
		                    
		                    if(c == 2)
		                    {
		                    	izvodjac.setAdresa(cell.toString());
		                    }
		                    
		                    if(c == 3)
		                    {
		                    	izvodjac.setGrad(cell.toString());
		                    }
		                    
		                    if(c == 4)
		                    {
		                    	izvodjac.setDrzava(cell.toString());
		                    }
		                    
		                    if(c == 5)
		                    {
		                    	izvodjac.setEmail(cell.toString());
		                    }
		                    
		                    if(c == 6)
		                    {
		                    	izvodjac.setTelefon(cell.toString());
		                    }
		                    
		                    if(c == 7)
		                    {
		                    	izvodjac.setFax(cell.toString());
		                    }
		                    
		                    if(c == 8)
		                    {
		                    	izvodjac.setWeb(cell.toString());
		                    }
		                    
		                    if(c == 9)
		                    {
		                    	izvodjac.setMobitel(cell.toString());
		                    }
		                    
		                }
		            }
		        }
		        firma.setIzvodac(izvodjac);
		        firma.dodajIzvodjaca(firma.getIzvodac());
		    }
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void procitajTablicuDistributeri(Firma firma)
	{
		
		try 
		{
			
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file5));
			
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) 
		    {
		        row = sheet.getRow(i);
		        if(row != null) 
		        {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) 
		            	cols = tmp;
		        }
		    }
		    
		    //System.out.println(cols);

		    for(int r = 1; r < rows; r++) 
		    {
		    	
		    	distributer = new Distributer("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
		 
		        row = sheet.getRow(r);
		        if(row != null) 
		        {
		            for(int c = 0; c < cols; c++) 
		            {
		                cell = row.getCell((short)c);
		                if(cell != null) 
		                {
		                    //System.out.println(cell);
		                    
		                    if(c == 0)
		                    {
		                    	distributer.setNaziv(cell.toString());
		                    }
		                    
		                    if(c == 1)
		                    {
		                    	distributer.setKontaktOsoba(cell.toString());
		                    }
		                    
		                    if(c == 2)
		                    {
		                    	distributer.setAdresa(cell.toString());
		                    }
		                    
		                    if(c == 3)
		                    {
		                    	distributer.setGrad(cell.toString());
		                    }
		                    
		                    if(c == 4)
		                    {
		                    	distributer.setDrzava(cell.toString());
		                    }
		                    
		                    if(c == 5)
		                    {
		                    	distributer.setEmail(cell.toString());
		                    }
		                    
		                    if(c == 6)
		                    {
		                    	distributer.setTelefon(cell.toString());
		                    }
		                    
		                    if(c == 7)
		                    {
		                    	distributer.setFax(cell.toString());
		                    }
		                    
		                    if(c == 8)
		                    {
		                    	distributer.setWeb(cell.toString());
		                    }
		                    
		                    if(c == 9)
		                    {
		                    	distributer.setMobitel(cell.toString());
		                    }
		                    
		                }
		            }
		        }
		        firma.setDistributer(distributer);
		        firma.dodajDistributera(firma.getDistributer());
		    }
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
