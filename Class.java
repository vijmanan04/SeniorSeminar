
import java.util.ArrayList;
import java.util.Arrays;
public class Class {
	
	ArrayList<Student> students = new ArrayList<Student>();
	
	public void addStudent(Student s1){ // adds a student to the class
		students.add(s1);
	}
	
	public void showClass(){ // prints all Students in the student arrayList to show how many students are in the arrayList
		for (Student student : students){
			System.out.println(student);
		}
	}
}
	


