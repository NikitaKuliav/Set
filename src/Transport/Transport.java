package Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Transport<T extends Driver> implements Competing {
    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;
    private int gasTankBar;
    private int oilTankBar;
    private List<Mechanic> mechanics;

    public Transport(String brand,
                     String model,
                     double engineVolume,
                     T driver,
                     int gasTankBar,
                     int oilTankBar,
                     ArrayList<Mechanic> mechanics) {
        if (brand == null || brand.equals("")) {
            brand = "default";
        }
        this.brand = brand;
        if (model == null || model.equals("")) {
            model = "default";
        }
        this.model = model;
        setEngineVolume(engineVolume);
        setDriver(driver);
        setGasTankBar(gasTankBar);
        setOilTankBar(oilTankBar);
        this.mechanics = mechanics;

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public double getEngineVolume() {
        return engineVolume;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }
    public String getMechanicName(int index) {
        Mechanic mechanic = mechanics.get(index);

        return mechanic.getNameSurname();
    }
    public String getDriverName(){
        return driver.getName();
    }
    public void getMechanicsAndDriver(){
        System.out.println("Список механиков: " + getMechanics());
        System.out.println("Имя водителя: " + getDriverName());

    }
    public String getMechanicFirm(int index) {
        Mechanic mechanic = mechanics.get(index);
        return mechanic.getFirm();
    }
    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            engineVolume = 1.6;
        }
        this.engineVolume = engineVolume;
    }

    public void setGasTankBar(int gasTankBar) {
        if (gasTankBar == 0) {
            gasTankBar = 100;
        }
        this.gasTankBar = gasTankBar;
    }

    public void setOilTankBar(int oilTankBar) {
        if (oilTankBar == 0) {
            oilTankBar = 100;
        }
        this.oilTankBar = oilTankBar;
    }


    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public abstract void printType();

    public abstract void startMove();

    public abstract void finishMove();

    public abstract Type getType();

    public void addGas(int gas){
        setGasTankBar(100);
        System.out.println("Транспорт " + Transport.this + " заправлен до полного бака");

    }

    public void addOil(int oil){
        setOilTankBar(100);
        System.out.println("В транспорт " + Transport.this + " залито масло");
    }

    public void decreaseGasAndOil(int gas, int oil) {
        this.gasTankBar -= gas;
        this.oilTankBar -= oil;
    }

    public int getGasTankBar() {
        return gasTankBar;
    }

    public int getOilTankBar() {
        return oilTankBar;
    }

    public void turnOnEngine(Transport object) throws EmptyGasTankException, NoOilException {

        if (object.getGasTankBar() > 0 && object.getOilTankBar() > 0) {
            System.out.println("Двигатель заведён");
        } else if (object.getGasTankBar() <= 0) {
            throw new EmptyGasTankException("Нет топлива");
        } else {
            throw new NoOilException("Недостаточно масла");
        }
    }




    @Override
    public String toString() {
        return
                "марка='" + brand + '\'' +
                        ", модель='" + model + '\'' +
                        ", объем двигателя=" + engineVolume;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && gasTankBar == transport.gasTankBar && oilTankBar == transport.oilTankBar && brand.equals(transport.brand) && model.equals(transport.model) && driver.equals(transport.driver) && mechanics.equals(transport.mechanics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver, gasTankBar, oilTankBar, mechanics);
    }
}
