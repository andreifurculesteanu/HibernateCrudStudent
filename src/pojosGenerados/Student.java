package pojosGenerados;
// Generated 21-feb-2019 13:46:08 by Hibernate Tools 5.2.11.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "tutorialDb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Student implements java.io.Serializable {

	private int id;
	private String name;
	private Date dob;
	private BigDecimal sal;

	public Student() {
	}

	public Student(int id) {
		this.id = id;
	}

	public Student(int id, String name, Date dob, BigDecimal sal) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.sal = sal;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "sal", precision = 7)
	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

}