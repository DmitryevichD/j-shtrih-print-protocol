package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CmdGetScalePrinterStatus extends ScaleCommand {
    /**
     * Получает состояние печатающего устройства, которое сообщает о наличии бумаги,
     * отпечатанной этикетки, спозиционированности следующей этикетки, возможности печати
     * копии этикетки и пр.
     */
    public CmdGetScalePrinterStatus(Param.Password pwd) {
        super(0x4A, 5, new Param[]{pwd}, false);
    }

}
