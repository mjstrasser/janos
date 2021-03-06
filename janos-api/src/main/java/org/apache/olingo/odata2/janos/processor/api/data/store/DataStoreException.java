/*
 * Copyright 2014 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.olingo.odata2.janos.processor.api.data.store;

import org.apache.olingo.odata2.api.exception.ODataApplicationException;

import java.util.Locale;

/**
 * The type Data store exception.
 */
public class DataStoreException extends ODataApplicationException {

  private static final long serialVersionUID = 42L;

  /**
   * Instantiates a new Data store exception.
   *
   * @param message the message
   */
  public DataStoreException(final String message) {
    this(message, null);
  }

  /**
   * Instantiates a new Data store exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public DataStoreException(final String message, final Throwable cause) {
    super(message, Locale.ENGLISH, cause);
  }
}
