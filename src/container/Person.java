package container;

import java.util.ArrayList;
import java.util.Iterator;

public class Person implements Iterable<Person>{

	public Person(String fn, String ln, int a, Person... kids){
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		for(Person child : kids)
			children.add(child);
	}
	
	public Iterator<Person> iterator() {
		return children.iterator();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() { 
        return "[Person: " +
            "firstName=" + firstName + " " +
            "lastName=" + lastName + " " +
            "age=" + age + "]";
    }
	 
	public static void main(String[] args) {
		Person ted = new Person("Ted", "Neward", 39,
	            new Person("Michael", "Neward", 16),
	            new Person("Matthew", "Neward", 10));

        // Iterate over the kids
        for (Person kid : ted)
        {
            System.out.println(kid.getFirstName());
        }
	}
	
	private String firstName;
	private String lastName;
	private int age;
	private ArrayList<Person> children = new ArrayList<Person>();
}
