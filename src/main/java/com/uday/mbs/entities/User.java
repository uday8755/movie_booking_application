package com.uday.mbs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 20, nullable = false)
    private String password;



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Booking> bookings;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setASingleBooking(Booking booking){
        this.bookings.add(booking);
    }

    public int getCustomerId() {
        return userId;
    }

    public void setCustomerId(int customerId) {
        this.userId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "customerId=" + userId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                + ", username='" + username + '\'' + ", password='" + password + '\'' + ", dateOfBirth=" + '}';
    }
}
