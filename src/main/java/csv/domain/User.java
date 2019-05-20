package csv.domain;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 
    private String name; 
    private Double salary;
    
    public User() {}
    
    public User(String name, Double salary) {
    	this.name = name;
    	this.salary = salary;
    }

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; } 
	public void setName(String name) { this.name = name; }

	public Double getSalary() { return salary; } 
	public void setSalary(Double salary) { this.salary = salary; }
	
	@Override
	public String toString() {
		return String.format("User[id=%d, name='%s', salary='%s']", id, name, salary);
	}
     
}