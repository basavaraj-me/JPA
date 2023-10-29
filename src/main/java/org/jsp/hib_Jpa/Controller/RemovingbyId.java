package org.jsp.hib_Jpa.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.hib_Jpa.DTO.Person;

public class RemovingbyId {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter id to delete the record");
	int id = s.nextInt();
	EntityManager  m = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction t = m.getTransaction();
	Person p = m.find(Person.class, id);
	if(p!=null) {
		m.remove(p);
		System.out.println("Person deleted");
		t.begin();
		t.commit();
	}else{
		System.err.println("Can't delete the person!! As id is invalid");
	}
	s.close();
}
}
