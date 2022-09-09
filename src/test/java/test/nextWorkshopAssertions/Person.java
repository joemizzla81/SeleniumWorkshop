package test.nextWorkshopAssertions;

public class Person {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if ((firstName == null) || firstName.isBlank()){
            throw new IllegalArgumentException("Value not correct for firstname");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName);
        }
        return false;
    }
}
