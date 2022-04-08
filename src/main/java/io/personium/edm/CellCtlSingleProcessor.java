package io.personium.edm;

import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;

public class CellCtlSingleProcessor extends ODataSingleProcessor {
    
    @Override
    public ODataResponse readEntity(GetEntityUriInfo uriInfo, String contentType) throws ODataException {
      // TODO Auto-generated method stub
      return super.readEntity(uriInfo, contentType);
    }
}
