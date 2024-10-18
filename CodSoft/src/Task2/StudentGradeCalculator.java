package Task2;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void resultCalculator(Scanner sc) {
        try {
            System.out.println("\n    *** Welcome to Student Grade Calculator ***");
            System.out.println();
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            int subj[] = new int[n];
            int tot = 0;

            System.out.println("\nEnter marks:\n");
            System.out.println("+-------+------------+----------+");
            System.out.println("| Sr No.| Subject No |  Marks   |");
            System.out.println("+-------+------------+----------+");

            for (int i = 0; i < n; i++) {
                System.out.printf("|  %-4d |  Subject %-2d|   ", (i + 1), (i + 1)); 
                subj[i] = sc.nextInt();
                sc.nextLine();
                tot += subj[i];
                System.out.println("+-------+------------+----------+");
            }

            float average = (float) tot / n;
            String grade;
            if (average >= 90) {
                grade = "A";
            } else if (average >= 75) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else if (average >= 40) {
                grade = "D";
            } else {
                grade = "FAIL";
            }

            System.out.println("\n\n    **** Student Result ****\n");
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Total Marks          |   %-3d/%d    |\n", tot,(n * 100));
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Average Percentage   |   %-6.2f     |\n", average);
            System.out.println("+----------------------+--------------+");
            System.out.printf("| Grade                |   %-6s     |\n", grade);
            System.out.println("+----------------------+--------------+");

            if (grade.equals("FAIL")) {
                System.out.println("\nSorry, you have failed the exam.\nBetter luck next time!");
                System.out.println("\t _____");
                System.out.println("\t|     |");
                System.out.println("\t| * * |");
                System.out.println("\t|  ^  |");
                System.out.println("\t|_____|");
                System.out.println("\nKeep trying! You can do it! :)");
            } else { 
                System.out.println(" ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Congratulations! You have passed the exam!");
                System.out.println("        *      	             	    *	  ");
                System.out.println("            *       \\O/        *          ");
                System.out.println("        *       *    |      *       *	  ");
                System.out.println("            *       / \\        *          ");
                System.out.println("        *                           *      ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            resultCalculator(s);
            System.out.print("Do you want to calculate another student result (y/n): ");
            String ch = s.next();
            if (ch.equalsIgnoreCase("y")) {
                continue;
            } else {
                System.out.println("Thank you! Have a good day!");
                break; 
            }
        }
        s.close();
    }
}
