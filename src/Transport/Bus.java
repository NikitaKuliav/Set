package Transport;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Bus extends Transport<DriverD> implements Diagnosticable {
    private Size size;
    private Type type;

    public Bus(String brand,
               String model,
               double engineVolume,
               DriverD driver,
               Size size,
               Type type,
               int gasTankBar,
               int oilTankBar,
               ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, gasTankBar, oilTankBar, mechanics);
        setSize(size);
    }

    @Override
    public void printType() {
        if (getSize() != null) {
            System.out.println(Type.BUS);
        } else System.out.println("Данных по транспортному средству недостаточно");

    }

    @Override
    public void startMove() {
        System.out.println("Автобус марки " + getBrand() + " начал двигаться ");
        decreaseGasAndOil(15, 15);
    }

    @Override
    public void finishMove() {
        System.out.println("Автобус марки " + getBrand() + " закончил двигаться ");
        decreaseGasAndOil(15, 15);
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у автобуса");
        decreaseGasAndOil(15, 15);
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 100;
        int maxBound = 150;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Лучшее время круга для автобуса " + theBestTimeInMins);

    }

    @Override
    public void maxSpeed() {
        int minBound = 80;
        int maxBound = 120;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для автобуса " + maxSpeed);

    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Type getType() {
        return Type.BUS;
    }

    @Override
    public void passDiagnostic() throws DiagnosticNotAllowedException {
        Random rnd = new Random();
        int r = rnd.nextInt(100);
        if (r <= 10) {
            throw new DiagnosticNotAllowedException();
        } else System.out.println("Диагностика пройдена успешно");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return size == bus.size && type == bus.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, type);
    }
}