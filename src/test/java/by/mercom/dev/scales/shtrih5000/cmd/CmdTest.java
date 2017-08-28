package by.mercom.dev.scales.shtrih5000.cmd;


import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleKeyboard;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    public void ScaleCurrentModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x01, 0x12};
        ScaleCommand cmd = new CmdScaleCurrentMode();
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleBeepTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x01, 0x13};
        ScaleCommand cmd = new CmdScaleBeep();
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScalePasswordChangeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x09, 0x16, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x33, 0x30};
        ScaleCommand cmd = new CmdChangePassword(
                new Param.Password("0000".toCharArray()),
                new Param.Password("0030".toCharArray())
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetDefaultTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x17, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdSetDefault(
                new Param.Password("0000".toCharArray())
                );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCleanAllGoodsAndMstTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x18, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdCleanAllGoodsAndMsg(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCleanTotalTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x19, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdCleanTotal(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetDelTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x20, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetPointPosition(
                new Param.Password("0000".toCharArray()),
                new Param.DelimPos(0)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x20, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetPointPosition(
                new Param.Password("0000".toCharArray()),
                new Param.DelimPos(1)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x20, 0x30, 0x30, 0x30, 0x30, 0x02};
        cmd = new CmdSetPointPosition(
                new Param.Password("0000".toCharArray()),
                new Param.DelimPos(2)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test(expected = IncorrectParamValue.class)
    public void ScaleSetDateFormatTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x24, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetScaleDateFormat(
                new Param.Password("0000".toCharArray()),
                new Param.DateFormat("DDMMYY")
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x24, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetScaleDateFormat(
                new Param.Password("0000".toCharArray()),
                new Param.DateFormat("YYMMDD")
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x24, 0x30, 0x30, 0x30, 0x30, 0x02};
        cmd = new CmdSetScaleDateFormat(
                new Param.Password("0000".toCharArray()),
                new Param.DateFormat("MMDDYY")
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        cmd = new CmdSetScaleDateFormat(
                new Param.Password("0000".toCharArray()),
                new Param.DateFormat("RWCSDF")
        );
    }

    @Test
    public void ScaleSetTimeFormatTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x23, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetScaleTimeFormat(
                new Param.Password("0000".toCharArray()),
                new Param.TimeFormat(true)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x23, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetScaleTimeFormat(
                new Param.Password("0000".toCharArray()),
                new Param.TimeFormat(false)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetTimeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x08, 0x21, 0x30, 0x30, 0x30, 0x30, 0x01, 0x02, 0x03};
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        Date dt = sdf.parse("17-08-12 01:02:03");
        ScaleCommand cmd = new CmdSetScaleTime(
                new Param.Password("0000".toCharArray()),
                new Param.ScaleTime(dt.getTime())
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetDateTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x08, 0x22, 0x30, 0x30, 0x30, 0x30, 0x0C, 0x08, 0x11};
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        Date dt = sdf.parse("17-08-12 01:01:01");
        ScaleCommand cmd = new CmdSetScaleDate(
                new Param.Password("0000".toCharArray()),
                new Param.ScaleDate(dt)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetPrintModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x27, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetPrintMode(
                new Param.Password("0000".toCharArray()),
                new Param.PrintMode(0)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x27, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetPrintMode(
                new Param.Password("0000".toCharArray()),
                new Param.PrintMode(1)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x27, 0x30, 0x30, 0x30, 0x30, 0x02};
        cmd = new CmdSetPrintMode(
                new Param.Password("0000".toCharArray()),
                new Param.PrintMode(2)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetAutoPrintWeightTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x07, 0x28, 0x30, 0x30, 0x30, 0x30, 0x19, 0x00};
        ScaleCommand cmd = new CmdSetAutoPrintWeight(
                new Param.Password("0000".toCharArray()),
                new Param.WeightLimit(25)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }
}
