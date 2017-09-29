package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет печать копии последней напечатанной обычной или итоговой этикетки.
 */
public class PrintCopyLabel extends ScaleCommand {

    /**
     * Создает комманду для печать копии последней этикетки
     * @param pwd
     */
    public PrintCopyLabel(Param.Password pwd) {
        super(0x43, 5, new Param[]{pwd}, true);
    }
}
