package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleTareToZero extends ScaleCommand{

    /**
     * Позволяет выбрать текущий вес в качестве тары товара. Выставляет признак тары.
     * @param pwd Пароль администратора
     */
    public CmdSetScaleTareToZero(Param.Password pwd) {
        super(0x31, 5, new Param[]{pwd}, true);
    }
}
