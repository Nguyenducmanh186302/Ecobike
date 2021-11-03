module Ecobike {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;
    requires java.naming;

    opens view.viewMuonXe;
    opens controller;
}