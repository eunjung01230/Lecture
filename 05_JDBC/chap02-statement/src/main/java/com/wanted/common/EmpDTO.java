package com.wanted.common;

import java.util.Date;

public class EmpDTO {

    private int empId;
    private String empName;
    private String empNo;
    private String empEmail;
    private String empPhone;
    private int empSalary;
    private Date empHiredate;
    private Date empEntdate;
    private char empEntyn;

    public EmpDTO() {
    }

    public EmpDTO(int empId, String empName, String empNo, String empEmail, String empPhone, int empSalary, Date empHiredate, Date empEntdate, char empEntyn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
        this.empSalary = empSalary;
        this.empHiredate = empHiredate;
        this.empEntdate = empEntdate;
        this.empEntyn = empEntyn;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public Date getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(Date empHiredate) {
        this.empHiredate = empHiredate;
    }

    public Date getEmpEntdate() {
        return empEntdate;
    }

    public void setEmpEntdate(Date empEntdate) {
        this.empEntdate = empEntdate;
    }

    public char getEmpEntyn() {
        return empEntyn;
    }

    public void setEmpEntyn(char empEntyn) {
        this.empEntyn = empEntyn;
    }

    @Override
    public String toString() {
        return "EmpDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empSalary=" + empSalary +
                ", empHiredate=" + empHiredate +
                ", empEntdate=" + empEntdate +
                ", empEntyn=" + empEntyn +
                '}';
    }
}
