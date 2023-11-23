package edu.gmalykhin.server.domain.service;


import edu.gmalykhin.server.domain.StateVinCheck;

public interface MyService {
    StateVinCheck getCarInfo(String vin);
}
