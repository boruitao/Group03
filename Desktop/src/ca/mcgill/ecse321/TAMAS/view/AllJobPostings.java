package ca.mcgill.ecse321.TAMAS.view;

import ca.mcgill.ecse321.TAMAS.controller.TamasController;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.JobPosting;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;
import ca.mcgill.ecse321.TAMAS.persistence.PersistenceXStream;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class AllJobPostings extends JFrame {

	private static final long serialVersionUID = -5884843490851166108L;
	private ManagementSystem ms;
	private static String filename = "output/data.xml";

	private Object user;

	/**
	 * Class constructor
	 * @param ms Management system
	 * @param user User
	 */
	public AllJobPostings(ManagementSystem ms, Object user) {
		this.ms = ms;
		this.user = user;
		initComponents();
	}

	/**
	 * Initialize all components
	 */
	private void initComponents() {
		
		// get table data ready;
		String[] columnNames = { "Job Title", "Course Code", "Course Name", "Hour Required", "Hourly Rate",
				"Preferred Experience", "Submission Deadline" };
		String[][] data = new String[ms.numberOfJobPostings() + 1][7];
		int i = 0;

		for (JobPosting aJobPosting : ms.getJobPostings()) {
			if (!TamasController.isDeadlinePassed(aJobPosting.getSubmissionDeadline())) {
				data[i][1] = aJobPosting.getCourse().getCourseCode();
				data[i][2] = aJobPosting.getCourse().getCourseName();
				if (aJobPosting.getJobTitle().equals("TA")) {
					int numLab = aJobPosting.getCourse().getNumLab();
					int labHour = aJobPosting.getCourse().getLabHour();
					int numTutorial = aJobPosting.getCourse().getNumTutorial();
					int tutorialHour = aJobPosting.getCourse().getTutorialHour();
					
					int hourRequiredTa = numLab*labHour + numTutorial*tutorialHour;
					double temp = hourRequiredTa/180;
					int numTaNeeded = (int) Math.ceil(temp);
					
					
					data[i][0] = aJobPosting.getJobTitle() + " [" + numTaNeeded	+ " needed]";			
					if (numTaNeeded==0){
						data[i][3] = "0 hrs/semester";
					}else{
						data[i][3] = "" + Math.ceil(hourRequiredTa/numTaNeeded) + " hrs / semester";
					}
					
				} else {
					data[i][0] = aJobPosting.getJobTitle() + " [" + aJobPosting.getCourse().getNumGraderNeeded() + " needed]";
					if (aJobPosting.getCourse().getNumGraderNeeded()==0){
						data[i][3] = "0 hrs / semester";
					}else{
						data[i][3] = "" + Math.ceil((aJobPosting.getCourse().getTotalGraderHour())/(aJobPosting.getCourse().getNumGraderNeeded())) + " hrs / semester";
					}
				}

				data[i][4] = "$" + aJobPosting.getHourRate() + " / hr";
				data[i][5] = aJobPosting.getPerferredExperience();
				data[i][6] = aJobPosting.getSubmissionDeadline().toString();
				i++;
			}
		}

		// get table itself ready;
		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(900, 100));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel buttomPane = new JPanel();

		// get the rest of frame ready;
		JButton addJobPostingButton = new JButton("Add a New Job Posting");
		JButton backButton = new JButton("Back");

		// get frame ready;
		setTitle("View All Job Postings");
		BorderLayout layout = new BorderLayout();
		Container pane = getContentPane();
		pane.setLayout(layout);
		pane.add(scrollPane, BorderLayout.PAGE_START);
		if (user.getClass().equals(Applicant.class)) {
			buttomPane.add(backButton);
			pane.add(buttomPane, BorderLayout.CENTER);
		} else if (user.getClass().equals(Instructor.class)) {
			buttomPane.add(addJobPostingButton);
			buttomPane.add(backButton);
			pane.add(buttomPane, BorderLayout.CENTER);
		}

		else {
			buttomPane.add(addJobPostingButton);
			buttomPane.add(backButton);
			pane.add(buttomPane, BorderLayout.CENTER);
		}
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// add actions listeners
		addJobPostingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ms.getCourses().size()==0){
					JOptionPane.showMessageDialog(AllJobPostings.this,
							"No course information has been uploaded.\n"
							+ "Please try again later.");
				}else{

					if (TamasController.isDeadlinePassed()) {
						JOptionPane.showMessageDialog(AllJobPostings.this,
								"Sorry, the deadline to publish new Job Postings have passed.\n" + "The deadline was "
										+ TamasController.getDefaultDeadLine() + ".");
					} else {
						JOptionPane.showMessageDialog(AllJobPostings.this, "Deadline : "
								+ TamasController.getDefaultDeadLine() + ". You may publish a new job posting");
						final ManagementSystem ms = PersistenceXStream.initializeModelManager(filename);
						new PublishJobPostingPage(ms, user).setVisible(true);
						dispose();
					}
				}
			}
		});

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backToMain();
				setVisible(false);
			}
		});

	}

	/**
	 * Return to main page
	 */
	private void backToMain() {
		new MainPage(user).setVisible(true);
	}
}
