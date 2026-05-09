package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.CommentDTO;
import aiss.peertubeminer.model.peertube.commentmodels.Comments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService commentService;
    @Test
    @DisplayName("List comments")
    void findAllComments() {
        Comments comments=commentService.findAllComments("110914", 10);
        System.out.println(comments);
    }
    @DisplayName("List commentDTOs")
    @Test
    void findAllCommentsDTO() {
        CommentDTO[] commentDTOs=commentService.findAllCommentsDTO("110914", 10);
        System.out.println(List.of(commentDTOs));
    }
}