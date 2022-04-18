package com.example.demo;

import com.example.demo.model.Lab4Main;
import com.example.demo.view.PointDTO;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;

public class HelloController {

    @FXML private TextField hField;
    @FXML private TextField bField;
    @FXML private TextField aField;
    @FXML private TextField eField;
    Lab4Main lab;
    Expression expression;

    public void initialize() {
        lab = new Lab4Main();
        xCol.setCellValueFactory(new PropertyValueFactory<>("xStr"));
        yCol.setCellValueFactory(new PropertyValueFactory<>("yStr"));
    }

    @FXML
    private TableView<PointDTO> table;
    @FXML
    private TableColumn<PointDTO, String> yCol;
    @FXML
    private TableColumn<PointDTO, String> xCol;

    public void fillTable() {
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());
        double h = Double.parseDouble(hField.getText());
        String expr = eField.getText();
        expression = new ExpressionBuilder(expr).variable("x").build();
        List<PointDTO> list = lab.tabulate(a, b, h, this::f).stream().map(p -> new PointDTO(p.getX(), p.getY())).toList();
        table.setItems(FXCollections.observableList(list));
    }

    public double f(double x) {
        expression.setVariable("x", x);
        return expression.evaluate();
    }
}