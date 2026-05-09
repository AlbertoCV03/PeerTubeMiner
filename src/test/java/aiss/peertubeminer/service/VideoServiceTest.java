package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.VideosDTO;
import aiss.peertubeminer.model.peertube.videomodels.Videos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("List Videos")
    void findAllVideosOfChannelName(){
        Videos videos= service.findAllVideosOfChannelName("she_drives_mobility@tube.tchncs.de",10);
        System.out.println(videos);
    }

     @Test
    @DisplayName("List VideosDTO")
    void findAllVideosDTOOfChannelName() throws InterruptedException {
        VideosDTO[] videosDTO=service.findAllVideosDTOOfChannelName("she_drives_mobility@tube.tchncs.de",10,2);
        System.out.println(List.of(videosDTO));
    }


}