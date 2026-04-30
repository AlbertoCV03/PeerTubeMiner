
package aiss.peertubeminer.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "uuid",
        "createdAt",
        "publishedAt",
        "originallyPublishedAt",
        "truncatedDescription",
        "name",
        "comments",
        "account"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("originallyPublishedAt")
    private String originallyPublishedAt;
    @JsonProperty("truncatedDescription")
    private String truncatedDescription;
    @JsonProperty("name")
    private String name;
    @JsonProperty("comments")
    private Integer comments;
    @JsonProperty("account")
    private Account user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getOriginallyPublishedAt() {
        return originallyPublishedAt;
    }

    public void setOriginallyPublishedAt(String originallyPublishedAt) {
        this.originallyPublishedAt = originallyPublishedAt;
    }

    public String getTruncatedDescription() {
        return truncatedDescription;
    }

    public void setTruncatedDescription(String truncatedDescription) {
        this.truncatedDescription = truncatedDescription;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", originallyPublishedAt='" + originallyPublishedAt + '\'' +
                ", truncatedDescription='" + truncatedDescription + '\'' +
                ", name='" + name + '\'' +
                ", comments=" + comments +
                '}';
    }
}
