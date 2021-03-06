package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadDocResult;
import org.jsoup.Connection;

import java.io.File;
import java.util.stream.Stream;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends PostMethod<UploadDocResult> {
    /**
     * Upload URL.
     */
    private String uploadUrl;

    @Override
    protected String getApi() {
        return uploadUrl;
    }

    @Override
    protected JsonToPojoConverter<UploadDocResult> getConverter() {
        return CachedConverterFactory.getConverter(UploadDocResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }

    @Override
    protected String getType() {
        return "file";
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public UploadDoc setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }

    public UploadDoc setDoc(File doc) {
        setFile(doc);
        return this;
    }

    public File getDoc() {
        return getFile();
    }
}
