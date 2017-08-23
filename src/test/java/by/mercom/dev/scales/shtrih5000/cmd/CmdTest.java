package by.mercom.dev.scales.shtrih5000.cmd;


import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleKeyboard;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CmdTest {

    @Test
    public void EmulKeyboardTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x08, 0x30, 0x30, 0x33, 0x30, 0x80};
        ScaleCommand cmd = new CmdEmulKeyboard(
                new Param.Password("0030".toCharArray()),
                new Param.KeyCode(ScaleKeyboard.HOT_KEYS));

        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

    }

    @Test
    public void LockKeyboardTest() throws Exception{
        int[] correctCmdEnable = new int[]{0x02, 0x06, 0x09, 0x30, 0x30, 0x33, 0x30, 0x01};
        int[] correctCmdDisable = new int[]{0x02, 0x06, 0x09, 0x30, 0x30, 0x33, 0x30, 0x00};
        ScaleCommand cmd = new CmdLockKeyboard(
                new Param.Password("0030".toCharArray()),
                new Param.KeyLock(true)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmdEnable);

        cmd = new CmdLockKeyboard(
                new Param.Password("0030".toCharArray()),
                new Param.KeyLock(false)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmdDisable);
    }

    @Test
    public void EnableBroadcastTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x0A, 0x30, 0x30, 0x33, 0x30};
        ScaleCommand cmd = new CmdEnableBroadcast(
                new Param.Password("0030".toCharArray()));
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void DisableBroadcastTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x0B, 0x30, 0x30, 0x33, 0x30};
        ScaleCommand cmd = new CmdDisableBroadcast(
                new Param.Password("0030".toCharArray()));
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleStatusTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x01, 0x11};
        ScaleCommand cmd = new CmdScaleStatus();
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }
}
