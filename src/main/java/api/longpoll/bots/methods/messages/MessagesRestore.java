package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.restore</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.restore">https://vk.com/dev/messages.restore</a>
 */
public class MessagesRestore extends GetMethod<GenericResult<Integer>> {
    /**
     * ID of a previously-deleted message to restore.
     */
    private Integer messageId;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesRestore(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesRestore();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, Integer.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_id", messageId),
                keyVal("group_id", groupId)
        );
    }

    public Integer getMessageId() {
        return messageId;
    }

    public MessagesRestore setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesRestore setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
