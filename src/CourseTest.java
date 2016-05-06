//Jeremy Sanders
//Insy 4305-001

import java.io.*;
import java.util.*;
import javax.swing.*;

public class CourseTest
{
	public static void main(String[] args)
	{
		ArrayList<Customer> customerList=new ArrayList<Customer>();

		CreateFiles.writeCustomers();
		CreateFiles.writeCourses();
		customerList=readCustomers("customers.txt");
		customerList=readCourses("courses.txt",customerList);

		for(Customer c:customerList)
		{
			System.out.println(c);
			System.out.println();
		}

		generateInvoice(customerList);
	}

	public static ArrayList<Customer> readCustomers(String fileName)
	{
		Scanner input;
		Customer tempCustomer;
		String line;
		String values[];
		ArrayList<Customer> tempCustomerList=new ArrayList<Customer>();

		try
		{
			input=new Scanner(new File(fileName));

			while(input.hasNext())
			{
				line=input.nextLine();
				values=line.split(" ");

				tempCustomer=new Customer(values[0],new Address(values[1],values[2],values[3],Integer.parseInt(values[4])),Integer.parseInt(values[5]));

				if (values[6].equals("student"))
					tempCustomer.setCType(Customer.CustomerType.STUDENT);
				else if (values[6].equals("faculty"))
					tempCustomer.setCType(Customer.CustomerType.FACULTY);
				else if (values[6].equals("government"))
					tempCustomer.setCType(Customer.CustomerType.GOVERNMENT);
				else
					System.out.println("ERROR: CourseTest.readCustomers() cType");

				tempCustomerList.add(tempCustomer);
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		return tempCustomerList;
	}

	public static ArrayList<Customer> readCourses(String fileName, ArrayList<Customer> tempCustomerList)
	{
		Scanner input;
		Course tempCourse;
		String customerName="";
		String line;
		String values[];

		try
		{
			input=new Scanner(new File(fileName));

			while(input.hasNext())
			{
				line=input.nextLine();
				values=line.split(" ");

				if (values[0].equals("Online"))
				{
					tempCourse=new OnlineCourse(values[1],values[2],Double.parseDouble(values[3]),new Date(Integer.parseInt(values[4]),Integer.parseInt(values[5]),Integer.parseInt(values[6])),new Date(Integer.parseInt(values[7]),Integer.parseInt(values[8]),Integer.parseInt(values[9])),values[11],Boolean.parseBoolean(values[12]),Integer.parseInt(values[13]));
					customerName=values[14];
				}
				else if (values[0].equals("InClass"))
				{
					tempCourse=new InClassCourse(values[1],values[2],Double.parseDouble(values[3]),new Date(Integer.parseInt(values[4]),Integer.parseInt(values[5]),Integer.parseInt(values[6])),new Date(Integer.parseInt(values[7]),Integer.parseInt(values[8]),Integer.parseInt(values[9])),values[11],new Time(Integer.parseInt(values[12]),Integer.parseInt(values[13])),new Time(Integer.parseInt(values[14]),Integer.parseInt(values[15])));
					customerName=values[16];
				}
				else
				{
					System.out.println("ERROR CourseTest.readCourses: Must be Online or In Class");
					tempCourse=new Course();
				}

				switch (values[10])
				{
					case "programming":
						tempCourse.setCType(Course.CourseType.PROGRAMMING);
						break;

					case "mathematics":
						tempCourse.setCType(Course.CourseType.MATHEMATICS);
						break;

					case "photography":
						tempCourse.setCType(Course.CourseType.PHOTOGRAPHY);
						break;

					case "music":
						tempCourse.setCType(Course.CourseType.MUSIC);
						break;

					case "painting":
						tempCourse.setCType(Course.CourseType.PAINTING);
						break;

					case "misc":
						tempCourse.setCType(Course.CourseType.MISC);
						break;

					default:
						System.out.println("ERROR CourseTest.readCourses: Course type invalid");
				}

				for (Customer c:tempCustomerList)
					if(customerName.equals(c.getName()))
						c.addCourse(tempCourse);
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		return tempCustomerList;
	}

	public static void generateInvoice(ArrayList<Customer> customerList)
	{
		String invoices="";

		for (Customer c:customerList)
		{
			try
			{
				if(c.getCourseList().isEmpty())
					throw new CustomerNotEnrolledException(c);
				else
				{
					invoices+=c.createInvoice();
					invoices+="\n";
				}
			}
			catch(CustomerNotEnrolledException e)
			{
				System.out.printf("Customer %s is not enrolled in any courses.\n",e.getCustomer().getName());
			}
		}

		JOptionPane.showMessageDialog(null,invoices);
	}
}