package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.CaptionDTO;
import aiss.peertubeminer.model.peertube.captionmodels.Captions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI= "https://peertube.tv/api/v1/videos/";

    public Captions getAllCaptionsFromVideo(String id){

        Captions captions=restTemplate.getForObject(BASE_URI+id+"/captions", Captions.class);
        return captions;
    }

    public CaptionDTO[] getAllCaptionsDTO(String id){

        Captions captions=getAllCaptionsFromVideo(id);
        List<CaptionDTO> captionDTOs=new ArrayList<>();

        for(Integer i=0;i<captions.getData().size();i++){
            CaptionDTO captionDTO=new CaptionDTO();
            captionDTO.setId(UUID.randomUUID().toString());
            captionDTO.setLink(captions.getData().get(i).getFileUrl());
            captionDTO.setLanguage(captions.getData().get(i).getLanguage().getLabel());
            captionDTOs.add(captionDTO);

        }
        return captionDTOs.toArray(new CaptionDTO[0]);

    }
}
