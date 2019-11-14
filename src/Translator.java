import java.util.HashMap;
import java.util.Map;

public class Translator {

	static final int msgNumber = 100;
	static int language;
	
	static Map <Integer,String> komunikaty = new HashMap<Integer,String>();
	
	Translator(int lang){
		language=lang;
		createMessages();
	}
	
	Translator(){
		createMessages();
	}
	
	
	
	static public String translate(int msgNum) {
		
		int number = msgNumber*language+msgNum;
		
		return komunikaty.get(number);
		
	}
	
	private void createMessages() {
		
		
		komunikaty.put(100, "Zadanie numer : ");
		komunikaty.put(101, "Przekroczono zasoby systemu zadania nie moga byc przydzielone ");
		komunikaty.put(105, "Zadanie numer : ,Czas startu : ,Rozmiar : ,Deadline : ");
		
		komunikaty.put(200, "Task number : ");
		komunikaty.put(201, "Resources have been exceeded , task can't be assinged ");
		komunikaty.put(205, "Task number : ,Start time : ,Size : ,Deadline : ");
		
		
		
		
	}
	
	
}
