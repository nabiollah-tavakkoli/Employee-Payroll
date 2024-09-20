package employees;

import java.util.Objects;

import contracts.TypeOfContract;

public class Employee {
	private String firstName;
	private String lastName;
	private String CF;
	private TypeOfContract typeofContract;

	public Employee(String firstName, String lastName, String CF, TypeOfContract typeofContract ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.CF = CF;
		this.typeofContract = typeofContract;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCF() {
		return CF;
	}

	public TypeOfContract getTypeofContract() {
		return typeofContract;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CF, firstName, lastName, typeofContract);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(CF, other.CF) 
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(typeofContract, other.typeofContract);
	}

	@Override
	public String toString() {
		return "Employee [firstName = " + firstName + 
				", lastName = " + lastName + 
				", CF = " + CF + 
				", typeofContract = "+ typeofContract + "]";
	}
	
	
	

}
