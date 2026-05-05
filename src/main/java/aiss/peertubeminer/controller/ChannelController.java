package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peertube/v1")
public class ChannelController {
    @Autowired
    ChannelService channelService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChannelDTO getChannel(@PathVariable String id,@RequestParam(defaultValue = "10") Integer maxVideos,@RequestParam(defaultValue = "2") Integer maxComments) throws InterruptedException {
        return channelService.findChannelDTOByName(id,maxVideos,maxComments);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDTO postChannel(@PathVariable String id,@RequestParam(defaultValue = "10") Integer maxVideos,@RequestParam(defaultValue = "2") Integer maxComments) throws InterruptedException {
        ChannelDTO channelDTO= channelService.postChannelDTOByName(id, maxVideos, maxComments);
        return channelDTO;
    }
}
