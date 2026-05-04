package aiss.peertubeminer.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "createdAt",
        "user",
        "caption",
        "comment"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideosDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createdAt")
    private String releaseTime;
    @JsonProperty("user")
    private UserDTO userDTO;
    @JsonProperty("captions")
    private CaptionDTO[] captionDTO;
    @JsonProperty("comments")
    private CommentDTO[] commentDTO;

    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonProperty("createdAt")
    public String getReleaseTime() {
        return releaseTime;
    }
    @JsonProperty("createdAt")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    @JsonProperty("user")
    public UserDTO getUser() {
        return userDTO;
    }
    @JsonProperty("user")
    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    @JsonProperty("captions")
    public CaptionDTO[] getCaptionDTO() {
        return captionDTO;
    }
    @JsonProperty("captions")
    public void setCaptionDTO(CaptionDTO[] captionDTO) {
        this.captionDTO = captionDTO;
    }
    @JsonProperty("comments")
    public CommentDTO[] getCommentDTO() {
        return commentDTO;
    }
    @JsonProperty("comments")
    public void setCommentDTO(CommentDTO[] commentDTO) {
        this.commentDTO = commentDTO;
    }

    @Override
    public String toString() {
        return "VideosDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description.replaceAll("\\R","") + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", user=" + userDTO +
                ", captionDTO=" + Arrays.stream(captionDTO).toList() +
                ", commentDTO=" + Arrays.toString(commentDTO) +
                '}'+"\n";
    }
}
