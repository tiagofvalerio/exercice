package br.com.tvalerio.exercise;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tvalerio.exercise.utils.Utils;

@RunWith(SpringRunner.class)
public class UtilsTest {

    @MockBean
    private Utils utils;

    @Test
    public void shouldGetDayOfWeek() throws Exception {

        Mockito.when(utils.getDayOfWeek()).thenReturn(
                LocalDate.of(2019, 02, 25).getDayOfWeek().name().toUpperCase());

        assertThat(utils.getDayOfWeek(), is("MONDAY"));
    }
}
