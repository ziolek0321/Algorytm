package Moje;

import java.util.Scanner;

public class Algorytm_3 {
	
	int slat; 					// szerokosc geo. zr. wody
	int slon;					// dlugosc geo. zr. wody
	int rtwsp_geo_lat;					// szerokosc geo. prawego-gornego rogu analizowanego obszaru
	int rtwsp_geo_lon;					// dlugosc geo. prawego-gornego rogu analizowanego obszaru
	int lbwsp_geo_lat;					// szerokosc geo. lewego-dolnego rogu analizowanego obszaru
	int lbwsp_geo_lon;					// dlugosc geo. lewego-dolnego rogu analizowanego obszaru
	int swsp_geo = 2;				// wysokosc zr. wody
	int hs;						// wysokosc poczatkowa zr. wody
	int he;						// wysokosc koncowa zr. wody
	int interwal = 2; 						// interwal przyrostu wody
	int length_tab;						//dlugosc tablicy
	int width_tab;						//szerokosc tablicy

	int poziomWody = 2;
	int wysokoscTerenu = 5;
	int maxPoziomWody = 10;
	
	Integer[][] tab1 = new Integer[3][3];
	Integer[][] tab2 = new Integer[3][3];
	
	public void Map() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj szerokosc geograficzna prawego-gornego punktu");
		rtwsp_geo_lat = scan.nextInt();
		System.out.println("Podaj dlugosc geograficzna prawego-gornego punkty");
		rtwsp_geo_lon = scan.nextInt();
		
		System.out.println("Podaj szerokosc geograficzna lewego-dolnego punktu");
		lbwsp_geo_lat = scan.nextInt();
		System.out.println("Podaj dlugosc geograficzna lewego-dolnego punkty");
		lbwsp_geo_lon = scan.nextInt();
		
		if(rtwsp_geo_lat < lbwsp_geo_lat) {
			do{
				length_tab = length_tab + 1;
				rtwsp_geo_lat++;
			}while (rtwsp_geo_lat <= lbwsp_geo_lat);
			
		} else {
			do{
				length_tab = length_tab + 1;
				lbwsp_geo_lat++;;
			}while (lbwsp_geo_lat <= rtwsp_geo_lat);
		}	
		
		if(rtwsp_geo_lon < lbwsp_geo_lon) {
			do{
				width_tab = width_tab + 1;
				rtwsp_geo_lon++;
			}while (rtwsp_geo_lon <= lbwsp_geo_lon);
			
		} else {
			do{
				width_tab = width_tab + 1;
				lbwsp_geo_lon++;
			}while (lbwsp_geo_lon <= rtwsp_geo_lon);
		}	
		
		//System.out.println(length_tab + " " + width_tab);
		
		
		Integer[][] netMap = new Integer[length_tab][width_tab];
		System.out.println("Twoja tablica ma wymiar " + netMap.length);
		
	}
	
	public void Calculation() {
			for(int i = 0; i <= tab1.length - 1; i++) { 
				for(int j = 0; j <= tab1.length - 1; j++) {
					if(poziomWody < wysokoscTerenu) {
						tab1[i][j] = poziomWody;
						System.out.println("Teren nie jest zalany " + poziomWody + " " + i + " " + j);
						poziomWody += 1;
					} else {
//						for(int p = 0; p <= tab2.length - 1; p++) { 
//							for(int k = 0; k <= tab2[p].length - 1; k++) {
									System.out.println("Teren jest zalany " + poziomWody + " " + i + " " + j);
									tab2[i][j] = poziomWody;
									//if(tab2[i][j] == maxPoziomWody) break;
									poziomWody -=3;
									
//							}
//						}
					}
				}
			}
	}
	
	public void Display() {
		System.out.println(" ");
		System.out.println("TABLICA 1 -  Teren nie zalany");
		for(int m = 0; m < tab1.length; m++) {
			for(int n = 0; n < tab1[m].length; n++) 
				System.out.print(tab1[m][n] + " ");
				System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("TABLICA 2 - teren zalany");
		for(int m = 0; m < tab2.length; m++) {
			for(int n = 0; n < tab2[m].length; n++) 
				System.out.print(tab2[m][n] + " ");
				System.out.println(" ");
		}
	}
}