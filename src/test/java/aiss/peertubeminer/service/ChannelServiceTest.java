package aiss.peertubeminer.service;

import aiss.peertubeminer.model.Channel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChannelServiceTest {
    @Autowired
    ChannelService service;
    @Test
    @DisplayName("Get a channel")
    void findChannelById(){
        Channel channel=service.findChannelById("she_drives_mobility@tube.tchncs.de");

        System.out.println(channel);

    }

}