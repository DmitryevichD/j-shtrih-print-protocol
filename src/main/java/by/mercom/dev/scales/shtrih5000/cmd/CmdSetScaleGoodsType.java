package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Указывает тип текущего товара в КЭ – весовой или штучный
 */
public class CmdSetScaleGoodsType extends ScaleCommand {

    /**
     * @param pwd Пароль
     * @param goodsType Тип товара
     */
    public CmdSetScaleGoodsType(Param.Password pwd, Param.GoodsType goodsType){
        super(0x35, 6, new Param[]{pwd, goodsType}, false);
    }
}
