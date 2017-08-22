package by.mercom.dev.scales.shtrih5000.cmd.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SYS_MSG_Test {
    List<Byte> sysCodes = Arrays.asList(new Byte[]{0x05, 0x06, 0x15, 0x0B});
    @Test
    public void isSysMsgCode() throws Exception {
        for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
            if(sysCodes.contains(i)){
                assertTrue(SYS_MSG.isSysCode(i));
            }else {
                assertFalse(SYS_MSG.isSysCode(i));
            }
        }
    }

}