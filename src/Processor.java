import java.util.PriorityQueue;

public class Processor {

	private int computingCapacity;
	private int currTime;
	
	
	
	PriorityQueue <Task> zadania = new PriorityQueue<Task>(); 
	
	
	Processor(int compCapa){
		
		computingCapacity=compCapa;
		currTime=0;
		
	}
	
	public void addTime(int time) {
		currTime+=time;
	}
	
	public void addTask(Task t) {
		
		currTime+=(t.getSize() /computingCapacity);
		zadania.add(t);
		
	}
	
	public int getTime() {
		return currTime;
	}
	public int getCompCapa() {
		return computingCapacity;
	}
	
	public void clearProc() {
		currTime=0;
		zadania.clear();
	}
	
	public String toString() {
		
		String res="";
		
		
			res+=zadania.toString();

		
		
		
		return res;
		
	}
	
	
}
