package kz.astana.tbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class WATBotHandler extends TelegramLongPollingBot {

    public WATBotHandler() {
        try {
            execute(SendMessage.builder().chatId(125667231L).text("I'm UP!").build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "WebAppTest";
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var msg = update.getMessage();
            long chat_id = update.getMessage().getChatId();

            var message = SendMessage.builder()
                    .chatId(chat_id)
                    .text("You send: " + msg.getText());

            try {
                execute(message.build());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
