package data.service;

import data.repository.*;

import java.util.Optional;

public class MyServiceImpl implements MyService {

    private static final MyServiceImpl INSTANCE = new MyServiceImpl();

    private MyServiceImpl() {
    }

    public static MyServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getGlobalManufacturerByIndex(String index) {
        return Optional.ofNullable(GlobalManufacturerIndex.GLOBAL_MANUFACTURER_INDEX.get(index))
                .orElseThrow(() -> new RuntimeException("No such global manufacture index"));
    }

    @Override
    public String getCarModelByIndex(String index) {
        return Optional.ofNullable(CarModel.CAR_MODEL.get(index))
                .orElseThrow(() -> new RuntimeException("No such car model"));
    }

    @Override
    public String getAssemblyFactoryByIndex(String index) {
        return Optional.ofNullable(AssemblyFactory.ASSEMBLY_FACTORY.get(index))
                .orElseThrow(() -> new RuntimeException("No such assembly factory"));
    }

    @Override
    public int getCheckDigit(String vin) {
        return MathAlgorithm.calculate(vin);
    }

}
