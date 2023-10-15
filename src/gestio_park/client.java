package gestio_park;
import java.util.*;
public class client {
private String cin;
private String nom;
private String prenom;
private String adresse;

static Scanner s=new Scanner(System.in);
/*constructeur de classe client*/
public client(String ch1,String ch2,String ch3,String ch4){
	this.cin=ch1;
	this.nom=ch2;
	this.prenom=ch3;
	this.adresse=ch4;
}


public void afficher_c() {
System.out.println(" CIN : "+cin+" nom&prenom : "+nom+" "+prenom+" adresse : "+ adresse);
}
public String getcin() {
	return cin;
}

}
