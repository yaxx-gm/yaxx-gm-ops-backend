package org.br.yaxx.backend.configurations;

import org.br.yaxx.backend.utils.languagues.English;
import org.br.yaxx.backend.utils.languagues.ILanguage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LanguageConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ILanguage setLanguage(){

        LOGGER.info("Language default: English");

        return new English();
    }

}
