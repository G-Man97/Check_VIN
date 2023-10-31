import data.service.MyServiceImpl;
import domain.use_case.GetCarInfo;

public class Test {
    public static void main(String[] args) {
        GetCarInfo carInfo = new GetCarInfo(MyServiceImpl.getInstance());
        System.out.println(carInfo.get("WBACC21060FG30973") + "\n");
        System.out.println(carInfo.get("WBACC21060FG30972"));
    }
}
