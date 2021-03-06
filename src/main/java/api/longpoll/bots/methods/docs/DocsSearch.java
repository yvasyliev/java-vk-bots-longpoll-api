package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.media.Doc;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.search</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.search">https://vk.com/dev/docs.search</a>
 */
public class DocsSearch extends GetMethod<VkList<Doc>> {
    /**
     * Search query.
     */
    private String q;

    /**
     * Number of results to return.
     */
    private Integer count;

    /**
     * Offset needed to return a specific subset of results.
     */
    private Integer offset;

    /**
     * <b>true</b> if flags should be returned.
     */
    private Boolean returnTags;

    public DocsSearch(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().docsSearch();
    }

    @Override
    protected JsonToPojoConverter<VkList<Doc>> getConverter() {
        return CachedConverterFactory.getConverter(VkList.class, Doc.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("q", q),
                keyVal("count", count),
                keyVal("offset", offset),
                keyVal("return_tags", returnTags, true)
        );
    }

    public String getQ() {
        return q;
    }

    public DocsSearch setQ(String q) {
        this.q = q;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public DocsSearch setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public DocsSearch setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Boolean getReturnTags() {
        return returnTags;
    }

    public DocsSearch setReturnTags(Boolean returnTags) {
        this.returnTags = returnTags;
        return this;
    }
}
