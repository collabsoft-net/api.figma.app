package app.figma.api.v1.dto;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressFBWarnings("EI_EXPOSE_REP")
public class Canvas extends Node implements withChildren {
    @JsonDeserialize(using = NodeDeserializer.class)
    private Node[] children;
}