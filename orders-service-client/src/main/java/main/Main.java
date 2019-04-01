package main;

import com.procourier.model.Order;
import http.GetOrderByIdClient;
import http.GetOrderListClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GetOrderListClient client = new GetOrderListClient();
        GetOrderByIdClient clientId = new GetOrderByIdClient();

        List<Order> orders = client.getOrders();
        Order ord = clientId.getOrder(2L);
        System.out.println("List: ");
        for(var order : orders) {
            System.out.println(order);
        }
        System.out.println("Id: ");
        System.out.println(ord);
    }
}
