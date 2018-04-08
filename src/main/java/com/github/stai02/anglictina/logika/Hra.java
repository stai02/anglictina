package com.github.stai02.anglictina.logika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Hra {

	private Map<String,Slovo> slovnik; // obsahuje zoznam dvojíc slov v hre 
	private List<String> slovnikCeskychSlov;  // zoznam českých slov v slovníku
	private List<String> slovnikAnglickychSlov;	// zoznam anglických slov v slovníku
	private List<String> zoznamCeskychSlov; // 6 českých slov pre aplikáciu
	private List<String> zoznamAnglickychSlov; // 6 anglických slov pre aplikáciu
	private List<String> vysledok;
	public int spravne;
	public int nespravne;
	
	public Hra() {
		spravne = 0;
		nespravne = 0;
		
		vysledok = new ArrayList<String>();
		slovnik = new HashMap<String,Slovo>();
		slovnikAnglickychSlov = new ArrayList<String>();  
		slovnikCeskychSlov = new ArrayList<String>(); 
		zoznamCeskychSlov = new ArrayList<String>();  
		zoznamAnglickychSlov = new ArrayList<String>();  
				
		Slovo oblak = new Slovo("cloud", "oblak","oblak");
		Slovo auto = new Slovo("car", "auto","auto");
		Slovo jablko = new Slovo("apple", "jablko","jablko");
		Slovo hruska = new Slovo("pear", "hruška","hruska");
		Slovo pomaranc = new Slovo("orange", "pomaranč","pomaranc");
		Slovo kvet = new Slovo("flower","kvet","kvet");
		Slovo vtak = new Slovo("bird", "vták","vtak");
		Slovo mrkva = new Slovo("carrot", "mrkva","mrkva");
		Slovo zosit = new Slovo("notebook", "zošit","zosit");
		Slovo ceruzka = new Slovo("pencil", "ceruzka","ceruzka");
		Slovo salka = new Slovo("cup", "šálka","salka");
		Slovo pohar = new Slovo("glass", "pohár","pohar");
		Slovo vidlicka = new Slovo("fork", "vidlička","vidlicka");
		Slovo kniha = new Slovo("book", "kniha","kniha");
		Slovo kolac = new Slovo("cake", "koláč","kolac");
		Slovo sopka = new Slovo("volcano", "sopka","sopka");
		Slovo budik = new Slovo("alarm clock", "budík","budik");
		Slovo liska = new Slovo ("fox", "líška","liska");
				
		slovnik.put(oblak.getPreklad(),oblak);
		slovnik.put(auto.getPreklad(),auto);
		slovnik.put(jablko.getPreklad(),jablko);
		slovnik.put(hruska.getPreklad(),hruska);
		slovnik.put(pomaranc.getPreklad(),pomaranc);
		slovnik.put(kvet.getPreklad(),kvet);
		slovnik.put(vtak.getPreklad(),vtak);
		slovnik.put(mrkva.getPreklad(),mrkva);
		slovnik.put(zosit.getPreklad(),zosit);
		slovnik.put(ceruzka.getPreklad(),ceruzka);
		slovnik.put(salka.getPreklad(),salka);
		slovnik.put(pohar.getPreklad(),pohar);
		slovnik.put(vidlicka.getPreklad(),vidlicka);
		slovnik.put(kniha.getPreklad(),kniha);
		slovnik.put(kolac.getPreklad(),kolac);
		slovnik.put(sopka.getPreklad(),sopka);
		slovnik.put(budik.getPreklad(),budik);
		slovnik.put(liska.getPreklad(),liska);
		
		slovnikCeskychSlov.add("oblak"); 
		slovnikCeskychSlov.add("auto"); 
		slovnikCeskychSlov.add("jablko");
		slovnikCeskychSlov.add("hruska");
		slovnikCeskychSlov.add("pomaranc"); 
		slovnikCeskychSlov.add("kvet"); 
		slovnikCeskychSlov.add("vtak");
		slovnikCeskychSlov.add("mrkva");
		slovnikCeskychSlov.add("zosit");
		slovnikCeskychSlov.add("ceruzka");
		slovnikCeskychSlov.add("salka");
		slovnikCeskychSlov.add("pohar");
		slovnikCeskychSlov.add("vidlicka");
		slovnikCeskychSlov.add("kniha");
		slovnikCeskychSlov.add("kolac");
		slovnikCeskychSlov.add("sopka");
		slovnikCeskychSlov.add("budik");
		slovnikCeskychSlov.add("liska");
		
		slovnikAnglickychSlov.add(oblak.getPreklad());
		slovnikAnglickychSlov.add(auto.getPreklad());
		slovnikAnglickychSlov.add(jablko.getPreklad());
		slovnikAnglickychSlov.add(hruska.getPreklad());
		slovnikAnglickychSlov.add(pomaranc.getPreklad());
		slovnikAnglickychSlov.add(kvet.getPreklad());
		slovnikAnglickychSlov.add(vtak.getPreklad());
		slovnikAnglickychSlov.add(mrkva.getPreklad());
		slovnikAnglickychSlov.add(zosit.getPreklad());
		slovnikAnglickychSlov.add(ceruzka.getPreklad());
		slovnikAnglickychSlov.add(salka.getPreklad());
		slovnikAnglickychSlov.add(pohar.getPreklad());
		slovnikAnglickychSlov.add(vidlicka.getPreklad());
		slovnikAnglickychSlov.add(kniha.getPreklad());
		slovnikAnglickychSlov.add(kolac.getPreklad());
		slovnikAnglickychSlov.add(sopka.getPreklad());
		slovnikAnglickychSlov.add(budik.getPreklad());
		slovnikAnglickychSlov.add(liska.getPreklad());
	}
	
	public void pridajPojem(String meno, String preklad, String diakritika) {
		Slovo slovo = new Slovo(preklad,meno,diakritika);
		slovnik.put(preklad,slovo);
		slovnikAnglickychSlov.add(preklad);
		slovnikCeskychSlov.add(meno);		
	}
	
	public Map<String,Slovo> getSlovnik() {
		return slovnik;		
	}
	
	public String nahodneCeskeSlovo() {
		return slovnikCeskychSlov.get(new Random().nextInt(slovnikCeskychSlov.size()));
			}
	
	public String nahodneAnglickeSlovo() {
		return slovnikAnglickychSlov.get(new Random().nextInt(slovnikAnglickychSlov.size()));
	}
	
	public void vytvorCeskyZoznam() {
		zoznamCeskychSlov.clear();
		do {
			String slovo = nahodneCeskeSlovo();
			if (!zoznamCeskychSlov.contains(slovo)) {
			zoznamCeskychSlov.add(slovo);
			}
		} while (zoznamCeskychSlov.size()<7);
	}			
		
	public void vytvorAnglickyZoznam() {
		zoznamAnglickychSlov.clear();
		do {
			String slovo = nahodneAnglickeSlovo();
			if (!zoznamAnglickychSlov.contains(slovo)) {
			zoznamAnglickychSlov.add(slovo);
			}
		} while (zoznamAnglickychSlov.size()<7);
	}
	
	public List<String> getCeskyZoznam() {
		return zoznamCeskychSlov;
	}			
		
	public List<String> getAnglickyZoznam() {
		return zoznamAnglickychSlov;
	}
	
	public List<String> getVysledok(String odpoved, String slovo) {
		if (odpoved.equals(slovo)) {
			vysledok.add(0,"Správna odpoveď !");
			vysledok.add(1,"spravne");
		} else {
			vysledok.add(0,"Nesprávna odpoveď !");
			vysledok.add(1,"nespravne");
		}
		return vysledok;
	}
	
	public void skore(String odpoved, String slovo) {
		if (odpoved.equals(slovo)) {
			spravne=spravne+1;
		} else {
			nespravne=nespravne+1;
		}
	}
	
	public int getPocetSpravnych() {
		return this.spravne;	
	}
	
	public int getPocetNespravnych() {
		return this.nespravne;
	}
	
	public String getAnglickeSlovo() {
		String slovo = getAnglickyZoznam().get(new Random().nextInt(getAnglickyZoznam().size()));
		return slovo;
	}

}
