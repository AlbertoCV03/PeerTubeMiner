    package aiss.peertubeminer.service;

    import aiss.peertubeminer.model.DTO.VideosDTO;
    import aiss.peertubeminer.model.Datum;
    import aiss.peertubeminer.model.UserDTO;
    import aiss.peertubeminer.model.Videos;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    import javax.xml.crypto.Data;
    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class VideoService {

        @Autowired
        RestTemplate restTemplate;

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
                videoDTO.setDescription(videolist.get(i).getTruncatedDescription());
                videoDTO.setReleaseTime(videolist.get(i).getCreatedAt());
                UserDTO userDTO=new UserDTO();
                userDTO.setId(videolist.get(i).getUser().getId());
                userDTO.setName(videolist.get(i).getUser().getName());
                userDTO.setUser_link(videolist.get(i).getUser().getUrl());
                userDTO.setPicture_link(videolist.get(i).getUser().getAvatars());
                videoDTO.setUser(userDTO);
                videosDTO.add(videoDTO);
            }
            VideosDTO[] res=videosDTO.toArray(new VideosDTO[0]);
            return res;

        }
    }
