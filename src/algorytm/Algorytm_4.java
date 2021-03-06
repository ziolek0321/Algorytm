package Moje;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Algorytm_4 {
	
	int slat; 							// szerokosc geo. zr. wody
	int slon;							// dlugosc geo. zr. wody
	int rtwsp_geo_lat;					// szerokosc geo. prawego-dolnego rogu analizowanego obszaru
	int rtwsp_geo_lon;					// dlugosc geo. prawego-dolnego rogu analizowanego obszaru
	int lbwsp_geo_lat;					// szerokosc geo. lewego-gornego rogu analizowanego obszaru
	int lbwsp_geo_lon;					// dlugosc geo. lewego-gornego rogu analizowanego obszaru
	int swsp_geo;						// wysokosc zr. wody
	int hs;								// wysokosc poczatkowa zr. wody
	int he;								// wysokosc koncowa zr. wody
	int interwal; 						// interwal przyrostu wody
	int length_tab;						//dlugosc tablicy
	int width_tab;						//szerokosc tablicy
	int tmpSlat;
	int tmpSlon;	

	Scanner scan = new Scanner(System.in);
	Random gen = new Random();
	
	public void Map() {
		
		//Wskazanie lewego-dolnego punktu
		System.out.println("Podaj szerokosc geograficzna lewego-gornego punktu");
		lbwsp_geo_lat = scan.nextInt();
		System.out.println("Podaj dlugosc geograficzna lewego-gornego punkty");
		lbwsp_geo_lon = scan.nextInt();
		
		//Wskazanie prawego-gornego punktu
		System.out.println("Podaj szerokosc geograficzna prawego-dolnego punktu");
		rtwsp_geo_lat = scan.nextInt();
		System.out.println("Podaj dlugosc geograficzna prawego-dolnego punkty");
		rtwsp_geo_lon = scan.nextInt();
				
		//Wskazanie punktu zr. wody
		System.out.println("Podaj szerokosc geograficzna zr. wody z zakresu " + rtwsp_geo_lat + " " + lbwsp_geo_lat);
		slat = scan.nextInt();
		System.out.println("Podaj dlugosc geograficzna zr. wody z zakresu " + rtwsp_geo_lon + " " + lbwsp_geo_lon);
		slon = scan.nextInt();
		
		System.out.println("Podaj wysokosc zr�d�a wody");
		swsp_geo = scan.nextInt();
		
		
		//Okreslenie wymiaru tablicy
		if(rtwsp_geo_lat < lbwsp_geo_lat) {
			do{
				rtwsp_geo_lat++;
				length_tab = length_tab + 1;
			}while (rtwsp_geo_lat <= lbwsp_geo_lat);
			
		} else {
			do{
				lbwsp_geo_lat++;
				length_tab = length_tab + 1;
			}while (lbwsp_geo_lat <= rtwsp_geo_lat);
		}	
		
		if(rtwsp_geo_lon < lbwsp_geo_lon) {
			do{
				rtwsp_geo_lon++;
				width_tab = width_tab + 1;
			}while (rtwsp_geo_lon <= lbwsp_geo_lon);
			
		} else {
			do{
				lbwsp_geo_lon++;
				width_tab = width_tab + 1;
			}while (lbwsp_geo_lon <= rtwsp_geo_lon);
		}
		

		for(int i = slat; i <= rtwsp_geo_lat; i++) {
			tmpSlat += 1;
		}
		
		for(int j = slon; j <= rtwsp_geo_lon; j++) {
			tmpSlon += 1;
		}
		//Przesuniecie tabicy do wsp. 0,0
		lbwsp_geo_lat = 0;
		lbwsp_geo_lon = 0;
		
		rtwsp_geo_lat = lbwsp_geo_lat + width_tab;
		rtwsp_geo_lon = lbwsp_geo_lon + length_tab;
		
		slat = rtwsp_geo_lat - tmpSlat;
		slon = rtwsp_geo_lon - tmpSlon;
	}
	
	
	
	public ArrayList<Integer> CoordinateList() {
		ArrayList<Integer> list1 = new ArrayList<Integer>(16);
		list1.add(-1);	// wiersz
		list1.add(-1);	// kolumna
		
		list1.add(-1);
		list1.add(0);
		
		list1.add(-1);
		list1.add(1);
	///////////////////////////////	
		list1.add(0);
		list1.add(-1);
		
		list1.add(0);
		list1.add(1);
	///////////////////////////////	
		list1.add(1);
		list1.add(-1);
		
		list1.add(1);
		list1.add(0);
		
		list1.add(1);
		list1.add(1);
		
		return list1;
	}
	
	//Tablica przechowywujaca wsp. punktow zalanych
	public ArrayList<Integer> WetPoints() {
		ArrayList<Integer> wetList = new ArrayList<Integer>(16);
		return wetList;
	}
	
	//Tablica przechowywujaca zalane punkty (wartosc punktu)
	public ArrayList<Integer> ListOfPoints() {
		ArrayList<Integer> listOfPoints = new ArrayList<Integer>(16);
		return listOfPoints;
	}
	
	
	
	public Integer[][] NetMap() {
		Integer[][] netMap = new Integer[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= netMap.length - 1; i++) { 
			for(int j = 0; j <= netMap.length - 1; j++) {
				netMap[i][j] = gen.nextInt(9);
			}
		}
		
		netMap[slat][slon] = swsp_geo;
		return netMap;
	}
	
	
	public Boolean[][] BooleanNetMap() {
		Boolean[][] booleanNetMap = new Boolean[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= booleanNetMap.length - 1; i++) { 
			for(int j = 0; j <= booleanNetMap.length - 1; j++) {
				booleanNetMap[i][j] = false;
			}
		}
		return booleanNetMap;
	}
	
	
	public String[][] WaterDirection() {
			String[][] waterDirection = new String[length_tab - 1][width_tab - 1];
		
		//Uzupelnienie tablicy losowymi liczbami
		for(int i = 0; i <= waterDirection.length - 1; i++) { 
			for(int j = 0; j <= waterDirection.length - 1; j++) {
				waterDirection[i][j] = "-";
			}
		}
		return waterDirection;
	}
	
	public void Display(Integer[][] netMap2, Boolean[][] booleanNetMap2, String[][] waterDirection2) {
		System.out.println(" ");
		System.out.println("TABLICA netMap");
		for(int m = 0; m < netMap2.length; m++) {
			for(int n = 0; n < netMap2[m].length; n++) 
				System.out.print(netMap2[m][n] + " ");
				System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("TABLICA BooleanNetMap");
		for(int m = 0; m < booleanNetMap2.length; m++) {
			for(int n = 0; n < booleanNetMap2[m].length; n++) 
				System.out.print(booleanNetMap2[m][n] + " ");
				System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("TABLICA WaterDirection");
		for(int m = 0; m < waterDirection2.length; m++) {
			for(int n = 0; n < waterDirection2[m].length; n++) 
				System.out.print(waterDirection2[m][n] + " ");
				System.out.println(" ");
		}
	}
	
	public void Calculation(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
		
			bolleanNetMap3[slat][slon] = true;
			waterDirection2[slat][slon] = "$";
			
			for(int i = 0; i < list2.size(); i += 2) {
				
				if(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)] < swsp_geo) {
					
					listOfPoints2.add(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)]);
					wetList2.add(slat - list2.get(i));	//wps. X nowego zalanego punktu
					wetList2.add(slon - list2.get(i + 1));	//wsp. Y nowego zalanego punktu
					bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
					waterDirection2[slat - list2.get(i)][slon - list2.get(i + 1)] = "#";
										
				} else {
					bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
				}
			}
			System.out.println(listOfPoints2 + " Punkty zalane");
			System.out.println(wetList2 + " Wspolrzedne X i Y zalanych punktow");
			System.out.println(" ");			
						

	}
	
	public void Calculation2(Integer[][] netMap3, ArrayList<Integer> list2, ArrayList<Integer> wetList2, Boolean[][] bolleanNetMap3, ArrayList<Integer> listOfPoints2, String[][] waterDirection2) {
		
		slat = wetList2.get(0);
		slon = wetList2.get(1);
		listOfPoints2.remove(0);
		wetList2.remove(1);
		wetList2.remove(0);

		
		for(int i = 0; i < list2.size(); i += 2) {
			try {
				if(bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] == false) {
					if(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)] < swsp_geo) {
						
							listOfPoints2.add(netMap3[slat - list2.get(i)][slon - list2.get(i + 1)]);
							wetList2.add(slat - list2.get(i));
							wetList2.add(slon - list2.get(i + 1));
							bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
							waterDirection2[slat - list2.get(i)][slon - list2.get(i + 1)] = "#";
					} else {
						bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
					}
												
				} else {
					bolleanNetMap3[slat - list2.get(i)][slon - list2.get(i + 1)] = true;
				}
			}
				
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Wyszedles po za obszar!");		
				}
			}
		
		System.out.println(listOfPoints2);
		System.out.println(wetList2);
		System.out.println(" ");
		
		
	
	}


}
