
public class Task implements Comparable<Task> {

	private int startTime;
	private int size;
	private int taskNum;
	private int deadLine;
	
	Task(){
		
	}
	
	
	Task(int start, int size, int number, int dead){
		
		startTime=start;
		this.size=size;
		taskNum=number;
		deadLine=dead;
		
		
	}
	
	public String allInfo() {

		String [] s = new String [4];
			s=Translator.translate(5).split(",");
		
		String result = s[0] + taskNum + " " + s[1] + startTime + " " + s[2] + size + " " + s[3] + deadLine ; 
	
	return result;
		
	}
	
	
	
	public String toString() {
		
		
		return Translator.translate(0) +taskNum;
	}




	@Override
	public int compareTo(Task arg0) {
		
		if(arg0.startTime>this.startTime) return -1;
		
		if(arg0.startTime==this.startTime)return compareTo2(arg0);
		
		return 1;
		
	}
	
	public int compareTo2(Task arg0) {
		if(arg0.size > this.size) return -1;
		if(arg0.size==this.size)return 0;
		
		return 1;
	}
	
	public int getDeadLine() {
		return deadLine;
	}
	public int getSize() {
		return size;
	}
	public int getStartTime() {
		return startTime;
	}
	
}
