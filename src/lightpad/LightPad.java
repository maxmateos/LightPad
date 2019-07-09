/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lightpad;

/**
 *
 * @author max
 */
import java.io.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.lang.Math;
public class LightPad {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opcion=-1,dif=-1;
	int [][] matriz=new int[1][1];

	//imprime LightPad
	imprimir(" .-.   .-. .---. .-. .-. .---.    .----.  .--.  .----. \n | |   | ||   __}| {_} |{_   _}   | {}  }| {} | | {} | \n | `--.| ||  {_ }| { } |  | |     | .--' | || | |    | \n `----'`-' `---' `-' `-'  `-'     `-'    `-'`-' `----' \n \n ====================================================================\n \n Instrucciones: En lightPad, debe buscar iluminar todo el tablero,\n o sea, llenar de 1s todo el tablero, puede escoger el tamano y la\n dificultad. Para ganar, seleccione una coordenada y todos los cuadros\n adyacentes invertiran su estado actual.");

	while(opcion!=0)
	{

		opcion=ingresarRango(4," \n Ingrese la opcion que desee: \n 1) 3*3 \n 2) 4*4 \n 3) 5*5 \n 0) Salir \n");

		if(opcion!=0)
		{
			opcion+=2;
			//crea el tablero inicial

			dif=ingresarRango(4," \n Seleccione la dificultad que desea:\n 0) Aprende a Jugar (3 Movimientos) \n 1) Principiante (5 Movimientos) \n 2) Intermedio(10 Movimientos) \n 3) Experto (20 Movimientos) \n");
			matriz=crearTablero(opcion,dif);
			imprimir("\n\n\n\n");
			juego(matriz,opcion);
		}

		opcion=ingresarRango(2,"Volver a jugar? \n 1) Si \n 0) No");
	}

	System.out.println("Adios!");

    }
    public static void juego(int [][]matriz,int opcion)
{
	String conc="\n\n";
	int x=0,y=0;
	boolean ganador=false;
	while(!ganador)
	{
	for(int i=0;i<opcion;i++)
			{
				for(int ii=0;ii<opcion;ii++)
				{
					conc+=""+matriz[i][ii];
				}
				conc+="\n";
			}
				imprimir(conc);
			conc="\n\n";


	x=ingresarRango(opcion,"Ingrese las coordenadas del punto que desea accionar, la esquina izquierda \n superior es (0,0) \nCoordenada X:");
	y=ingresarRango(opcion,"Coordenada Y:");

	for(int ii=-1;ii<2;ii++)
			{
				if(ii!=0)
				{
				if(y+ii>-1 && y+ii<opcion)
					if(matriz[y+ii][x]==1)
					matriz[y+ii][x]=0;
					else
					matriz[y+ii][x]=1;

					if(x+ii>-1 && x+ii<opcion)
					if(matriz[y][x+ii]==1)
					matriz[y][x+ii]=0;
					else
					matriz[y][x+ii]=1;
				}
				else
				{
				if(matriz[y][x]==1)
				matriz[y][x]=0;
				else
				matriz[y][x]=1;
				}
			}
			ganador=true;
	for(int i=0;i<opcion;i++)
	for(int ii=0;ii<opcion;ii++)
	{
		if(matriz[i][ii]==0)
		ganador=false;
	}
		}
		imprimir("\n\n\n\nFELICIDADES!! HA GANADO \n\n\n!!" );

}
public static int [][] crearTablero(int opcion,int dificultad)
{
	//crea una matriz del tamanio que escogio el usuario
	int [][] matriz=new int[opcion][opcion];
	int randomX=0,randomY=0;
	//llena la matriz de unos para empezar a revolverlo
	for(int i=0;i<opcion;i++)
	for(int ii=0;ii<opcion;ii++)
	{
		matriz[i][ii]=1;
	}

	//Numero de movimientos para resolver el acertijo
	if(dificultad==3)
	dificultad=20;
	if(dificultad==2)
	dificultad=10;
	if(dificultad==1)
	dificultad=5;
	if(dificultad==0)
	dificultad=3;

	for(int i=0;i<dificultad;i++)
	{
		randomX = (int)(Math.random()*opcion);
		randomY =  (int)(Math.random()*opcion);
		//imprime la respuesta al reves
		//imprimir("ye="+randomY+", equis="+randomX);
		//escoge coordenadas al azar para crear el rompecabezas
		for(int ii=-1;ii<2;ii++)
		{
			if(ii!=0)
			{
			if(randomY+ii>-1 && randomY+ii<opcion)
			if(matriz[randomY+ii][randomX]==1)
				matriz[randomY+ii][randomX]=0;
			else
				matriz[randomY+ii][randomX]=1;

			if(randomX+ii>-1 && randomX+ii<opcion)
			if(matriz[randomY][randomX+ii]==1)
			matriz[randomY][randomX+ii]=0;
			else
			matriz[randomY][randomX+ii]=1;
			}
			else
			{
			if(matriz[randomY][randomX]==1)
			matriz[randomY][randomX]=0;
			else
			matriz[randomY][randomX]=1;
			}
		}

	}



	return matriz;
}

public static void imprimir(String imprimir)
{
	System.out.println(imprimir);
}

public static int ingresarRango(int opcion,String mensaje)
	{
		int ingresar=-1;
		boolean mal=false;
	while(ingresar==-1)
	{
		ingresar=0;
		mal=false;
		imprimir(mensaje);
		try
	{
		ingresar = Integer.parseInt(in.readLine());

	}
	catch (NumberFormatException  ex)
	{
		mal=true;
	}
	catch(IOException ex)
	{
		mal=true;
	}
	if(mal ||ingresar<0 || ingresar >opcion-1)
	{
	System.out.println("La opcion no es correcta");
	ingresar=-1;
	}
	}
	return ingresar;
	}
}
