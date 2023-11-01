package data.service;

import data.repository.MathAlgorithm;
import domain.CarInfo;
import domain.StateVinCheck;
import domain.service.MyService;

import java.util.Optional;

import static data.repository.AssemblyFactory.ASSEMBLY_FACTORY;
import static data.repository.CarModel.CAR_MODEL;
import static data.repository.GlobalManufacturerIndex.GLOBAL_MANUFACTURER_INDEX;

public class MyServiceImpl implements MyService {

    private static final MyServiceImpl INSTANCE = new MyServiceImpl();
    private static final int MANUFACTURER_BEGIN_INDEX = 0;
    private static final int MANUFACTURER_END_INDEX = 3;
    private static final int CAR_MODEL_BEGIN_INDEX = 3;
    private static final int CAR_MODEL_END_INDEX = 7;
    private static final int ASSEMBLY_FACTORY_INDEX = 10;
    private static final int CHECK_DIGIT_INDEX = 8;
    private static final int PROD_NUMBER_BEGIN_INDEX = 11;

    private MyServiceImpl() {
    }

    public static MyServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public StateVinCheck getCarInfo(String vin) {
        CarInfo carInfo = new CarInfo(
                getGlobalManufacturerByIndex(vin.substring(MANUFACTURER_BEGIN_INDEX, MANUFACTURER_END_INDEX)),
                getCarModelByIndex(vin.substring(CAR_MODEL_BEGIN_INDEX, CAR_MODEL_END_INDEX)),
                getAssemblyFactoryByIndex(vin.charAt(ASSEMBLY_FACTORY_INDEX)),
                checkDigit(vin),
                getProdNumber(vin));
        if (carInfo.getIsVinValidate()) {
            if (carInfo.getGlobalManufacturer().startsWith("нет информации")
                    || carInfo.getCarModel().startsWith("нет информации")
                    || carInfo.getAssemblyFactory().startsWith("нет информации")) {
                return new StateVinCheck.Error(carInfo, createErrorText(carInfo.getIsVinValidate()));
            } else {
                return new StateVinCheck.Success(carInfo);
            }
        } else {
            return new StateVinCheck.Error(carInfo, createErrorText(carInfo.getIsVinValidate()));
        }
    }

    private String getGlobalManufacturerByIndex(String index) {
        return Optional.ofNullable(GLOBAL_MANUFACTURER_INDEX.get(index))
                .orElse("нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными об изготовителе автомобиля");
    }

    private String getCarModelByIndex(String index) {
        return Optional.ofNullable(CAR_MODEL.get(index))
                .orElse("нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными о модели автомобиля");
    }

    private String getAssemblyFactoryByIndex(Character index) {
        return Optional.ofNullable(ASSEMBLY_FACTORY.get(index))
                .orElse("нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными о сборочном заводе автомобиля");
    }

    private Boolean checkDigit(String vin) {
        return MathAlgorithm.calculate(vin) == Character.digit(vin.charAt(CHECK_DIGIT_INDEX), 10);
    }

    private String getProdNumber(String vin) {
        return vin.substring(PROD_NUMBER_BEGIN_INDEX);
    }

    private String createErrorText(Boolean isVinValidated) {
        //TODO надо придумать вменяемый текст
        return isVinValidated
                ? "VIN-номер валидный, но отсутствует некоторая информация"
                : "VIN-номер не валидный. Проверьте правильность ввода. Если всё верно, " +
                "это может означать, что VIN-номер не заводской, а перебитый";
    }
}
