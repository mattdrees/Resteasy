package org.jboss.resteasy.client.jaxrs.internal;

import javax.ws.rs.RuntimeType;

import org.jboss.resteasy.core.providerfactory.ClientHelper;
import org.jboss.resteasy.core.providerfactory.NOOPServerHelper;
import org.jboss.resteasy.core.providerfactory.ResteasyProviderFactoryImpl;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * A version of ResteasyProviderFactory which does not reference its parent
 * after it is created. Used for client framework Configurables.
 *
 * @author <a href="mailto:ron.sigal@jboss.com">Ron Sigal</a>
 * <p>
 * Date April 27, 2016
 */
public class LocalResteasyProviderFactory extends ResteasyProviderFactoryImpl
{

   public LocalResteasyProviderFactory()
   {
      super(null, true);
   }

   public LocalResteasyProviderFactory(final ResteasyProviderFactory factory)
   {
      super(factory, true);
   }

   @Override
   public RuntimeType getRuntimeType()
   {
      return RuntimeType.CLIENT;
   }

   @Override
   protected void initializeUtils()
   {
      clientHelper = new ClientHelper(this);
      serverHelper = NOOPServerHelper.INSTANCE;
   }
}
