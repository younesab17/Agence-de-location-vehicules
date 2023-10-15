package gestio_park;

import java.util.ArrayList;
import java.util.*;
public class loc_encours {
private ArrayList<location> liste_loc ;
/*constructeur*/
public loc_encours() {
	 liste_loc = new ArrayList<location>();
	 
}
public static boolean isNumeric1(String ch)
{
	boolean b = true;
        try {
            Float f = Float.parseFloat(ch);
        } catch (NumberFormatException e) {
            b = false;
        }
        return b;
}
public static boolean isAlpha(String s)
{
	if (s == null) {
		return false;
	}

	for (int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')&&(c!=' ')) {
			return false;
		}
	}
	return true;
}
static Scanner s=new Scanner(System.in);

public void ajouter_l(parc p) {
	
	/*affichage des vehicules disponibles pour le choix*/
	p.afficher_dispo();
	if(p.nbrdispo()==0) /*cas d'inexistance des vehicules disponibles*/
		System.out.println("Merci de visiter notre agence , a un autre service :))  !!!!");
	else if(p.nbrdispo()!=0) {
	 String cc="";int k=0; int occ=-1;
	do{
			System.out.println("Donner la matricule de la vehicule que vous voulez le louer ::");
		        cc=s.next();
		    
		    if((cc.length()!=5)||(isNumeric1(cc)==false))
				System.out.println("il faut 5 chiffres pour la matricule !!!");
		    
		    
		    for(int i=0;i<p.liste_rech.size();i++)
		    {   /*verification d'existance de vehicule par occ*/
		    	if(p.liste_rech.get(i).getmat().equals(cc))
		    		occ=i;
		    }
		    if(occ==-1) 
		    	System.out.println("cette matricule n'existe pas");
		    else {   /*verification d'etat de vehicule est qu'il est dispo ou non*/
			          if((p.liste_rech.get(occ).getmat().equals("loue"))||(p.liste_rech.get(occ).getmat().equals("enrepartition"))) {
			        	  System.out.println("cette matricule ne correspond pas a une vehicule diponible!!!");
			        	  k=1;
			                      }
		          }
	                
		                  }while((cc.length()!=5)||(isNumeric1(cc)==false)||(occ==-1)||(k==1));

	    
			/*dans le cas ou le choix est valide : changement d'etat à l'etat loue*/
  p.liste_rech.get(occ).setetat("loue");
  vehicule v=new vehicule(p.liste_rech.get(occ).getmat(),p.liste_rech.get(occ).geconstructeur(),p.liste_rech.get(occ).getmarque(),p.liste_rech.get(occ).getetat());
			                 
	    String ch1="",ch2="",ch3="",ch4="";
		/*demande des infos du client*/
	    do{ 
			System.out.println("donner la CIN du client");
			ch1=s.next();
			if((ch1.length()!=8)||(isNumeric1(ch1)==false))
				System.out.println("il faut 8 chiffres pour la CIN !!!");
		}while((ch1.length()!=8)||(isNumeric1(ch1)==false));
		
		
		do{
			System.out.println("donner le nom du client");
			ch2=s.next();
			if (isAlpha(ch2)==false)
				System.out.println("il faut un nom alphabetique !!!");
		}while(isAlpha(ch2)==false);
		
		
		do{
			System.out.println("donner le prenom du client");
			ch3=s.next();
			if (isAlpha(ch3)==false)
				System.out.println("il faut un prenom alphabetique !!!");
		}while(isAlpha(ch3)==false);
		
		
		do{
			System.out.println("donner adresse du client");
			ch4=s.next();
			if (isAlpha(ch4)==false)
				System.out.println("il faut une adresse alphabetique !!!");
		}while(isAlpha(ch4)==false);
           /*construction d'une instance client*/
	       client c=new client(ch1,ch2,ch3,ch4);
	       
	       /*demande des autres info pour la location*/
	       date d1=new date();
	       date d2=new date();
	       do {
	    	System.out.println("donner la date du debut de location ");   
	   		d1.saisie_d();
	   		System.out.println("donner la date du fin de location");
	   		d2.saisie_d();
	   		if(d1.ordre(d2)==false)
	   			System.out.println("date fin doit etre sup a date debut");
	   	}while(d1.ordre(d2)==false);

        double prix_tot,avance;
	   	do {
	   		System.out.println("donner le montant de la location ::");
	   		prix_tot=s.nextFloat();
	   		if(prix_tot<=100)
	   			System.out.println("Impossible que le montant soit inferieur a 100 dt !!!!!");
	   		}while(prix_tot<=100);


	   	do {
	   		System.out.println("donner le montant de l avance donnee par le client ::");
	   		avance=s.nextFloat();
	   		if(avance<(prix_tot*0.2))
	   			System.out.println("Avance doit etre superieur a 20 % du prix total!!!!!");
	   		}while(avance<(prix_tot*0.2));


	           location l=new location(v,c,d1,d2,prix_tot,avance);
	           liste_loc.add(l);
	           System.out.println("Ajout fait avec succes !!!");	            
 }
	           

}
public void supprimer(loc_historique l1,parc p) {
Location_h loc;
date d_retour=new date();
int indice;
afficher();/*affichage des locations pour le choix*/
System.out.println("donner l'indice de la location a supprimer");/*le choix du location a supprimer*/
indice=s.nextInt()-1;
/*stockage des attributs de location a supprimer*/
vehicule v1=liste_loc.get(indice).getvehicule();
client c1=liste_loc.get(indice).getclient();
date d1=liste_loc.get(indice).getdate_debut();
date d2=liste_loc.get(indice).getdate_fin();


int x;
do{/*precisition de l'etat de retour*/
	System.out.println("merci de choisir l'etat de retour de la vehicule");
	System.out.println("0 ==> en bonne ");
	System.out.println("1 ==> en mauvaise ");
	x=s.nextInt();
	if((x!=0)&&(x!=1))
	 System.out.println("choix invalide !!!!");
	}while((x!=0)&&(x!=1));
int y;/*demande de date de retour pour preciser s'il y a un retard ou non en le comparent par la date 
            du fin de location*/
 System.out.println("merci de saisir la date de retour");
	d_retour.saisie_d();
if(d2.ordre(d_retour))
 y=1;
else 
 y=0;
loc=new Location_h(v1,c1,d1,d2,liste_loc.get(indice).getprix_tot(),liste_loc.get(indice).getavance(),y,x);
for(int i=0;i<p.liste_rech.size();i++) {
	if(loc.getvehicule().getmat().equals(p.liste_rech.get(i).getmat()))
	  { if(loc.getretour()==1)
			p.liste_rech.get(i).setetat("enreparation");
		else
			p.liste_rech.get(i).setetat("enraparation"); }
}
l1.ajouter(loc);
liste_loc.remove(indice);
System.out.println("Suppression faite avec succes , cette location est mise a l'archive");
}


