package ra.entity;

import ra.validate.Validator;

import java.util.Scanner;

public class Employee implements IApp {
    private static final int BASE_SALARY = 1800000;
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coefficient;
    private int allowanceSalary;
    private String department;
    private byte status;

    public Employee() {
        this.allowanceSalary = 0;
        this.status = 1;
    }

    public Employee(String employeeId, String employeeName, String birthday, String phoneNumber, boolean sex, float coefficient, int allowanceSalary, String department, byte status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.coefficient = coefficient;
        this.allowanceSalary = allowanceSalary;
        this.department = department;
        this.status = status;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public boolean isSex() { return sex; }
    public void setSex(boolean sex) { this.sex = sex; }
    public float getCoefficient() { return coefficient; }
    public void setCoefficient(float coefficient) { this.coefficient = coefficient; }
    public int getAllowanceSalary() { return allowanceSalary; }
    public void setAllowanceSalary(int allowanceSalary) { this.allowanceSalary = allowanceSalary; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public byte getStatus() { return status; }
    public void setStatus(byte status) { this.status = status; }

    @Override
    public void inputData(Scanner sc) {
        this.employeeId = Validator.validateEmployeeId(sc);
        this.employeeName = Validator.validateEmployeeName(sc);
        this.birthday = Validator.validateBirthday(sc);
        this.phoneNumber = Validator.validatePhoneNumber(sc);
        this.sex = Validator.validateSex(sc);
        this.coefficient = Validator.validateCoefficient(sc);
        this.allowanceSalary = Validator.validateAllowanceSalary(sc);
        this.department = Validator.validateDepartment(sc);
    }

    public float getTotalSalary(){
        return BASE_SALARY * coefficient + allowanceSalary;
    }

    @Override
    public void displayData() {
        String gender = sex ? "Nam" : "Nữ";
        String statusStr = status == 1 ? "Đang làm việc" : status == 2 ? "Đang nghỉ phép" : "Đã nghỉ việc";
        float totalSalary = (BASE_SALARY * coefficient + allowanceSalary);

        System.out.printf("Mã NV: %s - Tên: %s - Năm sinh: %s - Giới tính: %s - SĐT: %s - Tổng lương: %f - Phòng ban: %s - Trạng thái: %s%n", employeeId, employeeName, birthday , gender, phoneNumber, totalSalary, department, statusStr);
    }
}