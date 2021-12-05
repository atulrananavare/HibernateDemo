package com.java.demo.sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneMapping {

	
	public static void main(String[] args) {
		IDCard card1 = new IDCard(11111,"Pune", "Mr. XXXX", "A+");
		IDCard card2 = new IDCard(11112,"Pune", "Mr. XXXX", "AB+");
		
		Student st1 = new Student(1,"AAAA","Mumbai", card1);
		Student st2 = new Student(2,"BBBB","Pune", card2);
		
		
		card1.setStudent(st1);
		card2.setStudent(st2);
		
		SessionFactory sfactory  = HibernateUtil.getSessionFactoryInstanceAnn();
		Session s1 = sfactory.openSession();
		Transaction tr1 = s1.beginTransaction();
		
		s1.save(card1);
		s1.save(card2);
		s1.save(st1);
		s1.save(st2);
		s1.flush();
		tr1.commit();
		
		System.out.println("INSERT COMPLETED...");
		
		
		System.out.println("FETCHING --");
		Student dbStud = s1.get(Student.class,1);
		System.out.println(dbStud);
		
		
		IDCard card11 = s1.get(IDCard.class,11112);
		System.out.println(card11);
		
		System.exit(0);
		
		
	}
}

@Entity
@Table(name = "STUDENT_INFO")
class Student{
	
	@Id
	private int studId;
	private String studName;
	private String studAddress;
	@OneToOne
	@JoinColumn(name = "card_num",unique = true)
	private IDCard card;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public IDCard getCard() {
		return card;
	}
	public void setCard(IDCard card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress + ", card="
				+ card + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studId, String studName, String studAddress, IDCard card) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		this.card = card;
	}
	
	
	
	
}

@Entity
@Table(name = "IDENTITY_INFO")
class IDCard{
	@Id
	private int idNumber;
	private String issuingPlace;
	private String signingAuthority;
	private String bloodGrp;
	
	@OneToOne(mappedBy = "card")
	private Student student;
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public IDCard(int idNumber, String issuingPlace, String signingAuthority, String bloodGrp) {
		super();
		this.idNumber = idNumber;
		this.issuingPlace = issuingPlace;
		this.signingAuthority = signingAuthority;
		this.bloodGrp = bloodGrp;
	}
	public IDCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getIssuingPlace() {
		return issuingPlace;
	}
	public void setIssuingPlace(String issuingPlace) {
		this.issuingPlace = issuingPlace;
	}
	public String getSigningAuthority() {
		return signingAuthority;
	}
	public void setSigningAuthority(String signingAuthority) {
		this.signingAuthority = signingAuthority;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	@Override
	public String toString() {
		return "IDCard [idNumber=" + idNumber + ", issuingPlace=" + issuingPlace + ", signingAuthority="
				+ signingAuthority + ", bloodGrp=" + bloodGrp +" ["+ student.getStudName()+","+student.getStudId() +"]";
	}
	
	
	
}