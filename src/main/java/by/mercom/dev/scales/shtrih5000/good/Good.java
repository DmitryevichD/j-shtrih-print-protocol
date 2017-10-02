package by.mercom.dev.scales.shtrih5000.good;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;

public interface Good {
    Param.GoodCode getGoodCode();
    Param.GoodName getGoodName1();
    Param.GoodName getGoodName2();
    Param.Price getGoodPrice();
    Param.GoodShelfLife getShelfLife();
    Param.Tare getGoodTare();
    Param.GoodGroupCode getGoodGroupCode();
    Param.MsgNumber getMessageNumber();
    Param.PictureNumber getPictureNumber();
    Param.Rostest getRostest();
}
