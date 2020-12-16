


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

public class AGBase {


//	protected static String orgNr = "161780023386";
//	protected static String period = "201908";
	
	protected int inkomst = 10010;
	protected int inkomst3 = 10030;
	protected int skatt = 3010;
	protected int skatt2 = 30000;
	protected int skatt3 = 3030;
	 int fk487 = inkomst;
	Random tinRand = new Random();
	int tinRa = tinRand.nextInt(10000);
	
	
	
	public String[] retLandKod() {
		String[] arrLandKod = new String[20];

		arrLandKod[0] = "NO";
		arrLandKod[1] = "FI";
		arrLandKod[2] = "RU";
		arrLandKod[3] = "MD";
		arrLandKod[4] = "KR";
		arrLandKod[5] = "UK";
		arrLandKod[6] = "US";
		arrLandKod[7] = "FR";
		arrLandKod[8] = "ES";
		arrLandKod[9] = "NL";
		arrLandKod[10] = "SK";
		arrLandKod[11] = "ZA";
		arrLandKod[12] = "TH";
		arrLandKod[13] = "RO";
		arrLandKod[14] = "IT";
		arrLandKod[15] = "IN";
		arrLandKod[16] = "IE";
		arrLandKod[17] = "JP";
		arrLandKod[18] = "HR";
		arrLandKod[19] = "PT";

		return (arrLandKod);
	}
	
	
	String iuVarden1 = new StringBuilder()
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">28500</agd:KontantErsattningUlagAG>\n")
			.append("<agd:SkatteplBilformanUlagAG faltkod=\"013\">2500</agd:SkatteplBilformanUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">9300</agd:AvdrPrelSkatt>\n")
			.toString();
	
/*	String betIuGroup = "<agd:BetalningsmottagareIUGROUP>\n"; 
	String betIuChoice = "agd:BetalningsmottagareIDChoice>\n"*/
	
	protected String betIuGroupChoiceStart() {
		String betIu = "<agd:BetalningsmottagareIUGROUP>\n"
						+ "<agd:BetalningsmottagareIDChoice>\n";
		
		return betIu;
		
	}
	
	protected String betIuGroupChoiceSlut() {
		String betIuSlut = "</agd:BetalningsmottagareIDChoice>\n"
				+ "</agd:BetalningsmottagareIUGROUP>\n";		
		return betIuSlut;
	}
	
	protected String betIuGroupSlut_annatId() {
		String betIuSlutannatID = "</agd:BetalningsmottagareIDChoice>\n"
				+ "<agd:Fornamn faltkod=\"216\">Steven</agd:Fornamn>\n"
				+ "<agd:Efternamn faltkod=\"217\">Van Zandt</agd:Efternamn>\n"
				+ "<agd:Gatuadress faltkod=\"218\">E-Street</agd:Gatuadress>\n"
				+ "<agd:Postnummer faltkod=\"219\">12345</agd:Postnummer>\n"
				+ "<agd:Postort faltkod=\"220\">Belmar</agd:Postort>\n"
				+ "<agd:FriAdress faltkod=\"230\">Lilyhammer</agd:FriAdress>\n"
				+ "<agd:LandskodPostort faltkod=\"221\">SE</agd:LandskodPostort>\n"
				+ "</agd:BetalningsmottagareIUGROUP>\n";
		
		return betIuSlutannatID;
	}
	
	protected String betIuGroupChoice_slutTIN() {
		String betIuGroup_Choice_slut_TIN = "</agd:BetalningsmottagareIDChoice>\n"
				+ "<agd:LandskodTIN faltkod=\"076\">NO</agd:LandskodTIN>\n"
				+ "<agd:TIN faltkod=\"252\">" + tinRand.nextInt(10000) + "</agd:TIN>\n"
				+ "</agd:BetalningsmottagareIUGROUP>\n";
		
		return betIuGroup_Choice_slut_TIN;
	}

protected String huvud(String orgNummer) {
	
	String huvud = new StringBuilder()
			.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n")
			.append("<Skatteverket omrade=\"Arbetsgivardeklaration\" xmlns=\"http://xmls.skatteverket.se/se/skatteverket/da/instans/schema/1.1\" ")
			.append("xmlns:agd=\"http://xmls.skatteverket.se/se/skatteverket/da/komponent/schema/1.1\" ")
			.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ")
			.append("xsi:schemaLocation=\"http://xmls.skatteverket.se/se/skatteverket/da/instans/schema/1.1 ")
			.append("http://xmls.skatteverket.se/se/skatteverket/da/arbetsgivardeklaration/arbetsgivardeklaration_1.1.xsd\">\n")
			.append("<agd:Avsandare>\n")
			.append("<agd:Programnamn>Programmakarna AB</agd:Programnamn>\n")
			.append("<agd:Organisationsnummer>" + orgNummer + "</agd:Organisationsnummer>\n")
			.append("<agd:TekniskKontaktperson>\n")
			.append("<agd:Namn>Ken Griffey Jr</agd:Namn>\n")
			.append("<agd:Telefon>23-2-4-244454</agd:Telefon>\n")
			.append("<agd:Epostadress>ken.griffey@mariners.com</agd:Epostadress>\n")
			.append("<agd:Utdelningsadress1>1250 1st Avenue South</agd:Utdelningsadress1>\n")
			.append("<agd:Utdelningsadress2>Dave Niehaus Way S</agd:Utdelningsadress2>\n")
			.append("<agd:Postnummer>1250</agd:Postnummer>\n")
			.append("<agd:Postort>Seattle</agd:Postort>\n")
			.append("</agd:TekniskKontaktperson>\n")
			.append("<agd:Skapad>2019-01-30T07:42:25</agd:Skapad>\n")
			.append("</agd:Avsandare>\n")
			.append("<agd:Blankettgemensamt>\n")
			.append("<agd:Arbetsgivare>\n")
			.append("<agd:AgRegistreradId>"+ orgNummer + "</agd:AgRegistreradId>\n")
			.append("<agd:Kontaktperson>\n")
			.append("<agd:Namn>Ville Vessla</agd:Namn>\n")
			.append("<agd:Telefon>555-244454</agd:Telefon>\n")
			.append("<agd:Epostadress>ville.vessla@foretaget.se</agd:Epostadress>\n")
			.append("<agd:Sakomrade>skruv-avdelningens anställda</agd:Sakomrade>\n")
			.append("</agd:Kontaktperson>\n")
			.append("<agd:Kontaktperson>\n")
			.append("<agd:Namn>Maria Olsson</agd:Namn>\n")
			.append("<agd:Telefon>555-244121</agd:Telefon>\n")
			.append("<agd:Epostadress>maria.olsson@foretaget.se</agd:Epostadress>\n")
			.append("<agd:Sakomrade>mutter-avdelningens anställda</agd:Sakomrade>\n")
			.append("</agd:Kontaktperson>\n")
			.append("</agd:Arbetsgivare>\n")
			.append("</agd:Blankettgemensamt>\n")
			//.append("\n")
			.toString();

	return huvud;
	
}

protected String iuStartMetod(String orgNummer, String perioder) {
	
	String iuStart = new StringBuilder()
			.append("<agd:Blankett>\n")
			.append("<agd:Arendeinformation>\n")
			.append("<agd:Arendeagare>" + orgNummer + "</agd:Arendeagare>\n")
			.append("<agd:Period>" + perioder + "</agd:Period>\n")
			.append("</agd:Arendeinformation>\n")
			.append("<agd:Blankettinnehall>\n")
			.append("<agd:IU>\n")
			.append("<agd:ArbetsgivareIUGROUP>\n")
			.append("<agd:AgRegistreradId faltkod=\"201\">" + orgNummer + "</agd:AgRegistreradId>\n")
			.append("</agd:ArbetsgivareIUGROUP>\n")
			.toString();
	
	return iuStart;
	
}

protected static String betIuGroup_Choice_slut_TIN(int tinNummer) {
	
	
	String betIUGroup_slut_Tin = new StringBuilder()
			.append("</agd:BetalningsmottagareIDChoice>\n")
			.append("<agd:LandskodTIN faltkod=\"076\">NO</agd:LandskodTIN>\n")
			.append("<agd:TIN faltkod=\"252\">" + tinNummer + "</agd:TIN>\n")
			.append("</agd:BetalningsmottagareIUGROUP>\n")
			.toString();
	
	
	return betIUGroup_slut_Tin;
	
	
	
}

protected  String iuSlutMetod(String periodenerna, int fk011, int fk001) {
		
	String iuSlut = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst + "</agd:KontantErsattningUlagAG>\n")
		//	.append("<agd:SkatteplBilformanUlagAG faltkod=\"013\">2500</agd:SkatteplBilformanUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt + "</agd:AvdrPrelSkatt>\n")
		//	.append("<agd:TIN faltkod=\"252\">3255</agd:TIN>\n")
		//	.append("<agd:LandskodTIN faltkod=\"076\">NO</agd:LandskodTIN>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			.toString();
	
	return iuSlut;	
}

