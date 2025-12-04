package mypackage;
import java.io.FileWriter;
import java.util.Scanner;
public class The_Smart_Home_Energy_Auditor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many devices to scan? ");
		int devices = sc.nextInt();	
		String data =  "";
		int[] dev = scanDevices(sc, devices);
		for (int i = 0; i < dev.length; i++) {
			data += "Device " + (i+1) + ": " + dev[i] + "W - " + checkEfficiency(dev[i]) + "\n";
		}
		System.out.println("\n"+data);
		saveAudit(data);
		System.out.println("Energy audit saved to energy_audit.txt");
		sc.close();
	}

	public static int[] scanDevices(Scanner sc, int devices) {
		System.out.println("Enter wattage for " + devices + " devices:");
		int[] wattage = new int[devices];
		for (int i = 0; i < wattage.length; i++) {
			System.out.print("Device " + (i + 1) + ": ");
			wattage[i] = sc.nextInt();
			sc.nextLine();
		}
		return wattage;
	}
	public static String checkEfficiency(int watts) {
		if (watts < 200 ) {
			return "Eco-Friendly";
		} else if (watts <= 1500) {
			return "Standard";
		} else {
			return "Power Hog";
		}
	}
	public static void saveAudit (String data) {
		 try {
			FileWriter fw = new FileWriter("energy_audit.txt", true);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
