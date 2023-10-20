package mapping.Many2Many;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prjId;

    @Column(name = "prj_name")
    private  String prjName;

    public Project(int prjId, String prjName, List<Employee> employeeList) {
        this.prjId = prjId;
        this.prjName = prjName;
        this.employeeList = employeeList;
    }

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @Override
    public String toString() {
        return "Project{" +
                "prjId=" + prjId +
                ", prjName='" + prjName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public Project() {
    }

    public int getPrjId() {
        return prjId;
    }

    public void setPrjId(int prjId) {
        this.prjId = prjId;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }
}
