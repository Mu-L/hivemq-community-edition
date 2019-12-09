/*
 * Copyright 2019 dc-square GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hivemq.extension.sdk.api.services.intializer;

import com.hivemq.extension.sdk.api.annotations.DoNotImplement;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.client.ClientContext;
import com.hivemq.extension.sdk.api.client.parameter.InitializerInput;

/**
 * @author Christoph Schäbel
 * @author Florian Limpöck
 * @since 4.0.0
 */
@DoNotImplement
public interface InitializerRegistry {

    /**
     * Each connecting and connected MQTT client will be initialized by this initializer, as soon as the extension is
     * enabled and running.
     * <p>
     * When the extension stops, its context will be removed from every client.
     * <p>
     * The {@link ClientInitializer} and its {@link ClientInitializer#initialize(InitializerInput, ClientContext)}
     * method must be implemented by the extension developer.
     * If there is already an initializer present, it will be overwritten.
     *
     * @param initializer The initializer to set.
     * @throws NullPointerException If the initializer is null.
     * @since 4.0.0
     */
    void setClientInitializer(@NotNull ClientInitializer initializer);
}
