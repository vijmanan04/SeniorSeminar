// This file contains information for the speaker
import java.util.ArrayList;
public class Speaker{
	private String lastName;
	private String firstName;
	private int sessionID;
	public Speaker(String[] info){
		this.sessionID = Integer.parseInt(info[0]);
		this.lastName = info[2];
		this.firstName = info[1];
	}

	public String toString(){ // add toString to get information on a student, not just pointer in memory when printing
		return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Session ID: " + this.sessionID;
	}

  public int getSessionID(){
    return sessionID;
  }
}
 
