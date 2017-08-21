package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdLockKeyboard extends ScaleCommand {

    public CmdLockKeyboard(Param.Password pwd, Param.KeyLock keyLock) {
        super(0x09, 6, new Param[]{pwd, keyLock}, false);
        setDescription("Блокировка / разблокировка клавиатуры");
    }

}
