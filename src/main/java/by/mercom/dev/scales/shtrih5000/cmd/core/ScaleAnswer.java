package by.mercom.dev.scales.shtrih5000.cmd.core;

import by.mercom.dev.scales.shtrih5000.scaleException.IncorrectAnswerException;

public abstract class ScaleAnswer {
    private byte ansCode;
    private byte status;
    private byte[] answerByteArray;
    private boolean isSysMsg;

    public ScaleAnswer(byte[] answer) throws IncorrectAnswerException{
        this.answerByteArray = answer;
        try {
            ansCode = answer[0];
            isSysMsg = SYS_MSG.isSysCode(ansCode);
            status = isSysMsg ? 0 : answer[1];
        } catch (Exception e) {
            throw new IncorrectAnswerException("Incorrect answer");
        }
    }



}
