package app.figma.api.v1.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Getter
@Builder
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class FileRequest {
    private String version;
    private List<String> ids;
    private Integer depth;
    private String geometry;
}
