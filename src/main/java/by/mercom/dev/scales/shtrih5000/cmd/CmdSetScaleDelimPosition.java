package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Запись положения десятичной точки
 */
public class CmdSetScaleDelimPosition extends ScaleCommand{

    /**
     * @param pwd пароль администратора
     * @param delimPos диапазон: отделяет 0..2 знака
     */
    public CmdSetScaleDelimPosition(Param.Password pwd, Param.DelimPos delimPos) {
        super(0x20, 6, new Param[]{pwd, delimPos}, false);
    }
}
