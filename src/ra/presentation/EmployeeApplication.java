package ra.presentation;

import ra.bussiness.EmployeeBusiness;

import java.util.Scanner;

public class EmployeeApplication {
    private static EmployeeBusiness employeeBusiness = new EmployeeBusiness();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    employeeBusiness.displayAllEmployees();
                    break;
                case 2:
                    employeeBusiness.addNewEmployee(sc);
                    break;
                case 3:
                    employeeBusiness.updateEmployee(sc);
                    break;
                case 4:
                    employeeBusiness.deleteEmployee(sc);
                    break;
                case 5:
                    employeeBusiness.searchEmployee(sc);
                    break;
                case 6:
                    employeeBusiness.sortEmployees(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("----------------------------Employee Menu----------------------------");
        System.out.println("1. Hiển thị danh sách nhân viên");
        System.out.println("2. Thêm mới nhân viên");
        System.out.println("3. Chỉnh sửa thông tin nhân viên");
        System.out.println("4. Xóa nhân viên");
        System.out.println("5. Tìm kiếm nhân viên");
        System.out.println("6. Sắp xếp");
        System.out.println("0. Thoát chương trình");
        System.out.print("Lựa chọn của bạn: ");
    }
}