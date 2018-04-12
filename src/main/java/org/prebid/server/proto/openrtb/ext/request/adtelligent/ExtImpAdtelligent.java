package org.prebid.server.proto.openrtb.ext.request.adtelligent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Defines the contract for bidrequest.imp[i].ext.adtelligent
 */
@AllArgsConstructor(staticName = "of")
@Value
public class ExtImpAdtelligent {

    /**
     * Defines the contract for bidrequest.imp[i].ext.adtelligent.aid
     */
    @JsonProperty("aid")
    Integer sourceId;

    /**
     * Defines the contract for bidrequest.imp[i].ext.adtelligent.placementId
     */
    @JsonProperty("placementId")
    Integer placementId;

    /**
     * Defines the contract for bidrequest.imp[i].ext.adtelligent.siteId
     */
    @JsonProperty("siteId")
    Integer siteId;

    /**
     * Defines the contract for bidrequest.imp[i].ext.adtelligent.bigFloor
     */
    @JsonProperty("bigFloor")
    Float bigFloor;
}