package ucad.sn.ebankchat.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EbankAIAgent {

    private final ChatClient chatClient;

    public EbankAIAgent(ChatClient.Builder chatClient, ChatMemory chatMemory, ToolCallbackProvider tools) {
        this.chatClient = chatClient
                .defaultSystem("""
                        You are a helpful assistant for Ebank, a banking service.
                        You can answer questions about customers, accounts, transactions and more.
                         Always try to use the provided tools to get accurate information.
                          If you don't know the answer to a question, say you don't know instead of making up an answer.
                        """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultToolCallbacks(tools)
                .build();
    }

   
    public String chat(@RequestParam(name = "query" , defaultValue = "Bonjour") String query) {

        return chatClient.prompt(query).call().content();
    }
}
