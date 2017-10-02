package by.mercom.dev.scales.shtrih5000.cmd.core;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Данный класс представляет собой инструмент для создания и преобразования различных базовых классов java
 * в массив байтов, совместимых с протоколом Штрих-принт
 */
public class SType {
    private byte[] value;

    /**
     * Создает массив из одного байта на основании целого числа
     * @param int_val Целое значение, которое будет конвертировано в byte
     */
    public SType(int int_val){
        this.value = new byte[1];
        this.value[0] = (int_val < 0 || int_val > 255) ?  0 : (byte) int_val;
    }

    /**
     * Все числовые величины передаются в двоичном формате, если не указано другое. Первым
     * передается самый младший байт, последним самый старший байт (т.н. little endian – стиль остроконечников)
     * @param int_val целое число, которое необходимо преобразовать в массив байт
     * @param countByte количество младший байтов @param value которые мы преобразуем в массив байт
     */
    public SType(int int_val, int countByte){
        countByte = (countByte < 1 || countByte > 4) ? 1 : countByte;
        value = convertToByte(int_val, countByte);
    }

    public SType(char[] charVal) {
        charVal = charVal == null ? new char[]{'0', '0', '0', '0'} : charVal;
        value = new byte[charVal.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = (byte)charVal[i];
        }
    }

    public SType(float floatValue){
       //round
        float roundFloat = new BigDecimal(floatValue).setScale(2, RoundingMode.HALF_UP).floatValue();
        value = convertToByte(Float.floatToIntBits(roundFloat), 4);
    }


    public SType(Date date) {
        date = date == null ? new Date() : date;
        String strDate = getDate(date);
        String[] dateArray = strDate.split(" ")[0].split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        value = new byte[3];
        value[0] = (byte)day;
        value[1] = (byte)month;
        value[2] = (byte)year;
    }

    public SType(long time) {
        String strDate = getDate(new Date(time));
        String[] dateArray = strDate.split(" ")[1].split(":");
        int hour = Integer.parseInt(dateArray[0]);
        int min = Integer.parseInt(dateArray[1]);
        int sec = Integer.parseInt(dateArray[2]);
        value = new byte[3];
        value[0] = (byte)hour;
        value[1] = (byte)min;
        value[2] = (byte)sec;
    }

    public SType(boolean boolVal) {
        value = new byte[1];
        value[0] = boolVal ? (byte)1 : (byte)0;
    }

    public SType(String str, int countByte){
        value = new byte[countByte];
        try {
            byte[] bString = str.getBytes("CP1251");
            System.arraycopy(bString,
                    0,
                    value,
                    0,
                    bString.length <= countByte ? bString.length : countByte);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public SType(byte[] byteArray) {
        this.value = byteArray == null ? new byte[]{0} : byteArray;
    }

    private byte[] convertToByte(int int_val, int countByte) {
        byte[] result = new byte[countByte];
        for (int i = 0; i < countByte; i++) {
            result[i] = (byte)(int_val >> 8 * i);
        }
        return result;
    }

    public byte[] asByteArray(){
        return value;
    }

    public int[] asIntArray(){
        int[] result = new int[value.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = value[i] & 0xFF;
        }
        return result;
    }

    public Byte asByte(){
        return value[0];
    }

    public Integer asInteger(){
        int result = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            result = result << 8;
            int tmvInt = value[i] & 0xFF;
            result = result | tmvInt;
        }
        return result;
    }

    public Character[] asCharArray(){
        Character[] result = new Character[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = (char)value[i];
        }
        return result;
    }

     public Boolean asBoolean(){
        return value[0] == 1;
     }

    private String getDate(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        return sdf.format(dt);
    }
}
