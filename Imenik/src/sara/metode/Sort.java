package sara.metode;

import java.util.Collections;
import java.util.List;

import sara.klase.Arhitektonske_tvrtka;
import sara.klase.Distributer;
import sara.klase.Hotel;
import sara.klase.Izlozbeni_prostor;
import sara.klase.Izvodac;

public class Sort {

	
	public static void sortirajHotele(List<Hotel> listaHotela)
	{
		Collections.sort(listaHotela, (p1,p2) -> p1.getNaziv().toUpperCase().
				compareTo(p2.getNaziv().toUpperCase()));
	}
	
	public static void sortirajArhTvrtke(List<Arhitektonske_tvrtka> listaArhTvrtki)
    {
        Collections.sort(listaArhTvrtki, ( p1,  p2) -> p1.getNaziv().toUpperCase().
        		compareTo(p2.getNaziv().toUpperCase()));

    }
    
    public static void sortirajIzlozbeneProstore(List<Izlozbeni_prostor> listaIzlozbenihProstora)
    {
        Collections.sort(listaIzlozbenihProstora, ( p1,  p2) -> p1.getNaziv().toUpperCase().
        		compareTo(p2.getNaziv().toUpperCase()));

    }
    
    public static void sortirajIzvodace(List<Izvodac> listaIzvodaca)
    {
        Collections.sort(listaIzvodaca, ( p1,  p2) -> p1.getNaziv().toUpperCase().
        		compareTo(p2.getNaziv().toUpperCase()));

    }
    
    public static void sortirajDistributere(List<Distributer> listaDistributera)
    {
        Collections.sort(listaDistributera, ( p1,  p2) -> p1.getNaziv().toUpperCase().
        		compareTo(p2.getNaziv().toUpperCase()));

    }
	
}
