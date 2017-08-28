package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Разрешает указанному прием широковещательных команд. После включения весов прием
 * широковещательных команд запрещен, т.е. они будут игнорированы.
 * Очищает в КЭ счетчик полученных команд исчетчик успешно выполненных команд
 */
public class CmdEnableBroadcast extends ScaleCommand {
    /**
     * @param pwd пароль администратора
     */
    public CmdEnableBroadcast(Param.Password pwd) {
        super(0x0A, 5, new Param[]{pwd}, false);
    }
}
