package com.gmalykhin.check_vin;

import data.service.MyServiceImpl;
import domain.use_case.GetCarInfo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {

    private final Integer VIN_LENGTH = 15;
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
        return "testVinBot";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public String getBotToken() {
        return "6376981922:AAFDen4B21fTeJfEB2GCW-4y9YsSLEJNyNU";
    }
}
