package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Восстановить параметры настройки
 */
public class CmdSetDefault extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     */
    public CmdSetDefault(Param.Password pwd) {
        super(0x17, 5, new  Param[]{pwd}, false);
    }
}
