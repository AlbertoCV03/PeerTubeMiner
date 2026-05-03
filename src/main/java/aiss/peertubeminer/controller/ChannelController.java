package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peertube")
public class ChannelController {
    @Autowired
    ChannelService channelService;


    @GetMapping("/{id}")
    public ChannelDTO getChannel(@PathVariable String id,@RequestParam(defaultValue = "10") Integer maxVideos,@RequestParam(defaultValue = "2") Integer maxComments){
        return channelService.findChannelDTOByName(id,maxVideos,maxComments);
    }

    @PostMapping("/{id}")
    public void postChannel(@PathVariable String id,@RequestParam(defaultValue = "10") Integer maxVideos,@RequestParam(defaultValue = "2") Integer maxComments) {
        channelService.postChannelDTOByName(id, maxVideos, maxComments);
    }
}
