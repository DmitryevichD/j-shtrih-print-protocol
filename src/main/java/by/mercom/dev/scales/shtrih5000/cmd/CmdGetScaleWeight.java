package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdGetScaleWeight extends ScaleCommand {
    /**
     * Запрашивает из КЭ текущий вес, в кг. Вес будет возвращен, если он успокоен и фиксирован,
     * т.е. находится в диапазоне от НмПВ до НПВ. Если тип товара в КЭ – штучный, то будет
     * возвращена ошибка «Команда не реализуется в данном режиме».
     */
    public CmdGetScaleWeight(Param.Password pwd) {
        super(0x38, 5, new Param[]{pwd}, false);
    }

}
