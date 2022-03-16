import java.util.ArrayList;
public class Speaker{
	private String lastName;
	private String firstName;
	private String sessionID;
	public Speaker(String[] info){
		this.sessionID = info[0]; 
		this.lastName = info[2];
		this.firstName = info[1];
	}
	
	public String toString(){ // add toString to get information on a student, not just pointer in memory when printing
		return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Session ID: " + this.sessionID;
	}
}
