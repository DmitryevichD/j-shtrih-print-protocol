package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать тестовой этикетки.
 * Служит для проверки качества печати.
 */
public class PrintTest extends ScaleCommand {

    /**
     * Создает комманду для печати тестовой этикетки
     * @param pwd Пароль администратора
     */
    public PrintTest(Param.Password pwd) {
        super(0x44, 5, new Param[]{pwd}, true);
    }
}
