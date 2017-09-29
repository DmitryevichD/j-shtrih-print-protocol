package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать итоговой этикетки.
 * (сумматор не должен быть пуст и печать итоговой этикетки должна быть разрешена)
 */
public class PrintTotalLabel extends ScaleCommand {

    /**
     * Создает комманду для печати итоговой этикетки
     * @param pwd Пароль администратора
     */
    public PrintTotalLabel(Param.Password pwd) {
        super(0x42, 5, new Param[]{pwd}, true);
    }
}
