package br.com.tvalerio.exercise;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.tvalerio.exercise.integration.spotify.SpotifyIntegration;

@Component
@Profile("production")
public class ApplicationContextInitializer {

    Logger logger = LoggerFactory
            .getLogger(ApplicationContextInitializer.class);

    @Autowired
    private SpotifyIntegration spotifyIntegration;

    @PostConstruct
    public void initializeApplicationContext() {
        logger.info("Initiating Spotify integration......");
        spotifyIntegration.loadData();
    }
}
