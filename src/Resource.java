import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Resource {

	private int maxProcNum;
	public int currProcNum;
	
	ArrayList<Processor> processors = new ArrayList<Processor>();
	
	Resource(int max){
		
		maxProcNum=max;
		currProcNum=1;
		
		Random rand2 = new Random();
		
		for(int i=0;i<maxProcNum;i++) {
			processors.add(new Processor(rand2.nextInt(3)+1));
		}
		
	}
	
	
	private int getProcess() {
		
		int res=0;
		int time=processors.get(0).getTime();
		
		for(int i=0;i<currProcNum;i++) {
			if(processors.get(i).getTime() < time)
				res=i;
		}
		
		return res;
		
	}
	
	public void przydziel(PriorityQueue<Task> zadania) throws MyException , ResourceException {
		
		Task temp = new Task();
		temp=zadania.poll();
		
		while(zadania.isEmpty() == false) {
			try 
			{
			tryAddTask(temp);
			temp=zadania.poll();
			}
			catch(ResourceException r) {
				throw r;
			}
			catch(MyException e) {
				
				for(int i=0;i<currProcNum;i++) {
					processors.get(i).clearProc();
					
				}
				throw new MyException();

			}
		}
		
		
		
	}
	
	
	public void tryAddTask(Task t) throws MyException ,ResourceException {
		
		boolean alreadyAdded=false;
		
		int p=getProcess();
			
			if(processors.get(p).getTime() + t.getSize()/processors.get(p).getCompCapa() <= t.getDeadLine() && alreadyAdded==false) {
				
				if(processors.get(p).getTime() >= t.getStartTime()) {
					
					processors.get(p).addTask(t);
					alreadyAdded=true;
		//			System.out.println(" dodano w etapie 1"+t.allInfo());
					
				}
				else {
					
					int diff= (t.getStartTime() - processors.get(p).getTime());
					
					if(processors.get(p).getTime()+diff  + t.getSize()/processors.get(p).getCompCapa() < t.getDeadLine() ) {
						
						processors.get(p).addTime(diff);
						processors.get(p).addTask(t);
						alreadyAdded=true;
			//			System.out.println(" dodano w etapie 2 "+t.allInfo());
						
					}
					else {
						//System.out.println("wyjatejk" +t.allInfo());
						throw new MyException(this);		// za mala liczba procesorow
					}
						
				}				
			}
				
			
			
		
		if(alreadyAdded == false)
		throw new MyException(this);
		
	}
	
	public void addProcessor() throws ResourceException {
		if(currProcNum < maxProcNum) {
		
			currProcNum++;
		}else {
			throw new ResourceException();
		}
		
	}
	

	public String toString() {
		String result="";
		
		for(int i=0;i<currProcNum;i++) {
			
			result+="Procesor " +(i+1);
			result+="\n";
			result+=processors.get(i).toString();
			result+="\n";
		}
		
		return result;
	}
	
}
