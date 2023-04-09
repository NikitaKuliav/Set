package Transport;

import java.util.Objects;

public abstract class Driver {

    private String name;
    private boolean hasDriverLicense;
    private int experienceInYears;

    public Driver(String name, boolean hasDriverLicense, int experienceInYears) {
        this.name = name;
        this.hasDriverLicense = hasDriverLicense;
        this.experienceInYears = experienceInYears;
    }

    public abstract void startMove();
    public abstract void finishMove();
    public abstract void refill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    @Override
    public String toString() {
        return "Водитель " + name +
                ", Есть ли у него водительские права= " + hasDriverLicense +
                ", Стаж вождения= " + experienceInYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return hasDriverLicense == driver.hasDriverLicense && experienceInYears == driver.experienceInYears && name.equals(driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasDriverLicense, experienceInYears);
    }
}
