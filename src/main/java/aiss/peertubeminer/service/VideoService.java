    package aiss.peertubeminer.service;

    import aiss.peertubeminer.model.DTO.CommentDTO;
    import aiss.peertubeminer.model.DTO.CaptionDTO;
    import aiss.peertubeminer.model.DTO.VideosDTO;
    import aiss.peertubeminer.model.peertube.videomodels.Datum;
    import aiss.peertubeminer.model.DTO.UserDTO;
    import aiss.peertubeminer.model.peertube.videomodels.Videos;
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

        public Videos findAllVideosOfChannelName(String name,Integer maxVideos){
            //maxVideos=(maxVideos!=null)?maxVideos:10;
            String count="?count="+maxVideos;
            Videos videos= restTemplate.getForObject(BASE_URI+"/"+name+"/videos"+count,Videos.class);
            return videos;
        }
        /*public Videos findAllVideosOfChannelName(String name){
            return findAllVideosOfChannelName(name,10);
        }*/

        public VideosDTO[] findAllVideosDTOOfChannelName(String name,Integer maxVideos,Integer maxComments) throws InterruptedException {
            /*maxVideos=(maxVideos!=null)?maxVideos:10;
            maxComments=(maxComments!=null)?maxComments:2;*/

            Videos video= findAllVideosOfChannelName(name,maxVideos);
            List<Datum> videolist=video.getData();
            List<VideosDTO> videosDTO=new ArrayList<>();
            for(Integer i=0;i<videolist.size();i++){
                Thread.sleep(100);
                VideosDTO videoDTO=new VideosDTO();
                videoDTO.setId(videolist.get(i).getId());
                videoDTO.setName(videolist.get(i).getName());
                videoDTO.setDescription(videolist.get(i).getDescription());
                videoDTO.setReleaseTime(videolist.get(i).getCreatedAt());

                createUsersDTO(videoDTO, videolist);
                videosDTO.add(videoDTO);

                Thread.sleep(100);
                CaptionDTO[] captionDTO=captionService.getAllCaptionsDTO(videolist.get(i).getId());
                videoDTO.setCaptionDTO(captionDTO);
                Thread.sleep(100);
                CommentDTO[] commentDTO= commentService.findAllCommentsDTO(videolist.get(i).getId(),maxComments);
                videoDTO.setCommentDTO(commentDTO);



                videosDTO.add(videoDTO);





            }
            VideosDTO[] res=videosDTO.toArray(new VideosDTO[0]);
            return res;

        }
        private static void createUsersDTO(VideosDTO videoDTO,List<Datum> videoList){

            for(Integer i=0;i<videoList.size();i++){
                UserDTO userDTO=new UserDTO();
                userDTO.setId(null);
                userDTO.setName(videoList.get(i).getAccount().getName());
                userDTO.setUser_link(videoList.get(i).getAccount().getUrl());
                Integer picture_link_index=videoList.get(i).getAccount().getAvatars().size() -1;
                String picture_link= videoList.get(i).getAccount().getAvatars().get(picture_link_index).getFileUrl();
                userDTO.setPicture_link(picture_link);
                videoDTO.setUser(userDTO);
            }

        }

        /*public VideosDTO[] findAllVideosDTOOfChannelName(String name){
            return findAllVideosDTOOfChannelName(name,10,2);
        }*/

    }
