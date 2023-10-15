package gestio_park;

public class Location_h extends location {//heritage de classe ''location'' avec deux attributs de plus
  
  private int retard;
  private int retour;
  public Location_h(vehicule v,client c,date d1,date d2,double x,double y,int a,int b) {
	  super(v,c,d1,d2,x,y);
	  retard=a;
	  retour=b;
  }
  //redifinition de la methode d'affichage
  public void afficher_l() {
		super.afficher_l();
		if(retard==0)
			System.out.println("retourne sans retard");
		else
			System.out.println("retourne avec retard");
		if(retour==0)
			System.out.println("retourne en bonne etat");
		else
			System.out.println("retourne en mauvaise etat");
		
	}
  
  
  public void setretard(int x) {
	  this.retard=x;
  }
  public void setretour(int x) {
	  this.retour=x;
  }
  public int getretour() {
	  return retour;
  }
  public int getretard() {
	  return retard;
  }
}
