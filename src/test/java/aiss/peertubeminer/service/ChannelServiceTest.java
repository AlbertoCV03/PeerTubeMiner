package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.model.peertube.channelmodels.Channel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    @Test
    @DisplayName("Get a channelDTO")
    void findChannelDTOByName() throws InterruptedException {
        ChannelDTO channelDTO=service.findChannelDTOByName("she_drives_mobility@tube.tchncs.de",10,2);
        System.out.println(channelDTO);

    }

}