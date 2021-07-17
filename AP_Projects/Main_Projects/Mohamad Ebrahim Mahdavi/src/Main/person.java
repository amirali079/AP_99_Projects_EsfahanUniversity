package Main;

import java.io.Serializable;

enum job{
    pilot,driver,staff,lukomotoran,sailor
}
public class person implements Serializable {
    private final String name;
    private final String family;
    private final String birth_date;
    private final String birth_location;
    private final double salary;
    private final String gender;
    private final job career;
    public boolean working_status = false;

    public person(String name, String family, String birth_date, String birth_location, int salary, String gender, String career) {
        this.name = name;
        this.family = family;
        this.birth_date = birth_date;
        this.birth_location = birth_location;
        this.salary = salary;
        this.gender = gender;
        this.career = job.valueOf(career);
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public double getSalary() {
        return salary;
    }

    public String getCareer() {
        return career.name();
    }

}
