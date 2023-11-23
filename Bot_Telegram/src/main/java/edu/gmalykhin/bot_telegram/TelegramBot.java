package edu.gmalykhin.bot_telegram;


import edu.gmalykhin.server.data.service.MyServiceImpl;
import edu.gmalykhin.server.domain.use_case.GetCarInfo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TelegramBot extends TelegramLongPollingBot {

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(TelegramBot.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final Integer VIN_LENGTH = 17;
    GetCarInfo carInfo = new GetCarInfo(MyServiceImpl.getInstance());

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
        for (Update update : updates) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage();
                message.setChatId(update.getMessage().getChatId().toString());
                if (update.getMessage().getText().length() < VIN_LENGTH) {
                    message.setText("Введите vin номер");
                } else {
                    String vin = update.getMessage().getText();
                    message.setText(carInfo.get(vin).getFullInfo());
                }

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return PROPERTIES.getProperty("bot.name");
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return PROPERTIES.getProperty("token");
    }
}
