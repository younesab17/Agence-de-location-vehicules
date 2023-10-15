package gestio_park;



public class vehicule {
private String matricule;
private String marque;
private String constructeur;
private String etat;

/*constructeur de la vehicule*/

public  vehicule(String ch1 ,String ch2 ,String ch3,String ch4 ) {
	this.matricule=ch1;
	this.constructeur=ch2;
	this.marque=ch3;
	this.etat=ch4;
	}

	/* une methode qui affiche la véhicule sous une forme déterminé*/
public void afficher_v() {
System.out.println(" matricule : "+matricule+"construit par"+constructeur+" du modele : "+marque+" est d'etat : "+ etat);
}
/*les getters et les setters*/

public String getmat() {
	return matricule;
}
public String getmarque() {
	return marque;
}
public String getetat() {
	return etat;
}
public String geconstructeur() {
	return constructeur;
}
public void setconstruct(String construct) {
	this.constructeur=construct;
}
public void setmat(String mat) {
	this.matricule=mat;
}
public void setmarque(String marque) {
	this.marque=marque;
}
public void setetat(String etat) {
	this.etat=etat;
}
}