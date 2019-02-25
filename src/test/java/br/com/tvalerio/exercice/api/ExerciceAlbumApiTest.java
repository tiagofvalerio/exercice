package br.com.tvalerio.exercice.api;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.tvalerio.exercice.ExerciceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExerciceApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ExerciceAlbumApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql({ "/datasources/should_find_album_by_id.sql" })
    public void shouldFindAlbumById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/albums/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfTracks",
                        is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artistName",
                        is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(50.00)))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.genre", is("ROCK")));
    }

    @Test
    public void shouldNotFindAlbumById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/albums/10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @Sql({ "/datasources/should_find_albums_by_filter.sql" })
    public void shouldFindAlbumsByFilter() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/albums")
                        .param("genre", "rock").param("page", "0")
                        .param("size", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id",
                        is(1)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].numberOfTracks", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].artistName", is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].price",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].genre",
                        is("ROCK")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].id",
                        is(2)));
    }

    @Test
    public void shouldNotFindAlbumsByFilter() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/albums").param("genre",
                        "pop"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content",
                        hasSize(0)));
    }
}
