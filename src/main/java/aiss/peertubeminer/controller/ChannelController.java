package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
            summary = "Retrieve a channel by its channel id",
            description = "Get a channelDTO object by specifying its channel id")
    @GetMapping("/{channelId}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "List of channels",
                    content = { @Content(schema = @Schema(implementation = ChannelDTO.class),
                            mediaType = "application/json") }),
            @ApiResponse(
                    responseCode = "404",
                    description="Channel not found",
                    content = { @Content(schema = @Schema()) })})
    @ResponseStatus(HttpStatus.OK)
    public ChannelDTO getChannel(
            @Parameter(description = "Name of channel to be searched")@PathVariable String channelId,
            @Parameter(description = "Maximum number of videos to be searched")@RequestParam(defaultValue = "10") Integer maxVideos,
            @Parameter(description = "Maximum number of comments per video to be searched")@RequestParam(defaultValue = "2") Integer maxComments)
            throws InterruptedException {
        return channelService.findChannelDTOByName(channelId,maxVideos,maxComments);
    }
    @Operation(
            summary = "Save a channel by its channel id",
            description = "Post a channelDTO object to VideoMiner by specifying its channel id")
    @PostMapping("/{channelId}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Channel successfully created",
                    content = { @Content(schema = @Schema(implementation = ChannelDTO.class),
                            mediaType = "application/json") }),
            @ApiResponse(
                    responseCode = "500",
                    description="The sent channel object  was incorrectly formed. Usually caused by a non existing channel name",
                    content = { @Content(schema = @Schema()) })})
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDTO postChannel(
            @Parameter(description = "Name of channel to be created")@PathVariable String channelId,
            @Parameter(description = "Maximum number of videos to be included")@RequestParam(defaultValue = "10") Integer maxVideos,
            @Parameter(description = "Maximum number of comments per video to be included")@RequestParam(defaultValue = "2") Integer maxComments)
            throws InterruptedException {
        ChannelDTO channelDTO= channelService.postChannelDTOByName(channelId, maxVideos, maxComments);
        return channelDTO;
    }
}
