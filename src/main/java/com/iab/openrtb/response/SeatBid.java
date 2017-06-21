package com.iab.openrtb.response;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * A bid response can contain multiple {@link SeatBid} objects, each on behalf
 * of a different bidder seat and each containing one or more individual bids.
 * If multiple impressions are presented in the request, the {@code group}
 * attribute can be used to specify if a seat is willing to accept any
 * impressions that it can win (default) or if it is only interested in winning
 * any if it can win them all as a group.
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class SeatBid {

    /**
     * Array of 1+ Bid objects (Section 4.2.3) each related to an impression.
     * Multiple bids can relate to the same impression.
     * (required)
     */
    List<Bid> bid = Collections.emptyList();

    /**
     * ID of the buyer seat (e.g., advertiser, agency) on whose behalf this bid
     * is made.
     */
    String seat;

    /**
     * 0 = impressions can be won individually; 1 = impressions must be won or
     * lost as a group.
     */
    int group;

    /** Placeholder for bidder-specific extensions to OpenRTB. */
    ObjectNode ext;
}