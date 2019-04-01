package main;

import com.procourier.model.Address;
import com.procourier.model.Buyer;
import com.procourier.model.Courier;
import com.procourier.model.Order;
import com.procourier.model.OrderLine;
import com.procourier.model.Product;
import com.procourier.model.Seller;
import service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();
        OrderService orderService = OrderService.getInstance();

        Product phone = new Product(1000L, "Huawei P30", "New phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "Old laptop ", 1700L);

        Product smartTV = new Product(2000L, "Samsung QLED", "Expensive TV", 10500L);
        Product smartWatch = new Product(500L, "Apple Watch 4", "Not much different from 3", 100L);


        Address emagAddress =
                new Address("Bucuresti", "Bucuresti", "Soseaua Virtutii", "20A");

        Address evomagAddress =
                new Address("Bucuresti", "Bucuresti", "Splaiul Independentei", "144");

        Address johnAddress = new Address("Dolj", "Craiova", "Ecaterina Teodoroiu", "11");
        Address jimAddress = new Address("Bucuresti", "Bucuresti", "Academiei", "14");

        Address proCourierAddress = new Address("Timis", "Timisoara", "AI Cuza", "86");

        Buyer john = new Buyer("John", johnAddress);
        Buyer jim = new Buyer("Jim", jimAddress);

        Seller emag = new Seller("Emag", emagAddress);
        Seller evomag = new Seller("EvoMag", evomagAddress);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        OrderLine olSmartTV = new OrderLine(smartTV, 1L);
        OrderLine olSmartWatch = new OrderLine(smartWatch, 1L);

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(olPhone);
        orderLines.add(olLaptop);

        List<OrderLine> orderLineList = new ArrayList<>();
        orderLineList.add(olSmartTV);
        orderLineList.add(olSmartWatch);


        Courier courier =
                new Courier("ProCourier", proCourierAddress, 9L, 13L);
        Order order = new Order(emag, john, courier, orderLines );
        Order order2 = new Order(evomag, jim, courier, orderLineList);


        orderService.addOrder(order);
        orderService.addOrder(order2);
        System.out.println("Order delivered successfully");

    }
}
