package org.apache.olingo.odata2.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.Association;
import org.apache.olingo.odata2.api.edm.provider.AssociationSet;
import org.apache.olingo.odata2.api.edm.provider.ComplexType;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.edm.provider.EntityContainer;
import org.apache.olingo.odata2.api.edm.provider.EntitySet;
import org.apache.olingo.odata2.api.edm.provider.EntityType;
import org.apache.olingo.odata2.api.edm.provider.Property;
import org.apache.olingo.odata2.api.edm.provider.Schema;
import org.apache.olingo.odata2.api.exception.ODataException;

public class MyEdmProvider extends EdmProvider {
    static final String ENTITY_SET_NAME_MANUFACTURERS = "Manufacturers";
    static final String ENTITY_SET_NAME_CARS = "Cars";
    static final String ENTITY_NAME_MANUFACTURER = "Manufacturer";
    static final String ENTITY_NAME_CAR = "Car";

    private static final String NAMESPACE = "org.apache.olingo.odata2.ODataCars";
    private static final FullQualifiedName ENTITY_TYPE_1_1 = new FullQualifiedName(NAMESPACE, ENTITY_NAME_CAR);
    private static final FullQualifiedName ENTITY_TYPE_1_2 = new FullQualifiedName(NAMESPACE, ENTITY_NAME_MANUFACTURER);

    private static final FullQualifiedName COMPLEX_TYPE = new FullQualifiedName(NAMESPACE, "Address");
    private static final FullQualifiedName ASSOCIATION_CAR_MANUFACTURER = new FullQualifiedName(NAMESPACE,
            "Car_Manufacturer_Manufacturer_Cars");

    private static final String ROLE_1_1 = "Car_Manufacturer";
    private static final String ROLE_1_2 = "Manufacturer_Cars";

    private static final String ENTITY_CONTAINER = "ODataCarsEntityContainer";
    private static final String ASSOCIATION_SET = "Cars_Manufacturers";

    public List<Schema> getSchemas() throws ODataException {
        var schemas = new ArrayList<Schema>();

        Schema schema = new Schema();
        schema.setNamespace(NAMESPACE);

        List<EntityType> entityTypes = new ArrayList<EntityType>();
        entityTypes.add(getEntityType(ENTITY_TYPE_1_1));
        entityTypes.add(getEntityType(ENTITY_TYPE_1_2));
        schema.setEntityTypes(entityTypes);

        List<ComplexType> complexTypes = new ArrayList<ComplexType>();
        complexTypes.add(getComplexType(COMPLEX_TYPE));
        schema.setComplexTypes(complexTypes);

        List<Association> associations = new ArrayList<Association>();
        associations.add(getAssociation(ASSOCIATION_CAR_MANUFACTURER));
        schema.setAssociations(associations);

        List<EntityContainer> entityContainers = new ArrayList<EntityContainer>();
        EntityContainer entityContainer = new EntityContainer();
        entityContainer.setName(ENTITY_CONTAINER).setDefaultEntityContainer(true);

        List<EntitySet> entitySets = new ArrayList<EntitySet>();
        entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_CARS));
        entitySets.add(getEntitySet(ENTITY_CONTAINER, ENTITY_SET_NAME_MANUFACTURERS));
        entityContainer.setEntitySets(entitySets);

        List<AssociationSet> associationSets = new ArrayList<AssociationSet>();
        associationSets.add(getAssociationSet(ENTITY_CONTAINER, ASSOCIATION_CAR_MANUFACTURER,
                ENTITY_SET_NAME_MANUFACTURERS, ROLE_1_2));
        entityContainer.setAssociationSets(associationSets);

        entityContainers.add(entityContainer);
        schema.setEntityContainers(entityContainers);

        schemas.add(schema);

        return schemas;
    }
}
