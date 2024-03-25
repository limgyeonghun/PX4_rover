/*
 * Copyright (C) 2015-2018 Swift Navigation Inc.
 * Contact: Swift Navigation <dev@swiftnav.com>
 *
 * This source is subject to the license found in the file 'LICENSE' which must
 * be be distributed together with this source. All other rights reserved.
 *
 * THIS CODE AND INFORMATION IS PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.swiftnav.sbp.logging;

import java.math.BigInteger;

import com.swiftnav.sbp.SBPMessage;
import com.swiftnav.sbp.SBPBinaryException;
import com.swiftnav.sbp.SBPStruct;

import org.json.JSONObject;
import org.json.JSONArray;


/** SBP class for message MSG_TWEET (0x0012).
 *
 * You can have MSG_TWEET inherent its fields directly from
 * an inherited SBP object, or construct it inline using a dict of its
 * fields.
 *
* All the news fit to tweet. */

public class MsgTweet extends SBPMessage {
    public static final int TYPE = 0x0012;

    
    /** Human-readable string */
    public String tweet;
    

    public MsgTweet (int sender) { super(sender, TYPE); }
    public MsgTweet () { super(TYPE); }
    public MsgTweet (SBPMessage msg) throws SBPBinaryException {
        super(msg);
        assert msg.type != TYPE;
    }

    @Override
    protected void parse(Parser parser) throws SBPBinaryException {
        /* Parse fields from binary */
        tweet = parser.getString(140);
    }

    @Override
    protected void build(Builder builder) {
        builder.putString(tweet, 140);
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = super.toJSON();
        obj.put("tweet", tweet);
        return obj;
    }
}