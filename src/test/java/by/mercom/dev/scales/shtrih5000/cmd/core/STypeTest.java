package by.mercom.dev.scales.shtrih5000.cmd.core;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


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

    @Test
    public void convertFloatToByteArrayTest() throws Exception{
        Map<Float, Byte[]> answers = new HashMap<Float, Byte[]>();
        answers.put(1.23f, new Byte[]{(byte)0xA4, (byte)0x70, (byte)0x9D, (byte)0x3F});
        answers.put(999999f, new Byte[]{(byte)0xF0, (byte)0x23, (byte)0x74, (byte)0x49});
        answers.put(99999.9f, new Byte[]{(byte)0xF3, (byte)0x4F, (byte)0xC3, (byte)0x47});
        answers.put(9999.99f, new Byte[]{(byte)0xF6, (byte)0x3F, (byte)0x1C, (byte)0x46});
        answers.put(8.38f, new Byte[]{(byte)0x7B, (byte)0x14, (byte)0x06, (byte)0x41});
        answers.put(23.75f, new Byte[]{(byte)0, (byte)0, (byte)0xBE, (byte)0x41});
        answers.put(153.89f, new Byte[]{(byte)0xD7, (byte)0xE3, (byte)0x19, (byte)0x43});
        answers.put(1f, new Byte[]{0, 0, (byte)0x80, (byte)0x3F});
        answers.put(0f, new Byte[]{0, 0, 0, 0});

        for (Map.Entry<Float, Byte[]> answer : answers.entrySet()) {
            assertArrayEquals("Invalid convert " + answer.getKey(), ArrayUtils.toPrimitive(answer.getValue()), new SType(answer.getKey()).asByteArray());
        }
    }

}