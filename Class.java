import java.util.ArrayList;
import java.util.Arrays;
public class Class {

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Speaker> sessions = new ArrayList<Speaker>();

	public void addStudent(Student s1){ // adds a student to the class
		students.add(s1);
	}

	public void addSession(Speaker s1){
		sessions.add(s1);
	}

	public void showClass(){ // prints all Students in the student arrayList to show how many students are in the arrayList
		for (Student student : students){
			System.out.println(student.toString());
		}
	}

	public void showSessions(){ // prints all Sessions in the session arrayList to show how many sessions are in the arrayList
		for (Speaker session : sessions){
			System.out.println(session.toString());
		}
	}
	
	public void makeSessions(){
		int[] sessionPopularity = new int[18];
		for (int i = 0; i < students.size(); i++){
			int[] arr = students.get(i).getChoices();
			for (int j = 0; i < arr.length; j++){
				sessionPopularity[arr[j] - 1] = sessionPopularity[arr[j] - 1] + 1;
			}
		}
		
		for (int val : sessionPopularity){
			System.out.print(val);
		}
	}
}
