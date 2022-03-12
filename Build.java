import java.util.Scanner;
import java.util.ArrayList;
import java.io.File; // used to read in .csv files

public class Build { // Builds the program and processes necessary data

	public static void main (String[] args) throws Exception {

		ArrayList<String> surveyAnswers = new ArrayList<String>();
		ArrayList<String> sessions  = new ArrayList<String>();


		Scanner scan = new Scanner(new File ("SurveyAnswers.csv"));
		while (scan.hasNext()){
			surveyAnswers.add(scan.next()); // keep adding the information to surveyAnswers
		}
		scan.close();


		scan = new Scanner(new File("Sessions.csv"));
		scan.useDelimiter(",");
		while (scan.hasNext()){
			sessions.add(scan.next()); // keep adding the information to sessions
		}
		scan.close();






		Class c1 = new Class(); // create an instance of a class

		for (int i = 1; i < surveyAnswers.size(); i++){
			String[] preProcessing = surveyAnswers.get(i).split(","); // split the string at each comma, since information is split by commas
			//System.out.println(preProcessing);
			c1.addStudent( new Student(preProcessing) ); // add the student to the class

		}

		for (int i = 3; i < sessions.size(); i+=3){
			ArrayList<String> preProcessing = new ArrayList<String>();
			preProcessing.add(sessions.get(i));
			preProcessing.add(sessions.get(i+1));
			preProcessing.add(sessions.get(i+2));

			c1.addSession(preProcessing);
			preProcessing = new ArrayList<String>();
		}

		c1.showSessions(); // shows class

	}
}
