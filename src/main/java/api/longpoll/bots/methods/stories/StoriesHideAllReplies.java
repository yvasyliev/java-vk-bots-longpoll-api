package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.hideAllReplies</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.hideAllReplies">https://vk.com/dev/stories.hideAllReplies</a>
 */
public class StoriesHideAllReplies extends GetMethod<GenericResult<Integer>> {
    /**
     * ID of the user whose replies should be hidden.
     */
    private Integer ownerId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public StoriesHideAllReplies(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesHideAllReplies();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, Integer.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("group_id", groupId)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public StoriesHideAllReplies setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public StoriesHideAllReplies setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
