package by.mercom.dev.scales.shtrih5000.cmd;


import by.mercom.dev.scales.shtrih5000.cmd.core.Param;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleCommand;
import by.mercom.dev.scales.shtrih5000.cmd.core.ScaleKeyboard;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectParamValue;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void ScaleSetPackagingModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x29, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetPackagingMode(
                new Param.Password("0000".toCharArray()),
                new Param.PackMode(false)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x29, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetPackagingMode(
                new Param.Password("0000".toCharArray()),
                new Param.PackMode(true)
        );
        assertArrayEquals(cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetSoundModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x2A, 0x30, 0x30, 0x30, 0x30, 0x01};
        ScaleCommand cmd = new CmdSetSoundMode(
                new Param.Password("0000".toCharArray()),
                new Param.BeepMode(true)
        );
        assertArrayEquals("Sound mode is enable",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x2A, 0x30, 0x30, 0x30, 0x30, 0x00};
        cmd = new CmdSetSoundMode(
                new Param.Password("0000".toCharArray()),
                new Param.BeepMode(false)
        );
        assertArrayEquals("Sound mode is disable",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetCourceTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x09, 0x2B, 0x30, 0x30, 0x30, 0x30, 0x52, 0xB8, 0xBA, 0x41};
        ScaleCommand cmd = new CmdSetCurrencyCource(
                new Param.Password("0000".toCharArray()),
                new Param.Cource(23.34f)
        );
        assertArrayEquals("check cource",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleGetPLUAccessTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x2C, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdGetScalePLUAccess(
                new Param.Password("0000".toCharArray()));
        assertArrayEquals("plu get access",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetPLUAccessTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x2F, 0x30, 0x30, 0x30, 0x30, 0x0};
        ScaleCommand cmd = new CmdSetScalePLUAccess(
                new Param.Password("0000".toCharArray()),
                new Param.PLUAccess(0)
        );
        assertArrayEquals("set plu access by number plus",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x2F, 0x30, 0x30, 0x30, 0x30, 0x1};
        cmd = new CmdSetScalePLUAccess(
                new Param.Password("0000".toCharArray()),
                new Param.PLUAccess(1)
        );
        assertArrayEquals("set plu access by code of goods",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetZeroTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x30, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdSetScaleZero(
                new Param.Password("0000".toCharArray()));
        assertArrayEquals("set zero",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetTareTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x31, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdSetScaleTare(
                new Param.Password("0000".toCharArray()));
        assertArrayEquals("set tare",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x07, 0x32, 0x30, 0x30, 0x30, 0x30, 0x22, 0x30};
        cmd = new CmdSetScaleTare(
                new Param.Password("0000".toCharArray()),
                new Param.Tare(12322)
        );
        assertArrayEquals("set tare",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleSetPriceTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x09, 0x33, 0x30, 0x30, 0x30, 0x30, 0x3F, 0x42, 0x0F, 0x00};
        ScaleCommand cmd = new CmdSetScalePrice(
                new Param.Password("0000".toCharArray()),
                new Param.Price(999999)
        );
        assertArrayEquals("set price",cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.Price(-23);
            assertTrue("must be exception", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleSetQuantityTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x34, 0x30, 0x30, 0x30, 0x30, 0x20};
        ScaleCommand cmd = new CmdSetScaleQuantity(
                new Param.Password("0000".toCharArray()),
                new Param.Quantity(32)
        );
        assertArrayEquals("set quantity",cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.Quantity(-23);
            assertTrue("must be exception", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleSetGoodsTypeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x35, 0x30, 0x30, 0x30, 0x30, 0x00};
        ScaleCommand cmd = new CmdSetScaleGoodsType(
                new Param.Password("0000".toCharArray()),
                new Param.GoodsType(0)
        );
        assertArrayEquals("set weight type",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x35, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdSetScaleGoodsType(
                new Param.Password("0000".toCharArray()),
                new Param.GoodsType(1)
        );
        assertArrayEquals("set piece type",cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.GoodsType(12);
            assertTrue("must be exception", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleCmdSetScaleCurrEquivModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x06, 0x36, 0x30, 0x30, 0x30, 0x30, 0x01};
        ScaleCommand cmd = new CmdSetScaleCurrEquivMode(
                new Param.Password("0000".toCharArray()),
                new Param.EnCurrEquiv(true)
        );
        assertArrayEquals("enable equiv mode",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x36, 0x30, 0x30, 0x30, 0x30, 0x00};
        cmd = new CmdSetScaleCurrEquivMode(
                new Param.Password("0000".toCharArray()),
                new Param.EnCurrEquiv(false)
        );
        assertArrayEquals("disable equiv mode",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdSetScaleGoodItemTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x07, 0x37, 0x30, 0x30, 0x30, 0x30, 0x00, 0x00};
        ScaleCommand cmd = new CmdSetScaleGoodItem(
                new Param.Password("0000".toCharArray()),
                new Param.GoodItem(0)
        );
        assertArrayEquals("reset good item",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x07, 0x37, 0x30, 0x30, 0x30, 0x30, 0x7D, 0x0D};
        cmd = new CmdSetScaleGoodItem(
                new Param.Password("0000".toCharArray()),
                new Param.GoodItem(3453)
        );
        assertArrayEquals("set good item",cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.GoodItem(-232);
            assertTrue("must be exception", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleCmdGetScaleWeightTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x38, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdGetScaleWeight(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get scale weight",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdGetScaleDisplayDataTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x39, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdGetScaleDisplayData(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get scale display data",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdGetScaleWeightDeviceStatusTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x3A, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdGetScaleWeightDeviceStatus(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get scale weight device status",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScaleFeedDocumentTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x40, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScaleFeedDocument(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("feed document",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintLabelTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x41, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScalePrintLabel(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("print label",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintTotalLabelTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x42, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScalePrintTotalLabel(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("print total label",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintCopyTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x43, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScalePrintCopy(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("print copy label",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintTestLabelTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x44, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScalePrintTestLabel(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("print test label",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintCashReportTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x07, 0x45, 0x30, 0x30, 0x30, 0x30, 0x01, 0x00};
        ScaleCommand cmd = new CmdScalePrintCashReport(
                new Param.Password("0000".toCharArray()),
                new Param.GoodItem(1)
        );
        assertArrayEquals("print cash report by good item",cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x07, 0x45, 0x30, 0x30, 0x30, 0x30, 0x00, 0x00};
        cmd = new CmdScalePrintCashReport(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("print cash report by all good item",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScalePrintOffsetTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x46, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScalePrintOffset(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get print offset", cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x47, 0x30, 0x30, 0x30, 0x30, 0x04};
        cmd = new CmdScalePrintOffset(
                new Param.Password("0000".toCharArray()),
                new Param.Offset(4)
        );
        assertArrayEquals("set print offset", cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.Offset(10);
            assertTrue("set print offset", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleCmdScaleBrightnessTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x48, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScaleBrightness(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get brightness", cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x49, 0x30, 0x30, 0x30, 0x30, 0x03};
        cmd = new CmdScaleBrightness(
                new Param.Password("0000".toCharArray()),
                new Param.Brightness(3)
        );
        assertArrayEquals("set brightness", cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.Brightness(18);
            assertTrue("set brightness", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }

    @Test
    public void ScaleCmdGetScalePrinterStatusTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x4A, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdGetScalePrinterStatus(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("getting printer status",cmd.cmdAsIntArray(), correctCmd);
    }

    @Test
    public void ScaleCmdScaleUnderwinerModeTest() throws Exception{
        int[] correctCmd = new int[]{0x02, 0x05, 0x4B, 0x30, 0x30, 0x30, 0x30};
        ScaleCommand cmd = new CmdScaleUnderwinerMode(
                new Param.Password("0000".toCharArray())
        );
        assertArrayEquals("get underwinder mode", cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x4C, 0x30, 0x30, 0x30, 0x30, 0x00};
        cmd = new CmdScaleUnderwinerMode(
                new Param.Password("0000".toCharArray()),
                new Param.UnderwinderMode(0)
        );
        assertArrayEquals("disable underwinder mode", cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x4C, 0x30, 0x30, 0x30, 0x30, 0x01};
        cmd = new CmdScaleUnderwinerMode(
                new Param.Password("0000".toCharArray()),
                new Param.UnderwinderMode(1)
        );
        assertArrayEquals("normal underwinder mode", cmd.cmdAsIntArray(), correctCmd);

        correctCmd = new int[]{0x02, 0x06, 0x4C, 0x30, 0x30, 0x30, 0x30, 0x02};
        cmd = new CmdScaleUnderwinerMode(
                new Param.Password("0000".toCharArray()),
                new Param.UnderwinderMode(2)
        );
        assertArrayEquals("strengthened underwinder mode", cmd.cmdAsIntArray(), correctCmd);

        try {
            new Param.UnderwinderMode(3);
            assertTrue("exception underwinder mode", false);
        } catch (IncorrectParamValue ex) {
            assertTrue(true);
        }
    }
}
