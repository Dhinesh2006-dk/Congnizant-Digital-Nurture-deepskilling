package com.cognizant.ormlearn;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
@SpringBootApplication
public class OrmLearnApplication {
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        testUpdateEmployee();
    }
    private static void testGetEmployee() {
        Employee employee = employeeService.get(1);
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }
    private static void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setName("Dhinesh");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(
                new SimpleDateFormat("dd/MM/yyyy")
                        .parse("18/02/2006"));
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println(employee);
    }
    private static void testUpdateEmployee() {
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println(employee);
    }
}