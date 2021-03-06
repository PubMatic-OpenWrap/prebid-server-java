package org.prebid.server.proto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class BidderInfo {

    boolean enabled;

    MaintainerInfo maintainer;

    CapabilitiesInfo capabilities;

    List<String> vendors;

    GdprInfo gdpr;

    public static BidderInfo create(boolean enabled, String maintainerEmail, List<String> appMediaTypes,
                                    List<String> siteMediaTypes, List<String> supportedVendors,
                                    int vendorId, boolean enforceGdpr) {
        final MaintainerInfo maintainer = new MaintainerInfo(maintainerEmail);
        final CapabilitiesInfo capabilities = new CapabilitiesInfo(platformInfo(appMediaTypes),
                platformInfo(siteMediaTypes));
        final GdprInfo gdpr = new GdprInfo(vendorId, enforceGdpr);

        return new BidderInfo(enabled, maintainer, capabilities, supportedVendors, gdpr);
    }

    private static PlatformInfo platformInfo(List<String> mediaTypes) {
        return mediaTypes != null ? new PlatformInfo(mediaTypes) : null;
    }

    @Value
    private static class MaintainerInfo {

        String email;
    }

    @Value
    private static class PlatformInfo {

        @JsonProperty("mediaTypes")
        List<String> mediaTypes;
    }

    @Value
    private static class CapabilitiesInfo {

        PlatformInfo app;

        PlatformInfo site;
    }

    @Value
    public static class GdprInfo {

        /**
         * GDPR Vendor ID in the IAB Global Vendor List which refers to this Bidder.
         * <p>
         * The Global Vendor list can be found here: https://vendorlist.consensu.org/vendorlist.json
         * Bidders can register for the list here: https://register.consensu.org/
         * <p>
         * If you're not on the list, this should return 0. If cookie sync requests have GDPR consent info,
         * or the Prebid Server host company configures its deploy to be "cautious" when no GDPR info exists
         * in the request, it will _not_ sync user IDs with you.
         */
        @JsonProperty("vendorId")
        int vendorId;

        /**
         * Flag, which true value means that PBS will keep gdpr logic for bidder, otherwise bidder will keep
         * gdpr support and request should be sent without gdpr changes.
         */
        boolean enforced;
    }
}
