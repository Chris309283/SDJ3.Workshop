package dto.client;

import dto.server.StudentInfoServer;
import dto.to.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentClient
{
  public static System.Logger LOGGER = System.getLogger("StudentClient");

  public static void main(String[] args)
  {
    List<Student> students = new ArrayList<>();

    Student student1 = new Student(309283,"Christopher","Gadgaard","apache helicopter");
    Student student2 = new Student(666666, "Vlad","Lazar","sucks dick");
    Student student3 = new Student(010101, "Tomas", "Something","eats shit");

    students.add(student1);
    students.add(student2);
    students.add(student3);

    StudentInfoServer studentInfoServer = new StudentInfoServer(students);

    LOGGER.log(System.Logger.Level.INFO,">>>> Listing all students");
    List<Student> studentList = studentInfoServer.getStudents();
    showDetails(studentList);
    LOGGER.log(System.Logger.Level.INFO,">>>> Putting a student");
    Student student4 = new Student(000000,"Alfonso","Shitface","fucks goats");
    studentInfoServer.addStudent(student4);
    studentList=studentInfoServer.getStudents();
    showDetails(studentList);
  }

  private static void showDetails(List<Student> studentList)
  {
    studentList.forEach(student -> LOGGER.log(System.Logger.Level.INFO,student.getFirstName()+"-> "+ student.getSmartMoM()));
  }
}
