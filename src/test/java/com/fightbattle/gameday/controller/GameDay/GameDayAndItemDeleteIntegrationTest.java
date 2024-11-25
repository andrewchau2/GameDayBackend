package com.fightbattle.gameday.controller.GameDay;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayAndItemDeleteIntegrationTest {
    @Test
    public void testThatDeleteGameSetItemReturnBadRequest(){

    }


    @Test
    public void testThatDeleteGameSetItemReturnOkRequest(){

    }

    @Test
    public void testThatDeleteGameSetItemSuccessfullyAddedToRecentlyPlayed(){

    }

    @Test
    public void testThatDeleteGameSetItemSuccessfullyAddedToWishlist(){

    }
}
