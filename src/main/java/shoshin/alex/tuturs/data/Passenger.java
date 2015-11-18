package shoshin.alex.tuturs.data;

import java.util.Calendar;

public class Passenger {
    private String name;
    private String surname;
    private String patronymic;
    private Calendar birthDate;
    
    public Passenger() {
        
    }
    
    public Passenger(String name, String surname, String patronymic, Calendar birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        return name + " " + surname;
    }
}