package task4_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\nВведите информацию о сотруднике " +
                    "(фамилия, имя, возраст, пол, образование, должность, отдел): ");

            String surname = request("фамилию");
            String name = request("имя");
            int age = Integer.parseInt(request("возраст"));
            String sex = request("пол");
            String education = request("образование");
            String position = request("должность");
            String department = request("отдел");

            employees.add(new Employee(surname, name, age, sex, education, position, department));

            printEmployees(employees);
            System.out.println("Если хотите закончить ввод данных, введите end");
            if ("end".equals(scanner.nextLine())) {
                while (true) {
                    System.out.println("Если не хотите менять данные, введите end");
                    String input = scanner.nextLine();

                    if ("end".equals(input)) {
                        break;
                    }

                    System.out.println("Введите фамилию и имя работника, для которого хотите изменить данные:");
                    surname = scanner.next();
                    name = scanner.nextLine().trim();

                    int index = searchBySurname(surname, name, employees);
                    if (index != -1) {
                        employees.get(index).setSurname(requestChange(employees.get(index).getSurname(),
                                "фамилию"));
                        employees.get(index).setName(requestChange(employees.get(index).getName(),
                                "имя"));
                        employees.get(index).setAge(Integer.parseInt(requestChange(Integer.toString(employees.get(index).getAge()),
                                "возраст")));
                        employees.get(index).setSex(requestChange(employees.get(index).getSex(),
                                "пол"));
                        employees.get(index).setEducation(requestChange(employees.get(index).getEducation(),
                                "образование"));
                        employees.get(index).setPosition(requestChange(employees.get(index).getPosition(),
                                "должность"));
                        employees.get(index).setDepartment(requestChange(employees.get(index).getDepartment(),
                                "отдел"));

                        printEmployees(employees);
                    }
                }

                break;
            }
        }
    }

    private static String request(String fieldOfEmployeeRus) {
        System.out.println("Введите " + fieldOfEmployeeRus + " сотрудника: ");
        return scanner.nextLine();
    }

    private static String requestChange(String fieldOfEmployee, String fieldOfEmployeeRus) {
        System.out.println("Меняем " + fieldOfEmployeeRus + " " + fieldOfEmployee + "? (да)");
        if (scanner.nextLine().equals("да")) {
            return request(fieldOfEmployeeRus);
        }
        return fieldOfEmployee;
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.printf("\n%15s%10s%10s%10s%12s%10s%10s\n", "фамилия", "имя", "возраст",
                "пол", "образование", "должность", "отдел");
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("%3d. %s\n", i + 1, employees.get(i).toString());
        }
    }

    public static int searchBySurname(String surname, String name, List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSurname().equals(surname) && employees.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
