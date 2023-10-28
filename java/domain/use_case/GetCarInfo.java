package domain.use_case;

import data.service.MyService;

public class GetCarInfo {
    private final MyService service;
    private String manufacturer;
    private String carModel;
    private String assemblyFactory;
    private String prodNumber;

    public GetCarInfo(MyService service) {
        this.service = service;
    }

    public String get(String vin) {
        this.manufacturer = service.getGlobalManufacturerByIndex(vin.substring(0, 3));
        this.carModel = service.getCarModelByIndex(vin.substring(3, 7));
        this.assemblyFactory = service.getAssemblyFactoryByIndex(vin.substring(10, 11));

        if (service.getCheckDigit(vin) != Character.digit(vin.charAt(8), 10)) {
            throw new RuntimeException("VIN is invalid");
        }

        this.prodNumber = vin.substring(11);
        return this.toString();
    }

    @Override
    public String toString() {
        return "VIN is valid." + "\n" +
                "Manufacturer: " + manufacturer + ",\n" +
                "Car model - " + carModel + ",\n" +
                "Assembly factory - " + assemblyFactory + ",\n" +
                "Product production number - " + prodNumber;
    }
}
