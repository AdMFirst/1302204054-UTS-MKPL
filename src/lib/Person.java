package lib;

public class Person {
    private String idNumber;
    private String name;

    Person(String name, String idNumber) {
        this.idNumber = idNumber;
        this.name = name;
    }


    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
