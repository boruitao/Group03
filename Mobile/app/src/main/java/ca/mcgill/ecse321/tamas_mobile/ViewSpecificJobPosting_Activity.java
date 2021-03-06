package ca.mcgill.ecse321.tamas_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import ca.mcgill.ecse321.TAMAS.Web.controller.DDBmanager;
import ca.mcgill.ecse321.TAMAS.controller.TamasController;
import ca.mcgill.ecse321.TAMAS.model.JobPosting;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;


public class ViewSpecificJobPosting_Activity extends AppCompatActivity implements AsyncResponse {


    private String username="";
    private String title="";
    private String course="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_specific_job_posting_);

        DDBmanager asyncTask = new DDBmanager();
        Parameters p=new Parameters(getApplicationContext(),null,0);
        asyncTask.delegate = this;
        asyncTask.execute(p);

        ManagementSystem ms = (ManagementSystem) loadFromXML();
        TamasController tc =  new TamasController(ms);

        TextView jobPostingTitle = (TextView) findViewById(R.id.JobPostingTitle);
        TextView jobTitle = (TextView) findViewById(R.id.JobTitle);
        TextView numNeeded = (TextView) findViewById(R.id.numberNeeded);
        TextView salary = (TextView) findViewById(R.id.hourlyRates);
        TextView workingHours = (TextView) findViewById(R.id.workingHours);
        TextView deadline = (TextView) findViewById(R.id.applicationDeadline);
        TextView preferredExp = (TextView) findViewById(R.id.preferredExperience);
        Button applyButton = (Button) findViewById(R.id.applyButton);

        // Get the username of the current user
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        title = intent.getStringExtra("title");
        course = intent.getStringExtra("course");

        // Find the selected JobPosting object from the system
        JobPosting thisPosting = null;
        for (JobPosting aPosting : ms.getJobPostings()) {
            if (aPosting.getJobTitle().equals(title) && aPosting.getCourse().getCourseCode().equals(course)) {
                thisPosting = aPosting;
                break;
            }
        }

        // If the selected JobPosting object is found, display its details on the screen
        if (thisPosting != null) {
            jobPostingTitle.setText(thisPosting.getCourse().getCourseCode() + " - " + thisPosting.getJobTitle());
            jobTitle.setText(thisPosting.getJobTitle());
            if (thisPosting.getJobTitle().trim().equals("TA")) {
                numNeeded.setText(Integer.toString(thisPosting.getCourse().getNumTaNeeded()));
                //workingHours.setText(Integer.toString(thisPosting.getCourse().getHourRequiredTa()));
            } else if (thisPosting.getJobTitle().trim().equals("Grader")) {
                numNeeded.setText(Integer.toString(thisPosting.getCourse().getNumGraderNeeded()));
                //workingHours.setText(Integer.toString(thisPosting.getCourse().getHourRequiredGrader()));
            }
            salary.setText(Double.toString(thisPosting.getHourRate()));
            deadline.setText(thisPosting.getSubmissionDeadline().toString());
            preferredExp.setText(thisPosting.getPerferredExperience());
        }

        // If the deadline hasn't passed, the apply button will be enabled
        Date today = tc.getToday();
        if (tc.isDeadlinePassed(today)) {
            applyButton.setEnabled(false);
        }
    }


    // This method is called when the save&submit button is clicked
    public void apply(View v){
        Intent applyIntent =  new Intent(ViewSpecificJobPosting_Activity.this, submitApplication_Activity.class);
        applyIntent.putExtra("username",username);
        applyIntent.putExtra("title",title);
        applyIntent.putExtra("course",course);
        ViewSpecificJobPosting_Activity.this.startActivity(applyIntent);
    }

    // This method is called when the back button is clicked
    public void backToViewJobPosting(View v){
        Intent viewApplicationIntent = new Intent(ViewSpecificJobPosting_Activity.this, ViewJobPosting_Activity.class);
        viewApplicationIntent.putExtra("username",username);
        ViewSpecificJobPosting_Activity.this.startActivity(viewApplicationIntent);
    }

    public Object loadFromXML() {
        XStream xstream = new XStream();
        xstream.setMode(XStream.ID_REFERENCES);
        xstream.alias("jobInfo", JobPosting.class);
        String filePath = getFilesDir().getPath().toString() + "/data.xml";
        File f=new File(filePath);
        if(f.exists()) {
            try {
                FileReader fileReader = new FileReader(f); // load our xml
                return xstream.fromXML(fileReader);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }else{
            return new ManagementSystem();
        }
    }

    @Override
    public void processFinish(String output){
        writeFile(output);
    }
    public void writeFile(String data) {
        String filePath = getFilesDir().getPath().toString() + "/data.xml";
        File f=new File(filePath);
        if (!f.exists()) {
            try {
                f.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String string = data;
        FileOutputStream outputStream;
        try {
            outputStream =new FileOutputStream (f);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
