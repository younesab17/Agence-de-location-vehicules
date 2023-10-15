package gestio_park;
import java.util.Scanner;
import java.util.ArrayList;

public class parc {
	ArrayList<vehicule> liste_rech ; 
	
	/*constructeur du parc */

public parc() {
		 liste_rech = new ArrayList<vehicule>();
		 
}
/*une fonction de verification que la chaine entrée est purement numérique*/
public static boolean isNumeric(String s)
{
	boolean b = true;
        try {
            Float f = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            b = false;
        }
        return b;
}
/*une fonction de verification que la chaine entrée est purement alphabétique*/

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
/*une fonction de verification que la chaine entrée est alphanumérique*/

public static boolean isAlphaNum(String s) {
	 return s != null && s.matches("^[a-zA-Z0-9]*$");
}
/*une fonction de verification que l'etat est valide */

public static boolean isEtat(String s)
{
    

    if((s.equals("disponible"))||(s.equals("loue"))||(s.equals("enreparation")))
    return true;
   else 
    return false;
}
/*une methode qui afficher l'ensemble des véhicules du parc*/

public void afficher() {
	if(liste_rech.size()==0)/*cas du parc vide*/
		System.out.println("il n'y a aucune vehicule ");
	else {
System.out.println("Ceci est la liste des vehicules ::");
for(int i=0;i<liste_rech.size();i++) {
	System.out.println(i+1+")"); liste_rech.get(i).afficher_v();}	    
}
}
static Scanner s=new Scanner(System.in);



public void ajouter() {
	String ch1="",ch2="",ch3="",ch4="";
 /*demande des differents attributes d'une vehicule avec ses controls saisies*/ 
 do{
		System.out.println("donner la matricule de la vehicule");
	    ch1=s.next();
	
	if((ch1.length()!=5)||(isNumeric(ch1)==false))
		System.out.println("il faut 5 chiffres pour la matricule !!!");
	 
		
	                  }while((ch1.length()!=5)||(isNumeric(ch1)==false));
 do{
		System.out.println("donner le constructeur de la vehicule");
		ch2=s.next();
		if (isAlpha(ch2)==false)
			System.out.println("il faut constructeur alphabetique !!!");
		    
	}while(isAlpha(ch2)==false);
	do{
		System.out.println("donner la marque de la vehicule");
		ch3=s.next();
		if (isAlphaNum(ch3)==false)
			System.out.println("il faut que marque ne contienne que des chiffres ou alphabets  !!!");
		    
	}while(isAlphaNum(ch3)==false);

	do {	
	System.out.println("donner l'etat de la vehicule");
	ch4=s.next();
	if (isEtat(ch4)==false)
		System.out.println("il faut etat entre ''disponible'' et ''loué'' et ''en cours de reparation'' ");
	}while(isEtat(ch4)==false);
	
	if(liste_rech.size()>0) {
	
		/* vérifier si la vehicule saisie a une matricule déjà existante dans le par ou non*/
		int occurence=0;
	for(int i=0;i<liste_rech.size();i++) 
		{if(liste_rech.get(i).getmat().equals(ch1))
			occurence++;}
	/* cas de matricule existante*/

             if(occurence>0)
           
                 System.out.println("cette matricule est deja existante !!!!");

          else {
        	  /*insertion du vehicule dans le cas d'inexistance du vehicule*/

			vehicule v=new vehicule(ch1,ch2,ch3,ch4);
			liste_rech.add(v);
			System.out.println("Ajout fait en succes !!");
		     }
	}
	else
	{
		vehicule v=new vehicule(ch1,ch2,ch3,ch4);
		liste_rech.add(v);
		System.out.println("Ajout fait en succes !!");	
	}
	
          
	
   
}


public void afficher_loue() {
	
/*affichages des vehicules donc l'etet est loué*/	
	if(liste_rech.size()==0)
		System.out.println("il n'y a aucune vehicule ");
	else { int nbr=0;
			for(int i=0;i<liste_rech.size();i++)
			{ if(liste_rech.get(i).getetat().equals("loue"))
				nbr++;
			}
			if(nbr==0)
				System.out.println("il n'y a aucune vehicule loue ");
			else { 
				System.out.println("Ceci est la liste des vehicules loues ");
				for(int i=0;i<liste_rech.size();i++)
				{ if(liste_rech.get(i).getetat().equals("loue"))
					System.out.println(i+1+")");liste_rech.get(i).afficher_v();
				}
		          
			}

}
}

public void afficher_dispo() {
	
	/*affichages des vehicules donc l'etet est disponible*/
	
	if(liste_rech.size()==0)
		System.out.println("il n'y a aucune vehicule ");
	else { int nbr=0;
			for(int i=0;i<liste_rech.size();i++)
			{ if(liste_rech.get(i).getetat().equals("disponible"))
				nbr++;
			}
			if(nbr==0)
				System.out.println("il n'y a aucune vehicule disponible ");
			else { 
				System.out.println("Ceci est la liste des vehicules disponibles ");
				for(int i=0;i<liste_rech.size();i++)
				{ if(liste_rech.get(i).getetat().equals("disponible"))
				System.out.println(i+1+")");liste_rech.get(i).afficher_v();
				}
		          
			}

}
}

public void afficher_encours() {
	
	/*affichages des vehicules donc l'etet est est en cours de reparation*/	
	
	if(liste_rech.size()==0)
		System.out.println("il n'y a aucune vehicule ");
	else { int nbr=0;
			for(int i=0;i<liste_rech.size();i++)
			{ if(liste_rech.get(i).getetat().equals("enreparation"))
				nbr++;
			}
			if(nbr==0)
				System.out.println("il n'y a aucune vehicule en cours de raparation ");
			else { 
				System.out.println("Ceci est la liste des vehicules en cours de raparation ");
				for(int i=0;i<liste_rech.size();i++)
				{ if(liste_rech.get(i).getetat().equals("enreparation"))
					System.out.println(i+1+")");liste_rech.get(i).afficher_v();
				}
		          
			}

}
}
/*methode qui retourne le nombre des vehicules disponibles*/
public int nbrdispo() {
	int nbr=0;
	if(liste_rech.isEmpty()==false) 
	
	{
			for(int i=0;i<liste_rech.size();i++)
			{ if(liste_rech.get(i).getetat().equals("disponible"))
				nbr++;
			}
			
         }
	return nbr;
}




public void supprimer () { 
	/*suppression d'une vehicule du parc en demandant ces criteres*/ 
	 
	
	
	if(liste_rech.size()==0)
		System.out.println("il n'y a aucune vehicule ");
	else {
		Scanner s=new Scanner (System.in);
		String ch1="";
		do{
			System.out.println("donner la matricule de la vehicule");
		ch1=s.nextLine();
		
		if(ch1.length()!=5)
			System.out.println("il faut 5 chiffres pour la matricule");
		if (isNumeric(ch1)==false)
			System.out.println("il faut matricule numerique");
		                  }while((ch1.length()!=5)&&(isNumeric(ch1)==false));
		
		int indice=-1;
		/* verifier son existance avant sa suppression*/
		for(int i=0;i<liste_rech.size();i++) {
			if(ch1.equals(liste_rech.get(i).getmat()))
                         indice=i;	}
		
	       if (indice!=-1)/*cas d'existance du vehicule*/
	       { liste_rech.remove(indice);
	       System.out.println("Supression faite avec succes !!");}
	       
	      else  /*cas d'inexistance du vehicule*/
				
				System.out.println("cette matricule est inexistante");
	}
			
		}
		
	


public void modifier() {
	if(liste_rech.size()==0)/*cas du parc vide*/
		System.out.println("il n'y a aucune vehicule ");
	else {
		Scanner s=new Scanner (System.in);
		String ch1="";/*demande de matricule du vehicule a modifier son etat*/
		do{ 
			System.out.println("donner la matricule de la vehicule");
		ch1=s.nextLine();
		
		if(ch1.length()!=5)
			System.out.println("il faut 5 chiffres pour la matricule");
		if (isNumeric(ch1)==false)
			System.out.println("il faut matricule numerique");
		                  }while((ch1.length()!=5)&&(isNumeric(ch1)==false));
		
		String ch2="";
		do{ /*demande de nouvelle etat*/
			System.out.println("donner la nouvelle etat de la vehicule");
		    ch2=s.nextLine();
		    if (isEtat(ch2)==false)
				System.out.println("il faut etat entre ''disponible'' et ''loué'' et ''en cours de reparation'' ");
		                  }while(isEtat(ch2)==false);
		/*modification de l'etat*/
		for(int i=0;i<liste_rech.size();i++) {
			if(ch1.equals(liste_rech.get(i).getmat()))
				{ 
				liste_rech.get(i).setetat(ch2);
				System.out.println("Modification faite avec succes");
				}		
	}
		
	}

}
}


