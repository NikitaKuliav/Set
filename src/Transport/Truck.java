package Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Truck extends Transport<DriverC> implements Diagnosticable {
    private LoadCapacity loadCapacity;
    private Type type;
    public Truck(String brand,
                 String model,
                 double engineVolume,
                 DriverC driver,
                 LoadCapacity loadCapacity,
                 Type type,
                 int gasTankBar,
                 int oilTankBar,
                 ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, gasTankBar, oilTankBar, mechanics);
        setLoadCapacity(loadCapacity);
    }


    @Override
    public void printType() { if (getloadCapacity() != null) {
        System.out.println(Type.TRUCK);
    } else System.out.println("Данных по транспортному средству недостаточно");
    }

    @Override
    public void startMove() {
        System.out.println("Грузовик марки " + getBrand() + " начал двигаться ");
        decreaseGasAndOil(15,15);
    }

    @Override
    public void finishMove() {
        System.out.println("Грузовик марки " + getBrand() + " закончил двигаться ");
        decreaseGasAndOil(15,15);
    }
    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у грузовика");
        decreaseGasAndOil(15,15);
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 90;
        int maxBound = 140;
        int theBestTimeInMins = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Лучшее время круга для грузовика " + theBestTimeInMins);

    }

    @Override
    public void maxSpeed() {
        int minBound = 90;
        int maxBound = 130;
        int maxSpeed = (int) (minBound + (maxBound - minBound) + Math.random());
        System.out.println("Максимальная скорость для грузовика " + maxSpeed);

    }
    public LoadCapacity getloadCapacity(){
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public Type getType() {
        return Type.TRUCK;
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
        Truck truck = (Truck) o;
        return loadCapacity == truck.loadCapacity && type == truck.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity, type);
    }
}

