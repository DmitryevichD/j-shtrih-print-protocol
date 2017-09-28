package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Запрашивает из КЭ текущий вес или количество товара, цену, стоимость и тип товара
 * (весовой или штучный). Стоимость считается корректной при выполнении метода без ошибок.
 */
public class CmdGetScaleDisplayData extends ScaleCommand {

    /**
     * @param pwd Пароль
     */
    public CmdGetScaleDisplayData(Param.Password pwd){
        super(0x39, 5, new Param[]{pwd}, false);
    }
}
