package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;

/**
 * Осуществляет печать общего отчета по итогам учета или отчета по номеру ПЛУ.
 */
public class PrintCashReport extends ScaleCommand {

    /**
     * Создает комманду для печати отчета по итогам
     * @param pwd Пароль администратора
     * @param goodItem Номер товара из ПЛУ, если данный параметр инициализирован
     *                 значением 0, тогда печатается общий итог
     */
    public PrintCashReport(Param.Password pwd, Param.GoodItem goodItem) {
        super(0x45, 7, new Param[]{pwd, goodItem}, true);
    }

    /**
     * Создает комманду для печати общего отчета по итогам
     * @param pwd Пароль администратора
     */
    public PrintCashReport(Param.Password pwd) throws IncorrectParamValue {
        super(0x45, 7, new Param[]{pwd, new Param.GoodItem(0)}, true);
    }
}
