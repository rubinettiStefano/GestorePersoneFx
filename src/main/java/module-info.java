module com.generation.gestorepersonefx {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;


	opens com.generation.gestorepersonefx to javafx.fxml;
	exports com.generation.gestorepersonefx;
	exports com.generation.gestorepersonefx.controller;
	opens com.generation.gestorepersonefx.controller to javafx.fxml;
}