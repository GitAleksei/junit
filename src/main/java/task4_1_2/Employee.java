package task4_1_2;

public class Employee {
    private String surname;
    private String name;
    private int age;
    private String sex;
    private String education;
    private String position;
    private String department;

    public Employee(String surname, String name, int age, String sex, String education, String position, String department) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.position = position;
        this.department = department;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEducation() {
        return education;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%10d%10s%12s%10s%10s", surname, name, age, sex, education,
                position, department);
    }
}
