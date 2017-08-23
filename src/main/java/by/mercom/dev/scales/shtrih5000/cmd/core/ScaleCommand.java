package by.mercom.dev.scales.shtrih5000.cmd.core;

import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectAnswerException;
import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectCommandLengthException;
import org.apache.commons.lang.ArrayUtils;

public abstract class ScaleCommand {
    private SType cmdCode;
    private SType cmdSize;
    private boolean isSyncMode = false;
    private boolean supportSyncMode;
    private String description = null;
    private Param[] params;

    public boolean isSyncMode(){
        return isSyncMode;
    }
    private byte[] paramsAsByteArray(){
        byte[] paramsArray = ArrayUtils.EMPTY_BYTE_ARRAY;

        if(ArrayUtils.isEmpty(params)){return paramsArray;};

        for (int i = 0; i < params.length; i++) {
            paramsArray = ArrayUtils.addAll(paramsArray, params[i].asByteArray());
        }
        return paramsArray;
    }

    public ScaleCommand(int cmdCode, int cmdSize, Param[] params, boolean supportSyncMode){
        this.cmdCode = new SType(cmdCode);
        this.cmdSize = new SType(cmdSize);
        this.supportSyncMode = supportSyncMode;
        this.params = params;
    }

    public void enableSyncMode(){
        isSyncMode = supportSyncMode;
    }

    public void disableSyncMode(){
        isSyncMode = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Возвращает начальный бит сообщения, в зависимости от режима, который поддерживает команда
     * @return начальный бит команды согласно спеки
     */
    private byte getCmdMode(){
        return isSyncMode() ? MODE.SYNC.getCode() : MODE.SIMPLE.getCode();
    }

    /**
     * Преобразовывает сообщение в последовательность байт, которые будут передаваться устройству
     * @return
     */
    public byte[] cmdAsByteArray() throws IncorrectCommandLengthException {
        byte[] result = ArrayUtils.addAll(new byte[]{getCmdMode(), cmdSize.asByte(), cmdCode.asByte()}, paramsAsByteArray());
        if (result.length != cmdSize.asInteger() + 2) {
            throw new IncorrectCommandLengthException("CMD:" + cmdCode + "current length: " + result.length + 2 + " needed: " + cmdSize + 2);
        }
        return result;
    }

    public int[] cmdAsIntArray() throws IncorrectCommandLengthException {
        byte[] byteArray = cmdAsByteArray();
        int[] result = new int[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            result[i] = byteArray[i] & 0xFF;
        }
        return result;
    }

    @Override
    public String toString(){
        return description == null ? super.toString() : description;
    }


    /**
     * Признак начала сообщения
     * Определяет начало сообщения и его режим (обычный или режим синхронизации с хостом)
     */
    enum MODE{
        SIMPLE((byte) 0x02), SYNC((byte) 0x03);

        private byte code;

        private MODE(byte code){
            this.code = code;
        }

        public byte getCode(){
          return code;
        }
    }

}
