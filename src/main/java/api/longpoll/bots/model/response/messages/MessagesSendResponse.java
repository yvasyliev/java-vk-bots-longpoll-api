package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.send</b> request.
 */
public class MessagesSendResponse {
    /**
     * Peer ID.
     */
    @SerializedName("peer_id")
    private Integer peerId;

    /**
     * Message ID.
     */
    @SerializedName("message_id")
    private Integer messageId;

    /**
     * Error message, if message is not delivered.
     */
    @SerializedName("error")
    private String error;

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
