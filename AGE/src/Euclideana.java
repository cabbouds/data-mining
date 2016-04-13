import java.io.*;

public class Euclideana {

    public static double euclidean(double[] x, double[] y)
    { 
        double sum = 0; 
        for (int i=0; i< Math.min(x.length, y.length); i++)
        { 
            sum += Math.pow(x[i] - y[i], 2); 
        } 
         
        return Math.sqrt(sum); 
    }
	
    private static String arrayToString(double[] array){ 
        StringBuilder res = new StringBuilder("[ "); 
        for (int i=0; i<array.length; i++){ 
            res.append(" "); 
            res.append(String.format("%5.2f", array[i])); 
        } 
        res.append(" ]"); 
        return res.toString(); 
    } 
    
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



public static int vars_matriz=11;
   public static double data [][]=new double [500][vars_matriz+1]; 


   //Aqui leo algo!
  public static int LeeMatriz() throws Exception {
    BufferedReader Fbr;
	try{Fbr=new BufferedReader(new InputStreamReader(new FileInputStream(new File("proyectofinal.dat"))));}
	catch (Exception e){System.out.println("No se encuentra <proyectofinal.dat>");return -1000;}
	int n=0;//Contador de lineas
	String sn;
	while (true){
		sn=Fbr.readLine();//Checo si el archivo trae al menos una linea
		if (sn==null)
			break;
		//endIf
		n++;//Contador del numero de lineas en el archivo
	}//endWhile
	System.out.println(n);
	Fbr=new BufferedReader(new InputStreamReader(new FileInputStream(new File("proyectofinal.dat"))));//Lo vuelvo a abrir
	for (int i=0;i<n;i++){//Por cada linea del archivo
		sn=Fbr.readLine();//Lee del archivo
		String [] input=null;
    	input=sn.split("\t");//Separa los campos deben de ser por tabulador
		for(int j=0;j<vars_matriz;j++){
			data[i][j]=Double.parseDouble(input[j]);
		}
		data[i][vars_matriz] = -1;
	}// endFor
	return n;
  }//endMethod

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	       	double[] x = {3.5, 2, 5, 1.5, 2 }; 
	        double[] y = {2, 3.5, 2, 3.5, 3};
	        double euclidean = euclidean(x, y); 
	        System.out.println("Array x: "+arrayToString(x)); 
	        System.out.println("Array y: "+arrayToString(y)); 
	        System.out.println(String.format("Euclidean distance: %f", euclidean));

	}
}
