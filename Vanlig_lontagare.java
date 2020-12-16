


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Vanlig_lontagare {

	ProcessData procData;
	AGBase agBas;
	public void doJob() throws Exception {
		procData = new ProcessData();
		agBas = new AGBase();
		// Ange orgnummer
		procData.setOrgNr("165780017678");
		// Ange period
		procData.setPeriod("201901");
		String dest = "k:\\IDAG\\xmlfiler\\gen\\Test_Wass_201901.xml";
		int hurmanga_iu = 2;
		// sätt boolean till true så kommer ett visst antal annat id och födelsetid i
		// filen. Sätt till false och bara betalmottagare med personnummer skapas.
		boolean annat = false;
	
		int k = 0;

		Date datum = new Date();
		
		ArrayList<String> helaXmlFilen = new ArrayList<String>();
		int inkomsten = agBas.inkomst;// 28500;
		int skatten = agBas.skatt;
		String alla = "";
	
		helaXmlFilen.add(agBas.huvud(procData.getOrgNr()));

		//helaXmlFilen.add(huvudUpp(procData.getOrgNr(), procData.getPeriod(), inkomst, skatt, hurmanga_iu));

		if (annat == false) {

			for (int i = 1; i < hurmanga_iu; i++) {
				k = procData.persRakn(procData.getPersNr1(), k);
				if (i < 10) {
					helaXmlFilen.add(procData.skapaUppgift6_1(alla, i, k));
				} else if (i >= 10 && i <= 20) {
					helaXmlFilen.add(procData.skapaUppgift8_1(alla, i, k));
				} else if (i >= 30 && i <= 40) {
					helaXmlFilen.add(procData.skapaUppgift6_1(alla, i, k));
				} else if (i >= 50 && i <= 60) {
					helaXmlFilen.add(procData.skapaUppgift1_1(alla, i, k));
				} else if (i >= 1500 && i <= 1502) {
					helaXmlFilen.add(procData.skapaUppgift6_1(alla, i, k));
				} else {
					helaXmlFilen.add(procData.skapaUppgift8_1(alla, i, k));
				}
			}

		} else {
			List<Integer> sort_list = new ArrayList<Integer>();
			List<Integer> sort_list3 = new ArrayList<Integer>();
			Random rand = new Random();

			for (int i = 0; i < 9050; i++) { // 19050
				int rand_int1 = rand.nextInt(10000);
				sort_list.add(rand_int1);
			}

			Collections.sort(sort_list);
			Set<Integer> listaUtanDubbletter = new LinkedHashSet<>(sort_list);

			sort_list3.addAll(listaUtanDubbletter);
			alla = "";
	
			for (int i = 1; i < hurmanga_iu; i++) {
				if (sort_list3.contains(i)) {				
					if (i % 2 == 0) {
						alla = procData.skapaUppgift_AnnatId(alla, i, k); 			
					} else {
						alla = procData.skapaUppgift_Fodelsetid(alla, i, k);
					}
					
				} else {
					k = procData.persRakn(procData.getPersNr1(), k);
					alla = procData.skapaUppgift8_1(alla, i, k);
				}
		
				helaXmlFilen.add(alla);
				
			}

		}
		helaXmlFilen.add("</Skatteverket>");



		
		System.out.println("</Skatteverket>");
		procData.skrivFilArrList1(helaXmlFilen, new File(dest));
		
		System.out.println(datum.toString());
		System.out.println(helaXmlFilen.size());
		System.out.println("Klart!");
		System.out.println("FK487 = " + inkomsten * (hurmanga_iu - 1) + "  " + hurmanga_iu);
		System.out.println("FK497 = " + skatten * (hurmanga_iu - 1));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vanlig_lontagare v = new Vanlig_lontagare();
		try {
			v.doJob();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
