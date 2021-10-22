package com.prosegur.sol.servicebilling.view.mapper;

import com.prosegur.rest.mapper.configuration.DefaultRequestMapperConfig;
import com.prosegur.sol.servicebilling.view.data.model.*;
import com.prosegur.sol.servicebilling.view.search.resource.response.model.WorkOrderResponse;
import com.prosegur.sol.utils.dateutils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Date;

@Mapper(componentModel = "spring", config = DefaultRequestMapperConfig.class)
@RequiredArgsConstructor
public abstract class WorkOrderMapper {
    ENUMMapper enumMapper = Mappers.getMapper(ENUMMapper.class);

    @Mapping(target = "centerStopId", source = "centerStop.id")
    @Mapping(target = "servicePointStopId", source = "servicePointStop.id")
    @Mapping(target = "servicePointCode", source = "servicePoint.code")
    @Mapping(target = "branchCode", source = "delegation.uniqueCode")
    @Mapping(target = "workOrderType", source = "workOrderType.description")
    @Mapping(target = "servicePointStopStartTime", source = "servicePointStop.stopStartDatetime")
    @Mapping(target = "servicePointStopEndTime", source = "servicePointStop.stopEndDatetime")
    @Mapping(target = "centerStopStartTime", source = "centerStop.stopStartDatetime")
    @Mapping(target = "centerStopEndTime", source = "centerStop.stopEndDatetime")
    abstract WorkOrderResponse mapWorkOrder(WorkOrder workOrder);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vehiclePlate", source = "vehicle.vehiclePlate")
    abstract void addRouteInfo(@MappingTarget WorkOrderResponse workOrder, Route route);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nonPerformingCode", defaultValue = "")
    @Mapping(target = "nonPerformingDescription", defaultValue = "")
    @Mapping(target = "isNonPerformingBillable", defaultValue = "")
    abstract void addNonPerformingInfo(@MappingTarget WorkOrderResponse workOrder, NonPerforming nonPerforming);

    @AfterMapping
    void map(@MappingTarget final WorkOrderResponse workOrder, final WorkOrder wo) {
        WorkOrderMapper.setDayType(workOrder, wo);
        this.addNonPerformingInfo(workOrder, wo.getNonPerforming());
        this.addRouteInfo(workOrder, wo.getRoute());
        workOrder.setOperationalStopType(ENUMMapper.mapEnumStopType(wo.getOperationalStopType()));
    }

    private static void setDayType(@MappingTarget final WorkOrderResponse workOrder, final WorkOrder wo) {
        if (wo == null || wo.getRoute() == null || wo.getRoute().getRouteDate() == null) {
            return;
        }
        final Date routeDate = DateUtil.localDateToDate(wo.getRoute().getRouteDate());

        final Address address = wo.getAddress();
        boolean holiday = false;
        if (address != null) {
            final City city = address.getCity();
            if (city != null) {
                final Province province = city.getProvince();
                if (province != null) {
                    final Country country = province.getCountry();
                    if (country != null) {
                        holiday = DateUtil.isHoliday(city.getId(), province.getId(), country.getId(), routeDate, true);
                    }
                }
            }
        }
        workOrder.setDayType(holiday ? "1" : "0");
    }
}