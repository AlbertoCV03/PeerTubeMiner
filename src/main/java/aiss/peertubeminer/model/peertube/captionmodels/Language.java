
package aiss.peertubeminer.model.peertube.captionmodels;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "label"
})
@Generated("jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {

    @JsonProperty("label")
    private String label;

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Language{" +
                "label='" + label + '\'' +
                '}';
    }
}
