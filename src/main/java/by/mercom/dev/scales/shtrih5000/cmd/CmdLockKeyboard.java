package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Производит блокировку или разблокировку клавиатуры
 */
public class CmdLockKeyboard extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     * @param keyLock Признак ключения/отключения блокировки
     */
    public CmdLockKeyboard(Param.Password pwd, Param.KeyLock keyLock) {
        super(0x09, 6, new Param[]{pwd, keyLock}, true);
        setDescription("Блокировка / разблокировка клавиатуры");
    }

}
