package br.com.tvalerio.exercise.integration.spotify;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tvalerio.exercise.integration.spotify.model.SpotifyAlbumResponse;
import br.com.tvalerio.exercise.integration.spotify.model.SpotifyTokenAuthResponse;
import br.com.tvalerio.exercise.model.GenreEntity;
import br.com.tvalerio.exercise.model.assembler.AlbumAssembler;
import br.com.tvalerio.exercise.service.AlbumService;
import br.com.tvalerio.exercise.service.GenreService;

@Component
public class SpotifyIntegration {

    Logger logger = LoggerFactory.getLogger(SpotifyIntegration.class);

    @Value("${spotify.token.api}")
    private String tokenApi;

    @Value("${spotify.search.api}")
    private String searchApi;

    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.client.secret}")
    private String clientSecret;

    @Value("${spotify.client.grant.type}")
    private String grantType;

    @Autowired
    private GenreService genreService;

    @Autowired
    private AlbumService albumService;

    private SpotifyTokenAuthResponse spotifyTokenAuthResponse;

    private SpotifyAlbumResponse spotifyAlbumResponse;

    public void loadData() {
        try {

            String token = getAuthorizationToken();

            List<GenreEntity> genres = genreService.getAllGenres();

            if (!genres.isEmpty() && !token.isEmpty()) {
                genres.forEach(genre -> {
                    SpotifyAlbumResponse albuns = getFirstFiftyAlbunsByGenre(
                            genre, token);
                    albumService.saveAllAlbums(new AlbumAssembler()
                            .fromSpotifyAlbumToAlbumEntity(albuns, genre));
                });
            }
        } catch (Exception e) {
            logger.info("Error loading data from Spotify integration.");
            logger.info(e.getMessage());
            logger.debug(e.getStackTrace().toString());
        }
    }

    private SpotifyAlbumResponse getFirstFiftyAlbunsByGenre(GenreEntity genre,
            String token) {

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        queryParams.add("q", genre.getName());
        queryParams.add("type", "album");
        queryParams.add("market", "BR");
        queryParams.add("limit", "50");

        spotifyAlbumResponse = makeHttpRequest(MediaType.APPLICATION_JSON,
                searchApi, queryParams, SpotifyAlbumResponse.class,
                HttpMethod.GET, token).getBody();

        return spotifyAlbumResponse;
    }

    private String getAuthorizationToken() {
        try {

            MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
            queryParams.add("grant_type", grantType);
            queryParams.add("client_id", clientId);
            queryParams.add("client_secret", clientSecret);
            spotifyTokenAuthResponse = makeHttpRequest(
                    MediaType.APPLICATION_FORM_URLENCODED, tokenApi,
                    queryParams, SpotifyTokenAuthResponse.class,
                    HttpMethod.POST, null).getBody();

        } catch (Exception e) {
            logger.info(
                    "Error trying to get authorization token from Spotify.");
            logger.info(e.getMessage());
            logger.debug(e.getStackTrace().toString());
        }

        return spotifyTokenAuthResponse.getAccessToken();
    }

    private <clazz> ResponseEntity<clazz> makeHttpRequest(MediaType mediaType,
            String url, MultiValueMap<String, String> queryParams,
            Class<clazz> clazz, HttpMethod httpMethod, String token) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);

        if (token != null && !token.isEmpty()) {
            headers.setBearerAuth(token);
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(queryParams);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<clazz> response = restTemplate
                .exchange(builder.toUriString(), httpMethod, entity, clazz);
        return response;
    }
}
