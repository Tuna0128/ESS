package ESS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ScheduleEvents {
	
	static Map<Integer, String> timeMap = new HashMap<Integer, String>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		Random ran = new Random();
		String testTeam = "台灣 韓國 俄羅斯 塞爾維亞 泰國 土耳其 義大利 美國 日本 西班牙 羅馬尼亞 墨西哥 巴西 法國 瑞士 哈薩克 奧地利 斯洛伐克 波蘭 捷克";
		timeMap.put(0,"上午");
		timeMap.put(1,"下午");
		//String testVenue = "臺北市立天母棒球場 棒球 臺北市士林區忠誠路二段77號 10110\n"
		//		+ "臺北市新生公園棒球場 棒球 臺北市中山區新生北路3段105號 12500\n"+null;
		Venues[] venueList = new Venues[100];
		int venueCounter = 0;
		//Venues
		FileReader fr = new FileReader("Venues.txt");
		BufferedReader br = new BufferedReader(fr);
		File f = new File("Venues.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String[] buff = sc.nextLine().split(" ");
			//System.out.println(buff[0]+buff[1]+buff[2]+buff[3]);
			venueList[venueCounter] = new Venues(buff[0],buff[1],buff[2],Integer.parseInt(buff[3]));
			venueCounter++;
		}
		int[] venueSelect = new int[venueCounter];
		fr.close();
		//Team
		String[] teamList = testTeam.split(" ");
		int[] teamSelect = new int[teamList.length];
		while (inputScanner.hasNext()){
			//System.out.println(0);
			teamSelect = new int[teamList.length];
			switch(inputScanner.next()){
			case "add":
				switch(inputScanner.next()){
				case "venue":
					//String Name, String sportType, String Address, int Seat
					System.out.println("Name:");
					String Name = inputScanner.next();
					System.out.println("Sport Type:");
					String sportType = inputScanner.next();
					System.out.println("Address:");
					String Address = inputScanner.next();
					System.out.println("Seat:");
					int Seat = inputScanner.nextInt();
					venueList[venueCounter] = new Venues(Name, sportType, Address, Seat);
					//System.out.println(venueList[venueCounter].getSportType());
					//System.out.println(venueList[venueCounter].getSportType().equals("棒球"));
					venueCounter++;
					venueSelect = new int[venueCounter];
					break;
				case "team":
					String[] buffList = teamList;
					teamList = new String[buffList.length+1];
					for (int i=0;i<buffList.length;i++){
						teamList[i]=buffList[i];
					}
					System.out.println("Name:");
					teamList[buffList.length]=inputScanner.next();
					teamSelect = new int[teamList.length];
					break;
				}
				break;
			case "delete":
				switch(inputScanner.next()){
				case "venue":
					System.out.println("Name:");
					String buff =inputScanner.next();
					Venues[] buffList = venueList;
					venueCounter--;
					venueSelect = new int[venueCounter];
					venueList = new Venues[venueCounter];
					int flag = 0;
					for (int i=0;i<venueCounter;i++){
						if(buffList[i].getName().equals(buff)){
							flag = 1;
						}
						if (flag == 0)
							venueList[i]=buffList[i];
						else 
							venueList[i]=buffList[i+1];
					}
					
					break;
					//venueList[++venueCounter] = new Venues(Name, sportType, Address, Seat);
				case "team":
					System.out.println("Name:");
					String buff1 =inputScanner.next();
					String[] buff1List = teamList;
					int flag1 = 0;
					teamList = new String[buff1List.length-1];
					try{
						for (int i=0;i<teamList.length;i++){
							if(buff1List[i].equals(buff1)){
								flag1 = 1;
							}
							if (flag1 == 0)
								teamList[i]=buff1List[i];
							else 
								teamList[i]=buff1List[i+1];
						}
					}
					catch(NullPointerException e){
						
					}
					break;
				}
				break;
			case "create":
				
				for (int i=0;i<5;i++){
					
					for(int j=0;j<2;j++){
						
						String type = "棒球";
						Venues Venue;
						String Team1;
						String Team2;
						int buff;
						//System.out.println(1);
						//select venue
						do{
							 buff = ran.nextInt(venueCounter);
						}while(!venueList[buff].getSportType().equals(type) || venueSelect[buff]==1);
						Venue = venueList[buff];
						venueSelect[buff]=1;
						//System.out.println(2);
						//select team
						do{
							 buff = ran.nextInt(teamList.length);
						}while(teamSelect[buff]==1);
						//System.out.print(buff+" ");
						Team1=teamList[buff];
						teamSelect[buff]=1;
						do{
							 buff = ran.nextInt(teamList.length);
						}while(teamSelect[buff]==1);
						//System.out.println(buff);
						Team2=teamList[buff];
						teamSelect[buff]=1;
						System.out.println("08/"+(19+i)+" "+timeMap.get(j)+" "+Venue.getName()+" "+type+" "+Team1+" vs. "+Team2);
					}
					venueSelect = new int[venueCounter];
				}
				break;
			}
		}
		
		inputScanner.close();
	}
	

}
