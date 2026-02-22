package ucad.sn.ebankchat.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ucad.sn.ebankchat.agents.EbankAIAgent;

@RestController
@RequestMapping("/api")
public class EbankChatBotController {
    private final EbankAIAgent ebankAIAgent;

    public EbankChatBotController(EbankAIAgent ebankAIAgent) {
        this.ebankAIAgent = ebankAIAgent;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(name = "query" , defaultValue = "Bonjour") String query) {
        return ebankAIAgent.chat(query);
    }
}
