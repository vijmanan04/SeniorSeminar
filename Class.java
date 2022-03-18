// This file is the one that contains all the logical functions for the program for making the class and organizing the speakers and students
import java.util.ArrayList;
import java.util.Arrays;
public class Class {

	private ArrayList<Student> students = new ArrayList<Student>(); // all students
	private ArrayList<Speaker> speakers = new ArrayList<Speaker>(); // all speakers
	private ArrayList<Integer> sessions = new ArrayList<Integer>(); // all speaker sessions

	// variables that will be used in summary part of program
	private int noChoices = 0;
	private int totalNoChoices = 0;
	private int[] remainingSessions = new int[18]; // counts how many available spaces left once non-selected student choices are assigned to students

	private String[] sessionMapping = {"Adventure Calls: The Benefits and Challenges of Study Abroad", "Be Your Own Boss: Entrepreneurship Opportunities in College and Beyond", "Business Clubs: Campus Involvement and Professional Development", "College Decisions: Choosing a Historically Black College over a Predominately White Institution", "Community Organizing and College: Participating in Your College's Democracy", "Community Service and Volunteering: Making an Impact as a College Student", "Conquering the Concrete Jungle", "Co-Ops and Engineering Internships: Gaining Professional Experience", "Emergency Medical Technician: Working in the Back of an Ambulance", "Greek Life: From Animal House to Developing Tomorrow's Leaders", "Making an Impact: Being a Leader in Student Government", "On-Campus Recruiting and the Coveted Junior Year Internship in Finance", "So You Want to Play with Swords: Performance Martial Arts and Club Leadership", "The Ins and Outs of Engineering Internships", "The Road Less Traveled: Finding the Right Path for You", "Thriving in a Highly Competitive College Environment", "To Read or Not To Read? Interning in Publishing", "What Is Research When It's Not a Resume Builder?"}; // session namse


	public void addStudent(Student s1){ // adds a student to the class
		students.add(s1);
	}

	public void addSession(Speaker s1){
		sessions.add(s1.getSessionID()); // add a session to the speakers arrayList
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

	public ArrayList<ArrayList<Integer>> makeSessions(){
		int[] sessionPopularity = new int[18];
		for (int i = 0; i < students.size(); i++){ // this for-looop calculates which sessions are more popular
			int[] arr = students.get(i).getChoices();
			for (int j = 0; j < arr.length; j++){
				sessionPopularity[arr[j] - 1] = sessionPopularity[arr[j] - 1] + 1;
			}
		}


		ArrayList<Integer> repeats = new ArrayList<Integer>();

		int previousMax = 100000;
		for (int i = 0; i < 12; i++){ // this for-loop makes the most popular sessions repeat again
			int currMax = 0;
			for (int j = 0; j < sessionPopularity.length; j++){
				if (sessionPopularity[i] > currMax && currMax < previousMax){
					currMax = sessionPopularity[i];
					repeats.add(i + 1);
				}
			}
			previousMax = currMax;
		}

		sessions.addAll(repeats); // adds repeating sessions to all sessions

		ArrayList<ArrayList<Integer>> schedule = new ArrayList<ArrayList<Integer>>(); // this holds the schedule for the day for all session, in their correct order
		int index = 0;
		for (int time = 0 ; time < 5 ; time++){ // this for-loop places all sessions in the correct order
			ArrayList<Integer> temporary = new ArrayList<Integer>();
			for (int room = 0 ; room < 6 ; room++){
				temporary.add(sessions.get(index)); // don't need to check for duplicates in this step because previous step ensures that their will be none
				index++;
			}
			schedule.add(temporary);
		}

		return schedule; // returns for sorted-out schedule

	}

	public void placeStudents(ArrayList<ArrayList<Integer>> sesh){

		ArrayList<ArrayList<Integer>> counts = new ArrayList<ArrayList<Integer>>();
		boolean exitFlag = false;
		int startTime = 0;

		for (int time = 0; time < 5; time++){ // this for-loop just initializes the counts array to the correct dimensions
			counts.add(new ArrayList<Integer>());
			for (int room = 0; room < 6; room++){
				counts.get(time).add(0);
			}
		}



		for (int i = 0; i < students.size(); i++){ // thus for-loop places the students by optimizing by response time and sll given responses
			int[] studentPreferences = students.get(i).getChoices();
			startTime = 0;

			for (int j = 0; j < studentPreferences.length; j++){
				int currChoice = studentPreferences[j];
				exitFlag = false; // need this to exit the outer for-loop ocassionally
				for (int time = startTime; time < 5; time++){
					if (exitFlag){ // exit the outer for-loop
						break;
					}
					for (int room = 0; room < 6; room++){
						if (sesh.get(time).get(room) == currChoice && counts.get(time).get(room) <= 30){ // prevents double-placement

							counts.get(time).set(room, counts.get(time).get(room) + 1); // add to count because can only have 30 at most for a given time and session
							students.get(i).update(sesh.get(time).get(room), time); // updates each indivual student with their event information
							startTime = time + 1;
							exitFlag = true;
							break;
						}
					}
				}
			}
		}

		ArrayList<Student> needMore = new ArrayList<Student>(); // counts number of students needing more placements
		for (Student s : students){ // for-loop adds the students needing more events
			if (s.getClasses().size() < 5){
				needMore.add(s);
			}

		}


		for (int i = 0; i < needMore.size(); i++){ //this for-loop counts how many people have been schduled in each session already
			int[] arr = students.get(i).getChoices();
			for (int j = 0; j < arr.length; j++){
				remainingSessions[arr[j] - 1] = remainingSessions[arr[j] - 1] + 1;
			}
		}



		int flag = 0; // used for summary metric counting
		for (int i = 0; i < remainingSessions.length; i++){

			if (remainingSessions[i] < 30){
				for (Student student : needMore){
					flag = 0;
					ArrayList<Integer> bookedTimes = student.getClassTimes(); // find which times the student already has an event

					for (int time = 0; time < 5; time++){
						if (!bookedTimes.contains(time) && !student.getClasses().contains(i)){ // if student is free and hasn't already done that session, give the student another session
							student.update(i, time); // update student classes schdules with new sessions
							remainingSessions[i]++; // add to count for session because can't have more than 30 at a time
							totalNoChoices++; // used for summary/metrics
							if (flag == 0){
								noChoices++;
								flag = 1;
							}

						}
					}
				}
			}
		}



	}


	public void showSchedule(){ // prints large-scale summary of whole process
		System.out.println("____________________________________");
		System.out.println("Schedules");
		System.out.println("____________________________________\n\n");
		for (Student student : students){
			student.showClasses();
		}

		System.out.println("____________________________________");

		System.out.println("SUMMARY");
		System.out.println("____________________________________\n\n");
		System.out.println("Number of times students got a choice they didn't ask for: " + totalNoChoices);
		System.out.println("On average, that is " + totalNoChoices / 70 + " choices a student didn't ask for for each student");


		System.out.println("\n\n\nIndividual Counts (some numbers are above 30 because those sections occur twice; nothing shoudl be above 60): \n");

		for (int i = 0; i < remainingSessions.length; i++){
			System.out.println(sessionMapping[i] + ": " + remainingSessions[i] + " total individuals attending session");
		}

	}




}
