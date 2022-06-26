package testdata;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockDataForUI {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    Faker faker;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private Date dateOfBirth;

    private String company;
    private String companyAddress1;
    private String companyAddress2;

    private int country;
    private String state;
    private String city;
    private String zipCode;
    private String mobilePhone;

    private String contactSubject;
    private String contactMessage;

    private String checkoutComment;

    private String nameOnCard;
    private String cardNumber;
    private String cvc;
    private String expiryMonth;
    private String expiryYear;

    private String searchProductName;

    private static MockDataForUI mockDataForUI = new MockDataForUI();


    public MockDataForUI() {
        faker = new Faker();
        setUpData();
    }
    private void setAllData(){
        title="Mr.";
        firstName = "AAA";
        lastName = "BBBB";
        email = "a2@gmail.com";
        password = "a1234567";
        dayOfBirth = 1;
        monthOfBirth=1;
        yearOfBirth=2000;
        company ="ABC Inc";
        companyAddress1 = "address 1";
        companyAddress2 = "address 2";
        country=1;
        state = "AB";
        city = "City Name";
        zipCode = "11111";
        mobilePhone="500-222-22-22";
        contactSubject="About your product";
        contactMessage="I found an error/defact in the product";
        checkoutComment = "This is my order.";
        nameOnCard="Test Name On Card";
        cardNumber="1234123412341234";
        cvc="123";
        expiryMonth="11";
        expiryYear="2001";
        searchProductName = "T-Shirt";

    }

    public String getSearchProductName() {
        return searchProductName;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public String getContactSubject() {
        return contactSubject;
    }

    public String getCheckoutComment() {
        return checkoutComment;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public static MockDataForUI getInstance(){
        //MockDataForUI data = new MockDataForUI();
        //data.setAllData();
        //return data;
        return mockDataForUI;
    }
    public static MockDataForUI getStaticInstance(){
        mockDataForUI = new MockDataForUI();
        mockDataForUI.setAllData();
        return mockDataForUI;
    }
    private void setUpData() {
        title = ((int) (Math.random() * 10) / 2 == 0) ? "Mr." : "Mrs.";

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        Date dateOfBirth = faker.date().birthday();
        setUpBirthday(dateOfBirth);
        company = faker.company().name();
        companyAddress1 = faker.address().fullAddress();
        companyAddress2 = faker.address().secondaryAddress();
        country = (int) (Math.random() * 6)+1;
        state = faker.address().state();
        city = faker.address().city();
        zipCode = faker.address().zipCode();
        mobilePhone = faker.phoneNumber().cellPhone();
        checkoutComment = faker.aviation().aircraft();
        nameOnCard= faker.name().firstName();
        cardNumber=faker.finance().creditCard();
        cvc=faker.finance().bic();
        expiryMonth="11";
        expiryYear="2001";
        searchProductName = "T-Shirt";

    }


    private void setUpBirthday(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dayOfBirth = localDate.getDayOfMonth();
        monthOfBirth = localDate.getMonthValue();
        yearOfBirth = localDate.getYear();
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public String getTitle() {
        return title;
    }


    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getCompany() {
        return company;
    }


    public String getCompanyAddress1() {
        return companyAddress1;
    }


    public String getCompanyAddress2() {
        return companyAddress2;
    }


    public int getCountry() {
        return country;
    }


    public String getState() {
        return state;
    }


    public String getCity() {
        return city;
    }


    public String getZipCode() {
        return zipCode;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

}
