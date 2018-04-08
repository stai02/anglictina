package com.github.stai02.anglictina.logika;

public class Slovo {

	private String meno;
	private String preklad;
	private String bezDiakritiky;
	
	public Slovo(String preklad,String meno,String bezDiakritiky) {
		this.meno = meno;
		this.preklad = preklad;
		this.bezDiakritiky = bezDiakritiky;
	}

	public String getPreklad() {
		return this.preklad;
	}
	
	public String getBezDiakritiky() {
		return this.bezDiakritiky;
	}
	
	public void setPreklad(String novyPreklad) {
		 this.preklad=novyPreklad;
	}
	
	public String getMeno() {
		return this.meno;
	}
	
	public void setMeno(String noveMeno) {
		 this.meno=noveMeno;
	}
}
