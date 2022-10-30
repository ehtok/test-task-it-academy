package by.roman.test.enumerate;

public enum Role {
    ADMIN("Администратор"),
    SALE_USER("Покупатель"),
    CUSTOMER_USER("Продавец"),
    SECURE_API_USER("Secure API User");


    private final String value;


    Role(String name) {
        this.value = name;
    }

}
