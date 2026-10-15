package com.wanted.common;

import java.util.Date;

public class EmployeeDTO {

    /* comment.
        DTO 기본 구성 요소
        1. 필드
        2. 기본생성자
        3. 모든 필드를 초기화하는 생성자
        4. Getter, Setter
        5. toString()
     */

    private int empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private Date entDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empId, String empName, String empNo, String email, String phone, Date entDate) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.phone = phone;
        this.entDate = entDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEntDate() {
        return entDate;
    }

    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", entDate=" + entDate +
                '}';
    }
}
