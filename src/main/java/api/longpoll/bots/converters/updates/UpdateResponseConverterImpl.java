package api.longpoll.bots.converters.updates;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class UpdateResponseConverterImpl extends JsonToPojoConverter<GetEventsResult> {
	private static final String TS_FIELD = "ts";
	private static final String UPDATES_FIELD = "updates";
	private UpdateConverterImpl updateConverter = new UpdateConverterImpl();

	@Override
	public GetEventsResult convert(JsonObject jsonObject) {
		GetEventsResult getEventsResult = gson.fromJson(jsonObject, GetEventsResult.class);

		if (jsonObject.has(UPDATES_FIELD)) {
			JsonArray updates = jsonObject.getAsJsonArray(UPDATES_FIELD);
			List<Event> eventList = new ArrayList<>(updates.size());
			updates.forEach(update -> eventList.add(updateConverter.convert(update.getAsJsonObject())));
			getEventsResult.setEvents(eventList);
		}

		return getEventsResult;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return GetEventsResult.class.equals(fieldAttributes.getDeclaringClass())
				&& List.class.equals(fieldAttributes.getDeclaredClass());
	}
}
