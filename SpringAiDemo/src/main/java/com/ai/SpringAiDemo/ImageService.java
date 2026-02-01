package com.ai.SpringAiDemo;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String prompt, String quality, int n, int width, int height){
       /* ImageResponse response=openAiImageModel.call(
                new ImagePrompt(prompt,
                        new OpenAiImageOptions.Builder()
                                .model("dall-e-2")
                                .quality("hd")
                                .N(1)// 1 for model dall-e-3 , unlimited for dall-e-2
                                .width(1024)
                                .height(1024)
                        .build())
        );*/

        ImageResponse response=openAiImageModel.call(
                new ImagePrompt(prompt,
                        new OpenAiImageOptions.Builder()
                                .model("dall-e-2")
                                .quality(quality)
                                .N(n)// 1 for model dall-e-3 , unlimited for dall-e-2
                                .width(width)
                                .height(height)
                                .build())
        );
        return response;
    }


}
