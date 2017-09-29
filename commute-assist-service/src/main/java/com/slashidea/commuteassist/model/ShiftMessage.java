package com.slashidea.commuteassist.model;

public class ShiftMessage {

    private Long userId;
    private Long delayInMillis;
    private String message;

    public ShiftMessage() {
    }

    public ShiftMessage(Long userId, Long shiftInMillis, String message) {
        this.userId = userId;
        this.delayInMillis = shiftInMillis;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDelayInMillis() {
        return delayInMillis;
    }

    public void setDelayInMillis(Long delayInMillis) {
        this.delayInMillis = delayInMillis;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ShiftMessage [userId=" + userId + ", delayInMillis=" + delayInMillis + ", message=" + message + "]";
    }
}
