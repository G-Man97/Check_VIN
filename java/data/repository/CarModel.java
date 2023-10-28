package data.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarModel {
    public static final Map<String, String> CAR_MODEL;

    static {
        Map<String, String> tempMap = new TreeMap<>();
        tempMap.put("AA51", "330i / 330Xi E46 (2000-2005)");
        tempMap.put("AAL9", "330 Xd E46 (2000-2005)");
        tempMap.put("AAN3", "325i E46 (2000-2005)");
        tempMap.put("AAP9", "330 Xd E46 (2000-2005)");
        tempMap.put("AAV1", "320i E46 (2000-2005)");
        tempMap.put("AAV3", "325i touring E46/3 (1999-2001)");
        tempMap.put("AAW1", "320i touring E46/3 (2001-2003)");
        tempMap.put("AAW3", "325i touring E46/3 (2003-2005)");
        tempMap.put("ABN1", "320 Ci E46 (2000-2005)");
        tempMap.put("ABN3", "325 Ci E46 (2000-2005)");
        tempMap.put("ABS1", "320 Ci Cabrio E46/2C (2000-2007)");
        tempMap.put("ABS3", "325 Ci Cabrio E46/2C (2000-2007)");
        tempMap.put("ADL7", "530D E39 (2000-2003)");
        tempMap.put("ADP7", "530D Touring E39/2 (2000-2004)");
        tempMap.put("ADS1", "520i Touring E39/2 (2000-2004)");
        tempMap.put("ADS3", "525i Touring E39/2 (2000-2004)");
        tempMap.put("ADS5", "530i Touring E39/2 (2000-2004)");
        tempMap.put("ADT1", "520i E39 (2000-2003)");
        tempMap.put("ADT3", "525i E39 (2000-2003)");
        tempMap.put("ADT5", "530i E39 (2000-2003)");
        tempMap.put("AL11", "316i E46 (1998-2001)");
        tempMap.put("AL31", "318i E46 (1998-2001)");
        tempMap.put("AL71", "320d E46 (1998-2001)");
        tempMap.put("AM11", "320i E46 (1998-2000)");
        tempMap.put("AM31", "323i E46 (1998-2000)");
        tempMap.put("AM51", "328i E46 (1998-2000)");
        tempMap.put("AM52", "328i E46 (1998-2000)");
        tempMap.put("AP31", "318i Touring E46 (1999-2001)");
        tempMap.put("AR11", "320i Touring E46 (1999-2001)");
        tempMap.put("AR51", "328i Touring E46 (1999-2001)");
        tempMap.put("AS71", "316i Limousine E46 (2001-2005)");
        tempMap.put("AW51", "330i touring E46 (2001-2005)");
        tempMap.put("AX71", "320d Touring E46 (1999-2001)");
        tempMap.put("BA46", "Alpina B10 V8 E39/2 (1999-2000)");
        tempMap.put("BJ31", "320i Cabrio E36 (1993-2000)");
        tempMap.put("BJ41", "320i A Cabrio E36 (1993-2000)");
        tempMap.put("BJ61", "325i A Cabrio E36 (1993-2000)");
        tempMap.put("BK71", "328i Cabrio E36 (1995-2000)");
        tempMap.put("BK81", "328i A Cabrio E36 (1995-2000)");
        tempMap.put("BM11", "320 Ci E46 (1998-2001)");
        tempMap.put("BM31", "323 Ci E46 (1998-2001)");
        tempMap.put("BM51", "328 Ci E46 (1998-2001)");
        tempMap.put("BM52", "328 Ci E46 (1998-2001)");
        tempMap.put("BN51", "330 Ci E46 (2001-2005)");
        tempMap.put("BS51", "330 Ci Cabrio E46 (2000-2007)");
        tempMap.put("CC21", "325td A E36 (1991-1998)");
        tempMap.put("CH31", "Z3 2.8 Roadster E36/7 (1999-2000)");
        tempMap.put("CJ51", "318tds Compact E36/5 (1995-2000)");
        tempMap.put("CK51", "Z3 2.8 Coupe R/C (1998-2000)");
        tempMap.put("CK71", "Z3 3.0 Coupe R/C (2000-2002)");
        tempMap.put("CL31", "Z3 2.0 Roadster E36/7 (1999-2002)");
        tempMap.put("CN51", "Z3 3.0 Roadster E36/7 (2000-2002)");
        tempMap.put("CS11", "316i compact E36/5 (1993-2000)");
        tempMap.put("CS21", "316i A compact E36/5 (1993-2000)");
        tempMap.put("CT31", "323 Ti compact E36/5 (1993-2000)");
        tempMap.put("CT41", "323 Ti A compact E36/5 (1993-2000)");
        tempMap.put("DE91", "M5 E39 (1998-2000)");
        tempMap.put("DF71", "525tds E39 (1995-2000)");
        tempMap.put("DF81", "525tds A E39 (1995-2000)");
        tempMap.put("DG51", "525tds Touring E39/2 (1997-2000)");
        tempMap.put("DG71", "525tds Touring E39/2 (1997-2000)");
        tempMap.put("DL71", "530D Limousine E39 (2000-2003)");
        tempMap.put("DL91", "525D E39 (2000-2003)");
        tempMap.put("DM11", "520i E39 (1999-2000)");
        tempMap.put("DM21", "520i A E39 (1999-2000)");
        tempMap.put("DM31", "523i E39 (1999-2000)");
        tempMap.put("DM41", "523i A E39 (1999-2000)");
        tempMap.put("DM51", "528i E39 (1999-2000)");
        tempMap.put("DM61", "528i A E39 (1999-2000)");
        tempMap.put("DM71", "520D E39 (2000-2003)");
        tempMap.put("DN11", "535i E39 (1999-2000)");
        tempMap.put("DN21", "535i A E39 (1999-2000)");
        tempMap.put("DN51", "540i E39 (1999-2000)");
        tempMap.put("DN61", "540i E39 (1999-2000)");
        tempMap.put("DN81", "540i A E39 (1999-2000)");
        tempMap.put("DP28", "528i Touring E39/2 (1999-2000)");
        tempMap.put("DP91", "525D Touring E39/2 (2000-2004)");
        tempMap.put("DR11", "520i Touring E39/2 (1999-2000)");
        tempMap.put("DR21", "520i A Touring E39/2 (1999-2000)");
        tempMap.put("DR31", "523i Touring E39/2 (1999-2000)");
        tempMap.put("DR41", "523i A Touring E39/2 (1999-2000)");
        tempMap.put("DR51", "540i Touring E39/2 (1999-2000)");
        tempMap.put("DR61", "540i A Touring E39/2 (1999-2000)");
        tempMap.put("DR71", "520D Touring E39/2 (2000-2004)");
        tempMap.put("DT31", "525i Limousine E39 (2000-2003)");
        tempMap.put("EJ11", "Z8 4.9 (2000-2003)");
        tempMap.put("EU51", "318D Limousine E46/4 (1998-2005)");
        tempMap.put("FA71", "X5 E53 (1999-2003)");
        tempMap.put("FB71", "X5 E53 (2003-2006)");
        tempMap.put("GE31", "728i E38 (1998-2001)");
        tempMap.put("GE42", "728i A E38 (1998-2001)");
        tempMap.put("GE61", "730d Limousine E38 (1998-2001)");
        tempMap.put("GE81", "740d E38 (1999-2001)");
        tempMap.put("GF11", "730i (1994-2000)");
        tempMap.put("GF51", "740i (1994-2000)");
        tempMap.put("GG01", "750i E38 (1998-2001)");
        tempMap.put("GG41", "735i E38 (1998-2001)");
        tempMap.put("GG81", "740i E38 (1998-2001)");
        tempMap.put("GH01", "740iL Protection E38 (1999-2001)");
        tempMap.put("GH41", "728iA / 728iL E38 (1998-2001)");
        tempMap.put("GH61", "735iL E38 (1998-2001)");
        tempMap.put("GH81", "740iL E38 (1998-2001)");
        tempMap.put("GJ01", "750iL E38 (1998-2001)");
        tempMap.put("GK81", "750iXL E38 (1998-2001)");
        tempMap.put("GK91", "750iL Protection E38 (1999-2001)");
        tempMap.put("HM21", "730D Limousine E65 (2001-2005)");
        tempMap.put("NJ71", "530D Touring E61 (2004-2007)");
        tempMap.put("NX51", "525D Limousine E60LCI (2007-2010)");
        tempMap.put("SBL9", "M3 E46 (2000-2006)");
        tempMap.put("VU31", "320D Touring E91 (2005-2008)");

        CAR_MODEL = Collections.unmodifiableMap(tempMap);
    }
}