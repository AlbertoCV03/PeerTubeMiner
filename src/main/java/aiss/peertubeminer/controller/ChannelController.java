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

    @PostMapping("/{id}")
    public ChannelDTO getChannel(@PathVariable String id){
        return channelService.findChannelDTOByName(id);
    }

}
