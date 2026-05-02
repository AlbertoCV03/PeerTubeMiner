
package aiss.peertubeminer.model.peertube.usermodels;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fileUrl",
})
@Generated("jsonschema2pojo")
public class Avatar {

    @JsonProperty("fileUrl")
    private String fileUrl;


    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    @JsonProperty("fileUrl")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
