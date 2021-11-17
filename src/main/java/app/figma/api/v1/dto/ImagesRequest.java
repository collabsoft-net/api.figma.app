package app.figma.api.v1.dto;

import lombok.Builder;
import lombok.Getter;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.List;

@Getter
@Builder
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class ImagesRequest {
    private List<String> ids;
    private Double scale;
    private ImagesFormat format;
    private Boolean svg_include_id;
    private Boolean svg_simplify_stroke;
    private Boolean use_absolute_bounds;
    private String version;
}
