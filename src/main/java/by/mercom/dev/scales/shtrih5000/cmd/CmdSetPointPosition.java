package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Устанавливает положение десятичной точки
 */
public class CmdSetPointPosition extends ScaleCommand{

    /**
     * @param pwd пароль администратора
     * @param delimPos диапазон: отделяет 0..2 знака
     */
    public CmdSetPointPosition(Param.Password pwd, Param.DelimPos delimPos) {
        super(0x20, 6, new Param[]{pwd, delimPos}, false);
    }
}
