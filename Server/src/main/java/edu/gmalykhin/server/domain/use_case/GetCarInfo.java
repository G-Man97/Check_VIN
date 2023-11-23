package edu.gmalykhin.server.domain.use_case;


import edu.gmalykhin.server.domain.StateVinCheck;
import edu.gmalykhin.server.domain.service.MyService;

public class GetCarInfo {
    private final MyService service;

    public GetCarInfo(MyService service) {
        this.service = service;
    }

    public StateVinCheck get(String vin) {
        return service.getCarInfo(vin);
    }
}
