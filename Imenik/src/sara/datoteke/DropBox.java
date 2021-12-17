package sara.datoteke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

import sara.javefx.ImenikController;


public class DropBox {

    private String APP_KEY;
    private String APP_SECRET;
    private DbxAppInfo appInfo;
    private DbxRequestConfig config;
	@SuppressWarnings("unused")
	private DbxWebAuthNoRedirect webAuth;
    private String accessToken;
    private  DbxClient client;
    
    private static final String conection_file= "dat//config.properties";
    private File inputFile = new File("dat//Arhitekti_dat.dat");
    private File inputFile2 = new File("dat//Distributeri_dat.dat");
    private File inputFile3 = new File("dat//Hoteli_dat.dat");
    private File inputFile4 = new File("dat//IzlozbeniProstori_dat.dat");
    private File inputFile5 = new File("dat//izvodjaci_dat.dat");
    
    
    public void Povezi() throws DbxException, IOException
    {
    	
    	Properties svojstva = new Properties();
		svojstva.load(new FileReader(conection_file));
        
		APP_KEY = svojstva.getProperty("key");
		APP_SECRET = svojstva.getProperty("app_secret");
		
		
        appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
        config = new DbxRequestConfig("aadi_Koncept",
               Locale.getDefault().toString());
        webAuth = new DbxWebAuthNoRedirect(config, appInfo);
           
        accessToken = svojstva.getProperty("accessToken");
        
        client = new DbxClient(config, accessToken);
        //System.out.println("povezao");

    }
    
    public void upload(String imeDatoteke) throws DbxException, IOException
    {    
    	
        if(imeDatoteke.equals("arhitekt"))
        {
        	FileInputStream inputStream = new FileInputStream(inputFile);
             try {
            	 
                 DbxEntry.File uploadedFile = client.uploadFile("/Arhitekti_dat.dat",
                		 DbxWriteMode.update(null), inputFile.length(), inputStream);
                 
                 ImenikController.verzijaArhTvrtka = uploadedFile.asFile().lastModified;
                 //System.out.println("Uploaded: " + uploadedFile.toString());
             } finally {
                 inputStream.close();
             }
             
        }
        
        
       else if(imeDatoteke.equals("hotel"))
        {
           FileInputStream inputStream = new FileInputStream(inputFile3);
                 try {
                	 
                     DbxEntry.File uploadedFile = client.uploadFile("/Hoteli_dat.dat",
                    		 DbxWriteMode.update(null), inputFile3.length(), inputStream);
                     
                     ImenikController.verzijaHotel = uploadedFile.asFile().lastModified;
                     
                     //System.out.println("Uploaded: " + uploadedFile.toString());
                 } finally {
                     inputStream.close();
                 }
        }
       else if(imeDatoteke.equals("distributer"))
        {
           FileInputStream inputStream = new FileInputStream(inputFile2);
                 try {
                                                       
                     DbxEntry.File uploadedFile = client.uploadFile("/Distributeri_dat.dat",                  
                    		 DbxWriteMode.update(null), inputFile2.length(), inputStream);
                     
                     ImenikController.verzijaDistributeri = uploadedFile.asFile().lastModified;
                   
                     //System.out.println("Uploaded: " + uploadedFile.toString());
                 } finally {
                     inputStream.close();
                 }
       }
       else if(imeDatoteke.equals("izlProstor"))
        {
           FileInputStream inputStream = new FileInputStream(inputFile4);
                 try {
                                                        
                     DbxEntry.File uploadedFile = client.uploadFile("/IzlozbeniProstori_dat.dat",                   
                    		 DbxWriteMode.update(null), inputFile4.length(), inputStream);
                     
                     ImenikController.verzijaIzlProstor = uploadedFile.asFile().lastModified;
                     
                     //System.out.println("Uploaded: " + uploadedFile.toString());
                 } finally {
                     inputStream.close();
                 }
      }
       else if(imeDatoteke.equals("izvodjac"))
        {
           FileInputStream inputStream = new FileInputStream(inputFile5);
                 try {
                                      
                     DbxEntry.File uploadedFile = client.uploadFile("/Izvodjaci_dat.dat",                   
                    		 DbxWriteMode.update(null), inputFile5.length(), inputStream);
                     
                     ImenikController.verzijaIzvodjaci = uploadedFile.asFile().lastModified;
                    
                     //System.out.println("Uploaded: " + uploadedFile.toString());
                 } finally {
                     inputStream.close();
                 }
     }
         
       // DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
        /*System.out.println("Files in the root path:");
        for (DbxEntry child : listing.children) {
            System.out.println("    " + child.name + ": " + child.toString())};*/
    }
    
