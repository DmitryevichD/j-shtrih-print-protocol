package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Позволяет включить или выключить режим фасовки
 */
public class CmdSetPackagingMode extends ScaleCommand{

    public CmdSetPackagingMode(Param.Password pwd, Param.PackMode packMode) {
        super(0x29, 6, new Param[]{pwd, packMode}, false);
    }
}
