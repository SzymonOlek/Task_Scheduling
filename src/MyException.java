
public class MyException extends Exception {

	
	
	MyException(){
		
	}
	
	MyException(String s){
		System.out.println(s);
	}
	
	MyException(Resource zasoby)throws ResourceException{
	try {
	zasoby.addProcessor();
	}
	catch(ResourceException r){
		throw r;
	}
	}
	
}
