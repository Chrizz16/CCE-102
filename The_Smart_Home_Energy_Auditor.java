package mypackage;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class The_Smart_Home_Energy_Auditor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = new File("energy_audit.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		
		int[] input = scanDevices(sc);
		String getWatts = checkEfficiency(input);
		saveAudit(getWatts, file);
		
		sc.close();
		    
	}
	
	public static int[] scanDevices(Scanner scan) {
		System.out.print("How many devices to scan? ");
		int numDev = scan.nextInt();
		scan.nextLine();
		int[] wattage = new int[numDev];
		System.out.printf("Enter wattage for %d devices:%n", numDev);
		for (int i = 0; i < wattage.length; i++) {
			System.out.printf("Device %d: ", (i+1));
			wattage[i]= scan.nextInt();
			scan.nextLine();
		}
		return wattage;
		
		
	}
	
	public static String checkEfficiency(int[] watts) {
		String contain = "";
		for (int i = 0; i < watts.length; i++) {
			if (watts[i] > 1500) {
				contain += "Device " + (i+1) + ": " + watts[i] + "W - " + "Power Hog\n";
			} else if(watts[i] >= 200) {
				contain += "Device " + (i+1) + ": " + watts[i] + "W - " + "Standard\n";
			} else {
				contain += "Device " + (i+1) + ": " + watts[i] + "W - " + "Eco-Friendly\n";
			}
			
		}
		System.out.println();
		System.out.println(contain);
		return contain;
	}
	
	public static void saveAudit(String text, File file) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
			System.out.println("Energy audit saved to energy_audit.txt");
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
}
