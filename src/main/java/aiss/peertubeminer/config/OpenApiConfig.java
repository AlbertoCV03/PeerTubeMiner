package aiss.peertubeminer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "PeerTubeMiner API",
                version = "v1",
                description = "REST API for retrieving, adapting and storing PeerTube channel data to VideoMiner API",
                contact = @Contact(
                        url = "https://github.com/AlbertoCV03/PeerTubeMiner"
                )
        )
)
public class OpenApiConfig {
}
