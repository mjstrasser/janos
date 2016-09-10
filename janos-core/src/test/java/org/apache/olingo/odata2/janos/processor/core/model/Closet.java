/*
 * Copyright 2013 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.olingo.odata2.janos.processor.core.model;

import org.apache.olingo.odata2.api.annotation.edm.EdmConcurrencyControl;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFacets;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@EdmEntityType(name = "Closet", namespace = ModelSharedConstants.NAMESPACE_1)
@EdmEntitySet(name = "Closets")
public class Closet extends RefBase {

  @EdmProperty
  private int floorLevel;

  @EdmNavigationProperty(name = "nc_Building", association = "ClosetBuilding")
  private Building building;

  public Closet() {
    this(0, null);
  }

  public Closet(final int id, final String name) {
    super(id, name);
  }

  public int getFloorLevel() {
    return floorLevel;
  }

  public void setFloorLevel(int floorLevel) {
    this.floorLevel = floorLevel;
  }

  public Building getBuilding() {
    return building;
  }

  public void setBuilding(Building building) {
    this.building = building;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(final Object obj) {
    return this == obj
        || obj != null && getClass() == obj.getClass() && id == ((Closet) obj).id;
  }

  @Override
  public String toString() {
    return "{\"Id\":\"" + id + "\",\"Name\":\"" + name + "\",\"FloorLevel\":" + floorLevel + "}";
  }
}
