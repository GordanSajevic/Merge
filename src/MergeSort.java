import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MergeSort {
	
	/**
	 * Funkcija prima jedan niz i poziva rekurzivnu funkciju, te vraæa sortirani niz
	 * @param array
	 * @return array
	 */
	
	public static int[] sortirajNiz(int[] array)
	{	
			int pocetak = 0;
			int kraj = array.length-1;
			sortirajRekurzivno(array, pocetak, kraj);
		
		return array;
		
	}
	
	/**
	 * Funkcija dijeli niz na dva dijela i ponavlja se rekurzivno, sve dok ne ostane samo 
	 * jedan èlan. Svaki put se poziva funkcija koja sastavlja èlanove niza sortirano
	 * @param array
	 * @param pocetak
	 * @param kraj
	 */
	
	private static void sortirajRekurzivno(int[] array, int pocetak, int kraj) {
		
		if(pocetak < kraj)
		{
			int sredina = pocetak +(kraj-pocetak)/2;
			System.out.println("Poèetak: " + pocetak + ", sredina: " + sredina + ", kraj: " + kraj);
			sortirajRekurzivno(array, pocetak, sredina);
			sortirajRekurzivno(array, sredina+1, kraj);
			sastaviNiz(array, pocetak, sredina, kraj);
		}
		
	}
	
	/**
	 * Funkcija kopira sve èlanove niza u jedan pomoæni niz, a zatim vraæa te èlanove 
	 * prvom nizu sortirano. Funkcija koristi dva brojaèa, tako da jedan brojaè broji
	 * èlanove niza od poèetka do sredine, a drugi od sredine do kraja. Nizovi se porede
	 * pomoæu brojaèa, tako da niz uvijek prvo dobije manji èlan. 
	 * @param array
	 * @param pocetak
	 * @param sredina
	 * @param kraj
	 */
	
	private static void sastaviNiz(int[] array, int pocetak, int sredina, int kraj) {
		int [] pomocni = new int [kraj+1];
		for (int i=pocetak; i<=kraj; i++)
		{
			pomocni[i] = array[i];
		}
		int i=pocetak;
		int j=sredina+1;
		int k=pocetak;
		while (i<=sredina && j<=kraj)
		{
			if (pomocni[i] <= pomocni[j])
			{
				array[k] = pomocni[i];
				i++;
			}
			else
			{
				array[k] = pomocni[j];
				j++;
			}
			k++;
		}
		while(i <= sredina)
		{
			array[k] = pomocni[i];
			i++;
			k++;
		}
	}

	/**
	 * Funkcija ispisuje sve èlanove jednog niza
	 * @param array
	 */
	
	private static void printArray(int[] array)
	{
		for (int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		int[] array = new int[20];
		FileReader fr = new FileReader("C:/Users/Gogo/workspace/Merge/src/numbers.txt");
		BufferedReader reader = new BufferedReader(fr);
		for (int i=0; i<20; i++)
		{
			String str = reader.readLine();
			str = str.trim();
			array[i] = Integer.parseInt(str);
		//	array[i] = 1+ (int)(Math.random()*100);
		} 
		System.out.println("Niz: ");
		printArray(array);
		System.out.println();
		sortirajNiz(array);
		System.out.println("Sortirani niz: ");
		printArray(array);
	}

}
