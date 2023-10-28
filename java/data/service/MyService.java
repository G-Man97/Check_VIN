package data.service;

public interface MyService {

    String getGlobalManufacturerByIndex(String index);

    String getCarModelByIndex(String index);

    String getAssemblyFactoryByIndex(String index);

    int getCheckDigit(String vin);
}
