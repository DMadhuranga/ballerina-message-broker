/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.broker.amqp.codec.frames;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.broker.amqp.codec.AmqpConnectionHandler;

/**
 * AMQP frame for basic.qos.
 * Parameter Summary:
 *     No parameters
 */
public class BasicQosOk extends MethodFrame {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicQosOk.class);

    public BasicQosOk(int channel) {
        super(channel, (short) 60, (short) 11);
    }

    @Override
    protected long getMethodBodySize() {
        return 0L;
    }

    @Override
    protected void writeMethod(ByteBuf buf) {
    }

    @Override
    public void handle(ChannelHandlerContext ctx, AmqpConnectionHandler connectionHandler) {
        // Server does not handle Qos frame
    }

    public static AmqMethodBodyFactory getFactory() {
        return (buf, channel, size) -> new BasicQosOk(channel);
    }
}
