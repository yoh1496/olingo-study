package io.personium;

import org.apache.olingo.odata2.core.rest.ODataRootLocator;
import org.apache.olingo.odata2.core.rest.app.ODataApplication;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class PersoniumCoreApplication extends ResourceConfig {

    public PersoniumCoreApplication() {
        packages("io.personium");
        ODataApplication oDataApplication = new ODataApplication();
        oDataApplication.getClasses().forEach(c -> {
            if ( !ODataRootLocator.class.isAssignableFrom(c)) {
                register(c);
            }
        });

        register(PersoniumCellResource.class);

        register(new AbstractBinder() {
            @Override
            protected void configure() {
              bindAsContract(CellCtlODataServiceFactory.class);
            }
        });
        register(CellCtlODataServiceFactory.class);
    }
}
