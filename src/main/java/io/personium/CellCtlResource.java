package io.personium;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.rest.ODataRootLocator;

@Path("/")
public class CellCtlResource extends ODataRootLocator {

    private CellCtlODataServiceFactory serviceFactory;

    @Inject
    public CellCtlResource(CellCtlODataServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public ODataServiceFactory getServiceFactory() {
        return this.serviceFactory;
    }
}
