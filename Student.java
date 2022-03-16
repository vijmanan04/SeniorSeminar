import java.util.ArrayList;
public class Student{
	private String lastName;
	private String firstName;
	private int[] choices;
	public Student(String[] info){
		this.choices = new int[info.length - 2]; // everything except first 2 indexes are part of student choices
		this.lastName = info[0];
		this.firstName = info[1];

		for (int i = 0; i < info.length - 2; i++){
			this.choices[i] = Integer.parseInt(info[i+2]); // covnvert each choice to an int for easier comparison later
		}
	}
	
	public int[] getChoices(){
		return choices;
	}

	public String toString(){ // add toString to get information on a student, not just pointer in memory when printing
		return "Name: " + this.firstName + " " + this.lastName + " Choices: " + this.choices;
	}
}
