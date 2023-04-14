package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adressLine;
    private String city;
    private String zip;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String adressLine, String city, String zip) {
        this.name = name;
        this.adressLine = adressLine;
        this.city = city;
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return zip == publisher.zip && Objects.equals(id, publisher.id) && Objects.equals(name, publisher.name) && Objects.equals(adressLine, publisher.adressLine) && Objects.equals(city, publisher.city);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", adressLine='" + adressLine + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adressLine, city, zip);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdressLine() {
        return adressLine;
    }

    public void setAdressLine(String adressLine) {
        this.adressLine = adressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
