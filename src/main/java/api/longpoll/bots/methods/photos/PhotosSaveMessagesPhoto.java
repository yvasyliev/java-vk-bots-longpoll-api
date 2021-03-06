package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResponse;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>photos.saveMessagesPhoto</b> method.
 *
 * @see <a href="https://vk.com/dev/photos.saveMessagesPhoto">https://vk.com/dev/photos.saveMessagesPhoto</a>
 */
public class PhotosSaveMessagesPhoto extends GetMethod<GenericResult<List<PhotosSaveMessagesPhotoResponse>>> {
    /**
     * Parameter returned when photo upload to the server.
     */
    private String photo;

    /**
     * Server ID.
     */
    private Integer server;

    /**
     * Hash.
     */
    private String hash;

    public PhotosSaveMessagesPhoto(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().photosSaveMessagesPhoto();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<List<PhotosSaveMessagesPhotoResponse>>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, List.class, PhotosSaveMessagesPhotoResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("photo", photo),
                keyVal("server", server),
                keyVal("hash", hash)
        );
    }

    public String getPhoto() {
        return photo;
    }

    public PhotosSaveMessagesPhoto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Integer getServer() {
        return server;
    }

    public PhotosSaveMessagesPhoto setServer(Integer server) {
        this.server = server;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public PhotosSaveMessagesPhoto setHash(String hash) {
        this.hash = hash;
        return this;
    }
}
