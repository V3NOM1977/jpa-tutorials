package com.example.jpa.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
/**
 * rather than creating repository we can also do like this.
 */
@NamedQuery(name = "User.findByZipCode1", query = "SELECT a FROM Address a WHERE a.zipCode = ?1")
@NamedQueries({
        @NamedQuery(name = "User.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = ?1"),
        @NamedQuery(name = "User.findById", query = "SELECT a FROM Address a WHERE a.id = ?1")
})
@NamedNativeQuery(name = "User.findByZipCode2", query = "SELECT a FROM Address a WHERE a.zipCode = ?1")
@NamedNativeQueries({
    @NamedNativeQuery(name = "User.findByZipCode3", query = "SELECT a FROM Address a WHERE a.zipCode = ?1"),
    @NamedNativeQuery(name = "User.findByZipCode4", query = "SELECT a FROM Address a WHERE a.zipCode = ?1")
})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String zipCode;

    public Address() {
    }

    public Address(String zipCode) {
        this.zipCode = zipCode;
    }

}
