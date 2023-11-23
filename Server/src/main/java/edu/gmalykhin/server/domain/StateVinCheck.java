package edu.gmalykhin.server.domain;

public sealed class StateVinCheck {
    protected final CarInfo carInfo;

    protected final String massageText;

    private StateVinCheck(CarInfo carInfo, String massageText) {
        this.carInfo = carInfo;
        this.massageText = massageText;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public String getMassageText() {
        return massageText;
    }

    public String getFullInfo() {
        return massageText + carInfo;
    }

    public static final class Success extends StateVinCheck {
        private static final String SUCCESS_TEXT = "VIN-номер валидный\n";
        public Success(CarInfo carInfo) {
            super(carInfo, SUCCESS_TEXT);
        }
    }

    public static final class Error extends StateVinCheck {

        public Error(CarInfo carInfo, String errorText) {
            super(carInfo, errorText);
        }

    }
}
