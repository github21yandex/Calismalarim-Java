package AlgAraSinav;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.ArrayList;
//import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		File f=new File("C:\\Users\\onur2\\Desktop\\sayilar.txt");
		FileWriter fw=new FileWriter(f);
	
		long timeMilli1 = System.nanoTime();
		long timeMilli2 = System.nanoTime();
		long timeMilliB = System.nanoTime();
		long timeMilliD = System.nanoTime();
		Random random = new Random();

		Point[] nokta = new Point[50];
		

		for (int i = 0; i < 50; i++) {
			nokta[i] = new Point(random.nextDouble() * 100, random.nextDouble() * 100);
		}

		Point[] points = new Point[27];

		points[	0	] = new Point(	28.4138	, 	1.9314	);
points[	1	] = new Point(	23.8360	, 	92.6739	);
points[	2	] = new Point(	20.5465	, 	98.4164	);
points[	3	] = new Point(	26.1186	, 	69.5129	);
points[	4	] = new Point(	29.9570	, 	98.7546	);
points[	5	] = new Point(	26.9168	, 	95.5184	);
points[	6	] = new Point(	25.2167	, 	0.7040	);
points[	7	] = new Point(	22.1545	, 	2.6433	);
points[	8	] = new Point(	31.4879	, 	0.5166	);
points[	9	] = new Point(	6.5407	, 	6.4864	);
points[	10	] = new Point(	5.6979	, 	30.5158	);
points[	11	] = new Point(	6.7491	, 	20.1821	);
points[	12	] = new Point(	4.9887	, 	92.5591	);
points[	13	] = new Point(	29.8018	, 	99.8122	);
points[	14	] = new Point(	24.6931	, 	18.1155	);
points[	15	] = new Point(	16.5832	, 	58.9331	);
points[	16	] = new Point(	10.6058	, 	85.5618	);
points[	17	] = new Point(	22.5771	, 	30.5777	);
points[	18	] = new Point(	4.0429	, 	61.4898	);
points[	19	] = new Point(	18.3863	, 	19.9681	);
points[	20	] = new Point(	18.0082	, 	55.5832	);
points[	21	] = new Point(	30.8500	, 	28.7464	);
points[	22	] = new Point(	17.4742	, 	96.2276	);
points[	23	] = new Point(	23.6351	, 	99.4663	);
points[	24	] = new Point(	30.8800	, 	26.0722	);
points[	25	] = new Point(	27.9613	, 	9.4817	);
points[	26	] = new Point(	19.1544	, 	9.0099	);


		

		


		////////////////////////////////////
		// NOKTALAR TEKRAR VAR MI KONTROL //
		////////////////////////////////////



		ArrayList<Point> temp = new ArrayList<Point>();

		boolean flag = false;

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].getX() == points[j].getX() && points[i].getY() == points[j].getY()) {
					flag = true;
					break;
				}
			}

			if (flag == false) {
				temp.add(points[i]);
				continue;
			}

			flag = false;
		}
		points = null;
		points = new Point[temp.size()];

		for (int i = 0; i < temp.size(); i++) {
			points[i] = temp.get(i);
		}

		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point point1, Point point2) {

				// return
				// Double.toString(point1.getX()).compareTo(Double.toString(point2.getX()));
				/**/

				if (point1.getX() > point2.getX()) {
					return 1;
				} else if (point1.getX() < point2.getX()) {
					return -1;
				} else {
					return 0;
				}

				/**/
			}
		});

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////

		//graph(points);
		
		//points(points);

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\n\n\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("                    BURUTE FORCE METHOD                     ");
		System.out.println("------------------------------------------------------------");
		

		timeMilliB = 0;

		for (int i = 0; i < 2000; i++) {
			timeMilli1 = System.nanoTime();
			Point.getClosestPair(nokta);
			timeMilli2 = System.nanoTime();
			timeMilliB +=  (timeMilli2-timeMilli1);

		}

		


		//int x = 0;
		//for (Point point : Point.getClosestPair(points)) {

		//	System.out.println(" " + x / 2 + "- " + point.toString());
			//if (x % 2 == 1) {
			//	System.out.println("");
			//}
		//	x++;

		//}

		System.out.println(timeMilliB/2000 );
		

	

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\n\n\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("                 DIVIDE AND CONQUER METHOD");
		System.out.println("------------------------------------------------------------");

		Point[] P = nokta.clone();
		Point[] Q = nokta.clone();

		Arrays.sort(P, new Comparator<Point>() {
			@Override
			public int compare(Point point1, Point point2) {

				// return
				// Double.toString(point1.getX()).compareTo(Double.toString(point2.getX()));
				//*

				if (point1.getX() > point2.getX()) {
					return 1;
				} else if (point1.getX() < point2.getX()) {
					return -1;
				} else {
					return 0;
				}

				/**/
			}
		});

		Arrays.sort(Q, new Comparator<Point>() {
			@Override
			public int compare(Point point1, Point point2) {
				if (point1.getY() > point2.getY()) {
					return 1;
				} else if (point1.getY() < point2.getY()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		timeMilliD = 0;
		
			for (int i = 0; i < 2000; i++) {
				timeMilli1 = System.nanoTime();
				Point.getClosestPair(P, Q);
				timeMilli2 = System.nanoTime();
				timeMilliD +=  (timeMilli2-timeMilli1);
	
			}
			
		
		

	
		
		

		//for (int j = 0; j < array.length; j += 2) {
		//	System.out.println(" " + j / 2 + "- " + array[j]);
		//	System.out.println(" " + j / 2 + "- " + array[j + 1] + "\n");
		//}
		System.out.println(timeMilliD/2000 );
		

		/*
		System.out.println("\n\n------------------------------------------------------------");
		System.out.println("                   POINTS  X'E GÖRESIRALI                   ");
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < P.length; i++) {
			System.out.println(i + "_ " + P[i].toString());
		}

		System.out.println("\n\n------------------------------------------------------------");
		System.out.println("                   POINTS  Y'E GÖRESIRALI                   ");
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < Q.length; i++) {
			System.out.println(i + "_ " + Q[i].toString());
		}
		/**/

		fw.close();

	}

	// *
	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////

	public static void points(Point[] points) {
		System.out.println("\n\n------------------------------------------------------------");
		System.out.println("                          POINTS                            ");
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < points.length; i++) {
			System.out.println(i + "_ " + points[i].toString());
		}

		/**/
	}

	////////////////////////////////////////////////////////////////////
	// NOKTALARI GRAFİK HALİNDE EKRANA YAZDIRAN METHOD //
	////////////////////////////////////////////////////////////////////

	public static void graph(Point[] points) {

		int maxX = (int) points[0].getX();
		int maxY = (int) points[0].getY();

		for (int i = 1; i < points.length; i++) {

			if (maxX < (int) points[i].getX())
				maxX = (int) points[i].getX();

			if (maxY < (int) points[i].getY())
				maxY = (int) points[i].getY();
		}

		boolean[][] graph = new boolean[maxX + 1][maxY + 1];

		for (Point point : points) {
			graph[(int) point.getX()][(int) point.getY()] = true;
		}

		System.out.print("\n\n\n");

		for (int i = maxY; i >= 0; i--) {
			System.out.printf("%3d|", i);
			for (int j = 0; j <= maxX; j++) {
				if (graph[j][i] == true) {
					System.out.print("x · ");
				} else {
					System.out.print("· · ");
				}

			}
			if (i != 0) {
				System.out.print("\n    ");
				for (int j = 0; j <= maxX; j++) {
					System.out.print("· · ");
				}
				System.out.print("\n");
			}

		}
		System.out.print("\n   ");
		for (int j = 0; j <= maxX; j++) {
			System.out.print(" ̅  ");
		}
		System.out.print("\n");

		for (int i = 100; i > 0; i /= 10) {
			for (int j = 0; j <= maxX; j++) {
				System.out.printf("  %3d ", j / i);
			}
			System.out.println("");
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////

	}

	public class DosyayaVeriYaz{
}

} // class App sonu