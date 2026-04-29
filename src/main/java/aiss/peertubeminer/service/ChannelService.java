package aiss.peertubeminer.service;

import aiss.peertubeminer.model.Channel;
import aiss.peertubeminer.model.DTO.ChannelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI= "https://peertube.tv/api/v1/video-channels";

    public Channel findChannelById(String id){

        Channel channel=restTemplate.getForObject(BASE_URI+"/"+id, Channel.class);

        return channel;

    }

    public ChannelDTO findChannelDTOByName(String name){

        Channel channel = restTemplate.getForObject(BASE_URI + "/" + name, Channel.class);

        ChannelDTO dto = new ChannelDTO();
        dto.setId(channel.getId());
        dto.setName(channel.getName());
        dto.setDescription(channel.getDescription());
        dto.setCreatedTime(channel.getCreatedAt());

        return dto;
    }
}
