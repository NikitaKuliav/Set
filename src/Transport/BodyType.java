package Transport;

public enum BodyType {
    SEDAN("Седан"),
    HATCHBACK("Хэтчбэк"),
    COUPE("Купе"),
    UNIVERSAL("Универсал"),
    SUV("Внедорожник"),
    CROSSOVER("Кроссовер"),
    PICKUP("Пикап"),
    VAN("Микроавтобус"),
    MINIVAN("Микроавтобус");

    private String description;
    BodyType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        if (this.description == null) {
            System.out.println("Данных недостаточно");
        }
        return "Тип кузова: " + this.description;
    }
}
