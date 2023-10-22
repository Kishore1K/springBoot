package mapping.jpa.entites;

import javax.persistence.*;

@Entity
@Table(name = "jpa_laptop")
public class Laptop {
    @Id
    private  int laptopId;
    private String modelNumber;
    private  String brand;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Students student;

    public Laptop() {
    }

    public Laptop(int laptopId, String modelNumber, String brand, Students student) {
        this.laptopId = laptopId;
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.student = student;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", modelNumber='" + modelNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", student=" + student +
                '}';
    }
}
