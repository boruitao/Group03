package ca.mcgill.ecse321.tamas_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import ca.mcgill.ecse321.TAMAS.Web.controller.DDBmanager;
import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.controller.TamasController;
import ca.mcgill.ecse321.TAMAS.model.JobPosting;
import ca.mcgill.ecse321.TAMAS.model.ManagementSystem;

public class Register_Activity extends AppCompatActivity implements AsyncResponse{
//public class Register_Activity extends AppCompatActivity{

    private String error="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        refreshData();

    }

    public void register(View v){
        error = "";

//
  //      tc = new TamasController(ms);
        DDBmanager asyncTask=new DDBmanager();
        asyncTask.delegate = this;
        Parameters p = new Parameters(getApplicationContext(), null, 0);
        asyncTask.execute(p);
        ManagementSystem ms= (ManagementSystem)loadFromXML();

        EditText newuser = (EditText)findViewById(R.id.newuser);

        // Report an error if the user doesn't enter a username
        if (newuser.getText().toString()==null || newuser.getText().toString().trim().length()==0){
            error += "You must enter a username! ";
        }

        if (error.length()<=0){
                try {
                    int numOfExitsingApp=ms.numberOfApplicants();
                    TamasController tc = new TamasController(ms);

                    // Call the register method in controller
                    tc.registerApplicant(newuser.getText().toString());
                    if (ms!=null) {
                        Parameters p2 = new Parameters(getApplicationContext(), ms, 1);
                        asyncTask=new DDBmanager();
                        asyncTask.delegate = this;
                        asyncTask.execute(p2);
                    }
                }
                catch (InvalidInputException e){
                    error += e.getMessage();
                }
        }
       refreshData();
    }

    private void refreshData(){
        EditText newuser = (EditText)findViewById(R.id.newuser);
        TextView errorMessage =(TextView)findViewById(R.id.registerError);

        // Clear the textfields and show error message (if there is any)
        errorMessage.setText(error);
        newuser.setText("");
    }

    // This method is called when the back button is clicked
    public void backToLogIn(View v){
        Intent toLogIn = new Intent(Register_Activity.this, Login_Activity.class);
        Register_Activity.this.startActivity(toLogIn);
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
