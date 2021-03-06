package org.prebid.server.proto.openrtb.ext.request;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Defines the contract for bidrequest.ext
 */
@AllArgsConstructor(staticName = "of")
@Value
public class ExtBidRequest {

    /**
     * Defines the contract for bidrequest.ext.prebid
     */
    ExtRequestPrebid prebid;
}
