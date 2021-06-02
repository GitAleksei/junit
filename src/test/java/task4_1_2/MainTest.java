package task4_1_2;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {
    @Test
    void searchBySurname_success() {
        String name = "Jhon";
        String surname = "Smith";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Miller", "Max", 28, "male",
                "graduate", "seo", "S1"));
        employees.add(new Employee("Smith", "Susana", 35, "female",
                "master", "developer", "D2"));
        employees.add(new Employee("Smith", "Jhon", 30, "male",
                "master", "developer", "D2"));

        int expected = 2;
        int actual = Main.searchBySurname(surname, name, employees);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void searchBySurname_null_in_list() {
        String name = "Jhon";
        String surname = "Smith";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Miller", "Max", 28, "male",
                "graduate", "seo", "S1"));
        employees.add(new Employee(null, null, 35, "female",
                "master", "developer", "D2"));
        employees.add(new Employee("Smith", "Jhon", 30, "male",
                "master", "developer", "D2"));

        Assertions.assertThrows(NullPointerException.class,
                () -> Main.searchBySurname(surname, name, employees));
    }

    @Test
    void searchBySurname_not_found() {
        String name = "Alex";
        String surname = "Smith";
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Miller", "Max", 28, "male",
                "graduate", "seo", "S1"));
        employees.add(new Employee("Smith", "Susana", 35, "female",
                "master", "developer", "D2"));
        employees.add(new Employee("Smith", "Jhon", 30, "male",
                "master", "developer", "D2"));

        int expected = -1;
        int actual = Main.searchBySurname(surname, name, employees);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void searchBySurname_empty_list() {
        String name = "Alex";
        String surname = "Smith";
        List<Employee> employees = new ArrayList<>();

        int expected = -1;
        int actual = Main.searchBySurname(surname, name, employees);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void searchBySurname_empty_list_and_not_found() {
        String name = "Alex";
        String surname = "Smith";
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Miller", "Max", 28, "male",
                "graduate", "seo", "S1"));
        employees1.add(new Employee("Smith", "Susana", 35, "female",
                "master", "developer", "D2"));
        employees1.add(new Employee("Smith", "Jhon", 30, "male",
                "master", "developer", "D2"));
        List<Employee> employees2 = new ArrayList<>();

        int expected = -1;

        MatcherAssert.assertThat(Arrays.asList(Main.searchBySurname(surname, name, employees1),
                Main.searchBySurname(surname, name, employees2)),
                Matchers.everyItem(Matchers.equalTo(expected)));
    }

    @Test
    void searchBySurname_is_() {
        String name = "Alex";
        String surname = "Smith";
        List<Employee> employees = new ArrayList<>();

        MatcherAssert.assertThat(Main.searchBySurname(surname, name, employees),
                Matchers.instanceOf(Integer.class));
    }
}