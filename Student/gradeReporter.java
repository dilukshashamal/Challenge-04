package Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class gradeReporter {

    public static void main(String[] args) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();

        try(Scanner scanner= new Scanner(new File("input.txt"))){
            int numberOfStudent = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i<numberOfStudent; i++){
                String nameLine = scanner.nextLine();
                String[] nameParts = nameLine.split(", ");
                String lastName = nameParts[0];
                String firstName = nameParts[1];

                String gradeLine = scanner.nextLine();
                String[] gradeParts = gradeLine.split(" ");
                String course = gradeParts[0];
                int[] grades = new int[gradeParts.length-1];
                for(int j=1; j<gradeParts.length; j++){
                    grades[j-1] = Integer.parseInt(gradeParts[j]);
                }

                if(course.equals("English")){
                    students.add(new EnglishStudent (firstName, lastName, grades[0], grades[1], grades[2]));
                } else if (course.equals("Science")){
                    students.add(new ScienceStudent (firstName, lastName, grades[0], grades[1], grades[2], grades[3]));
                } else if (course.equals("Math")){
                    students.add(new MathStudent (firstName, lastName, grades[0], grades[1], grades[2], grades[3], grades[4], grades[5], grades[6], grades[7]));
                }

            }
        } catch (IOException e){

        }

        try(PrintWriter writer = new PrintWriter(new File("output.txt"))){
            for(String course : Arrays.asList("English", "Science", "Math")){
                writer.println(course+" Students");
                writer.println("Name\tFinal Exam\tFinal Average\tLetter Grade");
                writer.println("----\t----------\t---------\t");

                for(Student student : students) {
                    double finalAverage = student.calculateFinalGrade();
                    String letterGrade = "";
                    if(finalAverage >= 90){
                        letterGrade = "A";
                    } else if(finalAverage >= 80){
                        letterGrade = "B";
                    } else if(finalAverage >= 70){
                        letterGrade = "C";
                    } else if(finalAverage >= 60){
                        letterGrade = "D";
                    } else {
                        letterGrade = "F";
                    }
                    writer.printf("%s %s\t%d\t\t%.2f\t\t%s\n", student.getFirstName(), student.getLastName(), student.getFinalExam(), finalAverage, letterGrade);
                }
                writer.println();
            }
            writer.println("Grade Distribution");
            int[] gradeCounts = new int[5];
            for(Student student:students){
                double finalAverage = student.calculateFinalGrade();
                if(finalAverage >= 90){
                    gradeCounts[0]++;
                } else if(finalAverage >= 80){
                    gradeCounts[1]++;
                } else if(finalAverage >= 70){
                    gradeCounts[2]++;
                } else if(finalAverage >= 60){
                    gradeCounts[3]++;
                } else {
                    gradeCounts[4]++;
                }
            }
            writer.printf("A: %d\nB: %d\nC: %d\nD: %d\nF: %dn", gradeCounts[0], gradeCounts[1], gradeCounts[2], gradeCounts[3], gradeCounts[4]);
        } catch (IOException e){

        }
    }
}
