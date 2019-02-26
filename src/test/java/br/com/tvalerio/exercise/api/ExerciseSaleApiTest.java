package br.com.tvalerio.exercise.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;

import br.com.tvalerio.exercise.ExerciseApplication;
import br.com.tvalerio.exercise.api.request.SalePostRequest;
import br.com.tvalerio.exercise.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExerciseApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ExerciseSaleApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Utils utils;

    @Test
    @Sql({ "/datasources/should_find_sale_by_id.sql" })
    public void shouldFindSaleById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sales/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumQuantity",
                        is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.saleAmount",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cashBackAmount",
                        is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.tatalCashBackAmount", is(5.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.id", is(1)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.album.numberOfTracks", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.artistName",
                        is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.price",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.genre",
                        is("ROCK")));
    }

    @Test
    public void shouldNotFindSaleById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sales/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @Sql({ "/datasources/should_find_sales_by_filter.sql" })
    public void shouldFindSalesByFilter() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/sales")
                        .param("start-date",
                                LocalDate.of(2019, 02, 25)
                                        .format(DateTimeFormatter
                                                .ofPattern("yyyy-MM-dd")))
                        .param("end-date",
                                LocalDate.of(2019, 02, 25)
                                        .format(DateTimeFormatter
                                                .ofPattern("yyyy-MM-dd"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id",
                        is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[0].createdAt", is("2019-02-25T13:04:00")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].albumQuantity", is(1)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].saleAmount", is(50.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].cashBackAmount", is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[0].tatalCashBackAmount", is(5.00)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.content[1].id",
                        is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[1].createdAt", is("2019-02-25T13:03:00")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[1].albumQuantity", is(1)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[1].saleAmount", is(50.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[1].cashBackAmount", is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[1].tatalCashBackAmount", is(5.00)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.content[2].id",
                        is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[2].createdAt", is("2019-02-25T13:02:00")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[2].albumQuantity", is(3)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[2].saleAmount", is(112.80)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[2].cashBackAmount", is(3.70)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[2].tatalCashBackAmount", is(11.10)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.content[3].id",
                        is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[3].createdAt", is("2019-02-25T13:01:00")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[3].albumQuantity", is(2)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[3].saleAmount", is(80.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[3].cashBackAmount", is(4.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[3].tatalCashBackAmount", is(8.00)))

                .andExpect(MockMvcResultMatchers.jsonPath("$.content[4].id",
                        is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[4].createdAt", is("2019-02-25T13:00:00")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[4].albumQuantity", is(1)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[4].saleAmount", is(50.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.content[4].cashBackAmount", is(5.00)))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.content[4].tatalCashBackAmount", is(5.00)));
    }

    @Test
    public void shouldNotFindASalesByFilter() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/sales")
                        .param("start-date",
                                LocalDate.of(2018, 02, 01)
                                        .format(DateTimeFormatter
                                                .ofPattern("yyyy-MM-dd")))
                        .param("end-date",
                                LocalDate.of(2018, 02, 02)
                                        .format(DateTimeFormatter
                                                .ofPattern("yyyy-MM-dd"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content",
                        hasSize(0)));
    }

    @Test
    @Sql({ "/datasources/should_register_sale.sql" })
    public void shouldRegisterNewSaleOnMonday() throws Exception {
        Gson gson = new Gson();
        SalePostRequest request = new SalePostRequest();
        request.setId(1L);
        request.setQuantity(1);

        Mockito.when(utils.getDayOfWeek()).thenReturn(
                LocalDate.of(2019, 02, 25).getDayOfWeek().name().toUpperCase());

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumQuantity",
                        is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.saleAmount",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cashBackAmount",
                        is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.tatalCashBackAmount", is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.album.numberOfTracks", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.artistName",
                        is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.price",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.genre",
                        is("ROCK")));
    }

    @Test
    @Sql({ "/datasources/should_register_sale.sql" })
    public void shouldRegisterNewSaleOnSunday() throws Exception {
        Gson gson = new Gson();
        SalePostRequest request = new SalePostRequest();
        request.setId(1L);
        request.setQuantity(1);

        Mockito.when(utils.getDayOfWeek()).thenReturn(
                LocalDate.of(2019, 02, 24).getDayOfWeek().name().toUpperCase());

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumQuantity",
                        is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.saleAmount",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cashBackAmount",
                        is(20.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.tatalCashBackAmount", is(20.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.album.numberOfTracks", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.artistName",
                        is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.price",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.genre",
                        is("ROCK")));
    }

    @Test
    @Sql({ "/datasources/should_register_sale.sql" })
    public void shouldRegisterNewSaleWithTwoAlbumsOnMonday() throws Exception {
        Gson gson = new Gson();
        SalePostRequest request = new SalePostRequest();
        request.setId(1L);
        request.setQuantity(2);

        Mockito.when(utils.getDayOfWeek()).thenReturn(
                LocalDate.of(2019, 02, 25).getDayOfWeek().name().toUpperCase());

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumQuantity",
                        is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.saleAmount",
                        is(100.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cashBackAmount",
                        is(5.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.tatalCashBackAmount", is(10.00)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.album.numberOfTracks", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.name",
                        is("ALBUM TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.artistName",
                        is("ARTIST TEST")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.price",
                        is(50.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album.genre",
                        is("ROCK")));
    }

}
