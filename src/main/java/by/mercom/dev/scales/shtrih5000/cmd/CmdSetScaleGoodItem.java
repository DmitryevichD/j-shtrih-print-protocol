package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Установить / сбросить товар
 */
public class CmdSetScaleGoodItem extends ScaleCommand {

    /**
     *
     * @param pwd Пароль
     * @param goodItem 0 – сбросить, 1..[Размер таблицы товаров] - установить
     */
    public CmdSetScaleGoodItem(Param.Password pwd, Param.GoodItem goodItem){
        super(0x37, 7, new Param[]{pwd, goodItem}, true);
    }
}
