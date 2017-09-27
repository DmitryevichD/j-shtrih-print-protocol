package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleQuantity extends ScaleCommand{

    /**
     * Устанавливает количество для штучного товара.
     * @param pwd Пароль администратора
     * @param quantity Количество
     */
    public CmdSetScaleQuantity(Param.Password pwd, Param.Quantity quantity) {
        super(0x34, 6, new Param[]{pwd, quantity}, false);
    }
}
