package com.prosegur.sol.servicebilling.view.data.repository;

import com.prosegur.sol.servicebilling.view.data.model.QWorkOrder;
import com.prosegur.sol.servicebilling.view.data.model.WorkOrder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class WorkOrderRepository extends QuerydslRepositorySupport {

    private static final QWorkOrder workOrder = QWorkOrder.workOrder;

    public WorkOrderRepository() {
        super(WorkOrder.class);
    }

    public long countCenterStopService(final String routeId, final String centerStopId) {
        final JPQLQuery<WorkOrder> query = this.from(workOrder)
                .distinct()
                .innerJoin(workOrder.centerStop)
                .innerJoin(workOrder.servicePoint.center)
                .where(workOrder.route.id.eq(routeId).and(workOrder.centerStop.id.eq(centerStopId)));
        return query.fetchCount();
    }

    public long countServicePointStopService(final String routeId, final String servicePointStopId) {
        final JPQLQuery<WorkOrder> query = this.from(workOrder)
                .distinct()
                .innerJoin(workOrder.servicePoint)
                .innerJoin(workOrder.servicePointStop)
                .where(workOrder.route.id.eq(routeId).and(workOrder.servicePointStop.id.eq(servicePointStopId)));
        return query.fetchCount();
    }
}
