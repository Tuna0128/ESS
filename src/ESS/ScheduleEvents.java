package ESS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScheduleEvents {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		String testTeam = "台灣  韓國 俄羅斯 塞爾維亞  泰國 土耳其  西班牙";
		//String testVenue = "臺北市立天母棒球場 棒球 臺北市士林區忠誠路二段77號 10110\n"
		//		+ "臺北市新生公園棒球場 棒球 臺北市中山區新生北路3段105號 12500\n"+null;
		Venues[] venueList = new Venues[100];
		int venueCounter = 0;
		/**
		 * Vunue
		 */
		FileReader fr = new FileReader("Venues.txt");
		BufferedReader br = new BufferedReader(fr);
		File f = new File("Venues.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String[] buff = sc.nextLine().split(" ");
			System.out.println(buff[0]+buff[1]+buff[2]+buff[3]);
			venueList[venueCounter] = new Venues(buff[0],buff[1],buff[2],Integer.parseInt(buff[3]));
			venueCounter++;
		}
		fr.close();
		String[] teamList = testTeam.split(" ");
		/*while (inputScanner.hasNext()){
			String[] buff = inputScanner.nextLine().split(" ");
			venueList[venueCounter] = new Venues(buff[0],buff[1],buff[2],Integer.parseInt(buff[3]));	
			venueCounter++;
		}*/
		
		inputScanner.close();
	}
	
	

}
