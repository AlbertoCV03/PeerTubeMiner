package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.VideosDTO;
import aiss.peertubeminer.model.peertube.channelmodels.Channel;
import aiss.peertubeminer.model.DTO.ChannelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VideoService service;

    private static final String BASE_URI= "https://peertube.tv/api/v1/video-channels";

    public Channel findChannelById(String id){

        Channel channel=restTemplate.getForObject(BASE_URI+"/"+id, Channel.class);

        return channel;

    }

    public ChannelDTO findChannelDTOByName(String name,Integer maxVideos,Integer maxComments){

        /*maxVideos=(maxVideos!=null)?maxVideos:10;
        maxComments=(maxComments!=null)?maxComments:2;*/
        Channel channel = restTemplate.getForObject(BASE_URI + "/" + name, Channel.class);
        VideosDTO[] videosDTO=service.findAllVideosDTOOfChannelName(name,maxVideos,maxComments);
        ChannelDTO dto = new ChannelDTO();
        dto.setId(channel.getId().toString());
        dto.setName(channel.getName());
        dto.setDescription(channel.getDescription());
        dto.setCreatedTime(channel.getCreatedAt());
        dto.setVideos(List.of(videosDTO));
        return dto;
    }

    public void postChannelDTOByName(String name,Integer maxVideos,Integer maxComments){
        ChannelDTO channelDTO=findChannelDTOByName(name, maxVideos, maxComments);
        restTemplate.postForObject("http://localhost:8080/api/channels",channelDTO, Void.class);
    }

}
