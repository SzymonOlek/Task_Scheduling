import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Homework {

	public static void main(String [] args) {
		
		
		
		int language =1;			//   1 = Polski  ,  2 = English
		
		new Translator(language);
		
		Random rand = new Random();
		
		
		PriorityQueue<Task> zadania = new PriorityQueue<Task>(); 			//lista zadan 
		
		int startT; // czas startu 
		int size;
		int deadL;
		for(int i=0;i<rand.nextInt(30)+20;i++) {

			startT=rand.nextInt(20);
			size = rand.nextInt(20)+1;
			deadL=rand.nextInt(10)+5;
			zadania.add(new Task(startT,size , i,deadL+startT+size));
			
		}
		
		Object[] zadania_copy = zadania.toArray();
				
		Resource zasobyProcesorowe = new Resource(rand.nextInt(8)+5);
		
		boolean przekroczono_zasoby=false;
		
		while(zadania.isEmpty() == false) {
			try 
			{
			zasobyProcesorowe.przydziel(zadania);
			
			}
			catch(ResourceException r) {
				zadania.clear();
				przekroczono_zasoby=true;
			}
			catch(MyException e) {
				
				//System.out.println("**********************" +temp);
				zadania.clear();

				for(int i=0;i<zadania_copy.length;i++) {
					zadania.add((Task)zadania_copy[i]);
				}
				
			}
		}
		if(przekroczono_zasoby==false)
		System.out.println(zasobyProcesorowe.toString());
		
		
		
	}
}
