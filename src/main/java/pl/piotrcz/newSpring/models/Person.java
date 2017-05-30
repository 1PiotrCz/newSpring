package pl.piotrcz.newSpring.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.temporal.ValueRange;

/**
 * Created by Piotr Czubkowski on 2017-05-29.
 */
public class Person {
    @NotEmpty (message = "{NotEmpty.person.name}")
//    @Size(min = 3, max = 25, message = "Min 3, max 25")
        @Size(min = 3, max = 25, message = "{Size.person.name}")
    private String name;
//    @NotEmpty (message = "Pole Nazwisko nie może być Puste")
    @NotEmpty (message = "{NotEmpty.person.lastname}")
    @Max(value = 25, message = "{Max.person.lastname}")
    @Min(value = 5, message = "{Min.person.lastname}")
    private String lastname;
    @Range(min = 0, max = 120 , message = "{Range.person.age}")
    private int age;
    @NotEmpty (message = "{NotEmpty.person.number}")
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{3}", message = "{Pattern.person.number}")
    private String number;
    @NotEmpty (message = "{NotEmpty.person.email}")
    @Email (message = "{Email.person.email}")
    private String email;

    public Person() {
    } //konstruktor bez argumentowy

    //konstruktor argumentowy
//    public Person(String name, String lastname, int age, String number, String email) {
//        this.name = name;
//        this.lastname = lastname;
//        this.age = age;
//        this.number = number;
//        this.email = email;
//    }

    private Person(Builder builder) {
        name = builder.name;
        lastname = builder.lastname;
        age = builder.age;
        number = builder.number;
        email = builder.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private String name; // metoda jedno wartosciowa
        private String lastname;
        private int age;
        private String number;
        private String email;

        public Builder(String name) {
            this.name = name;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
