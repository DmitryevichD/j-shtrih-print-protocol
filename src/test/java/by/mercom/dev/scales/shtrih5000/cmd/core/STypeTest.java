package by.mercom.dev.scales.shtrih5000.cmd.core;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class STypeTest {
    @Test
    public void convertToByteTest() throws Exception {
        Map<Integer, Byte> testMap = new HashMap<Integer, Byte>();
        testMap.put(123, (byte)123);
        testMap.put(128, (byte)-128);
        testMap.put(254, (byte)-2);
        testMap.put(23422, (byte)0);

        for (Map.Entry entry : testMap.entrySet()) {
            SType sType = new SType((Integer)entry.getKey());
            assertTrue(sType.asByteArray().length == 1);
            assertTrue(sType.asByteArray()[0] == (Byte)entry.getValue());
        }

        Map<Integer, Byte[]> testMapArray = new HashMap<Integer, Byte[]>();
        testMapArray.put(12366, new Byte[]{78, 48});
        testMapArray.put(1236666, new Byte[]{(byte)186, (byte)222, 18});
        testMapArray.put(123666611, new Byte[]{(byte)179, 0, 95, 7});

        for (Map.Entry<Integer, Byte[]> entry : testMapArray.entrySet()) {
            SType sType = new SType(entry.getKey(), entry.getValue().length);
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
        }
        Map<Character[], Byte[]> testCharArray = new HashMap<Character[], Byte[]>();
        testCharArray.put(new Character[]{'1', '2', '3', '4'}, new Byte[]{52, 51, 50, 49});
        testCharArray.put(new Character[]{'5', '6', '7', '8'}, new Byte[]{56, 55, 54, 53});
        testCharArray.put(new Character[]{'9', '9', '0', '0'}, new Byte[]{48, 48, 57, 57});
        for (Map.Entry<Character[], Byte[]> entry : testCharArray.entrySet()) {
            SType sType = new SType(ArrayUtils.toPrimitive(entry.getKey()));
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
        }

        Map<Boolean, Byte[]> testBoolArray = new HashMap<Boolean, Byte[]>();
        testBoolArray.put(false, new Byte[]{0});
        testBoolArray.put(true, new Byte[]{1});
        for (Map.Entry<Boolean, Byte[]> entry : testBoolArray.entrySet()) {
            SType sType = new SType(entry.getKey());
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
        }
    }

}