package domain.use_case;

import domain.service.MyService;

public class GetCarInfo {
    private final MyService service;

    public GetCarInfo(MyService service) {
        this.service = service;
    }

    public String get(String vin) {
        return service.getCarInfo(vin).getResultText();
    }
}
