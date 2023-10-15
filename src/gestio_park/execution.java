package gestio_park;
import java.util.*;
public class execution {
 
	
	static Scanner s=new Scanner(System.in);

	public static void gestion_parc(loc_historique l1,loc_encours l,parc p) {
		int ch;
		 //choix d'operation a effectuer
		 System.out.println("::Gestion du parc de l agence::");
		 System.out.println("1. Nouvelle acquisition   (Ajout d un vehicule");
		 System.out.println("2. Modification de l Etat d un Vehicule");
		 System.out.println("3. Suppression d un Vehicule");
		 System.out.println("4. Consultation Parc  (tous les vehicules)");
		 System.out.println("5. Liste des vehicules loues");
		 System.out.println("6. Liste des vehicules en cours de reparation");
		 System.out.println("7. Liste des vehicules disponibles");
		 System.out.println("8. Retour menu principal");
		do {
			System.out.println("Merci de choisir la procedure a acceder ");
			ch=s.nextInt();//controle saisie du choix
			 if((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4)&&(ch!=5)&&(ch!=6)&&(ch!=7)&&(ch!=8))
					System.out.println("choix invalide !!! ");
		}while((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4)&&(ch!=5)&&(ch!=6)&&(ch!=7)&&(ch!=8));
		 if(ch==1)
		 { p.ajouter();
	     System.out.println("");
		 gestion_parc(l1,l,p);  
		 }
		  
		 if(ch==2)
		 { p.modifier();
	     System.out.println("");
		 gestion_parc(l1,l,p);  //rappel au menu pour pouvoir continuer dans le programme
		 }
			
		 if(ch==3)
		 { p.supprimer();
	     System.out.println("");
		 gestion_parc(l1,l,p);  
		 }
		 if(ch==4)
		  {p.afficher();
		     System.out.println("");
		  gestion_parc(l1,l,p);  
		  }
		 if(ch==5)
		 { p.afficher_loue();
	     System.out.println("");
		 gestion_parc(l1,l,p);  
		 }
		 if(ch==6)
		 {   p.afficher_encours();
	     System.out.println("");
		 gestion_parc(l1,l,p);  
			 } 
		 if(ch==7)
		 { p.afficher_dispo();
	     System.out.println("");
		 gestion_parc(l1,l,p);  
		 }
		 if(ch==8)
			 {menu(l1,l,p);
		     System.out.println("");
}
	     	
	    	 	
	 }
	 
	 public static void gestion_location(loc_historique l1,loc_encours l,parc p) {
		int ch;
		 //choix d'operation a effectuer

		 System.out.println("Gestion locations");
		 System.out.println("1. Nouvelle Location (Ajout d une location)");
		 System.out.println("2. Fin de Location (Suppression)");
		 System.out.println("3. Consultation des locations en cours");
		 System.out.println("4. Consultation des locations archives");
		 System.out.println("5. Consultation des Vehicules Loues par un client");
		 System.out.println("6. Retour menu principal");
		 do {
			 System.out.println("Merci de choisir la procedure a acceder ");
			 ch=s.nextInt();//controle saisie du choix
			 if((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4)&&(ch!=5)&&(ch!=6))
					System.out.println("choix invalide !!! ");
		 }while((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4)&&(ch!=5)&&(ch!=6));
		 if(ch==1)
		 { l.ajouter_l(p);
	     System.out.println("");
		 gestion_location(l1,l,p);
		 }
		 if(ch==2)
		 {   l.supprimer(l1,p); 
	     System.out.println("");
			 gestion_location(l1,l,p);} //rappel au menu pour pouvoir continuer dans le programme}
		 if(ch==3)
			 {l.afficher();
		     System.out.println("");
			 gestion_location(l1,l,p);
			 }
		 if(ch==4)
		 {  l1.afficher();
		     System.out.println("");
			 gestion_location(l1,l,p);
		 }
		 if(ch==5)
		 {   l.loue_par_client(l1);
	     System.out.println("");
		 gestion_location(l1,l,p);
		 }
		 if(ch==6)
		 { System.out.println("");
			 menu(l1,l,p);
			 }
		 
		
	 }
	 
	 public static void stat(loc_historique l1,loc_encours l,parc p) {
		 int ch;
		 //choix d'operation a effectuer

		 System.out.println("Statistiques");
		 System.out.println("1. Nombre de locations pour une periode determinee");
		 System.out.println("2. Total des revenus pour une periode determinee");
		 System.out.println("3. Liste des clients a risque (Retard / mauvais etat de vehicules rendus)");
		 System.out.println("4. Retour menu principal");
		 do { //controle saisie du choix
			 System.out.println("Merci de choisir la procedure a acceder ");
			 ch=s.nextInt();
			 if((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4))
					System.out.println("choix invalide !!! ");
		 }while((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4));
		 if(ch==1)
		 { l.nbrlocs(l1);
	     System.out.println("");
		 stat(l1,l,p);
		 }
		 if(ch==2)
		 {   l.revenuelocs(l1); 
		     System.out.println("");
		     l1.afficher();
		     stat(l1,l,p);} //rappel au menu pour pouvoir continuer dans le programme}
		 if(ch==3)
			 {l1.sanctions();
		     System.out.println("");
			 stat(l1,l,p);
			 }
		 if(ch==4)
			 {System.out.println("");
			 menu(l1,l,p);
		     System.out.println("");}
	 }	
	
	 
		public static void menu(loc_historique l1,loc_encours l,parc p) {
			int ch;
			
			
			do {
				System.out.println(" 1// Gestion du parc de l'agence ");
				System.out.println(" 2// Gestion locations");
				System.out.println(" 3// Statistiques");
				System.out.println(" 4// Quitter");
				
				System.out.println("Merci de choisir le menu a acceder ");
				
                ch=s.nextInt();
              //controle saisie du choix
				if((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4))
					System.out.println("choix invalide !!! ");
			}while((ch!=1)&&(ch!=2)&&(ch!=3)&&(ch!=4));
			
			 if(ch==1) 
				 gestion_parc(l1,l,p);
			 if(ch==2) 
				 gestion_location(l1,l,p);
			 if(ch==3) 
				 stat(l1,l,p);
			 if(ch==4)
				 System.out.println("Merci pour consulter notre application !!");
			 	 
		}
	
		public static void main(String[]args) { 
			parc p=new parc();
			loc_encours l=new loc_encours();
			loc_historique l1=new loc_historique();
			menu(l1,l,p);}
		
			
	 }	
	
	 
 

