package AlgAraSinav;


import java.util.ArrayList;
//import java.util.Arrays;     // Ql ve QR yi sıralamak için ikinci method seçilirse kullanılacak
//import java.util.Comparator; // Ql ve QR yi sıralamak için ikinci method seçilirse kullanılacak


public class Point {

	public double x;
	public double y;

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return this.x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return this.y;
	}


	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}


////////////////////////////////////////////////////////
//              BRUTE FORCE METHOD                    //
////////////////////////////////////////////////////////

	public static Point[] getClosestPair(Point[] noktalarP) {
		
		
		

		if (noktalarP.length < 2 ){
			System.out.println("!!! Enter an array for BRUTE FORCE SORT that contains at least TWO POINTS !!! \\n\n\n");
		}

		ArrayList<Point> listOfClosestPoints = new ArrayList<Point>();    //en yakın noktaların tutulacağı liste
		
		double distOfPoints = 0.0;                                        //minumum mesafe değerini tutacak 

		double distOfClosestPoints = dist(noktalarP[0], noktalarP[1]);    //ilk karşılaştırma için seçilen minumum mesafe 

		for (int i = 0; i < noktalarP.length; i++) {                      //tüm noktalar biribiri ile karşılaştırılır

			for (int j = i + 1; j < noktalarP.length; j++) {

				distOfPoints = dist(noktalarP[i], noktalarP[j]);		
				
				if (  distOfPoints <= distOfClosestPoints  ) {

					if (distOfPoints < distOfClosestPoints ) {
						
						distOfClosestPoints = distOfPoints;
						listOfClosestPoints.clear();
					}
						
					listOfClosestPoints.add(noktalarP[i]);
					listOfClosestPoints.add(noktalarP[j]);
					
				}

			}// iç for soun
		}//dış for sonu
		
		return  listOfClosestPoints.toArray(new Point[0]);

	}



