package com.epam.reportportal.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Version {

    private String version;

    // TODO should we support right view of version ?
    // TODO create VersionValidator
    //private String major;
    //private String minor;
    //private String snapshot;

    private Documentation documentation;
    //TODO test changes

}
