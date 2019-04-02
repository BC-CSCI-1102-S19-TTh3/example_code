import java.util.*;

public class ComparatorExample {

  // TreeSet to keep track of students
  TreeSet<Student> students;

  // Constructor
  public ComparatorExample (String s){
    if (s.equals("gpa")) {
      students = new TreeSet<Student>(new GPAComparator());
    } else if (s.equals("year")) {
      students = new TreeSet<Student>(new YearComparator());
    } else {
      students = new TreeSet<Student>(new NameComparator());
    }

  }

  // Instance methods
  public void addStudent(String name, Integer year, Double gpa) {
    Student s = new Student(name, year, gpa);
    students.add(s);
  }

  public void printStudents() {
    for (Student s : this.students) {
      System.out.println(s.name + " " + s.gradyear + " " + s.gpa);
    }
    System.out.println();
  }

  // Student class with constructor
  public class Student {
    String name;
    Integer gradyear;
    Double gpa;

    public Student (String name, Integer gradyear, Double gpa) {
      this.name = name;
      this.gradyear = gradyear;
      this.gpa = gpa;
    }
  }

  // Comparator definitions
  public class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.name.compareTo(s2.name);
    }
  }

  public class YearComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.gradyear.compareTo(s2.gradyear);
    }
  }

  public class GPAComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
      return s1.gpa.compareTo(s2.gpa);
    }
  }

  public static void main (String[] args) {
    ComparatorExample ce = new ComparatorExample("year");
    ce.addStudent("Marvin", 2020, 3.8);
    ce.addStudent("Louise", 2021, 4.0);
    ce.addStudent("Dana", 2019, 2.7);
    ce.addStudent("Ming", 2022, 3.5);
    ce.printStudents();

    ComparatorExample ce2 = new ComparatorExample("name");
    ce2.addStudent("Marvin", 2020, 3.8);
    ce2.addStudent("Louise", 2021, 4.0);
    ce2.addStudent("Dana", 2019, 2.7);
    ce2.addStudent("Ming", 2022, 3.5);
    ce2.printStudents();

    ComparatorExample ce3 = new ComparatorExample("gpa");
    ce3.addStudent("Marvin", 2020, 3.8);
    ce3.addStudent("Louise", 2021, 4.0);
    ce3.addStudent("Dana", 2019, 2.7);
    ce3.addStudent("Ming", 2022, 3.5);
    ce3.printStudents();

  }



}
