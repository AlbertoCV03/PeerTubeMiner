package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Channel",description = "Channel operations")
@RestController
@RequestMapping("/peertube/v1")
public class ChannelController {
    @Autowired
    ChannelService channelService;

    @Operation(
            summary = "Retrieve a channel by id",
            description = "Get a channelDTO object by specifying its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChannelDTO getChannel(@Parameter(description = "Id of channel to be searched")@PathVariable String id, @Parameter(description = "Maximum number of videos to be searched")@RequestParam(defaultValue = "10") Integer maxVideos, @RequestParam(defaultValue = "2") Integer maxComments) throws InterruptedException {
        return channelService.findChannelDTOByName(id,maxVideos,maxComments);
    }
    @Operation(
            summary = "Save a channel by id",
            description = "Post a channelDTO object to VideoMiner by specifying its id")
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDTO postChannel(@PathVariable String id,@RequestParam(defaultValue = "10") Integer maxVideos,@RequestParam(defaultValue = "2") Integer maxComments) throws InterruptedException {
        ChannelDTO channelDTO= channelService.postChannelDTOByName(id, maxVideos, maxComments);
        return channelDTO;
    }
}
