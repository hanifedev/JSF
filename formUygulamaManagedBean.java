package jsf;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class formUygulamaManagedBean {
	
	private String ad;
	private String soyad;
	private String il;
	private String eposta;
	private String cinsiyet;
	private String adres;
	private String parola;
	private static Map<String,Object> cinsiyetler=new LinkedHashMap<String, Object>();
	private static Map<String,Object> iller=new LinkedHashMap<String, Object>();
	private String yabanci_dil;
	private Map<String,Object> yds=new LinkedHashMap<String, Object>();
	

	{
		yds.put("iyi", "iyi");
		yds.put("orta", "orta");
		yds.put("yok", "yok");
	}
	
	public Map<String,Object> ydsDoldur()
	{
		return yds;
	}
	
	static
	{
		iller.put("Samsun", "Samsun");
		iller.put("Istanbul","Istanbul");
		iller.put("Ankara", "Ankara");
		iller.put("Izmir", "Izmir");
	}
	
	public Map<String,Object> illeridondur()
	{
		return iller;
	}
	
	static
	{
		cinsiyetler.put("Erkek", "Erkek");
		cinsiyetler.put("Kadin", "Kadin");
	}
	
	public Map<String,Object> cinsiyetleridondur()
	{
		return cinsiyetler;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public static void setCinsiyetler(Map<String,Object> cinsiyetler) {
		managedBean.cinsiyetler = cinsiyetler;
	}

	public static Map<String,Object> getCinsiyetler() {
		return cinsiyetler;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getYabanci_dil() {
		return yabanci_dil;
	}

	public void setYabanci_dil(String yabanci_dil) {
		this.yabanci_dil = yabanci_dil;
	}	
}
