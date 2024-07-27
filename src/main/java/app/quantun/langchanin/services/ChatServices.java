package app.quantun.langchanin.services;

import app.quantun.langchanin.ai.Assistant;
import app.quantun.langchanin.models.dto.Answer;

public interface ChatServices {
    Answer getAnswer(String userQuery);

    Assistant createAssistant();
}
