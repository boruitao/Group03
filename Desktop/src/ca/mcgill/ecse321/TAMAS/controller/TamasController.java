package ca.mcgill.ecse321.TAMAS.controller;

import java.sql.Date;
import java.util.List;

import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Application;
import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.JobPosting;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;
import ca.mcgill.ecse321.TAMAS.persistence.PersistenceXStream;

public class TamasController {

	private ManagementSystem ms = new ManagementSystem();

	public TamasController(ManagementSystem ms) {
		this.ms = ms;
	}

	public void createJob(String jobPosition, Date deadlineDate, String exp, int numberEmployees, double hourlyRate,
			Course aCourse) throws InvalidInputException {
		String error = "";
		if (aCourse == null) {
			error += "Please select a course.";
		}
		if (jobPosition.equals("")) {
			error += "Must specify a job position! ";
		}
		if (deadlineDate == null) {
			error += "Must specify a date! ";
		}
		if (exp == null || exp.trim().length() == 0) {
			error += "Must specify preferred experience! ";
		}
		if (numberEmployees < 0) {
			error += "Must specify number of positions hiring! ";
		}
		if (hourlyRate < 0) {
			error += "Must specify hourly wage! ";
		}
		error = error.trim();

		if (error.length() > 0) {
			throw new InvalidInputException(error);
		}

		ms.addJobPosting(jobPosition, deadlineDate, exp, numberEmployees, hourlyRate, aCourse);
		PersistenceXStream.saveToXMLwithXStream(ms);

	}

	public void createApplication(JobPosting jp, String name, int id, String major, boolean isUndergrad, String year,
			String exp, String firstChoice, String secondChoice, String thirdChoice, int totalAppointmentHour)
			throws InvalidInputException {

		String error = "";
		Applicant ap = createApplicant(name, id, major, isUndergrad, year, exp, firstChoice, secondChoice, thirdChoice,
				totalAppointmentHour);

		System.out.println("create");
		System.out.println(ap.numberOfApplications());
		if (ap.getApplications().size() < 3) {
			Application application = new Application("submitted", jp, ap);
			ap.addApplication(application);
		}

		else {

			error += "You cannot submit more applications! ";
		}

		if (error.length() > 0) {
			throw new InvalidInputException(error);
		}

		PersistenceXStream.saveToXMLwithXStream(ms);

	}

	private Applicant createApplicant(String name, int id, String major, boolean isUndergrad, String year, String exp,
			String firstChoice, String secondChoice, String thirdChoice, int totalAppointmentHour)
			throws InvalidInputException {
		String error = "";

		if (name == null || name.trim().length() == 0) {
			error += "Name cannot be empty!";
		}
		if (id < 0) {
			error += "You must input a valid id!";
		}
		if (major == null || major.trim().length() == 0) {
			error += "Major cannot be empty!";
		}
		if (exp == null || exp.trim().length() == 0) {
			error += "Past experience cannot be empty!";
		}
		if (firstChoice == null || firstChoice.trim().length() == 0) {
			error += "First Choice cannnot be empty.";
		}

		error = error.trim();
		if (error.length() > 0) {
			throw new InvalidInputException(error);
		}
		Applicant this_applicant = null;
		boolean found = false;
		List<Applicant> allApplicants = ms.getApplicants();
		if (allApplicants.size() != 0) {

			for (int i = 0; i < allApplicants.size(); i++) {
				Applicant anApplicant = allApplicants.get(i);
				if ((anApplicant.getName().equals(name))) {
					this_applicant = anApplicant;
					found = true;
					break;
				}
			}
			if (found == false) {
				this_applicant = new Applicant(id, name, exp, isUndergrad, major, year, firstChoice, secondChoice,
						thirdChoice, totalAppointmentHour, ms);
			}

		} else {
			this_applicant = new Applicant(id, name, exp, isUndergrad, major, year, firstChoice, secondChoice,
					thirdChoice, totalAppointmentHour, ms);
		}
		PersistenceXStream.saveToXMLwithXStream(ms);
		return this_applicant;

	}
	
	public void registerApplicant(String name) throws InvalidInputException{
		
		String error = "";
		
		if (name == null || name.trim().length()==0){
			error += "Name cannot be empty! ";
		}
		
		boolean found = false;
		List<Applicant> allApplicants = ms.getApplicants();
		List<Instructor> allInstructors = ms.getInstructors();
		
		for (Applicant anApplicant: allApplicants){
			if (anApplicant.getName().equals(name.trim())){
				error += "This username already exists! ";
				found = true;
				break;
			}
		}
		
		if (found == false){
			for (Instructor anInstructor: allInstructors){
				if (anInstructor.getName().equals(name.trim())){
					error += "This username already exists! ";
					found = true;
					break;
				}
			}
		}
		
		error = error.trim();
		if (error.length()>0){
			throw new InvalidInputException(error);
		}
		
		try{
			ms.addApplicant(0, name, null, true, null, null, null, null, null, 0);
		}
		catch (RuntimeException e){
			throw new InvalidInputException(e.getMessage());
		}

		PersistenceXStream.saveToXMLwithXStream(ms);
	}
	
	public void registerInstructor(String name) throws InvalidInputException{
		
		String error = "";

		if (name == null || name.trim().length()==0){
			error += "Name cannot be empty! ";
		}
		
		boolean found = false;
		List<Applicant> allApplicants = ms.getApplicants();
		List<Instructor> allInstructors = ms.getInstructors();
		
		for (Applicant anApplicant: allApplicants){
			if (anApplicant.getName().equals(name.trim())){
				error += "This username already exists! ";
				found = true;
				break;
			}
		}
		
		if (found == false){
			for (Instructor anInstructor: allInstructors){
				if (anInstructor.getName().equals(name.trim())){
					error += "This username already exists! ";
					found = true;
					break;
				}
			}
		}
		
		error = error.trim();
		if (error.length()>0){
			throw new InvalidInputException(error);
		}
		
		try{
			ms.addInstructor(name);
		}
		catch (RuntimeException e){
			throw new InvalidInputException(e.getMessage());
		}
		
		PersistenceXStream.saveToXMLwithXStream(ms);
	}

}
