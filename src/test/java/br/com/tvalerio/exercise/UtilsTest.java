package br.com.tvalerio.exercise;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

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
    public void shouldGetDayOfWeekMock() throws Exception {

        Mockito.when(utils.getDayOfWeek()).thenReturn(
                LocalDate.of(2019, 02, 25).getDayOfWeek().name().toUpperCase());

        assertThat(utils.getDayOfWeek(), is("MONDAY"));
    }

    @Test
    public void shouldGetDayOfWeek() throws Exception {
        Utils u = new Utils();
        assertThat(u.getDayOfWeek(), notNullValue());
    }
}
