package homeWork2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Address {
	Table table = new Table();

	public static void main(String[] args) throws IOException {
		Address hw2 = new Address();
		hw2.run();
	}

	public void run() throws IOException {
		String key, value, choiceStr;
		boolean success;
		char choice = 0;

		inputFromFile();

		while (choice != 'q') {
			String msg = "Add a name (n)\rLook up a name (l)\rUpdate address (u)\rDelete an entry (d)\rDisplay all entries (a)\rSave (s)\rQuit (q)\r->";
			choiceStr = readLine(msg);
			choice = choiceStr.charAt(0);

			switch (choice) {

			case 'n':
				key = readLine("Name");
				value = readLine("Address");
				success = table.insert(key, value);
				if (!success)
					print("Name already present!!!");
				break;
			case 'l':
				key = readLine("Name");
				value = table.lookUp(key);
				if (value == null)
					print("Not found: ", key);
				else
					print("Address is: ", value);
				break;
			case 'u':
				key = readLine("Name");
				value = table.lookUp(key);
				if (value == null)
					print("The name was not found!", key);
				else {
					print("Old address is ", value);
					value = readLine("New address");
					table.update(key, value);
				}
				break;
			case 'd':
				key = readLine("Name to delete");
				success = table.delete(key);
				if (!success)
					print("Can not delete!!!");
				break;
			case 'a':
				Integer count = table.displayAll();
				print("Total records ", count.toString());
				break;
			case 's':
				String filename = readLine("Name of the file to save to:");
				table.save(filename);
				break;
			case 'q':
				break;
			default:
				print("That case was not found!!!");
			}
		}
		print("Thank you!!!");

	}

	private void inputFromFile() throws IOException {
		String choiceStr = readLine("Do you want to open a file? (y/n).");
		char choice = choiceStr.charAt(0);
		if (choice == 'y') {
			String filename = readLine("Please provide full file path:");
			// reading a file line by line before Java 8
			FileReader fr = new FileReader(filename);
			BufferedReader bufr = new BufferedReader(fr);
			String line;
			do {
				String key = bufr.readLine();
				if (isNullOrEmpty(key))
					break;
				String value = bufr.readLine();
				if (isNullOrEmpty(value))
					break;
				table.insert(key, value);
				line = bufr.readLine();
			} while (line != null);
			bufr.close();
		}
	}

	private void print(String msg, String value) {
		print(msg + ":" + value);
	}

	private void print(String msg) {
		System.out.println(msg);
	}

	private String readLine(String msg) {
		System.out.println(msg + ": ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	private boolean isNullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}

}