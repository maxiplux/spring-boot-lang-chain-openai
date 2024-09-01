package app.quantun.langchanin.services.impl;

import app.quantun.langchanin.ai.Assistant;
import app.quantun.langchanin.models.dto.Answer;
import app.quantun.langchanin.services.ChatServices;
import dev.langchain4j.experimental.rag.content.retriever.sql.SqlDatabaseContentRetriever;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Service
@Slf4j
public class ChatServicesImpl implements ChatServices {

    @Value("${langchain4j.open-ai.chat-model.api-key}")
    private String apiKey;

    @Autowired
    private DataSource dataSource;

    @Override
    public Answer getAnswer(String userQuery) {

        String agentAnswer = this.createAssistant().answer(userQuery);
        log.info("==================================================");
        return new Answer(agentAnswer);
    }

    @Override
    public Assistant createAssistant() {
        ChatLanguageModel chatLanguageModel = OpenAiChatModel.withApiKey(apiKey);

        ContentRetriever contentRetriever = SqlDatabaseContentRetriever.builder()
                .dataSource(this.dataSource)
                .chatLanguageModel(chatLanguageModel)
                .build();

        return AiServices.builder(Assistant.class)
                .chatLanguageModel(chatLanguageModel)
                .contentRetriever(contentRetriever)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }


}
