package dto.server;


import dto.to.Student;

import java.util.List;

public class StudentInfoServer
{
  private List<Student> students;

  public StudentInfoServer(List<Student> students)
  {
    this.students = students;
  }

  //return all students
  public List<Student> getStudents()
  {
    return students;
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public void removeByStudentNumber(int studentNumber)
  {
//    Predicate<Student> sp = student -> student.getStudentNumber() == studentNumber;
//    students.removeIf(sp);

    students.removeIf(student -> student.getStudentNumber() == studentNumber);
  }
}
