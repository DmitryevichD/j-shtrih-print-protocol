package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Осуществляет промотку бумаги с поиском начала следующей этикетки или без поиска,
 * в зависимости от настройки типа печати КЭ.
 */
public class CmdScaleFeedDocument extends ScaleCommand {
    public CmdScaleFeedDocument(Param.Password pwd) {
        super(0x40, 5, new Param[]{pwd}, true);
    }
}
