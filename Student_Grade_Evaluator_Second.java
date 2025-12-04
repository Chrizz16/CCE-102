package mypackage;

import java.util.Scanner;
import java.io.FileWriter;

public class Student_Grade_Evaluator_Second {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] inputGrades = collectGrades(scan);
		String text = evaluateStatus(inputGrades);
		saveToFile(text);
		System.out.println("\nSaved records to class_records.txt");
		scan.close();
	}
	
	public static double[] collectGrades(Scanner scan) {
		System.out.print("How many students in the class? ");
		int numStud = scan.nextInt();
		scan.nextLine();
		double[] grado = new double[numStud];
		System.out.println("Enter grades for " + numStud + " students: ");
		for (int i = 0; i < grado.length; i++) {
			System.out.print("Student " + (i+1) + ": ");
			grado[i] = scan.nextDouble();
			scan.nextLine();
		}
		return grado;
	}
	
	public static String evaluateStatus(double[] grado) {
		String text = "";
		for (int i = 0; i < grado.length; i++) {
			if (grado[i] >= 90) {
				text += String.format("Student %d: %.1f - Dean's Lister%n", (i+1), grado[i]);
			} else if (grado[i] >= 75) {
				text += String.format("Student %d: %.1f - Passed%n", (i+1), grado[i]);
			} else {
				text += String.format("Student %d: %.1f - Failed%n", (i+1), grado[i]);
			}
		}
		System.out.println();
		System.out.println(text);
		return text;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter("class_records.txt", true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