public void loue_par_client(loc_historique l1){
parc k=new parc();
String ch="";
do{
			System.out.println("donner la CIN du client");
			ch=s.next();
			if((ch.length()!=8)||(isNumeric1(ch)==false))
				System.out.println("il faut 8 chiffres pour la CIN !!!");
		}while((ch.length()!=8)||(isNumeric1(ch)==false));
for(int i=0;i<liste_loc.size();i++){
if(liste_loc.get(i).getclient().getcin().equals(ch))
 k.liste_rech.add(liste_loc.get(i).getvehicule());}

for(int i=0;i<l1.liste_hist.size();i++){
if(l1.liste_hist.get(i).getclient().getcin().equals(ch))
 k.liste_rech.add(l1.liste_hist.get(i).getvehicule());}

if(k.liste_rech.isEmpty())
  System.out.println("ce client n'a pas loue aucune vehicule de notre agence");
else
{System.out.println("les vehicules loues par "+ch+"sont les suivantes ::");
k.afficher();
}
}



public void nbrlocs(loc_historique l1){
date d1=new date();
date d2=new date();/*demande des deux dates : les extremites de la periode*/
System.out.println("merci d'entrer la date du debut de periode ");
d1.saisie_d();
System.out.println("merci d'entrer la date de la fin de periode ");
d2.saisie_d();
int nbr=0; /*parcours de locations courantes pour compter le nombre de loc dans cette periode*/
for(int i=0;i<liste_loc.size();i++){
if((liste_loc.get(i).getdate_debut().between(d1,d2))||(liste_loc.get(i).getdate_fin().between(d1,d2)))
  nbr++;
}
for(int i=0;i<l1.liste_hist.size();i++){/*parcours de locations archivés pour compter
                                         le nombre de loc dans cette periode*/
if((l1.liste_hist.get(i).getdate_debut().between(d1,d2))||(l1.liste_hist.get(i).getdate_fin().between(d1,d2)))
  nbr++;
}
System.out.println("dans cette periode l'agence a effectue "+nbr+" locations");
}



public void revenuelocs(loc_historique l1){
date d1=new date();
date d2=new date();
System.out.println("merci d'entrer la date du debut de periode ");
d1.saisie_d();
System.out.println("merci d'entrer la date de la fin de periode ");
d2.saisie_d();
double revenue=0;
for(int i=0;i<liste_loc.size();i++){ /*parcours de locations courantes pour calculer
                                             la revenue de loc dans cette periode*/
if((liste_loc.get(i).getdate_debut().between(d1,d2))||(liste_loc.get(i).getdate_fin().between(d1,d2)))
  revenue=revenue+liste_loc.get(i).getprix_tot();
}
for(int i=0;i<l1.liste_hist.size();i++){ /*parcours de locations archivés pour calculer
                                            la revenue de loc dans cette periode*/
if((l1.liste_hist.get(i).getdate_debut().between(d1,d2))||(l1.liste_hist.get(i).getdate_fin().between(d1,d2)))
  revenue=revenue+l1.liste_hist.get(i).getprix_tot();
}
System.out.println("dans cette periode l'agence a fait comme chiffre d'affaires : "+revenue+" DT");
}

/*affichage des locations*/

public void afficher() {
	if(liste_loc.isEmpty())
		System.out.println("il n y a aucune location ");
	else {
	for(int i=0;i<liste_loc.size();i++)
	{ System.out.println(i+1+")");
		liste_loc.get(i).afficher_l();
		System.out.println(""); }
}
}
}