protected String iuSlutMetod2(String periodenerna) {
	
	String iuSlut2 = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:SkatteplOvrigaFormanerUlagAG faltkod=\"012\">4500</agd:SkatteplOvrigaFormanerUlagAG>\n")
			.append("<agd:FormanHarJusterats faltkod=\"048\">true</agd:FormanHarJusterats>\n")
			.append("<agd:Arbetsstallenummer faltkod=\"060\">1</agd:Arbetsstallenummer>\n")
			.append("<agd:AmbassadanstISvMAvtal faltkod=\"094\">true</agd:AmbassadanstISvMAvtal>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			.toString();
	return iuSlut2;
	
}
protected String iuSlutNyaFaltkoder(String perioderna, int fk011, int fk001) {
	String iuSlut = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + perioderna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst  + "</agd:KontantErsattningUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt +"</agd:AvdrPrelSkatt>\n")
			.append("<agd:BetForDrivmVidBilformanUlagAG faltkod=\"098\">2000</agd:BetForDrivmVidBilformanUlagAG>\n")
			.append("<agd:DrivmVidBilformanUlagAG faltkod=\"018\">2100</agd:DrivmVidBilformanUlagAG>\n")
			.append("<agd:EjFastDriftstalleIndivid faltkod=\"303\">1</agd:EjFastDriftstalleIndivid>\n")
			.append("<agd:SkatteplBilformanUlagAG faltkod=\"013\">1500</agd:SkatteplBilformanUlagAG>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			.toString();
	return iuSlut;
			
}

protected String iuSlutMetod1_1(String periodenerna, int fk011, int fk001) {
	
	String iuSlut = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst + "</agd:KontantErsattningUlagAG>\n")
		//	.append("<agd:SkatteplBilformanUlagAG faltkod=\"013\">2500</agd:SkatteplBilformanUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt + "</agd:AvdrPrelSkatt>\n")
		//	.append("<agd:TIN faltkod=\"252\">3255</agd:TIN>\n")
		//	.append("<agd:LandskodTIN faltkod=\"076\">NO</agd:LandskodTIN>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			.toString();
	
	return iuSlut;	
}

