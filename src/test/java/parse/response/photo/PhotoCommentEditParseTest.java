package parse.response.photo;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhotoCommentEditParseTest extends AbstractParseTest {
	@Test
	public void test1_messageEdit() throws IOException {
		JsonObject jsonObject = readJson("json/response/photo_comment_edit/photo_comment_edit_sample_5_110.json");
		GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2614), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("photo_comment_edit", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("24c4fd1d5d9ad88cd714b91364e6737f2cff2814", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof PhotoCommentEvent);
		PhotoCommentEvent photoCommentUpdate = (PhotoCommentEvent) eventObject;
		Assert.assertNotNull(photoCommentUpdate);
		Assert.assertEquals(Integer.valueOf(3), photoCommentUpdate.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photoCommentUpdate.getFromId());
		Assert.assertEquals(Integer.valueOf(1594285508), photoCommentUpdate.getDate());
		Assert.assertEquals("tt", photoCommentUpdate.getText());
		Assert.assertEquals(Integer.valueOf(-168975658), photoCommentUpdate.getPhotoOwnerId());
		Assert.assertEquals(Integer.valueOf(457239017), photoCommentUpdate.getPhotoId());

		WallComment.Thread thread = photoCommentUpdate.getThread();
		Assert.assertNotNull(thread);
		Assert.assertEquals(Integer.valueOf(0), thread.getCount());
	}
}
