package abarento;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Games {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many servers to test?" );
		int servers = sc.nextInt();

	public static int[] inputpingvalues(Scanner sc, int servers) {
		System.out.println("Enter ping for Server " + servers);
		int[] ping = new int[servers];
		for (int i = 0; i < ping.length; i++);
		System.out.println("Server " + (servers + 1) + ":");
		ping[servers] = sc.nextInt();
		sc.nextLine();
	}
	return ping;

	public static String CatergorizeConnectionQuality (int ping) {
		if (ping < 50) {
			return "Excellent";
		}	else if (ping > 150) {
			return "Good";
		} else {
			return	"Laggy";
		}

	}

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWrter("server_status.txt");
			fw.write(ping);
			fw.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
