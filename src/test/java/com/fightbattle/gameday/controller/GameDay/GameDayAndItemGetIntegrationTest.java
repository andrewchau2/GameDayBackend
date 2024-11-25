package com.fightbattle.gameday.controller.GameDay;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayAndItemGetIntegrationTest {
    @Test
    public void testThatGetGameSetItemReturnBadRequest(){

    }


    @Test
    public void testThatGetGameSetItemReturnOkRequest(){

    }

    @Test
    public void testThatGetGameSetItemSuccessfullyAddedToRecentlyPlayed(){

    }

    @Test
    public void testThatGetGameSetItemSuccessfullyAddedToWishlist(){

    }
}