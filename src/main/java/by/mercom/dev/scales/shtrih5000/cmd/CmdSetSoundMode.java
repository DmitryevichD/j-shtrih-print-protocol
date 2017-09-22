package by.mercom.dev.scales.shtrih5000.cmd;

import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;

/**
 * Позволяет включить или выключить звуковые сигналы весов. Не влияет на звуковой сигнал при
 * включении питания весов и сигналы, сообщающие об ошибках.
 */
public class CmdSetSoundMode extends ScaleCommand {

    public CmdSetSoundMode(Param.Password pwd, Param.BeepMode beepMode){
        super(0x2A, 6, new Param[]{pwd, beepMode}, false);
    }
}