	public void download(String imeDatoteke) throws DbxException, IOException
    {
		
		if(imeDatoteke.equals("test"))
		{
			 FileOutputStream outputStream = new FileOutputStream("dat//testDownload.txt");
             try 
             {
                 @SuppressWarnings("unused")
				DbxEntry.File downloadedFile = client.getFile("/test.txt", null,
                     outputStream);
             } 
             
             finally 
             {            	 
                 outputStream.close();
             }   
		}
        
        if(imeDatoteke.equals("hotel"))
        {
               FileOutputStream outputStream = new FileOutputStream("dat//Hoteli_dat.dat");
               try {
                   DbxEntry.File downloadedFile = client.getFile("/Hoteli_dat.dat", null,
                       outputStream);
                   
                   ImenikController.verzijaHotel = downloadedFile.asFile().lastModified;
                   
                   //System.out.println("Metadata: " + downloadedFile.toString());
               } finally {
                   outputStream.close();
               }   
        }
        
        if(imeDatoteke.equals("arhitekt"))
        {
               FileOutputStream outputStream = new FileOutputStream("dat//Arhitekti_dat.dat");
               try {
                   DbxEntry.File downloadedFile = client.getFile("/Arhitekti_dat.dat", null,
                       outputStream);
                   
                   ImenikController.verzijaArhTvrtka = downloadedFile.asFile().lastModified;
                   
                   //System.out.println("Metadata: " + downloadedFile.toString());
               } finally {
                   outputStream.close();
               }
        }
        
        if(imeDatoteke.equals("izlProstor"))
        {
               FileOutputStream outputStream = new FileOutputStream("dat//IzlozbeniProstori_dat.dat");
               try {
                   DbxEntry.File downloadedFile = client.getFile("/IzlozbeniProstori_dat.dat", null,
                       outputStream);
                   
                   ImenikController.verzijaIzlProstor = downloadedFile.asFile().lastModified;
                   
                   //System.out.println("Metadata: " + downloadedFile.toString());
               } finally {
                   outputStream.close();
               }
        }
        
        if(imeDatoteke.equals("distributer"))
        {
               FileOutputStream outputStream = new FileOutputStream("dat//Distributeri_dat.dat");
               try {
                   DbxEntry.File downloadedFile = client.getFile("/Distributeri_dat.dat", null,
                       outputStream);
                   
                   ImenikController.verzijaDistributeri = downloadedFile.asFile().lastModified;
                   
                   //System.out.println("Metadata: " + downloadedFile.toString());
               } finally {
                   outputStream.close();
               }
        }
        
        if(imeDatoteke.equals("izvodjac"))
        {
               FileOutputStream outputStream = new FileOutputStream("dat//Izvodjaci_dat.dat");
               try {
                   DbxEntry.File downloadedFile = client.getFile("/Izvodjaci_dat.dat", null,
                       outputStream);
                   
                   ImenikController.verzijaIzvodjaci = downloadedFile.asFile().lastModified;
                   
                   //System.out.println("Metadata: " + downloadedFile.toString());
               } finally {
                   outputStream.close();
               }
        }
        
    }
    
    public void DohvatiVremena() throws DbxException, IOException, ClassNotFoundException
    {
    	
    	DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
        
       /* System.out.println("Files in the root path:");
        for (DbxEntry child : listing.children) {
        	
        	//dohæanje zadnje izmjene
        	System.out.println(child.name + ": " +child.asFile().lastModified.toString());
            //System.out.println("	" + child.name + ": " + child.toString());
        	}
        */
       
    	if(!listing.children.get(2).asFile().lastModified.equals(ImenikController.verzijaHotel))
    	{
    		ImenikController.osvHotele = true;
    		ImenikController.drop.download("hotel");
			ImenikController.firma.dohvatiHotele().clear();
			ImenikController.dat2.UcitajHotele(ImenikController.firma);
			System.out.println("jesaaaam hotel");
    		
    	}
    	
    	if(!listing.children.get(0).asFile().lastModified.equals(ImenikController.verzijaArhTvrtka))
    	{
    		ImenikController.osvArhTvrtke = true;
    		ImenikController.drop.download("arhitekt");
			ImenikController.firma.dohvatiArhTvrtke().clear();
		    ImenikController.dat2.UcitajArhitekte(ImenikController.firma);
		    System.out.println("jesaaaam arhitekt");
    	}
    	
    	if(!listing.children.get(1).asFile().lastModified.equals(ImenikController.verzijaDistributeri))
    	{
    		ImenikController.osvDistributere = true;
    		ImenikController.drop.download("distributer");
			ImenikController.firma.dohvatiDistributere().clear();
	        ImenikController.dat2.UcitajDistributere(ImenikController.firma);
	        System.out.println("jesaaaam distributer");

    	}
    	
    	if(!listing.children.get(3).asFile().lastModified.equals(ImenikController.verzijaIzlProstor))
    	{
    		ImenikController.osvIzlozbene = true;
    		ImenikController.drop.download("izlProstor");
			ImenikController.firma.dohvatiIzlProstori().clear();
		    ImenikController.dat2.UcitajIzlozbeniProstore(ImenikController.firma);
		    System.out.println("jesaaaam izlProstor");
    	}
    	
    	if(!listing.children.get(4).asFile().lastModified.equals(ImenikController.verzijaIzvodjaci))
    	{
    		ImenikController.osvIzvodjace = true;
    		ImenikController.drop.download("izvodjac");
			ImenikController.firma.dohvatiIzvodjaci().clear();
		    ImenikController.dat2.UcitajIzvodjace(ImenikController.firma);
		    System.out.println("jesaaaam izvodjac");

    	}
    	 

    }
    
}

	
