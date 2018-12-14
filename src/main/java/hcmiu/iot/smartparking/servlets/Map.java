package hcmiu.iot.smartparking.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmiu.iot.smartparking.beans.Place;
import hcmiu.iot.smartparking.dao.PlacesDAO;
import hcmiu.iot.smartparking.utils.MyUtils;

public class Map extends HttpServlet{
	private static final long serialVersionUID=1L;
	private ArrayList<Place> pList=null;
	PlacesDAO pdao=new PlacesDAO();
	
	public Map() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pList=pdao.getAllPlaces(MyUtils.getStoredConnection(request));
		request.setAttribute("placesList", pList);
//		RequestDispatcher rd=null;
//		rd=request.getRequestDispatcher("/map.jsp");
//		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
