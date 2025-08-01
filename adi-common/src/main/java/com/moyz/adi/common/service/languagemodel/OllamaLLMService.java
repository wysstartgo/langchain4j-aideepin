package com.moyz.adi.common.service.languagemodel;

import com.moyz.adi.common.entity.AiModel;
import com.moyz.adi.common.vo.LLMBuilderProperties;
import com.moyz.adi.common.vo.LLMException;
import com.moyz.adi.common.vo.OllamaSetting;
import dev.langchain4j.model.TokenCountEstimator;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import org.apache.commons.lang3.StringUtils;

import static com.moyz.adi.common.cosntant.AdiConstant.SysConfigKey.OLLAMA_SETTING;

public class OllamaLLMService extends AbstractLLMService<OllamaSetting> {

    public OllamaLLMService(AiModel aiModel) {
        super(aiModel, OLLAMA_SETTING, OllamaSetting.class);
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.isNotBlank(platformSetting.getBaseUrl()) && aiModel.getIsEnable();
    }

    @Override
    protected ChatModel doBuildChatModel(LLMBuilderProperties properties) {
        return OllamaChatModel.builder()
                .baseUrl(platformSetting.getBaseUrl())
                .modelName(aiModel.getName())
                .temperature(properties.getTemperature())
                .build();
    }

    @Override
    public StreamingChatModel buildStreamingChatModel(LLMBuilderProperties properties) {
        double temperature = properties.getTemperatureWithDefault(0.7);
        return OllamaStreamingChatModel.builder()
                .baseUrl(platformSetting.getBaseUrl())
                .modelName(aiModel.getName())
                .temperature(temperature)
                .build();
    }

    @Override
    public TokenCountEstimator getTokenEstimator() {
        return null;
    }

    @Override
    protected LLMException parseError(Object error) {
        return null;
    }
}
