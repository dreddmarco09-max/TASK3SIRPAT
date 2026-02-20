import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Scanner Sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- STUDENTS RECORD LIST ---");
            System.out.println("1. View Records");
            System.out.println("2. Add Student");
            System.out.println("3. Exit The Program");
            System.out.print("Select: ");
            
            int choice = Sc.nextInt();
            Sc.nextLine(); 

            if (choice == 1) {
                System.out.println("\n--- DATABASE RECORDS ---"); //
                List<Student> list = repo.getAllStudents();
                for (Student s : list) {
                    System.out.println(s.displayInfo()); 
                }
            } else if (choice == 2) {
                System.out.print("First Name: "); String fn = Sc.nextLine();
                System.out.print("Last Name: "); String ln = Sc.nextLine();
                System.out.print("Middle Name: "); String mn = Sc.nextLine();
                System.out.print("Gender: "); String gen = Sc.nextLine();
                System.out.print("Age: "); int age = Sc.nextInt(); Sc.nextLine();
                System.out.print("Course: "); String c = Sc.nextLine();
                System.out.print("Year Level: "); int yr = Sc.nextInt(); Sc.nextLine();
                System.out.print("Address: "); String add = Sc.nextLine();
                System.out.print("Contact: "); int con = Sc.nextInt();

                Student s = new Student.Builder()
                    .setFirstName(fn).setLastName(ln).setMiddleName(mn)
                    .setGender(gen).setAge(age).setCourse(c)
                    .setYearLevel(yr).setAddress(add).setContactNumber(con)
                    .build();
                repo.addStudent(s);
            } else {
                running = false;
            }
        }
    }
}