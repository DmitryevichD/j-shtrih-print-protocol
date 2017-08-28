package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает указанную дату
 */
public class CmdSetScaleDate extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     * @param date дата, которую необходимо установить в весах
     */
    public CmdSetScaleDate(Param.Password pwd, Param.ScaleDate date) {
        super(0x22, 8, new Param[]{pwd, date}, false);
    }
}
