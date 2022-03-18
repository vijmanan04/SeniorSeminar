import java.util.ArrayList;
public class Student{
	private String lastName;
	private String firstName;
	private int studentID;
	private int[] choices;
	private String temp = "";

	private String[] sessionMapping = {"Adventure Calls: The Benefits and Challenges of Study Abroad", "Be Your Own Boss: Entrepreneurship Opportunities in College and Beyond", "Business Clubs: Campus Involvement and Professional Development", "College Decisions: Choosing a Historically Black College over a Predominately White Institution", "Community Organizing and College: Participating in Your College's Democracy", "Community Service and Volunteering: Making an Impact as a College Student", "Conquering the Concrete Jungle", "Co-Ops and Engineering Internships: Gaining Professional Experience", "Emergency Medical Technician: Working in the Back of an Ambulance", "Greek Life: From Animal House to Developing Tomorrow's Leaders", "Making an Impact: Being a Leader in Student Government", "On-Campus Recruiting and the Coveted Junior Year Internship in Finance", "So You Want to Play with Swords: Performance Martial Arts and Club Leadership", "The Ins and Outs of Engineering Internships", "The Road Less Traveled: Finding the Right Path for You", "Thriving in a Highly Competitive College Environment", "To Read or Not To Read? Interning in Publishing", "What Is Research When It's Not a Resume Builder?"};

	private ArrayList<Integer> schedule = new ArrayList<Integer>();
	private ArrayList<Integer> times = new ArrayList<Integer>();

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

	public void showClasses(){ // shows the classes with additional formating 
		System.out.print(this.firstName + " " + this.lastName + "\'s class schedule: \n");
		for (int i = 0; i < times.size(); i++){
			System.out.println(sessionMapping[schedule.get(i) - 1] + " at time slot " + (times.get(i) + 1) + " ");
		}
		System.out.println();


	}

	public ArrayList<Integer> getClasses(){
		return schedule;
	}

	public ArrayList<Integer> getClassTimes(){
		return times;
	}

	public void update(int session, int time){ // records each students class schedule
		schedule.add(session);
		times.add(time);
	}
}
