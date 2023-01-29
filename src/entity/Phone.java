package entity;

public class Phone {
    private final String phoneNumber;

    public Phone(String numbers) {
        this.phoneNumber = numbers;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
