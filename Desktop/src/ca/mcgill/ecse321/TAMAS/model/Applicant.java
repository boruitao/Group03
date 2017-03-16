/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.util.*;

// line 83 "../../../../../TAMAS.ump"
public class Applicant
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Applicant Attributes
  private int studentID;
  private String name;
  private String previousExperience;
  private boolean isUnderGraduated;
  private String major;
  private String year;
  private String firstChoice;
  private String secondChoice;
  private String thirdChoice;
  private int totalAppointmentHours;

  //Applicant Associations
  private List<Allocation> allocations;
  private List<OfferedJob> offeredJobs;
  private ManagementSystem managementSystem;
  private List<Application> applications;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Applicant(int aStudentID, String aName, String aPreviousExperience, boolean aIsUnderGraduated, String aMajor, String aYear, String aFirstChoice, String aSecondChoice, String aThirdChoice, int aTotalAppointmentHours, ManagementSystem aManagementSystem)
  {
    studentID = aStudentID;
    name = aName;
    previousExperience = aPreviousExperience;
    isUnderGraduated = aIsUnderGraduated;
    major = aMajor;
    year = aYear;
    firstChoice = aFirstChoice;
    secondChoice = aSecondChoice;
    thirdChoice = aThirdChoice;
    totalAppointmentHours = aTotalAppointmentHours;
    allocations = new ArrayList<Allocation>();
    offeredJobs = new ArrayList<OfferedJob>();
    boolean didAddManagementSystem = setManagementSystem(aManagementSystem);
    if (!didAddManagementSystem)
    {
      throw new RuntimeException("Unable to create applicant due to managementSystem");
    }
    applications = new ArrayList<Application>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStudentID(int aStudentID)
  {
    boolean wasSet = false;
    studentID = aStudentID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPreviousExperience(String aPreviousExperience)
  {
    boolean wasSet = false;
    previousExperience = aPreviousExperience;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsUnderGraduated(boolean aIsUnderGraduated)
  {
    boolean wasSet = false;
    isUnderGraduated = aIsUnderGraduated;
    wasSet = true;
    return wasSet;
  }

  public boolean setMajor(String aMajor)
  {
    boolean wasSet = false;
    major = aMajor;
    wasSet = true;
    return wasSet;
  }

  public boolean setYear(String aYear)
  {
    boolean wasSet = false;
    year = aYear;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstChoice(String aFirstChoice)
  {
    boolean wasSet = false;
    firstChoice = aFirstChoice;
    wasSet = true;
    return wasSet;
  }

  public boolean setSecondChoice(String aSecondChoice)
  {
    boolean wasSet = false;
    secondChoice = aSecondChoice;
    wasSet = true;
    return wasSet;
  }

  public boolean setThirdChoice(String aThirdChoice)
  {
    boolean wasSet = false;
    thirdChoice = aThirdChoice;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalAppointmentHours(int aTotalAppointmentHours)
  {
    boolean wasSet = false;
    totalAppointmentHours = aTotalAppointmentHours;
    wasSet = true;
    return wasSet;
  }

  public int getStudentID()
  {
    return studentID;
  }

  public String getName()
  {
    return name;
  }

  public String getPreviousExperience()
  {
    return previousExperience;
  }

  public boolean getIsUnderGraduated()
  {
    return isUnderGraduated;
  }

  public String getMajor()
  {
    return major;
  }

  public String getYear()
  {
    return year;
  }

  public String getFirstChoice()
  {
    return firstChoice;
  }

  public String getSecondChoice()
  {
    return secondChoice;
  }

  public String getThirdChoice()
  {
    return thirdChoice;
  }

  public int getTotalAppointmentHours()
  {
    return totalAppointmentHours;
  }

  public boolean isIsUnderGraduated()
  {
    return isUnderGraduated;
  }

  public Allocation getAllocation(int index)
  {
    Allocation aAllocation = allocations.get(index);
    return aAllocation;
  }

  public List<Allocation> getAllocations()
  {
    List<Allocation> newAllocations = Collections.unmodifiableList(allocations);
    return newAllocations;
  }

  public int numberOfAllocations()
  {
    int number = allocations.size();
    return number;
  }

  public boolean hasAllocations()
  {
    boolean has = allocations.size() > 0;
    return has;
  }

  public int indexOfAllocation(Allocation aAllocation)
  {
    int index = allocations.indexOf(aAllocation);
    return index;
  }

  public OfferedJob getOfferedJob(int index)
  {
    OfferedJob aOfferedJob = offeredJobs.get(index);
    return aOfferedJob;
  }

  public List<OfferedJob> getOfferedJobs()
  {
    List<OfferedJob> newOfferedJobs = Collections.unmodifiableList(offeredJobs);
    return newOfferedJobs;
  }

  public int numberOfOfferedJobs()
  {
    int number = offeredJobs.size();
    return number;
  }

  public boolean hasOfferedJobs()
  {
    boolean has = offeredJobs.size() > 0;
    return has;
  }

  public int indexOfOfferedJob(OfferedJob aOfferedJob)
  {
    int index = offeredJobs.indexOf(aOfferedJob);
    return index;
  }

  public ManagementSystem getManagementSystem()
  {
    return managementSystem;
  }

  public Application getApplication(int index)
  {
    Application aApplication = applications.get(index);
    return aApplication;
  }

  public List<Application> getApplications()
  {
    List<Application> newApplications = Collections.unmodifiableList(applications);
    return newApplications;
  }

  public int numberOfApplications()
  {
    int number = applications.size();
    return number;
  }

  public boolean hasApplications()
  {
    boolean has = applications.size() > 0;
    return has;
  }

  public int indexOfApplication(Application aApplication)
  {
    int index = applications.indexOf(aApplication);
    return index;
  }

  public static int minimumNumberOfAllocations()
  {
    return 0;
  }

  public boolean addAllocation(Allocation aAllocation)
  {
    boolean wasAdded = false;
    if (allocations.contains(aAllocation)) { return false; }
    allocations.add(aAllocation);
    if (aAllocation.indexOfApplicant(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAllocation.addApplicant(this);
      if (!wasAdded)
      {
        allocations.remove(aAllocation);
      }
    }
    return wasAdded;
  }

  public boolean removeAllocation(Allocation aAllocation)
  {
    boolean wasRemoved = false;
    if (!allocations.contains(aAllocation))
    {
      return wasRemoved;
    }

    int oldIndex = allocations.indexOf(aAllocation);
    allocations.remove(oldIndex);
    if (aAllocation.indexOfApplicant(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAllocation.removeApplicant(this);
      if (!wasRemoved)
      {
        allocations.add(oldIndex,aAllocation);
      }
    }
    return wasRemoved;
  }

  public boolean addAllocationAt(Allocation aAllocation, int index)
  {  
    boolean wasAdded = false;
    if(addAllocation(aAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAllocations()) { index = numberOfAllocations() - 1; }
      allocations.remove(aAllocation);
      allocations.add(index, aAllocation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAllocationAt(Allocation aAllocation, int index)
  {
    boolean wasAdded = false;
    if(allocations.contains(aAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAllocations()) { index = numberOfAllocations() - 1; }
      allocations.remove(aAllocation);
      allocations.add(index, aAllocation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAllocationAt(aAllocation, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOfferedJobs()
  {
    return 0;
  }

  public static int maximumNumberOfOfferedJobs()
  {
    return 3;
  }

  public OfferedJob addOfferedJob(String aOfferDescription, Course aCourse)
  {
    if (numberOfOfferedJobs() >= maximumNumberOfOfferedJobs())
    {
      return null;
    }
    else
    {
      return new OfferedJob(aOfferDescription, aCourse, this);
    }
  }

  public boolean addOfferedJob(OfferedJob aOfferedJob)
  {
    boolean wasAdded = false;
    if (offeredJobs.contains(aOfferedJob)) { return false; }
    if (numberOfOfferedJobs() >= maximumNumberOfOfferedJobs())
    {
      return wasAdded;
    }

    Applicant existingApplicant = aOfferedJob.getApplicant();
    boolean isNewApplicant = existingApplicant != null && !this.equals(existingApplicant);
    if (isNewApplicant)
    {
      aOfferedJob.setApplicant(this);
    }
    else
    {
      offeredJobs.add(aOfferedJob);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOfferedJob(OfferedJob aOfferedJob)
  {
    boolean wasRemoved = false;
    //Unable to remove aOfferedJob, as it must always have a applicant
    if (!this.equals(aOfferedJob.getApplicant()))
    {
      offeredJobs.remove(aOfferedJob);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOfferedJobAt(OfferedJob aOfferedJob, int index)
  {  
    boolean wasAdded = false;
    if(addOfferedJob(aOfferedJob))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOfferedJobs()) { index = numberOfOfferedJobs() - 1; }
      offeredJobs.remove(aOfferedJob);
      offeredJobs.add(index, aOfferedJob);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOfferedJobAt(OfferedJob aOfferedJob, int index)
  {
    boolean wasAdded = false;
    if(offeredJobs.contains(aOfferedJob))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOfferedJobs()) { index = numberOfOfferedJobs() - 1; }
      offeredJobs.remove(aOfferedJob);
      offeredJobs.add(index, aOfferedJob);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOfferedJobAt(aOfferedJob, index);
    }
    return wasAdded;
  }

  public boolean setManagementSystem(ManagementSystem aManagementSystem)
  {
    boolean wasSet = false;
    //Must provide managementSystem to applicant
    if (aManagementSystem == null)
    {
      return wasSet;
    }

    if (managementSystem != null && managementSystem.numberOfApplicants() <= ManagementSystem.minimumNumberOfApplicants())
    {
      return wasSet;
    }

    ManagementSystem existingManagementSystem = managementSystem;
    managementSystem = aManagementSystem;
    if (existingManagementSystem != null && !existingManagementSystem.equals(aManagementSystem))
    {
      boolean didRemove = existingManagementSystem.removeApplicant(this);
      if (!didRemove)
      {
        managementSystem = existingManagementSystem;
        return wasSet;
      }
    }
    managementSystem.addApplicant(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfApplications()
  {
    return 0;
  }

  public static int maximumNumberOfApplications()
  {
    return 3;
  }

  public Application addApplication(String aApplicationStatus, JobPosting aJobPosting)
  {
    if (numberOfApplications() >= maximumNumberOfApplications())
    {
      return null;
    }
    else
    {
      return new Application(aApplicationStatus, aJobPosting, this);
    }
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    if (numberOfApplications() >= maximumNumberOfApplications())
    {
      return wasAdded;
    }

    Applicant existingApplicant = aApplication.getApplicant();
    boolean isNewApplicant = existingApplicant != null && !this.equals(existingApplicant);
    if (isNewApplicant)
    {
      aApplication.setApplicant(this);
    }
    else
    {
      applications.add(aApplication);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeApplication(Application aApplication)
  {
    boolean wasRemoved = false;
    //Unable to remove aApplication, as it must always have a applicant
    if (!this.equals(aApplication.getApplicant()))
    {
      applications.remove(aApplication);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addApplicationAt(Application aApplication, int index)
  {  
    boolean wasAdded = false;
    if(addApplication(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveApplicationAt(Application aApplication, int index)
  {
    boolean wasAdded = false;
    if(applications.contains(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addApplicationAt(aApplication, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Allocation> copyOfAllocations = new ArrayList<Allocation>(allocations);
    allocations.clear();
    for(Allocation aAllocation : copyOfAllocations)
    {
      aAllocation.removeApplicant(this);
    }
    for(int i=offeredJobs.size(); i > 0; i--)
    {
      OfferedJob aOfferedJob = offeredJobs.get(i - 1);
      aOfferedJob.delete();
    }
    ManagementSystem placeholderManagementSystem = managementSystem;
    this.managementSystem = null;
    placeholderManagementSystem.removeApplicant(this);
    for(int i=applications.size(); i > 0; i--)
    {
      Application aApplication = applications.get(i - 1);
      aApplication.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "studentID" + ":" + getStudentID()+ "," +
            "name" + ":" + getName()+ "," +
            "previousExperience" + ":" + getPreviousExperience()+ "," +
            "isUnderGraduated" + ":" + getIsUnderGraduated()+ "," +
            "major" + ":" + getMajor()+ "," +
            "year" + ":" + getYear()+ "," +
            "firstChoice" + ":" + getFirstChoice()+ "," +
            "secondChoice" + ":" + getSecondChoice()+ "," +
            "thirdChoice" + ":" + getThirdChoice()+ "," +
            "totalAppointmentHours" + ":" + getTotalAppointmentHours()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "managementSystem = "+(getManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getManagementSystem())):"null")
     + outputString;
  }
}