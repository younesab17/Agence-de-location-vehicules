package gestio_park;
import java.util.*;
public class loc_historique {
	protected ArrayList<Location_h> liste_hist ;
	

	public loc_historique() {
		 liste_hist = new ArrayList<Location_h>();
		
	}
	public void ajouter(Location_h a) {
		liste_hist.add(a);
		
	}
	public void afficher() {
		System.out.println("Archive des locations ");
		for(int i=0;i<liste_hist.size();i++) {
			System.out.println(i+1+")");
			liste_hist.get(i).afficher_l();
			System.out.println("");
		}
	}
	
	public void sanctions() {
		ArrayList<client> c1=new ArrayList<>();// une liste de des client pour les clients sanctionnes
		
		for(int i=0;i<liste_hist.size();i++) {/*parcours de liste des locations archives et
			                                  recherche d'un cas de retard ou mauvaise etet du retour*/ 
			
			if((liste_hist.get(i).getretard()==1)||(liste_hist.get(i).getretour()==1))
				c1.add(liste_hist.get(i).getclient());
		}
		if(c1.isEmpty())
			System.out.println("Aucun client ne sera sanctionne !! ");
		else {//affichage des sanctionés dans le cas d'existance d'un retard ou mauvaise etat du retour
			for(int i=0;i<c1.size();i++)
				c1.get(i).afficher_c(); }
	}
}
