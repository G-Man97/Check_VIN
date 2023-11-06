import data.service.MyServiceImpl;
import domain.use_case.GetCarInfo;

public class Test {
    public static void main(String[] args) {

        GetCarInfo carInfo = new GetCarInfo(MyServiceImpl.getInstance());

        System.out.println(carInfo.get("WBACC21060FG30973").getFullInfo() + "\n");

        System.out.println(carInfo.get("WBACC21060FG30972").getFullInfo() + "\n");

        System.out.println(carInfo.get("FKJCC21060FG30973").getFullInfo() + "\n");

        System.out.println(carInfo.get("FKJCC21060FG30972").getFullInfo() + "\n");

//        System.out.println(carInfo.get("WBACC21060FG30973").getCarInfo()
//                /*.getResultText(carInfo.get("WBACC21060FG30973"))*/ + "\n");
//
//        System.out.println(carInfo.get("WBACC21060FG30972").getCarInfo()
//                .getResultText(carInfo.get("WBACC21060FG30972")) + "\n");
//
//        System.out.println(carInfo.get("FKJCC21060FG30973").getCarInfo()
//                .getResultText(carInfo.get("FKJCC21060FG30973")) + "\n");

        /*System.out.println(carInfo.get("WBACC21060FG30973").getCarInfo().getResultText() + "\n");
        System.out.println(carInfo.get("WBACC21060FG30972").getCarInfo().getResultText() + "\n");
        System.out.println(carInfo.get("FKJCC21060FG30973").getCarInfo().getResultText() + "\n");*/
    }
}
