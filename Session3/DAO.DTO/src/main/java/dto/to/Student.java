package dto.to;

public class Student
{
  private final int studentNumber;
  private final String firstName, lastName, smartMoM;

  public Student(int studentNumber, String firstName, String lastName,
      String smartMoM)
  {
    this.studentNumber = studentNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.smartMoM = smartMoM;
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getSmartMoM()
  {
    return smartMoM;
  }


}
