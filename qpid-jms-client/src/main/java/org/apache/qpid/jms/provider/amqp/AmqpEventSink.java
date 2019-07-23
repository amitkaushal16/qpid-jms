/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.qpid.jms.provider.amqp;

import org.apache.qpid.jms.provider.ProviderException;
import org.apache.qpid.proton.engine.Delivery;

/**
 * Interface used by classes that want to process AMQP events sent from
 * the transport layer.
 */
public interface AmqpEventSink {

    /**
     * Event handler for remote peer open of this resource.
     *
     * @param provider
     *        the AmqpProvider instance for easier access to fire events.
     *
     * @throws ProviderException if an error occurs while processing the update.
     */
    void processRemoteOpen(AmqpProvider provider) throws ProviderException;

    /**
     * Event handler for remote peer detach of this resource.
     *
     * @param provider
     *        the AmqpProvider instance for easier access to fire events.
     *
     * @throws ProviderException if an error occurs while processing the update.
     */
    void processRemoteDetach(AmqpProvider provider) throws ProviderException;

    /**
     * Event handler for remote peer close of this resource.
     *
     * @param provider
     *        the AmqpProvider instance for easier access to fire events.
     *
     * @throws ProviderException if an error occurs while processing the update.
     */
    void processRemoteClose(AmqpProvider provider) throws ProviderException;

    /**
     * Called when the Proton Engine signals an Delivery related event has been triggered
     * for the given endpoint.
     *
     * @param provider
     *        the AmqpProvider instance for easier access to fire events.
     * @param delivery
     *        the Delivery that has an update to its state which needs handled.
     *
     * @throws ProviderException if an error occurs while processing the update.
     */
    void processDeliveryUpdates(AmqpProvider provider, Delivery delivery) throws ProviderException;

    /**
     * Called when the Proton Engine signals an Flow related event has been triggered
     * for the given endpoint.
     *
     * @param provider
     *        the AmqpProvider instance for easier access to fire events.
     *
     * @throws ProviderException if an error occurs while processing the update.
     */
    void processFlowUpdates(AmqpProvider provider) throws ProviderException;

}
