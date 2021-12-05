package com.java.demo.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sun.security.util.Pem;

public class StartingPoint {

	
	public static void main(String[] args) {
		
		Emp e1 = new Emp(101,"XXXX1");
		Emp e2 = new Emp(102,"XXXX2");
		
		Perm p1 = new Perm(103,"PPPPP1","PCCCC1",203);
		Perm p2 = new Perm(104,"PPPPP2","PCCCC1",202);
		
		
		Contract c1 = new Contract(105, "TTTT", "CCCC");
		
		System.out.println("-------------------------------------------------");
		SessionFactory sfactory1  = HibernateUtil.getSessionFactoryInstanceAnn();
		Session s11 = sfactory1.openSession();
		
		s11.get(Emp.class,1);		// only on emp	
		
		s11.get(Perm.class,1);
		
		Transaction tr11 = s11.beginTransaction();
		s11.save(e1);
		s11.save(p1);
		s11.save(e2);
		s11.save(p2);
		s11.save(c1);
		
		s11.flush();
		tr11.commit();
		System.out.println("-------------------------------------------------");
		
		System.exit(0);
		//T
		Employee emp1 = new Employee(101,"ABCD", "abc@gmail.com","SE", "M");
		//emp1.setEmpRole("Manager");// is this dirty object ???? -- NO
		
		System.out.println("-------------------------------------------------");
		SessionFactory sfactory  = HibernateUtil.getSessionFactoryInstanceAnn();
		Session s1 = sfactory.openSession();
		Transaction tr1 = s1.beginTransaction();
		s1.save(emp1);
		s1.flush();
		tr1.commit();
		System.out.println("-------------------------------------------------");
		
		//Persistent
		//emp1.setEmpRole("Manager"); // within session modified
		
		emp1.setEmpRole("Manager");
		//s1 = sfactory.openSession();
		tr1 = s1.beginTransaction();
		s1.update(emp1);
		s1.flush();
		tr1.commit();
		
		s1.clear();				//s1.clear()           s1.close    s1.evict(entity)	 s1 = null      s1.delete(entity) 
		
		System.exit(0);
		// Detached --?
		emp1.setEmpRole("Manager");   // outside session modified ---> dirty object
					//?												//[detached state madhe object modify]
		System.out.println("-------------------------------------------------");
		Session s2 = sfactory.openSession();
		Transaction tr2 = s2.beginTransaction();
		Employee emp2 = s2.get(Employee.class,101); //SE
		emp2.setEmpRole("CEO");	// SE - CEO		----> update fails here...
		s2.merge(emp1);						// within same same - same id-- more than 1 instances --
		s2.flush();								// state is diff --> 1 object is dirty--
		tr2.commit();
		
		System.out.println(emp2);
		System.out.println(emp1);
		
	}
}
