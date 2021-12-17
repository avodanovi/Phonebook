package sara.metode;
import java.util.ArrayList;
import java.util.List;

import sara.klase.Arhitektonske_tvrtka;
import sara.klase.Distributer;
import sara.klase.Hotel;
import sara.klase.Izlozbeni_prostor;
import sara.klase.Izvodac;




public class Firma {
	
	private Arhitektonske_tvrtka arhTvrtka;
	private Hotel hotel;
	private Izlozbeni_prostor izlozbeniProstor;
	private Izvodac izvodac;
	private Distributer distributer;
	
	private List<Hotel> Hoteli = new ArrayList<>();
	private List<Arhitektonske_tvrtka> ArhTvrtke = new ArrayList<>();
	private List<Izlozbeni_prostor> IzlProstori = new ArrayList<>();
	private List<Izvodac> izvodjaci = new ArrayList<>();
	private List<Distributer> distributeri = new ArrayList<>();
	
	public Firma(Arhitektonske_tvrtka arhTvrtka,Hotel hotel,Izlozbeni_prostor izlozbeniProstor,
			Izvodac izvodac)
	{
		this.arhTvrtka=arhTvrtka;
		this.hotel=hotel;
		this.izlozbeniProstor=izlozbeniProstor;
		this.izvodac=izvodac;
	}
	
	
	public Arhitektonske_tvrtka getArhTvrtka()
	{
		return arhTvrtka;
	}
	
	public void setArhTvrtka(Arhitektonske_tvrtka arhTvrtka) 
	{
		this.arhTvrtka = arhTvrtka;
	}
	
	public Hotel getHotel()
	{
		return hotel;
	}
	
	public void setHotel(Hotel hotel) 
	{
		this.hotel = hotel;
	}
	
	public Izlozbeni_prostor getIzlozbeniProstor()
	{
		return izlozbeniProstor;
	}
	
	public void setIzlozbeniProstor(Izlozbeni_prostor izlozbeniProstor)
	{
		this.izlozbeniProstor = izlozbeniProstor;
	}
	
	public Izvodac getIzvodac() 
	{
		return izvodac;
	}
	
	public void setIzvodac(Izvodac izvodac)
	{
		this.izvodac = izvodac;
	}
	
	public void setDistributer(Distributer distributer)
	{
		this.distributer=distributer;
	}
	
	public Distributer getDistributer()
	{
		return distributer;
	}
	
	public void dodajHotel(Hotel hotel)
	{
		Hoteli.add(hotel);
	}
	
	public List<Hotel> dohvatiHotele()
	{
		return Hoteli;
	}

	public void dodajArhTvrtku(Arhitektonske_tvrtka arhTvrtke) 
	{
		ArhTvrtke.add(arhTvrtke);
	}

	public List<Arhitektonske_tvrtka> dohvatiArhTvrtke() 
	{
		return ArhTvrtke;
	}

	public void dodajIzlProstor(Izlozbeni_prostor izlProstor) 
	{
		IzlProstori.add(izlProstor);
	}

	public List<Izlozbeni_prostor> dohvatiIzlProstori()
	{
		return IzlProstori;
	}
	
	public void dodajIzvodjaca(Izvodac izvodjac) 
	{
		izvodjaci.add(izvodjac);
	}
	
	public List<Izvodac> dohvatiIzvodjaci() 
	{
		return izvodjaci;
	}
	
	public void dodajDistributera(Distributer distributer)
	{
		distributeri.add(distributer);
	}
	
	public List<Distributer> dohvatiDistributere()
	{
		return distributeri;
	}
	
