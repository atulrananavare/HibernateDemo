package com.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.java.demo.sample.Employee;
import com.to.Player;

public class PlayerMainClass {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();		
		config.addAnnotatedClass(com.to.Player.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory=config.buildSessionFactory(builder.build());
		
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		/*Player p1= new Player(07, "Dhoni", "CSK", 37);
		Player p2= new Player(45, "Rohit", "MI", 34);
		session.save(p1);
		session.save(p2);
		Player p3=session.get(Player.class, 45);
		System.out.println("The Details are: "+p3);		
		p3.setAge(60);
		p3.setPlayerName("Sachin");*/
		
		
		//Criteria Concept
		Player p1= new Player("Dhoni", "CSK", 37);
		Player p2= new Player("Jadeja", "CSK", 30);
		Player p3= new Player("Aumrah", "MI", 28);
		Player p4= new Player("A", "KKR", 20);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		
		Criteria criteria=session.createCriteria(Player.class);
		criteria.add(Restrictions.like("playerName", "A%"));
		criteria.add(Restrictions.le("age", 30));
		List<Player> list=criteria.list();
		System.out.println(list);
		
		//Query interface in Hibernate
		SQLQuery query = session.createSQLQuery("select Player_Name, age from Player_Info");
		List<Object[]> rows = query.list();
		for(Object[] row : rows){
		    Player e = new Player();
		    e.setPlayerName(row[0].toString());
		    e.setAge(Integer.parseInt(row[1].toString()));
		    System.out.println(e);
		}
		
		/*Query query=session.createQuery("from Player");
		
		List<Player> playerList=query.getResultList();
		System.out.println("Player Details");
		for (Player player : playerList) {
			System.out.println(player);
		}*/
		transaction.commit();
		session.close();
	}

}
