package data.service;

import data.repository.AssemblyFactory;
import data.repository.CarModel;
import data.repository.GlobalManufacturerIndex;
import data.repository.MathAlgorithm;
import domain.CarInfo;
import domain.service.MyService;

import java.util.Optional;

public class MyServiceImpl implements MyService {

    private static final MyServiceImpl INSTANCE = new MyServiceImpl();

    private MyServiceImpl() {
    }

    public static MyServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public CarInfo getCarInfo(String vin) {
        return new CarInfo(
                getGlobalManufacturerByIndex(vin.substring(0, 3)),
                getCarModelByIndex(vin.substring(3, 7)),
                getAssemblyFactoryByIndex(vin.substring(10, 11)),
                checkDigit(vin),
                getProdNumber(vin));
    }

    private String getGlobalManufacturerByIndex(String index) {
        return Optional.ofNullable(GlobalManufacturerIndex.GLOBAL_MANUFACTURER_INDEX.get(index))
                .orElseThrow(() -> new RuntimeException("No such global manufacture index"));
    }

    private String getCarModelByIndex(String index) {
        return Optional.ofNullable(CarModel.CAR_MODEL.get(index))
                .orElseThrow(() -> new RuntimeException("No such car model"));
    }


    private String getAssemblyFactoryByIndex(String index) {
        return Optional.ofNullable(AssemblyFactory.ASSEMBLY_FACTORY.get(index))
                .orElseThrow(() -> new RuntimeException("No such assembly factory"));
    }

    private Boolean checkDigit(String vin) {
        return MathAlgorithm.calculate(vin) != Character.digit(vin.charAt(8), 10);
    }

    private String getProdNumber(String vin) {
        return vin.substring(11);
    }

}
