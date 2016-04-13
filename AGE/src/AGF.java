import java.io.*;

class AGF {
  
  public static double F01(double X,double Y){
/*
 * (1)
 *
 *	Minimizar:	
 *		X^2-2XY+Y^3+X+Y-2
 *	X=-16
 *	Y=-16
 *	F(X,Y)=-4,386
 *
 *	Maximizar
 *		X^2-2XY+Y^3+X+Y-2
 *	X=-16
 *	Y=+16
 *	F(X,Y)=+4,862
 *
 *	N=200
 *	E=4
 *	D=40
 *	Pc=0.95
 *	Pm=0.005
 *	G=1000
 * 
 */
	double Z;
	Z=Math.pow(X,2)-2*X*Y+Math.pow(Y,3)+X+Y-2; 
	return Z;
  }//endF01

  public static double F02(double X){
  double Y;
  /*
   * (2)
   *
   *	Resolver la siguiente ecuación cúbica:
   *
   *	Y=X^3+2.5X^2-2X+1
   *
   *	MINIMIZAR CON LAS RESTRICCIONES
   *
   *  X=-3.2180565 --> Y=0.0000000
   *  N=200
   *  E=4
   *  D=40
   *  Pc=1.000
   *  Pm=.005
   *  G=1000
   */
   Y=X*X*X+2.5*X*X-2*X+1;
   if (Y>0&&Y<=1) return Y;
   if (Y<1)     return 1000d;
   if (Y<10)    return 10000d;
   if (Y<100)   return 100000d;
   if (Y<1000)  return 1000000d;
   if (Y<10000) return 100000000d;
   return 10000000000d;
  }//endF02

  public static double F03(double X,double Y){
/*
 * (3)
 *
 *	Maximizar
 *
 *	N=200
 *	E=4
 *	D=40
 *	Pc=1
 *	Pm=.005
 *	G=5000
 *
 *	X=5
 *	Y=3
 *	F(X,Y)=0
 *
 */
 	return -(X-5)*(X-5)-(Y-3)*(Y-3);
  }//endF03

  public static double F04(double X,double Y){
/*
 * (4)
 *
 *	Minimizar
 *
 *	Z --> 0
 *	N=200
 *	E=4
 *	D=40
 *	Pc=1
 *	Pm=.005
 *	G=1000
 *
 *	(X,Y) = (1.198231,0.706163); Z=0.00000
 *
 *
 */
	double Z;
	Z=Math.pow(X,2)-2*X*Y+Math.pow(Y,3)+X+Y-2; 
	if (Z<0){
		if (Z>-100)
  			return 100000;
  		else
  			if (Z>-1000)
  				return 1000000;
  			else
  				if (Z>-10000)
  					return 100000000;
  				else
  					return 1000000000;
  				//endif
  			//endif
  		//endif
	}//endif
	return Z;
  }//endF04

  public static double F05(double X, double Y){
/*
 * (5)
 *
 */
//  2X+3Y-13=0
//   X-2Y+ 4=0
//  ----------
//  3X+ Y- 9=0
//  X=2; Y=3
/*
 *	USAR:
 *		  2 BITS ENTEROS
 *		 40 BITS DECIMALES
 *		200 INDIVIDUOS
 *		400 GENERACIONES
 *		Pc: 0.9
 *		Pm: 0.02
 */
 	double R1,R2;
	int C=0;
	R1=2*X+3*Y-13;
	R2=X-2*Y+4;
	if (R1>=0) C=C+1;
	if (R2>=0) C=C+1;
	if (C==2) return 3*X+Y-9;
	if (C==1) return 5000000d;
	return 10000000d;
  }//endF05
  
  public static double F06(double array1[],double array2[][]){//recibe 33 vars de centroides y la BD
		 double sum = 0.0;
		 int count = 0;
		 double result = 0.0;
	     for(int i=0;i<array2.length;i++){
			 int aux = -1;
			 for(int j=0;j<(array1.length/11);j++){
				 
				 int temp = 0;
				for(int l=0;l<array2[i].length;l++) {
					temp += Math.pow(array2[i][l]-array1[l+j*11],2);
				}
				if(aux==-1 || temp<aux){
					aux = temp;
				}
			 }
			 sum += Math.sqrt(aux);
			 count++;
	     }
		 result = sum/(double)count;
	     return result;
	  }
} //endClass
