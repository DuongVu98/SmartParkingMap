package hcmiu.iot.parkingmap.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hcmiu.iot.parkingmap.beans.Place;
import hcmiu.iot.parkingmap.dao.PlacesDAO;
import hcmiu.iot.parkingmap.utils.MyUtils;
import hcmiu.iot.parkingmap.utils.PlacesUtils;


public class Map extends HttpServlet{
	private static final long serialVersionUID=1L;
	private ArrayList<Place> pList=null;
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("jdbc-beans.xml");
//	PlacesDAO pdao=new PlacesDAO();
	PlacesUtils pdao = context.getBean("placesDAO",PlacesUtils.class);
	
	public Map() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pList=(ArrayList<Place>)pdao.getAllPlaces(MyUtils.getStoredConnection(request));
		request.setAttribute("placesList", pList);
		ServletOutputStream out = response.getOutputStream();
		out.println(pList.toString());
		System.out.println(pList.toString());
//		RequestDispatcher rd=null;
//		rd=request.getRequestDispatcher("/map.jsp");
//		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
