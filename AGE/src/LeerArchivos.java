import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeerArchivos 
{

	public static double Bds[][]=new double [500][11];

	public static void main(String[] args) throws IOException 
  { 

		        String thisLine = null;
		        BufferedReader br;
		        br = new BufferedReader(new FileReader("BDPreProc.txt"));
		        int filas=0,columnas = 0;
		        while ((thisLine = br.readLine()) != null) 
		        {
		        	String[] input=thisLine.split("\t");
		        	for (columnas=0; columnas<input.length; columnas++)
		        	{
		        		Bds[filas][columnas]= Double.parseDouble(input[columnas]);
		        		System.out.println("bd[" + filas + "]["+columnas+"] "+ Double.parseDouble(input[columnas]));
		        	}
		        	
		        	filas++;
		        }
		        br.close();
		        System.out.println("Terminado");
		        	        
  }
}



 
 