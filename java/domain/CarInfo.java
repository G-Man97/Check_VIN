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

    /*@Deprecated
    public String getResultText(StateVinCheck stateVinCheck) {
        //TODO Временно для тестов
        return stateVinCheck instanceof StateVinCheck.Error
                ? ((StateVinCheck.Error) stateVinCheck).getErrorText() + "\n" + this
                : "VIN-номер валидный.\n" + this;
    }*/

    public String getGlobalManufacturer() {
        return globalManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getAssemblyFactory() {
        return assemblyFactory;
    }

    public Boolean getIsVinValidate() {
        return isVinValidate;
    }

    @Override
    public String toString() {
        return "Изготовитель: " + globalManufacturer + ",\n" +
               "Модель автомобиля: " + carModel + ",\n" +
               "Сборочный завод: " + assemblyFactory + ",\n" +
               "Производственный номер изделия: " + prodNumber;
    }
}
