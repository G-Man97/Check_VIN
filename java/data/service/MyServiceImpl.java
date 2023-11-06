package data.service;

import data.repository.MathAlgorithm;
import domain.CarInfo;
import domain.StateVinCheck;
import domain.service.MyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        List<Map<Boolean, String>> resultList = infoAboutIndexFieldsOfCarInfo(vin);

        final int GLOBAL_MANUFACTURER_MAP_INDEX = 0;
        final int CAR_MODEL_MAP_INDEX = 1;
        final int ASSEMBLY_FACTORY_MAP_INDEX = 2;

        final var globalManufacturerMap = resultList.get(GLOBAL_MANUFACTURER_MAP_INDEX);
        final var carModelMap = resultList.get(CAR_MODEL_MAP_INDEX);
        final var assemblyFactoryMap = resultList.get(ASSEMBLY_FACTORY_MAP_INDEX);

        final boolean globalManufacturerFlag = globalManufacturerMap.keySet().iterator().next();
        final boolean carModelFlag = carModelMap.keySet().iterator().next();
        final boolean assemblyFactoryFlag = assemblyFactoryMap.keySet().iterator().next();

        final boolean[] isInfoAboutIndexFieldsOfCarInfoAbsent = {globalManufacturerFlag, carModelFlag
                                                                                        , assemblyFactoryFlag};
        CarInfo carInfo = new CarInfo(
                globalManufacturerMap.values().iterator().next(),
                carModelMap.values().iterator().next(),
                assemblyFactoryMap.values().iterator().next(),
                checkDigit(vin),
                getProdNumber(vin));

        if (carInfo.getIsVinValidate()) {
            if (globalManufacturerFlag || carModelFlag || assemblyFactoryFlag) {
                return new StateVinCheck.Error(carInfo, createErrorText(carInfo.getIsVinValidate()
                        , isInfoAboutIndexFieldsOfCarInfoAbsent));
            } else {
                return new StateVinCheck.Success(carInfo);
            }
        } else {
            return new StateVinCheck.Error(carInfo, createErrorText(carInfo.getIsVinValidate()
                    , isInfoAboutIndexFieldsOfCarInfoAbsent));
        }
    }

    private String getGlobalManufacturerByIndex(String index) {
        return GLOBAL_MANUFACTURER_INDEX.get(index);
    }

    private String getCarModelByIndex(String index) {
        return CAR_MODEL.get(index);
    }

    private String getAssemblyFactoryByIndex(Character index) {
        return ASSEMBLY_FACTORY.get(index);
    }

    private Boolean checkDigit(String vin) {
        return MathAlgorithm.calculate(vin) == Character.digit(vin.charAt(CHECK_DIGIT_INDEX), 10);
    }

    private String getProdNumber(String vin) {
        return vin.substring(PROD_NUMBER_BEGIN_INDEX);
    }

    private List<Map<Boolean, String>> infoAboutIndexFieldsOfCarInfo(String vin) {

        String globalManufacturerTemp = getGlobalManufacturerByIndex(vin
                .substring(MANUFACTURER_BEGIN_INDEX, MANUFACTURER_END_INDEX));
        String carModelTemp = getCarModelByIndex(vin.substring(CAR_MODEL_BEGIN_INDEX, CAR_MODEL_END_INDEX));
        String assemblyFactoryTemp = getAssemblyFactoryByIndex(vin.charAt(ASSEMBLY_FACTORY_INDEX));

        boolean globalManufacturerFlag = false,
                carModelFlag = false,
                assemblyFactoryFlag = false;

        List<Map<Boolean, String>> resultList = new ArrayList<>(3);

        if (globalManufacturerTemp == null) {
            globalManufacturerTemp = "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                    " либо мы не обладаем данными об изготовителе автомобиля";
            globalManufacturerFlag = true;
        }
        if (carModelTemp == null) {
            carModelTemp = "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                    " либо мы не обладаем данными о модели автомобиля";
            carModelFlag = true;
        }
        if (assemblyFactoryTemp == null) {
            assemblyFactoryTemp = "нет информации, возможно, Вы ошиблись при вводе VIN-номера," +
                    " либо мы не обладаем данными о сборочном заводе автомобиля";
            assemblyFactoryFlag = true;
        }

        resultList.add(Collections.singletonMap(globalManufacturerFlag, globalManufacturerTemp));
        resultList.add(Collections.singletonMap(carModelFlag, carModelTemp));
        resultList.add(Collections.singletonMap(assemblyFactoryFlag, assemblyFactoryTemp));

        return resultList;
    }

    private String createErrorText(Boolean isVinValidated, boolean[] isInfoAbsent) {
        if (isVinValidated) {
            return "VIN-номер валидный, но отсутствует некоторая информация\n";
        } else {
            if (isInfoAbsent[0] || isInfoAbsent[1] || isInfoAbsent[2]) {
                return "VIN-номер не валидный и отсутствует некоторая информация\n";
            } else return "VIN-номер не валидный. Проверьте правильность ввода. Если всё верно, " +
                    "это может означать, что VIN-номер не заводской, а перебитый\n";
        }
    }
}
