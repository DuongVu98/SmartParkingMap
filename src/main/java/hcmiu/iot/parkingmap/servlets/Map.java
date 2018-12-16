package hcmiu.iot.parkingmap.servlets;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmiu.iot.parkingmap.beans.Place;
import hcmiu.iot.parkingmap.dao.PlacesDAO;
import hcmiu.iot.parkingmap.utils.MyUtils;



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
		ServletOutputStream out = response.getOutputStream();
		out.println(pList.toString());
		System.out.println(pList.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
