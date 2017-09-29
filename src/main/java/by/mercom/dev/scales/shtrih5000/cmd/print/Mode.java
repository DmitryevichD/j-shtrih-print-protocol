package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Работа с режимом печати
 */
public class Mode extends ScaleCommand{

    /**
     * Создает комманду для установки текущего режима печати
     * @param pwd - Пароль администратора
     * @param printMode Режим печати
     */
    public Mode(Param.Password pwd, Param.PrintMode printMode) {
        super(0x27, 6, new Param[]{pwd, printMode}, false);
    }
}
