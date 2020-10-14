package app.figma.api.v1.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FileRequest {
    private String version;
    private List<String> ids;
    private Integer depth;
    private String geometry;
}
