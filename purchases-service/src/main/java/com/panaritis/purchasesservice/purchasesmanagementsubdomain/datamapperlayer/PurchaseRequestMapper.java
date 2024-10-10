package com.panaritis.purchasesservice.purchasesmanagementsubdomain.datamapperlayer;




import com.panaritis.purchasesservice.purchasesmanagementsubdomain.datalayer.*;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.furniture.FurnitureModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.customers.CustomerModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.domainclientlayer.deliveries.DeliveryModel;
import com.panaritis.purchasesservice.purchasesmanagementsubdomain.presentationlayer.PurchaseRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {
    @Mapping(target = "id", ignore = true)
    Purchase requestModelToEntity(PurchaseRequestModel purchaseRequestModel,
                                  PurchaseIdentifier purchaseIdentifier,
                                  CustomerModel customerModel,
                                  DeliveryModel deliveryModel,
                                  FurnitureModel furnitureModel);



}
