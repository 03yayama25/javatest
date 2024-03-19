package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicines;
import model.Medicines_timing;


@WebServlet("/Medicines")
public class MedicinesServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

    	
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
     		request.setCharacterEncoding("UTF-8");
     		String name = request.getParameter("name");
     		String type = request.getParameter("type");
     		int medicines_id = Integer.parseInt(request.getParameter("medisines_id"));
     		String timing = request.getParameter("timing");
        
        
     		// データベースに新規登録情報を保存
     		Connection connection = null;
     		PreparedStatement preparedStatement = null;
     		
     		
     		try {
    			// バリデーション: name、type、timing が null の場合は登録を拒否
    			if (name == "" || type == "" || timing == "") {
    				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "未入力があります。");
    				return;
    			}
    		

        
       

        
        
        
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    }
}
