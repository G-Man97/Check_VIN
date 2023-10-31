package domain;

public sealed class StateVinCheck {
    private final CarInfo carInfo;

    public StateVinCheck(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public static final class Success extends StateVinCheck {
        public Success(CarInfo carInfo) {
            super(carInfo);
        }
    }

    public static final class Error extends StateVinCheck {
        private final String errorText;

        public Error(CarInfo carInfo, String errorText) {
            super(carInfo);
            this.errorText = errorText;
        }

        public String getErrorText() {
            return errorText;
        }
    }
}
