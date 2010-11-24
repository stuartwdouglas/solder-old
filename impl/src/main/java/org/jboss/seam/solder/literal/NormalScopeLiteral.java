/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.solder.literal;

import javax.enterprise.context.NormalScope;
import javax.enterprise.util.AnnotationLiteral;


public class NormalScopeLiteral extends AnnotationLiteral<NormalScope> implements NormalScope
{

   private static final long serialVersionUID = -7952939796914825978L;

   private final boolean passivating;

   private NormalScopeLiteral(boolean passivating)
   {
      this.passivating = passivating;
   }

   public boolean passivating()
   {
      return passivating;
   }

   public final static NormalScope PASSIVATING_INSTANCE = new NormalScopeLiteral(true);

   public final static NormalScope NON_PASSIVATING_INSTANCE = new NormalScopeLiteral(false);
}
