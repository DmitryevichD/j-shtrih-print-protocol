package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает указанное время
 */
public class CmdSetScaleTime extends ScaleCommand {

    /**
     *
     * @param pwd пароль администратора
     * @param time время, которое будет установлено в весах
     */
    public CmdSetScaleTime(Param.Password pwd, Param.ScaleTime time) {
        super(0x21, 8, new Param[]{pwd, time}, false);
    }
}
