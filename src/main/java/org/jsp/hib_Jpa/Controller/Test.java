package org.jsp.hib_Jpa.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.hib_Jpa.DTO.Person;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Person p = new Person();
		System.out.println("Enter the name age email gender and phone number");
//		p.setName(sc.next());
//		p.setAge(sc.nextInt());
//		p.setEmail(sc.next());
//		p.setGender(sc.next());
//		p.setPhone(sc.nextLong());
////		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
//		manager.persist(p);
//		EntityTransaction t = manager.getTransaction();
//		t.begin();
//		t.commit();
//		System.out.println("Record has been saved with ID: "+p.getId());
//		Person p = manager.find(Person.class, 1);//get record by passing entity class name and primarykey as parameter
//		Query q = manager.createQuery("select p from Person p");// works like statement
		Query q = manager.createNamedQuery("findall",Person.class);
		q.setParameter("id", 1);
		Person person =(Person) q.getSingleResult();// return type is Object
//		@SuppressWarnings("unchecked")
//		List<Person> l = q.getResultList();
//		for (Person person : l) {
			System.out.println(person.getId());
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(person.getEmail());
			System.out.println(person.getGender());
//			
//		}
//		System.out.println(manager.contains(p));
		sc.close();
	}
}
