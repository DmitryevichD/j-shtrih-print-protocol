package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdSetScaleZero extends ScaleCommand{

    /**
     * Обнуляет показания массы и выставляет признак текущего автонуля.
     * Платформа КЭ должна быть при этом пуста
     * @param pwd Пароль администратора
     */
    public CmdSetScaleZero(Param.Password pwd) {
        super(0x30, 5, new Param[]{pwd}, true);
    }
}
