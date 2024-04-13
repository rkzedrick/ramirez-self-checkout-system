module com.customer.self.checkout.sys.selfcheckoutsys {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.customer.self.checkout.sys to javafx.fxml;
    opens com.customer.self.checkout.sys.controllers.main to javafx.fxml;
    opens com.customer.self.checkout.sys.controllers.list to javafx.fxml;


    exports com.customer.self.checkout.sys;
    exports com.customer.self.checkout.sys.controllers.main;
    exports com.customer.self.checkout.sys.controllers.list;
}