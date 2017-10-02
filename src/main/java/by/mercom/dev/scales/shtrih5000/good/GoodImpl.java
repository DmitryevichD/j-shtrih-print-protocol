package by.mercom.dev.scales.shtrih5000.good;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.config.Config;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;

public class GoodImpl implements Good {
    private Param.GoodCode goodCode;
    private Param.GoodName goodName1;
    private Param.GoodName goodName2;
    private Param.Price goodPrice;
    private Param.GoodShelfLife shelfLife;
    private Param.Tare goodTare;
    private Param.GoodGroupCode goodGroupCode;
    private Param.MsgNumber messageNumber;
    private Param.PictureNumber pictureNumber;
    private Param.Rostest rostest;

    public Param.GoodCode getGoodCode() {
        return goodCode;
    }

    public Param.GoodName getGoodName1() {
        return goodName1;
    }

    public Param.GoodName getGoodName2() {
        return goodName2;
    }

    public Param.Price getGoodPrice() {
        return goodPrice;
    }

    public Param.GoodShelfLife getShelfLife() {
        return shelfLife;
    }

    public Param.Tare getGoodTare() {
        return goodTare;
    }

    public Param.GoodGroupCode getGoodGroupCode() {
        return goodGroupCode;
    }

    public Param.MsgNumber getMessageNumber() {
        return messageNumber;
    }

    public Param.PictureNumber getPictureNumber() {
        return pictureNumber;
    }

    public Param.Rostest getRostest() {
        return rostest;
    }

    public GoodImpl(int goodCode, String goodName, float price) throws IncorrectParamValue {
        this.goodCode = new Param.GoodCode(goodCode);
        if (goodName.length() <= 28) {
            this.goodName1 = new Param.GoodName(goodName);
            this.goodName2 = new Param.GoodName("");
        }else {
            this.goodName1 = new Param.GoodName(goodName.substring(0, 28));
            this.goodName2 = new Param.GoodName(goodName.substring(29));
        }
        int goodprice = Config.getInstance().useCops() ? (int)(price * 100) : (int)price;
        this.goodPrice = new Param.Price(goodprice);
        this.shelfLife = new Param.GoodShelfLife(0);
        this.goodTare = new Param.Tare(0);
        this.goodGroupCode = new Param.GoodGroupCode(0);
        this.messageNumber = new Param.MsgNumber(0);
        this.pictureNumber = new Param.PictureNumber(0);
        this.rostest = new Param.Rostest("");
    }
}
