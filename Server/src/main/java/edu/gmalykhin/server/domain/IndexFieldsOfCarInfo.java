package edu.gmalykhin.server.domain;

import java.util.Map;

public class IndexFieldsOfCarInfo {
    private final String globalManufacturer;
    private final Boolean isGlobalManufacturerAbsent;
    private final String carModel;
    private final Boolean isCarModelAbsent;
    private final String assemblyFactory;
    private final Boolean isAssemblyFactoryAbsent;

    public IndexFieldsOfCarInfo(Map<Boolean, String> globalManufacturerMap,
                                Map<Boolean, String> carModelMap,
                                Map<Boolean, String> assemblyFactoryMap) {

        this.globalManufacturer = globalManufacturerMap.values().iterator().next();
        this.isGlobalManufacturerAbsent = globalManufacturerMap.keySet().iterator().next();

        this.carModel = carModelMap.values().iterator().next();
        this.isCarModelAbsent = carModelMap.keySet().iterator().next();

        this.assemblyFactory = assemblyFactoryMap.values().iterator().next();
        this.isAssemblyFactoryAbsent = assemblyFactoryMap.keySet().iterator().next();
    }

    public String getGlobalManufacturer() {
        return globalManufacturer;
    }

    public Boolean isGlobalManufacturerAbsent() {
        return isGlobalManufacturerAbsent;
    }

    public String getCarModel() {
        return carModel;
    }

    public Boolean isCarModelAbsent() {
        return isCarModelAbsent;
    }

    public String getAssemblyFactory() {
        return assemblyFactory;
    }

    public Boolean isAssemblyFactoryAbsent() {
        return isAssemblyFactoryAbsent;
    }
}
