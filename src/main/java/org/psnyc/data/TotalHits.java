package org.psnyc.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mk on 8/13/14.
 */
public class TotalHits {
    private long count;

    public TotalHits() {
    }

    public TotalHits(long count) {
        this.count = count;
    }

    @JsonProperty
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
