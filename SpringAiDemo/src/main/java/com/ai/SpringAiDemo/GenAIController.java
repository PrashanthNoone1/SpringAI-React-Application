package com.ai.SpringAiDemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenAIController {
   private final ChatService chatService;
    private final ImageService imageService;
    private  final RecipeService recipeService;

    public GenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
        this.chatService = chatService;
        this.imageService=imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("ask-ai")  //localhost:8080/ask-ai?prompt=Whats up?
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("ask-ai-options")  //localhost:8080/ask-ai?prompt=Whats up?
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

   /* @GetMapping("generate-image")  //localhost:8080/ask-ai?prompt=Whats up?
    public void  generateImages(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse= imageService.generateImage(prompt);
         String imageURL= imageResponse.getResult().getOutput().getUrl();
         response.sendRedirect(imageURL);

    }*/
   @GetMapping("generate-image")
   public List<String> generateImages(HttpServletResponse response,
                                      @RequestParam(defaultValue = "hd") String quality,
                                      @RequestParam(defaultValue = "1") int n,
                                      @RequestParam(defaultValue = "1024") int width,
                                      @RequestParam(defaultValue = "1024") int height,
                                      @RequestParam String prompt) throws IOException {
       ImageResponse imageResponse= imageService.generateImage(prompt,quality,n,width,height);
       List<String> imageURL= imageResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl()).collect(Collectors.toList());
                return imageURL;
   }
     @GetMapping("recipe-generator")
     public String recipeCreater(@RequestParam String ingreidents,
                                       @RequestParam(defaultValue = "any") String cuisine,
                                       @RequestParam(defaultValue = "") String dietaryRestrictions){
       return recipeService.createRecipe(ingreidents,cuisine,dietaryRestrictions);
     }





}
