package gestio_park;
import java.util.*;
public class date {
	private int jj;
	private int mm;
	private int aaaa;
 
	public date() {
	 jj=0;
	 mm=0;
	 aaaa=0;
                   }
	
	static Scanner s=new Scanner(System.in);
	
	public void saisie_d() {
		do{
			System.out.println("donner le jour ");
			jj=s.nextInt();
			if((jj<1)||(jj>31))
				System.out.println("il faut que le jour soit entre 1 et 31 !!!");
		}while((jj<1)||(jj>31));
	do{
			System.out.println("donner le mois ");
			mm=s.nextInt();
			if((mm<1)||(mm>12))
				System.out.println("il faut que le mois soit entre 1 et 12 !!!");
		}while((mm<1)||(mm>12));
	do{
			System.out.println("donner l annee ");
			aaaa=s.nextInt();
			if((aaaa<2022)||(jj>2023))
				System.out.println("il faut que l annee soit entre 2022 et 2023 !!!");
		}while((aaaa<2022)||(aaaa>2023));
	}
	
	
	
	public void afficher_d() {
	   System.out.println(jj+"/"+mm+"/"+aaaa);
   }
	
	
   public boolean between (date d1,date d2) {
	   
		if((ordre(d1)==false)&&(ordre(d2)==true))	
			return true;
		else
			return false;
   }
   
   
 public boolean ordre(date d1) {
	 if((d1.aaaa>aaaa)||((d1.aaaa==aaaa)&&(d1.mm>mm))||((d1.aaaa==aaaa)&&(d1.mm==mm)&&(d1.jj>jj)))
		 return true;
	 else 
		 return false;

 }
}
