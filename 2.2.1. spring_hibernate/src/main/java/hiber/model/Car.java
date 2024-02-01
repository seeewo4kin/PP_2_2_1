package hiber.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private int series;
    private String model;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car(){
    }

    public String getModel(){
        return model;
    }

    public int getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                ", user=" + user +
                '}';
    }
}
