package domain;

public class CarInfo {
    private final String globalManufacturer;
    private final String carModel;
    private final String assemblyFactory;
    private final Boolean isVinValidate;
    private final String prodNumber;

    public CarInfo(String globalManufacturer,
                   String carModel,
                   String assemblyFactory,
                   Boolean isVinValidate,
                   String prodNumber
    ) {
        this.globalManufacturer = globalManufacturer;
        this.carModel = carModel;
        this.assemblyFactory = assemblyFactory;
        this.isVinValidate = isVinValidate;
        this.prodNumber = prodNumber;
    }

    public String getResultText() {
        return this.isVinValidate
                ? "VIN is valid.\n" + this
                : "VIN is invalid.\n" + this;
    }

    @Override
    public String toString() {
        return "Manufacturer: " + globalManufacturer + ",\n" +
               "Car model - " + carModel + ",\n" +
               "Assembly factory - " + assemblyFactory + ",\n" +
               "Product production number - " + prodNumber;
    }
}
