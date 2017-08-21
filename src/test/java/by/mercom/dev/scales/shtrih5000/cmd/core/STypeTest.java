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

        for (Map.Entry<Integer, Byte[]> testMapEntry : testMapArray.entrySet()) {
            SType sType = new SType(testMapEntry.getKey(), testMapEntry.getValue().length);

            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(testMapEntry.getValue()));
        }
    }

}