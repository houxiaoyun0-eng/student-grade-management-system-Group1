//  Group : 1
//Group members:Xiaoyun Hou; Rakshya Kc; Dragon Little; Toni Long;


import java.util.Scanner;

public class StudentScore {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int choice = 0;
            int count = 0;
            String[] names = new String[50];
            double[] grades = new double[50];

            // Menu system
            while (choice != 6) {
                showMenu();
                choice = input.nextInt();

                switch (choice) {
                    case 1: // Add student
                        count = addStudents(names, grades, count, input);
                        break;

                    case 2: // Display students
                        displayStudents(names, grades, count);
                        break;

                    case 3: // Search for a student
                        input.nextLine(); // clear leftover newline
                        searchStudents(names, grades, count, input);
                        break;

                    case 4: // Highest and lowest grades
                        highestLowest(grades, count);
                        break;

                    case 5: // Average grade
                        average(grades, count);
                        break;

                    case 6: // Exit
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

            input.close();
        }

        public static void showMenu() {
            System.out.println("\n1. Add Student");
            System.out.println("2. Show All Students' names and grades");
            System.out.println("3. Search");
            System.out.println("4. Highest and Lowest grades");
            System.out.println("5. Class Average");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
        }
        // ADD students methods
        public static int addStudents(String[] names, double[] grades, int count, Scanner input) {
            if (count >= 50) {
                System.out.println("Maximum number of students has been reached.");
                return count;
            }
            input.nextLine();
            System.out.print("Enter student name: ");
            String name = input.nextLine();

            System.out.print("Enter student grade: ");
            double grade = input.nextDouble();

            names[count] = name;
            grades[count] = grade;
            count++;

            System.out.println("Student added!");
            return count;
        }

        public static void displayStudents(String[] names, double[] grades, int count) {
            if (count == 0) {
                System.out.println("No students have been added yet.");
                return;
            }

            for (int i = 0; i < count; i++) {
                System.out.println("Student name: " + names[i] + " | Grade: " + grades[i]);
            }
        }

        public static void searchStudents(String[] names, double[] grades, int count, Scanner input) {
            if (count == 0) {
                System.out.println("No students have been added yet.");
                return;
            }

            System.out.print("Enter student name to search: ");
            String searchName = input.nextLine();

            boolean found = false;

            for (int i = 0; i < count; i++) {
                if (names[i].equalsIgnoreCase(searchName)) {
                    System.out.println(names[i] + "'s Grade: " + grades[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }

        public static void highestLowest(double[] grades, int count) {
            if (count == 0) {
                System.out.println("No students have been added yet.");
                return;
            }

            double lowest = grades[0];
            double highest = grades[0];

            for (int i = 1; i < count; i++) {
                if (grades[i] < lowest) {
                    lowest = grades[i];
                }
                if (grades[i] > highest) {
                    highest = grades[i];
                }
            }

            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        public static void average(double[] grades, int count) {
            if (count == 0) {
                System.out.println("No students have been added yet.");
                return;
            }

            double sum = 0;
            for (int i = 0; i < count; i++) {
                sum += grades[i];
            }

            double avg = sum / count;
            System.out.println("Average grade: " + avg);
        }
    }

