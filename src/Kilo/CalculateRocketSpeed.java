package Kilo;

public class CalculateRocketSpeed {
    private double weightInKilos;
    private double fuelInKilos;
    private Converter converter;


    public CalculateRocketSpeed(double weightInKilos, double fuelInKilos, Converter converter) {
        this.weightInKilos = weightInKilos;
        this.fuelInKilos = fuelInKilos;
        this.converter = converter;
    }

    public double getSpeed(int time){
       return  4.4 * converter.kiloToPound(weightInKilos) + (converter.kiloToPound(fuelInKilos) * time)
    }
}
