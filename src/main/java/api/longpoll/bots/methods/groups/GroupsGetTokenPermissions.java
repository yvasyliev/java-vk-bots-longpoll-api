package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetTokenPermissionsResponse;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.getTokenPermissions</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.getTokenPermissions">https://vk.com/dev/groups.getTokenPermissions</a>
 */
public class GroupsGetTokenPermissions extends GetMethod<GenericResult<GroupsGetTokenPermissionsResponse>> {
    public GroupsGetTokenPermissions(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsGetTokenPermissions();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<GroupsGetTokenPermissionsResponse>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, GroupsGetTokenPermissionsResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }
}
