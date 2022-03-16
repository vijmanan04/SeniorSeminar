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
			String[] preProcessing = new String[3];
			preProcessing[0] = sessions.get(i);
			preProcessing[1] = sessions.get(i+1);
			preProcessing[2] = sessions.get(i+2);
			c1.addSession( new Speaker(preProcessing) ); // add the student to the class

		}
		
		/*

		for (int i = 3; i < sessions.size(); i+=3){ // start at 3 because the first 3 are just headers; increment 3 because 3 columns
			ArrayList<String> preProcessing = new ArrayList<String>(); // temporary ArrayList for prcoessing
			preProcessing.add(sessions.get(i)); // add information pertinenet to one presenter
			preProcessing.add(sessions.get(i+1)); // add information pertinenet to one presenter
			preProcessing.add(sessions.get(i+2)); // add information pertinenet to one presenter

			c1.addSession(preProcessing); // add all the pertinenent information to one presenter as an ArrayList 
			preProcessing = new ArrayList<String>(); // reset the preProcessing ArrayList
		}
		*/

		c1.makeSessions(); // shows class

	}
}
