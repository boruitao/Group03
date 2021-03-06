package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.controller.TamasController;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.JobPosting;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;

public class ApplyForJob extends JFrame {

	private static final long serialVersionUID = 5816868540239806192L;
	private Object user;

	// Basic information
	private JLabel formTitle;
	private JLabel errorMessage;
	private JLabel jobPostingLabel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel majorLabel;
	private JTextField majorTextField;
	private JLabel isUndergradLabel;
	private JComboBox<String> isUndergradToggleList;
	private JComboBox<String> jobPostingToggleList;
	private JLabel yearLabel;
	private JComboBox<String> yearToggleList;

	// Past experience
	private JLabel pastExperienceLabel;
	private JTextArea pastExperienceTextArea;
	private JLabel choiceMessage0;
	private JLabel choiceMessage1;
	private JLabel firstChoiceLabel;
	private JComboBox<String> firstChoiceToggleList;
	private JLabel secondChoiceLabel;
	private JComboBox<String> secondChoiceToggleList;
	private JLabel thirdChoiceLabel;
	private JComboBox<String> thirdChoiceToggleList;

	private String error = null;
	private Integer selectedJobPosting = -1;
	private Integer selectedDegree = -1;
	private Integer selectedYear = -1;
	private Integer selectedFirstChoice = -1;
	private Integer selectedSecondChoice = -1;
	private Integer selectedThirdChoice = -1;

	private JButton submitButton;
	private JButton cancelButton;

	private JSeparator horizontalLineTop;
	private JSeparator horizontalLineMiddle1;
	private JSeparator horizontalLineMiddle2;

	private ManagementSystem ms;

	/**
	 * Class constructor
	 * @param ms Management system
	 * @param user User
	 */
	public ApplyForJob(ManagementSystem ms, Object user) {
		this.ms = ms;
		this.user = user;
		initComponents();
		refreshData();
	}

