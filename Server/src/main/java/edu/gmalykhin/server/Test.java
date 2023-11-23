package edu.gmalykhin.server;


import edu.gmalykhin.server.data.service.MyServiceImpl;
import edu.gmalykhin.server.domain.use_case.GetCarInfo;

public class Test {
    public static void main(String[] args) {

        GetCarInfo carInfo = new GetCarInfo(MyServiceImpl.getInstance());

        System.out.println(carInfo.get("WBACC21060FG30973").getFullInfo() + "\n");

        System.out.println(carInfo.get("WBACC21060FG30972").getFullInfo() + "\n");

        System.out.println(carInfo.get("FKJCC21060FG30973").getFullInfo() + "\n");

        System.out.println(carInfo.get("FKJCC21060FG30972").getFullInfo() + "\n");
    }
}