protected String iuSlutMetod8_1(String periodenerna, int fk011, int fk001) {
	String iuSlut3 = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst  + "</agd:KontantErsattningUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt +"</agd:AvdrPrelSkatt>\n")
			.append("<agd:ErsattningsKod2 faltkod=\"084\">121</agd:ErsattningsKod2>\n")
			.append("<agd:ErsattningsKod3 faltkod=\"086\">113</agd:ErsattningsKod3>\n")
			.append("<agd:ErsattningsKod1 faltkod=\"004\">440</agd:ErsattningsKod1>\n")
			.append("<agd:ErsattningsBelopp1 faltkod=\"005\">2000</agd:ErsattningsBelopp1>\n")
			.append("<agd:ErsattningsBelopp2 faltkod=\"085\">2000</agd:ErsattningsBelopp2>\n")
			.append("<agd:ErsattningsBelopp3 faltkod=\"087\">2000</agd:ErsattningsBelopp3>\n")
			.append("<agd:ErsattningsKod4 faltkod=\"088\">121</agd:ErsattningsKod4>\n")
			.append("<agd:ErsattningsBelopp4 faltkod=\"089\">2000</agd:ErsattningsBelopp4>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			
			.toString();
			
	return iuSlut3;
	
	
}


protected String iuSlutMetod7_1(String periodenerna, int fk011, int fk001) {
	String iuSlut3 = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst  + "</agd:KontantErsattningUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt +"</agd:AvdrPrelSkatt>\n")
			.append("<agd:ErsattningsKod2 faltkod=\"084\">121</agd:ErsattningsKod2>\n")
			.append("<agd:ErsattningsKod3 faltkod=\"086\">113</agd:ErsattningsKod3>\n")
			.append("<agd:ErsattningsKod1 faltkod=\"004\">440</agd:ErsattningsKod1>\n")
			.append("<agd:ForstaAnstalld faltkod=\"062\">1</agd:ForstaAnstalld>\n")
			.append("<agd:ErsattningsBelopp1 faltkod=\"005\">2000</agd:ErsattningsBelopp1>\n")
			.append("<agd:ErsattningsBelopp2 faltkod=\"085\">2000</agd:ErsattningsBelopp2>\n")
			.append("<agd:ErsattningsBelopp3 faltkod=\"087\">2000</agd:ErsattningsBelopp3>\n")
			.append("<agd:ErsattningsKod4 faltkod=\"088\">121</agd:ErsattningsKod4>\n")
			.append("<agd:ErsattningsBelopp4 faltkod=\"089\">2000</agd:ErsattningsBelopp4>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			
			.toString();
			
	return iuSlut3;
	
	
}

protected String iuSlutMetod3_1(String periodenerna, int fk011, int fk001) {
	String iuSlut3 = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst  + "</agd:KontantErsattningUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt +"</agd:AvdrPrelSkatt>\n")
			.append("<agd:ErsattningsKod2 faltkod=\"084\">121</agd:ErsattningsKod2>\n")
			.append("<agd:ErsattningsKod3 faltkod=\"086\">113</agd:ErsattningsKod3>\n")
			.append("<agd:ErsattningsKod1 faltkod=\"004\">440</agd:ErsattningsKod1>\n")
			.append("<agd:ErsattningsBelopp1 faltkod=\"005\">2010</agd:ErsattningsBelopp1>\n")
			.append("<agd:ErsattningsBelopp2 faltkod=\"085\">2010</agd:ErsattningsBelopp2>\n")
			.append("<agd:ErsattningsBelopp3 faltkod=\"087\">2010</agd:ErsattningsBelopp3>\n")
			.append("<agd:ErsattningsKod4 faltkod=\"088\">121</agd:ErsattningsKod4>\n")
			.append("<agd:ErsattningsBelopp4 faltkod=\"089\">2010</agd:ErsattningsBelopp4>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			
			.toString();
			
	return iuSlut3;
	
	
}

protected String iuSlutMetod6_1(String periodenerna, int fk011, int fk001) {
	String iuSlut3 = new StringBuilder()
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + periodenerna + "</agd:RedovisningsPeriod>\n")
			.append("<agd:KontantErsattningUlagAG faltkod=\"011\">" + inkomst  + "</agd:KontantErsattningUlagAG>\n")
			.append("<agd:AvdrPrelSkatt faltkod=\"001\">" + skatt2 +"</agd:AvdrPrelSkatt>\n")
			.append("<agd:ErsattningsKod2 faltkod=\"084\">121</agd:ErsattningsKod2>\n")
			.append("<agd:ErsattningsKod3 faltkod=\"086\">113</agd:ErsattningsKod3>\n")
			.append("<agd:ErsattningsKod1 faltkod=\"004\">440</agd:ErsattningsKod1>\n")
			.append("<agd:ErsattningsBelopp1 faltkod=\"005\">3000</agd:ErsattningsBelopp1>\n")
			.append("<agd:ErsattningsBelopp2 faltkod=\"085\">3000</agd:ErsattningsBelopp2>\n")
			.append("<agd:ErsattningsBelopp3 faltkod=\"087\">3000</agd:ErsattningsBelopp3>\n")
		//	.append("<agd:ErsattningsKod4 faltkod=\"088\">121</agd:ErsattningsKod4>\n")
		//	.append("<agd:ErsattningsBelopp4 faltkod=\"089\">2000</agd:ErsattningsBelopp4>\n")
			.append("</agd:IU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
			
			.toString();
			
	return iuSlut3;
	
	
}



	
protected String huvudUpp(String orgNr, String period, int fk487, int skatt, int antal_iu) {
	double proc = 0.3142;
	double lokalFK487 = inkomst * (antal_iu -1);
	
	lokalFK487 = lokalFK487 * proc;
	int lokallFK497 = skatt * (antal_iu -1);
	String str487 = Integer.toString((int)lokalFK487);
	str487 = str487.trim();
	String hu = new StringBuilder()
			.append("<!-- Uppgift 1 HU -->\n")
			.append("<agd:Blankett>\n")
			.append("<agd:Arendeinformation>\n")
			.append("<agd:Arendeagare>" + orgNr + "</agd:Arendeagare>\n")
			.append("<agd:Period>"+ period +"</agd:Period>\n")
			.append("</agd:Arendeinformation>\n")
			.append("<agd:Blankettinnehall>\n")
			.append("<agd:HU>\n")
			.append("<agd:ArbetsgivareHUGROUP>\n")
			.append("<agd:AgRegistreradId faltkod=\"201\">" + orgNr +"</agd:AgRegistreradId>")
			.append("</agd:ArbetsgivareHUGROUP>\n")
			.append("<agd:RedovisningsPeriod faltkod=\"006\">" + period +"</agd:RedovisningsPeriod>\n")
			.append("<agd:SummaArbAvgSlf faltkod=\"487\">" + str487 + "</agd:SummaArbAvgSlf>\n")
			.append("<agd:SummaSkatteavdr faltkod=\"497\">" + lokallFK497 + "</agd:SummaSkatteavdr>\n")
			.append("<agd:TotalSjuklonekostnad faltkod=\"499\">25000</agd:TotalSjuklonekostnad>\n")
			.append("</agd:HU>\n")
			.append("</agd:Blankettinnehall>\n")
			.append("</agd:Blankett>\n")
		//	.append("\n")
			.toString();
		
	String allt = hu;
	
	return allt;	
}

	

}
