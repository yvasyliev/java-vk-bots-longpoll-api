package smaple;

import api.longpoll.bots.BotsLongPoll;
import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.methods.board.BoardDeleteComment;
import api.longpoll.bots.methods.board.BoardRestoreComment;
import api.longpoll.bots.methods.groups.GroupsAddAddress;
import api.longpoll.bots.methods.messages.MessagesSend;
import api.longpoll.bots.model.board.BoardPostDeleteEvent;
import api.longpoll.bots.model.board.BoardPostEvent;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.response.groups.GroupsAddAddressResult;
import org.slf4j.impl.SimpleLogger;

import java.io.File;

public class Main {
	private static BotsLongPoll botsLongPoll;
	private static class MyBot extends LongPollBot {
		@Override
		public void onMessageNew(MessageEvent messageUpdate) {
			try {
				File photo = new File("screenshot.png");

				GroupsAddAddressResult addAddressResponse = new GroupsAddAddress(this)
						.setGroupId(getGroupId())
						.setTitle("test")
						.setAddress("test addr")
						.setCountryId(1)
						.setCityId(1)
						.setLatitude(50)
						.setLongitude(50)
						.execute();

				new MessagesSend(this)
						.setPeerId(messageUpdate.getMessage().getPeerId())
						.setMessage("answer")
						.execute();

			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onBoardPostNew(BoardPostEvent boardPostUpdate) {
			try {
				new BoardDeleteComment(this)
						.setCommentId(boardPostUpdate.getId())
						.setGroupId(getGroupId())
						.setTopicId(boardPostUpdate.getTopicId())
						.execute();
			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onBoardPostDelete(BoardPostDeleteEvent boardPostDeleteUpdate) {
			try {
				new BoardRestoreComment(this)
						.setCommentId(boardPostDeleteUpdate.getId())
						.setGroupId(getGroupId())
						.setTopicId(boardPostDeleteUpdate.getTopicId())
						.execute();
			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String getAccessToken() {
			return System.getenv("access_token");
		}

		@Override
		public String getApiVersion() {
			return System.getenv("v");
		}

		@Override
		public int getGroupId() {
			return Integer.parseInt(System.getenv("group_id"));
		}
	}

	public static void main(String[] args) {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
		botsLongPoll = new BotsLongPoll(new MyBot());
		botsLongPoll.run();
	}
}
