import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<String> studentNames;
    private ArrayList<ArrayList<Double>> studentGrades;

    public StudentGradeTracker() {
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
    }

    public void addStudent(String name) {
        studentNames.add(name);
        studentGrades.add(new ArrayList<>());
    }

    public void addGrade(int studentIndex, double grade) {
        if (studentIndex >= 0 && studentIndex < studentGrades.size()) {
            studentGrades.get(studentIndex).add(grade);
        }
    }

    public double calculateAverage(int studentIndex) {
        ArrayList<Double> grades = studentGrades.get(studentIndex);
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return grades.size() == 0 ? 0 : sum / grades.size();
    }

    public double findHighest() {
        double highest = Double.MIN_VALUE;
        for (ArrayList<Double> grades : studentGrades) {
            for (double g : grades) {
                if (g > highest) {
                    highest = g;
                }
            }
        }
        return highest == Double.MIN_VALUE ? 0 : highest;
    }

    public double findLowest() {
        double lowest = Double.MAX_VALUE;
        for (ArrayList<Double> grades : studentGrades) {
            for (double g : grades) {
                if (g < lowest) {
                    lowest = g;
                }
            }
        }
        return lowest == Double.MAX_VALUE ? 0 : lowest;
    }

    public void displaySummary() {
        System.out.println("Student Grade Summary Report:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println("Student: " + studentNames.get(i));
            System.out.println("Grades: " + studentGrades.get(i));
            System.out.printf("Average: %.2f\n", calculateAverage(i));
            System.out.println("--------------------------");
        }
        System.out.printf("Highest Score in all students: %.2f\n", findHighest());
        System.out.printf("Lowest Score in all students: %.2f\n", findLowest());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Welcome to the Student Grade Tracker");
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            tracker.addStudent(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                double grade = scanner.nextDouble();
                tracker.addGrade(i, grade);
            }
            scanner.nextLine(); // consume newline
        }

        tracker.displaySummary();
        scanner.close();
    }
}


