module com.studentmanagementsystem.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.studentmanagementsystem.studentmanagementsystem to javafx.fxml;
    exports com.studentmanagementsystem.studentmanagementsystem;
}