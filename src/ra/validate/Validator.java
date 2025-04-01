package ra.validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static String PHONE = "^(03|05|07|08|09)[0-9]{8}$";

    public static String validateEmployeeId(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã nhân viên (NV...): ");
            String id = sc.nextLine();
            if (id.matches("^NV\\d{4}$")) {
                return id;
            }
            System.out.println("Mã nhân viên phải bắt đầu bằng NV và theo sau là 4 số");
        }
    }

    public static String validateEmployeeName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên nhân viên: ");
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên nhân viên không được để trống");
        }
    }

    public static String validateBirthday(Scanner sc) {
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthday = sc.nextLine();
        return birthday;
    }

    public static String validatePhoneNumber(Scanner sc) {
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            String phone = sc.nextLine();
            if (Pattern.matches(PHONE, phone)) {
                return phone;
            }
            System.out.println("Số điện thoại phải theo định dạng số VN");
        }
    }

    public static boolean validateSex(Scanner sc) {
        while (true) {
            System.out.print("Nhập giới tính (1-Nam, 0-Nữ): ");
            String input = sc.nextLine();
            if (input.equals("1")){
                return true;
            }
            if (input.equals("0")){
                return false;
            }
            System.out.println("Vui lòng nhập 1 cho Nam hoặc 0 cho Nữ");
        }
    }

    public static float validateCoefficient(Scanner sc) {
        while (true) {
            System.out.print("Nhập hệ số lương: ");
            try {
                float coef = Float.parseFloat(sc.nextLine());
                if (coef > 0) {
                    return coef;
                }
                System.out.println("Hệ số lương phải lớn hơn 0");
            } catch (NumberFormatException e) {
                System.out.println("Hệ số lương phải là số");
            }
        }
    }

    public static int validateAllowanceSalary(Scanner sc) {
        while (true) {
            System.out.print("Nhập phụ cấp lương: ");
            try {
                int allowance = Integer.parseInt(sc.nextLine());
                if (allowance >= 0) {
                    return allowance;
                }
                System.out.println("Phụ cấp lương phải lớn hơn hoặc bằng 0");
            } catch (NumberFormatException e) {
                System.out.println("Phụ cấp lương phải là số");
            }
        }
    }

    public static String validateDepartment(Scanner sc) {
        while (true) {
            System.out.print("Nhập phòng ban: ");
            String dept = sc.nextLine();
            if (!dept.isEmpty()) {
                return dept;
            }
            System.out.println("Phòng ban không được để trống");
        }
    }
}