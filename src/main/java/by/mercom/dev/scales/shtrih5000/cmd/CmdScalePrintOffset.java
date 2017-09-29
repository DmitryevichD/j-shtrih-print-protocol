package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Получает или установливает смещение печати для этикетки.
 * Единице соответствует смещение в 0.125 мм.
 */
public class CmdScalePrintOffset extends ScaleCommand {
    /**
     * ПолучитьСмещениеПечати
     * @param pwd Пароль администратора
     */
    public CmdScalePrintOffset(Param.Password pwd) {
        super(0x46, 5, new Param[]{pwd}, false);
    }

    /**
     * @param pwd Пароль администратора
     * @param offset Единице соответствует смещение в 0.125 мм.
     */
    public CmdScalePrintOffset(Param.Password pwd, Param.Offset offset) {
        super(0x47, 6, new Param[]{pwd, offset}, false);
    }


}
