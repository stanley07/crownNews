package handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.exception.AskSdkException;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.alexa.presentation.apl.RenderDocumentDirective;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import util.SkillData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LaunchHandler implements LaunchRequestHandler {
  @Override
  public boolean canHandle(HandlerInput handlerInput, LaunchRequest launchRequest) {
    return true;
  }

  @Override
  public Optional<Response> handle(HandlerInput handlerInput, LaunchRequest launchRequest) {
    final String speechText = "Hello, royal family! welcome to Crown news. "
        + "A concise tweeter news feed channel for the royal family. In memory of Her Majesty Queen Elizabeth the second.: "
        
              
        +"To hear what's trending in any city of the world, just ask: What's trending in, followed by the city name. ";        

    final String repromptText = "A consice tweeter news feed channel for the royal family. In memory of Her Majesty Queen Elizabeth the second "
        
        +"To hear what's trending in any city of the world, just ask: What's trending in, followed by the city name. ";
        

    // Device supports screen
    if (SkillData.supportsAPL(handlerInput)) {
      try {
        String content = SkillData.getFileContentAsString("welcome.json");

        Map<String, Object> document = new Gson().fromJson(content, new TypeToken<HashMap<String, Object>>() {
        }.getType());

        return handlerInput.getResponseBuilder().withSpeech(speechText).withReprompt(repromptText)
            .addDirective(RenderDocumentDirective.builder().withDocument(document).build()).build();
      } catch (IOException e) {
        throw new AskSdkException("Unable to read or deserialize APL document", e);
      }
    }

    // Headless device
    return handlerInput.getResponseBuilder().withSpeech(speechText).withReprompt(repromptText).build();
  }
}
