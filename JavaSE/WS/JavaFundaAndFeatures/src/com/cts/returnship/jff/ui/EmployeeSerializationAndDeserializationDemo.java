package com.cts.returnship.jff.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cts.returnship.jff.model.Employee;

public class EmployeeSerializationAndDeserializationDemo {

	public static void main(String[] args) {

		final String EMP_STORE_PATH = "./empStore.data";

		File empStoreFile = new File(EMP_STORE_PATH);

		List<Employee> emps = null;

		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		if (empStoreFile.exists()) {
			try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(empStoreFile))) {
				emps = (List<Employee>) os.readObject(); // Deserialization
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			emps = new ArrayList<>();
		}

		if (!emps.isEmpty()) {
			System.out.println("Existing Records");

			for (Employee e : emps) {
				System.out.println(e);
			}
		}

		System.out.print("How many records you wish to add? ");
		int count = scan.nextInt();

		for (int i = 1; i <= count; i++) {
			Employee e = new Employee();
			System.out.print("EmpId: ");
			e.setEmpId(scan.nextLong());
			System.out.print("Full Name: ");
			e.setFullName(scan.next());
			System.out.print("Date Of Joining(dd-MM-yyyy): ");
			e.setDateOfJoining(LocalDate.parse(scan.next(), dtformatter));
			System.out.print("Basic Pay: ");
			e.setBasic(scan.nextDouble());
			emps.add(e);
		}

		if (count != 0) {
			try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(empStoreFile))) {
				os.writeObject(emps); // Serialization
				System.out.println("Data Saved Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}

}
