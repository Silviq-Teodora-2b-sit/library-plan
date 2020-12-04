package com.libapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.libapp.TabelViews.searchUserTabel;
import com.libapp.controllersFunctions.CommonFunctions;
import com.libapp.controllersFunctions.CommonFunctionsImpl;
import com.libapp.service.HibernateUtil;
import com.libapp.service.Service;
import com.libapp.service.ServiceImpl;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchUserController {

   ObservableList<searchUserTabel> search = FXCollections.observableArrayList();
    @FXML
    private Label lb_register;

    @FXML
    private TextField userName;
    
    @FXML
    private TextField userId;

    @FXML
    private TextField registrationDate;

    @FXML
    private TextField userEmail;


    @FXML
    private TableView<searchUserTabel> tb_SearchUser;

    @FXML
    private TableColumn<searchUserTabel, Integer> search_id;

    @FXML
    private TableColumn<searchUserTabel, String> search_userName;

    @FXML
    private TableColumn<searchUserTabel, String> searchEmail;

    @FXML
    private TableColumn<searchUserTabel, String> search_Phone;

    @FXML
    private TableColumn<searchUserTabel, String> search_Password;

    @FXML
    private TableColumn<searchUserTabel, String> search_RegDate;

    @FXML
    private TableColumn<searchUserTabel, String> search_Role;

  /*  @FXML
    private TableColumn<searchUserTabel, String> search_Books;*/
    private Map<String, Object>queryMap=new HashMap<>();
    private CommonFunctions windowFunction;

    @FXML
    void SearchUser(ActionEvent event) {
    	windowFunction=new CommonFunctionsImpl();
    	init();
    	if(queryMap.size()==0)
    	{
    		windowFunction.alertForSearchUser("Fill at least one fild!");
    	}
    	else
    	{
    	Service<User> userService = new ServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
    	List<User> users=new ArrayList<>();
    	String criteriaString="";
    	int br=0;
    	for (String i : queryMap.keySet()) {
		    if(br==0)
		    {
		    	criteriaString=i+" LIKE '%' || :"+i+" || '%'";
		    	br++;
		    }
		    else {
				criteriaString=criteriaString+" and "+i+" LIKE '%' || :"+i+" || '%'";
			}
		   
    	}
    	users=userService.createQuery("from User where "+criteriaString, queryMap);
    	if(users.size()==0)
    	{
    		windowFunction.alertForSearchUser("No such user!");
    	}
    	putDataInTabel(users);
    	}
    }
    
    public void putDataInTabel(List<User> users) {
    	int i=0;
    	while(i<users.size())
    	{
    		Role role=new Role();
    		role=users.get(i).getUserRole();
    		if(SignInController.saveUser.getUserRole().getRoleName()=="operator" && role.getRoleName()=="admin" )
    		{
    			i++;
    		}
    		else 
    			{
			
    		search.add(new searchUserTabel(
    				new SimpleIntegerProperty(users.get(i).getUserId()),
    				new SimpleStringProperty(users.get(i).getUserName()),
    				new SimpleStringProperty(users.get(i).getUserEmail()),
    				new SimpleStringProperty(users.get(i).getUserPhone()),
    				new SimpleStringProperty(users.get(i).getUserPass()),
    				new SimpleStringProperty(role.getRoleName()),
    				new SimpleStringProperty(users.get(i).getRegistrationDate().toString())
    				));
    			}
    		i++;
    	}
    	search_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
    	search_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
    	searchEmail.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
    	search_Phone.setCellValueFactory(new PropertyValueFactory<>("userPhone"));
    	search_Password.setCellValueFactory(new PropertyValueFactory<>("userPass"));
    	search_RegDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
    	search_Role.setCellValueFactory(new PropertyValueFactory<>("userRole"));
    	//search_Books.setCellValueFactory(new PropertyValueFactory<>("userBooks"));
    	tb_SearchUser.setItems(search);
    	
    }

    public void init() {
    	queryMap=new HashMap<>();
    	if(!userId.getText().trim().isEmpty())
    	{
    		queryMap.put("userId", userId.getText());
    	}
    	if(!userName.getText().trim().isEmpty())
    	{
    		queryMap.put("userName", userName.getText());
    	}
    	if(!userEmail.getText().trim().isEmpty())
    	{
    		queryMap.put("userEmail", userEmail.getText());
    	}
    	if(!registrationDate.getText().trim().isEmpty())
    	{
    		queryMap.put("registrationDate", registrationDate.getText());
    	}
    	userId.clear();
    	userEmail.clear();
    	userName.clear();
    	registrationDate.clear();
    	//return queryMap;
    }


}
