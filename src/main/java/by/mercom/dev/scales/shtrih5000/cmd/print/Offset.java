package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Работает со смещением печати на этикетки
 */
public class Offset extends ScaleCommand {
    /**
     * Создает комманду для получения текущего значение смещения печати
     * @param pwd Пароль администратора
     */
    public Offset(Param.Password pwd) {
        super(0x46, 5, new Param[]{pwd}, false);
    }

    /**
     * Создает комманду для установки значение смещения печати
     * @param pwd Пароль администратора
     * @param offset Смещение этикетки
     */
    public Offset(Param.Password pwd, Param.Offset offset) {
        super(0x47, 6, new Param[]{pwd, offset}, false);
    }


}
