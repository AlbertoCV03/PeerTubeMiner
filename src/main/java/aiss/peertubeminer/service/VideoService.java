    package aiss.peertubeminer.service;

    import aiss.peertubeminer.model.CommentDTO;
    import aiss.peertubeminer.model.DTO.CaptionDTO;
    import aiss.peertubeminer.model.DTO.VideosDTO;
    import aiss.peertubeminer.model.videomodels.Datum;
    import aiss.peertubeminer.model.DTO.UserDTO;
    import aiss.peertubeminer.model.videomodels.Videos;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class VideoService {

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        CaptionService captionService;

        @Autowired
        CommentService commentService;

        private static final String BASE_URI= "https://peertube.tv/api/v1/video-channels";

        public Videos findAllVideosOfChannelName(String name){

            Videos videos= restTemplate.getForObject(BASE_URI+"/"+name+"/videos",Videos.class);
            return videos;
        }

        public VideosDTO[] findAllVideosDTOOfChannelName(String name){
            Videos video= findAllVideosOfChannelName(name);
            List<Datum> videolist=video.getData();
            List<VideosDTO> videosDTO=new ArrayList<>();
            for(Integer i=0;i<videolist.size();i++){
                VideosDTO videoDTO=new VideosDTO();
                videoDTO.setId(videolist.get(i).getUuid());
                videoDTO.setName(videolist.get(i).getName());
                videoDTO.setDescription(videolist.get(i).getDescription());
                videoDTO.setReleaseTime(videolist.get(i).getCreatedAt());

                UserDTO userDTO=new UserDTO();
                userDTO.setId(videolist.get(i).getUser().getId());
                userDTO.setName(videolist.get(i).getUser().getName());
                userDTO.setUser_link(videolist.get(i).getUser().getUrl());
                Integer picture_link_index=videolist.get(i).getUser().getAvatars().size() -1;
                String picture_link= videolist.get(i).getUser().getAvatars().get(picture_link_index).getFileUrl();
                userDTO.setPicture_link(picture_link);
                videoDTO.setUser(userDTO);

                CaptionDTO[] captionDTO=captionService.getAllCaptionsDTO(videolist.get(i).getUuid());
                videoDTO.setCaptionDTO(captionDTO);

                CommentDTO[] commentDTO= commentService.findAllCommentsDTO(videolist.get(i).getUuid());
                videoDTO.setCommentDTO(commentDTO);

                videosDTO.add(videoDTO);





            }
            VideosDTO[] res=videosDTO.toArray(new VideosDTO[0]);
            return res;

        }
    }
