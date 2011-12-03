/**
 * 
 */
package pl.com.bottega.erp.sales.presentation.listeners;

import java.util.Date;

import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.com.bottega.ddd.infrastructure.events.EventListener;
import pl.com.bottega.ddd.infrastructure.events.EventListeners;
import pl.com.bottega.erp.sales.application.events.ProductAddedToOrderEvent;
import pl.com.bottega.erp.sales.presentation.model.OrderedProduct;

/**
 * Sample of updating presentation model when event occurs
 * 
 * @author Slawek
 *
 */
@EventListeners
@Named
public class ProductEventsListener {

	@PersistenceContext(unitName="defaultPU")
	private EntityManager entityManager;
	
	@EventListener(asynchronous=true)
	public void handle(ProductAddedToOrderEvent event){
		entityManager.persist(new OrderedProduct(event.getProductid(), event.getClientId(), event.getQuantity(), new Date()));
	}
}