	public List<Hotel> dohvatiHotel(String referenca, String odabir)
    {
       
        List<Hotel> proHoteli = new ArrayList<>();
        if(odabir.equals("All")){
        for(int i = 0; i < Hoteli.size(); i++)
        {
           
            if(Hoteli.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()) ||
                    Hoteli.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()) || 
                     Hoteli.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()) ||
                     Hoteli.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
            {
                proHoteli.add(Hoteli.get(i));
            }
           
        }
        }
        else if(odabir.equals("Company name")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Contact person")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Address")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("City")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Country")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("E-mail")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Fax")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Web")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        else if(odabir.equals("Mobile phone")){
            for(int i = 0; i < Hoteli.size(); i++)
            {
                if(Hoteli.get(i).getMob().toUpperCase().contains(referenca.toUpperCase()))
                {
                    proHoteli.add(Hoteli.get(i));
                }
            }
        }
        return proHoteli;
    }
	
	public List<Arhitektonske_tvrtka> dohvatiArhTvrtku(String referenca,String odabir)
	{
		List<Arhitektonske_tvrtka> proArhTvrtke = new ArrayList<>();
		 if(odabir.equals("All")){
		for(int i=0;i<ArhTvrtke.size();i++)
		{
			if(ArhTvrtke.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()) || 
					ArhTvrtke.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()) ||  
					ArhTvrtke.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()) ||
					ArhTvrtke.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
			{
				proArhTvrtke.add(ArhTvrtke.get(i));
			}
		}
	 }
		  else if(odabir.equals("Company name")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Contact person")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Address")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(Hoteli.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("City")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Country")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("E-mail")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Phone")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Phone")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Fax")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Web")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Mobile phone")){
	            for(int i = 0; i < ArhTvrtke.size(); i++)
	            {
	                if(ArhTvrtke.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                	proArhTvrtke.add(ArhTvrtke.get(i));
	                }
	            }
	        }
		 
		return proArhTvrtke;
	}
	
	public List<Distributer> dohvatiDistributera(String referenca,String odabir)
	{
		List<Distributer> proDistributeri = new ArrayList<>();
		if(odabir.equals("All")){
			for(int i=0;i<distributeri.size();i++)
			{
				if(distributeri.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()) || 
						distributeri.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()) ||  
						distributeri.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()) ||
						distributeri.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
				{
					proDistributeri.add(distributeri.get(i));
				}
			}
		}
			else if(odabir.equals("Company name")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Contact person")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Address")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("City")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Country")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("E-mail")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Phone")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Phone")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Fax")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Web")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
	        else if(odabir.equals("Mobile phone")){
	            for(int i = 0; i < distributeri.size(); i++)
	            {
	                if(distributeri.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
	                {
	                    proDistributeri.add(distributeri.get(i));
	                }
	            }
	        }
		
		
		return proDistributeri;
	}
	
	public List<Izlozbeni_prostor> dohvatiIzlozbeni_Prostor(String referenca, String odabir)
	{
		List<Izlozbeni_prostor> proIzProstori  = new ArrayList<>();
		if(odabir.equals("All")){
				for(int i=0;i<IzlProstori.size();i++)
				{
					if(IzlProstori.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()) || 
							IzlProstori.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()) ||  
							IzlProstori.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()) ||
							IzlProstori.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
					{
						proIzProstori.add(IzlProstori.get(i));
					}
				}
		}
		else if(odabir.equals("Company name")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Contact person")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Address")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("City")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Country")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("E-mail")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Fax")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Web")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
        else if(odabir.equals("Mobile phone")){
            for(int i = 0; i < IzlProstori.size(); i++)
            {
                if(IzlProstori.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzProstori.add(IzlProstori.get(i));
                }
            }
        }
		return proIzProstori;
	}
	
	public List<Izvodac> dohvatiIzvodjaca(String referenca, String odabir)
	{
		List<Izvodac> proIzvodjaci  = new ArrayList<>();
		if(odabir.equals("All")){
			for(int i=0;i<izvodjaci.size();i++)
			{
				if(izvodjaci.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()) || 
						izvodjaci.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()) ||  
						izvodjaci.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()) ||
						izvodjaci.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
				{
					proIzvodjaci.add(izvodjaci.get(i));
				}
			}
		}
		else if(odabir.equals("Company name")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getNaziv().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Contact person")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getKontaktOsoba().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Address")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getAdresa().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("City")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getGrad().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Country")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getDrzava().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("E-mail")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getEmail().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Phone")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getTelefon().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Fax")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getFax().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Web")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getWeb().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
        else if(odabir.equals("Mobile phone")){
            for(int i = 0; i < izvodjaci.size(); i++)
            {
                if(izvodjaci.get(i).getMobitel().toUpperCase().contains(referenca.toUpperCase()))
                {
					proIzvodjaci.add(izvodjaci.get(i));
                }
            }
        }
		return proIzvodjaci;
	}
	
}
