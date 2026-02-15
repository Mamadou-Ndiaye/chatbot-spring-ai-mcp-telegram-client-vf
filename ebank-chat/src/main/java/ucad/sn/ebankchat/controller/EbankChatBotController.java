package ucad.sn.ebankchat.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EbankChatBotController {
    private final   ChatClient chatClient;

    public EbankChatBotController(ChatClient.Builder chatClient, ChatMemory chatMemory) {
        this.chatClient = chatClient.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("/chat")
    public String chatWithBot(@RequestParam(name = "query" , defaultValue = "Bonjour") String query) {

        return chatClient.prompt(query).call().content();
    }
}
