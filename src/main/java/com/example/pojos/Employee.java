package com.example.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee",schema = "test")
public class Employee {
    private Integer empid;
    private String ename;
    private Integer age;
    private Integer sex;
    private Dept dept;

    @Id
    @Column(name = "empid", nullable = false)
    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 50)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empid, employee.empid) &&
                Objects.equals(ename, employee.ename) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(sex, employee.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, ename, age, sex);
    }

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "did")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
