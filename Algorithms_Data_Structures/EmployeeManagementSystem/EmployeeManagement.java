public class EmployeeManagement {

    Employee[] employees = new Employee[10];

    int count = 0;

    // Add Employee
    public void addEmployee(Employee employee) {

        if(count < employees.length) {

            employees[count] = employee;
            count++;

            System.out.println("Employee Added");
        }
        else {

            System.out.println("Array Full");
        }
    }

    // Search Employee
    public Employee searchEmployee(int id) {

        for(int i=0;i<count;i++) {

            if(employees[i].employeeId == id) {

                return employees[i];
            }
        }

        return null;
    }

    // Traverse Employees
    public void displayEmployees() {

        System.out.println("\nEmployee Records:");

        for(int i=0;i<count;i++) {

            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        int index = -1;

        for(int i=0;i<count;i++) {

            if(employees[i].employeeId == id) {

                index = i;
                break;
            }
        }

        if(index == -1) {

            System.out.println("Employee Not Found");
            return;
        }

        for(int i=index;i<count-1;i++) {

            employees[i] = employees[i+1];
        }

        employees[count-1] = null;
        count--;

        System.out.println("Employee Deleted");
    }

    public static void main(String[] args) {

        EmployeeManagement system =
                new EmployeeManagement();

        system.addEmployee(
                new Employee(101,
                             "Alice",
                             "Manager",
                             75000));

        system.addEmployee(
                new Employee(102,
                             "Bob",
                             "Developer",
                             60000));

        system.addEmployee(
                new Employee(103,
                             "Charlie",
                             "Tester",
                             50000));

        system.displayEmployees();

        System.out.println("\nSearch Result:");

        System.out.println(
                system.searchEmployee(102));

        system.deleteEmployee(102);

        system.displayEmployees();
    }
}
