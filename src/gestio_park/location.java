package gestio_park;

public class location {
private vehicule v;
private client c;
private date date_debut;
private date date_fin;
private double prix_tot ;
private double avance ;
/*constructeur*/
public location(vehicule v,client c,date d1,date d2,double x,double y) {
	this.v=v;
	this.c=c;
	this.date_debut=d1;
	this.date_fin=d2;
	this.prix_tot=x;
	this.avance=y;	
}
/*affichage d'une location */

public void afficher_l() {
	System.out.println("vehicule ::   ");
	v.afficher_v();
	System.out.print("Client ::   ");
	c.afficher_c();
	System.out.println("date debut location  ::  ");
	date_debut.afficher_d();
	System.out.println("date fin location  ::    ");
	date_fin.afficher_d();
	System.out.println("Montat total a payer  ::    "+prix_tot);
	System.out.println("avance  ::   "+avance);
}

/*les getters et les setters*/
public  vehicule getvehicule() {
	return v;
}
public  client getclient() {
	return c;
}
public  double getavance() {
	return avance;
}
public  double getprix_tot() {
	return prix_tot;
}
public  date getdate_debut() {
	return date_debut;
}
public  date getdate_fin() {
	return date_fin;
}


public void setvehicule(vehicule v) {
	this.v=v;
}
public void setclient(client c) {
	this.c=c;
}
public void setdate_debut(date d) {
	this.date_debut=d;
}
public void setdate_fin(date d) {
	this.date_debut=d;
}
public void setavance(double y) {
	this.avance=y;
}
public void setprix_tot(double y) {
	this.prix_tot=y;
}

}