/////////////////////////////////////////////////////////////////
//                 DIVIDE AND CONQUER METHOD                   //
/////////////////////////////////////////////////////////////////


	public static Point[] getClosestPair(Point[] noktalarP, Point[] noktalarQ) {

		ArrayList<Point> closestPoints = new ArrayList<Point>();           //en yakın noktaların tutulduğu liste
		
		if (noktalarP.length <= 3){                                        //Üç nokta ve altında brute force uygulanır
		

			if (noktalarP.length == 2){                                     //iki nokta varsa noktalar işlemsiz döndürülür
					return noktalarP;
			}
			
			double distOfMin = rnd(  dist(noktalarP[0], noktalarP[1])  );   //bulunan minumum mesafeyi tutacak 

			double distOfPoints;                                            //karşılaştırılan noktalar arası mesafe
				
			

			for (int i = 0; i < noktalarP.length; i++) {                    //3 nokta brute force methodu ile karşılaştırılır

				for (int j = i + 1; j < noktalarP.length; j++) {

					distOfPoints = dist(noktalarP[i], noktalarP[j]);
	
					if (distOfPoints <= distOfMin ) {				
	
						if (distOfPoints < distOfMin) {

							distOfMin = distOfPoints;
							closestPoints.clear();
						}
						
						closestPoints.add(noktalarP[i]);
						closestPoints.add(noktalarP[j]);				
					}
				}
			}
			
			return closestPoints.toArray(new Point[0]);                               //üç noktadan en yakın olan ikililer döndürülür

		}else{//nokta sayısı üç ten fazla ise else çalışır
			
			int median = (noktalarP.length)/2-1;                                       //median, nokta sayısı tek ise P sıralı listedeki en ortadaki elemanın indisi olacak ve sol yarıya ait olacak
			//                                                                       	//median, nokta sayısı çift ise P sıralı listenin sol  yarısında kalan en sağdaki eleman olacaktır 
			Point [] PL = new Point [median + 1];                                      //P sıralı listenin ilk yarısı PL ye
			Point [] PR = new Point [noktalarP.length-(median + 1)];							//kalanı da PR ye kopyalanır
		
			System.arraycopy(noktalarP, 0, PL, 0, median+1);
			System.arraycopy(noktalarP, median+1, PR, 0, noktalarP.length-(median +1));

			Point [] QL = PL.clone();                                                  //PL, QL ye kopyalanır ve Y eksenine göre sıralanır
			Point [] QR = PR.clone();                                                  //PR, QR ye kopyalanır ve Y eksenine göre sıralanır
			
			
			/*
			Arrays.sort(QL, new Comparator <Point>(){                                  //Sıralama işlemi yandaki gibi Arrays.sort kullanılarak yapılabilir
         //                                                                         //ancak elimizde Y ye göre sıralı liste olduğundan aşağıda bu hazır 
			//                                                                         //liste ye göre sıralama yapıldı.
				@Override                                                             
				public int compare (Point point1, Point point2){                        //Point nesnesini Y ye göre sıralamak için yeni bir Comparator tanımlanır
					if(point1.getY() > point2.getY()){
						return 1;
					}
					else if(point1.getY() < point2.getY()){
						return -1;
					}
					else{
						return 0;
					}
				}
			});

			Arrays.sort(QR, new Comparator <Point>(){
				@Override
				public int compare (Point point1, Point point2){
					if(point1.getY() > point2.getY()){
						return 1;
					}
					else if(point1.getY() < point2.getY()){
						return -1;
					}
					else{
						return 0;
					}
				}
			});
			/**/


			/*Y ye göre sıralı QL ve QR listeleri elde etme*/

			//while döngüsü ile elimizde Y ye sıralı olan noktalarQ listesinde ki noktaların X değerleri
			//ile noktalarP listesinin medianının X değeri karşılaştırılır. medianın sağında kalanlar
			//QR listesine eklenir. diğerleri ise QL listesine eklenir. Y ye göre sıralı QL ve QR elde edilir.
			
			int count1 = 0;
			int count2 = 0;
			int k = 0;
			
			while( k != count1 + count2 ) {

				if ( noktalarQ[k].getX() > PR[median].getX()){

					if(count1 < QR.length){
						QR[count1] = noktalarQ[k];
						count1++;
					}

				}
				else{

					if (count2 < QL.length){
						QL[count2] = noktalarQ[k];
						count2++;
					}

				}
					
				k++;
					
			}//while sonu
			

			Point [] pointsL = getClosestPair(PL, QL);                     //ikiye bölünen noktalarP ve noktalarQ
			Point [] pointsR = getClosestPair(PR, QR);                     //listeleri recursive hesaplama için gönderilir
				

			double dl = rnd( Math.sqrt(   dist(pointsL[0], pointsL[1])   ) );   //yukarıdan geri dönen en yakın noktaların aradaki mesafesi hesaplanır
			double dr = rnd( Math.sqrt(   dist(pointsR[0], pointsR[1])   ) );
						

			if (dl == dr){                                                 //hesaplanan mesafelere göre karşılaştırma yapılır ve 
				//                                                          //pointsL ve pointsR içindeki en kısa mesafeye sahip
				//                                                          //nokta çiftleri closestPoints listesine eklenir
				for (int i = 0; i < pointsL.length; i+=2) {
					
					closestPoints.add( pointsL[i] );
					closestPoints.add( pointsL[i+1] );
					
				}

				for (int i = 0; i < pointsR.length; i+=2) {

					closestPoints.add( pointsR[i] );
					closestPoints.add( pointsR[i+1] );
				}

			}else if ( dl < dr ) {

				for (int i = 0; i < pointsL.length; i+=2) {

					closestPoints.add( pointsL[i] );
					closestPoints.add( pointsL[i+1] );
				}				
				
			}else{
	
				for (int i = 0; i < pointsR.length; i+=2) {

					closestPoints.add( pointsR[i] );
					closestPoints.add( pointsR[i+1] );
				}

			}// if sonu, dl ve dr karşılaştırmasının sonu

			

			double d = rnd( Math.min(dl, dr) );            //Buradan itibaren pointsL ve pointsR içersinide median ın sağında
			double dsq = rnd(d*d);                         //ve solunda kalan noktalar karşılaştırılır. soldaki bir nokta sağdaki
			//                                             //tüm noktalar ile karşılaştırılır ancak kendi tarafındaki bir nokta ile
			//                                             //karşılaştırma yapılmaz, çünkü kendi aralarında zaten karşılaştırıldılar.			
								

			for (int i = QL.length-1 ; i > QL.length-4 && i >= 0; i--) {   //en fazla karşılaştırılması gereken nokta sayısı 8 dir.
			//                                                             //çünkü en kötü ihtimalde medianın sağında ve solunda
			//                                                             //en fazla 4 er nokta kalabilir.
				for (int j = 0; j < 4 && j < QL.length; j++) {
					
					if (  rnd((  Math.abs( QL[i].getY() - QR[j].getY() ))  ) <= d  ){      //noktaların Y eksenine göre farklarının mutlak değeri
					//                                                                     //d den küçük veya eşitse closest point olabilirler.
						double dist =  dist(QL[i], QR[j]);

						if( dist <= dsq ){

							if(dist < dsq){
								dsq = dist;
								closestPoints.clear();
							}

							closestPoints.add( QL[i] );
							closestPoints.add( QR[j] );
							
						}

					
					}//if sonu
				
				}//iç for sonu
									
			}//dış for sonu		

		} //method başındaki if, else bloğu else sonu
		
		return closestPoints.toArray(new Point[0]);

	} // METHOD getClosestPair() sonu



