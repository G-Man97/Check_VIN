package data.service;

import data.repository.DataAbout;
import data.repository.MathAlgorithm;
import domain.CarInfo;
import domain.IndexFieldsOfCarInfo;
import domain.StateVinCheck;
import domain.service.MyService;

import java.util.Collections;
import java.util.Map;

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

        var indexFieldsOfCarInfo = new IndexFieldsOfCarInfo(
                getDataByIndex(vin, DataAbout.GLOBAL_MANUFACTURER),
                getDataByIndex(vin, DataAbout.CAR_MODEL),
                getDataByIndex(vin, DataAbout.ASSEMBLY_FACTORY));

        boolean isIndexFieldsInfoAbsent = indexFieldsOfCarInfo.isGlobalManufacturerAbsent()
                || indexFieldsOfCarInfo.isCarModelAbsent()
                || indexFieldsOfCarInfo.isAssemblyFactoryAbsent();

        CarInfo carInfo = new CarInfo(
                indexFieldsOfCarInfo.getGlobalManufacturer(),
                indexFieldsOfCarInfo.getCarModel(),
                indexFieldsOfCarInfo.getAssemblyFactory(),
                checkDigit(vin),
                getProdNumber(vin));

        if (carInfo.getIsVinValidate()) {
            if (isIndexFieldsInfoAbsent) {
                return new StateVinCheck.Error(carInfo,
                        createErrorText(carInfo.getIsVinValidate(), true));
            } else {
                return new StateVinCheck.Success(carInfo);
            }
        } else {
            return new StateVinCheck.Error(carInfo, createErrorText(carInfo.getIsVinValidate()
                    , isIndexFieldsInfoAbsent));
        }
    }

    private Map<Boolean, String> getDataByIndex(String vin, DataAbout dataAbout) {

        boolean isResultAbsent = false;

        String result = switch (dataAbout) {
            case GLOBAL_MANUFACTURER ->
                    GLOBAL_MANUFACTURER_INDEX.get(vin.substring(MANUFACTURER_BEGIN_INDEX, MANUFACTURER_END_INDEX));
            case CAR_MODEL -> CAR_MODEL.get(vin.substring(CAR_MODEL_BEGIN_INDEX, CAR_MODEL_END_INDEX));
            case ASSEMBLY_FACTORY -> ASSEMBLY_FACTORY.get(vin.charAt(ASSEMBLY_FACTORY_INDEX));
        };

        if (result == null) {
            result = switch (dataAbout) {
                case GLOBAL_MANUFACTURER -> "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными об изготовителе автомобиля";
                case CAR_MODEL -> "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными о модели автомобиля";
                case ASSEMBLY_FACTORY -> "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                        " либо мы не обладаем данными о сборочном заводе автомобиля";
            };
            isResultAbsent = true;
        }
        return Collections.singletonMap(isResultAbsent, result);
    }

    private Boolean checkDigit(String vin) {
        return MathAlgorithm.calculate(vin) == Character.digit(vin.charAt(CHECK_DIGIT_INDEX), 10);
    }

    private String getProdNumber(String vin) {
        return vin.substring(PROD_NUMBER_BEGIN_INDEX);
    }

    private String createErrorText(Boolean isVinValidated, boolean isIndexFieldsInfoAbsent) {
        if (isVinValidated) {
            return "VIN-номер валидный, но отсутствует некоторая информация\n";
        } else {
            if (isIndexFieldsInfoAbsent) {
                return "VIN-номер не валидный и отсутствует некоторая информация\n";
            } else return "VIN-номер не валидный. Проверьте правильность ввода. Если всё верно, " +
                    "это может означать, что VIN-номер не заводской, а перебитый\n";
        }
    }
}
