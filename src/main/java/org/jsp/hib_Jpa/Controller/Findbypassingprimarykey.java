package org.jsp.hib_Jpa.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.hib_Jpa.DTO.Person;

public class Findbypassingprimarykey {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter id to display the details");
		int id = s.nextInt();
		EntityManager m = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Person p = m.find(Person.class, id);
		if (p != null) {
			System.out.println("Person id: " + p.getId());
			System.out.println("Name : " + p.getName());
			System.out.println("Phone : " + p.getPhone());
			System.out.println("Email : " + p.getEmail());
			System.out.println("Age : " + p.getAge());
			System.out.println("Gender : " + p.getGender());
		} else {
			System.err.println("You have enterd Invalid id");
		}
		s.close();
	}
}
