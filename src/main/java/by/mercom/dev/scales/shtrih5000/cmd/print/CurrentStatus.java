package by.mercom.dev.scales.shtrih5000.cmd.print;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

public class CurrentStatus extends ScaleCommand {

    /**
     * Создает комманду для получения состояние=я печатающего устройства, которое сообщает:
     * наличие бумаги;
     * наличие отпечатанной этикетки;
     * спозиционированность следующей этикетки;
     * возможность печати;
     * копии этикетки;
     * и пр.
     */
    public CurrentStatus(Param.Password pwd) {
        super(0x4A, 5, new Param[]{pwd}, false);
    }

}
