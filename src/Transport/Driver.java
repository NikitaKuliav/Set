package Transport;

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

}
