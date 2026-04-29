package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.VideosDTO;
import aiss.peertubeminer.model.Videos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("List Videos")
    void findAllVideosOfChannelName(){
        Videos videos= service.findAllVideosOfChannelName("she_drives_mobility@tube.tchncs.de");
        System.out.println(videos);
    }

     @Test
    @DisplayName("List VideosDTO")
    void findAllVideosDTOOfChannelName(){
        VideosDTO[] videosDTO=service.findAllVideosDTOOfChannelName("she_drives_mobility@tube.tchncs.de");
        System.out.println(List.of(videosDTO));
    }


}