package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;

/**
 * Осуществляет печать общего отчета по итогам учета или отчета по номеру ПЛУ.
 */
public class CmdScalePrintCashReport extends ScaleCommand {

    /**
     * @param pwd Пароль администратора
     * @param goodItem 0 - Общий отчет по всем ПЛУ,
     *                 1..[Размер таблицы товаров] – по конкретному ПЛУ из указанного диапазона
     */
    public CmdScalePrintCashReport(Param.Password pwd, Param.GoodItem goodItem) {
        super(0x45, 7, new Param[]{pwd, goodItem}, true);
    }

    /**
     * Общий отчет по всем ПЛУ
     * @param pwd Пароль администратора
     */
    public CmdScalePrintCashReport(Param.Password pwd) throws IncorrectParamValue {
        super(0x45, 7, new Param[]{pwd, new Param.GoodItem(0)}, true);
    }
}
