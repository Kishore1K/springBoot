package mapping.Many2Many;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "emp_name")
    private String name;

    @ManyToMany
    @JoinTable(
            name ="emp_prj",
            joinColumns={@JoinColumn(name="eId")},
            inverseJoinColumns={@JoinColumn(name = "pId")}
    )
    private List<Project> projectList;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Employee() {
    }

    public Employee(int empId, String name, List<Project> projectList) {
        this.empId = empId;
        this.name = name;
        this.projectList = projectList;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
