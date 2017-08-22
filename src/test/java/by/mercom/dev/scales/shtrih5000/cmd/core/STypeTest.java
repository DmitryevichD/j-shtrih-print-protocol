package by.mercom.dev.scales.shtrih5000.cmd.core;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class STypeTest {
    @Test
    public void convertToByteTest() throws Exception {
        Map<Integer, Byte> testMap0 = new HashMap<Integer, Byte>();
        testMap0.put(123, (byte)123);
        testMap0.put(128, (byte)-128);
        testMap0.put(254, (byte)-2);
        testMap0.put(23422, (byte)0);

        for (Map.Entry entry : testMap0.entrySet()) {
            SType sType = new SType((Integer)entry.getKey());
            assertTrue(sType.asByteArray().length == 1);
            assertTrue(sType.asByteArray()[0] == (Byte)entry.getValue());
            Integer checkKey = (Integer)entry.getKey();
            if(checkKey < 0 || checkKey > 255){
                assertEquals((Integer)0, sType.asInteger());
            }else{
                assertEquals(entry.getKey(), sType.asInteger());
            }
        }

        Map<Integer, Byte[]> testMap1 = new HashMap<Integer, Byte[]>();
        testMap1.put(12366, new Byte[]{78, 48});
        testMap1.put(1236666, new Byte[]{(byte)186, (byte)222, 18});
        testMap1.put(123666611, new Byte[]{(byte)179, 0, 95, 7});

        for (Map.Entry<Integer, Byte[]> entry : testMap1.entrySet()) {
            SType sType = new SType(entry.getKey(), entry.getValue().length);
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
            assertEquals(entry.getKey(), sType.asInteger());
        }

        Map<Character[], Byte[]> testMap2 = new HashMap<Character[], Byte[]>();
        testMap2.put(new Character[]{'1', '2', '3', '4'}, new Byte[]{49, 50, 51, 52});
        testMap2.put(new Character[]{'5', '6', '7', '8'}, new Byte[]{53, 54, 55, 56});
        testMap2.put(new Character[]{'9', '9', '0', '0'}, new Byte[]{57, 57, 48, 48});
        for (Map.Entry<Character[], Byte[]> entry : testMap2.entrySet()) {
            SType sType = new SType(ArrayUtils.toPrimitive(entry.getKey()));
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
            assertArrayEquals(sType.asCharArray(), entry.getKey());
        }

        Map<Boolean, Byte[]> testMap3 = new HashMap<Boolean, Byte[]>();
        testMap3.put(false, new Byte[]{0});
        testMap3.put(true, new Byte[]{1});
        for (Map.Entry<Boolean, Byte[]> entry : testMap3.entrySet()) {
            SType sType = new SType(entry.getKey());
            assertArrayEquals(sType.asByteArray(), ArrayUtils.toPrimitive(entry.getValue()));
            assertEquals(sType.asBoolean(), entry.getKey());
        }

        int[] arrayInteger = new int[256];
        byte[] byteArray = new byte[256];
        for (int i = 0; i < 256; i++) {
            arrayInteger[i] = i;
            byteArray[i] = (byte)i;
        }
        SType sType = new SType(byteArray);
        assertArrayEquals(sType.asIntArray(), arrayInteger);
    }

}