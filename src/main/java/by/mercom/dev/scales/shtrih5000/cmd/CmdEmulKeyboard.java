package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Эмулирует нажатие клавиши на клавиатуре
 */
public class CmdEmulKeyboard extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     * @param keyCode Код клавиатуры
     */
    public CmdEmulKeyboard(Param.Password pwd, Param.KeyCode keyCode) {
        super(0x08, 6, new Param[]{pwd, keyCode}, true);
        setDescription("Эмуляция клавиатуры");
    }
}
