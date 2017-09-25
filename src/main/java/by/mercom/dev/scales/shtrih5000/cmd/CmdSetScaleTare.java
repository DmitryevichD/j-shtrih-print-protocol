package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleTare extends ScaleCommand{

    /**
     * Позволяет выбрать текущий вес в качестве тары товара. Выставляет признак тары.
     * @param pwd Пароль администратора
     */
    public CmdSetScaleTare(Param.Password pwd) {
        super(0x31, 5, new Param[]{pwd}, true);
    }

    /**
     * Устанавливает указанный вес, в кг, как вес тары в КЭ. Выставляет признак тары
     * @param pwd Пароль администратора
     */
    public CmdSetScaleTare(Param.Password pwd, Param.Tare tare) {
        super(0x32, 7, new Param[]{pwd, tare}, true);
    }
}
