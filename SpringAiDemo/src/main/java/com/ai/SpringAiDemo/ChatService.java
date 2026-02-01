package com.ai.SpringAiDemo;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
       return chatModel.call(prompt);
    }

    public String getResponseOptions(String userText){
        ChatResponse response= chatModel.call(
                new Prompt(
                        userText,
                        OpenAiChatOptions.builder()
                                .model("gpt-4o")
                                .maxTokens(150)
                                .build()
                ));
        AssistantMessage message = response.getResult().getOutput(); // returns AssistedMessage
        String text = message.getText();
        return  text;
    }
}
