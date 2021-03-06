package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesDeleteChatPhotoResponse;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.deleteChatPhoto</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.deleteChatPhoto">https://vk.com/dev/messages.deleteChatPhoto</a>
 */
public class MessagesDeleteChatPhoto extends GetMethod<GenericResult<MessagesDeleteChatPhotoResponse>> {
    /**
     * Chat ID.
     */
    private Integer chatId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesDeleteChatPhoto(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDeleteChatPhoto();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<MessagesDeleteChatPhotoResponse>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, MessagesDeleteChatPhotoResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("chat_id", chatId),
                keyVal("group_id", groupId)
        );
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesDeleteChatPhoto setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesDeleteChatPhoto setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
