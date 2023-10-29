package org.jsp.hib_Jpa.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hib_Jpa.DTO.Person;

public class Merge {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to update if id is not present then it will save the record");
		int id = s.nextInt();
		System.out.println("Enter the age, name, phone, gender, and email to update");
		Person p = new Person();
		p.setId(id);
		p.setAge(s.nextInt());
		p.setName(s.next());
		p.setPhone(s.nextLong());
		p.setGender(s.next());
		p.setEmail(s.next());
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		manager.merge(p);
		EntityTransaction t = manager.getTransaction();
		t.begin();
		t.commit();
		s.close();
	}
}
