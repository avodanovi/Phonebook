package sara.klase;

import java.io.Serializable;

public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String naziv;
	private String kontaktOsoba;
	private String adresa;
	private String drzava;
	private String grad;//sadrzi naziv grada i postanski broj(10000 Zagreb)
	private String email;
	private String telefon;
	private String fax;
	private String web;
	private String mob;
		
	
	public Hotel(String naziv,String kontaktOsoba,String adresa,String drzava,
			String grad, String email,String telefon,String fax,String web,String mob)
	{
		this.naziv=naziv;
		this.kontaktOsoba=kontaktOsoba;
		this.adresa=adresa;
		this.drzava=drzava;
		this.grad=grad;
		this.email=email;
		this.telefon=telefon;
		this.fax=fax;
		this.web=web;
		this.mob=mob;
	}
	public String getNaziv()
	{
		return naziv;
	}

	public void setNaziv(String naziv)
	{
		this.naziv = naziv;
	}

	public String getKontaktOsoba() 
	{
		return kontaktOsoba;
	}

	public void setKontaktOsoba(String kontaktOsoba)
	{
		this.kontaktOsoba = kontaktOsoba;
	}

	public String getAdresa()
	{
		return adresa;
	}

	public void setAdresa(String adresa) 
	{
		this.adresa = adresa;
	}

	public String getDrzava() 
	{
		return drzava;
	}

	public void setDrzava(String drzava) 
	{
		this.drzava = drzava;
	}

	public String getGrad()
	{ 
		return grad;
	}

	public void setGrad(String grad) 
	{
		this.grad = grad;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) 
	{
		this.telefon = telefon;
	}

	public String getFax() 
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getWeb()
	{
		return web;
	}

	public void setWeb(String web) 
	{
		this.web = web;
	}
	
	public String getMob()
	{
		return mob;
	}

	public void setMob(String mob) 
	{
		this.mob = mob;
	}
	
	@Override
	public String toString()
	{
		/*String format = "%1$-60s %2$60s %3$-60s %4$60s %5$-60s %6$60s %7$-60s %8$60s %9$-60s %10$60s";
		String tmp;
		
		tmp = String.format(format, "Naziv:  "+getNaziv(),"Kontakt osoba:  "+getKontaktOsoba()
		+System.lineSeparator(),
		"Adresa:  "+getAdresa(),"Grad:  "+getGrad()+System.lineSeparator(),"Država:  "+getDrzava()
		,"Email:  "+getEmail()+System.lineSeparator(),
		"Tel:  "+getTelefon(),"Fax:  "+getFax()+System.lineSeparator()
		,"Web stranica:  "+getWeb(),"Mobitel:  "+getMob()+System.lineSeparator());*/
		
		return "Naziv:  "+getNaziv()+System.lineSeparator()+
				"Kontakt osoba:  "+getKontaktOsoba()+System.lineSeparator()+
				"Adresa:  "+getAdresa()+System.lineSeparator()+
				"Grad:  "+getGrad()+System.lineSeparator()+
				"Država:  "+getDrzava()+System.lineSeparator()+
				"Email:  "+getEmail()+System.lineSeparator()+
				"Tel:  "+getTelefon()+System.lineSeparator()+
				"Fax:  "+getFax()+System.lineSeparator()+
				"Web stranica:  "+getWeb()+System.lineSeparator()+
				"Mobitel:  "+getMob()+System.lineSeparator();
		
		
	}
}