	/**
	 * Initialize all components
	 */
	public void initComponents() {

		formTitle = new JLabel("Application");
		formTitle.setFont(new Font("Georgia", Font.BOLD, 22));

		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		jobPostingLabel = new JLabel("Availabe Positions:");
		jobPostingLabel.setForeground(Color.BLACK);
		jobPostingToggleList = new JComboBox<String>();
		for (JobPosting jp : ms.getJobPostings()) {
			if (!TamasController.isDeadlinePassed(jp.getSubmissionDeadline())) {
				jobPostingToggleList.addItem(jp.getJobTitle() + " for " + jp.getCourse().getCourseCode());
			}
		}
		jobPostingToggleList.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) arg0.getSource();
				selectedJobPosting = cb.getSelectedIndex();
			}

		});

		nameLabel = new JLabel("Name:");
		nameLabel.setForeground(Color.BLACK);


		idLabel = new JLabel("McGill ID:");
		idLabel.setForeground(Color.BLACK);
		idTextField = new JTextField();
		majorLabel = new JLabel("Major:");
		majorLabel.setForeground(Color.BLACK);
		majorTextField = new JTextField();

		isUndergradLabel = new JLabel("Undergrad/Grad");
		isUndergradLabel.setForeground(Color.BLACK);
		isUndergradToggleList = new JComboBox<String>(new String[0]);
		isUndergradToggleList.addItem("Undergraduate");
		isUndergradToggleList.addItem("Graduate");
		isUndergradToggleList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedDegree = cb.getSelectedIndex();
			}
		});

		yearLabel = new JLabel("Year:");
		yearLabel.setForeground(Color.BLACK);
		yearToggleList = new JComboBox<String>(new String[0]);

		yearToggleList.addItem("Year 0");
		yearToggleList.addItem("Year 1");
		yearToggleList.addItem("Year 2");
		yearToggleList.addItem("Year 3 or more");
		yearToggleList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedYear = cb.getSelectedIndex();
			}
		});


		pastExperienceLabel = new JLabel("Past Experience");
		pastExperienceLabel.setForeground(Color.BLACK);
		pastExperienceTextArea = new JTextArea(5, 20);
		pastExperienceTextArea.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		choiceMessage0 = new JLabel(
				"Please select a first and second choice if already applied for 1 position");
		choiceMessage0.setForeground(Color.BLACK);

		choiceMessage1 = new JLabel("Please select a first,second and third choice if already applied for 2 positions");
		choiceMessage1.setForeground(Color.BLACK);


		// TODO: choices are hard coded.
		firstChoiceLabel = new JLabel("First Choice");

		firstChoiceToggleList = new JComboBox<String>(new String[0]);

		firstChoiceToggleList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedFirstChoice = cb.getSelectedIndex();
			}
		});


		secondChoiceLabel = new JLabel("Second Choice");

		secondChoiceToggleList = new JComboBox<String>(new String[0]);

		secondChoiceToggleList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedSecondChoice = cb.getSelectedIndex();
			}
		});


		thirdChoiceLabel = new JLabel("Third Choice");

		thirdChoiceToggleList = new JComboBox<String>(new String[0]);
		
		thirdChoiceToggleList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedThirdChoice = cb.getSelectedIndex();
			}
		});
		
		
		for (JobPosting jp : ms.getJobPostings()) {
			String d = jp.getJobTitle() + " " + jp.getCourse().getCourseCode();
			firstChoiceToggleList.addItem(d);
			secondChoiceToggleList.addItem(d);
			thirdChoiceToggleList.addItem(d);
		}
		

		submitButton = new JButton("  Submit  ");
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButtonActionPerformed(evt);
			}
		});

		cancelButton = new JButton("  Cancel  ");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		setTitle("Job Application");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		horizontalLineTop = new JSeparator();
		horizontalLineMiddle1 = new JSeparator();
		horizontalLineMiddle2 = new JSeparator();

		
		if (user.getClass().equals(Applicant.class)) { //
			Applicant a = (Applicant) user;
			nameTextField = new JTextField();
			nameTextField.setText(a.getName());
			nameTextField.setEditable(false);
			nameTextField.setForeground(Color.BLACK);
			
			// first, second, third choice toggle list enabled depending on
			// the number of applications the applicant has submitted before
			if (((Applicant)user).getApplications().size() == 0){
				firstChoiceToggleList.setEnabled(false);
				secondChoiceToggleList.setEnabled(false);
				thirdChoiceToggleList.setEnabled(false);
			}
			else if (((Applicant)user).getApplications().size() == 1){
				firstChoiceToggleList.setEnabled(true);
				secondChoiceToggleList.setEnabled(true);
				thirdChoiceToggleList.setEnabled(false);
			}
			else{
				firstChoiceToggleList.setEnabled(true);
				secondChoiceToggleList.setEnabled(true);
				thirdChoiceToggleList.setEnabled(true);
			}		
			
		} 
		
		// If user == Instructor or Department, all of the choice toggle list enabled
		else {
			nameTextField = new JTextField();
			firstChoiceToggleList.setEnabled(true);
			secondChoiceToggleList.setEnabled(true);
			thirdChoiceToggleList.setEnabled(true);
		}
		
		
		
		
		if (user.getClass().equals(Applicant.class)) {
			addlayout(nameTextField,firstChoiceToggleList,secondChoiceToggleList,thirdChoiceToggleList);
		} 
		
		else {
			addlayout(nameTextField,firstChoiceToggleList,secondChoiceToggleList,thirdChoiceToggleList);
		}

	}
	/**
	 * Add component to the layout
	 * @param o Component
	 */
	private void addlayout(Component name, Component firstChoice, Component secondChoice, Component thirdChoice) {



		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createParallelGroup().addComponent(formTitle).addComponent(errorMessage)
				.addComponent(horizontalLineTop).addComponent(horizontalLineMiddle1).addComponent(horizontalLineMiddle2)
				.addComponent(choiceMessage0).addComponent(choiceMessage1)

				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup().addComponent(jobPostingLabel).addComponent(nameLabel)
								.addComponent(idLabel).addComponent(majorLabel).addComponent(isUndergradLabel)
								.addComponent(yearLabel).addComponent(pastExperienceLabel)
								.addComponent(firstChoiceLabel).addComponent(secondChoiceLabel)
								.addComponent(thirdChoiceLabel).addComponent(cancelButton))
						.addGroup(layout.createParallelGroup().addComponent(jobPostingToggleList)
								.addComponent(nameLabel).addComponent(name).addComponent(idTextField)
								.addComponent(majorTextField).addComponent(isUndergradToggleList)
								.addComponent(yearToggleList).addComponent(pastExperienceTextArea)
								.addComponent(firstChoice).addComponent(secondChoice)
								.addComponent(thirdChoice).addComponent(submitButton))));

		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(formTitle)
				.addGroup(layout.createParallelGroup().addComponent(horizontalLineTop)).addComponent(errorMessage)
				.addGroup(layout.createParallelGroup().addComponent(jobPostingLabel).addComponent(jobPostingToggleList))
				.addGroup(layout.createParallelGroup().addComponent(nameLabel).addComponent(name))
				.addGroup(layout.createParallelGroup().addComponent(idLabel).addComponent(idTextField))
				.addGroup(layout.createParallelGroup().addComponent(majorLabel).addComponent(majorTextField))
				.addGroup(layout.createParallelGroup().addComponent(horizontalLineMiddle1))
				.addGroup(
						layout.createParallelGroup().addComponent(isUndergradLabel).addComponent(isUndergradToggleList))
				.addGroup(layout.createParallelGroup().addComponent(yearLabel).addComponent(yearToggleList))
				.addGroup(layout.createParallelGroup().addComponent(pastExperienceLabel)
						.addComponent(pastExperienceTextArea))
				.addGroup(layout.createParallelGroup().addComponent(horizontalLineMiddle2)).addComponent(choiceMessage0)
				.addComponent(choiceMessage1)
				.addGroup(
						layout.createParallelGroup().addComponent(firstChoiceLabel).addComponent(firstChoice))
				.addGroup(layout.createParallelGroup().addComponent(secondChoiceLabel).addComponent(secondChoice))
				.addGroup(
						layout.createParallelGroup().addComponent(thirdChoiceLabel).addComponent(thirdChoice))
				.addGroup(layout.createParallelGroup().addComponent(cancelButton).addComponent(submitButton))

		);

		pack();
		setResizable(false);
	}

	/**
	 * Refresh data if no errors occurred
	 */
	private void refreshData() {
		// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			idTextField.setText("");
			majorTextField.setText("");
			pastExperienceTextArea.setText("");

			selectedJobPosting = -1;
			jobPostingToggleList.setSelectedIndex(selectedJobPosting);
			selectedDegree = -1;
			isUndergradToggleList.setSelectedIndex(selectedDegree);
			selectedYear = -1;
			yearToggleList.setSelectedIndex(selectedYear);
			selectedFirstChoice = -1;
			firstChoiceToggleList.setSelectedIndex(selectedFirstChoice);
			selectedSecondChoice = -1;
			secondChoiceToggleList.setSelectedIndex(selectedSecondChoice);
			selectedThirdChoice = -1;
			thirdChoiceToggleList.setSelectedIndex(selectedThirdChoice);

		}

		pack();
	}

	/**
	 * Action triggered when submitting the job application
	 * @param evt Action event
	 */
	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {

		// TODO: Change the appointment hour after we have the allocation
		int totalAppointmentHours = 45;

		TamasController tc = new TamasController(ms);

		error = "";

		if (selectedJobPosting < 0) {
			error += "Please select an available position.";
		}

		if (selectedDegree < 0) {
			error += "Please select either Undergraduate or Graduate.";
		}

		if (selectedYear < 0) {
			error += "Please select your year.";
		}

		if (error.trim().length() == 0) {
			String name = null;
			if (user.getClass().equals(Applicant.class)) {
				Applicant a = (Applicant) user;
				name = a.getName();
			} else {
				name = nameTextField.getText();
			}

			String id = idTextField.getText();
			String major = majorTextField.getText();

			boolean isUndergrad = true;
			if (selectedDegree == 1) {
				isUndergrad = false;
			}

			String year = (String) yearToggleList.getSelectedItem();
			String exp = pastExperienceTextArea.getText();
			String firstChoice = null;
			String secondChoice = null;
			String thirdChoice = null;

			
			
			if (selectedFirstChoice != -1) {
				firstChoice = (String) firstChoiceToggleList.getSelectedItem();
			}

			if (selectedSecondChoice != -1) {
				secondChoice = (String) secondChoiceToggleList.getSelectedItem();
			}

			if (selectedThirdChoice != -1) {
				thirdChoice = (String) thirdChoiceToggleList.getSelectedItem();
			}

			try {
				JobPosting appliedjob = null;
				String app = jobPostingToggleList.getSelectedItem().toString();
				for (JobPosting jp : ms.getJobPostings()) {
					if (app.indexOf(jp.getJobTitle()) != -1 && app.indexOf(jp.getCourse().getCourseCode()) != -1)
						appliedjob = jp;
				}
				if (appliedjob != null) {
					tc.createApplication(appliedjob, name, id, major, isUndergrad, year, exp, firstChoice, secondChoice,
							thirdChoice, totalAppointmentHours);
					JOptionPane.showMessageDialog(ApplyForJob.this,"Application Submitted");
					setVisible(false);
					backToAllApp();
				}
			} catch (InvalidInputException e) {
				error += e.getMessage();
			}
		}

		// update visuals
		refreshData();
	}

	/**
	 * Action triggered when cancelling the job application
	 * @param evt Action event
	 */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		backToAllApp();
		setVisible(false);
	}

	/**
	 * Return to all applications page
	 */
	private void backToAllApp() {
		new AllApplication(ms, user).setVisible(true);
	}

}
