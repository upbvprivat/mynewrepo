


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class ProcessData {
	AGBase agBas;
	private String orgNr;
	private String period;
	private String fil;
	private ArrayList<String> persNr1;
	
	public ProcessData() throws FileNotFoundException, UnsupportedEncodingException {
		agBas = new AGBase();
		setFil("k:\\eclips\\Test\\dkanr31.txt");
		setPersNr1(taPersNr(getFil()));
	
		
		
		
	}
	
	public String skapaUppgift8_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {

		int i = raknare;
		alla = "<!-- iu nummer: " + i  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  i + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod8_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	
	public String skapaUppgift7_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {

		int i = raknare;
		alla = "<!-- iu nummer: " + i  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  i + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod7_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	public String skapaUppgift3_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
		
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod3_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}

	public String skapaUppgift6_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
	
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod6_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	public String skapaUppgift5_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod6_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	
	public String skapaUppgift1_1(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
	
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoiceSlut()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod1_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	
	public String skapaUppgift_TIN(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
		
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + "  --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:BetalningsmottagarId faltkod=\"215\">" + getPersNr1().get(k) + "</agd:BetalningsmottagarId>\n"
			+ agBas.betIuGroupChoice_slutTIN()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod1_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	
	public String skapaUppgift_AnnatId(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
	
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + " annat id --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:AnnatId faltkod=\"224\">Silvio Dante" + raknare + "</agd:AnnatId>\n"
			+ agBas.betIuGroupSlut_annatId()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod7_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	
	public String skapaUppgift_Fodelsetid(String alla, int raknare, int k) throws FileNotFoundException, UnsupportedEncodingException {
		Random rand1 = new Random();
		Random rand2 = new Random();
		int nasta_int = rand1.nextInt(899);
		int nasta_int2 = rand2.nextInt(79);
		nasta_int = nasta_int + 100;
		nasta_int2 = nasta_int2 + 10;
		alla = "<!-- iu nummer: " + raknare  + " som skapats" + " födelsetid --> \n"
			+ agBas.iuStartMetod(getOrgNr(), getPeriod())
			+ agBas.betIuGroupChoiceStart()
			+ "<agd:Fodelsetid faltkod=\"222\">19" + nasta_int2 + "1224" +  nasta_int +"</agd:Fodelsetid>\n"
			+ agBas.betIuGroupSlut_annatId()
			+ "<agd:Specifikationsnummer faltkod=\"570\">" +  raknare + "</agd:Specifikationsnummer>\n"
			+ agBas.iuSlutMetod7_1(getPeriod(), agBas.inkomst3, agBas.skatt3);
		return alla;
	}
	public void skrivFilArrList1(ArrayList<String> arrData, File f){
		//ArrayList<String> arrData1 = new ArrayList<String>();
		File file = f;
	//	FileWriter fr = null;
		int size = arrData.size();
		try {
			
			File path = new File(f.getParent());
			System.out.println(f.getParent());
			if(!path.exists()) {
				path.mkdirs();
			}
		
			BufferedWriter out = new BufferedWriter(new FileWriter(f, false));
			out.flush();
			for(String s : arrData) {
				out.write(s);
			}
				out.close();
		
			
		}   catch (IOException e){
			
		}
		finally {
			
		}
	}
	public ArrayList<String> taPersNr(String fileNamn) throws FileNotFoundException, UnsupportedEncodingException {
		File fr4 = new File(fileNamn);
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fr4), "UTF8"));
		
		ArrayList<String> personNrFil = new ArrayList<String>();
		String linje = null;
		
		try {
			while ((linje = reader1.readLine())  != null)
				
				personNrFil.add(linje.trim());				
		} catch (Exception e){
			System.out.println(e);	
		} finally {
			try {
				reader1.close();
			} catch (IOException e) {
				System.out.println(e);
			}
			
		}
		return personNrFil;
	}
	
	//Gör att när man kommer till slutet av peronnummerfilen så börjar man om från första numret i listan. Använder en fil med unika personnummer
	//och börjar från början igen.
	public int persRakn(ArrayList<String> persNummer, int kk) {
		//int kk;
		int langd = persNummer.size();
//		System.out.println(langd);
		if(kk == langd -1 ) {
			kk =1;
			//kk++;
		} else {
			kk++;
		}
			
		return kk;
		
	}
	
	public String getOrgNr() {
		return orgNr;
	}

	public void setOrgNr(String orgNr) {
		this.orgNr = orgNr;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getFil() {
		return fil;
	}

	public void setFil(String fil) {
		this.fil = fil;
	}

	public ArrayList<String> getPersNr1() {
		return persNr1;
	}

	public void setPersNr1(ArrayList<String> persNr1) {
		this.persNr1 = persNr1;
	}

}
