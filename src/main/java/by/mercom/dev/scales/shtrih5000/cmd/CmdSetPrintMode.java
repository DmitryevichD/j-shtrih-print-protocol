package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Команда изменения режима печати
 */
public class CmdSetPrintMode extends ScaleCommand{

    /**
     * @param pwd - Пароль администратора
     * @param printMode Режим печати
     */
    public CmdSetPrintMode(Param.Password pwd, Param.PrintMode printMode) {
        super(0x27, 6, new Param[]{pwd, printMode}, false);
    }
}
