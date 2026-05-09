package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.CaptionDTO;
import aiss.peertubeminer.model.DTO.CommentDTO;
import aiss.peertubeminer.model.peertube.captionmodels.Captions;
import aiss.peertubeminer.model.peertube.commentmodels.Comments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CaptionServiceTest {
    @Autowired
    CaptionService captionService;
    @Test
    @DisplayName("List captions")
    void getAllCaptionsFromVideo() {
        Captions captions=captionService.getAllCaptionsFromVideo("119345");
        System.out.println(captions);
    }

    @Test
    @DisplayName("List captionDTOs")
    void getAllCaptionsDTO() {
        CaptionDTO[] captionDTOs=captionService.getAllCaptionsDTO("119345");
        System.out.println(List.of(captionDTOs));
    }
}