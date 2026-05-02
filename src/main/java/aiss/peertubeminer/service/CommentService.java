package aiss.peertubeminer.service;

import aiss.peertubeminer.model.DTO.CommentDTO;
import aiss.peertubeminer.model.peertube.commentmodels.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    private static final String BASE_URI="https://peertube.tv/api/v1/videos/";

    public Comments findAllComments(String id){
        Comments comments=restTemplate.getForObject(BASE_URI+id+"/comment-threads", Comments.class);
        return comments;
    }

    public CommentDTO[] findAllCommentsDTO(String id){

        Comments comments=findAllComments(id);
        List<CommentDTO> commentDTOS=new ArrayList<>();
        for(Integer i=0;i<comments.getData().size();i++){
            CommentDTO commentDTO=new CommentDTO();
            commentDTO.setId(comments.getData().get(i).getId());
            commentDTO.setText(comments.getData().get(i).getText());
            commentDTO.setCreatedOn(comments.getData().get(i).getCreatedAt());
            commentDTOS.add(commentDTO);

        }
        return commentDTOS.toArray(new CommentDTO[0]);
    }

}
