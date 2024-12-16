package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}