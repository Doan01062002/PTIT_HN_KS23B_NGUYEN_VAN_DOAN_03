package ra.bussiness;

import ra.entity.Employee;
import ra.validate.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeBusiness {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees = new ArrayList<>();

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }
        employees.forEach(Employee::displayData);
    }

    public void addNewEmployee(Scanner sc) {
        if (employees.size() >= MAX_EMPLOYEES) {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm mới!");
            return;
        }

        System.out.print("Nhập số lượng nhân viên cần thêm: ");
        int count;
        try {
            count = Integer.parseInt(sc.nextLine());
            if (count <= 0 || count > MAX_EMPLOYEES - employees.size()) {
                System.out.println("Số lượng không hợp lệ!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng phải là số nguyên!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            Employee emp = new Employee();
            emp.inputData(sc);
            employees.add(emp);
        }
        System.out.println("Thêm mới nhân viên thành công!");
    }

    public void updateEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần sửa: ");
        String id = sc.nextLine();
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên!");
            return;
        }

        employee.displayData();
        System.out.println("Chọn thuộc tính cần sửa:");
        System.out.println("1. Tên nhân viên");
        System.out.println("2. Ngày sinh");
        System.out.println("3. Số điện thoại");
        System.out.println("4. Giới tính");
        System.out.println("5. Hệ số lương");
        System.out.println("6. Phụ cấp lương");
        System.out.println("7. Phòng ban");
        System.out.print("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                employee.setEmployeeName(Validator.validateEmployeeName(sc));
                break;
            case 2:
                employee.setBirthday(Validator.validateBirthday(sc));
                break;
            case 3:
                employee.setPhoneNumber(Validator.validatePhoneNumber(sc));
                break;
            case 4:
                employee.setSex(Validator.validateSex(sc));
                break;
            case 5:
                employee.setCoefficient(Validator.validateCoefficient(sc));
                break;
            case 6:
                employee.setAllowanceSalary(Validator.validateAllowanceSalary(sc));
                break;
            case 7:
                employee.setDepartment(Validator.validateDepartment(sc));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        System.out.println("Cập nhật thông tin thành công!");
    }

    public void deleteEmployee(Scanner sc) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String id = sc.nextLine();
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên!");
            return;
        }

        employee.displayData();
        System.out.print("Bạn có chắc chắn muốn xóa nhân viên này? (Yes/No): ");
        if (sc.nextLine().equalsIgnoreCase("Yes")) {
            employees.remove(employee);
            System.out.println("Xóa nhân viên thành công!");
        } else {
            System.out.println("Hủy bỏ thao tác xóa!");
        }
    }

    public void searchEmployee(Scanner sc) {
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm kiếm theo tên nhân viên");
        System.out.println("2. Tìm kiếm theo phòng ban");
        System.out.println("3. Tìm kiếm theo khoảng lương");
        System.out.print("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());
        if (employees.isEmpty()) {
            System.out.println("Danh sáachs trống không thể tìm kiếm");
            return;
        }

        switch (choice) {
            case 1:
                System.out.print("Nhập tên nhân viên cần tìm: ");
                String name = sc.nextLine().toLowerCase();
                employees.stream().filter(emp -> emp.getEmployeeName().toLowerCase().contains(name)).forEach(Employee::displayData);
                break;
            case 2:
                System.out.print("Nhập phòng ban cần tìm: ");
                String dept = sc.nextLine().toLowerCase();
                employees.stream().filter(emp -> emp.getDepartment().toLowerCase().contains(dept)).forEach(Employee::displayData);
                break;
            case 3:
                System.out.print("Nhập lương tối thiểu: ");
                long minSalary = Long.parseLong(sc.nextLine());
                System.out.print("Nhập lương tối đa: ");
                long maxSalary = Long.parseLong(sc.nextLine());
                employees.stream().filter(emp -> {
                            float totalSalary = emp.getTotalSalary();
                            return totalSalary >= minSalary && totalSalary <= maxSalary;
                        }).forEach(Employee::displayData);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }


    }

    public void sortEmployees(Scanner sc) {
        System.out.println("Chọn tiêu chí sắp xếp:");
        System.out.println("1. Theo tên tăng dần");
        System.out.println("2. Theo tên giảm dần");
        System.out.println("3. Theo tổng lương tăng dần");
        System.out.println("4. Theo tổng lương giảm dần");
        System.out.print("Lựa chọn của bạn: ");
        int choice = Integer.parseInt(sc.nextLine());

        List<Employee> sortedList = new ArrayList<>(employees);
        switch (choice) {
            case 1:
                sortedList.sort(Comparator.comparing(Employee::getEmployeeName));
                break;
            case 2:
                sortedList.sort(Comparator.comparing(Employee::getEmployeeName).reversed());
                break;
            case 3:
                sortedList.sort(Comparator.comparing(Employee::getTotalSalary));
                break;
            case 4:
                sortedList.sort(Comparator.comparing(Employee::getTotalSalary).reversed());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        sortedList.forEach(Employee::displayData);
    }

    private Employee findEmployeeById(String id) {
        return employees.stream().filter(emp -> emp.getEmployeeId().equals(id)).findFirst().orElse(null);
    }
}