/////////////////////////////////////////////////////////////////
//        METHOD    dist(Point point1, Point point2)            //
/////////////////////////////////////////////////////////////////

		//argüman olarak alınan iki Point nesnesi arasındaki mesafesin karesini döndürür. karekök yok!!

	public static double dist(Point point1, Point point2) {
		double dist1 = point1.getX() - point2.getX();
		double dist2 = point1.getY() - point2.getY();
		double dist = dist1*dist1+dist2*dist2;
		
		return rnd(dist);
	
	}



////////////////////////////////////////////////////////////////////////////////////
//        METHOD    queryPoint(Point A, Point B, ArrayList<Point> list)           //
////////////////////////////////////////////////////////////////////////////////////
/*

		//A ve B nokta ikililerinin list içerisinde A,B ya da B,A şeklinde çift olup olmadıklarını sorgular
		//noktalar list içersinde ise true değeri aksi durumda false değeri döndürür

	private static boolean queryPoint(Point A, Point B, ArrayList<Point> list){
		
		double AX = A.getX();
		double AY = A.getY();
		double BX = B.getX();
		double BY = B.getY();

		for (int i = 0; i < list.size(); i++) {

			double pointX = list.get(i).getX();
			double pointY = list.get(i).getY();

			if(   pointX == AX && pointY == AY   ){
				
				if (i % 2 == 0){

					if (list.get(i+1).getX() == BX && list.get(i+1).getY() == BY ){
						
						return true;
					}
				
				}

				if ( i % 2 != 0 ){
					
					if (list.get(i-1).getX() == BX && list.get(i-1).getY() == BY ){
						
						return true;
					}
					
				}
				//BURAYA daha az çalışması için BREAK konulamaz çünkü aynı noktadan başka çiftlerin içinde olabilir
			}
			
		}// for sonu

		return false;
		
	}/**///METHOD queryPoint sonu

//NORMALDE DOUBLE/FLOAT SAYILAR KARŞILAŞTIRILAMAZ ÇÜNKÜ BINARY SİSTEMİN KÜSÜRAT HATASINDAN DOLAYI
//YAPILAN BASİT TOPLAMA VE ÇARPMA GİBİ İŞLEMLERİN SONUNDA, VİRGÜLDEN SONRAKİ SON BASAMAKLAR ANLAMSIZ DEĞERLER ALACAKTIR.
//BU YÜZDEN VİRGÜLDEN SONRA BELLİ BASAMAK SAYISI SEÇİLEREK DOUBLE DEĞERLER KARŞILAŞTIRILMALIDIR.
//BU ÖDEV DE BUNA GEREK GÖRÜLMEMİŞTİR.

/////////////////////////////////
//   METHOD   rnd(double a)    //
/////////////////////////////////
        //alınan double sayıyı, virgülden sonraki 3 basamağa yuvarlayarak döndürür.

	public static double rnd(double a){
		a = Math.round(a*1000);
		a /=1000;
		return a;
	}

	

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}


} //class Point Soun