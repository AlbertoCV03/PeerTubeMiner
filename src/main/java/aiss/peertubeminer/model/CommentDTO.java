package aiss.peertubeminer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.criteria.CriteriaBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "text",
        "createdOn"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("createdOn")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}
