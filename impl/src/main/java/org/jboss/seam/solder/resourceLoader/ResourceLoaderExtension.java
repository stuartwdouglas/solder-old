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
package org.jboss.seam.solder.resourceLoader;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

/**
 * <p>
 * CDI portable extension responsible for setting up the resource loader.
 * </p>
 * 
 * @author Stuart Douglas
 * 
 */
public class ResourceLoaderExtension implements Extension
{
   
   void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event, BeanManager manager)
   {
      event.addAnnotatedType(manager.createAnnotatedType(ResourceProvider.class));
      event.addAnnotatedType(manager.createAnnotatedType(ResourceProducer.class));
      event.addAnnotatedType(manager.createAnnotatedType(ResourceLoaderManager.class));
   }
   
}
