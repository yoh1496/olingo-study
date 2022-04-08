package io.personium;

import javax.annotation.Resource;
import javax.ws.rs.Path;

@Path("/")
public class PersoniumCellResource {

    @Path("__ctl")
    public Class<CellCtlResource> ctl() {
        return CellCtlResource.class;
    }
    
}
