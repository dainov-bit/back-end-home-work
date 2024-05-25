package config;

import content.Author;
import content.Category;
import content.Material;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Category category() {
        return new Category();
    }

    @Bean
    public Material material() {
        return new Material();
    }

    @Bean
    public Author author() {
        return new Author();
    }
}
