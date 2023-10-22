package mapping.jpa.entites;

import mapping.jpa.entites.Laptop;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_student")
public class Students {

    @Id
    private int id;
    private  String name;
    private  String about;

    private  String email;

    private String phno;

    @OneToOne(mappedBy = "student")
    private Laptop laptop;
    public Students() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +

                ", phno='" + phno + '\'' +


                ", laptop=" + laptop +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}
