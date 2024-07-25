package app.quantun.langchanin.services;

import app.quantun.langchanin.ai.Assistant;

public interface ChatServices {
    String getAnswer(String userQuery);

    Assistant createAssistant();
}
