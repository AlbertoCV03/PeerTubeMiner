package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.DTO.ChannelDTO;
import aiss.peertubeminer.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Channel",description = "Channel operations")
@Validated
@RestController
@RequestMapping("/peertube/v1")
public class ChannelController {
    @Autowired
    ChannelService channelService;

    @Operation(
            summary = "Retrieve a PeerTube channel",
            description = "Returns a channel along with videos, comments and captions")
    @GetMapping("/{channelId}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "List of PeerTube channels",
                    content = { @Content(
                            schema = @Schema(implementation = ChannelDTO.class),
                            mediaType = "application/json",
                            examples =@ExampleObject(
                                    name = "Channel example",
                                    summary = "Successful response",
                                    description = "This example provides the representation of a valid response",
                                    value= """
                                            {
                                                "id": "80",
                                                "name": "tv",
                                                "description": "canal de videos random",
                                                "createdTime": "2023-01-01T23:36:17.306Z",
                                                "videos": [
                                                    {
                                                        "id": "21856",
                                                        "name": "Alien: Isolation live on iOS - 1/9/2023, 10:17:06 PM",
                                                        "description": "HOW WILL YOU SURVIVE? Discover the true meaning of fear in Alien: Isolation, a survival horror set in an atmosphere of constant dread and mortal danger.",
                                                        "releaseTime": "2023-01-09T22:32:41.126Z",
                                                        "comments": [{
                                                                "id": "3955",
                                                                "text": "Funniest video I've ever seen",
                                                                "createdOn": "2023-01-03T23:45:40.196Z"
                                                            }],
                                                        "captions": [
                                                            {
                                                                "id": "1",
                                                                "link": "/lazy-static/video-captions/68efe0a2-8ed8-4a6d-831a-ab8f5fc8f7fc-cy.vtt",
                                                                "language": "Spanish"
                                                            }
                                                        ],
                                                        "user": {
                                                            "name": "stux",
                                                            "user_link": "https://peertube.tv/accounts/stux",
                                                            "picture_link": "https://peertube.tv/lazy-static/avatars/f8463b3f-2e2e-4f36-8bd3-fa9c0ef4f463.png"
                                                        }
                                                    }
                                                ]
                                            }
                                            """
                            ))}),
            @ApiResponse(
                    responseCode = "404",
                    description="❌ **Channel not found**",
                    content = { @Content(schema = @Schema()) })})
    @ResponseStatus(HttpStatus.OK)
    public ChannelDTO getChannel(
            @Parameter(description = "Name id of the channel to be searched",example = "transport_evolved_take_2@peertube.tv")@PathVariable String channelId,
            @Parameter(description = "Maximum number of videos to be searched")@Min(1) @Max(100)@RequestParam(defaultValue = "10") Integer maxVideos,
            @Parameter(description = "Maximum number of comments per video to be searched")@Min(1) @Max(100)@RequestParam(defaultValue = "2") Integer maxComments)
            throws InterruptedException {
        return channelService.findChannelDTOByName(channelId,maxVideos,maxComments);
    }
    @Operation(
            summary = "Retrieve and send a PeerTube channel",
            description = "This operation stores a PeerTube channel on the VideoMiner  DB")
    @PostMapping("/{channelId}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Channel successfully created",
                    content = { @Content(schema = @Schema(implementation = ChannelDTO.class),
                            mediaType = "application/json") }),
            @ApiResponse(
                    responseCode = "404",
                    description="❌ **Channel not found**",
                    content = { @Content(schema = @Schema()) }),
            @ApiResponse(
                    responseCode = "500",
                    description="❌ **Internal server error**",
                    content = { @Content(schema = @Schema()) })
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDTO postChannel(
            @Parameter(description = "Name of channel to be created", required = true)@PathVariable String channelId,
            @Parameter(description = "Maximum number of videos to be included")@Min(1) @Max(100)@RequestParam(defaultValue = "10") Integer maxVideos,
            @Parameter(description = "Maximum number of comments per video to be included")@Min(1) @Max(100)@RequestParam(defaultValue = "2") Integer maxComments)
            throws InterruptedException {
        ChannelDTO channelDTO= channelService.postChannelDTOByName(channelId, maxVideos, maxComments);
        return channelDTO;
    }
}
