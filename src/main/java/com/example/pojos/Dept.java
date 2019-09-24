package com.example.pojos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dept",schema = "test")
public class Dept {
    private Integer did;
    private String dname;
    private String address;
    private List<Employee> emps;

    @Id
    @Column(name = "did", nullable = false)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname", nullable = true, length = 50)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(did, dept.did) &&
                Objects.equals(dname, dept.dname) &&
                Objects.equals(address, dept.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dname, address);
    }

    @OneToMany(mappedBy = "dept")
    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Dept() {
    }

    public Dept(Integer did, String dname, String address) {
        this.did = did;
        this.dname = dname;
        this.address = address;
    }
}
