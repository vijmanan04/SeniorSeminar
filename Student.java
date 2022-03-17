import java.util.ArrayList;
public class Student{
	private String lastName;
	private String firstName;
	private int studentID;
	private int[] choices;
	private String temp = "";
	public Student(String[] info){
		this.choices = new int[info.length - 3]; // everything except first 3 indexes are part of student choices
		this.lastName = info[0];
		this.firstName = info[1];
		this.studentID = Integer.parseInt(info[2]);

		for (int i = 0; i < choices.length; i++){

			this.choices[i] = Integer.parseInt(info[i+3]); // covnvert each choice to an int for easier comparison later
		}
	}

	public int[] getChoices(){
		return choices;
	}

	public String toString(){ // add toString to get information on a student, not just pointer in memory when printing

		for (int val : this.choices){
			temp += " " + val + " ";
		}
		return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Choices: " + temp + "Student ID: " + this.studentID;
	}
}
