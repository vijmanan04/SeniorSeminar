import java.util.ArrayList;
import java.util.Arrays;
public class Class {

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Speaker> speakers = new ArrayList<Speaker>();
	private ArrayList<Integer> sessions = new ArrayList<Integer>();
	private Permute permuter = new Permute();

	public void addStudent(Student s1){ // adds a student to the class
		students.add(s1);
	}

	public void addSession(Speaker s1){
		sessions.add(s1.getSessionID());
		speakers.add(s1);
	}

	public void showClass(){ // prints all Students in the student arrayList to show how many students are in the arrayList
		for (Student student : students){
			System.out.println(student.toString());
		}
	}

	public void showSessions(){ // prints all Sessions in the session arrayList to show how many sessions are in the arrayList
		for (Speaker speaker : speakers){
			System.out.println(speaker.toString());
		}
	}

	public void makeSessions(){
		int[] sessionPopularity = new int[18];
		for (int i = 0; i < students.size(); i++){
			int[] arr = students.get(i).getChoices();
			for (int j = 0; j < arr.length; j++){
				sessionPopularity[arr[j] - 1] = sessionPopularity[arr[j] - 1] + 1;
			}
		}

		for (int val : sessionPopularity){
			System.out.print(val + " ");
		}


		ArrayList<ArrayList<Student>> preferredStudents = new ArrayList<ArrayList<Student>>();
		for (int i = 0 ; i < sessionPopularity.length; i++){

			preferredStudents.add(new ArrayList<Student>());
			for (Student student : students){
				int[] choices = student.getChoices();
				for (int val : choices){
					if (val == i + 1){
						preferredStudents.get(i).add(student);
					}
				}

				if (preferredStudents.get(i).size() > 30){
					break;
				}
			}
		}

		ArrayList<Integer> repeats = new ArrayList<Integer>();

		int previousMax = 100000;
		for (int i = 0; i < 12; i++){
			int currMax = 0;
			for (int j = 0; j < sessionPopularity.length; j++){
				if (sessionPopularity[i] > currMax && currMax < previousMax){
					currMax = sessionPopularity[i];
					repeats.add(i + 1);
				}
			}
			previousMax = currMax;
		}

		sessions.addAll(repeats);






	}
}
