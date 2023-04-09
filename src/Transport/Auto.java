package Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Auto extends Transport<DriverB> implements Diagnosticable {
    private BodyType bodyType;
    private Type type;
    public Auto(String brand,
                String model,
                double engineVolume,
                DriverB driver,
                BodyType bodyType,
                Type type,
                int gasTankBar,
                int oilTankBar,
                ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, gasTankBar, oilTankBar, mechanics);
        setBodyType(bodyType);
    }

    @Override
    public void printType() { if (getBodyType() != null) {
        System.out.println(Type.CAR);
    } else System.out.println("Данных по транспортному средству недостаточно");
    }
    @Override
    public void startMove() {
        System.out.println("Автомобиль марки " + getBrand() + " начал двигаться ");
        decreaseGasAndOil(10,10);
    }

    @Override
    public void finishMove() {
        System.out.println("Автомобиль марки " + getBrand() + " закончил двигаться ");
        decreaseGasAndOil(10,10);
    }
    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у автомобиля");
        decreaseGasAndOil(10,10);
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 70;
        int maxBound = 120;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Лучшее время круга для автомобиля в минутах " + theBestTimeInMins);

    }

    @Override
    public void maxSpeed() {
        int minBound = 100;
        int maxBound = 160;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для автомобиля " + maxSpeed);

    }
    public BodyType getBodyType(){
        return bodyType;
    }
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void passDiagnostic(){
        System.out.println("Диагностика пройдена успешно");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Auto auto = (Auto) o;
        return bodyType == auto.bodyType && type == auto.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType, type);
    }
}
